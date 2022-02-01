import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class ajof
  implements URLDrawable.URLDrawableListener
{
  ajof(Resources paramResources, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      int i = wja.dp2px(21.0F, this.g);
      int j = paramURLDrawable.getIntrinsicWidth() * i / paramURLDrawable.getIntrinsicHeight();
      ViewGroup.LayoutParams localLayoutParams = this.val$imageView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = j;
      this.val$imageView.setImageDrawable(null);
      this.val$imageView.setImageDrawable(paramURLDrawable);
      this.val$imageView.setLayoutParams(localLayoutParams);
      this.val$imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajof
 * JD-Core Version:    0.7.0.1
 */