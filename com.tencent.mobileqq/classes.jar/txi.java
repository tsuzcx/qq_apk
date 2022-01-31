import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import java.util.ArrayList;
import java.util.List;

public class txi
  implements View.OnClickListener
{
  public txi(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    AssertUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter);
    AssertUtils.a(this.a.jdField_a_of_type_JavaUtilList);
    paramView = new ArrayList();
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      paramView.add(((TroopMemberListActivity.ATroopMember)this.a.jdField_a_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", paramView);
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txi
 * JD-Core Version:    0.7.0.1
 */