package com.tencent.mobileqq.gamecenter.data;

import ahrx;
import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;

public class PadFaceManager$1
  implements Runnable
{
  public PadFaceManager$1(ahrx paramahrx) {}
  
  public void run()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.this$0)
      {
        ahrx.a(this.this$0, ahrx.a(this.this$0).getApp().getSharedPreferences("gamecenter_sp" + ahrx.a(this.this$0).getCurrentAccountUin(), 4));
        ahrx.a(this.this$0, ahrx.a(this.this$0).getLong("last_pad_face_request_time", 0L));
        ahrx localahrx2 = this.this$0;
        if (ahrx.a(this.this$0).getInt("pad_face_ad_enabled", 1) == 1)
        {
          ahrx.a(localahrx2, bool);
          ahrx.a(this.this$0, ahrx.a(this.this$0).getInt("last_id_pad_face_shown", 0));
          ahrx.b(this.this$0, ahrx.a(this.this$0).getLong("last_time_pad_face_shown", 0L));
          ahrx.c(this.this$0, ahrx.a(this.this$0).getInt("request_interval", 2) * 3600000L);
          ahrx.a(this.this$0, ahrx.a(this.this$0).getEntityManagerFactory().createEntityManager());
          ahrx.a(this.this$0);
          ahrx.b(this.this$0, true);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.PadFaceManager.1
 * JD-Core Version:    0.7.0.1
 */