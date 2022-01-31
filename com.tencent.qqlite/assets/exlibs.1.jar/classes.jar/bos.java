import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.activity.TroopMemberListActivity.SearchResultAdapter;

public class bos
  implements View.OnClickListener
{
  public bos(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    int i;
    do
    {
      do
      {
        return;
        i = ((Integer)localObject).intValue();
      } while (i < 0);
      paramView = paramView.findViewById(2131298885);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramView.getTag() != null)
      {
        bool1 = bool2;
        if ((paramView.getTag() instanceof Boolean)) {
          bool1 = ((Boolean)paramView.getTag()).booleanValue();
        }
      }
      if (!bool1) {
        break;
      }
      paramView = (TroopMemberListActivity.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.getItem(i);
      this.a.a(paramView);
    } while ((this.a.b == null) || (!this.a.b.isShowing()));
    this.a.b.dismiss();
    return;
    paramView = (TroopMemberListActivity.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.getItem(i);
    this.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bos
 * JD-Core Version:    0.7.0.1
 */