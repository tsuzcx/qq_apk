package com.tencent.mobileqq.activity;

import acdt;
import android.graphics.Bitmap;

class JoinDiscussionActivity$FaceObserver$1
  implements Runnable
{
  JoinDiscussionActivity$FaceObserver$1(JoinDiscussionActivity.a parama) {}
  
  public void run()
  {
    Bitmap localBitmap = this.b.this$0.a.w(this.b.this$0.aNL);
    this.b.this$0.runOnUiThread(new JoinDiscussionActivity.FaceObserver.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.FaceObserver.1
 * JD-Core Version:    0.7.0.1
 */