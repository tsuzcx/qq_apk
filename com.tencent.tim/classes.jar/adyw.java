import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qphone.base.util.QLog;

public class adyw
  extends ContentObserver
{
  public adyw(BusinessCardEditActivity paramBusinessCardEditActivity, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_EditActivity", 2, "Contact changed selfChange=" + paramBoolean);
    }
    if (BusinessCardEditActivity.a(this.this$0))
    {
      this.this$0.cf(2131700776, 2);
      BusinessCardEditActivity.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyw
 * JD-Core Version:    0.7.0.1
 */