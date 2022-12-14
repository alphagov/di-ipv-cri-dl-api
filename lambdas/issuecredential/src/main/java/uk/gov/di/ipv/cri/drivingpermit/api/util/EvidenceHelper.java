package uk.gov.di.ipv.cri.drivingpermit.api.util;

import uk.gov.di.ipv.cri.drivingpermit.api.domain.verifiablecredential.Evidence;
import uk.gov.di.ipv.cri.drivingpermit.api.domain.verifiablecredential.EvidenceType;
import uk.gov.di.ipv.cri.drivingpermit.library.domain.CheckDetails;
import uk.gov.di.ipv.cri.drivingpermit.library.persistence.item.DocumentCheckResultItem;

public class EvidenceHelper {

    private EvidenceHelper() {
        throw new IllegalStateException("Instantiation is not valid for this class.");
    }

    public static Evidence documentCheckResultItemToEvidence(
            DocumentCheckResultItem documentCheckResultItem) {
        Evidence evidence = new Evidence();
        evidence.setType(EvidenceType.IDENTITY_CHECK);
        evidence.setTxn(documentCheckResultItem.getTransactionId());

        evidence.setActivityHistoryScore(documentCheckResultItem.getActivityHistoryScore());
        evidence.setStrengthScore(documentCheckResultItem.getStrengthScore());
        evidence.setValidityScore(documentCheckResultItem.getValidityScore());

        CheckDetails checkDetails = new CheckDetails();
        checkDetails.setCheckMethod(documentCheckResultItem.getCheckMethod());
        checkDetails.setIdentityCheckPolicy(documentCheckResultItem.getIdentityCheckPolicy());
        checkDetails.setActivityFrom(documentCheckResultItem.getActivityFrom());

        evidence.setCi(documentCheckResultItem.getContraIndicators());

        if (null == evidence.getCi()) {
            evidence.setCheckDetails(checkDetails);
        } else {
            evidence.setFailedCheckDetails(checkDetails);
        }

        return evidence;
    }
}
