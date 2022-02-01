package com.tencent.mobileqq.mini.servlet;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

public class MiniAppSSOCmdHelper
{
  private static final String TAG = "MiniAppSSOCmdHelper";
  
  public static <REQUEST extends MessageMicro<REQUEST>, RESPONSE extends MessageMicro<RESPONSE>> void sendSSOCmdRequest(@NonNull String paramString1, String paramString2, @NonNull REQUEST paramREQUEST, @NonNull Class<RESPONSE> paramClass, MiniAppCmdCallback<RESPONSE> paramMiniAppCmdCallback)
  {
    if (paramClass == null)
    {
      QLog.e("MiniAppSSOCmdHelper", 2, "sendSSOCmdRequest response class is null, not send sso request for " + paramString1);
      return;
    }
    MiniAppSSOCmdObserver.defaultObserver().sendSSOCmdRequest(paramString1, paramString2, paramREQUEST, new MiniAppSSOCmdHelper.1(paramMiniAppCmdCallback, paramClass));
  }
  
  public static abstract interface MiniAppCmdCallback<RESPONSE extends MessageMicro<RESPONSE>>
  {
    public abstract void onReceived(boolean paramBoolean, RESPONSE paramRESPONSE);
  }
  
  static abstract interface MiniAppCmdCallbackInternal<RESPONSE extends MessageMicro<RESPONSE>>
    extends MiniAppSSOCmdHelper.MiniAppCmdCallback<RESPONSE>
  {
    @NonNull
    public abstract Class<? extends RESPONSE> getResponseClass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper
 * JD-Core Version:    0.7.0.1
 */