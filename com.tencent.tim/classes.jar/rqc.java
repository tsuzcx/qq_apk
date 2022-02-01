import java.io.File;
import java.util.ArrayList;

class rqc
  extends rpz
{
  rqc(rqa paramrqa, rqi paramrqi, File paramFile) {}
  
  public void onFailure(String paramString)
  {
    this.a.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.J.exists()) {
      this.J.delete();
    }
    int i = 0;
    while (i < this.this$0.nJ.size())
    {
      File localFile = new File((String)this.this$0.nJ.get(i));
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    this.this$0.nJ = new ArrayList();
    this.a.onFinish(paramBoolean);
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
 * Qualified Name:     rqc
 * JD-Core Version:    0.7.0.1
 */