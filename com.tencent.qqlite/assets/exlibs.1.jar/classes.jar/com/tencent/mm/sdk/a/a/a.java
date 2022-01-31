package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.c;

public final class a
{
  public static boolean a(Context paramContext, a parama)
  {
    if ((paramContext == null) || (parama == null))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, invalid argument");
      return false;
    }
    if (c.a(parama.m))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, action is null");
      return false;
    }
    String str1 = null;
    if (!c.a(parama.l)) {
      str1 = parama.l + ".permission.MM_MESSAGE";
    }
    Intent localIntent = new Intent(parama.m);
    if (parama.k != null) {
      localIntent.putExtras(parama.k);
    }
    String str2 = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 570490883);
    localIntent.putExtra("_mmessage_appPackage", str2);
    localIntent.putExtra("_mmessage_content", parama.j);
    localIntent.putExtra("_mmessage_checksum", b.a(parama.j, 570490883, str2));
    paramContext.sendBroadcast(localIntent, str1);
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessage", "send mm message, intent=" + localIntent + ", perm=" + str1);
    return true;
  }
  
  public static final class a
  {
    public String j;
    public Bundle k;
    public String l;
    public String m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.a.a
 * JD-Core Version:    0.7.0.1
 */