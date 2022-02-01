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

class czh
  implements ActionSheet.OnButtonClickListener
{
  czh(czg paramczg, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt == 0) {
      if (1 == PermisionPrivacyActivity.a(this.jdField_a_of_type_Czg.a).b()) {
        PermisionPrivacyActivity.a(this.jdField_a_of_type_Czg.a);
      }
    }
    while (paramInt != 1)
    {
      return;
      if (2 == PermisionPrivacyActivity.b(this.jdField_a_of_type_Czg.a).b())
      {
        PermisionPrivacyActivity.b(this.jdField_a_of_type_Czg.a);
        return;
      }
      if (!NetworkUtil.e(this.jdField_a_of_type_Czg.a))
      {
        QQToast.a(paramView.getContext(), 0, this.jdField_a_of_type_Czg.a.getResources().getString(2131562488), 0).b(this.jdField_a_of_type_Czg.a.d());
        return;
      }
      this.jdField_a_of_type_Czg.a.setResult(2);
      this.jdField_a_of_type_Czg.a.finish();
      return;
    }
    paramView = DialogUtil.c(paramView.getContext(), 230, null, null, 2131561746, 2131562545, null, null);
    paramView.setMessage(2131561621);
    czi localczi = new czi(this);
    czk localczk = new czk(this);
    paramView.setPositiveButton(2131562545, localczi);
    paramView.setNegativeButton(2131561746, localczk);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czh
 * JD-Core Version:    0.7.0.1
 */