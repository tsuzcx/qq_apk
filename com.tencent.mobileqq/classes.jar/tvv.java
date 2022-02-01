import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tvv
  implements View.OnClickListener
{
  tvv(tvt paramtvt, tvs paramtvs) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.jdField_a_of_type_Tvt.jdField_a_of_type_Tvs.a, "P_CliOper", "Pb_account_lifeservice", "", "0X8005731", "0X8005731", 0, 0, "", "", "", "");
    bdll.b(this.jdField_a_of_type_Tvt.jdField_a_of_type_Tvs.a, "CliOper", "", "", "0X800642E", "0X800642E", 0, 0, String.valueOf(this.jdField_a_of_type_Tvt.jdField_a_of_type_Tvr.a), "", "", "");
    if ((this.jdField_a_of_type_Tvt.jdField_a_of_type_Tvr == null) || (TextUtils.isEmpty(String.valueOf(this.jdField_a_of_type_Tvt.jdField_a_of_type_Tvr.a)))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      tvt.a(this.jdField_a_of_type_Tvt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvv
 * JD-Core Version:    0.7.0.1
 */