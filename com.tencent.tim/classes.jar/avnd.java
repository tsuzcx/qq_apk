import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qqreader.js.JsCallParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class avnd
{
  private static long azJ;
  private List<avnd.a> LF = new ArrayList();
  private avna b;
  private avmc.a c = new avne(this);
  private Handler mHandler = new avnf(this, Looper.getMainLooper());
  
  avnd(avna paramavna)
  {
    this.b = paramavna;
  }
  
  private boolean cq(String paramString1, String paramString2)
  {
    return (("JSbookshelf".equals(paramString1)) && ("kvStorageGet".equals(paramString2)) && (!this.b.aKL())) || (("JSbookshelf".equals(paramString1)) && ("reportParams".equals(paramString2)));
  }
  
  private void eAZ()
  {
    this.mHandler.removeMessages(100001);
    eBa();
  }
  
  private void eBa()
  {
    Iterator localIterator = this.LF.iterator();
    while (localIterator.hasNext())
    {
      avnd.a locala = (avnd.a)localIterator.next();
      if (!locala.aKM()) {
        this.b.c(locala.b.getUrl(), locala.b.getPkgName(), locala.b.getMethod(), locala.b.getArgs());
      }
    }
    this.LF.clear();
  }
  
  private void eBb()
  {
    Iterator localIterator = this.LF.iterator();
    while (localIterator.hasNext())
    {
      avnd.a locala = (avnd.a)localIterator.next();
      if (locala.aKM())
      {
        if (!cq(locala.b.getPkgName(), locala.b.getMethod())) {
          eBc();
        }
        localIterator.remove();
      }
    }
  }
  
  private void eBc()
  {
    long l = System.currentTimeMillis();
    if (l - azJ > 5000L)
    {
      azJ = l;
      QQToast.a(BaseApplicationImpl.getApplication(), "插件正在加载中，请稍候...", 0).show();
    }
  }
  
  private void eBd()
  {
    if (!avmc.a().aKJ()) {
      avmc.a().a(this.c);
    }
  }
  
  void e(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString1 = new avnd.a(paramString1, paramString2, paramString3, 3000L, paramVarArgs);
    paramString2 = this.LF.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (avnd.a)paramString2.next();
      if (paramString3.a(paramString1)) {
        paramString3.eBe();
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.LF.add(paramString1);
      }
      if (!this.mHandler.hasMessages(100001)) {
        this.mHandler.sendEmptyMessageDelayed(100001, 3000L);
      }
      eBd();
      return;
    }
  }
  
  void onCreate() {}
  
  void onDestroy()
  {
    this.LF.clear();
    this.mHandler.removeMessages(100001);
  }
  
  static class a
  {
    long azK;
    JsCallParams b;
    long timeout;
    
    a(String paramString1, String paramString2, String paramString3, long paramLong, String... paramVarArgs)
    {
      this.b = new JsCallParams(paramString1, paramString2, paramString3, paramVarArgs);
      this.timeout = paramLong;
      this.azK = System.currentTimeMillis();
    }
    
    boolean a(a parama)
    {
      return this.b.a(parama.b);
    }
    
    boolean aKM()
    {
      return System.currentTimeMillis() - this.azK > this.timeout;
    }
    
    void eBe()
    {
      this.azK = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnd
 * JD-Core Version:    0.7.0.1
 */