public abstract interface rqi
{
  public abstract void onFailure(String paramString);
  
  public abstract void onFinish(boolean paramBoolean);
  
  public abstract void onProgress(String paramString);
  
  public abstract void onStart();
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqi
 * JD-Core Version:    0.7.0.1
 */