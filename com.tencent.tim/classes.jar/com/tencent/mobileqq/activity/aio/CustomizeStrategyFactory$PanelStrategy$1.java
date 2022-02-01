package com.tencent.mobileqq.activity.aio;

import aaai;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;
import wkr;

public class CustomizeStrategyFactory$PanelStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$PanelStrategy$1(CustomizeStrategyFactory.d paramd, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "PanelStrategy");
      }
      if ((this.this$0.a == null) || (this.this$0.b == null) || (TextUtils.isEmpty(this.val$info.templateId)))
      {
        CustomizeStrategyFactory.a().b(this.val$info);
        return;
      }
      String str = this.this$0.b.a("redPackPanel", "https://i.gtimg.cn/channel/imglib/201803/", new String[] { "themeInfo", "prefix" });
      str = str + this.val$info.templateId + ".png";
      this.this$0.a.b(str, new wkr(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.PanelStrategy.1
 * JD-Core Version:    0.7.0.1
 */