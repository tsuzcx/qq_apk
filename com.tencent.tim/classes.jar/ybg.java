import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class ybg
  implements Observer
{
  ybg(ybb paramybb) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof ytq))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "new FriendSystemMessage,:");
      }
      paramObservable = ((ytq)paramObject).a.getSystemMsg();
      if (paramObservable != null) {
        break label42;
      }
    }
    label42:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramObservable.msg.sub_type.get() != 9);
        paramObservable = String.valueOf(paramObservable.req_uin.get());
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "FRIEND_ADDSUCCESS, uin:" + paramObservable + " badd:" + ybb.a(this.this$0));
        }
      } while ((TextUtils.isEmpty(paramObservable)) || (this.this$0.sessionInfo == null) || (!paramObservable.equals(this.this$0.sessionInfo.aTl)));
      if (!ybb.a(this.this$0))
      {
        ybb.a(this.this$0, true);
        aine.ah(this.this$0.app, paramObservable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.this$0.TAG, 2, "FRIEND_ADDSUCCESS, processed:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybg
 * JD-Core Version:    0.7.0.1
 */