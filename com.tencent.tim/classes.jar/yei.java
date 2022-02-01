import GROUP.MessageRemindRsp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

public class yei
  extends aclh
{
  public yei(TroopChatPie paramTroopChatPie) {}
  
  public void a(boolean paramBoolean, MessageRemindRsp paramMessageRemindRsp)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("vip_pretty." + this.this$0.TAG, 2, "SVIPObserver.onGetBigTroopExpiredInfo, troopUin: " + this.this$0.sessionInfo.aTl + " iFreezedType=" + paramMessageRemindRsp.iFreezedType + " iLhGroupExpiredTime=" + paramMessageRemindRsp.iLhGroupExpiredTime + " iGroupType=" + paramMessageRemindRsp.iGroupType);
      }
      ((TroopManager)this.this$0.app.getManager(52)).a(this.this$0.sessionInfo.aTl, paramMessageRemindRsp);
      TroopManager.a(paramMessageRemindRsp, this.this$0.app, this.this$0.sessionInfo.aTl, this.this$0.mContext, this.this$0, TroopChatPie.b(this.this$0));
      return;
    }
    QLog.e("vip_pretty." + this.this$0.TAG, 2, String.format("SVIPObserver.onGetBigTroopExpiredInfo, troopUin: %s, isSuccess: false", new Object[] { this.this$0.sessionInfo.aTl }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yei
 * JD-Core Version:    0.7.0.1
 */