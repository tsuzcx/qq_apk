package com.tencent.mobileqq.activity.aio;

import aqiz;
import com.tencent.mobileqq.app.QQAppInterface;
import wjw;

public class AppGuideTipsManager$2
  implements Runnable
{
  public AppGuideTipsManager$2(wjw paramwjw) {}
  
  public void run()
  {
    wjw.b(this.this$0, aqiz.isAppInstalled(wjw.a(this.this$0).getApp(), "com.tencent.tim"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AppGuideTipsManager.2
 * JD-Core Version:    0.7.0.1
 */