import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

class ujf
  implements URLDrawableDownListener
{
  ujf(ujd paramujd) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    uya.c("RichBlockDialog", "onLoadCanceled - ");
    if (ujd.a(this.a) != null) {
      ujd.a(this.a).setImageResource(2130841730);
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (ujd.a(this.a) != null) {
      ujd.a(this.a).setImageResource(2130841730);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    ujd.a(this.a);
    unt.b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujf
 * JD-Core Version:    0.7.0.1
 */