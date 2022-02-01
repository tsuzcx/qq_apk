import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class uym
  extends alcb
{
  public uym(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a(boolean paramBoolean, String paramString, PersonalityLabel paramPersonalityLabel, byte[] paramArrayOfByte, int paramInt)
  {
    if ((!TextUtils.equals(paramString, this.this$0.jdField_a_of_type_Alcn.e.uin)) || (this.this$0.jdField_a_of_type_Alcn.d == null)) {}
    while (paramInt != 0) {
      return;
    }
    this.this$0.jdField_a_of_type_Alcn.d.personalityLabel = paramPersonalityLabel;
    this.this$0.jdField_a_of_type_Alcn.d.vPersonalityLabelV2 = paramArrayOfByte;
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.this$0.jdField_a_of_type_Alcn, true, new String[] { "map_key_personality_label_board" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uym
 * JD-Core Version:    0.7.0.1
 */