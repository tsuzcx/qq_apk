package com.tencent.mobileqq.activity.aio;

import aaai;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;
import wkx;

public class CustomizeStrategyFactory$VoiceResStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$VoiceResStrategy$1(CustomizeStrategyFactory.h paramh, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "VoiceResStrategy");
      }
      if ((this.this$0.a == null) || (this.this$0.b == null))
      {
        CustomizeStrategyFactory.a().b(this.val$info);
        return;
      }
      String str = this.this$0.b.a("voice_pwd", "https://imgcache.qq.com/channel/static/socialpay/voice/", new String[] { "urlPrefix" });
      str = str + "voice_rate_" + this.val$info.templateId + ".zip";
      this.this$0.a.a(str, new wkx(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.VoiceResStrategy.1
 * JD-Core Version:    0.7.0.1
 */