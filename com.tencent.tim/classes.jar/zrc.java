import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;

public class zrc
  extends akwl
{
  public zrc(RebindActivity paramRebindActivity) {}
  
  protected void D(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.VI();
    if (paramBoolean)
    {
      paramBundle = new Intent(this.a, BindVerifyActivity.class);
      paramBundle.putExtra("kSrouce", this.a.mSource);
      paramBundle.putExtra("k_number", this.a.baz);
      paramBundle.putExtra("kBindType", RebindActivity.a(this.a));
      paramBundle.putExtra("keyReqBindMode", 1);
      paramBundle.putExtra("k_country_code", RebindActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_uni", RebindActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_change_bind", RebindActivity.b(this.a));
      paramBundle.addFlags(67108864);
      paramBundle.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
      paramBundle.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
      paramBundle.putExtra("key_is_from_qav_multi_call", this.a.getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
      this.a.startActivityForResult(paramBundle, 1);
      return;
    }
    this.a.showToast(2131718828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrc
 * JD-Core Version:    0.7.0.1
 */