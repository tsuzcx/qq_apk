import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class vhx
  implements DialogInterface.OnClickListener
{
  vhx(vhw paramvhw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("nearby.check.auth", 1, "onCheckNearbyUserAuth onClick exit");
    this.a.this$0.finish();
    if (aqiw.isNetSupport(BaseApplication.getContext())) {
      ahng.a(this.a.this$0.b);
    }
    new anov(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_clk").e(this.a.this$0.b.getCurrentAccountUin()).report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhx
 * JD-Core Version:    0.7.0.1
 */