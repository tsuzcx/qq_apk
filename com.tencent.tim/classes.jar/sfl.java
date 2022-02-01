import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.biz.subscribe.other.story.VSUploadProgressManager.2;
import com.tencent.biz.subscribe.other.story.VSUploadProgressManager.ProgressStatus.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class sfl
{
  private static sfl jdField_a_of_type_Sfl = new sfl();
  private sfl.b jdField_a_of_type_Sfl$b = new sfm(this);
  private Map<String, sfl.a> fF = new HashMap();
  private Map<String, List<sfl.c>> fG = new HashMap();
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  public static sfl a()
  {
    return jdField_a_of_type_Sfl;
  }
  
  private void bk(String paramString, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new VSUploadProgressManager.2(this, paramString, paramInt));
    }
    for (;;)
    {
      return;
      Object localObject = (List)this.fG.get(paramString);
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        sfl.b localb = ((sfl.c)((Iterator)localObject).next()).a();
        if (localb != null) {
          localb.bl(paramString, paramInt);
        }
      }
    }
    a().tc(paramString);
  }
  
  /* Error */
  public void aw(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 122
    //   4: ldc 124
    //   6: aload_1
    //   7: invokestatic 129	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   10: aload_0
    //   11: getfield 36	sfl:fF	Ljava/util/Map;
    //   14: aload_1
    //   15: invokeinterface 133 2 0
    //   20: ifeq +62 -> 82
    //   23: aload_0
    //   24: getfield 36	sfl:fF	Ljava/util/Map;
    //   27: aload_1
    //   28: invokeinterface 90 2 0
    //   33: checkcast 6	sfl$a
    //   36: astore_3
    //   37: aload_3
    //   38: aload_1
    //   39: putfield 137	sfl$a:id	Ljava/lang/String;
    //   42: aload_3
    //   43: ldc 139
    //   45: putfield 142	sfl$a:vid	Ljava/lang/String;
    //   48: aload_3
    //   49: iload_2
    //   50: putfield 146	sfl$a:aAU	Z
    //   53: aload_3
    //   54: iconst_0
    //   55: putfield 150	sfl$a:status	I
    //   58: aload_3
    //   59: iconst_0
    //   60: putfield 153	sfl$a:progress	I
    //   63: aload_3
    //   64: invokevirtual 156	sfl$a:startTimer	()V
    //   67: aload_0
    //   68: getfield 36	sfl:fF	Ljava/util/Map;
    //   71: aload_1
    //   72: aload_3
    //   73: invokeinterface 160 3 0
    //   78: pop
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: new 6	sfl$a
    //   85: dup
    //   86: aload_0
    //   87: aconst_null
    //   88: invokespecial 163	sfl$a:<init>	(Lsfl;Lsfm;)V
    //   91: astore_3
    //   92: goto -55 -> 37
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	sfl
    //   0	100	1	paramString	String
    //   0	100	2	paramBoolean	boolean
    //   36	56	3	locala	sfl.a
    // Exception table:
    //   from	to	target	type
    //   2	37	95	finally
    //   37	79	95	finally
    //   82	92	95	finally
  }
  
  public void blZ()
  {
    try
    {
      ram.d("Q.videostory.publish.upload.VSUploadProgressManager", "startANewUploadSeq");
      Iterator localIterator = this.fF.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((sfl.a)((Map.Entry)localIterator.next()).getValue()).stopTimer();
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
      ram.b("Q.videostory.publish.upload.VSUploadProgressManager", "sendProtoSuccess:%s", paramString1);
      if (this.fF.containsKey(paramString1))
      {
        sfl.a locala = (sfl.a)this.fF.get(paramString1);
        locala.status = 4;
        locala.progress = 100;
        locala.vid = paramString2;
        bk(paramString1, locala.progress);
        locala.stopTimer();
        this.fF.remove(paramString1);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean fU(String paramString)
  {
    return this.fF.containsKey(paramString);
  }
  
  public void qW(String paramString)
  {
    try
    {
      ram.b("Q.videostory.publish.upload.VSUploadProgressManager", "preparedSuccess:%s", paramString);
      if (this.fF.containsKey(paramString))
      {
        sfl.a locala = (sfl.a)this.fF.get(paramString);
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
      ram.b("Q.videostory.publish.upload.VSUploadProgressManager", "mergeVideoSuccess:%s", paramString);
      if (this.fF.containsKey(paramString))
      {
        sfl.a locala = (sfl.a)this.fF.get(paramString);
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
      ram.b("Q.videostory.publish.upload.VSUploadProgressManager", "uploadVideoSuccess:%s", paramString);
      if (this.fF.containsKey(paramString))
      {
        sfl.a locala = (sfl.a)this.fF.get(paramString);
        locala.status = 3;
        locala.progress = 90;
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
        sfl.a locala = (sfl.a)this.fF.get(paramString);
        locala.status = 5;
        locala.progress = 100;
        bk(paramString, locala.progress);
        locala.stopTimer();
        this.fF.remove(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void tc(String paramString)
  {
    if ((List)this.fG.get(paramString) == null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new sfl.c(this.jdField_a_of_type_Sfl$b));
      this.fG.put(paramString, localArrayList);
    }
  }
  
  public class a
  {
    public boolean aAU;
    private Runnable dn = new VSUploadProgressManager.ProgressStatus.1(this);
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
          } while (this.progress < 90);
          this.progress = 89;
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
      sfl.a(sfl.this).postDelayed(this.dn, 550L);
    }
    
    public void stopTimer()
    {
      this.mStopped = true;
      sfl.a(sfl.this).removeCallbacks(this.dn);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bl(String paramString, int paramInt);
  }
  
  static class c
  {
    private WeakReference<sfl.b> cQ;
    
    public c(sfl.b paramb)
    {
      this.cQ = new WeakReference(paramb);
    }
    
    @Nullable
    public sfl.b a()
    {
      return (sfl.b)this.cQ.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfl
 * JD-Core Version:    0.7.0.1
 */