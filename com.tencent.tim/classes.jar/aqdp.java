import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class aqdp
  implements Handler.Callback
{
  private final aqdp.a a;
  private final LinkedList<aqdq> an;
  private final LinkedList<aqdq> ao;
  private final Handler handler;
  private long rG;
  
  public aqdp(aqdp.a parama)
  {
    this.a = parama;
    this.an = new LinkedList();
    this.ao = new LinkedList();
    this.handler = new auru(ThreadManager.getSubThreadLooper(), this);
    this.rG = 0L;
  }
  
  private void b(aqdq paramaqdq)
  {
    if (!paramaqdq.aBW()) {
      if (QLog.isColorLevel()) {
        QLog.d("FetchInfoListManager", 2, aqmr.makeLogMsg(new Object[] { "addToNeedFetchInfoListInner() ", paramaqdq.toString(), "非法请求" }));
      }
    }
    do
    {
      do
      {
        return;
        if ((!this.an.contains(paramaqdq)) && (!this.ao.contains(paramaqdq))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("FetchInfoListManager", 4, aqmr.makeLogMsg(new Object[] { "addToNeedFetchInfoListInner()", paramaqdq.toString(), "已经在队列中了" }));
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, aqmr.makeLogMsg(new Object[] { "addToNeedFetchInfoListInner()", paramaqdq.toString() }));
      }
      this.an.addFirst(paramaqdq);
    } while (this.handler.hasMessages(1));
    long l = SystemClock.elapsedRealtime() - this.rG;
    if ((l < 0L) || (l > 2000L))
    {
      this.handler.sendEmptyMessage(1);
      return;
    }
    this.handler.sendEmptyMessageDelayed(1, 300L);
  }
  
  private void c(aqdq paramaqdq)
  {
    if ((paramaqdq != null) && (!this.ao.contains(paramaqdq)))
    {
      paramaqdq.Tb = SystemClock.elapsedRealtime();
      this.ao.add(paramaqdq);
      if (!this.handler.hasMessages(2)) {
        this.handler.sendEmptyMessageDelayed(2, 30000L);
      }
    }
  }
  
  private void edw()
  {
    if (this.an.isEmpty()) {
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, "doFetchInfo fetch list is empty!");
      }
    }
    for (;;)
    {
      return;
      aqdq localaqdq;
      do
      {
        localaqdq = (aqdq)this.an.removeFirst();
      } while ((localaqdq == null) && (!this.an.isEmpty()));
      if (localaqdq == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FetchInfoListManager", 4, "doFetchInfo req is null !");
        }
      }
      else
      {
        this.rG = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
          QLog.d("FetchInfoListManager", 2, String.format(Locale.getDefault(), "doFetchInfo type:%d  key: %s time:%d", new Object[] { Integer.valueOf(localaqdq.iType), localaqdq.strKey, Long.valueOf(this.rG) }));
        }
        if (localaqdq.iType == 1)
        {
          ArrayList localArrayList = new ArrayList();
          c(localaqdq);
          localArrayList.add(localaqdq);
          int i = Math.min(this.an.size(), 20) - 1;
          while (i >= 0)
          {
            localaqdq = (aqdq)this.an.get(i);
            if ((localaqdq != null) && (localaqdq.iType == 1))
            {
              this.an.remove(i);
              c(localaqdq);
              localArrayList.add(localaqdq);
            }
            i -= 1;
          }
          this.a.Y(1, localArrayList);
        }
        while (!this.an.isEmpty())
        {
          this.handler.sendEmptyMessage(1);
          return;
          c(localaqdq);
          this.a.a(localaqdq);
        }
      }
    }
  }
  
  private void edx()
  {
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("dealTimeOut  size:").append(this.ao.size()).append(" {");
    }
    for (;;)
    {
      long l4 = SystemClock.elapsedRealtime();
      int i = this.ao.size() - 1;
      long l1 = 30000L;
      if (i >= 0)
      {
        aqdq localaqdq = (aqdq)this.ao.get(i);
        long l2;
        if (localaqdq == null)
        {
          this.ao.remove(localaqdq);
          l2 = l1;
        }
        for (;;)
        {
          i -= 1;
          l1 = l2;
          break;
          long l3 = l4 - localaqdq.Tb;
          if ((l3 < 0L) || (l3 >= 30000L))
          {
            this.ao.remove(localaqdq);
            l2 = l1;
            if (localStringBuilder != null)
            {
              localStringBuilder.append(", [").append(localaqdq.iType).append(",").append(localaqdq.strKey).append("]");
              l2 = l1;
            }
          }
          else
          {
            l2 = l1;
            if (l3 < l1) {
              l2 = l3;
            }
          }
        }
      }
      if (!this.ao.isEmpty()) {
        this.handler.sendEmptyMessageDelayed(2, Math.max(1000L, l1));
      }
      if ((QLog.isDevelopLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("}");
        localStringBuilder.append(" isEmpty: ").append(this.ao.isEmpty());
        QLog.d("FetchInfoListManager", 4, localStringBuilder.toString());
      }
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    paramString2 = new aqdq(paramInt, paramString1, paramString2, paramObject, paramBundle);
    paramString2 = this.handler.obtainMessage(3, paramString2);
    this.handler.sendMessage(paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.i("FetchInfoListManager", 4, String.format(Locale.getDefault(), "addToNeedFetchInfoList [%d, %s]", new Object[] { Integer.valueOf(paramInt), paramString1 }));
    }
  }
  
  public void clear()
  {
    this.an.clear();
    this.ao.clear();
    this.handler.removeCallbacksAndMessages(null);
    if (QLog.isDevelopLevel()) {
      QLog.i("FetchInfoListManager", 4, "clear");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof aqdq)) {
        b((aqdq)paramMessage.obj);
      }
    }
    do
    {
      return true;
      if (paramMessage.what == 1)
      {
        edw();
        return true;
      }
    } while (paramMessage.what != 2);
    edx();
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void Y(int paramInt, List<aqdq> paramList);
    
    public abstract void a(aqdq paramaqdq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdp
 * JD-Core Version:    0.7.0.1
 */