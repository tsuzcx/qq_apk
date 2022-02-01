package com.tencent.mobileqq.utils.confighandler;

import adbv;
import adca;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;

public class ARPromotionConfigHandler
{
  public static class ARPromotionEntryHandler
    extends NormalConfigHandler<PromotionConfigInfo>
  {
    public ARPromotionEntryHandler(String paramString)
    {
      super(paramString, "config_qq.android.ar_", "config", "ver");
    }
    
    public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, PromotionConfigInfo paramPromotionConfigInfo)
    {
      adca.a(paramQQAppInterface).a(paramQQAppInterface, paramString, paramPromotionConfigInfo);
    }
  }
  
  public static class ARPromotionResHandler
    extends NormalConfigHandler<DefaultConfigInfo>
  {
    public ARPromotionResHandler(String paramString)
    {
      super(paramString, "res_qq.android.ar_", "config", "ver");
    }
    
    public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DefaultConfigInfo paramDefaultConfigInfo)
    {
      adca.a(paramQQAppInterface).a(paramQQAppInterface, paramString, paramDefaultConfigInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler
 * JD-Core Version:    0.7.0.1
 */