import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class ahzw
  implements URLDrawable.DownloadListener
{
  private LinkedList<URLDrawable> V = new LinkedList();
  private HotPicPageView a;
  private Set<Integer> cD = new HashSet();
  SparseArray<URLDrawable> cN = new SparseArray();
  boolean cjv = false;
  boolean cjw = false;
  int dcP = 1;
  private Object eb = new Object();
  volatile int mRunningCount = 0;
  
  public ahzw(HotPicPageView paramHotPicPageView)
  {
    this.a = paramHotPicPageView;
    if (this.a.mPostion == 0)
    {
      KN(true);
      return;
    }
    KN(false);
  }
  
  /* Error */
  private void drD()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	ahzw:eb	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 53	ahzw:mRunningCount	I
    //   14: iconst_1
    //   15: isub
    //   16: putfield 53	ahzw:mRunningCount	I
    //   19: aload_0
    //   20: getfield 53	ahzw:mRunningCount	I
    //   23: aload_0
    //   24: getfield 34	ahzw:dcP	I
    //   27: if_icmpge +88 -> 115
    //   30: aload_0
    //   31: getfield 41	ahzw:V	Ljava/util/LinkedList;
    //   34: invokevirtual 72	java/util/LinkedList:size	()I
    //   37: ifle +78 -> 115
    //   40: aload_0
    //   41: getfield 41	ahzw:V	Ljava/util/LinkedList;
    //   44: invokevirtual 76	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   47: checkcast 78	com/tencent/image/URLDrawable
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 81	com/tencent/image/URLDrawable:getStatus	()I
    //   55: iconst_1
    //   56: if_icmpeq -37 -> 19
    //   59: aload_2
    //   60: invokevirtual 81	com/tencent/image/URLDrawable:getStatus	()I
    //   63: iconst_2
    //   64: if_icmpne +94 -> 158
    //   67: aload_2
    //   68: invokevirtual 84	com/tencent/image/URLDrawable:restartDownload	()V
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 53	ahzw:mRunningCount	I
    //   76: iconst_1
    //   77: iadd
    //   78: putfield 53	ahzw:mRunningCount	I
    //   81: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +31 -> 115
    //   87: ldc 92
    //   89: iconst_2
    //   90: new 94	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   97: ldc 97
    //   99: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 53	ahzw:mRunningCount	I
    //   106: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_0
    //   116: getfield 53	ahzw:mRunningCount	I
    //   119: ifne +34 -> 153
    //   122: aload_0
    //   123: getfield 41	ahzw:V	Ljava/util/LinkedList;
    //   126: invokevirtual 72	java/util/LinkedList:size	()I
    //   129: ifne +24 -> 153
    //   132: aload_0
    //   133: getfield 57	ahzw:a	Lcom/tencent/mobileqq/hotpic/HotPicPageView;
    //   136: ifnull +17 -> 153
    //   139: aload_0
    //   140: getfield 32	ahzw:cjv	Z
    //   143: ifeq +10 -> 153
    //   146: aload_0
    //   147: getfield 57	ahzw:a	Lcom/tencent/mobileqq/hotpic/HotPicPageView;
    //   150: invokevirtual 115	com/tencent/mobileqq/hotpic/HotPicPageView:px	()V
    //   153: aload_1
    //   154: monitorexit
    //   155: aload_0
    //   156: monitorexit
    //   157: return
    //   158: aload_2
    //   159: invokevirtual 118	com/tencent/image/URLDrawable:startDownload	()V
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 53	ahzw:mRunningCount	I
    //   167: iconst_1
    //   168: iadd
    //   169: putfield 53	ahzw:mRunningCount	I
    //   172: goto -57 -> 115
    //   175: astore_2
    //   176: aload_1
    //   177: monitorexit
    //   178: aload_2
    //   179: athrow
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	ahzw
    //   180	4	1	localObject2	Object
    //   50	109	2	localURLDrawable	URLDrawable
    //   175	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	19	175	finally
    //   19	115	175	finally
    //   115	153	175	finally
    //   153	155	175	finally
    //   158	172	175	finally
    //   176	178	175	finally
    //   2	9	180	finally
    //   178	180	180	finally
  }
  
  public void KM(boolean paramBoolean)
  {
    this.cjw = paramBoolean;
  }
  
  public void KN(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.cjv = true;
      if (this.cjv) {}
      for (int i = 3;; i = 4)
      {
        this.dcP = i;
        return;
      }
    }
    this.cjv = false;
    this.dcP = 1;
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    for (;;)
    {
      try
      {
        synchronized (this.eb)
        {
          if (this.cD.contains(Integer.valueOf(paramInt))) {
            return;
          }
          this.cD.add(Integer.valueOf(paramInt));
          paramURLDrawable.setDownloadListener(this);
          if (this.mRunningCount < this.dcP) {
            break label154;
          }
          if (!this.V.contains(paramURLDrawable))
          {
            paramURLDrawable.setAutoDownload(false);
            this.V.addFirst(paramURLDrawable);
            int i = this.V.size();
            if (!this.cjw) {
              break label148;
            }
            paramInt = 20;
            if (i > paramInt)
            {
              paramURLDrawable = (URLDrawable)this.V.removeLast();
              paramURLDrawable.setAutoDownload(true);
              paramURLDrawable.setDownloadListener(null);
            }
          }
        }
        paramInt = 15;
      }
      finally {}
      label148:
      continue;
      label154:
      if (paramURLDrawable.getStatus() == 2) {
        paramURLDrawable.restartDownload();
      }
      this.mRunningCount += 1;
    }
  }
  
  public void d(int paramInt, URLDrawable paramURLDrawable)
  {
    this.cN.put(paramInt, paramURLDrawable);
    paramURLDrawable.startDownload();
    a(paramURLDrawable, paramInt);
  }
  
  public void drC()
  {
    try
    {
      drD();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.cN.remove(paramInt);
    this.cD.remove(Integer.valueOf(paramInt));
    drD();
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    int i = (int)paramLong;
    this.cN.remove(i);
    this.cD.remove(Integer.valueOf(i));
    this.a.PC(i);
    drD();
  }
  
  public void reset()
  {
    int i = 0;
    synchronized (this.eb)
    {
      Iterator localIterator = this.V.iterator();
      if (localIterator.hasNext()) {
        ((URLDrawable)localIterator.next()).setDownloadListener(null);
      }
    }
    this.V.clear();
    while (i < this.cN.size())
    {
      ((URLDrawable)this.cN.valueAt(0)).setDownloadListener(null);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzw
 * JD-Core Version:    0.7.0.1
 */