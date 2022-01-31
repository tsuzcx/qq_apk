import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.HashMap;

class xlg
  implements View.OnClickListener
{
  xlg(xlb paramxlb) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.mRuntime.a();
    if (paramView == null) {}
    seh localseh;
    do
    {
      do
      {
        do
        {
          return;
        } while ((xlb.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(xlb.a(this.a))));
        localseh = (seh)xlb.jdField_a_of_type_JavaUtilHashMap.get(xlb.a(this.a));
      } while (localseh == null);
      if (localseh.b() == 3)
      {
        localseh.a();
        this.a.b();
        localseh.a(4);
        if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        xlb.jdField_a_of_type_JavaUtilHashMap.remove(xlb.a(this.a));
        return;
      }
    } while (localseh.b() != 0);
    mzb.a(paramView.getApplicationContext(), xlb.a(this.a), localseh.f, localseh.a, localseh);
    localseh.a(1);
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xlg
 * JD-Core Version:    0.7.0.1
 */