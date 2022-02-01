package com.tencent.token;

import android.net.Uri;
import android.provider.BaseColumns;

public final class pf
{
  public static final class a
  {
    public static Object a(int paramInt, String paramString)
    {
      switch (paramInt)
      {
      default: 
        break;
      case 6: 
      case 5: 
      case 4: 
      case 2: 
      case 1: 
        try
        {
          return Double.valueOf(paramString);
        }
        catch (Exception paramString)
        {
          new StringBuilder("resolveObj exception:").append(paramString.getMessage());
        }
        return Float.valueOf(paramString);
        return Boolean.valueOf(paramString);
        return Long.valueOf(paramString);
        paramString = Integer.valueOf(paramString);
        return paramString;
        return null;
      }
      return paramString;
    }
  }
  
  public static final class b
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pf
 * JD-Core Version:    0.7.0.1
 */