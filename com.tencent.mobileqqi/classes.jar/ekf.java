import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class ekf
  extends ContactBindObserver
{
  public ekf(BindNumberActivity paramBindNumberActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.a.setEnabled(true);
    this.a.d();
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0))
      {
        paramBundle = new Intent(this.a, BindVerifyActivity.class);
        paramBundle.putExtra("k_number", this.a.c);
        if ((paramBundle != null) && (!this.a.isFinishing()))
        {
          paramBundle.addFlags(536870912);
          this.a.startActivityForResult(paramBundle, 2);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(BindNumberActivity.b(this.a));
      BindNumberActivity.b(this.a, null);
      return;
      if (i == 107)
      {
        Intent localIntent = new Intent(this.a, RebindActivity.class);
        localIntent.putExtra("k_uin", paramBundle.getString("k_uin"));
        localIntent.putExtra("k_number", this.a.c);
        localIntent.putExtra("k_country_code", this.a.jdField_b_of_type_JavaLangString);
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
      this.a.b(a(i));
      paramBundle = null;
      break;
      this.a.b(2131562782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ekf
 * JD-Core Version:    0.7.0.1
 */