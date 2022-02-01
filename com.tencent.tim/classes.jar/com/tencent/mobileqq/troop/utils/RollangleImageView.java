package com.tencent.mobileqq.troop.utils;

import ahav;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import aprh;
import apsv;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class RollangleImageView
  extends ImageView
{
  public static MQLruCache<String, Object> mMemoryCache = BaseApplicationImpl.sImageCache;
  b a = null;
  boolean cSc = false;
  public String cqH;
  public String extension;
  
  public RollangleImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RollangleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RollangleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static Bitmap M(String paramString)
  {
    Bitmap localBitmap = (Bitmap)mMemoryCache.get("troopfilerollangleimage://");
    Object localObject4 = (Bitmap)mMemoryCache.get("troopfilerollangleimageborder://");
    Object localObject3;
    Object localObject2;
    Object localObject5;
    if (localBitmap != null)
    {
      localObject3 = localBitmap;
      localObject2 = localObject4;
      if (localObject4 != null) {}
    }
    else
    {
      localObject5 = BaseApplication.getContext().getResources();
      localObject1 = localBitmap;
      if (localBitmap != null) {}
    }
    try
    {
      localObject1 = BitmapFactory.decodeResource((Resources)localObject5, 2130843347);
      mMemoryCache.put("troopfilerollangleimage://", localObject1);
      localObject3 = localObject1;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        localObject2 = BitmapFactory.decodeResource((Resources)localObject5, 2130843346);
        mMemoryCache.put("troopfilerollangleimageborder://", localObject2);
        localObject3 = localObject1;
      }
      localObject1 = aqhu.a(new BitmapFactory.Options(), paramString, 128);
      i = paramString.getWidth();
    }
    catch (OutOfMemoryError paramString)
    {
      try
      {
        paramString = aqhu.d(paramString, (BitmapFactory.Options)localObject1);
        if (paramString != null) {
          break label181;
        }
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        if (!QLog.isColorLevel()) {
          break label179;
        }
        QLog.e("RollangleImageView", 4, "decode srcBmp OutOfMemoryError error");
        return null;
      }
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.e("RollangleImageView", 4, "decode maskBmp borderBmp OutOfMemoryError error");
      }
      return null;
    }
    label179:
    label181:
    int i;
    int j = paramString.getHeight();
    int k = Math.max(i, j);
    if (k <= 0) {
      return null;
    }
    Object localObject1 = new Rect(0, 0, k, k);
    try
    {
      localBitmap = Bitmap.createBitmap(k, k, Bitmap.Config.ARGB_8888);
      localObject4 = new Canvas(localBitmap);
      localObject5 = new Paint();
      ((Paint)localObject5).setAntiAlias(true);
      ((Canvas)localObject4).drawBitmap((Bitmap)localObject3, new Rect(0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight()), (Rect)localObject1, (Paint)localObject5);
      localObject3 = new Rect();
      ((Rect)localObject3).left = ((k - i) / 2);
      ((Rect)localObject3).top = ((k - j) / 2);
      ((Rect)localObject3).right = (((Rect)localObject3).left + i);
      ((Rect)localObject3).bottom = (((Rect)localObject3).top + j);
      Rect localRect = new Rect(0, 0, i, j);
      ((Paint)localObject5).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject4).drawBitmap(paramString, localRect, (Rect)localObject3, (Paint)localObject5);
      localObject3 = new Rect(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      ((Paint)localObject5).setXfermode(null);
      ((Canvas)localObject4).drawBitmap((Bitmap)localObject2, (Rect)localObject3, (Rect)localObject1, (Paint)localObject5);
      paramString.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RollangleImageView", 2, "generateRollAngleThumb, rollAngleBmp, OutOfMemoryError");
      }
    }
    return null;
  }
  
  private Bitmap c(boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (!TextUtils.isEmpty(this.cqH))
    {
      if (paramBoolean) {
        localBitmap = a.a().b(this.cqH, this);
      }
    }
    else {
      return localBitmap;
    }
    return a.a().a(this.cqH, this);
  }
  
  public static void setSuspendLoad(boolean paramBoolean)
  {
    a.a().Sd(paramBoolean);
  }
  
  public void Sc(boolean paramBoolean)
  {
    if (this.a != null)
    {
      this.a.cancel(true);
      this.a = null;
    }
    this.a = new b(this);
    this.a.execute(new Boolean[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setParams(String paramString1, String paramString2)
  {
    if ((apsv.isEquals(paramString1, this.extension)) && (apsv.isEquals(paramString2, this.cqH))) {
      return;
    }
    if (a.a().cSd)
    {
      setParamsOnScrolling(paramString1, paramString2);
      return;
    }
    this.extension = paramString1;
    this.cqH = paramString2;
    Sc(true);
  }
  
  public void setParamsOnScrolling(String paramString1, String paramString2)
  {
    Bitmap localBitmap = a.a().a(paramString2, this);
    if (localBitmap == null)
    {
      setImageResource(ahav.r(paramString1));
      return;
    }
    this.extension = paramString1;
    this.cqH = paramString2;
    setImageBitmap(localBitmap);
  }
  
  public static class a
  {
    private static a a;
    public boolean cSd;
    private Handler mHandler = new aprh(this, BaseApplication.getContext().getMainLooper());
    private LinkedList<a> queue;
    
    public static a a()
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    
    public void Sd(boolean paramBoolean)
    {
      if (paramBoolean) {}
      try
      {
        if (this.queue != null) {
          this.queue.clear();
        }
        this.cSd = paramBoolean;
        return;
      }
      finally {}
    }
    
    public Bitmap a(String paramString, RollangleImageView paramRollangleImageView)
    {
      try
      {
        paramString = (Bitmap)RollangleImageView.mMemoryCache.get("troopfileimage://" + paramString);
        return paramString;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    /* Error */
    public Bitmap b(String paramString, RollangleImageView paramRollangleImageView)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: getstatic 61	com/tencent/mobileqq/troop/utils/RollangleImageView:mMemoryCache	Landroid/support/v4/util/MQLruCache;
      //   5: new 63	java/lang/StringBuilder
      //   8: dup
      //   9: invokespecial 64	java/lang/StringBuilder:<init>	()V
      //   12: ldc 66
      //   14: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   17: aload_1
      //   18: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   24: invokevirtual 80	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   27: checkcast 82	android/graphics/Bitmap
      //   30: astore_3
      //   31: aload_3
      //   32: ifnull +9 -> 41
      //   35: aload_3
      //   36: astore_1
      //   37: aload_0
      //   38: monitorexit
      //   39: aload_1
      //   40: areturn
      //   41: aload_0
      //   42: getfield 47	com/tencent/mobileqq/troop/utils/RollangleImageView$a:queue	Ljava/util/LinkedList;
      //   45: ifnonnull +14 -> 59
      //   48: aload_0
      //   49: new 51	java/util/LinkedList
      //   52: dup
      //   53: invokespecial 84	java/util/LinkedList:<init>	()V
      //   56: putfield 47	com/tencent/mobileqq/troop/utils/RollangleImageView$a:queue	Ljava/util/LinkedList;
      //   59: aload_0
      //   60: getfield 47	com/tencent/mobileqq/troop/utils/RollangleImageView$a:queue	Ljava/util/LinkedList;
      //   63: invokevirtual 88	java/util/LinkedList:isEmpty	()Z
      //   66: ifeq +17 -> 83
      //   69: new 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$1
      //   72: dup
      //   73: aload_0
      //   74: invokespecial 93	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$1:<init>	(Lcom/tencent/mobileqq/troop/utils/RollangleImageView$a;)V
      //   77: iconst_5
      //   78: aconst_null
      //   79: iconst_1
      //   80: invokestatic 99	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
      //   83: new 9	com/tencent/mobileqq/troop/utils/RollangleImageView$a$a
      //   86: dup
      //   87: invokespecial 100	com/tencent/mobileqq/troop/utils/RollangleImageView$a$a:<init>	()V
      //   90: astore_3
      //   91: aload_3
      //   92: aload_2
      //   93: putfield 103	com/tencent/mobileqq/troop/utils/RollangleImageView$a$a:a	Lcom/tencent/mobileqq/troop/utils/RollangleImageView;
      //   96: aload_3
      //   97: aload_1
      //   98: putfield 107	com/tencent/mobileqq/troop/utils/RollangleImageView$a$a:path	Ljava/lang/String;
      //   101: aload_0
      //   102: getfield 47	com/tencent/mobileqq/troop/utils/RollangleImageView$a:queue	Ljava/util/LinkedList;
      //   105: aload_3
      //   106: invokevirtual 111	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   109: pop
      //   110: aconst_null
      //   111: astore_1
      //   112: goto -75 -> 37
      //   115: astore_1
      //   116: aload_0
      //   117: monitorexit
      //   118: aload_1
      //   119: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	120	0	this	a
      //   0	120	1	paramString	String
      //   0	120	2	paramRollangleImageView	RollangleImageView
      //   30	76	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	31	115	finally
      //   41	59	115	finally
      //   59	83	115	finally
      //   83	110	115	finally
    }
    
    /* Error */
    public void clearCache()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 47	com/tencent/mobileqq/troop/utils/RollangleImageView$a:queue	Ljava/util/LinkedList;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 47	com/tencent/mobileqq/troop/utils/RollangleImageView$a:queue	Ljava/util/LinkedList;
      //   18: invokevirtual 54	java/util/LinkedList:clear	()V
      //   21: aload_0
      //   22: aconst_null
      //   23: putfield 47	com/tencent/mobileqq/troop/utils/RollangleImageView$a:queue	Ljava/util/LinkedList;
      //   26: goto -15 -> 11
      //   29: astore_1
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_1
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	a
      //   6	2	1	localLinkedList	LinkedList
      //   29	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
    
    public static class a
    {
      public RollangleImageView a;
      public String path;
    }
  }
  
  static class b
    extends AsyncTask<Boolean, Void, Bitmap>
  {
    private WeakReference<RollangleImageView> ih;
    
    public b(RollangleImageView paramRollangleImageView)
    {
      this.ih = new WeakReference(paramRollangleImageView);
    }
    
    protected Bitmap a(Boolean... paramVarArgs)
    {
      RollangleImageView localRollangleImageView = (RollangleImageView)this.ih.get();
      if (localRollangleImageView != null) {
        return RollangleImageView.a(localRollangleImageView, paramVarArgs[0].booleanValue());
      }
      return null;
    }
    
    protected void o(Bitmap paramBitmap)
    {
      RollangleImageView localRollangleImageView = (RollangleImageView)this.ih.get();
      if (localRollangleImageView != null)
      {
        if (paramBitmap != null) {
          localRollangleImageView.setImageBitmap(paramBitmap);
        }
      }
      else {
        return;
      }
      localRollangleImageView.setImageResource(ahav.r(localRollangleImageView.extension));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView
 * JD-Core Version:    0.7.0.1
 */