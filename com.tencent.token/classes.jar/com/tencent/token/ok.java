package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public final class ok
{
  public static boolean a(Context paramContext, a parama)
  {
    if (paramContext == null) {
      return false;
    }
    if (pn.a(parama.a))
    {
      new StringBuilder("send fail, invalid targetPkgName, targetPkgName = ").append(parama.a);
      return false;
    }
    if (pn.a(parama.b))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(parama.a);
      ((StringBuilder)localObject).append(".wxapi.WXEntryActivity");
      parama.b = ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder("send, targetPkgName = ");
    ((StringBuilder)localObject).append(parama.a);
    ((StringBuilder)localObject).append(", targetClassName = ");
    ((StringBuilder)localObject).append(parama.b);
    localObject = new Intent();
    ((Intent)localObject).setClassName(parama.a, parama.b);
    if (parama.f != null) {
      ((Intent)localObject).putExtras(parama.f);
    }
    String str = paramContext.getPackageName();
    ((Intent)localObject).putExtra("_mmessage_sdkVersion", 621086720);
    ((Intent)localObject).putExtra("_mmessage_appPackage", str);
    ((Intent)localObject).putExtra("_mmessage_content", parama.c);
    ((Intent)localObject).putExtra("_mmessage_checksum", om.a(parama.c, str));
    ((Intent)localObject).putExtra("_message_token", parama.d);
    if (parama.e == -1) {
      ((Intent)localObject).addFlags(268435456).addFlags(134217728);
    } else {
      ((Intent)localObject).setFlags(parama.e);
    }
    try
    {
      paramContext.startActivity((Intent)localObject);
      "send mm message, intent=".concat(String.valueOf(localObject));
      return true;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("send fail, ex = ").append(paramContext.getMessage());
    }
    return false;
  }
  
  public static final class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e = -1;
    public Bundle f;
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("targetPkgName:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", targetClassName:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", content:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", flags:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", bundle:");
      localStringBuilder.append(this.f);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ok
 * JD-Core Version:    0.7.0.1
 */