package com.tencent.mm.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.algorithm.MD5;
import com.tencent.mm.sdk.MMSharedPreferences;
import com.tencent.mm.sdk.channel.MMessage;
import com.tencent.mm.sdk.channel.MMessageAct;
import com.tencent.mm.sdk.platformtools.Log;

final class WXApiImplV10
  implements IWXAPI
{
  private Context q;
  private String r;
  private boolean s = false;
  
  protected WXApiImplV10(Context paramContext, String paramString)
  {
    this(paramContext, paramString, false);
  }
  
  protected WXApiImplV10(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.q = paramContext;
    this.r = paramString;
    this.s = paramBoolean;
  }
  
  private boolean a(String paramString)
  {
    if (!this.s)
    {
      Log.d("MicroMsg.SDK.WXApiImplV10", "ignore wechat app signature validation");
      return true;
    }
    try
    {
      paramString = this.q.getPackageManager().getPackageInfo(paramString, 64);
      return a(paramString.signatures);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label39:
      break label39;
    }
    return false;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
      if (paramArrayOfByte1.length == paramArrayOfByte2.length) {}
    }
    for (paramArrayOfByte1 = "checkSumConsistent fail, length is different";; paramArrayOfByte1 = "checkSumConsistent fail, invalid arguments")
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", paramArrayOfByte1);
      return false;
      int i = 0;
      while (i < paramArrayOfByte1.length)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
  }
  
  private boolean a(Signature[] paramArrayOfSignature)
  {
    if (!this.s)
    {
      paramArrayOfSignature = "ignore wechat app signature validation";
      Log.d("MicroMsg.SDK.WXApiImplV10", paramArrayOfSignature);
      return true;
    }
    int j = paramArrayOfSignature.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label88;
      }
      String str = paramArrayOfSignature[i].toCharsString();
      StringBuilder localStringBuilder = new StringBuilder("check signature:");
      localStringBuilder.append(str);
      Log.d("MicroMsg.SDK.WXApiImplV10", localStringBuilder.toString());
      if (str.equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499"))
      {
        paramArrayOfSignature = "pass";
        break;
      }
      i += 1;
    }
    label88:
    return false;
  }
  
  public final int getWXAppSupportAPI()
  {
    if (!isWXAppInstalled())
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return 0;
    }
    return new MMSharedPreferences(this.q).getInt("_build_info_sdk_int_", 0);
  }
  
  public final boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    if (paramIntent == null) {}
    do
    {
      i = 0;
      break;
      str1 = paramIntent.getStringExtra("wx_token_key");
    } while ((str1 == null) || (!str1.equals("com.tencent.mm.openapi.token")));
    int i = 1;
    if (i == 0) {
      return false;
    }
    String str1 = paramIntent.getStringExtra("_mmessage_content");
    i = paramIntent.getIntExtra("_mmessage_sdkVersion", 0);
    String str2 = paramIntent.getStringExtra("_mmessage_appPackage");
    if ((str2 != null) && (str2.length() != 0))
    {
      byte[] arrayOfByte = paramIntent.getByteArrayExtra("_mmessage_checksum");
      StringBuffer localStringBuffer = new StringBuffer();
      if (str1 != null) {
        localStringBuffer.append(str1);
      }
      localStringBuffer.append(i);
      localStringBuffer.append(str2);
      localStringBuffer.append("mMcShCsTr");
      if (a(arrayOfByte, MD5.getMessageDigest(localStringBuffer.toString().substring(1, 9).getBytes()).getBytes())) {}
    }
    for (paramIntent = "checksum fail";; paramIntent = "invalid argument")
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", paramIntent);
      return false;
      switch (paramIntent.getIntExtra("_wxapi_command_type", 0))
      {
      default: 
        return false;
      case 4: 
        paramIWXAPIEventHandler.onReq(new ShowMessageFromWX.Req(paramIntent.getExtras()));
        return true;
      case 3: 
        paramIWXAPIEventHandler.onReq(new GetMessageFromWX.Req(paramIntent.getExtras()));
        return true;
      case 2: 
        paramIWXAPIEventHandler.onResp(new SendMessageToWX.Resp(paramIntent.getExtras()));
        return true;
      }
      paramIWXAPIEventHandler.onResp(new SendAuth.Resp(paramIntent.getExtras()));
      return true;
    }
  }
  
  public final boolean isWXAppInstalled()
  {
    try
    {
      PackageInfo localPackageInfo = this.q.getPackageManager().getPackageInfo("com.tencent.mm", 64);
      if (localPackageInfo == null) {
        return false;
      }
      boolean bool = a(localPackageInfo.signatures);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public final boolean isWXAppSupportAPI()
  {
    return getWXAppSupportAPI() >= 553910273;
  }
  
  public final boolean openWXApp()
  {
    if (!isWXAppInstalled())
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return false;
    }
    try
    {
      this.q.startActivity(this.q.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("startActivity fail, exception = ");
      localStringBuilder.append(localException.getMessage());
      Log.e("MicroMsg.SDK.WXApiImplV10", localStringBuilder.toString());
    }
    return false;
  }
  
  public final boolean registerApp(String paramString)
  {
    if (!a("com.tencent.mm"))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
      return false;
    }
    if (paramString != null) {
      this.r = paramString;
    }
    paramString = new StringBuilder("register app ");
    paramString.append(this.q.getPackageName());
    Log.d("MicroMsg.SDK.WXApiImplV10", paramString.toString());
    paramString = this.q;
    StringBuilder localStringBuilder = new StringBuilder("weixin://registerapp?appid=");
    localStringBuilder.append(this.r);
    MMessage.send(paramString, "com.tencent.mm", "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER", localStringBuilder.toString());
    return true;
  }
  
  public final boolean sendReq(BaseReq paramBaseReq)
  {
    if (!a("com.tencent.mm")) {}
    for (paramBaseReq = "sendReq failed for wechat app signature check failed";; paramBaseReq = "sendReq checkArgs fail")
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", paramBaseReq);
      return false;
      if (paramBaseReq.checkArgs()) {
        break;
      }
    }
    Bundle localBundle = new Bundle();
    paramBaseReq.toBundle(localBundle);
    paramBaseReq = this.q;
    StringBuilder localStringBuilder = new StringBuilder("weixin://sendreq?appid=");
    localStringBuilder.append(this.r);
    return MMessageAct.sendToWx(paramBaseReq, localStringBuilder.toString(), localBundle);
  }
  
  public final boolean sendResp(BaseResp paramBaseResp)
  {
    if (!a("com.tencent.mm")) {}
    for (paramBaseResp = "sendResp failed for wechat app signature check failed";; paramBaseResp = "sendResp checkArgs fail")
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", paramBaseResp);
      return false;
      if (paramBaseResp.checkArgs()) {
        break;
      }
    }
    Bundle localBundle = new Bundle();
    paramBaseResp.toBundle(localBundle);
    paramBaseResp = this.q;
    StringBuilder localStringBuilder = new StringBuilder("weixin://sendresp?appid=");
    localStringBuilder.append(this.r);
    return MMessageAct.sendToWx(paramBaseResp, localStringBuilder.toString(), localBundle);
  }
  
  public final void unregisterApp()
  {
    if (!a("com.tencent.mm"))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
      return;
    }
    Object localObject = this.r;
    if ((localObject != null) && (((String)localObject).length() != 0))
    {
      localObject = new StringBuilder("unregister app ");
      ((StringBuilder)localObject).append(this.q.getPackageName());
      Log.d("MicroMsg.SDK.WXApiImplV10", ((StringBuilder)localObject).toString());
      localObject = this.q;
      StringBuilder localStringBuilder = new StringBuilder("weixin://unregisterapp?appid=");
      localStringBuilder.append(this.r);
      MMessage.send((Context)localObject, "com.tencent.mm", "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER", localStringBuilder.toString());
      return;
    }
    Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXApiImplV10
 * JD-Core Version:    0.7.0.1
 */