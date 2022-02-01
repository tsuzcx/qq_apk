import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class key
{
  public static void E(Drawable paramDrawable)
  {
    if (!ze()) {
      QLog.i("DailyDynamicHeaderBackgroundController", 1, "blurBackground, isNeedToBlurBackground : NO");
    }
    while (!(paramDrawable instanceof URLDrawable)) {
      return;
    }
    ((URLDrawable)paramDrawable).setDecodeHandler(new kez());
  }
  
  public static void h(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (zf())
    {
      paramImageView.setColorFilter(855638016, PorterDuff.Mode.DARKEN);
      return;
    }
    paramImageView.clearColorFilter();
  }
  
  private static boolean ze()
  {
    Object localObject = (lcd)((QQAppInterface)kxm.getAppRuntime()).getManager(163);
    if (localObject != null)
    {
      localObject = ((lcd)localObject).b().C();
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("is_blur_background", "0");
        QLog.i("DailyDynamicHeaderBackgroundController", 1, "isNeedToBlurBackground, isBlurBackground = " + (String)localObject);
        return "1".equals(localObject);
      }
    }
    return false;
  }
  
  private static boolean zf()
  {
    Object localObject = (lcd)((QQAppInterface)kxm.getAppRuntime()).getManager(163);
    if (localObject != null)
    {
      localObject = ((lcd)localObject).b().C();
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("is_cover_background", "0");
        QLog.i("DailyDynamicHeaderBackgroundController", 1, "isNeedGrayLayer, isCoverBackground = " + (String)localObject);
        return "1".equals(localObject);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     key
 * JD-Core Version:    0.7.0.1
 */