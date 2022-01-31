import android.text.Editable;
import android.text.SpannableString;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class vsm
  implements Runnable
{
  public vsm(DiscussChatPie paramDiscussChatPie, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().delete(j - 1, j);
    }
    SpannableString localSpannableString = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx, false);
    if ((localSpannableString == null) || (localSpannableString.length() == 0)) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    if (j < 0) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(i, localSpannableString);
      DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).a(1);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsm
 * JD-Core Version:    0.7.0.1
 */