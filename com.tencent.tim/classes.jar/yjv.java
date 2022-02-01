import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class yjv
  extends achq
{
  yjv(yju paramyju) {}
  
  public void b(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    super.b(paramBoolean1, paramList, paramBoolean2);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.AIOUpComingMsgHelper", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    if ((paramBoolean1) && (paramList != null) && (!paramList.isEmpty())) {
      yju.a(this.this$0, (MessageRecord)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjv
 * JD-Core Version:    0.7.0.1
 */