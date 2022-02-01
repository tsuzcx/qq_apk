import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.ThumbDownloadManager.1;
import com.tencent.tim.filemanager.core.ThumbDownloadManager.2;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class atuo
{
  private static atuo a = new atuo();
  private List<atuo.a> Bi = new ArrayList();
  private List<String> Bj = new ArrayList();
  private LinkedHashMap<String, atuo.a> ac = new LinkedHashMap();
  private attw.a b = new atup(this);
  private Handler cQ = new Handler(ThreadManager.getSubThreadLooper());
  private QQAppInterface mAppInterface;
  
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
  
  public static atuo a(QQAppInterface paramQQAppInterface)
  {
    a.mAppInterface = paramQQAppInterface;
    return a;
  }
  
  private void a(atuo.a parama)
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
    while (aueh.fileExistsAndNotEmpty(paramString1)) {
      return false;
    }
    return true;
  }
  
  private void b(atuo.a parama)
  {
    if (parama == null) {
      return;
    }
    new attw(this.mAppInterface).a(parama.Za, parama.thumbPath, parama.thumbUrl, this.b);
  }
  
  private boolean c(long paramLong, String paramString1, String paramString2)
  {
    paramString2 = audx.lc(paramString2);
    if (!aW(paramString1, paramString2)) {
      return false;
    }
    atuo.a locala = new atuo.a();
    locala.thumbPath = paramString1;
    locala.thumbUrl = paramString2;
    locala.Za = paramLong;
    this.Bj.add(paramString2);
    this.Bi.add(locala);
    return true;
  }
  
  private void dif()
  {
    if (this.ac.size() >= 8) {}
    while (this.Bi.size() == 0) {
      return;
    }
    atuo.a locala = (atuo.a)this.Bi.get(0);
    if (locala == null)
    {
      this.Bi.remove(0);
      dif();
      return;
    }
    this.Bi.remove(locala);
    a(locala);
    b(locala);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atuo
 * JD-Core Version:    0.7.0.1
 */