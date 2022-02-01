package com.tencent.mobileqq.ark.API;

final class ArkAppNotifyCenter$1
  implements Runnable
{
  ArkAppNotifyCenter$1(ArkAppNotifyCenter.b paramb, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.a.notify(this.val$appName, this.val$eventName, this.val$params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.1
 * JD-Core Version:    0.7.0.1
 */