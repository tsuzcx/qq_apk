import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;

public class fme
  implements View.OnClickListener
{
  public fme(IphonePickerView paramIphonePickerView) {}
  
  public void onClick(View paramView)
  {
    if (IphonePickerView.a(this.a) != null) {
      IphonePickerView.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fme
 * JD-Core Version:    0.7.0.1
 */