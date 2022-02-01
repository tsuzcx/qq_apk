import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity;

public class cqt
  implements URLDrawableDownListener
{
  public cqt(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    float f = paramURLDrawable.getIntrinsicHeight() / paramURLDrawable.getIntrinsicWidth();
    paramURLDrawable = new DisplayMetrics();
    this.a.getWindowManager().getDefaultDisplay().getMetrics(paramURLDrawable);
    paramView.height = ((int)(f * paramURLDrawable.widthPixels + 0.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqt
 * JD-Core Version:    0.7.0.1
 */