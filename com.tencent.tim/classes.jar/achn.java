import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.observer.AccountObserver;

public class achn
  extends AccountObserver
{
  public achn(MessageHandler paramMessageHandler, String paramString) {}
  
  public void onChangeToken(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap = (RespondCustomSig)paramHashMap.get("login.chgTok");
      if ((paramHashMap == null) || (paramHashMap.SigList == null)) {
        return;
      }
      int i = 0;
      while (i < paramHashMap.SigList.size())
      {
        Object localObject = (CustomSigContent)paramHashMap.SigList.get(i);
        if ((((CustomSigContent)localObject).sResult == 0) && (((CustomSigContent)localObject).ulSigType == 16L))
        {
          localObject = new String(((CustomSigContent)localObject).SigContent);
          OpenID localOpenID = new OpenID();
          localOpenID.appID = this.val$appID;
          localOpenID.openID = ((String)localObject);
          this.this$0.b().persistOrReplace(localOpenID);
          this.this$0.a.a(this.val$appID, localOpenID);
          this.this$0.notifyUI(1, true, localOpenID);
        }
        i += 1;
      }
    }
    if (paramBoolean) {}
    for (paramHashMap = "0";; paramHashMap = "1")
    {
      arts.a().a(this.this$0.app.getAccount(), "", this.val$appID, "41", "19", paramHashMap, "", "", "4", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     achn
 * JD-Core Version:    0.7.0.1
 */