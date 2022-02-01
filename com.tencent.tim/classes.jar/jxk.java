import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class jxk
  implements URLDrawable.DownloadListener
{
  jxk(jxj paramjxj) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)jxj.a(this.b).get(0);
      jxj.a(this.b).remove(0);
      if (jxj.b(this.b) != null)
      {
        if (!jxj.b(this.b).contains(str)) {
          break label119;
        }
        jxj.b(this.b).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        jxj.a(this.b, null);
        jxj.a(this.b);
        return;
        jxj.a(this.b).add(str);
        jxj.b(this.b).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)jxj.a(this.b).get(0);
      jxj.a(this.b).remove(0);
      if ((jxj.b(this.b) != null) && (jxj.b(this.b).contains(str))) {
        jxj.b(this.b).remove(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      jxj.a(this.b, null);
      jxj.a(this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxk
 * JD-Core Version:    0.7.0.1
 */