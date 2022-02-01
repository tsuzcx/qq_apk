import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tvt
  implements View.OnClickListener
{
  tvt(tvr paramtvr, tvq paramtvq) {}
  
  public void onClick(View paramView)
  {
    bcst.b(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.a, "P_CliOper", "Pb_account_lifeservice", "", "0X8005731", "0X8005731", 0, 0, "", "", "", "");
    bcst.b(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.a, "CliOper", "", "", "0X800642E", "0X800642E", 0, 0, String.valueOf(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvp.a), "", "", "");
    if ((this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvp == null) || (TextUtils.isEmpty(String.valueOf(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvp.a)))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      tvr.a(this.jdField_a_of_type_Tvr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvt
 * JD-Core Version:    0.7.0.1
 */