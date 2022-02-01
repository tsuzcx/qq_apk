import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

class apwg
  implements View.OnClickListener
{
  apwg(apwe paramapwe, apwe.b paramb) {}
  
  public void onClick(View paramView)
  {
    if ((apwe.a(this.jdField_a_of_type_Apwe) != null) && (apwe.a(this.jdField_a_of_type_Apwe).isShowing())) {
      apwe.a(this.jdField_a_of_type_Apwe).dismiss();
    }
    if ((this.jdField_a_of_type_Apwe$b != null) && (apwe.a(this.jdField_a_of_type_Apwe) != null)) {
      this.jdField_a_of_type_Apwe$b.kc(apwe.a(this.jdField_a_of_type_Apwe).getTimeInMillis());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwg
 * JD-Core Version:    0.7.0.1
 */