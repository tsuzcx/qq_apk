public class rpz
  implements rqi
{
  public long Cp;
  
  public void onFailure(String paramString) {}
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    this.Cp = System.currentTimeMillis();
  }
  
  public void onSuccess(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpz
 * JD-Core Version:    0.7.0.1
 */