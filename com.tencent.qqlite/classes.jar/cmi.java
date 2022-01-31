import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchableDiscussionMember;
import com.tencent.mobileqq.search.SearchableTroopMember;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class cmi
  implements AdapterView.OnItemClickListener
{
  public cmi(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IContactSearchable localIContactSearchable = (IContactSearchable)SelectMemberActivity.a(this.a).getItem(paramInt);
    if (localIContactSearchable != null)
    {
      paramView = "";
      if ((localIContactSearchable instanceof ContactSearchableFriend))
      {
        paramView = ((ContactSearchableFriend)localIContactSearchable).a();
        paramAdapterView = paramView.uin;
        paramView = ContactUtils.a(paramView);
        if (((this.a.jdField_a_of_type_JavaUtilArrayList == null) || (!this.a.jdField_a_of_type_JavaUtilArrayList.contains(paramAdapterView))) && (!this.a.a(paramAdapterView)) && (!this.a.d())) {
          break label291;
        }
      }
    }
    else
    {
      return;
    }
    Object localObject;
    if ((localIContactSearchable instanceof SearchableDiscussionMember))
    {
      paramAdapterView = (DiscussionMemberInfo)((SearchableDiscussionMember)localIContactSearchable).a();
      localObject = paramAdapterView.memberUin;
      if ((FriendManager)this.a.app.getManager(8) == null) {
        break label699;
      }
    }
    label291:
    label699:
    for (paramAdapterView = ContactUtils.a(paramAdapterView, this.a.app);; paramAdapterView = "")
    {
      paramView = paramAdapterView;
      paramAdapterView = (AdapterView)localObject;
      break;
      if ((localIContactSearchable instanceof SearchableTroopMember))
      {
        localObject = (TroopMemberInfo)((SearchableTroopMember)localIContactSearchable).a();
        paramAdapterView = ((TroopMemberInfo)localObject).memberuin;
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.a.app.getManager(8);
        if (localFriendsManagerImp != null) {
          paramView = localFriendsManagerImp.a((TroopMemberInfo)localObject);
        }
        break;
      }
      if ((localIContactSearchable instanceof ContactsSearchablePhoneContact))
      {
        paramView = ((ContactsSearchablePhoneContact)localIContactSearchable).a();
        if (paramView.uin.equals("0")) {}
        for (paramAdapterView = paramView.nationCode + paramView.mobileCode;; paramAdapterView = paramView.uin)
        {
          paramView = paramView.name;
          break;
        }
        localObject = (SelectMemberInnerFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
        if ((this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 6) || (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) || (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 5)) {
          if ((localIContactSearchable instanceof SearchableDiscussionMember)) {
            this.a.c.add(this.a.a(paramAdapterView, paramView, 2, ((DiscussionMemberInfo)localIContactSearchable.a()).discussionUin));
          }
        }
        for (;;)
        {
          this.a.c();
          ((SelectMemberInnerFrame)localObject).f();
          this.a.a(true);
          this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
          return;
          if ((localIContactSearchable instanceof ContactSearchableFriend)) {
            this.a.c.add(this.a.a(paramAdapterView, paramView, 0, "-1"));
          } else if ((localIContactSearchable instanceof ContactsSearchablePhoneContact)) {
            if (paramAdapterView.startsWith("+"))
            {
              this.a.c.add(this.a.a(paramAdapterView, paramView, 4, "-1"));
            }
            else
            {
              this.a.c.add(this.a.a(paramAdapterView, paramView, 0, "-1"));
              continue;
              if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 8) {
                this.a.c.add(this.a.a(paramAdapterView, paramView, 1, ((SelectMemberInnerFrame)localObject).a()));
              } else if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 9) {
                this.a.c.add(this.a.a(paramAdapterView, paramView, 2, ((SelectMemberInnerFrame)localObject).a()));
              } else if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 2) {
                if (paramAdapterView.startsWith("+")) {
                  this.a.c.add(this.a.a(paramAdapterView, paramView, 4, ((SelectMemberInnerFrame)localObject).a()));
                } else {
                  this.a.c.add(this.a.a(paramAdapterView, paramView, 0, ((SelectMemberInnerFrame)localObject).a()));
                }
              }
            }
          }
        }
      }
      paramAdapterView = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmi
 * JD-Core Version:    0.7.0.1
 */