import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.widget.DropdownView;

public class hgm
  implements View.OnClickListener
{
  public hgm(DropdownView paramDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Hgp.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Hgp.getWindowToken(), 0);
    if ((this.a.jdField_a_of_type_Hgp.getAdapter() != null) && (this.a.jdField_a_of_type_Hgp.getAdapter().getCount() > 0))
    {
      if ((((ImageView)paramView).getDrawable() == this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) && (!this.a.jdField_a_of_type_Boolean)) {
        DropdownView.a(this.a).postDelayed(new hgn(this, paramView), 250L);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_Hgp.dismissDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgm
 * JD-Core Version:    0.7.0.1
 */