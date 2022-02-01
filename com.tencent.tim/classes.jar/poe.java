import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.1;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class poe
{
  private static poe a = new poe();
  private Map<String, poe.a> fF = new HashMap();
  private Map<String, List<poe.c>> fG = new HashMap();
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  public static poe a()
  {
    return a;
  }
  
  private void bk(String paramString, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new StoryVideoUploadProgressManager.1(this, paramString, paramInt));
    }
    for (;;)
    {
      return;
      ram.b("StoryVideoUploadProgressManager", "notifyListeners, id:%s, progress:%s", paramString, Integer.valueOf(paramInt));
      Object localObject = (List)this.fG.get(paramString);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          poe.b localb = ((poe.c)((Iterator)localObject).next()).a();
          if (localb != null) {
            localb.bl(paramString, paramInt);
          }
        }
      }
    }
  }
  
  public void a(String paramString, poe.b paramb)
  {
    ram.b("StoryVideoUploadProgressManager", "registerListener, id:%s, listener:%s", paramString, paramb.getClass().getSimpleName());
    Object localObject1 = null;
    Object localObject3 = this.fG.entrySet().iterator();
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
      Object localObject4 = (String)((Map.Entry)localObject2).getKey();
      localObject4 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      label84:
      if (((Iterator)localObject4).hasNext())
      {
        localObject2 = (poe.c)((Iterator)localObject4).next();
        if (((poe.c)localObject2).a() != paramb) {
          break label205;
        }
        ((Iterator)localObject4).remove();
        localObject1 = localObject2;
      }
    }
    label205:
    for (;;)
    {
      break label84;
      break;
      localObject3 = (List)this.fG.get(paramString);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new ArrayList();
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new poe.c(paramb);
      }
      ((List)localObject2).add(localObject3);
      this.fG.put(paramString, localObject2);
      return;
    }
  }
  
  public void a(poe.b paramb)
  {
    ram.b("StoryVideoUploadProgressManager", "unregisterListener, listener:%s", paramb.getClass().getSimpleName());
    Iterator localIterator = this.fG.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((poe.c)((Iterator)localObject).next()).a() == paramb) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  /* Error */
  public void aw(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 78
    //   4: ldc 175
    //   6: aload_1
    //   7: invokestatic 171	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   10: aload_0
    //   11: getfield 35	poe:fF	Ljava/util/Map;
    //   14: aload_1
    //   15: invokeinterface 178 2 0
    //   20: ifeq +62 -> 82
    //   23: aload_0
    //   24: getfield 35	poe:fF	Ljava/util/Map;
    //   27: aload_1
    //   28: invokeinterface 97 2 0
    //   33: checkcast 6	poe$a
    //   36: astore_3
    //   37: aload_3
    //   38: aload_1
    //   39: putfield 182	poe$a:id	Ljava/lang/String;
    //   42: aload_3
    //   43: ldc 184
    //   45: putfield 187	poe$a:vid	Ljava/lang/String;
    //   48: aload_3
    //   49: iload_2
    //   50: putfield 191	poe$a:aAU	Z
    //   53: aload_3
    //   54: iconst_0
    //   55: putfield 195	poe$a:status	I
    //   58: aload_3
    //   59: iconst_0
    //   60: putfield 198	poe$a:progress	I
    //   63: aload_3
    //   64: invokevirtual 201	poe$a:startTimer	()V
    //   67: aload_0
    //   68: getfield 35	poe:fF	Ljava/util/Map;
    //   71: aload_1
    //   72: aload_3
    //   73: invokeinterface 166 3 0
    //   78: pop
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: new 6	poe$a
    //   85: dup
    //   86: aload_0
    //   87: aconst_null
    //   88: invokespecial 204	poe$a:<init>	(Lpoe;Lcom/tencent/biz/qqstory/base/videoupload/StoryVideoUploadProgressManager$1;)V
    //   91: astore_3
    //   92: goto -55 -> 37
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	poe
    //   0	100	1	paramString	String
    //   0	100	2	paramBoolean	boolean
    //   36	56	3	locala	poe.a
    // Exception table:
    //   from	to	target	type
    //   2	37	95	finally
    //   37	79	95	finally
    //   82	92	95	finally
  }
  
  public int bb(String paramString)
  {
    paramString = (poe.a)this.fF.get(paramString);
    if (paramString != null) {
      return paramString.progress;
    }
    return -1;
  }
  
  public void blZ()
  {
    try
    {
      ram.d("StoryVideoUploadProgressManager", "startANewUploadSeq");
      Iterator localIterator = this.fF.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((poe.a)((Map.Entry)localIterator.next()).getValue()).stopTimer();
      }
      this.fF.clear();
    }
    finally {}
    this.fG.clear();
  }
  
  public void cn(String paramString1, String paramString2)
  {
    try
    {
      ram.b("StoryVideoUploadProgressManager", "sendProtoSuccess:%s", paramString1);
      if (this.fF.containsKey(paramString1))
      {
        poe.a locala = (poe.a)this.fF.get(paramString1);
        locala.status = 4;
        locala.progress = 100;
        locala.vid = paramString2;
        bk(paramString1, locala.progress);
        locala.stopTimer();
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public String fO(String paramString)
  {
    Iterator localIterator = this.fF.values().iterator();
    while (localIterator.hasNext())
    {
      poe.a locala = (poe.a)localIterator.next();
      if ((locala.vid != null) && (locala.vid.equals(paramString))) {
        return locala.id;
      }
    }
    return "";
  }
  
  public void qW(String paramString)
  {
    try
    {
      ram.b("StoryVideoUploadProgressManager", "preparedSuccess:%s", paramString);
      if (this.fF.containsKey(paramString))
      {
        poe.a locala = (poe.a)this.fF.get(paramString);
        locala.status = 1;
        locala.progress = 0;
        bk(paramString, locala.progress);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void qX(String paramString)
  {
    try
    {
      ram.b("StoryVideoUploadProgressManager", "mergeVideoSuccess:%s", paramString);
      if (this.fF.containsKey(paramString))
      {
        poe.a locala = (poe.a)this.fF.get(paramString);
        locala.status = 2;
        locala.progress = 60;
        bk(paramString, locala.progress);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void qY(String paramString)
  {
    try
    {
      ram.b("StoryVideoUploadProgressManager", "uploadVideoSuccess:%s", paramString);
      if (this.fF.containsKey(paramString))
      {
        poe.a locala = (poe.a)this.fF.get(paramString);
        locala.status = 3;
        locala.progress = 95;
        bk(paramString, locala.progress);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void qZ(String paramString)
  {
    try
    {
      if (this.fF.containsKey(paramString))
      {
        poe.a locala = (poe.a)this.fF.get(paramString);
        locala.status = 5;
        locala.progress = 100;
        bk(paramString, locala.progress);
        locala.stopTimer();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int sp()
  {
    Iterator localIterator = this.fF.values().iterator();
    int j = 0;
    int i = 0;
    int k;
    if (localIterator.hasNext())
    {
      poe.a locala = (poe.a)localIterator.next();
      if (!locala.aAU) {
        break label83;
      }
      k = locala.progress + j;
      j = i + 1;
      i = k;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if (i > 0) {
        return j / i;
      }
      return -1;
      label83:
      k = i;
      i = j;
      j = k;
    }
  }
  
  public class a
  {
    public boolean aAU;
    private Runnable dn = new StoryVideoUploadProgressManager.ProgressStatus.1(this);
    public String id;
    private boolean mStopped;
    public int progress;
    public int status;
    public String vid;
    
    private a() {}
    
    private void adc()
    {
      switch (this.status)
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        do
        {
          do
          {
            do
            {
              return;
              this.progress = 0;
              return;
              this.progress += 1;
            } while (this.progress < 60);
            this.progress = 59;
            return;
            this.progress += 1;
          } while (this.progress < 95);
          this.progress = 94;
          return;
          this.progress += 1;
        } while (this.progress < 100);
        this.progress = 99;
        return;
      }
      this.progress = 100;
    }
    
    public void startTimer()
    {
      this.mStopped = false;
      poe.a(poe.this).postDelayed(this.dn, 200L);
    }
    
    public void stopTimer()
    {
      this.mStopped = true;
      poe.a(poe.this).removeCallbacks(this.dn);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bl(String paramString, int paramInt);
  }
  
  static class c
  {
    private WeakReference<poe.b> cQ;
    
    public c(poe.b paramb)
    {
      this.cQ = new WeakReference(paramb);
    }
    
    @Nullable
    public poe.b a()
    {
      return (poe.b)this.cQ.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     poe
 * JD-Core Version:    0.7.0.1
 */