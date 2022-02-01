package com.tencent.component.network.downloader;

import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;

public abstract class UrlKeyGenerator
{
  public static final UrlKeyGenerator GENERATOR_DESPITE_DOMAIN = new GeneratorDespiteDomain(null);
  public static final UrlKeyGenerator GENERATOR_DESPITE_HASH = new GeneratorDespiteHash(null);
  private static final String HTTPS_PREFIX = "https://";
  private static final String HTTP_PREFIX = "http://";
  
  private static boolean startsWithIgnoreCase(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.regionMatches(true, 0, paramString2, 0, paramString2.length());
  }
  
  public final String doGenerate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!NetworkUtils.isNetworkUrl(paramString)) {
      return paramString;
    }
    return generate(paramString);
  }
  
  public abstract String generate(String paramString);
  
  static class GeneratorDespiteDomain
    extends UrlKeyGenerator
  {
    public String generate(String paramString)
    {
      String str = null;
      int i;
      if (UrlKeyGenerator.startsWithIgnoreCase(paramString, "http://")) {
        i = paramString.indexOf("/", "http://".length());
      }
      for (;;)
      {
        if (i != -1) {
          str = paramString.substring(i);
        }
        return str;
        if (UrlKeyGenerator.startsWithIgnoreCase(paramString, "https://")) {
          i = paramString.indexOf("/", "https://".length());
        } else {
          i = paramString.indexOf("/");
        }
      }
    }
  }
  
  static class GeneratorDespiteHash
    extends UrlKeyGenerator.GeneratorDespiteDomain
  {
    private GeneratorDespiteHash()
    {
      super();
    }
    
    public String generate(String paramString)
    {
      paramString = super.generate(paramString);
      if (TextUtils.isEmpty(paramString)) {}
      int i;
      do
      {
        return paramString;
        i = paramString.indexOf('#');
      } while (i <= 0);
      return paramString.substring(0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.UrlKeyGenerator
 * JD-Core Version:    0.7.0.1
 */