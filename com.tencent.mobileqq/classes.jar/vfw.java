import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool.2;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.SystemEmoCell;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class vfw
{
  private static int jdField_a_of_type_Int = bgtn.a(5.0F);
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static vfw jdField_a_of_type_Vfw;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private SparseArray<Drawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ConcurrentHashMap<String, SparseArray<SoftReference<EmoCell>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static int a(String paramString)
  {
    int n = -1;
    int i = n;
    int i2;
    int j;
    int i3;
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = paramString.length();
      i2 = paramString.length();
      paramString = new StringBuilder().append(paramString);
      j = 0;
      i = n;
      if (j < i1)
      {
        i3 = paramString.codePointAt(j);
        k = bdnh.a(i3);
        if (i3 <= 65535) {
          break label130;
        }
        if (i2 <= j + 2) {
          break label197;
        }
        i = paramString.codePointAt(j + 2);
      }
    }
    for (;;)
    {
      label84:
      if (bdnh.a(i)) {}
      for (int m = 1;; m = 0)
      {
        if ((k == -1) || (m != 0))
        {
          m = bdnh.a(i3, i);
          i = m;
          if (m != -1) {}
        }
        for (i = k;; i = k)
        {
          if (i != -1)
          {
            return i;
            label130:
            if (i2 <= j + 1) {
              break label197;
            }
            m = paramString.codePointAt(j + 1);
            i = m;
            if (m != 65039) {
              break label84;
            }
            i = m;
            if (i2 <= j + 2) {
              break label84;
            }
            i = paramString.codePointAt(j + 2);
            break label84;
          }
          j += 1;
          break;
        }
      }
      label197:
      i = -1;
    }
  }
  
  private Drawable a(int paramInt)
  {
    for (;;)
    {
      try
      {
        Drawable localDrawable = (Drawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        Object localObject1 = localDrawable;
        if (localDrawable == null) {}
        try
        {
          localObject1 = BaseApplication.getContext().getResources().getDrawable(2130848231);
          if (localObject1 != null) {
            break label75;
          }
          localObject1 = new ColorDrawable(Color.parseColor("#e8e8e8"));
        }
        catch (Exception localException)
        {
          ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e8e8e8"));
          continue;
        }
        return localObject1;
      }
      finally {}
      label75:
      localObject2.setBounds(0, 0, paramInt, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
    }
  }
  
  protected static Drawable a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (paramInt == 0)) {
      return paramDrawable;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f;
    if ((i > 0) && (j > 0)) {
      f = paramInt;
    }
    for (i = (int)(i * f / j);; i = paramInt)
    {
      Drawable.Callback localCallback = paramDrawable.getCallback();
      paramDrawable.setCallback(null);
      paramDrawable.setBounds(0, 0, i, paramInt);
      paramDrawable.setCallback(localCallback);
      return paramDrawable;
    }
  }
  
  private static String a(String paramString)
  {
    int i = paramString.indexOf("[dra]") + "[dra]".length();
    int j = paramString.indexOf("[/dra]");
    if ((i == -1) || (j == -1)) {
      return null;
    }
    return paramString.substring(i, j);
  }
  
  public static vfw a()
  {
    if (jdField_a_of_type_Vfw == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Vfw == null) {
        jdField_a_of_type_Vfw = new vfw();
      }
      return jdField_a_of_type_Vfw;
    }
  }
  
  private void a(int paramInt1, int paramInt2, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    PriorityThreadPool.getDefault().submit(new vfx(this, paramImageLoadListener, paramInt2, paramInt1, paramOptions), PriorityThreadPool.Priority.HIGH);
  }
  
  private void a(EmoCell paramEmoCell, String paramString, int paramInt, vhc paramvhc, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    Object localObject = null;
    ImageLoader.Options localOptions;
    if (arvq.a(paramString) != -1)
    {
      localOptions = ImageLoader.Options.obtain();
      localOptions.obj = paramEmoCell;
      localOptions.useMainThread = true;
      localOptions.disableHitRateReport = true;
      a(arvq.a(paramString), 1, new vfy(this, paramInt, paramvhc, paramImageLoadListener), localOptions);
      paramString = (String)localObject;
    }
    for (;;)
    {
      if (paramString != null)
      {
        a(paramString, paramInt);
        paramEmoCell.emoDrawable = paramString;
        paramEmoCell.isDrawableLoaded = true;
      }
      int i;
      int j;
      do
      {
        return;
        if (arvj.a(paramString) != -1)
        {
          localOptions = ImageLoader.Options.obtain();
          localOptions.obj = paramEmoCell;
          localOptions.useMainThread = true;
          localOptions.disableHitRateReport = true;
          a(arvj.a(paramString), 2, new vfy(this, paramInt, paramvhc, paramImageLoadListener), localOptions);
          paramString = (String)localObject;
          break;
        }
        if (paramString.startsWith("[dra]"))
        {
          localOptions = ImageLoader.Options.obtain();
          localOptions.obj = paramEmoCell;
          localOptions.useMainThread = true;
          localOptions.disableHitRateReport = true;
          a(a(paramString), paramInt, new vfy(this, paramInt, paramvhc, paramImageLoadListener), localOptions);
          paramString = (String)localObject;
          break;
        }
        i = paramString.indexOf("[em]") + "[em]".length();
        j = paramString.indexOf("[/em]");
      } while ((i == -1) || (j == -1));
      localObject = paramString.substring(i, j);
      try
      {
        paramString = bmpg.e((String)localObject);
        localObject = ImageLoader.Options.obtain();
        ((ImageLoader.Options)localObject).obj = paramEmoCell;
        ((ImageLoader.Options)localObject).useMainThread = true;
        ((ImageLoader.Options)localObject).disableHitRateReport = true;
        ((ImageLoader.Options)localObject).type = "qzEmod";
        paramString = ImageLoader.getInstance().loadImage(paramString, new vfy(this, paramInt, paramvhc, paramImageLoadListener), (ImageLoader.Options)localObject);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = "https://qzonestyle.gtimg.cn/qzone/em/" + (String)localObject + ".gif";
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new EmoObjectPool.2(this, paramString, paramOptions, paramImageLoadListener));
  }
  
  private static int b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("qzone_famous_icon"))) {
      return 2130847928;
    }
    return 0;
  }
  
  private static Drawable b(String paramString, Resources paramResources)
  {
    try
    {
      paramString = paramResources.getDrawable(b(paramString));
      return paramString;
    }
    catch (Throwable paramString)
    {
      QZLog.e("ERROR", "PICTURE NOT　FOUND！", paramString);
    }
    return null;
  }
  
  public EmoCell a(String paramString, int paramInt, vhc paramvhc)
  {
    SparseArray localSparseArray = (SparseArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localSparseArray == null) {
      localSparseArray = new SparseArray();
    }
    for (;;)
    {
      Object localObject = a(paramInt);
      SoftReference localSoftReference = (SoftReference)localSparseArray.get(paramInt);
      if (localSoftReference != null)
      {
        EmoCell localEmoCell = (EmoCell)localSoftReference.get();
        if ((localEmoCell != null) && (localEmoCell.emoDrawable.getBounds().isEmpty())) {
          a(localEmoCell.emoDrawable, paramInt);
        }
        if ((localEmoCell != null) && (localEmoCell.emoDrawable == localObject))
        {
          localEmoCell.isDrawableLoaded = false;
          a(localEmoCell, paramString, paramInt, paramvhc, null);
        }
      }
      if ((localSoftReference == null) || (localSoftReference.get() == null))
      {
        localObject = new EmoCell(new String(paramString), (Drawable)localObject);
        if (((EmoCell)localObject).emoDrawable.getBounds().isEmpty()) {
          a(((EmoCell)localObject).emoDrawable, paramInt);
        }
        ((EmoCell)localObject).isDrawableLoaded = false;
        a((EmoCell)localObject, paramString, paramInt, paramvhc, null);
        localSparseArray.put(paramInt, new SoftReference(localObject));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localSparseArray);
        return localObject;
      }
      return (EmoCell)localSoftReference.get();
    }
  }
  
  public SystemEmoCell a(String paramString, int paramInt, vhc paramvhc)
  {
    paramString = new SystemEmoCell(paramString, paramInt);
    paramString.isDrawableLoaded = false;
    a(paramString, paramvhc, null);
    return paramString;
  }
  
  public void a(EmoCell paramEmoCell, vhc paramvhc, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    if (paramEmoCell == null) {}
    int i;
    Drawable localDrawable;
    do
    {
      return;
      i = (int)paramEmoCell.getWidth(null);
      localDrawable = a(i);
    } while (paramEmoCell.emoDrawable != localDrawable);
    a(paramEmoCell, paramEmoCell.emoCode, i, paramvhc, paramImageLoadListener);
  }
  
  public void a(SystemEmoCell paramSystemEmoCell, vhc paramvhc, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    if (paramSystemEmoCell == null) {
      return;
    }
    int i = a(paramSystemEmoCell.text);
    if (i >= 0)
    {
      paramvhc = bdol.a(i, new vfz(this, paramvhc, paramSystemEmoCell, paramImageLoadListener));
      if (paramvhc != null)
      {
        paramSystemEmoCell.isDrawableLoaded = true;
        paramSystemEmoCell.emoDrawable = paramvhc;
        a(paramvhc, paramSystemEmoCell.mHeight);
        paramSystemEmoCell.mWidth = paramvhc.getBounds().width();
        return;
      }
    }
    paramSystemEmoCell.isDrawableLoaded = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfw
 * JD-Core Version:    0.7.0.1
 */