import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class uss
  extends acmf
{
  public uss(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, anxs paramanxs)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (paramanxs == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (paramanxs != null)) {
        break label113;
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder().append("Conversation.onGetBindSubAccount() return:");
        if (!paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramanxs = "data=null";; paramanxs = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, paramanxs);
      return;
      localObject1 = paramanxs.aQf;
      break;
    }
    label113:
    if (paramanxs.errorType == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      anxk.J(this.this$0.app, 0);
    }
    if (paramanxs.azk())
    {
      anxk.a(this.this$0.app, paramanxs.dM(), 2);
      this.this$0.app.bIR = true;
    }
    if (paramanxs.azl())
    {
      localObject1 = paramanxs.dN();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          anxk.aL(this.this$0.app, (String)localObject2);
        }
      }
    }
    paramanxs.dTL();
    this.this$0.fI(0L);
    Conversation.j(this.this$0);
  }
  
  protected void b(boolean paramBoolean, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramanxs != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + paramanxs.aLa + " subAccount=" + paramanxs.aQf + " errType=" + paramanxs.errorType + " errMsg=" + paramanxs.errorMsg);
      }
    }
    if ((paramBoolean) && (paramanxs != null) && (paramanxs.azm())) {
      anxk.a(this.this$0.app, paramanxs.dO(), 1);
    }
    this.this$0.fI(0L);
  }
  
  protected void c(boolean paramBoolean, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (paramanxs != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + paramanxs.aLa + " subAccount=" + paramanxs.aQf + " errType=" + paramanxs.errorType + " errMsg=" + paramanxs.errorMsg);
      }
    }
    if (paramanxs == null) {}
    while ((!paramBoolean) || (paramanxs.aQf == null) || (paramanxs.aQf.length() <= 4)) {
      return;
    }
    this.this$0.app.b().ca(paramanxs.aQf, 7000);
    anxk.aL(this.this$0.app, paramanxs.aQf);
    this.this$0.fI(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uss
 * JD-Core Version:    0.7.0.1
 */