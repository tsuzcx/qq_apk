package com.tencent.token;

import android.content.Context;
import com.tencent.halley.downloader.DownloaderFactory;
import java.util.List;

public final class kv
{
  public static List a(String paramString, long paramLong)
  {
    try
    {
      if (nb.a() != null)
      {
        paramString = nb.a().a(paramString, paramLong);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      label19:
      break label19;
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Context localContext = lp.a();
      if (localContext != null) {
        return;
      }
      lp.a(paramContext, paramString1, paramString2, paramString3);
      nb.a(paramContext, paramString1, paramString2, paramString3);
      DownloaderFactory.a(null);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kv
 * JD-Core Version:    0.7.0.1
 */