import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vfy
  extends accn
{
  public vfy(LikeSettingActivity paramLikeSettingActivity) {}
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onGetCardSwitch.isSuccess=" + paramBoolean1 + ",uin=" + paramString + ",voteAllowed=" + paramBoolean2 + ",praiseStatusAllowed=" + paramBoolean3);
    }
    if (!this.this$0.app.getCurrentAccountUin().equals(paramString)) {}
    while (!paramBoolean1) {
      return;
    }
    LikeSettingActivity.a(this.this$0, this.this$0.S.a(), paramBoolean2);
  }
  
  protected void onGetNotifyOnLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onGetNotifyOnLikeRankingList.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      LikeSettingActivity.a(this.this$0, this.this$0.R.a(), paramBoolean2);
      this.this$0.a.Fb(paramBoolean2);
    }
  }
  
  protected void onGetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onGetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      LikeSettingActivity.a(this.this$0, this.this$0.T.a(), paramBoolean2);
      this.this$0.a.Fc(paramBoolean2);
      if (!paramBoolean2) {
        this.this$0.R.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.this$0.R.setVisibility(0);
  }
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onSetCardSwitch.isSuccess=" + paramBoolean1 + ",uin=" + paramString + ",forNearPeople=" + paramBoolean2 + ",allowed=" + paramBoolean3);
    }
    if ((!this.this$0.app.getCurrentAccountUin().equals(paramString)) || (!paramBoolean2)) {}
    while (paramBoolean1) {
      return;
    }
    QQToast.a(this.this$0, 1, 2131719890, 0).show(this.this$0.getTitleBarHeight());
    LikeSettingActivity.a(this.this$0, this.this$0.S.a(), paramBoolean3);
  }
  
  protected void onSetNotifyOnLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onSetNotifyOnLikeRankingList.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (!paramBoolean1)
    {
      QQToast.a(this.this$0, 1, 2131719890, 0).show(this.this$0.getTitleBarHeight());
      LikeSettingActivity.a(this.this$0, this.this$0.T.a(), this.this$0.a.aaw());
      return;
    }
    this.this$0.a.Fb(paramBoolean2);
  }
  
  protected void onSetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onSetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (!paramBoolean1)
    {
      QQToast.a(this.this$0, 1, 2131719890, 0).show(this.this$0.getTitleBarHeight());
      LikeSettingActivity.a(this.this$0, this.this$0.T.a(), this.this$0.a.aay());
      return;
    }
    this.this$0.a.Fc(paramBoolean2);
    if (!paramBoolean2)
    {
      this.this$0.R.setVisibility(8);
      return;
    }
    this.this$0.R.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfy
 * JD-Core Version:    0.7.0.1
 */