package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public final class AsyncLayoutInflater
{
  private static final String TAG = "AsyncLayoutInflater";
  Handler mHandler;
  private Handler.Callback mHandlerCallback = new AsyncLayoutInflater.1(this);
  AsyncLayoutInflater.InflateThread mInflateThread;
  LayoutInflater mInflater;
  
  public AsyncLayoutInflater(@NonNull Context paramContext)
  {
    this.mInflater = new AsyncLayoutInflater.BasicInflater(paramContext);
    this.mHandler = new Handler(this.mHandlerCallback);
    this.mInflateThread = AsyncLayoutInflater.InflateThread.getInstance();
  }
  
  @UiThread
  public void inflate(@LayoutRes int paramInt, @Nullable ViewGroup paramViewGroup, @NonNull AsyncLayoutInflater.OnInflateFinishedListener paramOnInflateFinishedListener)
  {
    if (paramOnInflateFinishedListener == null) {
      throw new NullPointerException("callback argument may not be null!");
    }
    AsyncLayoutInflater.InflateRequest localInflateRequest = this.mInflateThread.obtainRequest();
    localInflateRequest.inflater = this;
    localInflateRequest.resid = paramInt;
    localInflateRequest.parent = paramViewGroup;
    localInflateRequest.callback = paramOnInflateFinishedListener;
    this.mInflateThread.enqueue(localInflateRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.AsyncLayoutInflater
 * JD-Core Version:    0.7.0.1
 */