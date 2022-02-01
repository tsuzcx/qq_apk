package com.tencent.mobileqq.activity;

import acfp;
import android.widget.TextView;
import aqcl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import vfu;

class Leba$35$3
  implements Runnable
{
  Leba$35$3(Leba.35 param35, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (Leba.b(this.a.this$0) != null)
      {
        Leba.b(this.a.this$0).setVisibility(0);
        Leba.b(this.a.this$0).setText(this.Ri);
      }
      if (Leba.a(this.a.this$0) != null) {
        Leba.a(this.a.this$0).setVisibility(8);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.val$uin);
      if ((Leba.a(this.a.this$0) != null) && (Leba.a(this.a.this$0) != null)) {
        Leba.a(this.a.this$0).cR(localArrayList);
      }
      if (Leba.a(this.a.this$0) != null) {
        aqcl.s(Leba.a(this.a.this$0), acfp.m(2131707640));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Leba", 1, "updateQZoneRedFlag" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35.3
 * JD-Core Version:    0.7.0.1
 */