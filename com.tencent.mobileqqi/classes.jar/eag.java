import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.widget.QfavMicroPhoneDialog.Listener;

public class eag
  implements QfavMicroPhoneDialog.Listener
{
  public eag(PttItemBuilder paramPttItemBuilder, MessageForPtt paramMessageForPtt) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QfavBuilder.a(paramString1, paramInt, paramString2).b(PttItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt).a((Activity)PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder), PttItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder).getAccount());
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.length() > 0)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      QfavReport.a(PttItemBuilder.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder), "User_AddFav", 4, 0, 6, paramInt, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eag
 * JD-Core Version:    0.7.0.1
 */