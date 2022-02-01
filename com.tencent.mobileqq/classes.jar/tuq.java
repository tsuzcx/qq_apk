import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

class tuq
  implements View.OnClickListener
{
  tuq(tup paramtup, int paramInt) {}
  
  public void onClick(View paramView)
  {
    beke localbeke = (beke)tup.a(this.jdField_a_of_type_Tup).get(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Tup.a((beke)tup.a(this.jdField_a_of_type_Tup).get(this.jdField_a_of_type_Int), paramView.getContext());
    if (localbeke != null) {
      FolderRecommendTabFragment.a("227", "227", localbeke.a.iAdId + "", 102, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tuq
 * JD-Core Version:    0.7.0.1
 */