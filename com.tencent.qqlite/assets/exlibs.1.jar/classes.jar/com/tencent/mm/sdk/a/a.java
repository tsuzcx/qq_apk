package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;

public final class a
{
  public static boolean a(Context paramContext, a parama)
  {
    if ((paramContext == null) || (parama == null))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      return false;
    }
    if (c.a(parama.h))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + parama.h);
      return false;
    }
    if (c.a(parama.i)) {
      parama.i = (parama.h + ".wxapi.WXEntryActivity");
    }
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + parama.h + ", targetClassName = " + parama.i);
    Intent localIntent = new Intent();
    localIntent.setClassName(parama.h, parama.i);
    if (parama.k != null) {
      localIntent.putExtras(parama.k);
    }
    String str = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 570490883);
    localIntent.putExtra("_mmessage_appPackage", str);
    localIntent.putExtra("_mmessage_content", parama.j);
    localIntent.putExtra("_mmessage_checksum", b.a(parama.j, 570490883, str));
    if (parama.flags == -1) {
      localIntent.addFlags(268435456).addFlags(134217728);
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", new Object[] { paramContext.getMessage() });
      }
      localIntent.setFlags(parama.flags);
    }
    return false;
  }
  
  public static final class a
  {
    public int flags = -1;
    public String h;
    public String i;
    public String j;
    public Bundle k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */