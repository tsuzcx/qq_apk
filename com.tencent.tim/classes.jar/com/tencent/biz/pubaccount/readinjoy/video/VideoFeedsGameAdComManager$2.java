package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import jzk;
import kku.a;
import klt;
import mud;
import mud.a;

public class VideoFeedsGameAdComManager$2
  implements Runnable
{
  public VideoFeedsGameAdComManager$2(mud parammud) {}
  
  public void run()
  {
    if ((mud.a(this.this$0) != null) && (!TextUtils.isEmpty(mud.a(this.this$0).WX)) && (mud.a(this.this$0).Xm != null)) {}
    try
    {
      Object localObject = new HashMap();
      ((HashMap)localObject).put("vid", mud.a(this.this$0));
      jzk.a(new kku.a().a(mud.a(this.this$0)).a(jzk.aFj).b(jzk.aFO).c(jzk.aGb).a(mud.a(this.this$0)).d(jzk.a(null, mud.a(this.this$0).mRowKey, mud.b(this.this$0), mud.a(this.this$0).Xk, mud.a(this.this$0).WX, (HashMap)localObject)).e(klt.a(mud.a(this.this$0).wP, jzk.aFp)).a());
      localObject = klt.a(mud.a(this.this$0).WX);
      if (((mud.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
      {
        Activity localActivity = mud.a(this.this$0);
        localActivity.runOnUiThread(new VideoFeedsGameAdComManager.2.1(this, localActivity, (Pair)localObject));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(mud.access$900(), 2, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2
 * JD-Core Version:    0.7.0.1
 */