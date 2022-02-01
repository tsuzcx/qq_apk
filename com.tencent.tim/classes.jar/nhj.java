import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nhj
  implements View.OnClickListener
{
  nhj(nhi paramnhi, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    if (nhi.a(this.jdField_c_of_type_Nhi) != null) {
      nhi.a(this.jdField_c_of_type_Nhi).oE(this.val$position);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
    int j = kqo.aLl;
    if (this.kz.getVisibility() == 0) {}
    for (int i = 1;; i = 0)
    {
      kqo.a("0X8009496", localTabChannelCoverInfo, j, i, this.val$position);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhj
 * JD-Core Version:    0.7.0.1
 */