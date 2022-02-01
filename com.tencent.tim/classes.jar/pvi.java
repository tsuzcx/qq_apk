import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class pvi
{
  public pni a;
  protected pvi.a a;
  private pvm.a a;
  protected pvm a;
  protected boolean aCe;
  protected final Set<String> aE = new CopyOnWriteArraySet();
  protected final Set<String> aF = new CopyOnWriteArraySet();
  protected AtomicBoolean aN = new AtomicBoolean(false);
  protected int bkF;
  private WeakReference<pvi.b> cS;
  protected final Queue<puh> q = new LinkedList();
  
  public pvi()
  {
    this.jdField_a_of_type_Pni = new pnp();
    this.jdField_a_of_type_Pvm$a = new pvl(this);
    this.jdField_a_of_type_Pvm = new pvm();
    this.jdField_a_of_type_Pni.vP(2);
    Object localObject = (psr)psx.a(10);
    this.bkF = ((Integer)((psr)localObject).c("key_story_msg_tab_node_preload", Integer.valueOf(0))).intValue();
    this.aCe = ((Boolean)((psr)localObject).c("key_story_msg_tab_node_preload_4g", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("消息TAB日迹预加载器wifi开关状态：");
      if (this.bkF <= 0) {
        break label213;
      }
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("MsgTabStoryVideoPreloader", 2, bool);
      QLog.i("MsgTabStoryVideoPreloader", 2, "消息TAB日迹预加载器4G开关状态：" + this.aCe);
      return;
    }
  }
  
  private Queue<puh> a(List<puh> paramList)
  {
    LinkedList localLinkedList;
    for (;;)
    {
      try
      {
        localLinkedList = new LinkedList();
        if ((paramList == null) || (paramList.isEmpty())) {
          break;
        }
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        puh localpuh = (puh)paramList.next();
        if ((localpuh != null) && (pvs.j(localpuh))) {
          if (localpuh.unreadCount > 0) {
            localLinkedList.add(localpuh);
          } else {
            this.aE.remove(localpuh.unionId);
          }
        }
      }
      finally {}
    }
    return localLinkedList;
  }
  
  private boolean az(Context paramContext)
  {
    boolean bool = true;
    switch (jqi.getNetworkType(paramContext))
    {
    case 2: 
    case 3: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "checkNetState() 非4g非wifi，不进行预下载");
      }
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "checkNetState() wifi");
        }
        this.jdField_a_of_type_Pvm.ss(true);
        this.jdField_a_of_type_Pvm.st(true);
      } while (this.bkF != 0);
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "checkNetState() 4g");
      }
      this.jdField_a_of_type_Pvm.ss(this.aCe);
      this.jdField_a_of_type_Pvm.st(false);
    } while ((this.aCe) && (this.bkF != 0));
    return false;
  }
  
  private void b(Queue<puh> paramQueue)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "添加一波要预加载的节点队列=" + paramQueue.size() + "\n" + paramQueue);
      }
      if (!this.aN.getAndSet(true))
      {
        ??? = a();
        if (??? != null) {
          ((pvi.b)???).onStart();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "预加载正式开始");
      }
      synchronized (this.q)
      {
        paramQueue = paramQueue.iterator();
        while (paramQueue.hasNext())
        {
          puh localpuh = (puh)paramQueue.next();
          if (!this.q.contains(localpuh)) {
            this.q.add(localpuh);
          }
        }
      }
    }
    finally {}
  }
  
  private void blW()
  {
    try
    {
      if (this.jdField_a_of_type_Pvi$a == null)
      {
        this.jdField_a_of_type_Pvi$a = new pvi.a();
        this.jdField_a_of_type_Pni.a(this.jdField_a_of_type_Pvi$a);
      }
      pnm localpnm = (pnm)psx.a(6);
      if (!localpnm.Iy()) {
        localpnm.blW();
      }
      return;
    }
    finally {}
  }
  
  private void ee(List<StoryVideoItem> paramList)
  {
    try
    {
      Bosses.get().postJob(new pvk(this, "MsgTabStoryVideoPreloader", paramList));
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  /* Error */
  public boolean Hp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	pvi:aE	Ljava/util/Set;
    //   6: invokeinterface 291 1 0
    //   11: istore_1
    //   12: aload_0
    //   13: getfield 101	pvi:bkF	I
    //   16: istore_2
    //   17: iload_1
    //   18: iload_2
    //   19: if_icmpge +9 -> 28
    //   22: iconst_1
    //   23: istore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_3
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_3
    //   30: goto -6 -> 24
    //   33: astore 4
    //   35: aload_0
    //   36: monitorexit
    //   37: aload 4
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	pvi
    //   11	9	1	i	int
    //   16	4	2	j	int
    //   23	7	3	bool	boolean
    //   33	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	33	finally
  }
  
  public pvi.b a()
  {
    if (this.cS != null) {
      return (pvi.b)this.cS.get();
    }
    return null;
  }
  
  public void a(pvi.b paramb)
  {
    this.cS = new WeakReference(paramb);
  }
  
  /* Error */
  public void az(String arg1, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	pvi:aF	Ljava/util/Set;
    //   6: aload_1
    //   7: invokeinterface 189 2 0
    //   12: pop
    //   13: aload_0
    //   14: getfield 58	pvi:aN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   17: invokevirtual 304	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   20: ifeq +83 -> 103
    //   23: aload_0
    //   24: getfield 49	pvi:q	Ljava/util/Queue;
    //   27: astore_1
    //   28: aload_1
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 49	pvi:q	Ljava/util/Queue;
    //   34: invokeinterface 305 1 0
    //   39: ifeq +67 -> 106
    //   42: aload_0
    //   43: getfield 51	pvi:aF	Ljava/util/Set;
    //   46: invokeinterface 306 1 0
    //   51: ifeq +55 -> 106
    //   54: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +12 -> 69
    //   60: ldc 130
    //   62: iconst_2
    //   63: ldc_w 308
    //   66: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload_0
    //   70: getfield 58	pvi:aN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   73: iconst_0
    //   74: invokevirtual 311	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   77: aload_0
    //   78: getfield 44	pvi:aE	Ljava/util/Set;
    //   81: invokeinterface 314 1 0
    //   86: aload_0
    //   87: invokevirtual 249	pvi:a	()Lpvi$b;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnull +9 -> 101
    //   95: aload_3
    //   96: invokeinterface 317 1 0
    //   101: aload_1
    //   102: monitorexit
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: iload_2
    //   107: ifeq -6 -> 101
    //   110: aload_0
    //   111: invokevirtual 320	pvi:bmX	()V
    //   114: goto -13 -> 101
    //   117: astore_3
    //   118: aload_1
    //   119: monitorexit
    //   120: aload_3
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	pvi
    //   0	127	2	paramBoolean	boolean
    //   90	6	3	localb	pvi.b
    //   117	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	69	117	finally
    //   69	91	117	finally
    //   95	101	117	finally
    //   101	103	117	finally
    //   110	114	117	finally
    //   118	120	117	finally
    //   2	30	122	finally
    //   120	122	122	finally
  }
  
  public void b(Context paramContext, List<puh> paramList)
  {
    if (paramContext == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new pvj(this, "MsgTabStoryVideoPreloader", paramContext, paramList));
  }
  
  protected void bmX()
  {
    for (;;)
    {
      try
      {
        synchronized (this.q)
        {
          if (this.q.isEmpty())
          {
            if (QLog.isColorLevel()) {
              QLog.i("MsgTabStoryVideoPreloader", 2, "节点信息都加载成功了");
            }
            return;
          }
          puh localpuh = (puh)this.q.poll();
          if (localpuh != null) {
            if (!TextUtils.isEmpty(localpuh.unionId)) {
              break label83;
            }
          }
        }
        if (Hp()) {
          break label145;
        }
      }
      finally {}
      label83:
      if (QLog.isColorLevel()) {
        QLog.w("MsgTabStoryVideoPreloader", 2, "预加载节点数到了指定阈值:" + this.bkF + "，不继续加载");
      }
      this.q.clear();
      continue;
      label145:
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "pull video info from node \n" + localObject2);
      }
      this.aE.add(localObject2.unionId);
      this.jdField_a_of_type_Pvm.a(localObject2, this.jdField_a_of_type_Pvm$a);
    }
  }
  
  /* Error */
  public void stopDownload()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	pvi:aN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_0
    //   7: invokevirtual 311	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 261	pvi:jdField_a_of_type_Pvi$a	Lpvi$a;
    //   15: aload_0
    //   16: getfield 39	pvi:jdField_a_of_type_Pni	Lpni;
    //   19: ifnull +12 -> 31
    //   22: aload_0
    //   23: getfield 39	pvi:jdField_a_of_type_Pni	Lpni;
    //   26: invokeinterface 362 1 0
    //   31: aload_0
    //   32: getfield 49	pvi:q	Ljava/util/Queue;
    //   35: astore_1
    //   36: aload_1
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 51	pvi:aF	Ljava/util/Set;
    //   42: invokeinterface 314 1 0
    //   47: aload_0
    //   48: getfield 49	pvi:q	Ljava/util/Queue;
    //   51: invokeinterface 352 1 0
    //   56: aload_0
    //   57: getfield 44	pvi:aE	Ljava/util/Set;
    //   60: invokeinterface 314 1 0
    //   65: aload_1
    //   66: monitorexit
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: astore_2
    //   71: aload_1
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pvi
    //   75	4	1	localObject1	Object
    //   70	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	67	70	finally
    //   71	73	70	finally
    //   2	31	75	finally
    //   31	38	75	finally
    //   73	75	75	finally
  }
  
  class a
    extends pnn
  {
    private final Set<String> aG = new HashSet();
    
    public a()
    {
      super();
    }
    
    public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, png parampng)
    {
      super.a(paramString, paramInt1, paramErrorMessage, paramInt2, parampng);
      if (paramInt2 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgTabStoryVideoPreloader", 2, "download error: vid=" + paramString + " fileType=" + paramInt1, paramErrorMessage);
        }
        pvi.this.az(parampng.originalUrl, true);
      }
    }
    
    public void a(String paramString, int paramInt1, File paramFile, int paramInt2, png parampng)
    {
      super.a(paramString, paramInt1, paramFile, paramInt2, parampng);
      if (paramInt2 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download success before: vid=" + paramString + " fileType=" + paramInt1);
        }
        pvi.this.az(parampng.originalUrl, true);
      }
    }
    
    public void b(String paramString, int paramInt1, File paramFile, int paramInt2, png parampng)
    {
      super.b(paramString, paramInt1, paramFile, paramInt2, parampng);
      if (paramInt2 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download success: vid=" + paramString + " fileType=" + paramInt1);
        }
        pvi.this.az(parampng.originalUrl, this.aG.add(paramString));
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onFinish();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvi
 * JD-Core Version:    0.7.0.1
 */