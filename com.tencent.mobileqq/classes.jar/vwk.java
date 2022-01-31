import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class vwk
  extends CardObserver
{
  public vwk(StrangerChatPie paramStrangerChatPie) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    Object localObject = null;
    String str1;
    if ((paramBoolean) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      str1 = paramObject.uin;
      localObject = paramObject.strCampusName;
      paramObject = paramObject.tempChatSig;
    }
    for (;;)
    {
      Locale localLocale;
      String str3;
      String str4;
      if (QLog.isColorLevel())
      {
        localLocale = Locale.getDefault();
        str3 = Utils.b(str1);
        str4 = Utils.b((String)localObject);
        if (paramObject != null) {
          break label201;
        }
      }
      label201:
      for (String str2 = "sig is null";; str2 = "sig is not null")
      {
        QLog.d("StrangerChatPie", 2, String.format(localLocale, "onGetCampusInfo [%s, %s, %s]", new Object[] { str3, str4, str2 }));
        if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1029) && (Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str1)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((String)localObject);
          if (paramObject != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().l(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramObject);
          }
          this.a.a().runOnUiThread(new vwl(this));
        }
        return;
      }
      str2 = null;
      str1 = null;
      paramObject = localObject;
      localObject = str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwk
 * JD-Core Version:    0.7.0.1
 */