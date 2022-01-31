package oicq.wlogin_sdk.quicklogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;
import oicq.wlogin_sdk.tools.util;

public class QuickLogin
{
  private static int a(Activity paramActivity, long paramLong1, long paramLong2, WtloginHelper.QuickLoginParam paramQuickLoginParam)
  {
    Intent localIntent;
    if ((paramQuickLoginParam != null) && (paramQuickLoginParam.webViewActivityClassName != null) && (paramQuickLoginParam.webViewActivityClassName.length() != 0))
    {
      localIntent = new Intent();
      localIntent.setClassName(paramActivity, paramQuickLoginParam.webViewActivityClassName);
    }
    for (;;)
    {
      localIntent.putExtra("appid", paramLong1);
      localIntent.putExtra("subappid", paramLong2);
      if ((paramQuickLoginParam != null) && (paramQuickLoginParam.userAccount != null) && (paramQuickLoginParam.userAccount.length() != 0))
      {
        localIntent.putExtra("account", paramQuickLoginParam.userAccount);
        localIntent.putExtra("isUserAccountLocked", paramQuickLoginParam.isUserAccountLocked);
      }
      if (paramQuickLoginParam != null) {
        localIntent.putExtra("forceWebLogin", paramQuickLoginParam.forceWebLogin);
      }
      if (paramQuickLoginParam != null)
      {
        localIntent.putExtra("titleBackgroundColor", paramQuickLoginParam.titleBackgroundColor);
        localIntent.putExtra("titleTextColor", paramQuickLoginParam.titleTextColor);
        localIntent.putExtra("finishAnimEnter", paramQuickLoginParam.finishAnimEnter);
        localIntent.putExtra("finishAnimExit", paramQuickLoginParam.finishAnimExit);
      }
      util.LOGI("before startActivityForResult for web", "");
      paramActivity.startActivityForResult(localIntent, 1202);
      if ((paramQuickLoginParam != null) && ((paramQuickLoginParam.startAnimEnter != 0) || (paramQuickLoginParam.startAnimExit != 0))) {
        paramActivity.overridePendingTransition(paramQuickLoginParam.startAnimEnter, paramQuickLoginParam.startAnimExit);
      }
      return -2000;
      localIntent = new Intent(paramActivity, QuickLoginWebViewActivity.class);
    }
  }
  
  private static int a(Context paramContext, Activity paramActivity, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    Object localObject = util.get_rsa_pubkey(paramContext);
    if (localObject != null)
    {
      paramContext = (Context)localObject;
      if (localObject.length != 0) {}
    }
    else
    {
      paramContext = util.string_to_buf("30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001");
    }
    localObject = new Intent();
    ((Intent)localObject).setClassName(paramString1, "com.tencent.open.agent.AgentActivity");
    paramString1 = new Bundle();
    paramString1.putLong("dstSsoVer", 1L);
    paramString1.putLong("dstAppid", paramLong1);
    paramString1.putLong("subDstAppid", paramLong2);
    paramString1.putByteArray("dstAppVer", paramString2.getBytes());
    paramString1.putByteArray("publickey", paramContext);
    ((Intent)localObject).putExtra("key_params", paramString1);
    ((Intent)localObject).putExtra("key_action", "action_quick_login");
    util.LOGI("before startActivityForResult for qq", "");
    paramActivity.startActivityForResult((Intent)localObject, 1201);
    return -2001;
  }
  
  public static int jumpToLoginActivity(Context paramContext, Activity paramActivity, long paramLong1, long paramLong2, String paramString, WtloginHelper.QuickLoginParam paramQuickLoginParam)
  {
    if ((paramQuickLoginParam != null) && (true == paramQuickLoginParam.forceWebLogin)) {
      return a(paramActivity, paramLong1, paramLong2, paramQuickLoginParam);
    }
    try
    {
      if (true == util.isMQQExist(paramContext))
      {
        util.LOGI("login through qq", "");
        return a(paramContext, paramActivity, "com.tencent.mobileqq", paramLong1, paramLong2, paramString);
      }
      if (true == util.isPackageExist(paramContext, "com.tencent.minihd.qq"))
      {
        util.LOGI("login through qq hd", "");
        return a(paramContext, paramActivity, "com.tencent.minihd.qq", paramLong1, paramLong2, paramString);
      }
      if (true == util.isPackageExist(paramContext, "com.tencent.tim"))
      {
        util.LOGI("login through tim", "");
        return a(paramContext, paramActivity, "com.tencent.tim", paramLong1, paramLong2, paramString);
      }
      if (true == util.isPackageExist(paramContext, "com.tencent.qim"))
      {
        util.LOGI("login through qim", "");
        return a(paramContext, paramActivity, "com.tencent.qim", paramLong1, paramLong2, paramString);
      }
      util.LOGI("login through web", "");
      int i = a(paramActivity, paramLong1, paramLong2, paramQuickLoginParam);
      return i;
    }
    catch (Exception paramContext)
    {
      util.LOGI("login through web as exception occurred " + paramContext.getMessage(), "");
    }
    return a(paramActivity, paramLong1, paramLong2, paramQuickLoginParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.QuickLogin
 * JD-Core Version:    0.7.0.1
 */