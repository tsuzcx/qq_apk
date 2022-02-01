import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.vip.diy.common.DIYImageView;

public class aqvu
  extends awlz
{
  private ImageView Fn;
  private String bWn;
  
  public aqvu(String paramString1, View paramView, @NonNull String paramString2)
  {
    super(paramString1, paramView);
    if ((paramView != null) && ((paramView instanceof DIYImageView))) {
      this.Fn = ((DIYImageView)paramView).A();
    }
    this.bWn = paramString2;
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
  
  public void RB()
  {
    super.RB();
    if ((this.ey == null) || (this.Fn == null)) {}
    ViewGroup.LayoutParams localLayoutParams1;
    ViewGroup.LayoutParams localLayoutParams2;
    do
    {
      return;
      if ((this.ey.getParent() != null) && ((this.ey.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.ey.getParent()).setClipChildren(false);
      }
      localLayoutParams1 = this.ey.getLayoutParams();
      localLayoutParams2 = this.Fn.getLayoutParams();
    } while ((localLayoutParams1 == null) || (localLayoutParams2 == null));
    localLayoutParams2.width = localLayoutParams1.width;
    localLayoutParams2.height = localLayoutParams1.height;
    this.Fn.setLayoutParams(localLayoutParams2);
  }
  
  protected void RC()
  {
    super.RC();
  }
  
  protected void setAttribute(String paramString1, String paramString2)
  {
    super.setAttribute(paramString1, paramString2);
    if (!(this.ey instanceof DIYImageView)) {
      rom.fail("JsonInflateViewModel current view type illegal!", new Object[0]);
    }
    do
    {
      return;
      if ("content".equals(paramString1))
      {
        setImageSrc(paramString2);
        return;
      }
    } while (!"scale_type".equals(paramString1));
    this.Fn.setScaleType(a(paramString2));
  }
  
  protected void setImageSrc(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http")) {
      str = this.bWn + paramString;
    }
    if (!aurr.isValidUrl(str)) {}
    do
    {
      return;
      paramString = URLDrawable.URLDrawableOptions.obtain();
      if ((this.JO > 0) && (this.mViewHeight > 0))
      {
        paramString.mRequestWidth = this.JO;
        paramString.mRequestHeight = this.mViewHeight;
      }
      paramString.mLoadingDrawable = aoop.TRANSPARENT;
      paramString.mFailedDrawable = aoop.TRANSPARENT;
      paramString.mPlayGifImage = false;
      paramString = URLDrawable.getDrawable(str, paramString);
    } while (paramString == null);
    this.Fn.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvu
 * JD-Core Version:    0.7.0.1
 */