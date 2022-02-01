package com.facebook.stetho.common.android;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.facebook.stetho.common.LogUtil;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ResourcesUtil
{
  private static String getFallbackIdString(int paramInt)
  {
    return "#" + Integer.toHexString(paramInt);
  }
  
  public static String getIdString(@Nullable Resources paramResources, int paramInt)
    throws Resources.NotFoundException
  {
    if (paramResources == null) {
      return getFallbackIdString(paramInt);
    }
    String str2;
    switch (getResourcePackageId(paramInt))
    {
    default: 
      str2 = paramResources.getResourcePackageName(paramInt);
    }
    for (String str1 = ":";; str1 = "")
    {
      String str3 = paramResources.getResourceTypeName(paramInt);
      paramResources = paramResources.getResourceEntryName(paramInt);
      StringBuilder localStringBuilder = new StringBuilder(str2.length() + 1 + str1.length() + str3.length() + 1 + paramResources.length());
      localStringBuilder.append("@");
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      localStringBuilder.append(str3);
      localStringBuilder.append("/");
      localStringBuilder.append(paramResources);
      return localStringBuilder.toString();
      str2 = "";
    }
  }
  
  @Nonnull
  public static String getIdStringQuietly(Object paramObject, @Nullable Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = getIdString(paramResources, paramInt);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      paramResources = getFallbackIdString(paramInt);
      LogUtil.w("Unknown identifier encountered on " + paramObject + ": " + paramResources);
    }
    return paramResources;
  }
  
  private static int getResourcePackageId(int paramInt)
  {
    return paramInt >>> 24 & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.ResourcesUtil
 * JD-Core Version:    0.7.0.1
 */