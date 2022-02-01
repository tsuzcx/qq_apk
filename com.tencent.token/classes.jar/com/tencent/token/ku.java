package com.tencent.token;

import android.content.Context;
import com.tencent.halley.downloader.DownloaderFactory;
import java.util.List;

public final class ku
{
  public static List a(String paramString, long paramLong)
  {
    try
    {
      if (na.a() != null)
      {
        paramString = na.a().a(paramString, paramLong);
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
      Context localContext = lo.a();
      if (localContext != null) {
        return;
      }
      lo.a(paramContext, paramString1, paramString2, paramString3);
      na.a(paramContext, paramString1, paramString2, paramString3);
      DownloaderFactory.a(null);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ku
 * JD-Core Version:    0.7.0.1
 */