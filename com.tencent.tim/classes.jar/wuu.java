import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class wuu
  extends achq
{
  wuu(wur paramwur) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    apoy localapoy;
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AppShortcutBarAIOHelper", 2, "onGetSystemMsgFin.success");
      }
      List localList = wur.a(this.this$0).app.b().k(acbn.bkK, 0);
      localapoy = null;
      paramList = localapoy;
      if (localList != null)
      {
        paramList = localapoy;
        if (localList.size() - 1 >= 0) {
          paramList = (MessageRecord)localList.get(localList.size() - 1);
        }
      }
      if ((paramList != null) && ((paramList instanceof MessageForSystemMsg))) {
        break label98;
      }
    }
    for (;;)
    {
      return;
      label98:
      paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
      if ((paramList.msg_type.get() == 2) && (paramList.msg.get() != null))
      {
        int i = paramList.msg.group_msg_type.get();
        if ((i == 3) || (i == 15))
        {
          long l = paramList.msg.group_code.get();
          if ((wur.a(this.this$0).sessionInfo.aTl != null) && (wur.a(this.this$0).sessionInfo.aTl.equalsIgnoreCase("" + l)))
          {
            paramList = ((TroopManager)wur.a(this.this$0).app.getManager(52)).b(wur.a(this.this$0).sessionInfo.aTl);
            if (paramList != null) {
              try
              {
                localapoy = wur.a(this.this$0).a(Long.valueOf(Long.parseLong(wur.a(this.this$0).sessionInfo.aTl)));
                if (localapoy != null)
                {
                  localapoy.WW(0);
                  wur.a(this.this$0).aV(Long.parseLong(wur.a(this.this$0).sessionInfo.aTl), (int)paramList.dwGroupClassExt);
                }
                localapoy = wur.a(this.this$0).b(Long.valueOf(Long.parseLong(wur.a(this.this$0).sessionInfo.aTl)));
                if (localapoy != null)
                {
                  localapoy.WW(0);
                  wur.a(this.this$0).aW(Long.parseLong(wur.a(this.this$0).sessionInfo.aTl), (int)paramList.dwGroupClassExt);
                  return;
                }
              }
              catch (Exception paramList)
              {
                QLog.e("AppShortcutBarAIOHelper", 1, paramList.getMessage());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wuu
 * JD-Core Version:    0.7.0.1
 */