import android.text.Editable;
import android.text.SpannableString;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.widget.XPanelContainer;

public class cah
  implements Runnable
{
  public cah(DiscussChatPie paramDiscussChatPie, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      j = DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).getSelectionStart();
      DiscussChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).getEditableText().delete(j - 1, j);
    }
    SpannableString localSpannableString = AtTroopMemberSpan.a(DiscussChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie), DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, DiscussChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie), false);
    if ((localSpannableString == null) || (localSpannableString.length() == 0)) {
      return;
    }
    int j = DiscussChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).getSelectionStart();
    if (j < 0) {}
    for (;;)
    {
      DiscussChatPie.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).getEditableText().insert(i, localSpannableString);
      DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).a(1);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cah
 * JD-Core Version:    0.7.0.1
 */