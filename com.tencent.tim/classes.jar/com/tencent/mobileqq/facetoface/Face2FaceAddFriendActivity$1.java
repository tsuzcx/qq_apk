package com.tencent.mobileqq.facetoface;

import acgr;
import acia;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

class Face2FaceAddFriendActivity$1
  implements Runnable
{
  Face2FaceAddFriendActivity$1(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, acia paramacia) {}
  
  public void run()
  {
    if (this.this$0.cVN == 1) {
      if (!TextUtils.isEmpty(this.this$0.bGa)) {}
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          long l = Long.valueOf(this.this$0.bGa).longValue();
          boolean bool = this.a.k(l, 1);
          if (!bool)
          {
            Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(6, 0L);
            this.this$0.cVR = 2;
            return;
          }
        }
        catch (Exception localException) {}
      }
      if (!this.a.k(0L, 1))
      {
        Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(6, 0L);
        this.this$0.cVR = 2;
        return;
      }
    } while (this.this$0.a.x(this.this$0.app.getCurrentAccountUin(), false));
    this.this$0.cVQ = 2;
    Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(6, 0L);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.1
 * JD-Core Version:    0.7.0.1
 */