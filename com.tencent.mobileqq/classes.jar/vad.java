import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.widget.QfavMicroPhoneDialog.Listener;

public class vad
  implements QfavMicroPhoneDialog.Listener
{
  public vad(PttItemBuilder paramPttItemBuilder, MessageForPtt paramMessageForPtt) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QfavBuilder.a(paramString1, paramInt, paramString2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt).a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.length() > 0)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", 4, 0, 6, paramInt, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vad
 * JD-Core Version:    0.7.0.1
 */