import android.graphics.Paint;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.util.DisplayUtil;

public class tok
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public tok(QQMapActivity paramQQMapActivity) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.jdField_c_of_type_AndroidWidgetLinearLayout.getWidth();
    if (i > 0)
    {
      int j = DisplayUtil.a(this.a, 10.0F);
      Object localObject = new Paint();
      ((Paint)localObject).setTextSize(DisplayUtil.a(this.a, 14.0F));
      ((Paint)localObject).setAntiAlias(true);
      int k = (int)(((Paint)localObject).measureText(this.a.e.getText().toString()) + 1.0F);
      ((Paint)localObject).setTextSize(DisplayUtil.a(this.a, 20.0F));
      if ((int)(((Paint)localObject).measureText(this.a.jdField_c_of_type_AndroidWidgetTextView.getText().toString()) + 1.0F) + (k + j) > i)
      {
        localObject = this.a.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = (i - j - k);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.a.jdField_c_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tok
 * JD-Core Version:    0.7.0.1
 */