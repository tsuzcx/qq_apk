package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import jzk;
import kku.a;
import klt;
import kns;
import mud;
import mud.a;
import mue;
import org.json.JSONObject;

public class VideoFeedsGameAdComManager$2$1
  implements Runnable
{
  VideoFeedsGameAdComManager$2$1(VideoFeedsGameAdComManager.2 param2, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.val$activity.isFinishing())
    {
      if ((mud.a(this.a.this$0) != null) && (mud.a(this.a.this$0).isShowing())) {
        mud.a(this.a.this$0).dismiss();
      }
      if (mud.a(this.a.this$0) != 2) {
        break label93;
      }
      if (mud.a(this.a.this$0) != null) {
        mud.a(this.a.this$0).dismiss();
      }
    }
    return;
    label93:
    mud.a(this.a.this$0, new kns(mud.a(this.a.this$0), 3));
    mud.a(this.a.this$0).a((List)this.b.first, (List)this.b.second, mud.a(this.a.this$0).WX, mud.a(this.a.this$0).akl, mud.a(this.a.this$0).akm, mud.a(this.a.this$0).sAppid, mud.a(this.a.this$0).akn);
    mud.a(this.a.this$0).ek(mud.a(this.a.this$0).wP);
    mud.a(this.a.this$0).i(mud.a(this.a.this$0));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("vid", mud.a(this.a.this$0));
    localObject = jzk.a(null, mud.a(this.a.this$0).mRowKey, mud.b(this.a.this$0), mud.a(this.a.this$0).Xk, mud.a(this.a.this$0).WX, (HashMap)localObject);
    mud.a(this.a.this$0).R((JSONObject)localObject);
    mud.a(this.a.this$0).mu(true);
    mud.a(this.a.this$0).a(this.a.this$0);
    mud.a(this.a.this$0).a(new mue(this));
    mud.a(this.a.this$0).show();
    jzk.a(new kku.a().a(mud.a(this.a.this$0)).a(jzk.aFj).b(jzk.aFO).c(jzk.aGb).d((JSONObject)localObject).a(mud.a(this.a.this$0)).e(klt.a(mud.a(this.a.this$0).wP, jzk.aFq)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2.1
 * JD-Core Version:    0.7.0.1
 */