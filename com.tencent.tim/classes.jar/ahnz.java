import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.RefreshView.b;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ahnz
  implements RefreshView.b
{
  public ahnz(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onRefresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "onRefresh");
    }
    this.this$0.doU();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = NearbyHybridFragment.g;
    if (localSosoLbsInfo == null) {
      localSosoLbsInfo = SosoInterface.c();
    }
    for (;;)
    {
      if (localSosoLbsInfo != null) {
        ((acig)this.this$0.b.getBusinessHandler(3)).e((float)localSosoLbsInfo.a.ce, (float)localSosoLbsInfo.a.cd, 5);
      }
      this.this$0.a.onRefreshComplete();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnz
 * JD-Core Version:    0.7.0.1
 */