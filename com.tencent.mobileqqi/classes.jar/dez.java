import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class dez
  implements ActionSheet.OnButtonClickListener
{
  dez(dey paramdey, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt == 0) {
      if (1 == PermisionPrivacyActivity.a(this.jdField_a_of_type_Dey.a).b()) {
        PermisionPrivacyActivity.a(this.jdField_a_of_type_Dey.a);
      }
    }
    while (paramInt != 1)
    {
      return;
      if (2 == PermisionPrivacyActivity.b(this.jdField_a_of_type_Dey.a).b())
      {
        PermisionPrivacyActivity.b(this.jdField_a_of_type_Dey.a);
        return;
      }
      if (!NetworkUtil.e(this.jdField_a_of_type_Dey.a))
      {
        QQToast.a(paramView.getContext(), 0, this.jdField_a_of_type_Dey.a.getResources().getString(2131562488), 0).b(this.jdField_a_of_type_Dey.a.d());
        return;
      }
      this.jdField_a_of_type_Dey.a.setResult(2);
      this.jdField_a_of_type_Dey.a.finish();
      return;
    }
    paramView = DialogUtil.c(paramView.getContext(), 230, null, null, 2131561746, 2131562545, null, null);
    paramView.setMessage(2131561621);
    dfa localdfa = new dfa(this);
    dfc localdfc = new dfc(this);
    paramView.setPositiveButton(2131562545, localdfa);
    paramView.setNegativeButton(2131561746, localdfc);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dez
 * JD-Core Version:    0.7.0.1
 */