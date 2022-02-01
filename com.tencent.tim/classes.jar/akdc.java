import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akdc
  implements View.OnClickListener
{
  akdc(akcx paramakcx) {}
  
  public void onClick(View paramView)
  {
    ajoz localajoz = ajoz.a(this.this$0.a, this.this$0.a.app.getAccount(), 2);
    if (localajoz != null)
    {
      localajoz.d1 = "13";
      localajoz.toUin = akcx.a(this.this$0).uin;
      akkm localakkm = new akkm(this.this$0.a);
      localakkm.a(localajoz);
      localakkm.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akdc
 * JD-Core Version:    0.7.0.1
 */