import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;

public class dbm
  implements View.OnClickListener
{
  public dbm(IphonePickerView paramIphonePickerView) {}
  
  public void onClick(View paramView)
  {
    if (IphonePickerView.a(this.a) != null) {
      IphonePickerView.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbm
 * JD-Core Version:    0.7.0.1
 */