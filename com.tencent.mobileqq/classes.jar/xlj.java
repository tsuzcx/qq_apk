import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.HashMap;

class xlj
  implements View.OnClickListener
{
  xlj(xle paramxle) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.mRuntime.a();
    if (paramView == null) {}
    sek localsek;
    do
    {
      do
      {
        do
        {
          return;
        } while ((xle.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(xle.a(this.a))));
        localsek = (sek)xle.jdField_a_of_type_JavaUtilHashMap.get(xle.a(this.a));
      } while (localsek == null);
      if (localsek.b() == 3)
      {
        localsek.a();
        this.a.b();
        localsek.a(4);
        if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        xle.jdField_a_of_type_JavaUtilHashMap.remove(xle.a(this.a));
        return;
      }
    } while (localsek.b() != 0);
    mze.a(paramView.getApplicationContext(), xle.a(this.a), localsek.f, localsek.a, localsek);
    localsek.a(1);
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xlj
 * JD-Core Version:    0.7.0.1
 */