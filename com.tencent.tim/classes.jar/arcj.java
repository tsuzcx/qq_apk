import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsDownloader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class arcj
{
  private static final ArrayList<arcj.a> Dh = new ArrayList(5);
  private static arcj a;
  private static long avq;
  private static int eev;
  static WeakReference<BrowserAppInterface> iC;
  final MessageQueue.IdleHandler sIdleHandler = new arck(this);
  boolean sIsIdleHandlerInQueue = false;
  
  public static arcj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new arcj();
      }
      return a;
    }
    finally {}
  }
  
  public static void a(BrowserAppInterface paramBrowserAppInterface)
  {
    iC = new WeakReference(paramBrowserAppInterface);
  }
  
  static void ehr()
  {
    try
    {
      jqo.le("downloadX5KernelIfNeeded");
      BrowserAppInterface localBrowserAppInterface = (BrowserAppInterface)iC.get();
      if (localBrowserAppInterface != null)
      {
        String str = WebAccelerateHelper.getInstance().getTBSDpcParam();
        if ((str == null) || (str.charAt(0) != '1') || (!"CN".equals(Locale.getDefault().getCountry()))) {
          break label91;
        }
        if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new arcl()))
        {
          localBrowserAppInterface.Ep(false);
          QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle:download tbs.");
        }
      }
      for (;;)
      {
        jqo.lf("downloadX5KernelIfNeeded");
        return;
        label91:
        eev = 5;
        QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle: no need download tbs.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SwiftBrowserIdleTaskHelper", 1, "downloadX5Kernel error:" + localThrowable.getMessage());
      jqo.lf("downloadX5KernelIfNeeded");
    }
  }
  
  public void a(arcj.a parama)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Iterator localIterator = Dh.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((arcj.a)localIterator.next()).taskId != parama.taskId);
    }
    do
    {
      return;
      Dh.add(parama);
    } while ((Dh.isEmpty()) || (this.sIsIdleHandlerInQueue));
    this.sIsIdleHandlerInQueue = true;
    Looper.myQueue().addIdleHandler(this.sIdleHandler);
  }
  
  public boolean removeIdleTask(int paramInt)
  {
    Iterator localIterator = Dh.iterator();
    while (localIterator.hasNext())
    {
      arcj.a locala = (arcj.a)localIterator.next();
      if (locala.taskId == paramInt)
      {
        Dh.remove(locala);
        return true;
      }
    }
    return false;
  }
  
  public static abstract class a
  {
    public final int taskId;
    
    public a(int paramInt)
    {
      this.taskId = paramInt;
    }
    
    public abstract int run();
  }
  
  public static class b
    extends arcj.a
  {
    public b(int paramInt)
    {
      super();
    }
    
    public int run()
    {
      if (WebAccelerateHelper.preloadBrowserView == null)
      {
        WebAccelerateHelper.preInflaterBrowserView();
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserIdleTaskHelper", 2, "preloadBrowserView on idle.");
        }
      }
      do
      {
        return 2;
        if (SwiftReuseTouchWebView.sPoolSize != 0) {
          break;
        }
        SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication).Th(true);
      } while (!QLog.isColorLevel());
      QLog.d("SwiftBrowserIdleTaskHelper", 2, "preload Webview on idle.");
      return 2;
      long l;
      if (arcj.eev < 5)
      {
        l = System.currentTimeMillis();
        if (System.currentTimeMillis() > arcj.avq + 10000L)
        {
          arcj.ehr();
          arcj.access$108();
          arcj.access$202(l);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserIdleTaskHelper", 2, "downloadX5KernelIfNeeded on idle.");
          }
        }
      }
      for (;;)
      {
        return 1;
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserIdleTaskHelper", 2, "not need check because time limit:" + l + " - " + arcj.avq + " < 10s.");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserIdleTaskHelper", 2, "not need check because count limit:" + arcj.eev + ">=" + 5 + ".");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcj
 * JD-Core Version:    0.7.0.1
 */