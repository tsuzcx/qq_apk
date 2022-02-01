package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.ThreadManager;
import kor;
import mqq.os.MqqHandler;

public class ReadInjoyAdSuperBgDrawable$1
  implements Runnable
{
  public ReadInjoyAdSuperBgDrawable$1(kor paramkor, Drawable paramDrawable, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    kor.a(this.this$0, kor.a(this.this$0, this.ct, this.val$w, this.val$h));
    if (kor.a(this.this$0) != null) {
      ThreadManager.getUIHandler().post(new ReadInjoyAdSuperBgDrawable.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyAdSuperBgDrawable.1
 * JD-Core Version:    0.7.0.1
 */