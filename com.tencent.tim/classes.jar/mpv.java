import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.image.URLDrawable.DownloadListener;

public class mpv
  extends AsyncTask<Void, Void, Boolean>
{
  private URLDrawable.DownloadListener b;
  private Bitmap bitmap;
  private String path;
  
  public mpv(Bitmap paramBitmap, String paramString)
  {
    this.bitmap = paramBitmap;
    this.path = paramString;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    return Boolean.valueOf(rop.d(this.bitmap, this.path));
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if (this.b == null) {
      return;
    }
    if (paramBoolean.booleanValue())
    {
      this.b.onFileDownloadSucceed(0L);
      return;
    }
    this.b.onFileDownloadFailed(0);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.b != null) {
      this.b.onFileDownloadStarted();
    }
  }
  
  public void setDownloadListener(URLDrawable.DownloadListener paramDownloadListener)
  {
    this.b = paramDownloadListener;
  }
  
  public void startDownload()
  {
    executeOnExecutor(acmo.a(64), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpv
 * JD-Core Version:    0.7.0.1
 */