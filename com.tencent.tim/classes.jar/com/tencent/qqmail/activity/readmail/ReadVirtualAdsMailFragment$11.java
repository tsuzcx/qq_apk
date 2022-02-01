package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;

class ReadVirtualAdsMailFragment$11
  implements QMCallback.ISuccessCallback
{
  ReadVirtualAdsMailFragment$11(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkResponse = paramQMNetworkResponse.getResponseString();
    String str = ReadVirtualAdsMailFragment.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("loadContent succ, ").append(this.val$requestUrl).append(", ");
    if (paramQMNetworkResponse == null) {}
    for (paramQMNetworkRequest = null;; paramQMNetworkRequest = Integer.valueOf(paramQMNetworkResponse.length()))
    {
      QMLog.log(6, str, paramQMNetworkRequest);
      QMSharedPreferenceManager.getInstance().setPopularizeAD(ReadVirtualAdsMailFragment.access$100(this.this$0).getOpenUrl(), paramQMNetworkResponse);
      QMSharedPreferenceManager.getInstance().setPopularizeADLastUpdateTime(System.currentTimeMillis() + "");
      ReadVirtualAdsMailFragment.access$3100(this.this$0, new ReadVirtualAdsMailFragment.11.1(this, paramQMNetworkResponse));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.11
 * JD-Core Version:    0.7.0.1
 */