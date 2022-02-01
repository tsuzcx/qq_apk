package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import wlh;
import wll;

public class IntimateInfoView$12
  implements Runnable
{
  public IntimateInfoView$12(wll paramwll, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    Bitmap localBitmap = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.g.setBounds(0, 0, 750, 1272);
    this.g.draw(localCanvas);
    wll.a(this.this$0, new wlh(this.this$0.mActivity, this.this$0.mApp, wll.a(this.this$0), wll.a(this.this$0, this.this$0.mApp.getCurrentAccountUin()), wll.a(this.this$0, this.this$0.mFriendUin), localBitmap));
    ThreadManager.getUIHandler().post(new IntimateInfoView.12.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.12
 * JD-Core Version:    0.7.0.1
 */