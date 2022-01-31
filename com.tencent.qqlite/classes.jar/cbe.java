import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;

public class cbe
  implements View.OnClickListener
{
  public cbe(SearchResultDialog paramSearchResultDialog) {}
  
  public void onClick(View paramView)
  {
    SearchResultDialog.a(this.a).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cbe
 * JD-Core Version:    0.7.0.1
 */