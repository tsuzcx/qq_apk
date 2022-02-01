package com.tencent.smtt.sdk;

public class MimeTypeMap
{
  private static MimeTypeMap a;
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().h(paramString);
    }
    return android.webkit.MimeTypeMap.getFileExtensionFromUrl(paramString);
  }
  
  public static MimeTypeMap getSingleton()
  {
    try
    {
      if (a == null) {
        a = new MimeTypeMap();
      }
      MimeTypeMap localMimeTypeMap = a;
      return localMimeTypeMap;
    }
    finally {}
  }
  
  public String getExtensionFromMimeType(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().l(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
  }
  
  public String getMimeTypeFromExtension(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().j(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
  }
  
  public boolean hasExtension(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().k(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasExtension(paramString);
  }
  
  public boolean hasMimeType(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b())) {
      return localy.c().i(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasMimeType(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.MimeTypeMap
 * JD-Core Version:    0.7.0.1
 */