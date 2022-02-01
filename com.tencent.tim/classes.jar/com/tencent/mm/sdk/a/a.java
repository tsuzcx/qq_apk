package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.f;

public final class a
{
  public static boolean a(Context paramContext, a parama)
  {
    if ((paramContext == null) || (parama == null))
    {
      com.tencent.mm.sdk.b.b.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      return false;
    }
    if (f.c(parama.b))
    {
      com.tencent.mm.sdk.b.b.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + parama.b);
      return false;
    }
    if (f.c(parama.c)) {
      parama.c = (parama.b + ".wxapi.WXEntryActivity");
    }
    com.tencent.mm.sdk.b.b.c("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + parama.b + ", targetClassName = " + parama.c);
    Intent localIntent = new Intent();
    localIntent.setClassName(parama.b, parama.c);
    if (parama.e != null) {
      localIntent.putExtras(parama.e);
    }
    String str = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 570490883);
    localIntent.putExtra("_mmessage_appPackage", str);
    localIntent.putExtra("_mmessage_content", parama.d);
    localIntent.putExtra("_mmessage_checksum", com.tencent.mm.sdk.a.a.b.a(parama.d, 570490883, str));
    if (parama.flags == -1) {
      localIntent.addFlags(268435456).addFlags(134217728);
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        com.tencent.mm.sdk.b.b.c("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        com.tencent.mm.sdk.b.b.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", new Object[] { paramContext.getMessage() });
      }
      localIntent.setFlags(parama.flags);
    }
    return false;
  }
  
  public static final class a
  {
    public String b;
    public String c;
    public String d;
    public Bundle e;
    public int flags = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */