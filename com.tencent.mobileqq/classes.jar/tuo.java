import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

class tuo
  implements View.OnClickListener
{
  tuo(tun paramtun, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bdri localbdri = (bdri)tun.a(this.jdField_a_of_type_Tun).get(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Tun.a((bdri)tun.a(this.jdField_a_of_type_Tun).get(this.jdField_a_of_type_Int), paramView.getContext());
    if (localbdri != null) {
      FolderRecommendTabFragment.a("227", "227", localbdri.a.iAdId + "", 102, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tuo
 * JD-Core Version:    0.7.0.1
 */