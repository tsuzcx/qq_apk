import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arhl
  implements View.OnClickListener
{
  public arhl(ProfileCardMoreInfoView paramProfileCardMoreInfoView, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (afsi.me(this.this$0.app.getCurrentAccountUin()))
    {
      localObject = afyk.b(this.this$0.mActivity);
      int j = 1;
      int i = j;
      if ((this.this$0.mActivity instanceof FriendProfileCardActivity))
      {
        i = j;
        if (((FriendProfileCardActivity)this.this$0.mActivity).aWx) {
          i = 2;
        }
      }
      anot.a(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
      if ((this.this$0.mActivity != null) && (!this.this$0.mActivity.isFinishing())) {
        ((Dialog)localObject).show();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = new Intent();
      if (this.c != null) {
        ((Intent)localObject).putExtra("key_extend_friend_info", new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.c));
      }
      anot.a(this.this$0.app, "dc00898", "", "", "kuolie", "0X80092DB", 0, 0, "", "", "", "");
      PublicFragmentActivity.startForResult(this.this$0.mActivity, (Intent)localObject, ExtendFriendEditFragment.class, 4097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhl
 * JD-Core Version:    0.7.0.1
 */