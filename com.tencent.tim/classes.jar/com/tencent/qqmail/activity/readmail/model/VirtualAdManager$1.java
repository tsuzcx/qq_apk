package com.tencent.qqmail.activity.readmail.model;

import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;

class VirtualAdManager$1
  implements QMCallback.ISuccessCallback
{
  VirtualAdManager$1(VirtualAdManager paramVirtualAdManager, String paramString, Popularize paramPopularize) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkResponse = paramQMNetworkResponse.getResponseString();
    StringBuilder localStringBuilder = new StringBuilder().append("preLoadVirtualAdsMailHtml succ, ").append(this.val$requestUrl).append(", ");
    if (paramQMNetworkResponse == null) {}
    for (paramQMNetworkRequest = null;; paramQMNetworkRequest = Integer.valueOf(paramQMNetworkResponse.length()))
    {
      QMLog.log(4, "VirtualAdManager", paramQMNetworkRequest);
      QMSharedPreferenceManager.getInstance().setPopularizeAD(this.val$commercialPopularize.getOpenUrl(), paramQMNetworkResponse);
      QMSharedPreferenceManager.getInstance().setPopularizeADLastUpdateTime(System.currentTimeMillis() + "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.model.VirtualAdManager.1
 * JD-Core Version:    0.7.0.1
 */