import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uzy
  implements View.OnClickListener
{
  public uzy(FriendProfileCardActivity paramFriendProfileCardActivity, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((FriendProfileCardActivity.a(this.this$0) != null) && (FriendProfileCardActivity.a(this.this$0).isShowing())) {
        FriendProfileCardActivity.a(this.this$0).dismiss();
      }
      if (TextUtils.isEmpty(this.c.declaration))
      {
        anot.a(this.this$0.app, "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
      }
      else
      {
        anot.a(this.this$0.app, "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
        continue;
        if (TextUtils.isEmpty(this.c.declaration)) {
          PublicFragmentActivity.start(this.this$0.getActivity(), ExtendFriendEditFragment.class);
        }
        for (;;)
        {
          if ((FriendProfileCardActivity.a(this.this$0) != null) && (FriendProfileCardActivity.a(this.this$0).isShowing())) {
            FriendProfileCardActivity.a(this.this$0).dismiss();
          }
          if (!TextUtils.isEmpty(this.c.declaration)) {
            break label278;
          }
          anot.a(this.this$0.app, "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
          break;
          Intent localIntent = InterestSwitchEditActivity.b(this.this$0);
          this.this$0.startActivityForResult(localIntent, 1022);
        }
        label278:
        anot.a(this.this$0.app, "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzy
 * JD-Core Version:    0.7.0.1
 */