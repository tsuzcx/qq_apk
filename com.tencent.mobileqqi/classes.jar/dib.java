import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity.TroopAdmin;
import com.tencent.widget.ActionSheet;

class dib
  implements View.OnClickListener
{
  dib(dia paramdia, SetTroopAdminsActivity.TroopAdmin paramTroopAdmin) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.a(this.jdField_a_of_type_Dia.a);
    paramView.a(String.format(this.jdField_a_of_type_Dia.a.getString(2131561531), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivitySetTroopAdminsActivity$TroopAdmin.b }));
    paramView.a(2131561758, 3);
    paramView.d(2131561746);
    paramView.a(new dic(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dib
 * JD-Core Version:    0.7.0.1
 */