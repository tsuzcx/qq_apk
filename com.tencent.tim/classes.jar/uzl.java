import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.29.3.1;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uzl
  implements View.OnClickListener
{
  uzl(uzi paramuzi) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null) {}
    label279:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if ((this.a.a.data instanceof String)) {
        localObject = (String)this.a.a.data;
      }
      for (;;)
      {
        if (localObject == null) {
          break label279;
        }
        this.a.this$0.copyContent((String)localObject);
        ThreadManager.post(new FriendProfileCardActivity.29.3.1(this), 5, null, true);
        break;
        if ((this.a.a.data instanceof ProfileActivity.CardContactInfo))
        {
          localObject = (ProfileActivity.CardContactInfo)this.a.a.data;
          if ((this.a.this$0.a != null) && (this.a.this$0.a.e != null) && (this.a.this$0.a.e.pa == 33)) {
            localObject = ((ProfileActivity.CardContactInfo)localObject).phoneNumber;
          } else {
            localObject = ((ProfileActivity.CardContactInfo)localObject).aOL + " " + ((ProfileActivity.CardContactInfo)localObject).phoneNumber;
          }
        }
        else if ((this.a.a.data instanceof alas))
        {
          if ((paramView instanceof TextView)) {
            localObject = ((alas)this.a.a.data).mJ(((TextView)paramView).getText().toString());
          } else {
            localObject = ((alas)this.a.a.data).mContent;
          }
        }
        else
        {
          localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzl
 * JD-Core Version:    0.7.0.1
 */