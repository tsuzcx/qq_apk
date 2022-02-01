import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nzz
  implements View.OnClickListener
{
  nzz(nzx.a parama, nzx paramnzx) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.a.jdField_a_of_type_Nzx.mApp, "P_CliOper", "Pb_account_lifeservice", "", "0X8005731", "0X8005731", 0, 0, "", "", "", "");
    anot.a(this.a.jdField_a_of_type_Nzx.mApp, "CliOper", "", "", "0X800642E", "0X800642E", 0, 0, String.valueOf(this.a.jdField_a_of_type_Nzw.uin), "", "", "");
    if ((this.a.jdField_a_of_type_Nzw == null) || (TextUtils.isEmpty(String.valueOf(this.a.jdField_a_of_type_Nzw.uin)))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      nzx.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzz
 * JD-Core Version:    0.7.0.1
 */