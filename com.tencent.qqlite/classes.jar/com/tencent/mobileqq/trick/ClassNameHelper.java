package com.tencent.mobileqq.trick;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ClassNameHelper
{
  private static Set a;
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new ComponentName(paramString1, paramString2).flattenToShortString();
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return null;
  }
  
  public static Set a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a = new HashSet();
        Intent localIntent = new Intent();
        localIntent.setAction("com.android.settings.SubSettings");
        a.addAll(a(localIntent));
        a.add("com.android.settings.SubSettings");
        a.add("com.android.settings.applications.ManageApplicationsActivity");
      }
      return a;
    }
    finally {}
  }
  
  private static Set a(Intent paramIntent)
  {
    paramIntent = BaseApplicationImpl.getContext().getPackageManager().queryIntentActivities(paramIntent, 65536).iterator();
    HashSet localHashSet = new HashSet();
    while (paramIntent.hasNext())
    {
      Object localObject = (ResolveInfo)paramIntent.next();
      String str2 = ((ResolveInfo)localObject).activityInfo.packageName;
      String str1 = ((ResolveInfo)localObject).activityInfo.name;
      String str3 = ((ResolveInfo)localObject).activityInfo.targetActivity;
      if ((((ResolveInfo)localObject).activityInfo.applicationInfo.flags & 0x1) != 0)
      {
        localObject = a(str2, str1);
        if (localObject != null) {
          localHashSet.add(localObject);
        }
        str2 = a(str2, str3);
        if (str2 != null) {
          localHashSet.add(str2);
        }
        localHashSet.add(str1);
      }
    }
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.trick.ClassNameHelper
 * JD-Core Version:    0.7.0.1
 */