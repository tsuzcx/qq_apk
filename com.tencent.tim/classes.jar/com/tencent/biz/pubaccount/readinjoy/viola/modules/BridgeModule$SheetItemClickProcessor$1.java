package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URLEncoder;
import kxm;

class BridgeModule$SheetItemClickProcessor$1
  implements Runnable
{
  BridgeModule$SheetItemClickProcessor$1(BridgeModule.b paramb, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$url)) {}
    try
    {
      localObject = (QQAppInterface)kxm.getAppRuntime();
      if (localObject == null) {
        break label87;
      }
      localObject = ((QQAppInterface)localObject).getAccount();
      localObject = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + URLEncoder.encode(this.val$url, "utf-8") + "&qq=" + (String)localObject + "&_wv=7";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.printStackTrace();
        String str = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=";
      }
    }
    if (BaseActivity.sTopActivity != null) {
      kxm.aJ(BaseActivity.sTopActivity, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.SheetItemClickProcessor.1
 * JD-Core Version:    0.7.0.1
 */