import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.scribble.ScribbleDownloader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;

public class amja
  implements Handler.Callback, Manager
{
  public String TAG = "ScribbleDownloader";
  public amja.a a = new amja.a();
  AtomicBoolean dJ = new AtomicBoolean(true);
  public QQAppInterface mApp;
  protected Handler subHandler;
  
  public amja(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.subHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(amiz paramamiz)
  {
    int i = this.a.b(paramamiz);
    log("addDownload", "result is " + i);
    dNT();
  }
  
  private boolean avX()
  {
    int i = akxo.Hi();
    if (i != 0)
    {
      log("isNeedPreDownload", "Not Wifi, networkType=" + i + ", no need to predownload");
      return false;
    }
    return true;
  }
  
  private void b(amiz paramamiz)
  {
    ThreadManager.post(new ScribbleDownloader.1(this, paramamiz), 5, null, false);
  }
  
  private void dNT()
  {
    if (this.a.IL() < 2)
    {
      amiz localamiz = this.a.a();
      if (localamiz == null)
      {
        log("consumeDownload", "removeOneFromWaitToDowning is null");
        return;
      }
      b(localamiz);
      return;
    }
    log("consumeDownload", "donwloading is max threads");
  }
  
  private void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      paramString1 = new StringBuilder().append(paramString1).append("(): ").append(str);
      QLog.d(this.TAG, 2, paramString1.toString());
    }
  }
  
  public int a(MessageForScribble paramMessageForScribble)
  {
    int i = this.a.b(paramMessageForScribble);
    log("removeDownloadedMsg", " result is " + i);
    dNT();
    return i;
  }
  
  public void d(MessageForScribble paramMessageForScribble)
  {
    log("PreDownloadFromMsg", "uniseq=" + paramMessageForScribble.uniseq);
    if (avX())
    {
      a(new amiz(paramMessageForScribble, 200));
      return;
    }
    log("PreDownloadFromMsg", "no NeedPreDownload uniseq=" + paramMessageForScribble.uniseq);
  }
  
  public void dDQ()
  {
    this.dJ.set(false);
    log("off", "mIsPreDownloaderOpen=" + this.dJ.get());
    this.subHandler.sendEmptyMessageDelayed(111, 60000L);
  }
  
  public void dDR()
  {
    this.dJ.set(true);
    log("on", " mIsPreDownloaderOpen=" + this.dJ.get());
    dNT();
  }
  
  public void dNS()
  {
    int i = 0;
    try
    {
      if (SessionInfo.getInstance(this.mApp.getCurrentUin()).getHttpconn_sig_session() != null) {
        i = SessionInfo.getInstance(this.mApp.getCurrentUin()).getHttpconn_sig_session().length;
      }
      if (i == 0) {
        HwServlet.getConfig(this.mApp, this.mApp.getCurrentUin());
      }
      return;
    }
    finally {}
  }
  
  public void e(MessageForScribble paramMessageForScribble)
  {
    log("DownloadFromAio", "uniseq=" + paramMessageForScribble.uniseq);
    a(new amiz(paramMessageForScribble, 201));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 111)
    {
      if (!this.dJ.get())
      {
        this.dJ.set(true);
        log("handleMessage", "MSG_OPEN_PRE_DOWNLOADING, mIsPreDownloaderOpen=" + this.dJ.get());
      }
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    log("onDestroy", null);
  }
  
  class a
  {
    public final int dCg = -1;
    public final int dCh = 0;
    public final int dCi = 1;
    public final int dCj = 2;
    public final int dCk = 0;
    public final int dCl = -1;
    private PriorityBlockingQueue<amiz> e = new PriorityBlockingQueue();
    private Lock lock = new ReentrantLock();
    private ArrayList<amiz> zu = new ArrayList();
    
    a() {}
    
    public int IL()
    {
      this.lock.lock();
      try
      {
        int i = this.zu.size();
        this.lock.unlock();
        amja.a(amja.this, "getDownloadingSize", "downing size is " + i);
        return i;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    
    public amiz a()
    {
      amiz localamiz = null;
      this.lock.lock();
      try
      {
        if (this.e.size() > 0)
        {
          localamiz = (amiz)this.e.poll();
          this.zu.add(localamiz);
        }
        return localamiz;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    
    public int b(amiz paramamiz)
    {
      int k = 1;
      int m = -1;
      this.lock.lock();
      for (;;)
      {
        try
        {
          if (this.zu.size() > 0)
          {
            i = 0;
            if (i < this.zu.size())
            {
              if (paramamiz.c.uniseq == ((amiz)this.zu.get(i)).c.uniseq)
              {
                j = 1;
                i = 1;
                if ((j == 0) && (this.e.size() > 0))
                {
                  Iterator localIterator = this.e.iterator();
                  if (localIterator.hasNext())
                  {
                    amiz localamiz = (amiz)localIterator.next();
                    if (localamiz.c.uniseq != paramamiz.c.uniseq) {
                      continue;
                    }
                    if (localamiz.priority >= paramamiz.priority) {
                      break label214;
                    }
                    localamiz.priority = paramamiz.priority;
                    break label214;
                    if (j == 0)
                    {
                      this.e.add(paramamiz);
                      i = 0;
                    }
                    return i;
                  }
                }
              }
              else
              {
                i += 1;
                continue;
              }
              continue;
            }
          }
        }
        finally
        {
          this.lock.unlock();
        }
        int j = 0;
        int i = m;
        continue;
        label214:
        i = 2;
        j = k;
      }
    }
    
    public int b(MessageForScribble paramMessageForScribble)
    {
      this.lock.lock();
      for (;;)
      {
        try
        {
          if (this.zu.size() > 0)
          {
            i = 0;
            if (i < this.zu.size())
            {
              if (paramMessageForScribble.uniseq == ((amiz)this.zu.get(i)).c.uniseq)
              {
                this.zu.remove(i);
                i = 0;
                return i;
              }
              i += 1;
              continue;
            }
          }
          int i = -1;
        }
        finally
        {
          this.lock.unlock();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amja
 * JD-Core Version:    0.7.0.1
 */