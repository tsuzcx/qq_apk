import com.tencent.mobileqq.activity.bless.BlessBaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class wkh
  extends MessageObserver
{
  public wkh(BlessBaseActivity paramBlessBaseActivity) {}
  
  public void a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onSendBlessMsgResp " + paramBoolean1);
    }
    this.a.a();
    if (!this.a.jdField_a_of_type_Boolean) {
      return;
    }
    this.a.jdField_a_of_type_Boolean = false;
    if (paramInt == 67L)
    {
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      this.a.a(paramLong);
      QQToast.a(this.a.app.getApp(), 2131438305, 1).a();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "onSendBlessMsgResp failed:" + paramInt + " waitTime=" + paramLong);
      }
      this.a.b(paramBoolean1);
      return;
      if (!paramBoolean1) {
        QQToast.a(this.a.app.getApp(), 2131438306, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wkh
 * JD-Core Version:    0.7.0.1
 */