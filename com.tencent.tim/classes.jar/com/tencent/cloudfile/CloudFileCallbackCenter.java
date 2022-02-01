package com.tencent.cloudfile;

import java.util.Map;

public abstract class CloudFileCallbackCenter
{
  public void onCreateUploadFileComplete(long paramLong, Map<String, String> paramMap) {}
  
  public void onDeleteUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void onDownloadComplete(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2) {}
  
  public void onDownloadProgress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onFeedsUpdate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2) {}
  
  public void onGetThumComplete(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void onGetUploadInfo(long paramLong, String paramString1, String paramString2, String paramString3) {}
  
  public void onInitialRecursiveRefreshFinishDir(byte[] paramArrayOfByte, long paramLong) {}
  
  public void onListUpdate(byte[] paramArrayOfByte, int paramInt, String paramString) {}
  
  public void onRecursiveRefreshFinished(int paramInt) {}
  
  public void onStartDownLoad(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2) {}
  
  public void onStartTeamDownLoad(String paramString1, String paramString2, long paramLong1, long paramLong2) {}
  
  public void onStartUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile) {}
  
  public void onStopDownload(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString) {}
  
  public void onStopTeamDownload(String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public void onStopUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void onTeamDownloadComplete(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4) {}
  
  public void onTeamDownloadProgress(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onUploadComplete(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile) {}
  
  public void onUploadProgress(byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void onUploadTotalProgress(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.cloudfile.CloudFileCallbackCenter
 * JD-Core Version:    0.7.0.1
 */