import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uqi
  implements View.OnClickListener
{
  uqi(uqg paramuqg, uqf paramuqf) {}
  
  public void onClick(View paramView)
  {
    bdla.b(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.a, "P_CliOper", "Pb_account_lifeservice", "", "0X8005731", "0X8005731", 0, 0, "", "", "", "");
    bdla.b(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.a, "CliOper", "", "", "0X800642E", "0X800642E", 0, 0, String.valueOf(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqe.a), "", "", "");
    if ((this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqe == null) || (TextUtils.isEmpty(String.valueOf(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqe.a)))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      uqg.a(this.jdField_a_of_type_Uqg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqi
 * JD-Core Version:    0.7.0.1
 */