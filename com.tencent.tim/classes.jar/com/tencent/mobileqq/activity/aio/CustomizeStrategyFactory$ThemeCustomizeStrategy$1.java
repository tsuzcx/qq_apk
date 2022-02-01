package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;
import wkw;

public class CustomizeStrategyFactory$ThemeCustomizeStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$ThemeCustomizeStrategy$1(CustomizeStrategyFactory.g paramg, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "ThemeCustomizeStrategy");
      }
      if ((CustomizeStrategyFactory.g.a(this.this$0) == null) || (TextUtils.isEmpty(this.val$info.templateId)))
      {
        CustomizeStrategyFactory.a().b(this.val$info);
        return;
      }
      String str = this.val$info.templateId + ".png";
      CustomizeStrategyFactory.g.a(this.this$0).b(str, new wkw(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeCustomizeStrategy.1
 * JD-Core Version:    0.7.0.1
 */