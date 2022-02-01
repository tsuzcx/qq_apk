import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nol
  implements View.OnClickListener
{
  nol(nof.a parama, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onClick: " + nof.a.a(this.d).mChannelCoverName);
    if (this.cz != null) {
      this.cz.onClick(paramView);
    }
    awit.cu(nof.a.a(this.d).mChannelCoverId, true);
    nof.a.a(this.d);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nol
 * JD-Core Version:    0.7.0.1
 */