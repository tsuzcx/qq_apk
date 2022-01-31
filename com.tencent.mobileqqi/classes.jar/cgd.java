import android.view.View;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cgd
  implements ActionSheet.OnButtonClickListener
{
  public cgd(DetailProfileActivity paramDetailProfileActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.b.a(2));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.a(2131561424, 1);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte != 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte = 1;
          this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgd
 * JD-Core Version:    0.7.0.1
 */