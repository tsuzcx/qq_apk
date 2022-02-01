package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.List;
import kjt;
import kkp;
import klt;
import mqq.os.MqqHandler;

public class AdDownloadProxy$1
  implements Runnable
{
  public AdDownloadProxy$1(kjt paramkjt) {}
  
  public void run()
  {
    if ((this.this$0.a.a != null) && (!TextUtils.isEmpty(this.this$0.a.a.packageName)) && (this.this$0.a.a.a != null))
    {
      Pair localPair = klt.a(this.this$0.a.a.packageName);
      if (((this.this$0.context instanceof Activity)) && (localPair.first != null) && (((List)localPair.first).size() > 0))
      {
        Activity localActivity = (Activity)this.this$0.context;
        localActivity.runOnUiThread(new AdDownloadProxy.1.1(this, localActivity, localPair));
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new AdDownloadProxy.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.AdDownloadProxy.1
 * JD-Core Version:    0.7.0.1
 */