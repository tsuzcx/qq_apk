import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class tql
{
  @NotNull
  public static URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130846089);
    if (paramURLImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
  
  public static void a()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      BaseApplicationImpl.sImageCache.evict(0);
      return;
    }
    BaseApplicationImpl.sImageCache.evictAll();
  }
  
  public static void a(String paramString, URLImageView paramURLImageView)
  {
    a(paramString, paramURLImageView, null, false);
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = b(paramURLImageView);
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    a(paramString, paramURLImageView, localURLDrawableOptions, false);
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, URLDrawable.URLDrawableOptions paramURLDrawableOptions, boolean paramBoolean)
  {
    WeakReference localWeakReference = new WeakReference(paramURLImageView);
    Object localObject = paramURLDrawableOptions;
    if (paramURLDrawableOptions == null) {}
    for (;;)
    {
      try
      {
        localObject = a(paramURLImageView);
        long l = 0L;
        if (paramBoolean)
        {
          paramURLDrawableOptions = URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
          if ((paramURLDrawableOptions == null) || (localWeakReference.get() == null)) {
            break label158;
          }
          paramURLImageView.setURLDrawableDownListener(new tqm(l, paramString));
          ((ImageView)localWeakReference.get()).setImageDrawable(paramURLDrawableOptions);
          return;
        }
        localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        paramURLDrawableOptions = (URLDrawable.URLDrawableOptions)localObject;
        switch (((URLDrawable)localObject).getStatus())
        {
        case 1: 
        case 3: 
          l = System.currentTimeMillis();
          ((URLDrawable)localObject).startDownload();
          paramURLDrawableOptions = (URLDrawable.URLDrawableOptions)localObject;
          break;
        case 2: 
          l = System.currentTimeMillis();
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      ((URLDrawable)localObject).restartDownload();
      paramURLDrawableOptions = (URLDrawable.URLDrawableOptions)localObject;
      continue;
      label158:
      return;
    }
  }
  
  public static URLDrawable.URLDrawableOptions b(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841308);
    if ((paramURLImageView != null) && (paramURLImageView.getLayoutParams() != null))
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tql
 * JD-Core Version:    0.7.0.1
 */