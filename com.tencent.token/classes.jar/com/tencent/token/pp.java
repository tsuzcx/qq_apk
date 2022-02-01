package com.tencent.token;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public final class pp
{
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Intent localIntent;
    if ((paramContext != null) && (paramString1.length() != 0) && (paramString2.length() != 0))
    {
      localIntent = new Intent();
      localIntent.setClassName(paramString1, paramString2);
      localIntent.putExtras(paramBundle);
      paramString1 = paramContext.getPackageName();
      localIntent.putExtra("_mmessage_sdkVersion", 553910273);
      localIntent.putExtra("_mmessage_appPackage", paramString1);
      localIntent.putExtra("_mmessage_content", paramString3);
      localIntent.putExtra("_mmessage_checksum", pq.a(paramString3, paramString1));
      localIntent.addFlags(268435456).addFlags(134217728);
    }
    try
    {
      paramContext.startActivity(localIntent);
      pw.c("MicroMsg.SDK.MMessageAct", "send mm message, intent=".concat(String.valueOf(localIntent)));
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      label128:
      break label128;
    }
    for (paramContext = "send fail, target ActivityNotFound";; paramContext = "send fail, invalid arguments")
    {
      pw.a("MicroMsg.SDK.MMessageAct", paramContext);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pp
 * JD-Core Version:    0.7.0.1
 */