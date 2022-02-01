import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class uyz
  extends aqnl.a
{
  public uyz(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt)
  {
    super(paramInt);
  }
  
  public void onClick()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.bHA == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.this$0.jdField_a_of_type_Vbv != null) {
        this.this$0.jdField_a_of_type_Vbv.xr(bool);
      }
      VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "defaultcard", "click_customized", "", 1, 0, 0, "", "", "");
      this.this$0.AK(3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyz
 * JD-Core Version:    0.7.0.1
 */