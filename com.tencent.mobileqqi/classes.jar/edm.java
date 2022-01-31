import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.voip.VoipDetailActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.ContactSearchableDiscussion;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.ContactSearchablePublicAccount;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.ContactSearchableTroop;
import com.tencent.mobileqq.search.ContactsSearchableCircleBuddy;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.search.SearchableDiscussionMember;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class edm
  implements AdapterView.OnItemClickListener
{
  public edm(SearchResultDialog paramSearchResultDialog) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = null;
    if (paramAdapterView == SearchResultDialog.a(this.a)) {
      if (SearchResultDialog.a(this.a) != null) {}
    }
    label849:
    label1890:
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
              ProfileActivity.a(SearchResultDialog.a(this.a), paramAdapterView);
              this.a.dismiss();
              this.a.a(paramView.displayName, paramView.uin, paramView.troopUin, paramView.type);
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
          paramAdapterView.j = paramView.displayName;
          break;
          paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 71);
          paramAdapterView.m = paramView.displayName;
          break;
          paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 71);
          paramAdapterView.c = paramView.troopUin;
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
            localObject = (IContactSearchable)SearchResultDialog.a(this.a).getItem(paramInt);
          }
        }
        else if (localObject != null)
        {
          if ((12 == SearchResultDialog.a(this.a)) && ((localObject instanceof ContactSearchableFriend)))
          {
            paramView = ((ContactSearchableFriend)localObject).a();
            paramAdapterView = new Intent();
            paramAdapterView.putExtra("extra_choose_friend_uin", paramView.uin);
            paramAdapterView.putExtra("extra_choose_friend_name", paramView.name);
            paramView = (Activity)SearchResultDialog.a(this.a);
            paramView.setResult(-1, paramAdapterView);
            paramView.finish();
            this.a.dismiss();
            return;
          }
          String str;
          if ((SearchResultDialog.a(this.a) == 7) || (SearchResultDialog.a(this.a) == 8) || (SearchResultDialog.a(this.a) == 9) || (SearchResultDialog.a(this.a) == 6) || (SearchResultDialog.a(this.a) == 10) || (SearchResultDialog.a(this.a) == 11) || (SearchResultDialog.a(this.a) == 15) || (SearchResultDialog.a(this.a) == 14))
          {
            paramAdapterView = (TextView)paramView.findViewById(2131231411);
            if (paramAdapterView != null)
            {
              str = paramAdapterView.getText().toString();
              if (!(localObject instanceof ContactSearchableFriend)) {
                break label849;
              }
              paramView = ((ContactSearchableFriend)localObject).a().uin;
              paramInt = 0;
              paramAdapterView = paramView;
            }
          }
          for (;;)
          {
            if (StringUtil.b(paramView)) {
              break label1890;
            }
            SearchResultDialog.a(this.a).a(paramView, paramInt, paramAdapterView, str);
            SearchResultDialog.a(SearchResultDialog.a(this.a), SearchResultDialog.b(this.a));
            this.a.a(str, paramView, paramAdapterView, paramInt);
            int i = this.a.b(SearchResultDialog.a(this.a));
            ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Search", "Search_into_AIO", i, 0, String.valueOf(this.a.a(paramInt)), String.valueOf(i), "", "");
            if (SearchResultDialog.a(this.a).u == 13) {
              ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Two_call", "Tc_msg_search", 0, 0, "", "", "", "");
            }
            this.a.dismiss();
            return;
            str = "";
            break;
            if ((localObject instanceof ContactSearchableTroop))
            {
              paramView = ((ContactSearchableTroop)localObject).a().troopuin;
              paramInt = 1;
              paramAdapterView = paramView;
            }
            else if ((localObject instanceof ContactSearchableDiscussion))
            {
              paramView = ((ContactSearchableDiscussion)localObject).a().uin;
              paramInt = 3000;
              paramAdapterView = paramView;
            }
            else if ((localObject instanceof ContactsSearchableRecentUser))
            {
              RecentUser localRecentUser = ((ContactsSearchableRecentUser)localObject).a();
              localObject = localRecentUser.uin;
              paramAdapterView = localRecentUser.troopUin;
              paramView = (TextView)paramView.findViewById(16908308);
              if (paramView != null) {
                str = paramView.getText().toString();
              }
              paramInt = localRecentUser.type;
              paramView = (View)localObject;
            }
            else
            {
              if ((localObject instanceof ContactsSearchablePhoneContact))
              {
                paramAdapterView = ((ContactsSearchablePhoneContact)localObject).a();
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
              if ((localObject instanceof SearchableDiscussionMember))
              {
                paramAdapterView = (DiscussionMemberInfo)((SearchableDiscussionMember)localObject).a();
                paramView = paramAdapterView.memberUin;
                paramAdapterView = paramAdapterView.discussionUin;
                paramInt = 1004;
              }
              else if ((localObject instanceof ContactsSearchableCircleBuddy))
              {
                paramAdapterView = ((ContactsSearchableCircleBuddy)localObject).a();
                paramView = paramAdapterView.uin;
                paramAdapterView = paramAdapterView.uin;
                ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Network_circle", "Search_circle_clk", 83, 0, "", "", "", "");
                paramInt = 1021;
                continue;
                if ((localObject instanceof ContactSearchableFriend))
                {
                  paramAdapterView = ((ContactSearchableFriend)localObject).a();
                  this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.uin, 0, ContactUtils.a(paramAdapterView));
                }
                do
                {
                  for (;;)
                  {
                    SearchResultDialog.a(SearchResultDialog.a(this.a), SearchResultDialog.b(this.a));
                    return;
                    if ((localObject instanceof ContactSearchableTroop))
                    {
                      paramAdapterView = ((ContactSearchableTroop)localObject).a();
                      this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.troopuin, 1, paramAdapterView.troopname, paramAdapterView.troopcode);
                    }
                    else if ((localObject instanceof ContactSearchableDiscussion))
                    {
                      paramAdapterView = ((ContactSearchableDiscussion)localObject).a();
                      this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.uin, 3000, paramAdapterView.discussionName);
                    }
                    else if ((localObject instanceof SearchableDiscussionMember))
                    {
                      paramAdapterView = (DiscussionMemberInfo)((SearchableDiscussionMember)localObject).a();
                      this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.memberUin, 1004, paramAdapterView.inteRemark, paramAdapterView.discussionUin);
                    }
                    else if ((localObject instanceof ContactSearchablePublicAccount))
                    {
                      paramAdapterView = (PublicAccountInfo)((IContactSearchable)localObject).a();
                      this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), String.valueOf(paramAdapterView.uin), 1008, paramAdapterView.name);
                    }
                    else if ((localObject instanceof ContactsSearchableRecentUser))
                    {
                      if (SearchResultDialog.b(this.a) != null)
                      {
                        com.tencent.mobileqq.activity.recent.RecentUtil.a = true;
                        SearchResultDialog.b(this.a).a(paramAdapterView, paramView, paramInt, paramLong);
                        this.a.dismiss();
                      }
                    }
                    else
                    {
                      if (!(localObject instanceof ContactsSearchablePhoneContact)) {
                        break;
                      }
                      paramAdapterView = ((ContactsSearchablePhoneContact)localObject).a();
                      paramView = new Intent(SearchResultDialog.a(this.a), VoipDetailActivity.class);
                      paramView.putExtra("contactId", paramAdapterView.lookupID);
                      paramView.putExtra("source", "voipAddressBookActivity");
                      SearchResultDialog.a(this.a).startActivity(paramView);
                    }
                  }
                } while (!(localObject instanceof ContactsSearchableCircleBuddy));
                paramAdapterView = (CircleBuddy)((IContactSearchable)localObject).a();
                if (SearchResultDialog.a(this.a) == 4)
                {
                  paramView = new Intent(SearchResultDialog.a(this.a), ChatActivity.class);
                  paramView.putExtra("uin", paramAdapterView.uin);
                  paramView.putExtra("uinname", SearchResultDialog.a(this.a).a(paramAdapterView));
                  paramView.putExtra("uintype", 1021);
                  SearchResultDialog.a(this.a).startActivity(paramView);
                }
                for (;;)
                {
                  if (SearchResultDialog.a(this.a) != null) {
                    this.a.a(SearchResultDialog.a(this.a).a(paramAdapterView.uin), paramAdapterView.uin, "", 1021);
                  }
                  if (SearchResultDialog.a(this.a) != 13) {
                    break label1801;
                  }
                  ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "P_prof", "Prof_in_client", 84, 0, "", "", "", "");
                  this.a.dismiss();
                  break;
                  paramView = new ProfileActivity.AllInOne(paramAdapterView.uin, 71);
                  paramView.m = paramAdapterView.remark;
                  paramView.g = paramAdapterView.nickName;
                  paramView.f = 84;
                  ProfileActivity.a(SearchResultDialog.a(this.a), paramView);
                }
                paramInt = 0;
                switch (SearchResultDialog.a(this.a))
                {
                }
                for (;;)
                {
                  ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Network_circle", "Search_circle_clk", paramInt, 0, "", "", "", "");
                  break;
                  paramInt = 81;
                  continue;
                  paramInt = 59;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     edm
 * JD-Core Version:    0.7.0.1
 */