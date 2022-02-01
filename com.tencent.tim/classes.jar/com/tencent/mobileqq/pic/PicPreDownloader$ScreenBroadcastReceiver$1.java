package com.tencent.mobileqq.pic;

import angb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class PicPreDownloader$ScreenBroadcastReceiver$1
  implements Runnable
{
  PicPreDownloader$ScreenBroadcastReceiver$1(PicPreDownloader.a parama) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.mUinString);
      if (localObject1 != null)
      {
        PicPreDownloader localPicPreDownloader = ((QQAppInterface)localObject1).a();
        localObject1 = (angb)((QQAppInterface)localObject1).getManager(95);
        if (localPicPreDownloader != null)
        {
          localPicPreDownloader.consume();
          localPicPreDownloader.dDU();
        }
        if (localObject1 != null) {
          ((angb)localObject1).dDU();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.ScreenBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */