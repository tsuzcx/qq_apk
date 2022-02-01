import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView.5;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arhd
  implements View.OnClickListener
{
  public arhd(ProfileCardExtendFriendView.5 param5) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c.authState == 1L) {
      QQToast.a(this.a.this$0.getContext(), 0, 2131701096, 1).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.c.authState == 0L) || (this.a.c.authState == 3L)) {
        afxn.b((FriendProfileCardActivity)ProfileCardExtendFriendView.a(this.a.this$0), this.a.c.idx, this.a.c.schoolName, this.a.c.schoolId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhd
 * JD-Core Version:    0.7.0.1
 */