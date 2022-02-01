import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import java.util.ArrayList;

public class uyw
  extends aqnl.a
{
  public uyw(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt)
  {
    super(paramInt);
  }
  
  public void onClick()
  {
    Intent localIntent = new Intent(this.this$0, CardPicGalleryActivity.class);
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mCoverUrl)) {
      localIntent.putExtra("extra_default", 2130846645);
    }
    localArrayList.add(this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mCoverUrl);
    localIntent.putExtra("extra_mode", 2);
    localIntent.putExtra("is_from_mine_profile", true);
    localIntent.putStringArrayListExtra("business_card_pics", localArrayList);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.bHA == 0) {}
    for (int i = this.this$0.jdField_a_of_type_Alcn.d.defaultCardId;; i = 0)
    {
      localIntent.putExtra("default_card_id", i);
      this.this$0.startActivity(localIntent);
      this.this$0.overridePendingTransition(2130772376, 0);
      this.this$0.AK(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyw
 * JD-Core Version:    0.7.0.1
 */