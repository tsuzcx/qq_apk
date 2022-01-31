package com.tencent.biz.common.util;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;

public class OpenIdInterface
{
  public static OpenID a(QQAppInterface paramQQAppInterface, String paramString)
  {
    OpenID localOpenID = null;
    if (paramQQAppInterface != null) {
      localOpenID = paramQQAppInterface.a().a(paramString);
    }
    if (localOpenID == null) {
      a(paramQQAppInterface, paramString);
    }
    return localOpenID;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a().d(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.OpenIdInterface
 * JD-Core Version:    0.7.0.1
 */