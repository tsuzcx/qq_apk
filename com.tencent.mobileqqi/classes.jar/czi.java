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

class czi
  implements ActionSheet.OnButtonClickListener
{
  czi(czh paramczh, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt == 0) {
      if (1 == PermisionPrivacyActivity.a(this.jdField_a_of_type_Czh.a).b()) {
        PermisionPrivacyActivity.a(this.jdField_a_of_type_Czh.a);
      }
    }
    while (paramInt != 1)
    {
      return;
      if (2 == PermisionPrivacyActivity.b(this.jdField_a_of_type_Czh.a).b())
      {
        PermisionPrivacyActivity.b(this.jdField_a_of_type_Czh.a);
        return;
      }
      if (!NetworkUtil.e(this.jdField_a_of_type_Czh.a))
      {
        QQToast.a(paramView.getContext(), 0, this.jdField_a_of_type_Czh.a.getResources().getString(2131562488), 0).b(this.jdField_a_of_type_Czh.a.d());
        return;
      }
      this.jdField_a_of_type_Czh.a.setResult(2);
      this.jdField_a_of_type_Czh.a.finish();
      return;
    }
    paramView = DialogUtil.c(paramView.getContext(), 230, null, null, 2131561746, 2131562545, null, null);
    paramView.setMessage(2131561621);
    czj localczj = new czj(this);
    czl localczl = new czl(this);
    paramView.setPositiveButton(2131562545, localczj);
    paramView.setNegativeButton(2131561746, localczl);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czi
 * JD-Core Version:    0.7.0.1
 */