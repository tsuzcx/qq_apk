import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotPicPageView.c;
import com.tencent.mobileqq.hotpic.HotVideoBlurTaskManager.1;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ahzp
{
  public static boolean cjr;
  static ArrayList<WeakReference<ahzp>> xo = new ArrayList();
  boolean cjs = false;
  public ArrayMap<HotVideoData, HotPicPageView.c> l = new ArrayMap();
  public Context mContext;
  
  ahzp(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static void KL(boolean paramBoolean)
  {
    for (;;)
    {
      WeakReference localWeakReference;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = xo.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          localArrayList.add(localWeakReference);
          continue;
        }
        localahzp = (ahzp)localWeakReference.get();
      }
      finally {}
      ahzp localahzp;
      if (localahzp == null) {
        localObject.add(localWeakReference);
      } else if ((paramBoolean) && (!localahzp.cjs)) {
        localahzp.drx();
      }
    }
  }
  
  /* Error */
  public static ahzp a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: invokestatic 68	ahzp:KL	(Z)V
    //   7: aload_0
    //   8: ifnonnull +10 -> 18
    //   11: aconst_null
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 2	ahzp
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 70	ahzp:<init>	(Landroid/content/Context;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: getstatic 24	ahzp:xo	Ljava/util/ArrayList;
    //   32: invokevirtual 74	java/util/ArrayList:size	()I
    //   35: iconst_3
    //   36: if_icmpge -23 -> 13
    //   39: getstatic 24	ahzp:xo	Ljava/util/ArrayList;
    //   42: new 54	java/lang/ref/WeakReference
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 77	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   50: invokevirtual 58	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_1
    //   55: astore_0
    //   56: goto -43 -> 13
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramContext	Context
    //   26	29	1	localahzp	ahzp
    // Exception table:
    //   from	to	target	type
    //   3	7	59	finally
    //   18	27	59	finally
    //   29	54	59	finally
  }
  
  public static void a(ahzp paramahzp)
  {
    for (;;)
    {
      try
      {
        KL(false);
        if (paramahzp == null) {
          return;
        }
        if (xo.size() < 3)
        {
          Iterator localIterator = xo.iterator();
          int i;
          if (localIterator.hasNext())
          {
            Object localObject = (WeakReference)localIterator.next();
            if (localObject != null)
            {
              localObject = (ahzp)((WeakReference)localObject).get();
              if ((localObject != null) && (paramahzp.equals(localObject)))
              {
                i = 1;
                if (i == 0) {
                  xo.add(new WeakReference(paramahzp));
                }
              }
            }
          }
          else
          {
            i = 0;
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public static void b(ahzp paramahzp)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: invokestatic 68	ahzp:KL	(Z)V
    //   7: aload_0
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 24	ahzp:xo	Ljava/util/ArrayList;
    //   18: invokevirtual 42	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   21: astore_1
    //   22: aload_1
    //   23: invokeinterface 48 1 0
    //   28: ifeq -17 -> 11
    //   31: aload_1
    //   32: invokeinterface 52 1 0
    //   37: checkcast 54	java/lang/ref/WeakReference
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull -20 -> 22
    //   45: aload_2
    //   46: invokevirtual 61	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   49: checkcast 2	ahzp
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull -32 -> 22
    //   57: aload_0
    //   58: aload_3
    //   59: invokevirtual 81	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   62: ifeq -40 -> 22
    //   65: getstatic 24	ahzp:xo	Ljava/util/ArrayList;
    //   68: aload_2
    //   69: invokevirtual 85	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: goto -62 -> 11
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramahzp	ahzp
    //   21	11	1	localIterator	Iterator
    //   40	29	2	localWeakReference	WeakReference
    //   52	7	3	localahzp	ahzp
    // Exception table:
    //   from	to	target	type
    //   3	7	76	finally
    //   15	22	76	finally
    //   22	41	76	finally
    //   45	53	76	finally
    //   57	73	76	finally
  }
  
  public static void dry()
  {
    cjr = true;
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoBlurTaskManager", 2, "pauseAllBlurTask HotVideoBlurTaskLock is:" + cjr);
    }
  }
  
  public static void drz()
  {
    cjr = false;
    KL(true);
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoBlurTaskManager", 2, "resmueAllBlurTask HotVideoBlurTaskLock is:" + cjr + " TaskManagerList size is " + xo.size());
    }
  }
  
  public void a(HotPicPageView.c paramc, HotVideoData paramHotVideoData)
  {
    if ((paramc == null) || (paramHotVideoData == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.l.containsKey(paramHotVideoData))
        {
          int i = this.l.indexOfKey(paramHotVideoData);
          this.l.setValueAt(i, paramc);
          if (QLog.isColorLevel()) {
            QLog.d("HotVideoBlurTaskManager", 2, "AddBlurTask HotVideoData.Name is:" + paramHotVideoData.name + " mBlurTasks size is " + this.l.size());
          }
          if (this.cjs) {
            break;
          }
          drx();
          break;
        }
      }
      finally {}
      this.l.put(paramHotVideoData, paramc);
    }
  }
  
  public void b(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.l.containsKey(paramHotVideoData)) {
          this.l.remove(paramHotVideoData);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HotVideoBlurTaskManager", 2, "RemoveTaskByData HotVideoData.Name is:" + paramHotVideoData.name + " mBlurTasks size is " + this.l.size());
      }
      finally {}
    }
  }
  
  public void drx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoBlurTaskManager", 2, "tryStartBlurTask HotVideoBlurTaskLock is:" + cjr);
    }
    if ((this.l.size() == 0) || (cjr))
    {
      this.cjs = false;
      return;
    }
    this.cjs = true;
    ThreadManager.post(new HotVideoBlurTaskManager.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzp
 * JD-Core Version:    0.7.0.1
 */