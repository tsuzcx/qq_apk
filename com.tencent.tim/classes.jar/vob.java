import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

public class vob
  extends achq
{
  public vob(QQLSActivity paramQQLSActivity) {}
  
  protected void A(boolean paramBoolean, Object paramObject)
  {
    super.A(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "PC has read onPushReadedNotify finish" + Thread.currentThread().getId());
    }
    QQLSActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vob
 * JD-Core Version:    0.7.0.1
 */