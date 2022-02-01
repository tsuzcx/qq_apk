import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class atee
  implements URLDrawable.DownloadListener
{
  atee(ated paramated, String paramString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (!ated.a(this.b).contains(this.val$url))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileGridAdapter", 2, "onFileDownloadFailed url: " + this.val$url);
      }
      ated.a(this.b).add(this.val$url);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atee
 * JD-Core Version:    0.7.0.1
 */