import android.os.StatFs;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class avsx
  implements avsw.a
{
  private static Comparator<File> fileTimeComparator = new avta();
  private static FilenameFilter filenameFilter = new avsz();
  private final avsx.a a;
  private final AtomicInteger mCounter = new AtomicInteger(0);
  private long mLastWarnTime;
  private Future mPendingFuture;
  private int mWarnCount;
  
  public avsx(avsx.a parama)
  {
    this.a = parama;
  }
  
  private long bq(String paramString)
  {
    long l2 = 0L;
    paramString = new File(paramString);
    long l1 = l2;
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label42;
      }
      l1 = 0L + paramString.length();
      FileUtils.delete(paramString);
    }
    label42:
    do
    {
      return l1;
      l1 = l2;
    } while (!paramString.isDirectory());
    paramString = paramString.listFiles();
    int i = 0;
    for (;;)
    {
      l1 = l2;
      if (i >= paramString.length) {
        break;
      }
      l2 += bq(paramString[i].getAbsolutePath());
      i += 1;
    }
  }
  
  private int calculateRemainSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return paramInt1;
    }
    if (paramInt2 / paramInt1 < 0.12F) {}
    for (float f = 0.05F;; f = 0.1F) {
      return (int)(f * paramInt1);
    }
  }
  
  private void eBP()
  {
    if (!shouldShowWarning()) {
      return;
    }
    QQToast.a(BaseApplication.getContext(), 2131690215, 1).show();
  }
  
  private int fX(String paramString)
  {
    int j = 0;
    int k = 0;
    paramString = new File(paramString);
    int i = j;
    if (paramString.exists())
    {
      i = j;
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles(filenameFilter);
        i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.length > 0)
          {
            i = 0;
            if (k < paramString.length)
            {
              j = i;
              if (paramString[k] != null)
              {
                j = i;
                if (paramString[k].getName() != null) {
                  if (!paramString[k].isDirectory()) {
                    break label118;
                  }
                }
              }
              label118:
              for (j = i + fX(paramString[k].getAbsolutePath());; j = (int)(i + paramString[k].length()))
              {
                k += 1;
                i = j;
                break;
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  private boolean shouldShowWarning()
  {
    long l1 = ((1.0F - 1.0F / (this.mWarnCount / 6.0F + 1.0F)) * 1800000.0F);
    long l2 = System.currentTimeMillis();
    if (l2 - this.mLastWarnTime >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (this.mWarnCount < 2147483647) {
          this.mWarnCount += 1;
        }
        this.mLastWarnTime = l2;
      }
      return bool;
    }
  }
  
  public static boolean tA(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l < 20971520L) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          QLog.w("CacheManager", 1, "low storage: totalSize=" + localStatFs.getBlockCount() * localStatFs.getBlockSize() + ", availableSize=" + l + ", external=" + paramString);
        }
        return bool;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      QLog.e("CacheManager", 1, "", paramString);
    }
  }
  
  public void R(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        paramString = new File(paramString);
        Object localObject;
        int i;
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          localObject = paramString.listFiles(filenameFilter);
          if ((localObject != null) && (localObject.length > 0))
          {
            paramString = new ArrayList(localObject.length);
            i = 0;
            if (i < localObject.length)
            {
              paramString.add(localObject[i]);
              i += 1;
              continue;
            }
            Collections.sort(paramString, fileTimeComparator);
          }
        }
        try
        {
          int j = paramString.size() - 1;
          i = paramInt1;
          paramInt1 = j;
          if (paramInt1 > 0)
          {
            localObject = ((File)paramString.get(paramInt1)).getAbsolutePath();
            l2 = bq((String)localObject);
            i = (int)(i - l2);
            localObject = new File((String)localObject + ".headers");
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            if (i >= paramInt2) {
              break label247;
            }
          }
        }
        catch (Exception paramString)
        {
          long l2;
          paramString.printStackTrace();
          continue;
        }
        l2 = System.currentTimeMillis();
        QLog.w("CacheManager", 1, "onLowStorage time:" + (l2 - l1));
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("CacheManager", 1, "", paramString);
        return;
      }
      label247:
      paramInt1 -= 1;
    }
  }
  
  public void a(avsw paramavsw, boolean paramBoolean)
  {
    if (this.mCounter.getAndIncrement() < 2) {
      return;
    }
    this.mCounter.set(0);
    try
    {
      if ((this.mPendingFuture != null) && (!this.mPendingFuture.isDone())) {
        return;
      }
    }
    finally {}
    this.mPendingFuture = PriorityThreadPool.getDefault().submit(new avsy(this, paramBoolean));
  }
  
  public void eBQ()
  {
    try
    {
      if ((this.mPendingFuture != null) && (!this.mPendingFuture.isDone())) {
        return;
      }
      boolean bool = avsu.isExternalAvailable();
      this.mPendingFuture = PriorityThreadPool.getDefault().submit(new avtb(this, bool));
      return;
    }
    finally {}
  }
  
  /* Error */
  public void gT(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 68	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 75	java/io/File:exists	()Z
    //   16: ifeq +238 -> 254
    //   19: aload_1
    //   20: invokevirtual 91	java/io/File:isDirectory	()Z
    //   23: ifeq +231 -> 254
    //   26: aload_1
    //   27: getstatic 32	avsx:filenameFilter	Ljava/io/FilenameFilter;
    //   30: invokevirtual 126	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   33: astore 11
    //   35: aload 11
    //   37: ifnull +217 -> 254
    //   40: aload 11
    //   42: arraylength
    //   43: ifle +211 -> 254
    //   46: lconst_0
    //   47: lstore 5
    //   49: iconst_0
    //   50: istore_3
    //   51: iload_3
    //   52: aload 11
    //   54: arraylength
    //   55: if_icmpge +22 -> 77
    //   58: lload 5
    //   60: aload 11
    //   62: iload_3
    //   63: aaload
    //   64: invokevirtual 82	java/io/File:length	()J
    //   67: ladd
    //   68: lstore 5
    //   70: iload_3
    //   71: iconst_1
    //   72: iadd
    //   73: istore_3
    //   74: goto -23 -> 51
    //   77: lload 5
    //   79: iload_2
    //   80: i2l
    //   81: lcmp
    //   82: ifle +172 -> 254
    //   85: ldc 159
    //   87: iconst_1
    //   88: ldc_w 268
    //   91: invokestatic 187	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: iload_2
    //   95: i2f
    //   96: ldc_w 269
    //   99: fmul
    //   100: f2l
    //   101: lstore 9
    //   103: new 199	java/util/ArrayList
    //   106: dup
    //   107: aload 11
    //   109: arraylength
    //   110: invokespecial 200	java/util/ArrayList:<init>	(I)V
    //   113: astore_1
    //   114: iload 4
    //   116: istore_2
    //   117: iload_2
    //   118: aload 11
    //   120: arraylength
    //   121: if_icmpge +19 -> 140
    //   124: aload_1
    //   125: aload 11
    //   127: iload_2
    //   128: aaload
    //   129: invokevirtual 204	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   132: pop
    //   133: iload_2
    //   134: iconst_1
    //   135: iadd
    //   136: istore_2
    //   137: goto -20 -> 117
    //   140: aload_1
    //   141: getstatic 37	avsx:fileTimeComparator	Ljava/util/Comparator;
    //   144: invokestatic 210	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   147: aload_1
    //   148: invokevirtual 213	java/util/ArrayList:size	()I
    //   151: iconst_1
    //   152: isub
    //   153: istore_2
    //   154: iload_2
    //   155: ifle +99 -> 254
    //   158: aload_1
    //   159: iload_2
    //   160: invokevirtual 217	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   163: checkcast 68	java/io/File
    //   166: astore 11
    //   168: aload 11
    //   170: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   173: astore 12
    //   175: lload 5
    //   177: lstore 7
    //   179: aload 11
    //   181: invokevirtual 75	java/io/File:exists	()Z
    //   184: ifeq +19 -> 203
    //   187: lload 5
    //   189: aload 11
    //   191: invokevirtual 82	java/io/File:length	()J
    //   194: lsub
    //   195: lstore 7
    //   197: aload 11
    //   199: invokevirtual 221	java/io/File:delete	()Z
    //   202: pop
    //   203: new 68	java/io/File
    //   206: dup
    //   207: new 161	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   214: aload 12
    //   216: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 219
    //   221: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   230: astore 11
    //   232: aload 11
    //   234: invokevirtual 75	java/io/File:exists	()Z
    //   237: ifeq +9 -> 246
    //   240: aload 11
    //   242: invokevirtual 221	java/io/File:delete	()Z
    //   245: pop
    //   246: lload 7
    //   248: lload 9
    //   250: lcmp
    //   251: ifge +4 -> 255
    //   254: return
    //   255: iload_2
    //   256: iconst_1
    //   257: isub
    //   258: istore_2
    //   259: lload 7
    //   261: lstore 5
    //   263: goto -109 -> 154
    //   266: astore_1
    //   267: aload_1
    //   268: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   271: return
    //   272: astore_1
    //   273: ldc 159
    //   275: iconst_1
    //   276: ldc 189
    //   278: aload_1
    //   279: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	avsx
    //   0	283	1	paramString	String
    //   0	283	2	paramInt	int
    //   50	24	3	i	int
    //   1	114	4	j	int
    //   47	215	5	l1	long
    //   177	83	7	l2	long
    //   101	148	9	l3	long
    //   33	208	11	localObject	Object
    //   173	42	12	str	String
    // Exception table:
    //   from	to	target	type
    //   147	154	266	java/lang/Exception
    //   158	175	266	java/lang/Exception
    //   179	203	266	java/lang/Exception
    //   203	246	266	java/lang/Exception
    //   3	35	272	java/lang/Throwable
    //   40	46	272	java/lang/Throwable
    //   51	70	272	java/lang/Throwable
    //   85	94	272	java/lang/Throwable
    //   103	114	272	java/lang/Throwable
    //   117	133	272	java/lang/Throwable
    //   140	147	272	java/lang/Throwable
    //   147	154	272	java/lang/Throwable
    //   158	175	272	java/lang/Throwable
    //   179	203	272	java/lang/Throwable
    //   203	246	272	java/lang/Throwable
    //   267	271	272	java/lang/Throwable
  }
  
  public static abstract interface a
  {
    public abstract Collection<avsw> collect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsx
 * JD-Core Version:    0.7.0.1
 */