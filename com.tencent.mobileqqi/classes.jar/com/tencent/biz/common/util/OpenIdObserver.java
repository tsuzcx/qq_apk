package com.tencent.biz.common.util;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class OpenIdObserver
  extends MessageObserver
{
  public static final int a = 1;
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QLog.d("openid", 2, "isSuccess=" + paramBoolean + ",data=" + paramObject);
    a(paramBoolean, (OpenID)paramObject);
  }
  
  protected void a(boolean paramBoolean, OpenID paramOpenID) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.OpenIdObserver
 * JD-Core Version:    0.7.0.1
 */