import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

class ucn
  implements URLDrawableDownListener
{
  ucn(ucl paramucl) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    upe.c("RichBlockDialog", "onLoadCanceled - ");
    if (ucl.a(this.a) != null) {
      ucl.a(this.a).setImageResource(2130841680);
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (ucl.a(this.a) != null) {
      ucl.a(this.a).setImageResource(2130841680);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    ucl.a(this.a);
    uha.b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucn
 * JD-Core Version:    0.7.0.1
 */