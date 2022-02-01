import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.widget.DropdownView;

public class hgl
  implements View.OnClickListener
{
  public hgl(DropdownView paramDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Hgo.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Hgo.getWindowToken(), 0);
    if ((this.a.jdField_a_of_type_Hgo.getAdapter() != null) && (this.a.jdField_a_of_type_Hgo.getAdapter().getCount() > 0))
    {
      if ((((ImageView)paramView).getDrawable() == this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) && (!this.a.jdField_a_of_type_Boolean)) {
        DropdownView.a(this.a).postDelayed(new hgm(this, paramView), 250L);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_Hgo.dismissDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgl
 * JD-Core Version:    0.7.0.1
 */