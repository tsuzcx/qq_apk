package com.tencent.qqmail.model;

public class MailManagerDelegate
{
  private BeforeSendCallback onBeforeSend;
  private EventCallback onComplete;
  private MailErrorCallback onError;
  private SendDataCallback onSendData;
  private DataCallback onSuccess;
  
  public MailManagerDelegate() {}
  
  public MailManagerDelegate(MailManagerDelegate paramMailManagerDelegate)
  {
    this.onSuccess = paramMailManagerDelegate.getOnSuccess();
    this.onBeforeSend = paramMailManagerDelegate.getOnBeforeSend();
    this.onComplete = paramMailManagerDelegate.getOnComplete();
    this.onError = paramMailManagerDelegate.getOnError();
    this.onSendData = paramMailManagerDelegate.getOnSendData();
  }
  
  public BeforeSendCallback getOnBeforeSend()
  {
    return this.onBeforeSend;
  }
  
  public EventCallback getOnComplete()
  {
    return this.onComplete;
  }
  
  public MailErrorCallback getOnError()
  {
    return this.onError;
  }
  
  public SendDataCallback getOnSendData()
  {
    return this.onSendData;
  }
  
  public DataCallback getOnSuccess()
  {
    return this.onSuccess;
  }
  
  public void handleBeforeSend(Object paramObject)
  {
    if (this.onBeforeSend != null) {
      this.onBeforeSend.run(paramObject);
    }
  }
  
  public void handleComplete(Object paramObject)
  {
    if (this.onComplete != null) {
      this.onComplete.run(paramObject);
    }
  }
  
  public void handleError(Object paramObject)
  {
    if (this.onError != null) {
      this.onError.run(paramObject);
    }
  }
  
  public void handleSendData(Long paramLong1, Long paramLong2)
  {
    if (this.onSendData != null) {
      this.onSendData.run(paramLong1, paramLong2);
    }
  }
  
  public void handleSuccess(Object paramObject1, Object paramObject2)
  {
    if (this.onSuccess != null) {
      this.onSuccess.run(paramObject1, paramObject2);
    }
  }
  
  public void setOnBeforeSend(BeforeSendCallback paramBeforeSendCallback)
  {
    this.onBeforeSend = paramBeforeSendCallback;
  }
  
  public void setOnComplete(EventCallback paramEventCallback)
  {
    this.onComplete = paramEventCallback;
  }
  
  public void setOnError(MailErrorCallback paramMailErrorCallback)
  {
    this.onError = paramMailErrorCallback;
  }
  
  public void setOnSendData(SendDataCallback paramSendDataCallback)
  {
    this.onSendData = paramSendDataCallback;
  }
  
  public void setOnSuccess(DataCallback paramDataCallback)
  {
    this.onSuccess = paramDataCallback;
  }
  
  public static abstract interface BeforeSendCallback
  {
    public abstract void run(Object paramObject);
  }
  
  public static abstract interface DataCallback
  {
    public abstract void run(Object paramObject1, Object paramObject2);
  }
  
  public static abstract interface EventCallback
  {
    public abstract void run(Object paramObject);
  }
  
  public static abstract interface MailErrorCallback
  {
    public abstract void run(Object paramObject);
  }
  
  public static abstract interface SendDataCallback
  {
    public abstract void run(Long paramLong1, Long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.MailManagerDelegate
 * JD-Core Version:    0.7.0.1
 */