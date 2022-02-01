import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aalr
  extends aalq
{
  public aalr(Context paramContext)
  {
    this.content = ("[" + acfp.m(2131699495) + "]");
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((StructMsgForGeneralShare)anre.a(paramMessageRecord.msgData) == null)
    {
      if (!QLog.isColorLevel()) {
        break label136;
      }
      QLog.d("Navigate.UpdateMsgInfoUtil", 2, "updateMsgInfo():calendarMsg getStructMsg is null");
      paramMessageRecord = "";
    }
    for (;;)
    {
      if ((paramObject instanceof aalr))
      {
        paramObject = (aalr)paramObject;
        paramObject.a.a(paramaozx.b);
      }
      for (paramaozx = paramObject;; paramaozx = paramObject)
      {
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          paramaozx.content = ("[" + paramMessageRecord + "]");
        }
        return paramaozx;
        paramMessageRecord = StructMsgForGeneralShare.remindBrief;
        break;
        paramObject = new aalr(BaseApplication.getContext());
        paramObject.a = new aozy(paramaozx.b);
      }
      label136:
      paramMessageRecord = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalr
 * JD-Core Version:    0.7.0.1
 */