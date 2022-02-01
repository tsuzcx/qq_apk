import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class aquz
{
  public List<String> GP;
  public aquz.a a = new aquz.a();
  private AtomicBoolean aV = new AtomicBoolean(false);
  public int akN = 60000;
  public long atU;
  public long atV;
  public long atW;
  public long atX;
  public long atY;
  public long atZ;
  public long aua;
  public byte bC = 0;
  public boolean bJO;
  public int bju;
  public String bqw;
  public boolean cWA;
  public boolean cWB = true;
  public boolean cWk;
  public boolean cWl;
  public boolean cWm = true;
  public boolean cWn = true;
  public boolean cWo = true;
  public boolean cWp;
  public boolean cWq;
  public boolean cWr = true;
  public boolean cWs;
  public boolean cWt;
  public boolean cWu;
  public boolean cWv;
  public boolean cWw;
  public boolean cWx = true;
  public boolean cWy = true;
  public boolean cWz;
  public String currUrl;
  public int currentIndex;
  public String cxW;
  public String cxX = "Vip";
  public int errCode = 0;
  public String errMsg;
  public float fj = 0.0F;
  public int httpCode;
  private AtomicBoolean isCancel = new AtomicBoolean(false);
  private aquy j;
  public String key;
  public long lastModifiedTime;
  Object lock = new Object();
  public long maxSize;
  public Map<String, File> ov;
  private Map<String, String> ow;
  public int retryCount = 3;
  private AtomicInteger status = new AtomicInteger(2);
  ArrayList<aquz> taskList;
  public int taskType;
  private Bundle y;
  
  public aquz(String paramString, File paramFile)
  {
    this.GP = new ArrayList();
    this.ov = new HashMap();
    this.GP.add(paramString);
    this.ov.put(paramString, paramFile);
    this.key = paramString;
    this.taskType = 1;
  }
  
  public aquz(List<String> paramList, Map<String, File> paramMap, String paramString)
  {
    if (paramList != null)
    {
      this.GP = paramList;
      if (paramMap == null) {
        break label169;
      }
    }
    for (;;)
    {
      this.ov = paramMap;
      this.key = paramString;
      this.taskType = 2;
      return;
      paramList = new ArrayList();
      break;
      label169:
      paramMap = new HashMap();
    }
  }
  
  public boolean Ai()
  {
    boolean bool;
    if (a() != null) {
      bool = a().onStart(this);
    }
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if ((this.taskList != null) && (this.cWB))
        {
          i = this.taskList.size() - 1;
          if (i >= 0)
          {
            aquz localaquz = (aquz)this.taskList.get(i);
            if ((localaquz == null) || (localaquz.a() == null)) {
              break label137;
            }
            localaquz.setStatus(getStatus());
            localaquz.errCode = this.errCode;
            localaquz.fj = this.fj;
            localaquz.a().onStart(localaquz);
          }
        }
      }
      return bool;
      bool = true;
      continue;
      label137:
      i -= 1;
    }
  }
  
  public void XY(int paramInt)
  {
    this.atY = paramInt;
  }
  
  public aquy a()
  {
    return this.j;
  }
  
  public Map<String, String> aC()
  {
    return this.ow;
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.ow == null) {
          this.ow = new HashMap();
        }
        this.ow.put(paramString1, paramString2);
      }
      finally {}
    }
  }
  
  public void bme()
  {
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if (this.taskList == null) {
          break label72;
        }
        i = this.taskList.size() - 1;
        if (i >= 0)
        {
          aquz localaquz = (aquz)this.taskList.get(i);
          if (localaquz == null) {
            break label75;
          }
          localaquz.c(null);
        }
      }
      this.taskList.clear();
      this.taskList = null;
      label72:
      return;
      label75:
      i -= 1;
    }
  }
  
  public void c(aquy paramaquy)
  {
    this.j = paramaquy;
  }
  
  public void cCN()
  {
    if (a() != null) {
      a().onDone(this);
    }
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if ((this.taskList != null) && (this.cWB))
        {
          i = this.taskList.size() - 1;
          if (i >= 0)
          {
            aquz localaquz = (aquz)this.taskList.get(i);
            if ((localaquz == null) || (localaquz.a() == null)) {
              break label119;
            }
            localaquz.setStatus(getStatus());
            localaquz.errCode = this.errCode;
            localaquz.fj = this.fj;
            localaquz.a().onDone(localaquz);
          }
        }
      }
      return;
      label119:
      i -= 1;
    }
  }
  
  public void cancel(boolean paramBoolean)
  {
    this.isCancel.set(paramBoolean);
  }
  
  public void dy(Bundle paramBundle)
  {
    this.y = paramBundle;
  }
  
  public boolean e(byte paramByte)
  {
    return ((byte)(this.bC | 0x0) & paramByte) == paramByte;
  }
  
  public void efO()
  {
    this.atW = 0L;
    this.aV.set(true);
  }
  
  public void efP()
  {
    if (a() != null) {
      a().onProgress(this);
    }
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if ((this.taskList != null) && (this.cWB))
        {
          i = this.taskList.size() - 1;
          if (i >= 0)
          {
            aquz localaquz = (aquz)this.taskList.get(i);
            if ((localaquz == null) || (localaquz.a() == null)) {
              break label135;
            }
            localaquz.setStatus(getStatus());
            localaquz.errCode = this.errCode;
            localaquz.fj = this.fj;
            localaquz.maxSize = this.maxSize;
            localaquz.atU = this.atU;
            localaquz.a().onProgress(localaquz);
          }
        }
      }
      return;
      label135:
      i -= 1;
    }
  }
  
  public void efQ()
  {
    if (a() != null) {
      a().onDoneFile(this);
    }
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if ((this.taskList != null) && (this.cWB))
        {
          i = this.taskList.size() - 1;
          if (i >= 0)
          {
            aquz localaquz = (aquz)this.taskList.get(i);
            if ((localaquz == null) || (localaquz.a() == null)) {
              break label119;
            }
            localaquz.setStatus(getStatus());
            localaquz.errCode = this.errCode;
            localaquz.fj = this.fj;
            localaquz.a().onDoneFile(localaquz);
          }
        }
      }
      return;
      label119:
      i -= 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof aquz)) && (((aquz)paramObject).GP.equals(this.GP));
  }
  
  public int getId()
  {
    int i = 0;
    if (this.y != null) {
      i = this.y.getInt("id");
    }
    return i;
  }
  
  public Bundle getParams()
  {
    if (this.y == null) {
      this.y = new Bundle();
    }
    return this.y;
  }
  
  public int getStatus()
  {
    return this.status.get();
  }
  
  public void h(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadTask", 2, "DownloadTask.addDuplicateListenerTask,task.key=" + paramaquz.key);
    }
    synchronized (this.lock)
    {
      if (this.taskList == null) {
        this.taskList = new ArrayList();
      }
      if (this.taskList.size() < 5) {
        this.taskList.add(paramaquz);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("DownloadTask", 2, "DownloadTask.addDuplicateListenerTask, taskList.size() >= DUPLICATE_LIMIT,size=" + this.taskList.size());
    }
  }
  
  public boolean isCancel()
  {
    return this.isCancel.get();
  }
  
  public boolean isLoading()
  {
    return this.aV.get();
  }
  
  public void onCancel()
  {
    if (a() != null) {
      a().onCancel(this);
    }
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if ((this.taskList != null) && (this.cWB))
        {
          i = this.taskList.size() - 1;
          if (i >= 0)
          {
            aquz localaquz = (aquz)this.taskList.get(i);
            if ((localaquz == null) || (localaquz.a() == null)) {
              break label119;
            }
            localaquz.setStatus(getStatus());
            localaquz.errCode = this.errCode;
            localaquz.fj = this.fj;
            localaquz.a().onCancel(localaquz);
          }
        }
      }
      return;
      label119:
      i -= 1;
    }
  }
  
  public void onNetMobile2None()
  {
    if (a() != null) {
      a().onNetMobile2None();
    }
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if ((this.taskList != null) && (this.cWB))
        {
          i = this.taskList.size() - 1;
          if (i >= 0)
          {
            aquz localaquz = (aquz)this.taskList.get(i);
            if ((localaquz == null) || (localaquz.a() == null)) {
              break label117;
            }
            localaquz.setStatus(getStatus());
            localaquz.errCode = this.errCode;
            localaquz.fj = this.fj;
            localaquz.a().onNetMobile2None();
          }
        }
      }
      return;
      label117:
      i -= 1;
    }
  }
  
  public void onNetWifi2Mobile()
  {
    if (a() != null) {
      a().onNetWifi2Mobile();
    }
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if ((this.taskList != null) && (this.cWB))
        {
          i = this.taskList.size() - 1;
          if (i >= 0)
          {
            aquz localaquz = (aquz)this.taskList.get(i);
            if ((localaquz == null) || (localaquz.a() == null)) {
              break label117;
            }
            localaquz.setStatus(getStatus());
            localaquz.errCode = this.errCode;
            localaquz.fj = this.fj;
            localaquz.a().onNetWifi2Mobile();
          }
        }
      }
      return;
      label117:
      i -= 1;
    }
  }
  
  public void onNetWifi2None()
  {
    if (a() != null) {
      a().onNetWifi2None();
    }
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if ((this.taskList != null) && (this.cWB))
        {
          i = this.taskList.size() - 1;
          if (i >= 0)
          {
            aquz localaquz = (aquz)this.taskList.get(i);
            if ((localaquz == null) || (localaquz.a() == null)) {
              break label117;
            }
            localaquz.setStatus(getStatus());
            localaquz.errCode = this.errCode;
            localaquz.fj = this.fj;
            localaquz.a().onNetWifi2None();
          }
        }
      }
      return;
      label117:
      i -= 1;
    }
  }
  
  public void setStatus(int paramInt)
  {
    this.status.set(paramInt);
  }
  
  public void t(long paramLong1, long paramLong2, int paramInt)
  {
    float f = 100.0F;
    this.maxSize = paramLong1;
    this.atU = paramLong2;
    this.currentIndex = paramInt;
    if (this.atU <= 0L) {
      f = 30.0F;
    }
    for (;;)
    {
      this.fj = ((f + paramInt * 100) / this.GP.size());
      return;
      if (this.atU >= this.maxSize)
      {
        if (paramInt + 1 == this.GP.size())
        {
          setStatus(3);
          this.fj = 100.0F;
        }
      }
      else {
        f = 100.0F * (float)this.atU / (float)this.maxSize;
      }
    }
  }
  
  public String toString()
  {
    return " key=" + this.key + ",urlList size=" + this.GP.size() + "|currentUrlIndex=" + this.currentIndex + "|errCode=" + this.errCode + "|status=" + this.status + "|readSize=" + this.atU + "|maxSize=" + this.maxSize + "|percent=" + this.fj;
  }
  
  public static class a
  {
    public int appid = 1000277;
    public long iUin = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aquz
 * JD-Core Version:    0.7.0.1
 */