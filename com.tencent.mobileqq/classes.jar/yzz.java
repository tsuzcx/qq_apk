import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.HashMap;

class yzz
  implements View.OnClickListener
{
  yzz(yzu paramyzu) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.mRuntime.a();
    if (paramView == null) {}
    swb localswb;
    do
    {
      do
      {
        do
        {
          return;
        } while ((yzu.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(yzu.a(this.a))));
        localswb = (swb)yzu.jdField_a_of_type_JavaUtilHashMap.get(yzu.a(this.a));
      } while (localswb == null);
      if (localswb.b() == 3)
      {
        localswb.a();
        this.a.b();
        localswb.a(4);
        if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        yzu.jdField_a_of_type_JavaUtilHashMap.remove(yzu.a(this.a));
        return;
      }
    } while (localswb.b() != 0);
    nbv.a(paramView.getApplicationContext(), yzu.a(this.a), localswb.f, localswb.a, localswb);
    localswb.a(1);
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzz
 * JD-Core Version:    0.7.0.1
 */