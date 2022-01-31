import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;

public class cdg
  implements View.OnClickListener
{
  public cdg(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cdg
 * JD-Core Version:    0.7.0.1
 */