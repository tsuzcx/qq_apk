import android.view.View;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class udi
  implements URLDrawableDownListener
{
  udi(udh paramudh) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    udh.a(this.a);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    udh.a(this.a);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    udh.a(this.a);
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udi
 * JD-Core Version:    0.7.0.1
 */