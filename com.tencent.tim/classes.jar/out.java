import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import java.util.ArrayList;
import java.util.List;

final class out
  implements URLDrawableDownListener
{
  out(URLDrawableDownListener paramURLDrawableDownListener, long paramLong, String paramString) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (this.c != null) {
      this.c.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    }
    if (this.zj > 0L)
    {
      double d = (float)(System.currentTimeMillis() - this.zj) / 1000.0F;
      paramView = new ArrayList();
      paramView.add(pcr.a("time_cost", String.valueOf(d)));
      paramView.add(pcr.a("ret_code", "-1"));
      paramView.add(pcr.a("url", this.arC));
      pcq.c("image_load_ret", paramView, true);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (this.c != null) {
      this.c.onLoadSuccessed(paramView, paramURLDrawable);
    }
    if (this.zj > 0L)
    {
      double d = (float)(System.currentTimeMillis() - this.zj) / 1000.0F;
      paramView = new ArrayList();
      paramView.add(pcr.a("time_cost", String.valueOf(d)));
      paramView.add(pcr.a("ret_code", "0"));
      paramView.add(pcr.a("url", this.arC));
      pcq.c("image_load_ret", paramView, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     out
 * JD-Core Version:    0.7.0.1
 */