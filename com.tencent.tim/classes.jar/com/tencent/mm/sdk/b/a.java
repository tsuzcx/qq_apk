package com.tencent.mm.sdk.b;

import android.os.Bundle;

public final class a
{
  public static int a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return -1;
    }
    try
    {
      int i = paramBundle.getInt(paramString, -1);
      return i;
    }
    catch (Exception paramBundle)
    {
      b.a("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramBundle.getMessage() });
    }
    return -1;
  }
  
  public static String b(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      b.a("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramBundle.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */