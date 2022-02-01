import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.1;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.b;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class wrq
{
  static volatile wrq a;
  private final String TAG = "DoodleResHelper";
  private Map<Integer, wrq.a> hx;
  private int mID;
  
  private String T(String paramString, int paramInt)
  {
    return "Aio_Doodle/Type_" + paramInt + "_" + paramString;
  }
  
  public static wrq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new wrq();
      }
      return a;
    }
    finally {}
  }
  
  public List<Integer> D(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramInt == 1) || (paramInt == 2))
    {
      localObject = ScribbleResMgr.a().j((QQAppInterface)localObject);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        localArrayList.addAll((Collection)localObject);
      }
    }
    do
    {
      do
      {
        return localArrayList;
      } while (paramInt != 0);
      localObject = ScribbleResMgr.a().i((QQAppInterface)localObject);
    } while ((localObject == null) || (((ArrayList)localObject).size() <= 0));
    localArrayList.addAll((Collection)localObject);
    return localArrayList;
  }
  
  public void E(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    try
    {
      if (this.hx == null) {
        return;
      }
    }
    finally {}
    Object localObject = this.hx.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      wrq.a locala = (wrq.a)((Iterator)localObject).next();
      if ((locala.dR != null) && (locala.dR.get() == paramBitmap))
      {
        locala.bfL = true;
        QLog.d("DoodleResHelper", 2, "releaseBitmap succ:" + this.hx.size());
        return;
      }
    }
    localObject = new wrq.a();
    ((wrq.a)localObject).mHeight = paramBitmap.getHeight();
    ((wrq.a)localObject).mWidth = paramBitmap.getWidth();
    ((wrq.a)localObject).dR = new WeakReference(paramBitmap);
    ((wrq.a)localObject).bfL = true;
    paramBitmap = this.hx;
    int i = this.mID;
    this.mID = (i + 1);
    paramBitmap.put(Integer.valueOf(i), localObject);
    QLog.d("DoodleResHelper", 2, "releaseBitmap add new one:" + this.hx.size());
  }
  
  public Drawable a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = u(paramInt1, paramInt2);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = null;
      return localObject1;
    }
    if (paramInt2 > 0)
    {
      localObject1 = new File((String)localObject1);
      Object localObject2 = BaseApplicationImpl.sImageCache;
      Object localObject3 = ((File)localObject1).toURI().toString();
      if (paramBoolean) {}
      for (paramInt2 = 2;; paramInt2 = 3)
      {
        localObject2 = ((MQLruCache)localObject2).get(T((String)localObject3, paramInt2));
        if (localObject2 == null) {
          break;
        }
        return (Drawable)localObject2;
      }
      localObject2 = BaseApplicationImpl.getContext();
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Context)localObject2).getResources().getDrawable(2130838074);
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Context)localObject2).getResources().getDrawable(2130838074);
      ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = null;
      ((URLDrawable.URLDrawableOptions)localObject3).mUseMemoryCache = false;
      if (paramInt1 == 1)
      {
        ((URLDrawable.URLDrawableOptions)localObject3).mUseUnFinishCache = false;
        label151:
        if ((paramInt1 != 0) && (paramInt1 != 3)) {
          break label226;
        }
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
      }
      for (;;)
      {
        localObject2 = URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        if (paramInt1 != 2)
        {
          localObject1 = localObject2;
          if (paramInt1 != 1) {
            break;
          }
        }
        ((URLDrawable)localObject2).setIgnorePause(true);
        return localObject2;
        ((URLDrawable.URLDrawableOptions)localObject3).mUseUnFinishCache = true;
        if (paramBoolean)
        {
          ((URLDrawable.URLDrawableOptions)localObject3).isFlashPic = true;
          break label151;
        }
        ((URLDrawable.URLDrawableOptions)localObject3).isFlashPic = false;
        break label151;
        label226:
        if ((paramInt1 == 2) && (paramBoolean)) {
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        } else if ((paramInt1 == 1) && (paramBoolean)) {
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        }
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, ScribbleResMgr.b paramb)
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new DoodleResHelper.1(this, paramInt1, paramInt2, paramView, paramb));
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramInt1 == 0)
      {
        ScribbleResMgr.a().a(localQQAppInterface, 3, paramInt2, paramView, paramb);
        return;
      }
    } while ((paramInt1 != 1) && (paramInt1 != 2));
    ScribbleResMgr.a().a(localQQAppInterface, 4, paramInt2, paramView, paramb);
  }
  
  public boolean aw(int paramInt1, int paramInt2)
  {
    return !TextUtils.isEmpty(v(paramInt1, paramInt2));
  }
  
  public boolean ax(int paramInt1, int paramInt2)
  {
    return !TextUtils.isEmpty(u(paramInt1, paramInt2));
  }
  
  public boolean ay(int paramInt1, int paramInt2)
  {
    return (ax(paramInt1, paramInt2)) && (aw(paramInt1, paramInt2));
  }
  
  public void b(int paramInt1, int paramInt2, View paramView, ScribbleResMgr.b paramb)
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new DoodleResHelper.2(this, paramInt1, paramInt2, paramView, paramb));
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramInt1 == 0)
      {
        ScribbleResMgr.a().a(localQQAppInterface, 1, paramInt2, paramView, paramb);
        return;
      }
    } while ((paramInt1 != 1) && (paramInt1 != 2));
    ScribbleResMgr.a().a(localQQAppInterface, 2, paramInt2, paramView, paramb);
  }
  
  /* Error */
  public Drawable c(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iload_2
    //   4: ifge +9 -> 13
    //   7: aconst_null
    //   8: astore 6
    //   10: aload 6
    //   12: areturn
    //   13: aload_0
    //   14: iload_1
    //   15: iload_2
    //   16: invokevirtual 292	wrq:v	(II)Ljava/lang/String;
    //   19: astore 6
    //   21: aload 6
    //   23: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   34: aload_0
    //   35: aload 6
    //   37: iconst_1
    //   38: invokespecial 198	wrq:T	(Ljava/lang/String;I)Ljava/lang/String;
    //   41: invokevirtual 203	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull +8 -> 54
    //   49: aload_3
    //   50: checkcast 205	android/graphics/drawable/Drawable
    //   53: areturn
    //   54: new 312	java/io/FileInputStream
    //   57: dup
    //   58: aload 6
    //   60: invokespecial 313	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: astore_3
    //   64: new 315	java/io/BufferedInputStream
    //   67: dup
    //   68: aload_3
    //   69: invokespecial 318	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore 5
    //   74: aload 5
    //   76: invokestatic 324	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   79: astore 4
    //   81: new 326	android/graphics/drawable/BitmapDrawable
    //   84: dup
    //   85: invokestatic 59	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   88: invokevirtual 330	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   91: invokevirtual 221	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   94: aload 4
    //   96: invokespecial 333	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   99: astore 4
    //   101: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   104: aload_0
    //   105: aload 6
    //   107: iconst_1
    //   108: invokespecial 198	wrq:T	(Ljava/lang/String;I)Ljava/lang/String;
    //   111: aload 4
    //   113: invokevirtual 334	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 339	java/io/InputStream:close	()V
    //   125: aload 4
    //   127: astore 6
    //   129: aload 5
    //   131: ifnull -121 -> 10
    //   134: aload 5
    //   136: invokevirtual 339	java/io/InputStream:close	()V
    //   139: aload 4
    //   141: areturn
    //   142: astore_3
    //   143: aload 4
    //   145: areturn
    //   146: astore_3
    //   147: aconst_null
    //   148: astore 5
    //   150: aconst_null
    //   151: astore_3
    //   152: aload 4
    //   154: ifnull +8 -> 162
    //   157: aload 4
    //   159: invokevirtual 339	java/io/InputStream:close	()V
    //   162: aload_3
    //   163: astore 6
    //   165: aload 5
    //   167: ifnull -157 -> 10
    //   170: aload 5
    //   172: invokevirtual 339	java/io/InputStream:close	()V
    //   175: aload_3
    //   176: areturn
    //   177: astore 4
    //   179: aload_3
    //   180: areturn
    //   181: astore_3
    //   182: aconst_null
    //   183: astore_3
    //   184: aconst_null
    //   185: astore 5
    //   187: aconst_null
    //   188: astore 4
    //   190: aload_3
    //   191: ifnull +7 -> 198
    //   194: aload_3
    //   195: invokevirtual 339	java/io/InputStream:close	()V
    //   198: aload 4
    //   200: astore 6
    //   202: aload 5
    //   204: ifnull -194 -> 10
    //   207: aload 5
    //   209: invokevirtual 339	java/io/InputStream:close	()V
    //   212: aload 4
    //   214: areturn
    //   215: astore_3
    //   216: aload 4
    //   218: areturn
    //   219: astore 4
    //   221: aconst_null
    //   222: astore_3
    //   223: aconst_null
    //   224: astore 5
    //   226: aload_3
    //   227: ifnull +7 -> 234
    //   230: aload_3
    //   231: invokevirtual 339	java/io/InputStream:close	()V
    //   234: aload 5
    //   236: ifnull +8 -> 244
    //   239: aload 5
    //   241: invokevirtual 339	java/io/InputStream:close	()V
    //   244: aload 4
    //   246: athrow
    //   247: astore_3
    //   248: goto -123 -> 125
    //   251: astore 4
    //   253: goto -91 -> 162
    //   256: astore_3
    //   257: goto -59 -> 198
    //   260: astore_3
    //   261: goto -27 -> 234
    //   264: astore_3
    //   265: goto -21 -> 244
    //   268: astore 4
    //   270: aconst_null
    //   271: astore 5
    //   273: goto -47 -> 226
    //   276: astore 4
    //   278: goto -52 -> 226
    //   281: astore 4
    //   283: aconst_null
    //   284: astore 5
    //   286: aconst_null
    //   287: astore 4
    //   289: goto -99 -> 190
    //   292: astore 4
    //   294: aconst_null
    //   295: astore 4
    //   297: goto -107 -> 190
    //   300: astore 6
    //   302: goto -112 -> 190
    //   305: astore 4
    //   307: aconst_null
    //   308: astore 6
    //   310: aload_3
    //   311: astore 4
    //   313: aconst_null
    //   314: astore 5
    //   316: aload 6
    //   318: astore_3
    //   319: goto -167 -> 152
    //   322: astore 4
    //   324: aconst_null
    //   325: astore 6
    //   327: aload_3
    //   328: astore 4
    //   330: aload 6
    //   332: astore_3
    //   333: goto -181 -> 152
    //   336: astore 6
    //   338: aload_3
    //   339: astore 6
    //   341: aload 4
    //   343: astore_3
    //   344: aload 6
    //   346: astore 4
    //   348: goto -196 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	wrq
    //   0	351	1	paramInt1	int
    //   0	351	2	paramInt2	int
    //   44	78	3	localObject1	Object
    //   142	1	3	localIOException1	java.io.IOException
    //   146	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   151	29	3	localDrawable1	Drawable
    //   181	1	3	localException1	Exception
    //   183	12	3	localObject2	Object
    //   215	1	3	localIOException2	java.io.IOException
    //   222	9	3	localObject3	Object
    //   247	1	3	localIOException3	java.io.IOException
    //   256	1	3	localIOException4	java.io.IOException
    //   260	1	3	localIOException5	java.io.IOException
    //   264	47	3	localIOException6	java.io.IOException
    //   318	26	3	localObject4	Object
    //   1	157	4	localObject5	Object
    //   177	1	4	localIOException7	java.io.IOException
    //   188	29	4	localDrawable2	Drawable
    //   219	26	4	localObject6	Object
    //   251	1	4	localIOException8	java.io.IOException
    //   268	1	4	localObject7	Object
    //   276	1	4	localObject8	Object
    //   281	1	4	localException2	Exception
    //   287	1	4	localObject9	Object
    //   292	1	4	localException3	Exception
    //   295	1	4	localObject10	Object
    //   305	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   311	1	4	localObject11	Object
    //   322	1	4	localOutOfMemoryError3	OutOfMemoryError
    //   328	19	4	localObject12	Object
    //   72	243	5	localBufferedInputStream	java.io.BufferedInputStream
    //   8	193	6	localObject13	Object
    //   300	1	6	localException4	Exception
    //   308	23	6	localObject14	Object
    //   336	1	6	localOutOfMemoryError4	OutOfMemoryError
    //   339	6	6	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   134	139	142	java/io/IOException
    //   54	64	146	java/lang/OutOfMemoryError
    //   170	175	177	java/io/IOException
    //   54	64	181	java/lang/Exception
    //   207	212	215	java/io/IOException
    //   54	64	219	finally
    //   121	125	247	java/io/IOException
    //   157	162	251	java/io/IOException
    //   194	198	256	java/io/IOException
    //   230	234	260	java/io/IOException
    //   239	244	264	java/io/IOException
    //   64	74	268	finally
    //   74	101	276	finally
    //   101	117	276	finally
    //   64	74	281	java/lang/Exception
    //   74	101	292	java/lang/Exception
    //   101	117	300	java/lang/Exception
    //   64	74	305	java/lang/OutOfMemoryError
    //   74	101	322	java/lang/OutOfMemoryError
    //   101	117	336	java/lang/OutOfMemoryError
  }
  
  public void cbn()
  {
    try
    {
      this.hx = null;
      return;
    }
    finally {}
  }
  
  /* Error */
  public Bitmap d(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iload_2
    //   4: ifge +9 -> 13
    //   7: aconst_null
    //   8: astore 6
    //   10: aload 6
    //   12: areturn
    //   13: aload_0
    //   14: iload_1
    //   15: iload_2
    //   16: invokevirtual 292	wrq:v	(II)Ljava/lang/String;
    //   19: astore 6
    //   21: aload 6
    //   23: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: iload_2
    //   32: ifle +199 -> 231
    //   35: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   38: aload_0
    //   39: aload 6
    //   41: iconst_0
    //   42: invokespecial 198	wrq:T	(Ljava/lang/String;I)Ljava/lang/String;
    //   45: invokevirtual 203	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +8 -> 58
    //   53: aload_3
    //   54: checkcast 140	android/graphics/Bitmap
    //   57: areturn
    //   58: new 312	java/io/FileInputStream
    //   61: dup
    //   62: aload 6
    //   64: invokespecial 313	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   67: astore_3
    //   68: new 315	java/io/BufferedInputStream
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 318	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore 5
    //   78: aload 5
    //   80: invokestatic 324	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   83: astore 4
    //   85: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   88: aload_0
    //   89: aload 6
    //   91: iconst_0
    //   92: invokespecial 198	wrq:T	(Ljava/lang/String;I)Ljava/lang/String;
    //   95: aload 4
    //   97: invokevirtual 334	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: aload_3
    //   102: ifnull +7 -> 109
    //   105: aload_3
    //   106: invokevirtual 339	java/io/InputStream:close	()V
    //   109: aload 4
    //   111: astore 6
    //   113: aload 5
    //   115: ifnull -105 -> 10
    //   118: aload 5
    //   120: invokevirtual 339	java/io/InputStream:close	()V
    //   123: aload 4
    //   125: areturn
    //   126: astore_3
    //   127: aload 4
    //   129: areturn
    //   130: astore_3
    //   131: aconst_null
    //   132: astore_3
    //   133: aconst_null
    //   134: astore 5
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 339	java/io/InputStream:close	()V
    //   146: aload_3
    //   147: astore 6
    //   149: aload 5
    //   151: ifnull -141 -> 10
    //   154: aload 5
    //   156: invokevirtual 339	java/io/InputStream:close	()V
    //   159: aload_3
    //   160: areturn
    //   161: astore 4
    //   163: aload_3
    //   164: areturn
    //   165: astore_3
    //   166: aconst_null
    //   167: astore 4
    //   169: aconst_null
    //   170: astore_3
    //   171: aconst_null
    //   172: astore 5
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 339	java/io/InputStream:close	()V
    //   182: aload 4
    //   184: astore 6
    //   186: aload 5
    //   188: ifnull -178 -> 10
    //   191: aload 5
    //   193: invokevirtual 339	java/io/InputStream:close	()V
    //   196: aload 4
    //   198: areturn
    //   199: astore_3
    //   200: aload 4
    //   202: areturn
    //   203: astore 4
    //   205: aconst_null
    //   206: astore_3
    //   207: aconst_null
    //   208: astore 5
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 339	java/io/InputStream:close	()V
    //   218: aload 5
    //   220: ifnull +8 -> 228
    //   223: aload 5
    //   225: invokevirtual 339	java/io/InputStream:close	()V
    //   228: aload 4
    //   230: athrow
    //   231: aconst_null
    //   232: areturn
    //   233: astore_3
    //   234: goto -125 -> 109
    //   237: astore 4
    //   239: goto -93 -> 146
    //   242: astore_3
    //   243: goto -61 -> 182
    //   246: astore_3
    //   247: goto -29 -> 218
    //   250: astore_3
    //   251: goto -23 -> 228
    //   254: astore 4
    //   256: aconst_null
    //   257: astore 5
    //   259: goto -49 -> 210
    //   262: astore 4
    //   264: goto -54 -> 210
    //   267: astore 4
    //   269: aconst_null
    //   270: astore 4
    //   272: aconst_null
    //   273: astore 5
    //   275: goto -101 -> 174
    //   278: astore 4
    //   280: aconst_null
    //   281: astore 4
    //   283: goto -109 -> 174
    //   286: astore 6
    //   288: goto -114 -> 174
    //   291: astore 4
    //   293: aconst_null
    //   294: astore 6
    //   296: aconst_null
    //   297: astore 5
    //   299: aload_3
    //   300: astore 4
    //   302: aload 6
    //   304: astore_3
    //   305: goto -169 -> 136
    //   308: astore 4
    //   310: aconst_null
    //   311: astore 6
    //   313: aload_3
    //   314: astore 4
    //   316: aload 6
    //   318: astore_3
    //   319: goto -183 -> 136
    //   322: astore 6
    //   324: aload_3
    //   325: astore 6
    //   327: aload 4
    //   329: astore_3
    //   330: aload 6
    //   332: astore 4
    //   334: goto -198 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	wrq
    //   0	337	1	paramInt1	int
    //   0	337	2	paramInt2	int
    //   48	58	3	localObject1	Object
    //   126	1	3	localIOException1	java.io.IOException
    //   130	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   132	32	3	localBitmap1	Bitmap
    //   165	1	3	localException1	Exception
    //   170	9	3	localObject2	Object
    //   199	1	3	localIOException2	java.io.IOException
    //   206	9	3	localObject3	Object
    //   233	1	3	localIOException3	java.io.IOException
    //   242	1	3	localIOException4	java.io.IOException
    //   246	1	3	localIOException5	java.io.IOException
    //   250	50	3	localIOException6	java.io.IOException
    //   304	26	3	localObject4	Object
    //   1	141	4	localBitmap2	Bitmap
    //   161	1	4	localIOException7	java.io.IOException
    //   167	34	4	localBitmap3	Bitmap
    //   203	26	4	localObject5	Object
    //   237	1	4	localIOException8	java.io.IOException
    //   254	1	4	localObject6	Object
    //   262	1	4	localObject7	Object
    //   267	1	4	localException2	Exception
    //   270	1	4	localObject8	Object
    //   278	1	4	localException3	Exception
    //   281	1	4	localObject9	Object
    //   291	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   300	1	4	localObject10	Object
    //   308	1	4	localOutOfMemoryError3	OutOfMemoryError
    //   314	19	4	localObject11	Object
    //   76	222	5	localBufferedInputStream	java.io.BufferedInputStream
    //   8	177	6	localObject12	Object
    //   286	1	6	localException4	Exception
    //   294	23	6	localObject13	Object
    //   322	1	6	localOutOfMemoryError4	OutOfMemoryError
    //   325	6	6	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   118	123	126	java/io/IOException
    //   58	68	130	java/lang/OutOfMemoryError
    //   154	159	161	java/io/IOException
    //   58	68	165	java/lang/Exception
    //   191	196	199	java/io/IOException
    //   58	68	203	finally
    //   105	109	233	java/io/IOException
    //   141	146	237	java/io/IOException
    //   178	182	242	java/io/IOException
    //   214	218	246	java/io/IOException
    //   223	228	250	java/io/IOException
    //   68	78	254	finally
    //   78	85	262	finally
    //   85	101	262	finally
    //   68	78	267	java/lang/Exception
    //   78	85	278	java/lang/Exception
    //   85	101	286	java/lang/Exception
    //   68	78	291	java/lang/OutOfMemoryError
    //   78	85	308	java/lang/OutOfMemoryError
    //   85	101	322	java/lang/OutOfMemoryError
  }
  
  public Bitmap e(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      try
      {
        if (this.hx == null) {
          this.hx = new HashMap();
        }
        if (this.hx.size() <= 0) {
          break label233;
        }
        localObject4 = this.hx.entrySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label233;
        }
        localObject5 = (wrq.a)((Map.Entry)((Iterator)localObject4).next()).getValue();
        if ((localObject5 == null) || (((wrq.a)localObject5).dR == null) || (((wrq.a)localObject5).dR.get() == null))
        {
          ((Iterator)localObject4).remove();
          QLog.d("DoodleResHelper", 2, "getBitmap remove a invalid item");
          continue;
        }
        if (!((wrq.a)localObject5).bfL) {
          continue;
        }
      }
      finally {}
      if ((((wrq.a)localObject5).mHeight == paramInt2) && (((wrq.a)localObject5).mWidth == paramInt1))
      {
        if (((wrq.a)localObject5).dR != null) {}
        label233:
        Object localObject3;
        for (Object localObject2 = (Bitmap)((wrq.a)localObject5).dR.get(); localObject2 != null; localObject3 = null)
        {
          QLog.d("DoodleResHelper", 2, "getBitmap find idle :" + this.hx.size());
          ((wrq.a)localObject5).bfL = false;
          return localObject2;
          QLog.d("DoodleResHelper", 2, "getBitmap add new item");
          localObject2 = new wrq.a();
          ((wrq.a)localObject2).mHeight = paramInt2;
          ((wrq.a)localObject2).mWidth = paramInt1;
          try
          {
            localObject4 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
            ((wrq.a)localObject2).dR = new WeakReference(localObject4);
            ((wrq.a)localObject2).bfL = false;
            localObject5 = this.hx;
            paramInt1 = this.mID;
            this.mID = (paramInt1 + 1);
            ((Map)localObject5).put(Integer.valueOf(paramInt1), localObject2);
            QLog.d("DoodleResHelper", 2, "getBitmap create new cache:" + this.hx.size());
            return localObject4;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localOutOfMemoryError.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("DoodleResHelper", 2, "getBitmap exception OOM!" + localOutOfMemoryError.toString());
            }
            if (QLog.isColorLevel()) {
              QLog.d("DoodleResHelper", 2, "getBitmap error!");
            }
            return null;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("DoodleResHelper", 2, "getBitmap exception:" + localException);
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: iload_1
    //   5: iload_2
    //   6: invokevirtual 174	wrq:u	(II)Ljava/lang/String;
    //   9: astore 8
    //   11: aload 8
    //   13: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +9 -> 25
    //   19: aconst_null
    //   20: astore 6
    //   22: aload 6
    //   24: areturn
    //   25: iload_2
    //   26: ifle +252 -> 278
    //   29: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   32: aload_0
    //   33: aload 8
    //   35: iconst_0
    //   36: invokespecial 198	wrq:T	(Ljava/lang/String;I)Ljava/lang/String;
    //   39: invokevirtual 203	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +8 -> 52
    //   47: aload_3
    //   48: checkcast 140	android/graphics/Bitmap
    //   51: areturn
    //   52: new 312	java/io/FileInputStream
    //   55: dup
    //   56: aload 8
    //   58: invokespecial 313	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   61: astore_3
    //   62: new 315	java/io/BufferedInputStream
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 318	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore 5
    //   72: aload_3
    //   73: astore 7
    //   75: aload 5
    //   77: astore 6
    //   79: aload 5
    //   81: invokestatic 324	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   84: astore 4
    //   86: aload 4
    //   88: ifnull +31 -> 119
    //   91: iconst_3
    //   92: iload_1
    //   93: if_icmpeq +26 -> 119
    //   96: aload_3
    //   97: astore 7
    //   99: aload 5
    //   101: astore 6
    //   103: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   106: aload_0
    //   107: aload 8
    //   109: iconst_0
    //   110: invokespecial 198	wrq:T	(Ljava/lang/String;I)Ljava/lang/String;
    //   113: aload 4
    //   115: invokevirtual 334	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: pop
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 339	java/io/InputStream:close	()V
    //   127: aload 4
    //   129: astore 6
    //   131: aload 5
    //   133: ifnull -111 -> 22
    //   136: aload 5
    //   138: invokevirtual 339	java/io/InputStream:close	()V
    //   141: aload 4
    //   143: areturn
    //   144: astore_3
    //   145: aload 4
    //   147: areturn
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_3
    //   151: aconst_null
    //   152: astore 5
    //   154: aload 4
    //   156: ifnull +8 -> 164
    //   159: aload 4
    //   161: invokevirtual 339	java/io/InputStream:close	()V
    //   164: aload_3
    //   165: astore 6
    //   167: aload 5
    //   169: ifnull -147 -> 22
    //   172: aload 5
    //   174: invokevirtual 339	java/io/InputStream:close	()V
    //   177: aload_3
    //   178: areturn
    //   179: astore 4
    //   181: aload_3
    //   182: areturn
    //   183: astore_3
    //   184: aconst_null
    //   185: astore 4
    //   187: aconst_null
    //   188: astore_3
    //   189: aconst_null
    //   190: astore 5
    //   192: aload_3
    //   193: astore 7
    //   195: aload 5
    //   197: astore 6
    //   199: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +19 -> 221
    //   205: aload_3
    //   206: astore 7
    //   208: aload 5
    //   210: astore 6
    //   212: ldc 21
    //   214: iconst_2
    //   215: ldc_w 399
    //   218: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_3
    //   222: ifnull +7 -> 229
    //   225: aload_3
    //   226: invokevirtual 339	java/io/InputStream:close	()V
    //   229: aload 4
    //   231: astore 6
    //   233: aload 5
    //   235: ifnull -213 -> 22
    //   238: aload 5
    //   240: invokevirtual 339	java/io/InputStream:close	()V
    //   243: aload 4
    //   245: areturn
    //   246: astore_3
    //   247: aload 4
    //   249: areturn
    //   250: astore 4
    //   252: aconst_null
    //   253: astore_3
    //   254: aconst_null
    //   255: astore 6
    //   257: aload_3
    //   258: ifnull +7 -> 265
    //   261: aload_3
    //   262: invokevirtual 339	java/io/InputStream:close	()V
    //   265: aload 6
    //   267: ifnull +8 -> 275
    //   270: aload 6
    //   272: invokevirtual 339	java/io/InputStream:close	()V
    //   275: aload 4
    //   277: athrow
    //   278: aconst_null
    //   279: areturn
    //   280: astore_3
    //   281: goto -154 -> 127
    //   284: astore 4
    //   286: goto -122 -> 164
    //   289: astore_3
    //   290: goto -61 -> 229
    //   293: astore_3
    //   294: goto -29 -> 265
    //   297: astore_3
    //   298: goto -23 -> 275
    //   301: astore 4
    //   303: aconst_null
    //   304: astore 6
    //   306: goto -49 -> 257
    //   309: astore 4
    //   311: aload 7
    //   313: astore_3
    //   314: goto -57 -> 257
    //   317: astore 4
    //   319: aconst_null
    //   320: astore 4
    //   322: aconst_null
    //   323: astore 5
    //   325: goto -133 -> 192
    //   328: astore 4
    //   330: aconst_null
    //   331: astore 4
    //   333: goto -141 -> 192
    //   336: astore 6
    //   338: goto -146 -> 192
    //   341: astore 4
    //   343: aconst_null
    //   344: astore 6
    //   346: aconst_null
    //   347: astore 5
    //   349: aload_3
    //   350: astore 4
    //   352: aload 6
    //   354: astore_3
    //   355: goto -201 -> 154
    //   358: astore 4
    //   360: aconst_null
    //   361: astore 6
    //   363: aload_3
    //   364: astore 4
    //   366: aload 6
    //   368: astore_3
    //   369: goto -215 -> 154
    //   372: astore 6
    //   374: aload_3
    //   375: astore 6
    //   377: aload 4
    //   379: astore_3
    //   380: aload 6
    //   382: astore 4
    //   384: goto -230 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	wrq
    //   0	387	1	paramInt1	int
    //   0	387	2	paramInt2	int
    //   42	82	3	localObject1	Object
    //   144	1	3	localIOException1	java.io.IOException
    //   148	1	3	localException1	Exception
    //   150	32	3	localBitmap1	Bitmap
    //   183	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   188	38	3	localObject2	Object
    //   246	1	3	localIOException2	java.io.IOException
    //   253	9	3	localObject3	Object
    //   280	1	3	localIOException3	java.io.IOException
    //   289	1	3	localIOException4	java.io.IOException
    //   293	1	3	localIOException5	java.io.IOException
    //   297	1	3	localIOException6	java.io.IOException
    //   313	67	3	localObject4	Object
    //   1	159	4	localBitmap2	Bitmap
    //   179	1	4	localIOException7	java.io.IOException
    //   185	63	4	localBitmap3	Bitmap
    //   250	26	4	localObject5	Object
    //   284	1	4	localIOException8	java.io.IOException
    //   301	1	4	localObject6	Object
    //   309	1	4	localObject7	Object
    //   317	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   320	1	4	localObject8	Object
    //   328	1	4	localOutOfMemoryError3	OutOfMemoryError
    //   331	1	4	localObject9	Object
    //   341	1	4	localException2	Exception
    //   350	1	4	localObject10	Object
    //   358	1	4	localException3	Exception
    //   364	19	4	localObject11	Object
    //   70	278	5	localBufferedInputStream	java.io.BufferedInputStream
    //   20	285	6	localObject12	Object
    //   336	1	6	localOutOfMemoryError4	OutOfMemoryError
    //   344	23	6	localObject13	Object
    //   372	1	6	localException4	Exception
    //   375	6	6	localObject14	Object
    //   73	239	7	localObject15	Object
    //   9	99	8	str	String
    // Exception table:
    //   from	to	target	type
    //   136	141	144	java/io/IOException
    //   52	62	148	java/lang/Exception
    //   172	177	179	java/io/IOException
    //   52	62	183	java/lang/OutOfMemoryError
    //   238	243	246	java/io/IOException
    //   52	62	250	finally
    //   123	127	280	java/io/IOException
    //   159	164	284	java/io/IOException
    //   225	229	289	java/io/IOException
    //   261	265	293	java/io/IOException
    //   270	275	297	java/io/IOException
    //   62	72	301	finally
    //   79	86	309	finally
    //   103	119	309	finally
    //   199	205	309	finally
    //   212	221	309	finally
    //   62	72	317	java/lang/OutOfMemoryError
    //   79	86	328	java/lang/OutOfMemoryError
    //   103	119	336	java/lang/OutOfMemoryError
    //   62	72	341	java/lang/Exception
    //   79	86	358	java/lang/Exception
    //   103	119	372	java/lang/Exception
  }
  
  public String u(int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramInt1 == 0) {
      localObject = ScribbleResMgr.Q(1, paramInt2);
    }
    for (;;)
    {
      if (!aqhq.fileExists((String)localObject))
      {
        return null;
        if (paramInt1 == 1)
        {
          localObject = ScribbleResMgr.Q(2, paramInt2);
          continue;
        }
        if (paramInt1 == 2)
        {
          localObject = ScribbleResMgr.Q(2, paramInt2);
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf('.')) + "ex.gif";
          continue;
        }
        if (paramInt1 == 3)
        {
          localObject = ScribbleResMgr.Q(2, paramInt2);
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf('.')) + "pre.png";
        }
      }
      else
      {
        return localObject;
      }
      localObject = null;
    }
  }
  
  public String v(int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramInt1 == 0) {
      localObject = ScribbleResMgr.P(1, paramInt2);
    }
    for (;;)
    {
      if (!aqhq.fileExists((String)localObject))
      {
        return null;
        if ((paramInt1 == 2) || (paramInt1 == 1)) {
          localObject = ScribbleResMgr.P(2, paramInt2);
        }
      }
      else
      {
        return localObject;
      }
      localObject = null;
    }
  }
  
  class a
  {
    boolean bfL;
    WeakReference<Bitmap> dR;
    int mHeight;
    int mWidth;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrq
 * JD-Core Version:    0.7.0.1
 */