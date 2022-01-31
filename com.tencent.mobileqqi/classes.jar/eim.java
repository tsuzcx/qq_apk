import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;

public class eim
  implements View.OnClickListener
{
  public eim(SearchResultDialog paramSearchResultDialog) {}
  
  public void onClick(View paramView)
  {
    SearchResultDialog.a(this.a).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eim
 * JD-Core Version:    0.7.0.1
 */