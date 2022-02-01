package com.tencent.TMG.config;

import android.text.TextUtils;

public class ConfigBaseParser
{
  public static final String DEFAULT_VALUE = "unknown";
  protected String mData = null;
  
  public ConfigBaseParser() {}
  
  public ConfigBaseParser(String paramString)
  {
    this.mData = paramString;
  }
  
  public native String findConfigValue(String paramString1, String paramString2, String paramString3);
  
  public native String getConfig();
  
  protected int getIntValue(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      paramString = getIntValues(paramString);
    } while ((paramString == null) || (paramString.length <= 0));
    return paramString[0];
  }
  
  protected int[] getIntValues(String paramString)
  {
    int[] arrayOfInt = null;
    if (TextUtils.isEmpty(this.mData)) {
      this.mData = getConfig();
    }
    Object localObject = findConfigValue(this.mData, paramString, "unknown");
    paramString = arrayOfInt;
    if (localObject != null)
    {
      if (!((String)localObject).equalsIgnoreCase("unknown")) {
        break label57;
      }
      paramString = arrayOfInt;
    }
    label57:
    do
    {
      return paramString;
      localObject = ((String)localObject).split(",");
      paramString = arrayOfInt;
    } while (localObject == null);
    int j = localObject.length;
    arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfInt;
      if (i >= j) {
        break;
      }
      try
      {
        arrayOfInt[i] = Integer.parseInt(localObject[i].trim());
        i += 1;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          arrayOfInt[i] = 0;
        }
      }
    }
  }
  
  protected String getStringValue(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString2;
      paramString1 = getStringValues(paramString1);
    } while ((paramString1 == null) || (paramString1.length <= 0));
    return paramString1[0];
  }
  
  protected String[] getStringValues(String paramString)
  {
    if (TextUtils.isEmpty(this.mData)) {
      this.mData = getConfig();
    }
    paramString = findConfigValue(this.mData, paramString, "unknown");
    if ((paramString == null) || (paramString.equalsIgnoreCase("unknown"))) {
      return null;
    }
    return paramString.trim().split(",");
  }
  
  public void setConfig(String paramString)
  {
    this.mData = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigBaseParser
 * JD-Core Version:    0.7.0.1
 */