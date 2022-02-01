import android.graphics.Paint;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQMapActivity;

public class von
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public von(QQMapActivity paramQQMapActivity) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.gn.getWidth();
    if (i > 0)
    {
      int j = aqcx.dip2px(this.a, 10.0F);
      Object localObject = new Paint();
      ((Paint)localObject).setTextSize(aqcx.dip2px(this.a, 14.0F));
      ((Paint)localObject).setAntiAlias(true);
      int k = (int)(((Paint)localObject).measureText(this.a.EZ.getText().toString()) + 1.0F);
      ((Paint)localObject).setTextSize(aqcx.dip2px(this.a, 20.0F));
      if ((int)(((Paint)localObject).measureText(this.a.EX.getText().toString()) + 1.0F) + (k + j) > i)
      {
        localObject = this.a.EX.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = (i - j - k);
        this.a.EX.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.a.gn.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     von
 * JD-Core Version:    0.7.0.1
 */