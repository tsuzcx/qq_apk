package com.tencent.mobileqq.mini.network.http;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestTask$1
  extends HttpCallBack
{
  RequestTask$1(RequestTask paramRequestTask) {}
  
  public void headersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    if (RequestTask.access$000(this.this$0).mCallback != null) {
      RequestTask.access$000(this.this$0).mCallback.headersReceived(paramInt, paramMap);
    }
  }
  
  public void httpCallBack(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    if ((!this.this$0.mIsAbort.get()) && (paramArrayOfByte != null)) {
      if (RequestTask.access$000(this.this$0).mCallback != null)
      {
        RequestTask.access$000(this.this$0).mCallback.httpCallBack(paramInt, paramArrayOfByte, paramMap);
        WxRequest.removeTaskInMap(RequestTask.access$000(this.this$0).mTaskId);
      }
    }
    do
    {
      return;
      if (this.this$0.mIsAbort.get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("RequestTask", 2, "[run] abort");
        }
        RequestTask.access$000(this.this$0).mCallback.httpCallBack(-5, paramArrayOfByte, paramMap);
        return;
      }
    } while (RequestTask.access$000(this.this$0).mCallback == null);
    RequestTask.access$000(this.this$0).mCallback.httpCallBack(paramInt, null, paramMap);
    WxRequest.removeTaskInMap(RequestTask.access$000(this.this$0).mTaskId);
  }
  
  public void onProgressUpdate(int paramInt1, int paramInt2, int paramInt3)
  {
    if (RequestTask.access$000(this.this$0).mCallback != null) {
      RequestTask.access$000(this.this$0).mCallback.onProgressUpdate(paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.RequestTask.1
 * JD-Core Version:    0.7.0.1
 */