import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

class ucp
  implements URLDrawableDownListener
{
  ucp(ucn paramucn) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    uqf.c("RichBlockDialog", "onLoadCanceled - ");
    if (ucn.a(this.a) != null) {
      ucn.a(this.a).setImageResource(2130841690);
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (ucn.a(this.a) != null) {
      ucn.a(this.a).setImageResource(2130841690);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    ucn.a(this.a);
    uhc.b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucp
 * JD-Core Version:    0.7.0.1
 */