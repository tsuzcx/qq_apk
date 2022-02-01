import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.ContactsSearchableCircleBuddy;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchableDiscussionMember;
import com.tencent.mobileqq.search.SearchableTroopMember;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class eqy
  implements AdapterView.OnItemClickListener
{
  public eqy(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IContactSearchable localIContactSearchable = (IContactSearchable)SelectMemberActivity.a(this.a).getItem(paramInt);
    if (localIContactSearchable != null)
    {
      paramAdapterView = "";
      if ((localIContactSearchable instanceof ContactSearchableFriend))
      {
        paramAdapterView = ((ContactSearchableFriend)localIContactSearchable).a();
        paramView = paramAdapterView.uin;
        paramAdapterView = ContactUtils.a(paramAdapterView);
        if (((this.a.jdField_a_of_type_JavaUtilArrayList == null) || (!this.a.jdField_a_of_type_JavaUtilArrayList.contains(paramView))) && (!this.a.a(paramView)) && (!this.a.d())) {
          break label409;
        }
      }
    }
    else
    {
      return;
    }
    if ((localIContactSearchable instanceof SearchableDiscussionMember))
    {
      paramAdapterView = (DiscussionMemberInfo)((SearchableDiscussionMember)localIContactSearchable).a();
      paramView = paramAdapterView.memberUin;
      if ((FriendManager)this.a.b.getManager(8) == null) {
        break label916;
      }
    }
    label916:
    for (paramAdapterView = ContactUtils.a(paramAdapterView, this.a.b);; paramAdapterView = "")
    {
      break;
      Object localObject;
      if ((localIContactSearchable instanceof SearchableTroopMember))
      {
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((SearchableTroopMember)localIContactSearchable).a();
        localObject = localTroopMemberInfo.memberuin;
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.a.b.getManager(8);
        paramView = (View)localObject;
        if (localFriendsManagerImp == null) {
          break;
        }
        paramAdapterView = localFriendsManagerImp.a(localTroopMemberInfo);
        paramView = (View)localObject;
        break;
      }
      if ((localIContactSearchable instanceof ContactsSearchableCircleBuddy))
      {
        paramAdapterView = ((ContactsSearchableCircleBuddy)localIContactSearchable).a();
        paramView = paramAdapterView.uin;
        if ((paramAdapterView.remark != null) && (paramAdapterView.remark.length() != 0)) {
          paramAdapterView = paramAdapterView.remark;
        }
        for (;;)
        {
          ReportController.b(this.a.b, "CliOper", "", "", "Network_circle", "Search_circle_clk", 82, 0, "", "", "", "");
          break;
          if ((paramAdapterView.nickName != null) && (paramAdapterView.nickName.length() != 0)) {
            paramAdapterView = paramAdapterView.nickName;
          } else {
            paramAdapterView = paramAdapterView.uin;
          }
        }
      }
      if ((localIContactSearchable instanceof ContactsSearchablePhoneContact))
      {
        paramView = ((ContactsSearchablePhoneContact)localIContactSearchable).a();
        if (paramView.uin.equals("0")) {}
        for (paramAdapterView = paramView.nationCode + paramView.mobileCode;; paramAdapterView = paramView.uin)
        {
          localObject = paramView.name;
          paramView = paramAdapterView;
          paramAdapterView = (AdapterView)localObject;
          break;
        }
        label409:
        localObject = (SelectMemberInnerFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
        if ((this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 6) || (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) || (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 5)) {
          if ((localIContactSearchable instanceof SearchableDiscussionMember)) {
            this.a.c.add(this.a.a(paramView, paramAdapterView, 2, ((DiscussionMemberInfo)localIContactSearchable.a()).discussionUin));
          }
        }
        for (;;)
        {
          this.a.d();
          ((SelectMemberInnerFrame)localObject).f();
          this.a.a(true);
          SelectMemberActivity.a(this.a).setText("");
          this.a.i();
          return;
          if ((localIContactSearchable instanceof ContactSearchableFriend)) {
            this.a.c.add(this.a.a(paramView, paramAdapterView, 0, "-1"));
          } else if ((localIContactSearchable instanceof ContactsSearchableCircleBuddy)) {
            this.a.c.add(this.a.a(paramView, paramAdapterView, 3, "-1"));
          } else if ((localIContactSearchable instanceof ContactsSearchablePhoneContact)) {
            if (paramView.startsWith("+"))
            {
              this.a.c.add(this.a.a(paramView, paramAdapterView, 4, "-1"));
            }
            else
            {
              this.a.c.add(this.a.a(paramView, paramAdapterView, 0, "-1"));
              continue;
              if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 8) {
                this.a.c.add(this.a.a(paramView, paramAdapterView, 1, ((SelectMemberInnerFrame)localObject).a()));
              } else if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 9) {
                this.a.c.add(this.a.a(paramView, paramAdapterView, 2, ((SelectMemberInnerFrame)localObject).a()));
              } else if ((this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 1) || (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 7)) {
                this.a.c.add(this.a.a(paramView, paramAdapterView, 3, ((SelectMemberInnerFrame)localObject).a()));
              } else if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 2) {
                if (paramView.startsWith("+")) {
                  this.a.c.add(this.a.a(paramView, paramAdapterView, 4, ((SelectMemberInnerFrame)localObject).a()));
                } else {
                  this.a.c.add(this.a.a(paramView, paramAdapterView, 0, ((SelectMemberInnerFrame)localObject).a()));
                }
              }
            }
          }
        }
      }
      paramView = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqy
 * JD-Core Version:    0.7.0.1
 */