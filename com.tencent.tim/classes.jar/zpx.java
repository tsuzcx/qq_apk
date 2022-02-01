import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zpx
  extends akwl
{
  public zpx(BindNumberActivity paramBindNumberActivity) {}
  
  protected void C(boolean paramBoolean, Bundle paramBundle)
  {
    this.this$0.bso = false;
    this.this$0.cqW();
    this.this$0.VI();
    int i;
    if (paramBoolean)
    {
      String str = aqgv.BW();
      if (!TextUtils.isEmpty(str)) {
        anot.a(this.this$0.app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      i = paramBundle.getInt("k_result");
      if (paramBundle.getBoolean("k_buto_bind", false)) {
        this.this$0.cqY();
      }
    }
    for (;;)
    {
      aqgv.edI();
      this.this$0.app.unRegistObserver(this.this$0.g);
      this.this$0.g = null;
      return;
      if ((i == 104) || (i == 0))
      {
        this.this$0.cqX();
      }
      else
      {
        if (i == 107)
        {
          this.this$0.bK(paramBundle);
          return;
        }
        if (i == 106)
        {
          this.this$0.i(null, 2);
        }
        else if (i == 227)
        {
          this.this$0.cqZ();
        }
        else if (i == 226)
        {
          this.this$0.cra();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("BindNumberActivity", 2, "bind error " + i);
          }
          this.this$0.showToast(eF(i));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("BindNumberActivity", 2, "onBindMobile failed");
          }
          this.this$0.showToast(2131718828);
        }
      }
    }
  }
  
  protected void D(boolean paramBoolean, Bundle paramBundle)
  {
    this.this$0.VI();
    if (paramBoolean) {
      this.this$0.cqX();
    }
    for (;;)
    {
      this.this$0.app.unRegistObserver(this.this$0.g);
      this.this$0.g = null;
      return;
      this.this$0.showToast(2131718828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpx
 * JD-Core Version:    0.7.0.1
 */