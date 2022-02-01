package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import wog;
import woi;
import wop.a;

public class LottieAnimDirector$2$1
  implements Runnable
{
  public LottieAnimDirector$2$1(woi paramwoi, boolean paramBoolean) {}
  
  public void run()
  {
    if ((wog.b(this.a.this$0)) || (wog.a(this.a.this$0))) {}
    do
    {
      return;
      if (this.val$success)
      {
        QQAppInterface localQQAppInterface = wog.a(this.a.this$0);
        if (localQQAppInterface != null) {
          wog.a(this.a.this$0, localQQAppInterface);
        }
      }
    } while (this.a.a == null);
    this.a.a.yH(this.val$success);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.2.1
 * JD-Core Version:    0.7.0.1
 */