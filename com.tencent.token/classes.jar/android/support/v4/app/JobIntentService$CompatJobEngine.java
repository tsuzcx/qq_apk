package android.support.v4.app;

import android.os.IBinder;

abstract interface JobIntentService$CompatJobEngine
{
  public abstract IBinder compatGetBinder();
  
  public abstract JobIntentService.GenericWorkItem dequeueWork();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.JobIntentService.CompatJobEngine
 * JD-Core Version:    0.7.0.1
 */