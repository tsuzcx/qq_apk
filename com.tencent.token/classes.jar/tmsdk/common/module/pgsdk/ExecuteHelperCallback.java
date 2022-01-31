package tmsdk.common.module.pgsdk;

public abstract interface ExecuteHelperCallback
{
  public abstract void onProcessHelper(int paramInt);
  
  public abstract void onStartHelper(ExecuteHelperCallback.HelperAbortCallback paramHelperAbortCallback);
  
  public abstract void onStopHelper();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.ExecuteHelperCallback
 * JD-Core Version:    0.7.0.1
 */