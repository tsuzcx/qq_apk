package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;

final class qj
  implements qg
{
  private Context a;
  private String b;
  private boolean c = false;
  
  protected qj(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = false;
  }
  
  private boolean a(Signature[] paramArrayOfSignature)
  {
    if (!this.c)
    {
      paramArrayOfSignature = "ignore wechat app signature validation";
      qk.c("MicroMsg.SDK.WXApiImplV10", paramArrayOfSignature);
      return true;
    }
    int j = paramArrayOfSignature.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label74;
      }
      String str = paramArrayOfSignature[i].toCharsString();
      qk.c("MicroMsg.SDK.WXApiImplV10", "check signature:".concat(String.valueOf(str)));
      if (str.equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499"))
      {
        paramArrayOfSignature = "pass";
        break;
      }
      i += 1;
    }
    label74:
    return false;
  }
  
  private boolean b(String paramString)
  {
    if (!this.c)
    {
      qk.c("MicroMsg.SDK.WXApiImplV10", "ignore wechat app signature validation");
      return true;
    }
    try
    {
      paramString = this.a.getPackageManager().getPackageInfo(paramString, 64);
      return a(paramString.signatures);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label39:
      break label39;
    }
    return false;
  }
  
  public final boolean a()
  {
    try
    {
      PackageInfo localPackageInfo = this.a.getPackageManager().getPackageInfo("com.tencent.mm", 64);
      if (localPackageInfo == null) {
        return false;
      }
      boolean bool = a(localPackageInfo.signatures);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public final boolean a(qf paramqf)
  {
    if (!b("com.tencent.mm")) {}
    for (paramqf = "sendReq failed for wechat app signature check failed";; paramqf = "sendReq checkArgs fail")
    {
      qk.a("MicroMsg.SDK.WXApiImplV10", paramqf);
      return false;
      if (paramqf.a()) {
        break;
      }
    }
    Bundle localBundle = new Bundle();
    paramqf.a(localBundle);
    paramqf = this.a;
    StringBuilder localStringBuilder = new StringBuilder("weixin://sendreq?appid=");
    localStringBuilder.append(this.b);
    return qd.a(paramqf, "com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity", localStringBuilder.toString(), localBundle);
  }
  
  public final boolean a(String paramString)
  {
    if (!b("com.tencent.mm"))
    {
      qk.a("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
      return false;
    }
    this.b = paramString;
    paramString = new StringBuilder("register app ");
    paramString.append(this.a.getPackageName());
    qk.c("MicroMsg.SDK.WXApiImplV10", paramString.toString());
    paramString = this.a;
    Object localObject1 = new StringBuilder("weixin://registerapp?appid=");
    ((StringBuilder)localObject1).append(this.b);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("com.tencent.mm");
    ((StringBuilder)localObject2).append(".permission.MM_MESSAGE");
    localObject2 = ((StringBuilder)localObject2).toString();
    Intent localIntent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER");
    String str = paramString.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 553910273);
    localIntent.putExtra("_mmessage_appPackage", str);
    localIntent.putExtra("_mmessage_content", (String)localObject1);
    localIntent.putExtra("_mmessage_checksum", qe.a((String)localObject1, str));
    paramString.sendBroadcast(localIntent, (String)localObject2);
    paramString = new StringBuilder("send mm message, intent=");
    paramString.append(localIntent);
    paramString.append(", perm=");
    paramString.append((String)localObject2);
    qk.c("MicroMsg.SDK.MMessage", paramString.toString());
    return true;
  }
  
  public final int b()
  {
    if (!a())
    {
      qk.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return 0;
    }
    return new qc(this.a).getInt("_build_info_sdk_int_", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qj
 * JD-Core Version:    0.7.0.1
 */