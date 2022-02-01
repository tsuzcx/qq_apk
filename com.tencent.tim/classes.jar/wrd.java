import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;

public class wrd
  implements URLDrawableDownListener
{
  public wrd(DoodleMsgLayout paramDoodleMsgLayout) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == DoodleMsgLayout.a(this.this$0))
    {
      DoodleMsgLayout.a(this.this$0, true);
      DoodleMsgLayout.a(this.this$0);
    }
    do
    {
      return;
      if (paramView == DoodleMsgLayout.b(this.this$0))
      {
        ((GifDrawable)paramURLDrawable.getCurrDrawable()).setGIFPlayOnceListener(this.this$0);
        return;
      }
    } while (paramView != DoodleMsgLayout.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrd
 * JD-Core Version:    0.7.0.1
 */