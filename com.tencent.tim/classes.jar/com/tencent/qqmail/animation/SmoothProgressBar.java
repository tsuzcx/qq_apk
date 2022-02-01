package com.tencent.qqmail.animation;

import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;

public class SmoothProgressBar
  extends ProgressBar
{
  private int duration = 10;
  private ProgressBarCallback pbcallback;
  private int schedule;
  private String tag;
  private ProgressBarWorker worker;
  
  public SmoothProgressBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public SmoothProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SmoothProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public SmoothProgressBar(Context paramContext, ProgressBarCallback paramProgressBarCallback)
  {
    super(paramContext);
    this.pbcallback = paramProgressBarCallback;
  }
  
  private static void LogPb(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("FILE", "TAG: " + paramString1 + " msg " + paramString2 + " max " + paramInt1 + " current " + paramInt2 + " schedule " + paramInt3);
  }
  
  private void executeWorker(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.worker.execute(new Integer[] { Integer.valueOf(paramInt) });
      return;
    }
    this.worker.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Integer[] { Integer.valueOf(paramInt) });
  }
  
  private void updateSchedule(int paramInt)
  {
    setSchedule(paramInt);
    if (this.pbcallback != null) {
      this.pbcallback.handleSchedule(paramInt);
    }
  }
  
  public void cancelPb()
  {
    if (this.worker != null) {
      this.worker.cancel(true);
    }
  }
  
  public CharSequence getContentDescription()
  {
    return getContext().getString(2131691028) + getContext().getString(2131720845) + getProgress() * 100 / getMax();
  }
  
  public int getSchedule()
  {
    return this.schedule;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setPbCallback(ProgressBarCallback paramProgressBarCallback)
  {
    this.pbcallback = paramProgressBarCallback;
    setProgress(paramProgressBarCallback.getProgress());
    paramProgressBarCallback.setCode(hashCode());
  }
  
  public void setProgressSmooth(int paramInt, boolean paramBoolean)
  {
    updateSchedule(paramInt);
    if ((paramBoolean) && (this.worker != null)) {
      while (this.worker.getStatus() != AsyncTask.Status.FINISHED) {
        try
        {
          Thread.sleep(5L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    if (this.worker == null)
    {
      this.worker = new ProgressBarWorker(this, this.pbcallback);
      this.worker.setSchedule(paramInt);
      executeWorker(paramInt);
      Log.d("FAN", "new worker max " + getMax() + " progress " + getProgress() + " addr " + hashCode() + " schedule " + this.worker.getSchedule() + " name " + getTag());
    }
    do
    {
      return;
      if (this.worker.getStatus() == AsyncTask.Status.RUNNING)
      {
        this.worker.setSchedule(paramInt);
        Log.d("FAN", "set schedule running max " + getMax() + " progress " + getProgress() + " addr " + hashCode() + " pbprogress " + this.pbcallback.getProgress() + " inprogress " + paramInt + " schedule " + this.worker.getSchedule() + " name " + getTag());
      }
      if (this.worker.getStatus() == AsyncTask.Status.PENDING)
      {
        this.worker.setSchedule(paramInt);
        executeWorker(paramInt);
        Log.d("FAN", "set schedule pending max " + getMax() + " progress " + getProgress() + " addr " + hashCode() + " pbprogress " + this.pbcallback.getProgress() + " inprogress " + paramInt + " schedule " + this.worker.getSchedule() + " name " + getTag());
        return;
      }
    } while (this.worker.getStatus() != AsyncTask.Status.FINISHED);
    this.worker = null;
    this.worker = new ProgressBarWorker(this, this.pbcallback);
    this.worker.setSchedule(paramInt);
    executeWorker(paramInt);
    Log.d("FAN", "set schedule finish max " + getMax() + " progress " + getProgress() + " addr " + hashCode() + " pbprogress " + this.pbcallback.getProgress() + " inprogress " + paramInt + " schedule " + this.worker.getSchedule() + " name " + getTag());
  }
  
  public void setSchedule(int paramInt)
  {
    this.schedule = paramInt;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  class ProgressBarWorker
    extends AsyncTask<Integer, Integer, Integer>
  {
    private ProgressBarCallback pbcallback;
    private SmoothProgressBar progressBar;
    private int schedule;
    private String tag;
    
    public ProgressBarWorker(SmoothProgressBar paramSmoothProgressBar, ProgressBarCallback paramProgressBarCallback)
    {
      this.progressBar = paramSmoothProgressBar;
      this.pbcallback = paramProgressBarCallback;
      this.progressBar.setProgress(this.pbcallback.getProgress());
      if (paramProgressBarCallback != null) {}
      for (this$1 = paramProgressBarCallback.getTag();; this$1 = "")
      {
        this.tag = SmoothProgressBar.this;
        return;
      }
    }
    
    private boolean isNeedSchedule()
    {
      int j;
      if (this.pbcallback != null) {
        j = this.pbcallback.getProgress();
      }
      for (int i = getSchedule(); isScheduleComplete(j, i) == true; i = this.progressBar.getSchedule())
      {
        return false;
        j = this.progressBar.getProgress();
      }
      return true;
    }
    
    private boolean isScheduleComplete(int paramInt1, int paramInt2)
    {
      return (paramInt1 >= paramInt2) || (paramInt2 <= 0);
    }
    
    private boolean isTouchMax(int paramInt)
    {
      return paramInt >= this.progressBar.getMax();
    }
    
    protected Integer doInBackground(Integer... paramVarArgs)
    {
      Log.d("FBN", "do in background");
      this.schedule = paramVarArgs[0].intValue();
      Log.d("FAN", "beg-proc progress " + this.progressBar.getProgress() + " schedule " + this.schedule + " addr " + this.progressBar.hashCode() + " name " + this.progressBar.getTag());
      while ((isNeedSchedule()) && (!isCancelled()) && (this.progressBar.hashCode() == this.pbcallback.getCode()))
      {
        if (getSchedule() > 0)
        {
          this.progressBar.incrementProgressBy(1);
          if (this.pbcallback != null)
          {
            this.pbcallback.handleProgress(this.progressBar.getProgress());
            this.pbcallback.setProgress(this.progressBar.getProgress());
          }
        }
        try
        {
          Thread.sleep(SmoothProgressBar.this.duration);
        }
        catch (InterruptedException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
      }
      Log.d("FAN", "fini-proc progress " + this.progressBar.getProgress() + " schedule " + this.progressBar.getSchedule() + " this.schedule " + this.schedule + " addr " + this.progressBar.hashCode() + " name " + this.progressBar.getTag());
      return Integer.valueOf(this.progressBar.getProgress());
    }
    
    public int getSchedule()
    {
      return this.schedule;
    }
    
    protected void onCancelled()
    {
      super.onCancelled();
    }
    
    protected void onCancelled(Integer paramInteger)
    {
      super.onCancelled(paramInteger);
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      if ((this.pbcallback != null) && (isTouchMax(paramInteger.intValue())))
      {
        this.pbcallback.handleComplete(paramInteger.intValue());
        Log.e("yahuang", "Ftn-debug handle complete progress " + this.progressBar.getProgress() + " schedule " + this.progressBar.getSchedule() + " addr " + this.progressBar.hashCode() + " name " + this.progressBar.getTag());
      }
      for (;;)
      {
        super.onPostExecute(paramInteger);
        SmoothProgressBar.LogPb(this.tag, " onPostExecute ", this.progressBar.getMax(), this.progressBar.getProgress(), this.schedule);
        return;
        Log.d("FAN", "handle no complete progress " + this.progressBar.getProgress() + " schedule " + this.progressBar.getSchedule() + " addr " + this.progressBar.hashCode());
        if (this.pbcallback == null) {
          Log.d("FILE", "onPostExecute pbcallback is null");
        } else {
          Log.d("FILE", "onPostExecute not touch max result " + paramInteger + " max " + this.progressBar.getMax());
        }
      }
    }
    
    protected void onPreExecute()
    {
      if (this.pbcallback != null)
      {
        this.pbcallback.handleBefore();
        this.progressBar.setProgress(this.pbcallback.getProgress());
      }
      super.onPreExecute();
      SmoothProgressBar.LogPb(this.tag, " onPreExecute ", this.progressBar.getMax(), this.progressBar.getProgress(), this.schedule);
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      super.onProgressUpdate(paramVarArgs);
    }
    
    public void setSchedule(int paramInt)
    {
      this.schedule = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.SmoothProgressBar
 * JD-Core Version:    0.7.0.1
 */