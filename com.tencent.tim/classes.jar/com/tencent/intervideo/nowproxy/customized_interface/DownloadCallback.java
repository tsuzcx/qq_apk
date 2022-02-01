package com.tencent.intervideo.nowproxy.customized_interface;

public abstract interface DownloadCallback
{
  public abstract void onDownloadCancel();
  
  public abstract void onDownloadError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onDownloadSuccess(String paramString);
  
  public abstract void onProgress(int paramInt1, int paramInt2);
  
  public static abstract interface ErrorCode
  {
    public static final int CODE_ERR_EXEPTION = -102;
    public static final int CODE_ERR_INSUFFICENT_SPACE = -101;
    public static final int CODE_ERR_NETWORK_NOT_AVALIBLE = -100;
    public static final int CODE_ERR_OTHER = -103;
    public static final int CODE_SUCCESS = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback
 * JD-Core Version:    0.7.0.1
 */