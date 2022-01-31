import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AccountManageActivity;

class bxy
  implements Runnable
{
  bxy(bxx parambxx) {}
  
  public void run()
  {
    int i = 0;
    if (!this.a.a.c) {
      this.a.a.a(false);
    }
    this.a.a.jdField_a_of_type_AndroidViewView = null;
    int j = this.a.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    while (i < j)
    {
      View localView = this.a.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (localView.getTag() != null) {
        localView.setTag(Integer.valueOf(i));
      }
      i += 1;
    }
    this.a.a.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bxy
 * JD-Core Version:    0.7.0.1
 */