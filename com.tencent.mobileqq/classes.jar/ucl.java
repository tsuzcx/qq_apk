import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ucl
  implements View.OnClickListener
{
  ucl(ucj paramucj, uci paramuci) {}
  
  public void onClick(View paramView)
  {
    bcef.b(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.a, "P_CliOper", "Pb_account_lifeservice", "", "0X8005731", "0X8005731", 0, 0, "", "", "", "");
    bcef.b(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.a, "CliOper", "", "", "0X800642E", "0X800642E", 0, 0, String.valueOf(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uch.a), "", "", "");
    if ((this.jdField_a_of_type_Ucj.jdField_a_of_type_Uch == null) || (TextUtils.isEmpty(String.valueOf(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uch.a)))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ucj.a(this.jdField_a_of_type_Ucj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucl
 * JD-Core Version:    0.7.0.1
 */