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

public class vvr
{
  public static URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841114);
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
  
  public static void a(String paramString, URLImageView paramURLImageView, URLDrawable.URLDrawableOptions paramURLDrawableOptions, boolean paramBoolean)
  {
    WeakReference localWeakReference = new WeakReference(paramURLImageView);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
    if (paramURLDrawableOptions == null) {}
    try
    {
      localURLDrawableOptions = b(paramURLImageView);
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
    }
  }
  
  @NotNull
  private static URLDrawable.URLDrawableOptions b(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130845521);
    if (paramURLImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
  
  public static void b(String paramString, URLImageView paramURLImageView)
  {
    a(paramString, paramURLImageView, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vvr
 * JD-Core Version:    0.7.0.1
 */