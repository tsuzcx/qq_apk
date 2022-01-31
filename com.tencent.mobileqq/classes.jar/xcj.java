import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.HashMap;

class xcj
  implements View.OnClickListener
{
  xcj(xce paramxce) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.mRuntime.a();
    if (paramView == null) {}
    rrs localrrs;
    do
    {
      do
      {
        do
        {
          return;
        } while ((xce.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(xce.a(this.a))));
        localrrs = (rrs)xce.jdField_a_of_type_JavaUtilHashMap.get(xce.a(this.a));
      } while (localrrs == null);
      if (localrrs.b() == 3)
      {
        localrrs.a();
        this.a.b();
        localrrs.a(4);
        if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        xce.jdField_a_of_type_JavaUtilHashMap.remove(xce.a(this.a));
        return;
      }
    } while (localrrs.b() != 0);
    mof.a(paramView.getApplicationContext(), xce.a(this.a), localrrs.f, localrrs.a, localrrs);
    localrrs.a(1);
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xcj
 * JD-Core Version:    0.7.0.1
 */