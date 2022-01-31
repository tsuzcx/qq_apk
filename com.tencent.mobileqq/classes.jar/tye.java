import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class tye
  implements tyh
{
  private final HashSet<URLDrawable> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final ConcurrentHashMap<String, HashSet<tyi>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private Bitmap a(@NonNull URLDrawable paramURLDrawable, int paramInt1, int paramInt2)
  {
    Object localObject = paramURLDrawable.getCurrDrawable();
    if ((localObject instanceof RegionDrawable))
    {
      localObject = ((RegionDrawable)localObject).getBitmap();
      if (localObject != null) {
        return localObject;
      }
    }
    return bacm.a(paramURLDrawable, paramInt1, paramInt2);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, tyi paramtyi)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(1073741824);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable;
    try
    {
      URL localURL = new URL(paramString);
      localObject = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new tyf(this, paramString, paramInt1, paramInt2, (URLDrawable)localObject));
      ((URLDrawable)localObject).setAutoDownload(true);
      if (((URLDrawable)localObject).getStatus() != 1) {
        break label177;
      }
      urk.a("story.icon.ShareGroupIconManager", "download url success directly. %s", paramString);
      localObject = a((URLDrawable)localObject, paramInt1, paramInt2);
      if (localObject != null)
      {
        paramtyi.a(paramString, (Bitmap)localObject);
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      urk.d("story.icon.ShareGroupIconManager", localMalformedURLException, "can not download url. %s", new Object[] { paramString });
      paramtyi.a(paramString, new Throwable("getBitmapFromDrawable failed"));
      return;
    }
    urk.e("story.icon.ShareGroupIconManager", "download url success directly. but OOM occur !");
    paramtyi.a(paramString, new Throwable("getBitmapFromDrawable failed"));
    return;
    label177:
    urk.a("story.icon.ShareGroupIconManager", "download url pending. %s", paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(paramString, new HashSet());
    ((HashSet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).add(paramtyi);
    this.jdField_a_of_type_JavaUtilHashSet.add(localMalformedURLException);
    localMalformedURLException.startDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tye
 * JD-Core Version:    0.7.0.1
 */