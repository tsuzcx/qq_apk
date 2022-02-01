import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class smg
  implements URLDrawableDownListener
{
  smg(slz paramslz) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    this.this$0.I(false, "onLoadCancelled");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.this$0.I(false, "onLoadFailed");
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    this.this$0.I(false, "onLoadInterrupted");
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.this$0.I(true, "onLoadSuccessed");
    this.this$0.aLX = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smg
 * JD-Core Version:    0.7.0.1
 */