import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity.TroopAdmin;
import com.tencent.widget.ActionSheet;

class dic
  implements View.OnClickListener
{
  dic(dib paramdib, SetTroopAdminsActivity.TroopAdmin paramTroopAdmin) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.a(this.jdField_a_of_type_Dib.a);
    paramView.a(String.format(this.jdField_a_of_type_Dib.a.getString(2131561531), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivitySetTroopAdminsActivity$TroopAdmin.b }));
    paramView.a(2131561758, 3);
    paramView.d(2131561746);
    paramView.a(new did(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dic
 * JD-Core Version:    0.7.0.1
 */