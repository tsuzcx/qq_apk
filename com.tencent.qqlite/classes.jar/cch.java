import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.search.ContactSearchableDiscussion;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.ContactSearchableTroop;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.search.SearchableDiscussionMember;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class cch
  implements AdapterView.OnItemClickListener
{
  public cch(SearchResultDialog paramSearchResultDialog) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ThreadPriorityManager.a(true);
    Object localObject2 = null;
    if (paramAdapterView == SearchResultDialog.a(this.a)) {
      if (SearchResultDialog.a(this.a) != null) {}
    }
    label836:
    label2016:
    for (;;)
    {
      return;
      paramAdapterView = (IContactSearchable)SearchResultDialog.a(this.a).getItem(paramInt);
      if ((paramAdapterView instanceof ContactSearchableSearchHistory))
      {
        paramView = ((ContactSearchableSearchHistory)paramAdapterView).a();
        if (SearchResultDialog.a(this.a) == 0)
        {
          paramAdapterView = null;
          switch (paramView.type)
          {
          default: 
            if (paramAdapterView != null)
            {
              ProfileActivity.b(SearchResultDialog.a(this.a), paramAdapterView);
              this.a.dismiss();
              this.a.a(paramView.displayName, paramView.uin, paramView.troopUin, paramView.type);
              paramAdapterView = (FriendManager)SearchResultDialog.a(this.a).getManager(8);
              if (paramAdapterView != null)
              {
                paramAdapterView = paramAdapterView.c(paramView.uin);
                if ((paramAdapterView != null) && (paramAdapterView.gathtertype == 1)) {
                  ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "0X8004C58", "0X8004C58", 1, 0, "", "", "", "");
                }
              }
            }
            break;
          }
        }
        for (;;)
        {
          ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Search", "May_find", this.a.b(SearchResultDialog.a(this.a)), 0, "", "", "", "");
          return;
          paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 1);
          break;
          paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 31);
          paramAdapterView.a = new ArrayList();
          paramAdapterView.k = paramView.displayName;
          break;
          paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 47);
          paramAdapterView.jdField_d_of_type_JavaLangString = paramView.troopUin;
          break;
          this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramView.uin, paramView.type, paramView.displayName, paramView.troopUin);
          continue;
          if (4 == SearchResultDialog.a(this.a)) {
            this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramView.uin, paramView.type, paramView.displayName, paramView.troopUin);
          }
        }
        if (paramAdapterView == SearchResultDialog.b(this.a))
        {
          if (SearchResultDialog.a(this.a) != null) {
            localObject2 = (IContactSearchable)SearchResultDialog.a(this.a).getItem(paramInt);
          }
        }
        else if (localObject2 != null)
        {
          if ((12 == SearchResultDialog.a(this.a)) && ((localObject2 instanceof ContactSearchableFriend)))
          {
            paramView = ((ContactSearchableFriend)localObject2).a();
            paramAdapterView = new Intent();
            paramAdapterView.putExtra("extra_choose_friend_uin", paramView.uin);
            paramAdapterView.putExtra("extra_choose_friend_name", paramView.name);
            paramView = (Activity)SearchResultDialog.a(this.a);
            paramView.setResult(-1, paramAdapterView);
            paramView.finish();
            this.a.dismiss();
            return;
          }
          Object localObject1;
          if ((SearchResultDialog.a(this.a) == 7) || (SearchResultDialog.a(this.a) == 8) || (SearchResultDialog.a(this.a) == 9) || (SearchResultDialog.a(this.a) == 6) || (SearchResultDialog.a(this.a) == 10) || (SearchResultDialog.a(this.a) == 11) || (SearchResultDialog.a(this.a) == 14))
          {
            paramAdapterView = (TextView)paramView.findViewById(2131296876);
            if (paramAdapterView != null)
            {
              localObject1 = paramAdapterView.getText().toString();
              if (!(localObject2 instanceof ContactSearchableFriend)) {
                break label836;
              }
              paramView = ((ContactSearchableFriend)localObject2).a().uin;
              paramInt = 0;
              paramAdapterView = paramView;
            }
          }
          for (;;)
          {
            if (StringUtil.b(paramView)) {
              break label2016;
            }
            SearchResultDialog.a(this.a).a(paramView, paramInt, paramAdapterView, (String)localObject1);
            SearchResultDialog.a(SearchResultDialog.a(this.a), SearchResultDialog.b(this.a));
            this.a.a((String)localObject1, paramView, paramAdapterView, paramInt);
            int i = this.a.b(SearchResultDialog.a(this.a));
            ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Search", "Search_into_AIO", i, 0, String.valueOf(this.a.a(paramInt)), String.valueOf(i), "", "");
            this.a.dismiss();
            return;
            localObject1 = "";
            break;
            if ((localObject2 instanceof ContactSearchableTroop))
            {
              paramView = ((ContactSearchableTroop)localObject2).a().troopuin;
              paramInt = 1;
              paramAdapterView = paramView;
            }
            else if ((localObject2 instanceof ContactSearchableDiscussion))
            {
              paramView = ((ContactSearchableDiscussion)localObject2).a().uin;
              paramInt = 3000;
              paramAdapterView = paramView;
            }
            else
            {
              Object localObject3;
              if ((localObject2 instanceof ContactsSearchableRecentUser))
              {
                localObject3 = ((ContactsSearchableRecentUser)localObject2).a();
                localObject2 = ((RecentUser)localObject3).uin;
                paramAdapterView = ((RecentUser)localObject3).troopUin;
                paramView = (TextView)paramView.findViewById(16908308);
                if (paramView != null) {
                  localObject1 = paramView.getText().toString();
                }
                paramInt = ((RecentUser)localObject3).type;
                paramView = (View)localObject2;
              }
              else
              {
                if ((localObject2 instanceof ContactsSearchablePhoneContact))
                {
                  paramAdapterView = ((ContactsSearchablePhoneContact)localObject2).a();
                  if (paramAdapterView.uin.equals("0")) {
                    paramView = paramAdapterView.nationCode + paramAdapterView.mobileCode;
                  }
                  for (paramInt = 1006;; paramInt = 0)
                  {
                    paramAdapterView = "";
                    break;
                    paramView = paramAdapterView.uin;
                  }
                }
                if ((localObject2 instanceof SearchableDiscussionMember))
                {
                  paramAdapterView = (DiscussionMemberInfo)((SearchableDiscussionMember)localObject2).a();
                  paramView = paramAdapterView.memberUin;
                  paramAdapterView = paramAdapterView.discussionUin;
                  paramInt = 1004;
                  continue;
                  if ((localObject2 instanceof ContactSearchableFriend))
                  {
                    paramAdapterView = ((ContactSearchableFriend)localObject2).a();
                    this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.uin, 0, ContactUtils.a(paramAdapterView));
                  }
                  for (;;)
                  {
                    SearchResultDialog.a(SearchResultDialog.a(this.a), SearchResultDialog.b(this.a));
                    return;
                    if ((localObject2 instanceof ContactSearchableTroop))
                    {
                      paramAdapterView = ((ContactSearchableTroop)localObject2).a();
                      this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.troopuin, 1, paramAdapterView.troopname, paramAdapterView.troopcode);
                    }
                    else if ((localObject2 instanceof ContactSearchableDiscussion))
                    {
                      paramAdapterView = ((ContactSearchableDiscussion)localObject2).a();
                      this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.uin, 3000, paramAdapterView.discussionName);
                    }
                    else if ((localObject2 instanceof SearchableDiscussionMember))
                    {
                      paramAdapterView = (DiscussionMemberInfo)((SearchableDiscussionMember)localObject2).a();
                      this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.memberUin, 1004, paramAdapterView.inteRemark, paramAdapterView.discussionUin);
                    }
                    else if ((localObject2 instanceof ContactsSearchableRecentUser))
                    {
                      if (SearchResultDialog.b(this.a) != null)
                      {
                        com.tencent.mobileqq.activity.recent.RecentUtil.a = true;
                        SearchResultDialog.b(this.a).a(paramAdapterView, paramView, paramInt, paramLong);
                        this.a.dismiss();
                      }
                    }
                    else if ((localObject2 instanceof ContactsSearchablePhoneContact))
                    {
                      localObject1 = ((ContactsSearchablePhoneContact)localObject2).a();
                      if ((SearchResultDialog.a(this.a) != 0) && (SearchResultDialog.a(this.a) != 5) && (SearchResultDialog.a(this.a) != 15)) {
                        break label1922;
                      }
                      if (!TextUtils.isEmpty(((PhoneContact)localObject1).uin)) {
                        break;
                      }
                      paramView = new ProfileActivity.AllInOne(((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode, 33);
                      paramView.a = new ArrayList();
                      paramView.k = ((PhoneContact)localObject1).name;
                      paramView.h = ((PhoneContact)localObject1).nickName;
                      localObject2 = ((PhoneContact)localObject1).mobileNo.split("\\|");
                      paramInt = 0;
                      if (paramInt < localObject2.length)
                      {
                        localObject3 = paramView.a;
                        StringBuilder localStringBuilder = new StringBuilder().append("电话");
                        if (localObject2.length > 0) {}
                        for (paramAdapterView = Integer.valueOf(paramInt + 1);; paramAdapterView = "")
                        {
                          ((ArrayList)localObject3).add(new ProfileActivity.CardContactInfo(paramAdapterView, localObject2[paramInt], ((PhoneContact)localObject1).nationCode));
                          paramInt += 1;
                          break;
                        }
                      }
                      paramView.jdField_d_of_type_Int = ((PhoneContact)localObject1).ability;
                      paramView.f = 3;
                      paramAdapterView = paramView;
                      ProfileActivity.b(SearchResultDialog.a(this.a), paramAdapterView);
                      if (SearchResultDialog.a(this.a) != 15)
                      {
                        paramInt = this.a.b(SearchResultDialog.a(this.a));
                        ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Search", "Search_into_AIO", paramInt, 0, String.valueOf(this.a.a(1006)), String.valueOf(paramInt), "", "");
                      }
                      this.a.dismiss();
                    }
                  }
                  if (!((PhoneContact)localObject1).uin.equals("0"))
                  {
                    paramAdapterView = new ProfileActivity.AllInOne(((PhoneContact)localObject1).uin, 1);
                    if (!((PhoneContact)localObject1).uin.equals("0")) {
                      break label1911;
                    }
                    paramView = ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode;
                  }
                  for (paramInt = 1006;; paramInt = 0)
                  {
                    this.a.a(((PhoneContact)localObject1).name, paramView, "", paramInt);
                    break;
                    paramAdapterView = ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode;
                    if (((PhoneContact)localObject1).originBinder == 3L) {}
                    for (paramInt = 32;; paramInt = 31)
                    {
                      paramAdapterView = new ProfileActivity.AllInOne(paramAdapterView, paramInt);
                      paramAdapterView.a = new ArrayList();
                      paramAdapterView.h = ((PhoneContact)localObject1).nickName;
                      paramAdapterView.k = ((PhoneContact)localObject1).name;
                      paramAdapterView.a.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
                      paramAdapterView.jdField_d_of_type_Int = ((PhoneContact)localObject1).ability;
                      paramAdapterView.f = 3;
                      break;
                    }
                    label1911:
                    paramView = ((PhoneContact)localObject1).uin;
                  }
                  if (((PhoneContact)localObject1).uin.equals("0")) {
                    paramAdapterView = ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode;
                  }
                  for (paramInt = 1006;; paramInt = 0)
                  {
                    this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView, paramInt, ((PhoneContact)localObject1).name);
                    break;
                    paramAdapterView = ((PhoneContact)localObject1).uin;
                  }
                }
                else
                {
                  paramInt = -1;
                  paramAdapterView = null;
                  paramView = null;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cch
 * JD-Core Version:    0.7.0.1
 */