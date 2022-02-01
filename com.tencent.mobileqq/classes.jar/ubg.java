import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

class ubg
  implements View.OnClickListener
{
  ubg(ubf paramubf, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bdda localbdda = (bdda)ubf.a(this.jdField_a_of_type_Ubf).get(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Ubf.a((bdda)ubf.a(this.jdField_a_of_type_Ubf).get(this.jdField_a_of_type_Int), paramView.getContext());
    if (localbdda != null) {
      FolderRecommendTabFragment.a("227", "227", localbdda.a.iAdId + "", 102, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubg
 * JD-Core Version:    0.7.0.1
 */