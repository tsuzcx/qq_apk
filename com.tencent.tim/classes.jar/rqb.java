import java.util.ArrayList;

class rqb
  extends rpz
{
  rqb(rqa paramrqa, rqi paramrqi) {}
  
  public void onFailure(String paramString)
  {
    this.a.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    rqa localrqa;
    if (this.this$0.mA.size() == 0)
    {
      localrqa = this.this$0;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localrqa.bub = i;
      rqa.b = null;
      this.a.onFinish(paramBoolean);
      return;
    }
  }
  
  public void onProgress(String paramString)
  {
    this.a.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.a.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.a.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqb
 * JD-Core Version:    0.7.0.1
 */