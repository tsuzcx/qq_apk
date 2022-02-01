package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.utilities.QMWeakReference;
import java.util.List;
import java.util.Map;

public class QMCallback
{
  private IBeforeSendCallback onBeforeSend;
  private ICompleteCallback onComplete;
  private IErrorCallback onError;
  private IReceiveDataCallback onReceiveData;
  private IReceiveHeaderCallback onReceiveHeader;
  private ISendDataCallback onSendData;
  private ISuccessCallback onSuccess;
  
  public QMCallback() {}
  
  public QMCallback(QMCallback paramQMCallback)
  {
    if (paramQMCallback != null)
    {
      this.onBeforeSend = paramQMCallback.onBeforeSend;
      this.onComplete = paramQMCallback.onComplete;
      this.onReceiveData = paramQMCallback.onReceiveData;
      this.onSendData = paramQMCallback.onSendData;
      this.onError = paramQMCallback.onError;
      this.onSuccess = paramQMCallback.onSuccess;
      this.onReceiveHeader = paramQMCallback.onReceiveHeader;
    }
  }
  
  public void handleBeforeSend(QMNetworkRequest paramQMNetworkRequest)
  {
    if (this.onBeforeSend != null) {
      this.onBeforeSend.run(paramQMNetworkRequest);
    }
  }
  
  public void handleComplete(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if (this.onComplete != null) {
      this.onComplete.run(paramQMNetworkRequest, paramQMNetworkResponse, paramQMNetworkError);
    }
  }
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if (this.onError != null) {
      this.onError.run(paramQMNetworkRequest, paramQMNetworkResponse, paramQMNetworkError);
    }
  }
  
  public void handleReceiveData(QMNetworkRequest paramQMNetworkRequest, byte[] paramArrayOfByte, int paramInt, Long paramLong)
  {
    if (this.onReceiveData != null) {
      this.onReceiveData.run(paramQMNetworkRequest, paramArrayOfByte, paramInt, paramLong);
    }
  }
  
  public void handleReceiveHeader(QMNetworkRequest paramQMNetworkRequest, Map<String, List<String>> paramMap)
  {
    if (this.onReceiveHeader != null) {
      this.onReceiveHeader.run(paramQMNetworkRequest, paramMap);
    }
  }
  
  public void handleSendData(QMNetworkRequest paramQMNetworkRequest, long paramLong1, long paramLong2)
  {
    if (this.onSendData != null) {
      this.onSendData.run(paramQMNetworkRequest, Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    }
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if (this.onSuccess != null) {
      this.onSuccess.run(paramQMNetworkRequest, paramQMNetworkResponse);
    }
  }
  
  public void setOnBeforeSend(IBeforeSendCallback paramIBeforeSendCallback)
  {
    this.onBeforeSend = paramIBeforeSendCallback;
  }
  
  public void setOnComplete(ICompleteCallback paramICompleteCallback)
  {
    this.onComplete = paramICompleteCallback;
  }
  
  public void setOnError(IErrorCallback paramIErrorCallback)
  {
    this.onError = paramIErrorCallback;
  }
  
  public void setOnReceiveData(IReceiveDataCallback paramIReceiveDataCallback)
  {
    this.onReceiveData = paramIReceiveDataCallback;
  }
  
  public void setOnReceiveHeader(IReceiveHeaderCallback paramIReceiveHeaderCallback)
  {
    this.onReceiveHeader = paramIReceiveHeaderCallback;
  }
  
  public void setOnSendData(ISendDataCallback paramISendDataCallback)
  {
    this.onSendData = paramISendDataCallback;
  }
  
  public void setOnSuccess(ISuccessCallback paramISuccessCallback)
  {
    this.onSuccess = paramISuccessCallback;
  }
  
  public static abstract class ErrorCallbackWeakRef<T>
    extends QMWeakReference<T>
    implements QMCallback.IErrorCallback
  {
    public ErrorCallbackWeakRef(T paramT)
    {
      super();
    }
  }
  
  public static abstract interface IBeforeSendCallback
  {
    public abstract void run(QMNetworkRequest paramQMNetworkRequest);
  }
  
  public static abstract interface ICompleteCallback
  {
    public abstract void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError);
  }
  
  public static abstract interface IErrorCallback
  {
    public abstract void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError);
  }
  
  public static abstract interface IReceiveDataCallback
  {
    public abstract void run(QMNetworkRequest paramQMNetworkRequest, byte[] paramArrayOfByte, int paramInt, Long paramLong);
  }
  
  public static abstract interface IReceiveHeaderCallback
  {
    public abstract void run(QMNetworkRequest paramQMNetworkRequest, Map<String, List<String>> paramMap);
  }
  
  public static abstract interface ISendDataCallback
  {
    public abstract void run(QMNetworkRequest paramQMNetworkRequest, Long paramLong1, Long paramLong2);
  }
  
  public static abstract interface ISuccessCallback
  {
    public abstract void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse);
  }
  
  public static abstract class SuccessCallbackWeakRef<T>
    extends QMWeakReference<T>
    implements QMCallback.ISuccessCallback
  {
    public SuccessCallbackWeakRef(T paramT)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMCallback
 * JD-Core Version:    0.7.0.1
 */