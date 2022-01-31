import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.observer.AccountObserver;

public class ctr
  extends AccountObserver
{
  public ctr(MessageHandler paramMessageHandler, String paramString) {}
  
  public void onChangeToken(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap = (RespondCustomSig)paramHashMap.get("login.chgTok");
      if ((paramHashMap != null) && (paramHashMap.SigList != null)) {
        break label30;
      }
    }
    for (;;)
    {
      return;
      label30:
      int i = 0;
      while (i < paramHashMap.SigList.size())
      {
        Object localObject = (CustomSigContent)paramHashMap.SigList.get(i);
        if ((((CustomSigContent)localObject).sResult == 0) && (((CustomSigContent)localObject).ulSigType == 16L))
        {
          localObject = new String(((CustomSigContent)localObject).SigContent);
          OpenID localOpenID = new OpenID();
          localOpenID.appID = this.jdField_a_of_type_JavaLangString;
          localOpenID.openID = ((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().b(localOpenID);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.a(this.jdField_a_of_type_JavaLangString, localOpenID);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(1, true, localOpenID);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ctr
 * JD-Core Version:    0.7.0.1
 */