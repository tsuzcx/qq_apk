import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;

class cof
  implements View.OnClickListener
{
  cof(coe paramcoe) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (String)paramView.getTag();
    paramView = (String)paramView.getTag(2131230924);
    if (localObject == null) {}
    do
    {
      return;
      if (!((String)localObject).equals(this.a.a.getString(2131562251))) {
        break;
      }
    } while (3000 != DiscussionInfoCardActivity.a(this.a.a));
    paramView = new Intent(this.a.a, SelectMemberActivity.class);
    localObject = new ArrayList(DiscussionInfoCardActivity.a(this.a.a));
    paramView.putStringArrayListExtra("param_uins_selected_default", (ArrayList)localObject);
    paramView.putExtra("param_groupcode", DiscussionInfoCardActivity.a(this.a.a));
    paramView.putExtra("param_type", 3000);
    paramView.putExtra("param_subtype", 1);
    paramView.putExtra("param_max", 50 - ((ArrayList)localObject).size());
    this.a.a.startActivityForResult(paramView, 2);
    return;
    if (((String)localObject).equals(this.a.a.b.a()))
    {
      paramView = new ProfileActivity.AllInOne((String)localObject, 0);
      paramView.jdField_e_of_type_Int = 5;
      paramView.f = 57;
      ProfileActivity.a(this.a.a, paramView, 3);
      return;
    }
    if (((FriendManager)this.a.a.b.getManager(8)).b((String)localObject))
    {
      paramView = new ProfileActivity.AllInOne((String)localObject, 1);
      paramView.g = ContactUtils.a(this.a.a.b, (String)localObject, 0);
      if (3000 != DiscussionInfoCardActivity.a(this.a.a))
      {
        paramView.jdField_e_of_type_JavaLangString = ((String)localObject);
        paramView.jdField_d_of_type_Int = DiscussionInfoCardActivity.a(this.a.a);
      }
      paramView.jdField_e_of_type_Int = 5;
      paramView.f = 57;
      ProfileActivity.a(this.a.a, paramView, 3);
      return;
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne((String)localObject, 46);
    if (DiscussionInfoCardActivity.a(this.a.a) == 3000)
    {
      localAllInOne.a = 46;
      localAllInOne.g = paramView;
      localAllInOne.jdField_e_of_type_JavaLangString = ((String)localObject);
      localAllInOne.jdField_d_of_type_Int = DiscussionInfoCardActivity.a(this.a.a);
      if (3000 != DiscussionInfoCardActivity.a(this.a.a)) {
        break label570;
      }
      localAllInOne.jdField_d_of_type_JavaLangString = DiscussionInfoCardActivity.a(this.a.a);
    }
    for (;;)
    {
      localAllInOne.jdField_e_of_type_Int = 5;
      localAllInOne.f = 57;
      ProfileActivity.a(this.a.a, localAllInOne, 3);
      return;
      if (DiscussionInfoCardActivity.a(this.a.a) == 1000)
      {
        localAllInOne.a = 22;
        localAllInOne.c = this.a.a.getIntent().getStringExtra("troop_uin");
        break;
      }
      if (DiscussionInfoCardActivity.a(this.a.a) == 1001)
      {
        localAllInOne.a = 42;
        break;
      }
      if (DiscussionInfoCardActivity.a(this.a.a) == 1005)
      {
        localAllInOne.a = 2;
        break;
      }
      if (DiscussionInfoCardActivity.a(this.a.a) == 1023)
      {
        localAllInOne.a = 74;
        break;
      }
      localAllInOne.a = 19;
      break;
      label570:
      if (1000 == DiscussionInfoCardActivity.a(this.a.a)) {
        localAllInOne.c = this.a.a.getIntent().getStringExtra("troop_uin");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cof
 * JD-Core Version:    0.7.0.1
 */