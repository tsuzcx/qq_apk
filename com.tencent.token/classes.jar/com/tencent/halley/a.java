package com.tencent.halley;

import android.content.Context;
import com.tencent.halley.common.f;
import com.tencent.halley.downloader.DownloaderFactory;
import com.tencent.token.al;
import com.tencent.token.ar;
import java.util.List;

public class a
{
  public static List a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (ar.a() != null)
      {
        paramString = ar.a().a(paramString, paramInt, paramLong, paramBoolean);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      label22:
      break label22;
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, List paramList, DownloaderConfig paramDownloaderConfig)
  {
    try
    {
      Context localContext = f.a();
      if (localContext != null) {
        return;
      }
      f.a(paramContext, paramString1, paramString2, paramString3);
      paramContext = ar.a(paramContext, paramString1, paramString2, paramString3);
      if (paramContext != null) {
        paramContext.a(paramList);
      }
      DownloaderFactory.a(paramDownloaderConfig);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.a
 * JD-Core Version:    0.7.0.1
 */