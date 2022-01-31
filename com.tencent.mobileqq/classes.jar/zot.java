import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr.LocationInfo;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.qphone.base.util.QLog;

public class zot
  extends BizTroopObserver
{
  public zot(LbsInfoMgr paramLbsInfoMgr) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (paramBoolean)
    {
      d = TroopMemberLbsHelper.a(paramLong1, paramLong2, LbsInfoMgr.a(this.a).b, LbsInfoMgr.a(this.a).a);
      i = this.a.a;
      if ((d <= 500.0D) && (this.a.a < 3600000))
      {
        localLbsInfoMgr = this.a;
        localLbsInfoMgr.a *= 2;
      }
    }
    while (!QLog.isColorLevel())
    {
      double d;
      int i;
      LbsInfoMgr localLbsInfoMgr;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "onReportSelfLbsInfo: lat=" + paramLong1 + ", lon=" + paramLong2 + " nextInterval=" + this.a.a / 1000 / 60 + ", rawInterval=" + i / 1000 / 60 + ", distance=" + d);
        }
        LbsInfoMgr.a(this.a).b = paramLong1;
        LbsInfoMgr.a(this.a).a = paramLong2;
        TroopMemberLbsHelper.b(LbsInfoMgr.a(this.a));
        if ((d > 100.0D) && (this.a.b())) {
          LbsInfoMgr.a(this.a).a().a((int)paramLong1, (int)paramLong2);
        }
        return;
        if (d > 500.0D) {
          this.a.a = 900000;
        }
      }
    }
    QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "onReportSelfLbsInfo, isSucc=false, lat=" + paramLong1 + ", lon=" + paramLong2 + ", interval=" + this.a.a / 1000 / 60);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zot
 * JD-Core Version:    0.7.0.1
 */