import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class pxd
{
  protected String TAG = "Q.qqstory.net:BatchHandlerListPuller";
  protected pxd.a a;
  protected boolean aCw;
  protected AtomicBoolean aO = new AtomicBoolean(false);
  protected AtomicBoolean aQ = new AtomicBoolean(false);
  protected List<pxe> mH = new ArrayList();
  protected List<pxe> mI = new ArrayList();
  protected List<pxe> mJ = new ArrayList();
  protected List<pxe> mK = new ArrayList();
  
  public pxd(List<pxe> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.aCw = true;
      this.aQ.set(true);
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((pxe)localIterator.next()).a(this);
    }
    this.mH = new ArrayList(paramList);
  }
  
  public static pxd a(ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int j;
    for (int i = 0;; i = j)
    {
      if (i < paramArrayList.size())
      {
        j = Math.min(paramArrayList.size(), i + 20);
        if (i < j) {}
      }
      else
      {
        return new pxd(localArrayList1);
      }
      List localList = paramArrayList.subList(i, j);
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      while (i < localList.size())
      {
        localArrayList2.add(new QQUserUIItem.a("", (String)localList.get(i)));
        i += 1;
      }
      localArrayList1.add(new pxs(1, localArrayList2));
    }
  }
  
  public static pxd a(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    psu localpsu = (psu)psx.a(5);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!StoryVideoItem.isFakeVid(str))
      {
        StoryVideoItem localStoryVideoItem = localpsu.a(str);
        if ((localStoryVideoItem == null) || (localStoryVideoItem.mBasicInfoState != 1) || (localStoryVideoItem.mVideoIndex == 0L)) {
          localArrayList.add(str);
        }
      }
    }
    paramList = new ArrayList();
    int j;
    for (int i = 0;; i = j)
    {
      if (i < localArrayList.size())
      {
        j = Math.min(localArrayList.size(), i + 20);
        if (i < j) {}
      }
      else
      {
        return new pxd(paramList);
      }
      paramList.add(new pyc(localArrayList.subList(i, j)));
    }
  }
  
  public boolean Jo()
  {
    return this.aQ.get();
  }
  
  public void a(pxd.a parama)
  {
    this.a = parama;
  }
  
  /* Error */
  public void a(pxe parampxe)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	pxd:mI	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 166 2 0
    //   12: pop
    //   13: aload_0
    //   14: getfield 39	pxd:mJ	Ljava/util/List;
    //   17: aload_1
    //   18: invokeinterface 123 2 0
    //   23: pop
    //   24: aload_0
    //   25: getfield 50	pxd:aQ	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 37	pxd:mI	Ljava/util/List;
    //   33: invokeinterface 56 1 0
    //   38: ifne +105 -> 143
    //   41: aload_0
    //   42: getfield 41	pxd:mK	Ljava/util/List;
    //   45: invokeinterface 56 1 0
    //   50: ifne +93 -> 143
    //   53: iconst_1
    //   54: istore_2
    //   55: aload_1
    //   56: iload_2
    //   57: invokevirtual 61	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   60: aload_0
    //   61: getfield 37	pxd:mI	Ljava/util/List;
    //   64: invokeinterface 56 1 0
    //   69: ifne +71 -> 140
    //   72: aload_0
    //   73: getfield 162	pxd:a	Lpxd$a;
    //   76: ifnull +19 -> 95
    //   79: aload_0
    //   80: getfield 162	pxd:a	Lpxd$a;
    //   83: aload_0
    //   84: getfield 50	pxd:aQ	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   87: invokevirtual 159	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   90: invokeinterface 169 2 0
    //   95: aload_0
    //   96: getfield 30	pxd:TAG	Ljava/lang/String;
    //   99: astore_3
    //   100: new 171	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   107: ldc 174
    //   109: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: astore 4
    //   114: aload_0
    //   115: getfield 50	pxd:aQ	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   118: invokevirtual 159	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   121: ifeq +27 -> 148
    //   124: ldc 180
    //   126: astore_1
    //   127: aload_3
    //   128: aload 4
    //   130: aload_1
    //   131: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 189	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: iconst_0
    //   144: istore_2
    //   145: goto -90 -> 55
    //   148: new 171	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   155: aload_0
    //   156: getfield 41	pxd:mK	Ljava/util/List;
    //   159: invokeinterface 56 1 0
    //   164: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc 194
    //   169: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: astore_1
    //   176: goto -49 -> 127
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	pxd
    //   0	184	1	parampxe	pxe
    //   54	91	2	bool	boolean
    //   99	29	3	str	String
    //   112	17	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	53	179	finally
    //   55	95	179	finally
    //   95	124	179	finally
    //   127	140	179	finally
    //   148	176	179	finally
  }
  
  /* Error */
  public void b(pxe parampxe)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 48	pxd:aO	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   8: invokevirtual 159	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   11: ifeq +8 -> 19
    //   14: aload_1
    //   15: invokevirtual 198	pxe:retry	()Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifne +135 -> 155
    //   23: aload_0
    //   24: getfield 37	pxd:mI	Ljava/util/List;
    //   27: aload_1
    //   28: invokeinterface 166 2 0
    //   33: pop
    //   34: aload_0
    //   35: getfield 41	pxd:mK	Ljava/util/List;
    //   38: aload_1
    //   39: invokeinterface 123 2 0
    //   44: pop
    //   45: aload_0
    //   46: getfield 50	pxd:aQ	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   49: iconst_0
    //   50: invokevirtual 61	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   53: aload_0
    //   54: getfield 37	pxd:mI	Ljava/util/List;
    //   57: invokeinterface 56 1 0
    //   62: ifne +73 -> 135
    //   65: aload_0
    //   66: getfield 162	pxd:a	Lpxd$a;
    //   69: ifnull +19 -> 88
    //   72: aload_0
    //   73: getfield 162	pxd:a	Lpxd$a;
    //   76: aload_0
    //   77: getfield 50	pxd:aQ	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   80: invokevirtual 159	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   83: invokeinterface 169 2 0
    //   88: aload_0
    //   89: getfield 30	pxd:TAG	Ljava/lang/String;
    //   92: astore 4
    //   94: new 171	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   101: ldc 174
    //   103: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 50	pxd:aQ	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   112: invokevirtual 159	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   115: ifeq +43 -> 158
    //   118: ldc 180
    //   120: astore_3
    //   121: aload 4
    //   123: aload 5
    //   125: aload_3
    //   126: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 189	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield 30	pxd:TAG	Ljava/lang/String;
    //   139: ldc 200
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: aastore
    //   149: invokestatic 204	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   152: invokestatic 189	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: monitorexit
    //   157: return
    //   158: new 171	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   165: aload_0
    //   166: getfield 41	pxd:mK	Ljava/util/List;
    //   169: invokeinterface 56 1 0
    //   174: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: ldc 194
    //   179: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: astore_3
    //   186: goto -65 -> 121
    //   189: astore_1
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	pxd
    //   0	194	1	parampxe	pxe
    //   1	19	2	bool	boolean
    //   120	66	3	str1	String
    //   92	30	4	str2	String
    //   106	18	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	19	189	finally
    //   23	88	189	finally
    //   88	118	189	finally
    //   121	135	189	finally
    //   135	155	189	finally
    //   158	186	189	finally
  }
  
  public void destroy()
  {
    try
    {
      this.aO.set(false);
      this.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isBusy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	pxd:mI	Ljava/util/List;
    //   6: invokeinterface 56 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifle +9 -> 22
    //   16: iconst_1
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_2
    //   24: goto -6 -> 18
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	pxd
    //   11	2	1	i	int
    //   17	7	2	bool	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.aO.get();
        if (bool) {
          return;
        }
        this.aO.set(true);
        if (this.aCw)
        {
          ram.w(this.TAG, "Task list is empty , return result now");
          if (this.a == null) {
            continue;
          }
          this.a.sx(this.aQ.get());
          continue;
        }
        localIterator = this.mH.iterator();
      }
      finally {}
      Iterator localIterator;
      int i = 0;
      while (localIterator.hasNext())
      {
        pxe localpxe = (pxe)localIterator.next();
        this.mI.add(localpxe);
        localpxe.sendRequest();
        i += 1;
      }
      this.mH.clear();
      ram.w(this.TAG, "Run! Request count = %d", new Object[] { Integer.valueOf(i) });
    }
  }
  
  public void setTag(String paramString)
  {
    this.TAG = (paramString + ":BatchHandlerListPuller");
  }
  
  public static abstract interface a
  {
    public abstract void sx(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxd
 * JD-Core Version:    0.7.0.1
 */