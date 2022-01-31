package com.pay.googlewalletsdk.http;

import android.os.Bundle;
import android.os.Message;
import com.pay.googlewaletsdk.entity.DownloadInfo;
import java.util.HashMap;

public abstract class BaseHttpResolve
  implements IHttpDownAgency
{
  private HashMap<String, BaseHttpClient> downHashMap;
  protected DownloadInfo downloadInfo;
  protected int errorCode;
  protected String errorMessage;
  protected boolean isError;
  private HttpClientHandle mainHandler;
  
  public BaseHttpResolve(HttpClientHandle paramHttpClientHandle, HashMap<String, BaseHttpClient> paramHashMap)
  {
    this.mainHandler = paramHttpClientHandle;
    this.downHashMap = paramHashMap;
  }
  
  private void sendDownLoadMessage(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    Message localMessage = this.mainHandler.obtainMessage();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    localMessage.obj = this;
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("bytes", paramArrayOfByte);
    localBundle.putLong("downsize", paramLong);
    localMessage.setData(localBundle);
    this.mainHandler.sendMessage(localMessage);
  }
  
  private void sendErrorMessage()
  {
    Message localMessage = this.mainHandler.obtainMessage();
    localMessage.what = 4;
    localMessage.obj = this;
    this.mainHandler.sendMessage(localMessage);
  }
  
  private void sendFinishMessage(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = this.mainHandler.obtainMessage();
    paramArrayOfByte.what = 3;
    paramArrayOfByte.obj = this;
    this.mainHandler.sendMessage(paramArrayOfByte);
  }
  
  private void sendPause()
  {
    Message localMessage = this.mainHandler.obtainMessage();
    localMessage.what = 5;
    localMessage.obj = this;
    this.mainHandler.sendMessage(localMessage);
  }
  
  private void sendReadyMessage()
  {
    Message localMessage = this.mainHandler.obtainMessage();
    localMessage.what = 0;
    localMessage.obj = this;
    this.mainHandler.sendMessage(localMessage);
  }
  
  private void sendStartMessage()
  {
    Message localMessage = this.mainHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this;
    this.mainHandler.sendMessage(localMessage);
  }
  
  private void sendStopMessage()
  {
    Message localMessage = this.mainHandler.obtainMessage();
    localMessage.what = 6;
    localMessage.obj = this;
    this.mainHandler.sendMessage(localMessage);
  }
  
  public DownloadInfo getDownloadInfo()
  {
    return this.downloadInfo;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public boolean isError()
  {
    return this.isError;
  }
  
  public void onDownLoading(byte[] paramArrayOfByte, int paramInt, long paramLong, BaseHttpClient paramBaseHttpClient)
  {
    onDownLoadingResolve(paramArrayOfByte, paramInt, paramLong, paramBaseHttpClient);
    sendDownLoadMessage(paramArrayOfByte, paramInt, paramLong);
  }
  
  public abstract void onDownLoadingResolve(byte[] paramArrayOfByte, int paramInt, long paramLong, BaseHttpClient paramBaseHttpClient);
  
  public void onError(BaseHttpClient paramBaseHttpClient)
  {
    unRegister(paramBaseHttpClient.getDownloadInfo().getKey());
    onErrorResolve();
    sendErrorMessage();
  }
  
  public abstract void onErrorResolve();
  
  public void onFinish(BaseHttpClient paramBaseHttpClient)
  {
    unRegister(paramBaseHttpClient.getDownloadInfo().getKey());
    onFinishresolve(paramBaseHttpClient.getContent());
    sendFinishMessage(paramBaseHttpClient.getContent());
  }
  
  public abstract void onFinishresolve(byte[] paramArrayOfByte);
  
  public void onPause(BaseHttpClient paramBaseHttpClient)
  {
    unRegister(paramBaseHttpClient.getDownloadInfo().getKey());
    onPauseResolve();
    sendPause();
  }
  
  public abstract void onPauseResolve();
  
  public void onReady(BaseHttpClient paramBaseHttpClient)
  {
    onReadyRegister(paramBaseHttpClient);
    onReadyResolve();
    sendReadyMessage();
  }
  
  protected void onReadyRegister(BaseHttpClient paramBaseHttpClient)
  {
    this.downloadInfo = paramBaseHttpClient.getDownloadInfo();
    this.downHashMap.put(this.downloadInfo.getKey(), paramBaseHttpClient);
  }
  
  public abstract void onReadyResolve();
  
  public void onStart(BaseHttpClient paramBaseHttpClient)
  {
    onStartResolve();
    sendStartMessage();
  }
  
  public abstract void onStartResolve();
  
  public void onStop(BaseHttpClient paramBaseHttpClient)
  {
    unRegister(paramBaseHttpClient.getDownloadInfo().getKey());
    onStopResolve();
    sendStopMessage();
  }
  
  public abstract void onStopResolve();
  
  public void setDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    this.downloadInfo = paramDownloadInfo;
  }
  
  public void setError(boolean paramBoolean)
  {
    this.isError = paramBoolean;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorMessage(String paramString)
  {
    this.errorMessage = paramString;
  }
  
  public void unRegister(String paramString)
  {
    this.downHashMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.http.BaseHttpResolve
 * JD-Core Version:    0.7.0.1
 */