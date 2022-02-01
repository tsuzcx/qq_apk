package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteEvent;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteListener;
import java.io.IOException;
import javax.net.ssl.HttpsURLConnection;

class QAPMHttpsURLConnectionExtension$1
  implements QAPMStreamCompleteListener
{
  QAPMHttpsURLConnectionExtension$1(QAPMHttpsURLConnectionExtension paramQAPMHttpsURLConnectionExtension, QAPMTransactionState paramQAPMTransactionState) {}
  
  public void streamComplete(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    int i;
    if (!this.val$state.isComplete()) {
      i = 0;
    }
    try
    {
      int j = QAPMHttpsURLConnectionExtension.access$000(this.this$0).getResponseCode();
      i = j;
      this.val$state.setStatusCode(j);
      i = j;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        long l1;
        long l2;
      }
    }
    l1 = paramQAPMStreamCompleteEvent.getBytes();
    if (i != 206)
    {
      l2 = QAPMHttpsURLConnectionExtension.access$000(this.this$0).getContentLength();
      if (l2 >= 0L) {
        l1 = l2;
      }
      for (;;)
      {
        this.val$state.setBytesReceived(l1);
        QAPMHttpsURLConnectionExtension.access$200(this.this$0, this.val$state);
        return;
      }
    }
  }
  
  public void streamError(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    try
    {
      int i = QAPMHttpsURLConnectionExtension.access$000(this.this$0).getResponseCode();
      this.val$state.setStatusCode(i);
      label19:
      if (!this.val$state.isComplete()) {
        this.val$state.setBytesReceived(paramQAPMStreamCompleteEvent.getBytes());
      }
      QAPMHttpsURLConnectionExtension.access$100(this.this$0, paramQAPMStreamCompleteEvent.getException());
      return;
    }
    catch (IOException localIOException)
    {
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMHttpsURLConnectionExtension.1
 * JD-Core Version:    0.7.0.1
 */