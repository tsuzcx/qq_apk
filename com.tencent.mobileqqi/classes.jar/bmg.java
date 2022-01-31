import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class bmg
  implements ActionSheet.OnButtonClickListener
{
  public bmg(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.a, this.a.d());
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562645);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      DiscussionInfoCardActivity.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a, 2, this.a.jdField_j_of_type_JavaLangString, this.a.h, this.a.f, this.a.jdField_j_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      continue;
      DiscussionInfoCardActivity.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a, this.a.i, this.a.h, this.a.f);
      continue;
      DiscussionInfoCardActivity.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_b_of_type_Long, this.a.i, this.a.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmg
 * JD-Core Version:    0.7.0.1
 */