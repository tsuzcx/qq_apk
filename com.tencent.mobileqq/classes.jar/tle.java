import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tle
  implements View.OnClickListener
{
  tle(tld paramtld, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onClick: " + tld.a(this.jdField_a_of_type_Tld).mChannelCoverName);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    bmhv.a(tld.a(this.jdField_a_of_type_Tld).mChannelCoverId, true);
    tld.a(this.jdField_a_of_type_Tld);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tle
 * JD-Core Version:    0.7.0.1
 */