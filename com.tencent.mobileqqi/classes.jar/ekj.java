import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.BindNumberDialogActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class ekj
  extends ContactBindObserver
{
  public ekj(BindNumberDialogActivity paramBindNumberDialogActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.d();
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0))
      {
        paramBundle = new Intent(this.a, BindVerifyActivity.class);
        paramBundle.putExtra("kBindType", BindNumberDialogActivity.a(this.a));
        paramBundle.putExtra("k_number", this.a.c);
        paramBundle.putExtra("kShowAgree", true);
        if ((paramBundle != null) && (!this.a.isFinishing()))
        {
          paramBundle.addFlags(536870912);
          this.a.startActivityForResult(paramBundle, 2);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(BindNumberDialogActivity.a(this.a));
      BindNumberDialogActivity.a(this.a, null);
      this.a.finish();
      return;
      if (i == 107)
      {
        Intent localIntent = new Intent(this.a, RebindActivity.class);
        localIntent.putExtra("k_uin", paramBundle.getString("k_uin"));
        localIntent.putExtra("k_number", this.a.c);
        localIntent.putExtra("k_country_code", this.a.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("kBindType", BindNumberDialogActivity.a(this.a));
        paramBundle = localIntent;
        break;
      }
      if (i == 106)
      {
        this.a.b(this.a.getString(2131558957));
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
 * Qualified Name:     ekj
 * JD-Core Version:    0.7.0.1
 */