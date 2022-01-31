import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class dmy
  implements View.OnClickListener
{
  public dmy(SubLoginActivity paramSubLoginActivity) {}
  
  public void onClick(View paramView)
  {
    if ((SubLoginActivity.a(this.a) != null) && (SubLoginActivity.a(this.a).isShown())) {
      SubLoginActivity.a(this.a).setVisibility(8);
    }
    SubLoginActivity.a(this.a).setText("");
    SubLoginActivity.a(this.a).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmy
 * JD-Core Version:    0.7.0.1
 */