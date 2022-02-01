import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class aqnq
  implements URLDrawable.URLDrawableListener
{
  public aqnq(Resources paramResources, String paramString, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    int i;
    if (paramURLDrawable != null)
    {
      i = wja.dp2px(15.0F, this.g);
      j = paramURLDrawable.getIntrinsicHeight();
      if (j == 0)
      {
        boolean bool = new File(aqqx.lE(this.val$iconUrl)).delete();
        QLog.e("VipUtils", 1, "onLoadSuccessed drawableHeight=0, deleteSucc=" + bool + " url=" + this.val$iconUrl);
        this.val$imageView.setImageDrawable(this.de);
      }
    }
    else
    {
      return;
    }
    int j = paramURLDrawable.getIntrinsicWidth() * i / j;
    ViewGroup.LayoutParams localLayoutParams = this.val$imageView.getLayoutParams();
    localLayoutParams.height = i;
    localLayoutParams.width = j;
    this.val$imageView.setImageDrawable(null);
    this.val$imageView.setImageDrawable(paramURLDrawable);
    this.val$imageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnq
 * JD-Core Version:    0.7.0.1
 */