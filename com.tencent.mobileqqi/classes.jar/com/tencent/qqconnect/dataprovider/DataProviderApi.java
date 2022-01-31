package com.tencent.qqconnect.dataprovider;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.List;

public final class DataProviderApi
{
  private static final String DATA_PROVIDER_SCHEME = "tencent%s.data://";
  
  public static boolean has3rdPartyApp(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(String.format("tencent%s.data://", new Object[] { paramString })));
    return paramContext.queryIntentActivities(localIntent, 0).size() != 0;
  }
  
  public static int startDataProviderActivity(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(String.format("tencent%s.data://", new Object[] { paramString1 })));
    localIntent.putExtra("requestDataTypeFlag", paramInt);
    localIntent.putExtra("srcAction", paramString2);
    localIntent.putExtra("srcPackageName", paramString3);
    localIntent.putExtra("srcClassName", paramString4);
    localIntent.putExtra("params_appid", paramString1);
    try
    {
      paramContext.startActivity(localIntent);
      return 0;
    }
    catch (ActivityNotFoundException paramContext) {}
    return -4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.qqconnect.dataprovider.DataProviderApi
 * JD-Core Version:    0.7.0.1
 */