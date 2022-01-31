package android.support.v4.view;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;

class AsyncLayoutInflater$1
  implements Handler.Callback
{
  AsyncLayoutInflater$1(AsyncLayoutInflater paramAsyncLayoutInflater) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = (AsyncLayoutInflater.InflateRequest)paramMessage.obj;
    if (paramMessage.view == null) {
      paramMessage.view = this.this$0.mInflater.inflate(paramMessage.resid, paramMessage.parent, false);
    }
    paramMessage.callback.onInflateFinished(paramMessage.view, paramMessage.resid, paramMessage.parent);
    this.this$0.mInflateThread.releaseRequest(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.AsyncLayoutInflater.1
 * JD-Core Version:    0.7.0.1
 */