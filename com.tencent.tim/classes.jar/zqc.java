import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class zqc
  extends akwl
{
  public zqc(BindNumberFromPcActivity paramBindNumberFromPcActivity) {}
  
  protected void C(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.confirmBtn.setEnabled(true);
    this.a.VI();
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0))
      {
        paramBundle = new Intent(this.a, BindVerifyActivity.class);
        paramBundle.putExtra("k_number", this.a.mobileNo);
        paramBundle.putExtra("k_country_code", this.a.countryCode);
        if ((paramBundle != null) && (!this.a.isFinishing()))
        {
          paramBundle.addFlags(536870912);
          this.a.startActivityForResult(paramBundle, 1);
        }
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindNumberFromPcActivity.a(this.a));
      BindNumberFromPcActivity.a(this.a, null);
      return;
      if (i == 107)
      {
        Intent localIntent = new Intent(this.a, RebindActivity.class);
        localIntent.putExtra("k_uin", paramBundle.getString("k_uin"));
        localIntent.putExtra("k_number", this.a.mobileNo);
        localIntent.putExtra("k_country_code", this.a.countryCode);
        paramBundle = localIntent;
        break;
      }
      if (i == 106)
      {
        this.a.setResult(-1);
        this.a.finish();
        paramBundle = null;
        break;
      }
      this.a.showToast(eF(i));
      paramBundle = null;
      break;
      this.a.showToast(2131718828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqc
 * JD-Core Version:    0.7.0.1
 */