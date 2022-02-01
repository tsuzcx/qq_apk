import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zqd
  extends akwl
{
  public zqd(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void C(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "onBindMobile [" + paramBoolean + ", " + paramBundle + "]");
    }
    this.this$0.VI();
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0)) {
        this.this$0.crf();
      }
    }
    for (;;)
    {
      this.this$0.app.unRegistObserver(BindVerifyActivity.a(this.this$0));
      BindVerifyActivity.a(this.this$0, null);
      return;
      if (i == 107)
      {
        this.this$0.bK(paramBundle);
      }
      else if (i == 106)
      {
        this.this$0.cre();
        if (this.this$0.getIntent().getBooleanExtra("k_is_block", false)) {
          anot.a(this.this$0.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 2, 0, "", "", "", "");
        }
      }
      else
      {
        this.this$0.aL(1, eF(i));
        continue;
        this.this$0.aL(1, this.this$0.getString(2131718828));
      }
    }
  }
  
  protected void D(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, "onRebindMobile [" + paramBoolean + ", " + paramBundle + "]");
    }
    this.this$0.VI();
    if (paramBoolean) {
      this.this$0.crf();
    }
    for (;;)
    {
      this.this$0.app.unRegistObserver(BindVerifyActivity.a(this.this$0));
      BindVerifyActivity.a(this.this$0, null);
      return;
      this.this$0.aL(1, this.this$0.getString(2131718828));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqd
 * JD-Core Version:    0.7.0.1
 */