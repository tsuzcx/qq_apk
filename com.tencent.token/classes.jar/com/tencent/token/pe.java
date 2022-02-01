package com.tencent.token;

import android.os.Bundle;

public final class pe
{
  public static String a(Bundle paramBundle, String paramString)
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
      new StringBuilder("getStringExtra exception:").append(paramBundle.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pe
 * JD-Core Version:    0.7.0.1
 */