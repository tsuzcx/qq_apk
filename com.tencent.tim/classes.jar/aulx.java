import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class aulx
  implements URLDrawable.DownloadListener
{
  aulx(aulw paramaulw, String paramString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (!aulw.a(this.a).contains(this.val$url))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupPadTemplateAdapter", 2, "onFileDownloadFailed url: " + this.val$url);
      }
      aulw.a(this.a).add(this.val$url);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulx
 * JD-Core Version:    0.7.0.1
 */