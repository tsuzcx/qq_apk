import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class opq
  implements URLDrawable.URLDrawableListener
{
  opq(String paramString1, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ooz.i("815", "onLoadCanceled - " + this.val$tag);
    this.lu.setImageResource(2130842541);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ooz.i("815", "onLoadFialed - " + this.val$tag);
    this.lu.setImageResource(2130842541);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    ooz.i("815", "onLoadProgressed - " + this.val$tag);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ooz.i("815", "onLoadSuccessed - " + this.val$tag);
    this.lu.setImageDrawable(paramURLDrawable);
    if (TextUtils.equals(this.val$tag, "banner")) {
      oiu.m(2, this.val$url);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opq
 * JD-Core Version:    0.7.0.1
 */