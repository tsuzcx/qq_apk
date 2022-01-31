package android.support.v4.app;

import android.os.AsyncTask;

final class JobIntentService$CommandProcessor
  extends AsyncTask
{
  JobIntentService$CommandProcessor(JobIntentService paramJobIntentService) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    for (;;)
    {
      paramVarArgs = this.this$0.dequeueWork();
      if (paramVarArgs == null) {
        break;
      }
      this.this$0.onHandleWork(paramVarArgs.getIntent());
      paramVarArgs.complete();
    }
    return null;
  }
  
  protected void onCancelled(Void paramVoid)
  {
    this.this$0.processorFinished();
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    this.this$0.processorFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.JobIntentService.CommandProcessor
 * JD-Core Version:    0.7.0.1
 */