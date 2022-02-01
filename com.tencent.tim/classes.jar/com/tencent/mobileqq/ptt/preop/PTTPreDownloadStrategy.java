package com.tencent.mobileqq.ptt.preop;

import alip.b;
import aliq;
import aliq.a;
import android.os.Handler;
import anpc;
import aomi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class PTTPreDownloadStrategy
  implements alip.b, Runnable
{
  private a a = new a(1);
  private a b = new a(3);
  private a c = new a(2);
  private volatile boolean cxn;
  private Handler mHandler;
  private WeakReference<QQAppInterface> n;
  
  public PTTPreDownloadStrategy(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    this.n = new WeakReference(paramQQAppInterface);
    this.mHandler = paramHandler;
    this.cxn = false;
  }
  
  private long a(MessageForPtt paramMessageForPtt)
  {
    long l2 = 4096L;
    long l1 = paramMessageForPtt.fileSize;
    if (l1 <= 0L)
    {
      if (paramMessageForPtt.voiceType == 1) {
        if (paramMessageForPtt.voiceLength <= 0) {
          l1 = 10240L;
        }
      }
      do
      {
        do
        {
          return l1;
          return paramMessageForPtt.voiceLength * 1200;
          l1 = l2;
        } while (paramMessageForPtt.voiceType != 0);
        l1 = l2;
      } while (paramMessageForPtt.voiceLength <= 0);
      return paramMessageForPtt.voiceLength * 700;
    }
    return l1;
  }
  
  private void a(a parama)
  {
    long l2;
    if (parama.a.duD == -2147483648)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PTTPreDownloader", 4, "initStrategyInfoIfNeccessary");
      }
      Date localDate = new Date();
      Object localObject1 = (QQAppInterface)this.n.get();
      aliq.a locala1 = aliq.a((QQAppInterface)localObject1, parama.mType);
      parama.a.duD = locala1.duD;
      int i;
      if (parama.a.duD > 0)
      {
        aliq.a locala2 = new aliq.a();
        localObject1 = aliq.a((QQAppInterface)localObject1, parama.mType, locala2);
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd").format(localDate);
        if (QLog.isDevelopLevel()) {
          QLog.d("PTTPreDownloader", 4, "PreTime:" + (String)localObject1 + " curTime:" + (String)localObject2);
        }
        if (((String)localObject2).equals(localObject1))
        {
          i = 0;
          while (i <= 5)
          {
            parama.a.mG[i] = locala2.mG[i];
            i += 1;
          }
        }
        i = 0;
        int j = 0;
        if (locala2.duD > -1)
        {
          localObject1 = new HashMap();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(locala2.duD);
          i = j;
          while (i <= 5)
          {
            ((StringBuilder)localObject2).append('#').append(i).append('_').append(locala2.mG[i]);
            i += 1;
          }
          ((HashMap)localObject1).put("RemainCfg", ((StringBuilder)localObject2).toString());
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          anpc.a(BaseApplication.getContext()).collectPerformance(null, "PttPreDownloadDailyRemain", true, 0L, 0L, (HashMap)localObject1, "");
          i = 0;
        }
        while (i <= 5)
        {
          parama.a.mG[i] = locala1.mG[i];
          i += 1;
        }
      }
      b(parama);
      if (!this.cxn)
      {
        l1 = localDate.getTime();
        i = localDate.getHours();
        localDate.setHours(0);
        localDate.setMinutes(0);
        localDate.setSeconds(0);
        l2 = localDate.getTime();
        if (i >= 0) {
          break label494;
        }
      }
    }
    label494:
    for (long l1 = 0L - (l1 - l2);; l1 = 86400000L - (l1 - l2))
    {
      if (QLog.isDevelopLevel())
      {
        l2 = l1 / 1000L;
        QLog.d("PTTPreDownloader", 4, "Next reset time offset:" + l2 / 60L + ":" + l2 % 60L);
      }
      this.cxn = true;
      this.mHandler.postDelayed(this, l1);
      return;
    }
  }
  
  private void b(a parama)
  {
    parama = parama.mType + ":" + parama.a;
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, parama);
    }
  }
  
  private void dGk()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "save");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.n.get();
    if (localQQAppInterface == null) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      if (this.a.a.duD != -2147483648)
      {
        aliq.a(localQQAppInterface, this.a.a, this.a.mType);
        b(this.a);
        localHashMap.put("C2CDownload", String.valueOf(this.a.mDownloadCount));
        localHashMap.put("C2CView", String.valueOf(this.a.mViewCount));
        localHashMap.put("C2CCancel", String.valueOf(this.a.duA));
        localHashMap.put("C2CEscape", String.valueOf(this.a.duz));
      }
      if (this.b.a.duD != -2147483648)
      {
        aliq.a(localQQAppInterface, this.b.a, this.b.mType);
        b(this.b);
        b(this.a);
        localHashMap.put("GroupDownload", String.valueOf(this.b.mDownloadCount));
        localHashMap.put("GroupView", String.valueOf(this.b.mViewCount));
        localHashMap.put("GroupCancel", String.valueOf(this.b.duA));
        localHashMap.put("GroupEscape", String.valueOf(this.b.duz));
      }
      if (this.c.a.duD != -2147483648)
      {
        aliq.a(localQQAppInterface, this.c.a, this.c.mType);
        b(this.c);
        localHashMap.put("DiscussDownload", String.valueOf(this.c.mDownloadCount));
        localHashMap.put("DiscussView", String.valueOf(this.c.mViewCount));
        localHashMap.put("DiscussCancel", String.valueOf(this.c.duA));
        localHashMap.put("DiscussEscape", String.valueOf(this.c.duz));
      }
    } while (localHashMap.size() <= 0);
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "PttPreDownloadPV", true, 0L, 0L, localHashMap, "");
  }
  
  public boolean a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 2) {
      return true;
    }
    if (paramMessageForPtt.istroop == 0) {}
    label389:
    for (a locala = this.a;; locala = null)
    {
      boolean bool1 = bool2;
      int i;
      if (locala != null)
      {
        if ((paramMessageForPtt.extFlag & 1L) <= 0L) {
          break label289;
        }
        i = 1;
        label45:
        if (i == 0) {
          break label336;
        }
        i = aomi.a().getNetType();
      }
      for (;;)
      {
        try
        {
          a(locala);
          long l1 = locala.a.mG[i];
          long l2 = paramMessageForPtt.fileSize + l1;
          aliq.a locala1 = aliq.a((QQAppInterface)this.n.get(), locala.mType);
          if (l2 > locala1.mG[i])
          {
            locala.a.mG[i] = locala1.mG[i];
            if (paramInt != 1) {
              break label316;
            }
            locala.mViewCount += 1;
            if (QLog.isDevelopLevel()) {
              QLog.d("PTTPreDownloader", 4, "consume sesion:" + locala.mType + " netType:" + i + ", " + l1 + " + " + paramMessageForPtt.fileSize + " = " + locala.a.mG[i]);
            }
            bool1 = true;
            return bool1;
            if (paramMessageForPtt.istroop == 1)
            {
              locala = this.b;
              break;
            }
            if (paramMessageForPtt.istroop != 3000) {
              break label389;
            }
            locala = this.c;
            break;
            label289:
            i = 0;
            break label45;
          }
          locala.a.mG[i] = ((int)l2);
          continue;
          if (paramInt != 3) {
            continue;
          }
        }
        finally {}
        label316:
        locala.duA += 1;
        continue;
        label336:
        bool1 = bool2;
        if (QLog.isDevelopLevel())
        {
          QLog.d("PTTPreDownloader", 4, "consume sesion:" + locala.mType + " not preDownload");
          bool1 = bool2;
        }
      }
    }
  }
  
  public boolean c(MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramMessageForPtt.istroop == 0) {}
    label393:
    for (a locala = this.a;; locala = null)
    {
      long l2;
      int i;
      if (locala != null)
      {
        l2 = 0L;
        i = aomi.a().getNetType();
      }
      for (;;)
      {
        long l3;
        try
        {
          a(locala);
          if (locala.a.duD <= 0)
          {
            l1 = l2;
            bool1 = bool3;
            bool2 = bool1;
            if (QLog.isDevelopLevel())
            {
              QLog.d("PTTPreDownloader", 4, "canDownload:" + bool1 + " sesion:" + locala.mType + " net:" + i + " " + l1 + " - " + paramMessageForPtt.estimatedSize + " = " + locala.a.mG[i] + ", pttSize:" + paramMessageForPtt.fileSize);
              bool2 = bool1;
            }
            return bool2;
            if (paramMessageForPtt.istroop == 1)
            {
              locala = this.b;
              break;
            }
            if (paramMessageForPtt.istroop != 3000) {
              break label393;
            }
            locala = this.c;
            break;
          }
          l3 = paramMessageForPtt.msgRecTime - paramMessageForPtt.msgTime;
          bool1 = bool3;
          l1 = l2;
          if (l3 < -10000L) {
            continue;
          }
          bool1 = bool3;
          l1 = l2;
          if (l3 > locala.a.duD * 24 * 60 * 60 * 100) {
            continue;
          }
          l3 = a(paramMessageForPtt);
          if (l3 > locala.a.mG[i])
          {
            locala.duz += 1;
            bool1 = bool3;
            l1 = l2;
            continue;
          }
          locala.mDownloadCount += 1;
        }
        finally {}
        paramMessageForPtt.estimatedSize = l3;
        long l1 = locala.a.mG[i];
        int[] arrayOfInt = locala.a.mG;
        arrayOfInt[i] = ((int)(arrayOfInt[i] - l3));
        boolean bool1 = true;
      }
    }
  }
  
  public boolean d(MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = true;
    if (paramMessageForPtt.estimatedSize <= 0L) {
      return false;
    }
    a locala = null;
    int i;
    if (paramMessageForPtt.istroop == 0)
    {
      locala = this.a;
      if (locala == null) {
        break label266;
      }
      i = aomi.a().getNetType();
    }
    for (;;)
    {
      try
      {
        long l1 = locala.a.mG[i];
        locala.a.mG[i] += (int)(paramMessageForPtt.estimatedSize - paramMessageForPtt.fileSize);
        long l2 = paramMessageForPtt.estimatedSize;
        paramMessageForPtt.estimatedSize = 0L;
        bool1 = bool2;
        if (QLog.isDevelopLevel())
        {
          QLog.d("PTTPreDownloader", 4, "fixEstimatedSize sesion:" + locala.mType + " net:" + i + ", " + l1 + " + " + l2 + " - " + paramMessageForPtt.fileSize + " = " + locala.a.mG[i] + ", PttSize:" + paramMessageForPtt.fileSize);
          bool1 = bool2;
        }
        return bool1;
      }
      finally {}
      if (paramMessageForPtt.istroop == 1)
      {
        locala = this.b;
        break;
      }
      if (paramMessageForPtt.istroop != 3000) {
        break;
      }
      locala = this.c;
      break;
      label266:
      boolean bool1 = false;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "onDestroy");
    }
    this.mHandler.removeCallbacks(this);
    this.cxn = false;
    dGk();
  }
  
  public void reset()
  {
    this.a = new a(1);
    this.b = new a(3);
    this.c = new a(2);
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "reset");
    }
    this.mHandler.removeCallbacks(this);
    this.cxn = false;
    reset();
  }
  
  static class a
  {
    public final aliq.a a = new aliq.a();
    public int duA;
    public int duz;
    public int mDownloadCount;
    public int mType;
    public int mViewCount;
    
    public a(int paramInt)
    {
      this.mType = paramInt;
      this.a.duD = -2147483648;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PTTPreDownloadStrategy
 * JD-Core Version:    0.7.0.1
 */