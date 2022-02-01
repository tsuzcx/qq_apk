import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class vhw
  extends acih
{
  public vhw(NearbyActivity paramNearbyActivity) {}
  
  protected void b(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.heart_beat", 2, "onNearbyHeartBeat:isSucc=" + paramBoolean + ", cmd=" + paramString + ", interval=" + paramLong);
    }
    if ("OidbSvc.0xafc_1".equals(paramString))
    {
      if (paramBoolean) {
        this.this$0.Gy = paramLong;
      }
      if (!this.this$0.aYJ)
      {
        this.this$0.bN.removeMessages(this.this$0.bID);
        this.this$0.bN.sendEmptyMessageDelayed(this.this$0.bID, this.this$0.Gy);
      }
    }
  }
  
  protected void g(boolean paramBoolean, int paramInt, String paramString)
  {
    QLog.d("nearby.check.auth", 1, "onCheckNearbyUserAuth isSuccess=" + paramBoolean + ", checkRet=" + paramInt + ", checkMsg=" + paramString + ", isFinishing=" + this.this$0.isFinishing() + ", isStopHeartBeat=" + this.this$0.aYJ);
    if ((paramBoolean) && (paramInt != 0)) {
      if (!this.this$0.isFinishing()) {}
    }
    while ((this.this$0.isFinishing()) || (this.this$0.aYJ))
    {
      do
      {
        return;
        try
        {
          aqju localaqju = aqha.a(this.this$0, 230);
          localaqju.setCancelable(false);
          String str = paramString;
          if (TextUtils.isEmpty(paramString)) {
            str = acfp.m(2131708647);
          }
          localaqju.setMessage(str);
          localaqju.setNegativeButton(acfp.m(2131708648), new vhx(this));
          localaqju.show();
          new anov(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_exp").e(this.this$0.b.getCurrentAccountUin()).report();
          return;
        }
        catch (Exception paramString) {}
      } while (!QLog.isColorLevel());
      QLog.d("nearby.NearbyActivity", 2, "onCheckNearbyUserAuth exp:" + paramString.toString());
      return;
    }
    this.this$0.bRL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhw
 * JD-Core Version:    0.7.0.1
 */