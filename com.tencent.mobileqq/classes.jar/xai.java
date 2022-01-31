import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class xai
{
  private static xai a = new xai();
  
  public static xai a()
  {
    return a;
  }
  
  public void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      wsv.e("ImageLoader", "ImageView or uri is null.");
      return;
    }
    wsv.b("ImageLoader", "uri:" + paramString + ",width:" + paramInt1 + ",height:" + paramInt2);
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      paramContext.mRequestWidth = paramInt1;
      paramContext.mRequestHeight = paramInt2;
    }
    paramContext.mFailedDrawable = baul.a;
    paramContext.mLoadingDrawable = baul.a;
    paramContext.mUseAutoScaleParams = false;
    paramContext = URLDrawable.getDrawable(paramString, paramContext);
    if (paramURLDrawableListener != null)
    {
      if (paramContext.getStatus() != 1) {
        break label154;
      }
      wsv.b("ImageLoader", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramContext);
    }
    for (;;)
    {
      paramContext.setURLDrawableListener(paramURLDrawableListener);
      paramImageView.setImageDrawable(paramContext);
      return;
      label154:
      wsv.b("ImageLoader", "start load URLDrawable.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xai
 * JD-Core Version:    0.7.0.1
 */