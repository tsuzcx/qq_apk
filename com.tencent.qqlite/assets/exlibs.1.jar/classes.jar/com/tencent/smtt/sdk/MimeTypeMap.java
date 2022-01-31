package com.tencent.smtt.sdk;

public class MimeTypeMap
{
  private static MimeTypeMap mInstance;
  private android.webkit.MimeTypeMap mSystemMimeTypeMap = android.webkit.MimeTypeMap.getSingleton();
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().mimeTypeMapGetFileExtensionFromUrl(paramString);
    }
    return android.webkit.MimeTypeMap.getFileExtensionFromUrl(paramString);
  }
  
  public static MimeTypeMap getSingleton()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new MimeTypeMap();
      }
      MimeTypeMap localMimeTypeMap = mInstance;
      return localMimeTypeMap;
    }
    finally {}
  }
  
  public String getExtensionFromMimeType(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().mimeTypeMapGetExtensionFromMimeType(paramString);
    }
    return this.mSystemMimeTypeMap.getExtensionFromMimeType(paramString);
  }
  
  public String getMimeTypeFromExtension(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().mimeTypeMapGetMimeTypeFromExtension(paramString);
    }
    return this.mSystemMimeTypeMap.getMimeTypeFromExtension(paramString);
  }
  
  public boolean hasExtension(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().mimeTypeMapHasExtension(paramString);
    }
    return this.mSystemMimeTypeMap.hasExtension(paramString);
  }
  
  public boolean hasMimeType(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().mimeTypeMapHasMimeType(paramString);
    }
    return this.mSystemMimeTypeMap.hasMimeType(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.MimeTypeMap
 * JD-Core Version:    0.7.0.1
 */