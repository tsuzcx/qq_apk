import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

class uxc
  implements URLDrawableDownListener
{
  uxc(uxa paramuxa) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    vmp.c("RichBlockDialog", "onLoadCanceled - ");
    if (uxa.a(this.a) != null) {
      uxa.a(this.a).setImageResource(2130841740);
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (uxa.a(this.a) != null) {
      uxa.a(this.a).setImageResource(2130841740);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    uxa.a(this.a);
    vbt.b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxc
 * JD-Core Version:    0.7.0.1
 */