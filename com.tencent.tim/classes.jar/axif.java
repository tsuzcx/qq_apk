import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.play.PlayDownloadManagerWrap.1;
import dov.com.qq.im.ae.play.PlayDownloadManagerWrap.2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class axif
{
  private WeakReference<axgi> bv;
  private String cUF = "";
  private final Map<String, List<axie>> ky = new HashMap();
  private final Map<String, axcc.b> qk = new HashMap();
  
  public static axif a()
  {
    return axif.b.a;
  }
  
  private void a(String paramString, axcc.b paramb)
  {
    synchronized (this.qk)
    {
      this.qk.put(paramString, paramb);
      return;
    }
  }
  
  private void acH(String paramString)
  {
    synchronized (this.qk)
    {
      this.qk.remove(paramString);
      return;
    }
  }
  
  private boolean uf(String paramString)
  {
    for (;;)
    {
      synchronized (this.qk)
      {
        if (this.qk.get(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void a(axgi paramaxgi, @NonNull axbr paramaxbr, @NonNull axbu paramaxbu)
  {
    if (uf(paramaxbu.id)) {
      return;
    }
    if ((this.bv == null) || (this.bv.get() == null)) {
      this.bv = new WeakReference(paramaxgi);
    }
    paramaxgi = new axif.a(null);
    a(paramaxbu.id, paramaxgi);
    this.cUF = paramaxbu.id;
    ThreadManager.excute(new PlayDownloadManagerWrap.1(this, paramaxbr, paramaxbu, paramaxgi), 128, null, true);
  }
  
  public void a(String paramString, axie paramaxie)
  {
    if (paramaxie != null) {}
    try
    {
      List localList = (List)this.ky.get(paramString);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      if (!((List)localObject).contains(paramaxie))
      {
        ((List)localObject).add(paramaxie);
        this.ky.put(paramString, localObject);
      }
      return;
    }
    finally {}
  }
  
  public Map<String, axcc.b> aM()
  {
    return this.qk;
  }
  
  public void aoc()
  {
    this.bv = null;
    this.ky.clear();
  }
  
  public void b(String paramString, axie paramaxie)
  {
    List localList;
    try
    {
      localList = (List)this.ky.get(paramString);
      if ((localList != null) && (localList.size() > 1))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if ((axie)localIterator.next() == paramaxie) {
            localIterator.remove();
          }
        }
      }
      if (localList == null) {
        break label91;
      }
    }
    finally {}
    if (localList.size() < 1) {
      label91:
      this.ky.remove(paramString);
    }
  }
  
  public void d(axbu paramaxbu, boolean paramBoolean)
  {
    if (paramaxbu == null) {}
    for (;;)
    {
      return;
      String str;
      List localList;
      try
      {
        str = paramaxbu.id;
        localList = (List)this.ky.get(str);
        if ((this.cUF != null) && (this.cUF.equals(str)) && (paramBoolean) && (paramaxbu.equals(axgn.h))) {
          ThreadManager.getUIHandler().post(new PlayDownloadManagerWrap.2(this, paramaxbu));
        }
        if (localList == null)
        {
          this.ky.remove(str);
          continue;
        }
      }
      finally {}
      paramaxbu = localList.iterator();
      while (paramaxbu.hasNext()) {
        ((axie)paramaxbu.next()).dR(str, paramBoolean);
      }
      this.ky.remove(str);
    }
  }
  
  /* Error */
  public void hf(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	axif:ky	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 66 2 0
    //   12: checkcast 102	java/util/List
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +17 -> 34
    //   20: aload_0
    //   21: getfield 31	axif:ky	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 61 2 0
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_3
    //   35: invokeinterface 128 1 0
    //   40: astore_3
    //   41: aload_3
    //   42: invokeinterface 134 1 0
    //   47: ifeq -16 -> 31
    //   50: aload_3
    //   51: invokeinterface 137 1 0
    //   56: checkcast 139	axie
    //   59: aload_1
    //   60: iload_2
    //   61: invokeinterface 179 3 0
    //   66: goto -25 -> 41
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	axif
    //   0	74	1	paramString	String
    //   0	74	2	paramInt	int
    //   15	36	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	69	finally
    //   20	31	69	finally
    //   34	41	69	finally
    //   41	66	69	finally
  }
  
  static class a
    implements axcc.b
  {
    public void a(axbu paramaxbu, int paramInt)
    {
      if (paramInt <= 1) {
        return;
      }
      axif.a().hf(paramaxbu.id, paramInt);
    }
    
    public void a(axbu paramaxbu, boolean paramBoolean)
    {
      if (paramaxbu == null) {
        return;
      }
      paramaxbu.downloading = false;
      if (paramBoolean) {
        paramaxbu.usable = true;
      }
      for (;;)
      {
        axif.a().d(paramaxbu, paramBoolean);
        axif.a(axif.a(), paramaxbu.id);
        return;
        QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + paramaxbu.id);
      }
    }
  }
  
  static class b
  {
    public static final axif a = new axif(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axif
 * JD-Core Version:    0.7.0.1
 */