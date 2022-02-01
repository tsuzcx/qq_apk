import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class ous
{
  @NotNull
  public static URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130847483);
    localURLDrawableOptions.mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844853);
    if (paramURLImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = b(paramURLImageView);
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    a(paramString, paramURLImageView, localURLDrawableOptions, false);
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, URLDrawable.URLDrawableOptions paramURLDrawableOptions, boolean paramBoolean)
  {
    a(paramString, paramURLImageView, paramURLDrawableOptions, paramBoolean, null);
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, URLDrawable.URLDrawableOptions paramURLDrawableOptions, boolean paramBoolean, URLDrawableDownListener paramURLDrawableDownListener)
  {
    WeakReference localWeakReference = new WeakReference(paramURLImageView);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
    if (paramURLDrawableOptions == null) {}
    for (;;)
    {
      try
      {
        localURLDrawableOptions = a(paramURLImageView);
        long l = 0L;
        if (paramBoolean)
        {
          paramURLDrawableOptions = URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
          if ((paramURLDrawableOptions != null) && (localWeakReference.get() != null))
          {
            paramURLImageView.setURLDrawableDownListener(new out(paramURLDrawableDownListener, l, paramString));
            ((ImageView)localWeakReference.get()).setImageDrawable(paramURLDrawableOptions);
          }
        }
        else
        {
          paramURLDrawableOptions = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        }
        switch (paramURLDrawableOptions.getStatus())
        {
        case 2: 
          l = System.currentTimeMillis();
          paramURLDrawableOptions.startDownload();
          continue;
          l = System.currentTimeMillis();
          paramURLDrawableOptions.restartDownload();
          continue;
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static URLDrawable.URLDrawableOptions b(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130842474);
    localURLDrawableOptions.mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844853);
    if ((paramURLImageView != null) && (paramURLImageView.getLayoutParams() != null))
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
  
  public static void b(String paramString, URLImageView paramURLImageView)
  {
    a(paramString, paramURLImageView, null, false);
  }
  
  public static void clearMemoryCache()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      BaseApplicationImpl.sImageCache.evict(0);
      return;
    }
    BaseApplicationImpl.sImageCache.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ous
 * JD-Core Version:    0.7.0.1
 */