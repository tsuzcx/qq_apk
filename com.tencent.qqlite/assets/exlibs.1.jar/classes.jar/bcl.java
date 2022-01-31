import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

public class bcl
  extends MessageObserver
{
  public bcl(QQLSActivity paramQQLSActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "PC has read onPushReadedNotify finish" + Thread.currentThread().getId());
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcl
 * JD-Core Version:    0.7.0.1
 */