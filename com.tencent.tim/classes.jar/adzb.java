import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adzb
  implements View.OnClickListener
{
  public adzb(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    BusinessCardEditActivity.a locala = (BusinessCardEditActivity.a)paramView.getTag();
    this.this$0.I(locala.uin, locala.nickName, locala.bSt);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzb
 * JD-Core Version:    0.7.0.1
 */