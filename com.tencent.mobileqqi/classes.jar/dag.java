import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class dag
  extends FriendListObserver
{
  public dag(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)) || (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, paramString))) {}
    for (;;)
    {
      return;
      paramString = (FriendManager)this.a.b.getManager(8);
      if (paramString == null) {}
      for (paramString = null; (paramString != null) && (!Utils.a(ProfileCardMoreActivity.b(this.a), paramString.group_name)); paramString = paramString.a(String.valueOf(paramByte1)))
      {
        ProfileCardMoreActivity.a(this.a, paramString.group_name);
        this.a.runOnUiThread(new dah(this));
        return;
      }
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131562991, 2);
      if (this.a.jdField_a_of_type_AndroidContentIntent == null) {
        this.a.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("finchat", true);
      this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
      this.a.finish();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(paramString1)) || (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
      return;
    }
    if (paramBoolean)
    {
      this.a.b(paramString2);
      if ((ProfileCardMoreActivity.a(this.a) & 0x1) == 1)
      {
        paramString1 = this.a;
        if (!paramBoolean) {
          break label190;
        }
        paramByte = 2131562805;
        label69:
        if (!paramBoolean) {
          break label197;
        }
      }
    }
    label188:
    label190:
    label197:
    for (int i = 2;; i = 1)
    {
      paramString1.a(paramByte, i);
      ProfileCardMoreActivity.a(this.a, ProfileCardMoreActivity.a(this.a) & 0xFFFFFFFE);
      return;
      paramString1 = (FriendManager)this.a.b.getManager(8);
      if (paramString1 == null) {}
      for (paramString1 = null;; paramString1 = paramString1.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
      {
        if (paramString1 == null) {
          break label188;
        }
        String str = "";
        paramString2 = str;
        if (paramString1.remark != null)
        {
          paramString2 = str;
          if (paramString1.isRemark == 1) {
            paramString2 = paramString1.remark;
          }
        }
        this.a.b(paramString2);
        break;
      }
      break;
      paramByte = 2131562435;
      break label69;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    FriendManager localFriendManager;
    Object localObject2;
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != null) && (ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
    {
      localFriendManager = (FriendManager)this.a.b.getManager(8);
      if (localFriendManager != null) {
        break label226;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        String str = "";
        localObject2 = str;
        if (((Friends)localObject1).remark != null)
        {
          localObject2 = str;
          if (((Friends)localObject1).isRemark == 1) {
            localObject2 = ((Friends)localObject1).remark;
          }
        }
        this.a.b((String)localObject2);
        localObject1 = localFriendManager.a(String.valueOf(((Friends)localObject1).groupid));
        if ((localObject1 != null) && (!Utils.a(ProfileCardMoreActivity.b(this.a), ((Groups)localObject1).group_name)))
        {
          ProfileCardMoreActivity.a(this.a, ((Groups)localObject1).group_name);
          if ((ProfileCardMoreActivity.b(this.a) != null) && (ProfileCardMoreActivity.b(this.a).equals("我的好友"))) {
            ProfileCardMoreActivity.a(this.a, this.a.getString(2131559856));
          }
          localObject2 = this.a.c;
          if (!TextUtils.isEmpty(ProfileCardMoreActivity.b(this.a))) {
            break label247;
          }
        }
      }
    }
    label226:
    label247:
    for (Object localObject1 = "";; localObject1 = ProfileCardMoreActivity.b(this.a))
    {
      ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
      return;
      localObject1 = localFriendManager.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dag
 * JD-Core Version:    0.7.0.1
 */