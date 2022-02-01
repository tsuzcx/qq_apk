package com.tencent.mm.sdk.c;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.mm.sdk.b.b;

public final class a
{
  public static final class a
  {
    public static Object a(int paramInt, String paramString)
    {
      String str = paramString;
      switch (paramInt)
      {
      default: 
      case 1: 
      case 2: 
      case 4: 
      case 5: 
      case 6: 
        try
        {
          b.a("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          str = null;
        }
        return Integer.valueOf(paramString);
        return Long.valueOf(paramString);
        return Boolean.valueOf(paramString);
        return Float.valueOf(paramString);
        paramString = Double.valueOf(paramString);
        return paramString;
      }
      return str;
    }
  }
  
  public static final class b
    implements BaseColumns
  {
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */