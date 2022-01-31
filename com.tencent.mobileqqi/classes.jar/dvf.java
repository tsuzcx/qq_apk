import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.widget.GridListView;

public class dvf
  implements View.OnClickListener
{
  public dvf(VisitorsActivity paramVisitorsActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    paramView = VisitorsActivity.a(this.a);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.b();
    if (i == 0)
    {
      paramView.setText(2131562286);
      this.a.b = true;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setMode(1);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.invalidate();
      paramView = this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      if (i != 0) {
        break label128;
      }
    }
    for (;;)
    {
      paramView.putBoolean("visitor_grid", bool);
      paramView.commit();
      return;
      if (i != 1) {
        break;
      }
      paramView.setText(2131562177);
      this.a.b = false;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setMode(0);
      break;
      label128:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dvf
 * JD-Core Version:    0.7.0.1
 */