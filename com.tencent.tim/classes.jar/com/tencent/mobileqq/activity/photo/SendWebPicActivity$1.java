package com.tencent.mobileqq.activity.photo;

import aurf;

class SendWebPicActivity$1
  implements Runnable
{
  SendWebPicActivity$1(SendWebPicActivity paramSendWebPicActivity, String paramString) {}
  
  public void run()
  {
    SendWebPicActivity.a(this.this$0).sendEmptyMessage(1002);
    this.this$0.mw(this.val$imagePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendWebPicActivity.1
 * JD-Core Version:    0.7.0.1
 */