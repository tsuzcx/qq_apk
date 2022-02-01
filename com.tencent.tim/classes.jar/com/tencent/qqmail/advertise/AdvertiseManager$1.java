package com.tencent.qqmail.advertise;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;

class AdvertiseManager$1
  implements QMCallback.ISuccessCallback
{
  AdvertiseManager$1(AdvertiseManager paramAdvertiseManager, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkResponse = paramQMNetworkResponse.getResponseString();
    StringBuilder localStringBuilder = new StringBuilder().append("updatePullDownHtml succ, ").append(this.val$modifyUrl).append(", ");
    if (paramQMNetworkResponse == null) {}
    for (paramQMNetworkRequest = null;; paramQMNetworkRequest = Integer.valueOf(paramQMNetworkResponse.length()))
    {
      QMLog.log(4, "AdvertiseManager", paramQMNetworkRequest);
      QMSharedPreferenceManager.getInstance().setPullDownADHtml(paramQMNetworkResponse);
      QMSharedPreferenceManager.getInstance().setPullDownADLastUpdateTime(System.currentTimeMillis() + "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.advertise.AdvertiseManager.1
 * JD-Core Version:    0.7.0.1
 */