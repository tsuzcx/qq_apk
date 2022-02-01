import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aalo
  extends aalq
{
  public aalo(Context paramContext)
  {
    this.content = acfp.m(2131699463);
    this.contentDescription = this.content;
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof aalo))
    {
      paramObject = (aalo)paramObject;
      paramObject.a.a(paramaozx.b);
    }
    for (paramaozx = paramObject;; paramaozx = paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(aozx.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
      }
      return paramaozx;
      paramObject = new aalo(BaseApplication.getContext());
      paramObject.a(paramMessageRecord.senderuin);
      paramObject.a = new aozy(paramaozx.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalo
 * JD-Core Version:    0.7.0.1
 */