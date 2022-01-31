import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class xer
{
  private static xer a = new xer();
  
  public static xer a()
  {
    return a;
  }
  
  public void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      wxe.e("ImageLoader", "ImageView or uri is null.");
      return;
    }
    wxe.b("ImageLoader", "uri:" + paramString + ",width:" + paramInt1 + ",height:" + paramInt2);
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      paramContext.mRequestWidth = paramInt1;
      paramContext.mRequestHeight = paramInt2;
    }
    paramContext.mFailedDrawable = bayu.a;
    paramContext.mLoadingDrawable = bayu.a;
    paramContext.mUseAutoScaleParams = false;
    paramContext = URLDrawable.getDrawable(paramString, paramContext);
    if (paramURLDrawableListener != null)
    {
      if (paramContext.getStatus() != 1) {
        break label154;
      }
      wxe.b("ImageLoader", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramContext);
    }
    for (;;)
    {
      paramContext.setURLDrawableListener(paramURLDrawableListener);
      paramImageView.setImageDrawable(paramContext);
      return;
      label154:
      wxe.b("ImageLoader", "start load URLDrawable.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xer
 * JD-Core Version:    0.7.0.1
 */