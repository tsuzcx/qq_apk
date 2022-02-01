package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;
import wkv;

public class CustomizeStrategyFactory$ThemeAnimStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$ThemeAnimStrategy$1(CustomizeStrategyFactory.f paramf, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "ThemeAnimStrategy");
    }
    if ((CustomizeStrategyFactory.f.a(this.this$0) == null) || (TextUtils.isEmpty(this.val$info.templateId)))
    {
      CustomizeStrategyFactory.a().b(this.val$info);
      return;
    }
    String str = this.val$info.templateId + ".zip";
    CustomizeStrategyFactory.f.a(this.this$0).a(str, "", new wkv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeAnimStrategy.1
 * JD-Core Version:    0.7.0.1
 */