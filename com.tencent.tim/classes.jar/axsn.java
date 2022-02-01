import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class axsn
  extends axpn
  implements URLDrawable.URLDrawableListener
{
  private final float Eu;
  private final float Ev;
  aynd a;
  private final String cVY;
  String cVZ;
  int mProgress = 0;
  int mState = 2;
  URLDrawable mURLDrawable;
  private final float mWidthScale;
  
  public axsn(aynd paramaynd, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.cVY = paramString1;
    this.cVZ = paramString2;
    this.a = paramaynd;
    this.Eu = paramFloat1;
    this.Ev = paramFloat2;
    this.mWidthScale = paramFloat3;
    if (QLog.isColorLevel()) {
      QLog.d("QCombo.LPaster", 2, "create id=" + paramString1 + " name=" + paramString2);
    }
  }
  
  private URLDrawable i()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    aynd.a locala = this.a.a(this.cVZ);
    if (locala != null) {
      return URLDrawable.getDrawable(locala.imageUrl, localURLDrawableOptions);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo.LPaster", 2, "createUrlDrawable no item =" + this.cVZ);
    }
    return null;
  }
  
  public void A(Activity paramActivity, int paramInt)
  {
    paramActivity = this.a.a(this.cVZ);
    if (paramActivity != null)
    {
      DoodleLayout localDoodleLayout = axvy.a().a(paramInt);
      if (localDoodleLayout != null) {
        localDoodleLayout.a().jR(this.a.name, paramActivity.desc);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "apply id=" + this.cVY + " name=" + this.cVZ + " state=" + this.mState);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "unApply no item =" + this.cVZ);
      }
    }
  }
  
  /* Error */
  public int Rq()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 153	axsn:mURLDrawable	Lcom/tencent/image/URLDrawable;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 155	axsn:i	()Lcom/tencent/image/URLDrawable;
    //   14: putfield 153	axsn:mURLDrawable	Lcom/tencent/image/URLDrawable;
    //   17: aload_0
    //   18: getfield 153	axsn:mURLDrawable	Lcom/tencent/image/URLDrawable;
    //   21: ifnull +86 -> 107
    //   24: aload_0
    //   25: getfield 153	axsn:mURLDrawable	Lcom/tencent/image/URLDrawable;
    //   28: invokevirtual 158	com/tencent/image/URLDrawable:getStatus	()I
    //   31: iconst_1
    //   32: if_icmpne +84 -> 116
    //   35: aload_0
    //   36: iconst_3
    //   37: putfield 29	axsn:mState	I
    //   40: aload_0
    //   41: bipush 100
    //   43: putfield 27	axsn:mProgress	I
    //   46: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +58 -> 107
    //   52: ldc 49
    //   54: iconst_2
    //   55: new 51	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   62: ldc 160
    //   64: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 31	axsn:cVY	Ljava/lang/String;
    //   71: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 62
    //   76: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 33	axsn:cVZ	Ljava/lang/String;
    //   83: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 162
    //   88: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 153	axsn:mURLDrawable	Lcom/tencent/image/URLDrawable;
    //   95: invokevirtual 158	com/tencent/image/URLDrawable:getStatus	()I
    //   98: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_0
    //   108: getfield 29	axsn:mState	I
    //   111: istore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: iload_1
    //   115: ireturn
    //   116: aload_0
    //   117: getfield 153	axsn:mURLDrawable	Lcom/tencent/image/URLDrawable;
    //   120: invokevirtual 165	com/tencent/image/URLDrawable:startDownload	()V
    //   123: aload_0
    //   124: getfield 153	axsn:mURLDrawable	Lcom/tencent/image/URLDrawable;
    //   127: aload_0
    //   128: invokevirtual 169	com/tencent/image/URLDrawable:setURLDrawableListener	(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 29	axsn:mState	I
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield 27	axsn:mProgress	I
    //   141: aload_0
    //   142: invokevirtual 172	axsn:eNI	()V
    //   145: goto -99 -> 46
    //   148: astore_2
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	axsn
    //   111	4	1	i	int
    //   148	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	148	finally
    //   17	46	148	finally
    //   46	107	148	finally
    //   107	112	148	finally
    //   116	145	148	finally
  }
  
  public void a(aynd paramaynd, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, axqg paramaxqg)
  {
    if (paramaxqg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "try apply but no listener");
      }
    }
    do
    {
      return;
      paramaynd = this.mURLDrawable;
      if (paramaynd == null) {
        break;
      }
      paramaynd.setBounds(0, 0, paramaynd.getIntrinsicWidth(), paramaynd.getIntrinsicHeight());
      paramString = this.a.a(this.cVZ);
      if (paramString != null)
      {
        paramString.dj = paramaynd;
        paramaxqg.a(paramString, paramInt1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, this.mSegmentKeeper);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QCombo.LPaster", 2, "applyLocationPaster no item =" + this.cVZ);
    return;
    ram.e("QCombo.LPaster", "can create drawable from urldrawable:" + this.mURLDrawable);
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    paramActivity = axvy.a().a(paramInt);
    if (paramActivity != null)
    {
      a(this.a, this.cVZ, azbx.SCREEN_WIDTH, azbx.cIE, this.Eu, this.Ev, this.mWidthScale, paramActivity.a());
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "apply id=" + this.cVY + " name=" + this.cVZ + " state=" + this.mState);
      }
    }
    return 0;
  }
  
  public float getProgress()
  {
    return 1.0F;
  }
  
  public int getState()
  {
    for (;;)
    {
      try
      {
        if (this.mURLDrawable == null) {
          this.mURLDrawable = i();
        }
        if (this.mURLDrawable == null) {
          break label129;
        }
        if (this.mState != 3)
        {
          aynd.a locala = this.a.a(this.cVZ);
          if (locala == null) {
            break label92;
          }
          if (aoiz.getFile(locala.imageUrl) == null) {
            this.mState = 2;
          }
        }
        else
        {
          int i = this.mState;
          return i;
        }
        this.mState = 3;
        this.mURLDrawable.startDownload();
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      label92:
      QLog.d("QCombo.LPaster", 2, "getState no item =" + this.cVZ);
      continue;
      label129:
      this.mState = 2;
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.mProgress = 0;
    this.mState = 2;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.mProgress = 0;
    this.mState = 2;
    aeD(4);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    this.mProgress = paramInt;
    this.mState = 1;
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.mProgress = 100;
    this.mState = 3;
    eNJ();
  }
  
  public String toString()
  {
    return "LP@" + this.cVY + "@" + this.cVZ + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsn
 * JD-Core Version:    0.7.0.1
 */