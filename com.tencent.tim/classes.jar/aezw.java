import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aezw
  implements View.OnClickListener
{
  public aezw(MessageForNewGrayTips paramMessageForNewGrayTips, GrayTipsSpan paramGrayTipsSpan) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForNewGrayTips.click(paramView, this.jdField_a_of_type_ComTencentMobileqqDataGrayTipsSpan.url);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aezw
 * JD-Core Version:    0.7.0.1
 */