import android.content.res.Resources;
import android.support.v4.util.MQLruCache;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class ryx
{
  @NotNull
  public static URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130847483);
    if (paramURLImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, URLDrawable.URLDrawableOptions paramURLDrawableOptions, boolean paramBoolean)
  {
    WeakReference localWeakReference = new WeakReference(paramURLImageView);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
    if (paramURLDrawableOptions == null) {}
    try
    {
      localURLDrawableOptions = a(paramURLImageView);
      if (paramBoolean) {}
      for (paramString = URLDrawable.getFileDrawable(paramString, localURLDrawableOptions); (paramString != null) && (localWeakReference.get() != null); paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions))
      {
        ((ImageView)localWeakReference.get()).setImageDrawable(paramString);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Error paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static URLDrawable.URLDrawableOptions b(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130842474);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryx
 * JD-Core Version:    0.7.0.1
 */