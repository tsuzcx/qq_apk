package com.tencent.qqmail.utilities.qmnetwork;

import androidx.annotation.NonNull;
import java.net.URI;
import java.net.URISyntaxException;

public final class QMUrlUtil
{
  public static final String URL_VIEWFILE = "/cgi-bin/viewfile";
  
  @NonNull
  public static String getHost(@NonNull String paramString)
  {
    try
    {
      String str = new URI(paramString).getHost();
      paramString = str;
      if (str.startsWith("www.")) {
        paramString = str.substring(4);
      }
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  @NonNull
  public static String getPath(@NonNull String paramString)
  {
    try
    {
      paramString = new URI(paramString).getPath();
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static boolean isViewFile(String paramString)
  {
    if (paramString != null)
    {
      if ((paramString.equals("/cgi-bin/viewfile")) || (paramString.startsWith("/cgi-bin/viewfile?"))) {}
      while (paramString.matches("https?://.*mail.qq.com/cgi-bin/viewfile(\\?.*)?$")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMUrlUtil
 * JD-Core Version:    0.7.0.1
 */