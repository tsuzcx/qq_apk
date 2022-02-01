import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class acqv
  extends tnu
{
  public acqv(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, tom paramtom)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramtom);
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (tog.a(paramConversationInfo) > 0) {
      return 0;
    }
    return super.a(paramInt, paramConversationInfo);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, tnt.a parama)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap2 = parama.gH;
    Map localMap1 = parama.gK;
    Object localObject = parama.a;
    String str1 = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = anaz.gQ();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    localObject = ((acxw)localObject).a(str1, 1);
    if (localMap2.containsKey(top.u(((RecentUser)localObject).uin, ((RecentUser)localObject).getType()))) {
      localObject = (RecentUser)localMap2.get(top.u(((RecentUser)localObject).uin, ((RecentUser)localObject).getType()));
    }
    for (;;)
    {
      int i;
      String str2;
      if (!top.fz(paramMessageRecord.msgtype))
      {
        i = 1;
        int j = i;
        if (paramMessageRecord.isLongMsg())
        {
          j = i;
          if (this.app.a().aQ(paramMessageRecord))
          {
            i = 0;
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
              j = i;
            }
          }
        }
        if (j != 0)
        {
          str2 = top.u(str1, 1);
          ((RecentUser)localObject).uin = str1;
          ((RecentUser)localObject).setType(1);
          boolean bool = true;
          if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
            bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.ciF;
          }
          if ((l > ((RecentUser)localObject).lastmsgtime) && (bool)) {
            ((RecentUser)localObject).lastmsgtime = l;
          }
          localMap2.put(str2, localObject);
          localObject = (MessageRecord)localMap1.get(str2);
          if ((localObject != null) && (!paramMessageRecord.isSendFromLocal())) {
            break label358;
          }
          localMap1.put(str2, paramMessageRecord);
        }
      }
      for (;;)
      {
        if (paramMessageRecord.isSendFromLocal())
        {
          paramMessageRecord.extraflag = 32772;
          paramMessageRecord.sendFailCode = 0;
        }
        super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, parama);
        return;
        i = 0;
        break;
        label358:
        if (b(paramMessageRecord) >= b((MessageRecord)localObject)) {
          localMap1.put(str2, paramMessageRecord);
        }
      }
    }
  }
  
  protected String at(String paramString1, String paramString2)
  {
    if (this.app.getCurrentAccountUin().equals(paramString1)) {}
    String str;
    for (paramString2 = acfp.m(2131707118);; paramString2 = aqgv.h(this.app, paramString2, paramString1))
    {
      if ((paramString2 != null) && (paramString2.length() != 0))
      {
        str = paramString2;
        if (!paramString2.equals(paramString1)) {}
      }
      else
      {
        str = this.app.a(true).a(true).lt(paramString1);
      }
      if (str != null) {
        break;
      }
      return paramString1;
    }
    return str;
  }
  
  protected String au(String paramString1, String paramString2)
  {
    return at(paramString1, paramString2);
  }
  
  protected void c(QQMessageFacade.Message paramMessage)
  {
    paramMessage.nickName = at(paramMessage.senderuin, paramMessage.frienduin);
    Object localObject;
    if ((paramMessage.nickName == null) || (paramMessage.nickName.equals(paramMessage.senderuin))) {
      localObject = paramMessage.nickName;
    }
    try
    {
      String str = paramMessage.getExtInfoFromExtStr("hotchat_nick");
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      paramMessage.nickName = ((String)localObject);
    }
    if (QLog.isDevelopLevel()) {
      ajrk.f("PttShow", "processNickName", new Object[] { paramMessage.senderuin, paramMessage.nickName });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqv
 * JD-Core Version:    0.7.0.1
 */