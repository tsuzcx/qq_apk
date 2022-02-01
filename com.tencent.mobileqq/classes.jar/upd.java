import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

class upd
  implements View.OnClickListener
{
  upd(upc paramupc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bekc localbekc = (bekc)upc.a(this.jdField_a_of_type_Upc).get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Upc.a((bekc)upc.a(this.jdField_a_of_type_Upc).get(this.jdField_a_of_type_Int), paramView.getContext());
      if (localbekc != null) {
        FolderRecommendTabFragment.a("227", "227", localbekc.a.iAdId + "", 102, 1);
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        localIndexOutOfBoundsException.printStackTrace();
        QLog.e("FolderRecommendTabFragment", 1, "on click IndexOutOfBoundsException", localIndexOutOfBoundsException);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upd
 * JD-Core Version:    0.7.0.1
 */