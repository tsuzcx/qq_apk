import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class awlu
  extends awlz
{
  public awlu(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  private ImageView.ScaleType a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("center_crop".equals(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("fit_center".equals(paramString)) {
      return ImageView.ScaleType.FIT_CENTER;
    }
    return ImageView.ScaleType.CENTER_CROP;
  }
  
  protected void RC()
  {
    super.RC();
  }
  
  protected void setAttribute(String paramString1, String paramString2)
  {
    super.setAttribute(paramString1, paramString2);
    if (!(this.ey instanceof ImageView)) {}
    do
    {
      return;
      if ("content".equals(paramString1))
      {
        setImageSrc(paramString2);
        return;
      }
    } while (!"scale_type".equals(paramString1));
    ((ImageView)this.ey).setScaleType(a(paramString2));
  }
  
  protected void setImageSrc(String paramString)
  {
    if (!aurr.isValidUrl(paramString)) {}
    do
    {
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if ((this.JO > 0) && (this.mViewHeight > 0))
      {
        localURLDrawableOptions.mRequestWidth = this.JO;
        localURLDrawableOptions.mRequestHeight = this.mViewHeight;
      }
      localURLDrawableOptions.mPlayGifImage = false;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    } while (paramString == null);
    ((ImageView)this.ey).setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlu
 * JD-Core Version:    0.7.0.1
 */