import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.widget.DropdownView;

public class eyf
  implements View.OnClickListener
{
  public eyf(DropdownView paramDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Eyi.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Eyi.getWindowToken(), 0);
    if ((this.a.jdField_a_of_type_Eyi.getAdapter() != null) && (this.a.jdField_a_of_type_Eyi.getAdapter().getCount() > 0))
    {
      if ((((ImageView)paramView).getDrawable() == this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) && (!this.a.jdField_a_of_type_Boolean)) {
        DropdownView.a(this.a).postDelayed(new eyg(this, paramView), 250L);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_Eyi.dismissDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eyf
 * JD-Core Version:    0.7.0.1
 */