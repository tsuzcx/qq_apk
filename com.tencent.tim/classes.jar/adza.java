import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adza
  implements View.OnClickListener
{
  public adza(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (BusinessCardEditActivity.a)paramView.getTag();
    if (!((acff)this.this$0.app.getManager(51)).isFriend(((BusinessCardEditActivity.a)localObject).uin)) {}
    for (int i = 35;; i = 1)
    {
      localObject = new ProfileActivity.AllInOne(((BusinessCardEditActivity.a)localObject).uin, i);
      ProfileActivity.a(this.this$0, (ProfileActivity.AllInOne)localObject, 1016);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adza
 * JD-Core Version:    0.7.0.1
 */