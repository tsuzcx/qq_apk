import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

public class tim
  extends MessageObserver
{
  public tim(QQLSActivity paramQQLSActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "PC has read onPushReadedNotify finish" + Thread.currentThread().getId());
    }
    QQLSActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tim
 * JD-Core Version:    0.7.0.1
 */