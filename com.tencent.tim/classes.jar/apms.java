import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class apms
  extends apmr
{
  public apms(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    apab.a locala = apab.a.a(paramInt1, paramLong1, paramInt2);
    MessageRecord localMessageRecord = this.app.b().d(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong1);
    Object localObject;
    if (!aqio.isEmpty(paramList))
    {
      localObject = this.context;
      if (paramInt1 == 17)
      {
        paramInt1 = 2131696129;
        if (paramList.size() <= 99) {
          break label366;
        }
        paramObject = "99+";
        label73:
        paramObject = ((Context)localObject).getString(paramInt1, new Object[] { paramObject });
        localObject = (TroopManager)this.app.getManager(52);
        if (localObject == null) {
          break label492;
        }
        localObject = ((TroopManager)localObject).b(this.sessionInfo.aTl);
        if ((localObject == null) || (!((TroopInfo)localObject).hasOrgs())) {
          break label380;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label138:
      label184:
      label187:
      label235:
      boolean bool1;
      if (paramInt1 != 0)
      {
        if (paramList.size() == 1) {
          anot.a(this.app, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.sessionInfo.aTl, "", "", "");
        }
      }
      else
      {
        paramList = paramObject;
        if (!MessageForQQWalletMsg.isRedPacketMsg(localMessageRecord)) {
          break label471;
        }
        paramList = (MessageForQQWalletMsg)localMessageRecord;
        if ((paramList.messageType != 7) && (paramList.messageType != 8)) {
          break label455;
        }
        paramList = this.context.getString(2131719508);
        locala.cPv = true;
        if ((localMessageRecord == null) || (!a(localMessageRecord, paramLong2, paramLong3))) {
          break label482;
        }
        paramObject = localMessageRecord.senderuin;
        bool1 = true;
      }
      for (;;)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject = this.TAG + ".troop.special_msg.special_attention";
          localStringBuilder = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
          if (localMessageRecord == null) {
            break label474;
          }
        }
        label455:
        label471:
        label474:
        for (boolean bool2 = true;; bool2 = false)
        {
          QLog.d((String)localObject, 2, bool2 + ", isShow = " + bool1);
          if (!bool1) {
            break label480;
          }
          return new apmr.a(true, paramList, locala, paramObject);
          paramInt1 = 2131701847;
          break;
          label366:
          paramObject = Integer.valueOf(paramList.size());
          break label73;
          label380:
          paramInt1 = 0;
          break label138;
          anot.a(this.app, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, this.sessionInfo.aTl, paramList.size() + "", "", "");
          break label184;
          paramList = this.context.getString(2131720413);
          break label187;
          paramList = this.context.getString(2131719487);
          locala.cPu = true;
          break label235;
        }
        label480:
        return null;
        label482:
        bool1 = false;
        paramObject = "";
      }
      label492:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apms
 * JD-Core Version:    0.7.0.1
 */