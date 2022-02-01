import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.util.concurrent.Executor;

public abstract class arxd<Param, Progress, Result>
  extends AsyncTask<Param, Progress, Result>
{
  protected String mMethodName;
  protected String mUri;
  
  public arxd(String paramString1, String paramString2)
  {
    this.mUri = paramString1;
    if (!paramString1.toLowerCase().startsWith("http")) {
      this.mUri = ("https://openmobile.qq.com/" + paramString1);
    }
    this.mMethodName = paramString2;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public Executor obtainMultiExecutor()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return AsyncTask.THREAD_POOL_EXECUTOR;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxd
 * JD-Core Version:    0.7.0.1
 */