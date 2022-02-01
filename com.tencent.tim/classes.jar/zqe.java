import android.os.Handler;
import android.widget.EditText;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zqe
  extends akwl
{
  public zqe(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void aJ(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "onVerifyBindSms [" + paramBoolean + ", " + paramInt + "]");
    }
    BindVerifyActivity.a(this.this$0, false);
    BindVerifyActivity.a(this.this$0).removeMessages(4);
    this.this$0.VI();
    if (!paramBoolean)
    {
      this.this$0.report("dc00898", "0X8009F19", 0);
      this.this$0.aL(1, this.this$0.getString(2131718828));
    }
    for (;;)
    {
      this.this$0.app.unRegistObserver(BindVerifyActivity.b(this.this$0));
      BindVerifyActivity.b(this.this$0, null);
      return;
      if ((paramInt == 0) || (paramInt == 106))
      {
        this.this$0.cre();
      }
      else if (paramInt == 213)
      {
        this.this$0.report("dc00898", "0X8009F19", 0);
        this.this$0.aL(1, acfp.m(2131703230));
        BindVerifyActivity.a(this.this$0).setEnabled(true);
      }
      else
      {
        this.this$0.report("dc00898", "0X8009F19", 0);
        String str = acfp.m(2131703225);
        if (paramInt == 107) {
          str = acfp.m(2131703227);
        }
        this.this$0.dV(acfp.m(2131703231), str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqe
 * JD-Core Version:    0.7.0.1
 */