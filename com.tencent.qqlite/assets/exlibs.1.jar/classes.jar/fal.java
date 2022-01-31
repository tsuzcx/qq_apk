import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.widget.DropdownView;

public class fal
  implements View.OnClickListener
{
  public fal(DropdownView paramDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Fao.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Fao.getWindowToken(), 0);
    if ((this.a.jdField_a_of_type_Fao.getAdapter() != null) && (this.a.jdField_a_of_type_Fao.getAdapter().getCount() > 0))
    {
      if ((((ImageView)paramView).getDrawable() == this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) && (!this.a.jdField_a_of_type_Boolean)) {
        DropdownView.a(this.a).postDelayed(new fam(this, paramView), 250L);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_Fao.dismissDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fal
 * JD-Core Version:    0.7.0.1
 */