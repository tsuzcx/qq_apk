import android.content.Intent;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.WtloginObserver;

public class altz
  extends alty
{
  protected static final String TAG = altz.class.getSimpleName();
  private byte[] bW;
  private String bYs = this.a.getIntent().getStringExtra("key_register_fail_paid_lh");
  private boolean bac = this.a.getIntent().getBooleanExtra("key_register_from_send_sms", false);
  private WtloginObserver c = new alua(this);
  private String mSmsCode = "";
  private String mUin;
  
  public altz(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    if (this.mSmsCode == null) {
      this.mSmsCode = "";
    }
  }
  
  public void dI(Intent paramIntent)
  {
    this.mSmsCode = paramIntent.getStringExtra("key_register_smscode");
    if (this.mSmsCode == null) {
      this.mSmsCode = "";
    }
    this.bYs = paramIntent.getStringExtra("key_register_from_fail_pay_lh");
    doAction(paramIntent.getStringExtra("key_register_nick"));
  }
  
  public void doAction(String paramString)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(TAG, 4, String.format(Locale.getDefault(), "doAction nick: %s, unBindUin: %s, smsCode: %s", new Object[] { paramString, this.bYs, this.mSmsCode }));
      }
      this.a.Bv(2131717031);
      if (akwp.a().a(this.a.app, this.mSmsCode.getBytes(), paramString.getBytes(), this.bYs, this.c) != 0)
      {
        this.a.gV();
        this.a.J(2131717096, 1);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altz
 * JD-Core Version:    0.7.0.1
 */