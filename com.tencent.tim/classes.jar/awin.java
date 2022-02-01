import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.component.media.image.IDecoder;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.SafeBitmapFactory;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import cooperation.qzone.zipanimate.ZipDrawableLoader.3;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class awin
{
  public static final byte[] inTempStorage = new byte[24576];
  private awip a;
  private CopyOnWriteArrayList<awin.b> ax = new CopyOnWriteArrayList();
  private awiq b;
  private int bIg = -1;
  private String bxJ;
  private QzoneZipCacheHelperCallBack c = new awio(this);
  private boolean dqp = true;
  public boolean dqq = false;
  private boolean dqr;
  private int dwj = -1;
  private awir e;
  private int eAD = -1;
  private int eAE = -1;
  private Rect mBounds;
  private WeakReference<Context> mContext;
  private long mCurrentTime;
  private String mDir;
  private Set<WeakReference<Bitmap>> mReusableBitmaps;
  private float mScale = 1.0F;
  private String mZipUrl;
  private Drawable t;
  
  public awin(Context paramContext)
  {
    this.mContext = new WeakReference(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      this.mReusableBitmaps = Collections.synchronizedSet(new HashSet());
    }
  }
  
  private void Xe(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(QzoneZipCacheHelper.getFolderFileNameList(this.bxJ, this.mDir), QzoneZipCacheHelper.getBasePath(this.bxJ, this.mDir));
    }
    while (this.e == null) {
      return;
    }
    this.e.onZipLoaded(paramBoolean);
  }
  
  private void Xf(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.t = null;
    }
  }
  
  private void YW()
  {
    Iterator localIterator = this.ax.iterator();
    while (localIterator.hasNext())
    {
      awin.b localb = (awin.b)localIterator.next();
      if (localb.k != null) {
        localb.k = null;
      }
    }
  }
  
  private void acu(int paramInt)
  {
    int k = paramInt + this.dwj;
    int m = this.ax.size();
    if ((paramInt < 0) || (paramInt >= k) || (paramInt >= m)) {}
    for (;;)
    {
      return;
      int i;
      awin.b localb;
      if (k >= m)
      {
        i = k % m;
        while (i < paramInt)
        {
          localb = (awin.b)this.ax.get(i);
          if (localb.k != this.t)
          {
            if (this.dqp) {
              b(localb.k);
            }
            localb.k = null;
          }
          i += 1;
        }
      }
      else
      {
        i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= paramInt) {
            break;
          }
          localb = (awin.b)this.ax.get(i);
          if (localb.k != this.t)
          {
            if (this.dqp) {
              b(localb.k);
            }
            localb.k = null;
          }
          i += 1;
        }
        while (j < m)
        {
          localb = (awin.b)this.ax.get(j);
          if (localb.k != this.t)
          {
            if (this.dqp) {
              b(localb.k);
            }
            localb.k = null;
          }
          j += 1;
        }
      }
    }
  }
  
  @TargetApi(11)
  private void addInBitmapOptions(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = aR();
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  @TargetApi(12)
  private BitmapDrawable b(String paramString)
  {
    int i = 1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((QZLog.isColorLevel()) && (System.currentTimeMillis() - this.mCurrentTime > 1000L))
    {
      this.mCurrentTime = System.currentTimeMillis();
      QZLog.i("zip_drawable", 2, "decodeBitmap mZipUrl = " + this.mZipUrl);
    }
    label297:
    label299:
    for (;;)
    {
      try
      {
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QzoneMainRuntime))
        {
          localObject = ImageManager.getInstance().getDecoder();
          if (localObject == null) {
            break label297;
          }
          paramString = new File(paramString);
          if ((!paramString.exists()) || (paramString.isDirectory())) {
            break label297;
          }
          Bitmap localBitmap = aR();
          paramString = ((IDecoder)localObject).decodeBitmap(paramString, this.eAD, this.eAE, localBitmap);
          break label299;
          if (paramString == null) {
            break;
          }
          paramString.setDensity(160);
          return new BitmapDrawable(paramString);
        }
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        ((BitmapFactory.Options)localObject).inTempStorage = inTempStorage;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if ((this.eAE < 0) && (this.eAD < 0))
        {
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inSampleSize = i;
          ((BitmapFactory.Options)localObject).inTempStorage = inTempStorage;
          if (Build.VERSION.SDK_INT >= 11) {
            addInBitmapOptions((BitmapFactory.Options)localObject);
          }
          paramString = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        }
        else
        {
          i = calculateInSampleSize((BitmapFactory.Options)localObject, this.eAD, this.eAE);
          continue;
          paramString = null;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QZLog.e("ziploader", "OutOfMemoryError  ");
        return null;
      }
      catch (Exception paramString)
      {
        QZLog.e("ziploader", "decode bitmap exception " + paramString);
        return null;
      }
    }
  }
  
  private void b(int paramInt, awiq paramawiq)
  {
    if (paramInt > this.ax.size()) {}
    do
    {
      do
      {
        return;
        if (((awin.b)this.ax.get(paramInt)).k == null)
        {
          QzoneHandlerThreadFactory.getHandlerThread("YellowVip_HandlerThread").post(new ZipDrawableLoader.3(this, paramInt, paramawiq));
          return;
        }
        if (paramawiq != null) {
          paramawiq.b(paramInt, ((awin.b)this.ax.get(paramInt)).k);
        }
      } while (this.dqq);
      this.dqq = true;
    } while (this.a == null);
    this.a.al(((awin.b)this.ax.get(paramInt)).k);
  }
  
  private void b(BitmapDrawable paramBitmapDrawable)
  {
    if (paramBitmapDrawable != null)
    {
      if ((Build.VERSION.SDK_INT < 11) || (this.mReusableBitmaps.size() >= this.dwj)) {
        break label50;
      }
      this.mReusableBitmaps.add(new WeakReference(paramBitmapDrawable.getBitmap()));
    }
    label50:
    do
    {
      return;
      paramBitmapDrawable = paramBitmapDrawable.getBitmap();
      if ((paramBitmapDrawable != null) && (!paramBitmapDrawable.isRecycled())) {
        paramBitmapDrawable.recycle();
      }
    } while (!QZLog.isColorLevel());
    QZLog.d("ziploader", 1, " out of max preload num:");
  }
  
  private void b(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    for (;;)
    {
      int i;
      try
      {
        this.ax.clear();
        i = 0;
        if (i < paramArrayOfString.length)
        {
          awin.b localb = new awin.b();
          localb.path = (paramString + File.separator + paramArrayOfString[i]);
          if ((!localb.path.endsWith(".jpg")) && (!localb.path.endsWith(".png"))) {
            break label158;
          }
          this.ax.add(localb);
          break label158;
        }
        bool = true;
        if (this.dqr) {
          a(0, this.b);
        }
        if (this.e != null) {
          this.e.onZipLoaded(bool);
        }
        return;
      }
      finally {}
      boolean bool = false;
      continue;
      label158:
      i += 1;
    }
  }
  
  private int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  private boolean selectDrawable(int paramInt)
  {
    try
    {
      awin.b localb = (awin.b)this.ax.get(paramInt);
      if (localb.k != null) {
        this.t = localb.k;
      }
      acu(this.bIg);
      ak(this.ax, this.bIg + 1);
      return false;
    }
    finally {}
  }
  
  public void E(String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      a(paramString, "zip_drawable", getZipDrawableDirSuffix(paramString), paramInt, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void Xd(boolean paramBoolean)
  {
    this.dqp = paramBoolean;
  }
  
  /* Error */
  public void a(int paramInt, awiq paramawiq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	awin:ax	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 182	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   9: istore_3
    //   10: iload_3
    //   11: iload_1
    //   12: if_icmpgt +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: iload_1
    //   20: aload_2
    //   21: invokespecial 442	awin:b	(ILawiq;)V
    //   24: aload_0
    //   25: iload_1
    //   26: invokevirtual 445	awin:setFrame	(I)V
    //   29: goto -14 -> 15
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	awin
    //   0	37	1	paramInt	int
    //   0	37	2	paramawiq	awiq
    //   9	4	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	32	finally
    //   18	29	32	finally
  }
  
  public void a(awiq paramawiq)
  {
    this.b = paramawiq;
  }
  
  public void a(awir paramawir)
  {
    this.e = paramawir;
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	awin:ax	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 392	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   9: aload_1
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 61	awin:dwj	I
    //   20: ifgt +8 -> 28
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 61	awin:dwj	I
    //   28: aload_0
    //   29: aload_1
    //   30: putfield 172	awin:mZipUrl	Ljava/lang/String;
    //   33: aload_0
    //   34: aload_3
    //   35: putfield 114	awin:mDir	Ljava/lang/String;
    //   38: aload_0
    //   39: aload_2
    //   40: putfield 112	awin:bxJ	Ljava/lang/String;
    //   43: aload_0
    //   44: iload 5
    //   46: putfield 412	awin:dqr	Z
    //   49: ldc_w 449
    //   52: invokestatic 346	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;)Lcooperation/qzone/thread/QzoneBaseThread;
    //   55: new 451	cooperation/qzone/zipanimate/ZipDrawableLoader$1
    //   58: dup
    //   59: aload_0
    //   60: iload 4
    //   62: invokespecial 454	cooperation/qzone/zipanimate/ZipDrawableLoader$1:<init>	(Lawin;I)V
    //   65: invokevirtual 357	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   68: goto -55 -> 13
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	awin
    //   0	76	1	paramString1	String
    //   0	76	2	paramString2	String
    //   0	76	3	paramString3	String
    //   0	76	4	paramInt	int
    //   0	76	5	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	71	finally
    //   16	28	71	finally
    //   28	68	71	finally
  }
  
  protected Bitmap aR()
  {
    Bitmap localBitmap3 = null;
    Bitmap localBitmap1 = localBitmap3;
    if (this.mReusableBitmaps != null)
    {
      localBitmap1 = localBitmap3;
      if (!this.mReusableBitmaps.isEmpty()) {
        synchronized (this.mReusableBitmaps)
        {
          Iterator localIterator = this.mReusableBitmaps.iterator();
          localBitmap1 = null;
          while (localIterator.hasNext())
          {
            localBitmap3 = (Bitmap)((WeakReference)localIterator.next()).get();
            if ((localBitmap3 != null) && (localBitmap3.isMutable()))
            {
              localIterator.remove();
              localBitmap1 = localBitmap3;
            }
            else
            {
              localIterator.remove();
            }
          }
        }
      }
    }
    return localBitmap2;
  }
  
  public void acs(int paramInt)
  {
    if (paramInt > 0) {
      this.dwj = paramInt;
    }
  }
  
  public void act(int paramInt)
  {
    if ((this.ax == null) || (paramInt >= this.ax.size())) {}
    awin.b localb;
    do
    {
      return;
      this.bIg = paramInt;
      localb = (awin.b)this.ax.get(paramInt);
    } while (localb.k == null);
    this.t = localb.k;
  }
  
  /* Error */
  void ak(java.util.List<awin.b> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	awin:ax	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 468	java/util/concurrent/CopyOnWriteArrayList:isEmpty	()Z
    //   9: istore 4
    //   11: iload 4
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: iconst_0
    //   20: istore_3
    //   21: iload_3
    //   22: aload_0
    //   23: getfield 61	awin:dwj	I
    //   26: if_icmpge -10 -> 16
    //   29: aload_0
    //   30: iload_2
    //   31: iload_3
    //   32: iadd
    //   33: aload_1
    //   34: invokeinterface 471 1 0
    //   39: irem
    //   40: aload_0
    //   41: getfield 414	awin:b	Lawiq;
    //   44: invokespecial 442	awin:b	(ILawiq;)V
    //   47: iload_3
    //   48: iconst_1
    //   49: iadd
    //   50: istore_3
    //   51: goto -30 -> 21
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	awin
    //   0	59	1	paramList	java.util.List<awin.b>
    //   0	59	2	paramInt	int
    //   20	31	3	i	int
    //   9	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	54	finally
    //   21	47	54	finally
  }
  
  public Drawable bi()
  {
    return this.t;
  }
  
  /* Error */
  public void dO(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	awin:ax	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 392	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   9: aload_1
    //   10: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 61	awin:dwj	I
    //   25: ifgt +8 -> 33
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 61	awin:dwj	I
    //   33: aload_0
    //   34: iload_2
    //   35: putfield 412	awin:dqr	Z
    //   38: aload_0
    //   39: aload_1
    //   40: invokestatic 481	cooperation/qzone/webviewplugin/QzoneZipCacheHelper:getFileList	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: aload_1
    //   44: invokespecial 127	awin:b	([Ljava/lang/String;Ljava/lang/String;)V
    //   47: goto -29 -> 18
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	awin
    //   0	55	1	paramString	String
    //   0	55	2	paramBoolean	boolean
    //   13	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	50	finally
    //   21	33	50	finally
    //   33	47	50	finally
  }
  
  public int getFrameCount()
  {
    return this.ax.size();
  }
  
  public String getZipDrawableDirSuffix(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return String.valueOf(paramString.hashCode());
  }
  
  public CopyOnWriteArrayList<awin.b> h()
  {
    return this.ax;
  }
  
  public boolean nextFrame()
  {
    boolean bool = false;
    try
    {
      int j = this.bIg + 1;
      int k = this.ax.size();
      int i = j;
      if (j >= k) {
        i = 0;
      }
      setFrame(i);
      if (i == k - 1) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    this.mBounds = paramRect;
    if (this.t != null) {
      this.t.setBounds(this.mBounds);
    }
  }
  
  public void release()
  {
    Xf(false);
    YW();
    this.mReusableBitmaps.clear();
  }
  
  /* Error */
  public void setFrame(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	awin:ax	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 182	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   9: istore_2
    //   10: iload_1
    //   11: iload_2
    //   12: if_icmplt +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: iload_1
    //   20: putfield 72	awin:bIg	I
    //   23: aload_0
    //   24: iload_1
    //   25: invokespecial 510	awin:selectDrawable	(I)Z
    //   28: pop
    //   29: goto -14 -> 15
    //   32: astore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_3
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	awin
    //   0	37	1	paramInt	int
    //   9	4	2	i	int
    //   32	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	32	finally
    //   18	29	32	finally
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.eAD = paramInt1;
    this.eAE = paramInt2;
  }
  
  public static class a
  {
    public QzoneZipCacheHelperCallBack mCallBack;
    
    public void onLoadedFailed() {}
    
    public void onLoadedSuccess(AnimationDrawable paramAnimationDrawable) {}
  }
  
  public static class b
  {
    public BitmapDrawable k;
    public String path;
  }
  
  public static abstract interface c
  {
    public abstract void onLoaded(Drawable paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awin
 * JD-Core Version:    0.7.0.1
 */