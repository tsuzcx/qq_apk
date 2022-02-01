import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class uqc
  extends acnd
{
  public uqc(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<apyk> paramList, int paramInt)
  {
    if (this.this$0.a == null) {}
    while ((!paramBoolean1) || (paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    paramInt = 0;
    label31:
    apyk localapyk;
    if (paramInt < paramList.size())
    {
      localapyk = (apyk)paramList.get(paramInt);
      if ((localapyk != null) && (aqft.equalsWithNullCheck(localapyk.troopuin, this.this$0.a.troopUin)))
      {
        if (localapyk.appid != 2L) {
          break label206;
        }
        this.this$0.a.nNewPhotoNum = localapyk.dXV;
        this.this$0.a.nUnreadMsgNum = localapyk.nUnreadMsgNum;
        this.this$0.mUIHandler.sendEmptyMessage(4);
        if (paramBoolean2) {
          avpw.bf(this.this$0, this.this$0.a.nUnreadMsgNum);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onUpdateTroopUnreadMsg| isPush = " + paramBoolean2 + ", " + localapyk);
      }
      paramInt += 1;
      break label31;
      break;
      label206:
      if (localapyk.appid == 1L)
      {
        this.this$0.a.nUnreadFileMsgnum = localapyk.nUnreadMsgNum;
        this.this$0.a.nNewFileMsgNum = localapyk.dXV;
        this.this$0.mUIHandler.sendEmptyMessage(8);
      }
      else if (localapyk.appid == 1101236949L)
      {
        this.this$0.a.mNewTroopNotificationNum = localapyk.dXV;
        this.this$0.mUIHandler.sendEmptyMessage(9);
      }
      else if (localapyk.appid == 1106611799L)
      {
        Object localObject = this.this$0.mUIHandler.obtainMessage(19);
        ((Message)localObject).arg1 = localapyk.dXV;
        ((Message)localObject).sendToTarget();
        if ((localapyk.dXV == -1) || (localapyk.dXV > 0))
        {
          localObject = (acms)this.this$0.app.getBusinessHandler(20);
          if (localObject != null) {
            ((acms)localObject).a(this.this$0.a.troopUin, true, this.this$0.bFM, 3);
          }
        }
      }
      else if (localapyk.appid == 1106664488L)
      {
        this.this$0.a.nUnreadFileMsgnum = 1;
        this.this$0.a.nNewFileMsgNum = localapyk.dXV;
        this.this$0.mUIHandler.sendEmptyMessage(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqc
 * JD-Core Version:    0.7.0.1
 */