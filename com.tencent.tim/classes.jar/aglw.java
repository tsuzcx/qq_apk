import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.1;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.2;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class aglw
{
  private List<aglw.a> Bi = new ArrayList();
  private List<String> Bj = new ArrayList();
  private LinkedHashMap<String, aglw.a> ac = new LinkedHashMap();
  private agla.a b = new aglx(this);
  private Handler cQ;
  private QQAppInterface mAppInterface;
  
  public aglw(QQAppInterface paramQQAppInterface)
  {
    this.mAppInterface = paramQQAppInterface;
    this.cQ = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private void IS(String paramString)
  {
    this.cQ.post(new ThumbDownloadManager.2(this, paramString));
  }
  
  private void IT(String paramString)
  {
    this.ac.remove(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ThumbDownloadManager", 2, "removeDownloadingTask : MapDowloadingTask currentSize[" + this.ac.size() + "]");
    }
  }
  
  private void IU(String paramString)
  {
    if (!this.Bj.remove(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.i("ThumbDownloadManager", 2, "removeDownloadingList : ListDownloadTask remove task fail, thumbUrl[" + paramString + "]");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("ThumbDownloadManager", 2, "removeDownloadingList : ListDownloadTask currentSize[" + this.Bj.size() + "]");
  }
  
  private void a(aglw.a parama)
  {
    if (parama == null) {}
    do
    {
      return;
      this.ac.put(parama.thumbUrl, parama);
    } while (!QLog.isColorLevel());
    QLog.i("ThumbDownloadManager", 2, "addDownloadingTask : MapDowloadingTask currentSize[" + this.ac.size() + "]");
  }
  
  private boolean aW(String paramString1, String paramString2)
  {
    if (this.Bj.contains(paramString2)) {}
    while (ahbj.fileExistsAndNotEmpty(paramString1)) {
      return false;
    }
    return true;
  }
  
  private void b(aglw.a parama)
  {
    if (parama == null) {
      return;
    }
    new agla(this.mAppInterface).a(parama.Za, parama.thumbPath, parama.thumbUrl, this.b);
  }
  
  private boolean c(long paramLong, String paramString1, String paramString2)
  {
    paramString2 = ahav.lc(paramString2);
    if (!aW(paramString1, paramString2)) {
      return false;
    }
    aglw.a locala = new aglw.a();
    locala.thumbPath = paramString1;
    locala.thumbUrl = paramString2;
    locala.Za = paramLong;
    this.Bj.add(paramString2);
    this.Bi.add(locala);
    return true;
  }
  
  private void dif()
  {
    this.cQ.post(new ThumbDownloadManager.3(this));
  }
  
  public void q(long paramLong, String paramString1, String paramString2)
  {
    this.cQ.post(new ThumbDownloadManager.1(this, paramLong, paramString1, paramString2));
  }
  
  public static class a
  {
    long Za;
    String thumbPath;
    String thumbUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aglw
 * JD-Core Version:    0.7.0.1
 */