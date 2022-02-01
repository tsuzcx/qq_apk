package com.tencent.mobileqq.ark.API;

import adnq.c;
import adnx;
import com.tencent.ark.ark.VariantWrapper;
import java.util.HashMap;
import java.util.Locale;
import oicq.wlogin_sdk.tools.util;

public class ArkAppModuleReg$ModuleQQ$25$1
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$25$1(adnx paramadnx, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, String paramString) {}
  
  public void run()
  {
    ark.VariantWrapper localVariantWrapper1 = this.a.this$0.a(this.a.Vr);
    if (localVariantWrapper1 == null)
    {
      adnq.c.a(this.a.this$0, null);
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    Object localObject;
    if (this.val$ret == 0)
    {
      localObject = util.buf_to_string(this.ds);
      String str1 = util.buf_to_string(this.dt);
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"openid\":\"%s\",\"token\":\"%s\"}", new Object[] { localObject, str1 }));
      String str2 = this.a.this$0.mAppName + "_" + this.Vs + "_" + this.val$userAccount;
      adnq.c.a(this.a.this$0).put(str2, localObject);
      adnq.c.b(this.a.this$0).put(str2, str1);
      adnq.c.c(this.a.this$0).put(this.a.this$0.mAppName, String.valueOf(this.Vs));
    }
    for (;;)
    {
      localObject = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, (ark.VariantWrapper)localObject);
      ((ark.VariantWrapper)localObject).Reset();
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      adnq.c.a(this.a.this$0, null);
      return;
      localVariantWrapper2.SetNull();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.25.1
 * JD-Core Version:    0.7.0.1
 */