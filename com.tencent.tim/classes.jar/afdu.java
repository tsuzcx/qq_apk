import android.view.View;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.doutu.DoutuData;
import java.util.HashMap;

class afdu
  implements URLDrawableDownListener
{
  afdu(afdt paramafdt) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof afdt.a)))
    {
      paramView = (afdt.a)paramView;
      if (paramView.progressBar != null) {
        paramView.progressBar.setVisibility(4);
      }
      if (this.a.kg == null) {
        this.a.kg = new HashMap();
      }
      if ((paramView.c != null) && (paramView.c.pic_md5 != null) && (paramView.c.pic_down_url != null)) {
        this.a.kg.put(paramView.c.pic_md5, paramView.c.pic_down_url);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdu
 * JD-Core Version:    0.7.0.1
 */