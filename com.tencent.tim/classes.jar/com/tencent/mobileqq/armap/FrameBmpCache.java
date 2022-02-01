package com.tencent.mobileqq.armap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;

public class FrameBmpCache
{
  LinkedList<CancelAbleRunnable> R = new LinkedList();
  private long VC;
  volatile CancelAbleRunnable jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable;
  private a jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$a;
  public boolean bQQ;
  private volatile boolean bQR;
  private boolean bQS;
  private boolean bQT = true;
  public int cJZ = (int)(this.fps / 2.0F);
  private int cKa;
  private int cKb;
  private Bitmap eJ;
  public int fps = 10;
  private long interval = 1000 / this.fps;
  public boolean isEnd;
  private volatile boolean isStop;
  public MQLruCache<String, Object> l = BaseApplicationImpl.sImageCache;
  private int mCurrentIndex = -1;
  private int mLastIndex;
  Object mLock = new Object();
  Resources mResources;
  public List<String> yq;
  
  public FrameBmpCache(Resources paramResources)
  {
    this.mResources = paramResources;
  }
  
  private void LA(int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.mLock)
      {
        LinkedList localLinkedList = new LinkedList();
        i = paramInt;
        if ((i >= paramInt + 3) || ((i >= this.yq.size()) && (!this.bQS)))
        {
          if (localLinkedList.size() > 0)
          {
            this.R.addAll(0, localLinkedList);
            if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable == null) {
              cUv();
            }
          }
          return;
        }
        Object localObject1 = (String)this.yq.get(gR(i));
        if (this.l.get(localObject1) == null) {
          break label224;
        }
        break label217;
        if (j >= this.R.size()) {
          break label211;
        }
        if (gR(((CancelAbleRunnable)this.R.get(j)).index) == gR(i))
        {
          localObject1 = (CancelAbleRunnable)this.R.remove(j);
          Object localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = new CancelAbleRunnable(i);
          }
          localLinkedList.add(localObject4);
        }
      }
      j += 1;
      continue;
      label211:
      Object localObject3 = null;
      continue;
      label217:
      i += 1;
      continue;
      label224:
      int j = 0;
    }
  }
  
  private void Q()
  {
    if (this.yq == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.yq.size())
      {
        Bitmap localBitmap = (Bitmap)this.l.get(this.yq.get(i));
        if ((localBitmap != null) && (localBitmap != this.eJ)) {
          this.l.remove(this.yq.get(i));
        }
        i += 1;
      }
    }
  }
  
  private void cUv()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable = ((CancelAbleRunnable)this.R.poll());
    if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameBmpCache", 2, "keepRunning " + this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable);
      }
      ThreadManager.postImmediately(this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable, null, true);
    }
  }
  
  private Bitmap decodeBitmap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      if ((!this.bQT) || (this.mResources.getDisplayMetrics().density < 2.0F)) {}
      for (localOptions.inSampleSize = 2;; localOptions.inSampleSize = 1)
      {
        localOptions.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(paramString, localOptions);
      }
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("FrameBmpCache", 2, "decodeBitmap oom", paramString);
        return null;
      }
      QLog.e("FrameBmpCache", 2, "ecodeBitmap oom " + paramString.getMessage());
    }
  }
  
  private int gR(int paramInt)
  {
    return paramInt % this.yq.size();
  }
  
  private void reset()
  {
    this.isStop = true;
    this.isEnd = false;
    this.mCurrentIndex = -1;
    this.mLastIndex = 0;
    this.cKa = 0;
    this.interval = (1000 / this.fps);
    synchronized (this.mLock)
    {
      this.R.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable.cancel();
        this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable = null;
      }
      return;
    }
  }
  
  public void GK(boolean paramBoolean)
  {
    this.bQR = paramBoolean;
  }
  
  public void cUw()
  {
    this.mCurrentIndex = 0;
    this.mLastIndex = 0;
    this.cKa = 0;
    this.VC = System.currentTimeMillis();
    this.eJ = ((Bitmap)this.l.get(this.yq.get(this.mCurrentIndex)));
    this.isStop = false;
    this.isEnd = false;
  }
  
  public Bitmap getBitmapByIndex(int paramInt)
  {
    if ((this.yq != null) && (paramInt >= 0) && (paramInt < this.yq.size()))
    {
      String str = (String)this.yq.get(paramInt);
      Bitmap localBitmap2 = (Bitmap)this.l.get(str);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        localBitmap1 = decodeBitmap(str);
        this.l.put(str, localBitmap1);
      }
      return localBitmap1;
    }
    return null;
  }
  
  public Bitmap getCurrentBitmap()
  {
    Object localObject = null;
    if (this.isStop)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameBmpCache", 2, "getCurrentBitmap, isStop");
      }
      if (this.bQR) {
        localObject = this.eJ;
      }
    }
    int i;
    int j;
    do
    {
      return localObject;
      i = (int)(System.currentTimeMillis() - this.VC);
      j = this.mCurrentIndex;
      this.mCurrentIndex = ((int)(i / this.interval));
      if (this.mCurrentIndex != j) {
        LA(j + 1);
      }
      if (this.mCurrentIndex < j) {
        this.mCurrentIndex = j;
      }
      if ((this.mCurrentIndex < this.yq.size()) || (this.bQS)) {
        break;
      }
      this.mCurrentIndex = (this.yq.size() - 1);
      this.isEnd = true;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$a.a(null);
      }
    } while (!this.bQR);
    return (Bitmap)this.l.get(this.yq.get(gR(this.mCurrentIndex)));
    Bitmap localBitmap = (Bitmap)this.l.get(this.yq.get(gR(this.mCurrentIndex)));
    localObject = localBitmap;
    if (localBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameBmpCache", 2, "getCurrentBitmap, cant find bitmap in cache, index=" + this.mCurrentIndex);
      }
      localBitmap = (Bitmap)this.l.get(this.yq.get(gR(this.mLastIndex)));
      localObject = localBitmap;
      if (localBitmap != null)
      {
        this.mCurrentIndex = this.mLastIndex;
        localObject = localBitmap;
      }
    }
    if ((this.mCurrentIndex != j) && (this.mCurrentIndex - j != 1)) {
      this.cKa += 1;
    }
    if (localObject != null) {
      this.eJ = ((Bitmap)localObject);
    }
    if (this.bQQ)
    {
      i = this.mCurrentIndex - 1;
      if ((i > 0) && (i < this.yq.size()))
      {
        localObject = (String)this.yq.get(i);
        this.l.remove(localObject);
      }
    }
    return this.eJ;
  }
  
  public boolean isInit()
  {
    return this.yq != null;
  }
  
  public void jD(List<String> paramList)
  {
    this.yq = paramList;
    this.cKb = 0;
    this.isStop = false;
    if (MemoryManager.eS() <= 37748736L) {
      this.bQT = false;
    }
    QLog.d("FrameBmpCache", 1, "mUseHighQuality=" + this.bQT);
  }
  
  public void setEndListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$a = parama;
  }
  
  public void setFps(int paramInt)
  {
    this.fps = paramInt;
    this.interval = (1000 / this.fps);
    this.cJZ = ((int)(this.fps / 2.0F));
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.bQS = paramBoolean;
  }
  
  public void startDecode()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameBmpCache", 2, "startDecode");
    }
    Object localObject1 = this.mLock;
    int i = 0;
    try
    {
      while (i < this.yq.size())
      {
        CancelAbleRunnable localCancelAbleRunnable = new CancelAbleRunnable(i);
        this.R.add(localCancelAbleRunnable);
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable == null) {
        cUv();
      }
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    if (isInit())
    {
      reset();
      Q();
    }
  }
  
  class CancelAbleRunnable
    implements Runnable
  {
    volatile boolean bQU = false;
    public int index;
    
    public CancelAbleRunnable(int paramInt)
    {
      this.index = paramInt;
    }
    
    public void cancel()
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameBmpCache", 2, "cancel");
      }
      this.bQU = true;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 24	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:bQU	Z
      //   4: ifne +118 -> 122
      //   7: aload_0
      //   8: getfield 19	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
      //   11: getfield 50	com/tencent/mobileqq/armap/FrameBmpCache:yq	Ljava/util/List;
      //   14: aload_0
      //   15: getfield 19	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
      //   18: aload_0
      //   19: getfield 26	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:index	I
      //   22: invokestatic 54	com/tencent/mobileqq/armap/FrameBmpCache:a	(Lcom/tencent/mobileqq/armap/FrameBmpCache;I)I
      //   25: invokeinterface 60 2 0
      //   30: checkcast 62	java/lang/String
      //   33: astore_1
      //   34: aload_0
      //   35: getfield 19	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
      //   38: getfield 66	com/tencent/mobileqq/armap/FrameBmpCache:l	Landroid/support/v4/util/MQLruCache;
      //   41: aload_1
      //   42: invokevirtual 71	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   45: ifnonnull +138 -> 183
      //   48: aload_0
      //   49: getfield 19	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
      //   52: aload_1
      //   53: invokestatic 74	com/tencent/mobileqq/armap/FrameBmpCache:a	(Lcom/tencent/mobileqq/armap/FrameBmpCache;Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   56: astore_2
      //   57: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   60: ifeq +49 -> 109
      //   63: ldc 36
      //   65: iconst_2
      //   66: new 76	java/lang/StringBuilder
      //   69: dup
      //   70: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   73: ldc 79
      //   75: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   78: aload_0
      //   79: getfield 26	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:index	I
      //   82: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   85: ldc 88
      //   87: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: aload_1
      //   91: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   94: ldc 90
      //   96: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: aload_2
      //   100: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   103: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   106: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   109: aload_0
      //   110: getfield 19	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
      //   113: getfield 66	com/tencent/mobileqq/armap/FrameBmpCache:l	Landroid/support/v4/util/MQLruCache;
      //   116: aload_1
      //   117: aload_2
      //   118: invokevirtual 101	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   121: pop
      //   122: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   125: ifeq +31 -> 156
      //   128: ldc 36
      //   130: iconst_2
      //   131: new 76	java/lang/StringBuilder
      //   134: dup
      //   135: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   138: ldc 103
      //   140: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: aload_0
      //   144: getfield 26	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:index	I
      //   147: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   150: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   153: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   156: aload_0
      //   157: getfield 24	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:bQU	Z
      //   160: ifne +22 -> 182
      //   163: aload_0
      //   164: getfield 19	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
      //   167: getfield 107	com/tencent/mobileqq/armap/FrameBmpCache:mLock	Ljava/lang/Object;
      //   170: astore_1
      //   171: aload_1
      //   172: monitorenter
      //   173: aload_0
      //   174: getfield 19	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
      //   177: invokestatic 110	com/tencent/mobileqq/armap/FrameBmpCache:a	(Lcom/tencent/mobileqq/armap/FrameBmpCache;)V
      //   180: aload_1
      //   181: monitorexit
      //   182: return
      //   183: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   186: ifeq -64 -> 122
      //   189: ldc 36
      //   191: iconst_2
      //   192: new 76	java/lang/StringBuilder
      //   195: dup
      //   196: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   199: ldc 79
      //   201: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   204: aload_0
      //   205: getfield 26	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:index	I
      //   208: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   211: ldc 112
      //   213: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   216: aload_1
      //   217: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   220: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   223: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   226: goto -104 -> 122
      //   229: astore_1
      //   230: aload_0
      //   231: getfield 19	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
      //   234: iconst_1
      //   235: invokestatic 115	com/tencent/mobileqq/armap/FrameBmpCache:b	(Lcom/tencent/mobileqq/armap/FrameBmpCache;I)I
      //   238: pop
      //   239: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   242: ifeq -120 -> 122
      //   245: ldc 36
      //   247: iconst_2
      //   248: new 76	java/lang/StringBuilder
      //   251: dup
      //   252: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   255: ldc 117
      //   257: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   260: aload_0
      //   261: getfield 26	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:index	I
      //   264: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   267: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   270: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   273: goto -151 -> 122
      //   276: astore_1
      //   277: aload_0
      //   278: getfield 19	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
      //   281: iconst_2
      //   282: invokestatic 115	com/tencent/mobileqq/armap/FrameBmpCache:b	(Lcom/tencent/mobileqq/armap/FrameBmpCache;I)I
      //   285: pop
      //   286: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   289: ifeq -167 -> 122
      //   292: ldc 36
      //   294: iconst_2
      //   295: ldc 122
      //   297: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   300: goto -178 -> 122
      //   303: astore_2
      //   304: aload_1
      //   305: monitorexit
      //   306: aload_2
      //   307: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	308	0	this	CancelAbleRunnable
      //   229	1	1	localOutOfMemoryError	OutOfMemoryError
      //   276	29	1	localThrowable	java.lang.Throwable
      //   56	62	2	localBitmap	Bitmap
      //   303	4	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   7	109	229	java/lang/OutOfMemoryError
      //   109	122	229	java/lang/OutOfMemoryError
      //   183	226	229	java/lang/OutOfMemoryError
      //   7	109	276	java/lang/Throwable
      //   109	122	276	java/lang/Throwable
      //   183	226	276	java/lang/Throwable
      //   173	182	303	finally
      //   304	306	303	finally
    }
    
    public String toString()
    {
      return Integer.toString(this.index);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(SdCardImageAnimView paramSdCardImageAnimView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.FrameBmpCache
 * JD-Core Version:    0.7.0.1
 */