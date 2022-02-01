import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.ArrayList;
import java.util.Map;

class amjt
  implements AdapterView.c
{
  amjt(amjp paramamjp) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    aqfp.Sz(true);
    SearchHistory localSearchHistory;
    label270:
    int i;
    if ((paramAdapterView == this.this$0.R) && (this.this$0.a != null))
    {
      amxk.b("home_page", "clk_history", new String[] { "" + paramInt });
      paramAdapterView = (amjz)this.this$0.a.getItem(paramInt);
      if (!(paramAdapterView instanceof amjl)) {
        break label1238;
      }
      localSearchHistory = ((amjl)paramAdapterView).a();
      QLog.d("searchUtils", 2, "on serarch history click, " + localSearchHistory.toString());
      switch (localSearchHistory.type)
      {
      default: 
        paramInt = 1;
        if (paramInt != 0)
        {
          amxk.d(amjp.a(this.this$0), localSearchHistory.displayName, localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type);
          if (localSearchHistory.type != 1) {
            break label1163;
          }
          i = 2;
        }
        break;
      }
    }
    for (;;)
    {
      label316:
      paramInt = 0;
      if (this.this$0.fromType == 2)
      {
        paramInt = 3;
        label331:
        anot.a(null, "CliOper", "", "", "Search", "May_find", paramInt, 0, String.valueOf(i), "", "", "");
        if (localSearchHistory.type != 0) {
          break label1213;
        }
        paramInt = 1;
      }
      for (;;)
      {
        amub.a(amjp.a(this.this$0), 0, SearchEntryFragment.jf(this.this$0.bms), "0X8009D19", paramInt, 0, null, null);
        return;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 29);
        paramAdapterView.contactName = localSearchHistory.displayName;
        paramAdapterView.bIZ = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label270;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 34);
        paramAdapterView.contactName = localSearchHistory.displayName;
        paramAdapterView.bIZ = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label270;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 53);
        paramAdapterView.contactName = localSearchHistory.displayName;
        paramAdapterView.bIZ = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label270;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 53);
        paramAdapterView.contactName = localSearchHistory.displayName;
        paramAdapterView.bIZ = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label270;
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localSearchHistory.uin, 33);
        localAllInOne.pr = new ArrayList();
        localAllInOne.contactName = localSearchHistory.displayName;
        if (!TextUtils.isEmpty(localSearchHistory.uin))
        {
          String[] arrayOfString = localSearchHistory.uin.split("\\|");
          if (arrayOfString != null)
          {
            paramInt = 0;
            if (paramInt < arrayOfString.length)
            {
              ArrayList localArrayList = localAllInOne.pr;
              StringBuilder localStringBuilder = new StringBuilder().append(acfp.m(2131707158));
              if (arrayOfString.length > 0) {}
              for (paramAdapterView = Integer.valueOf(paramInt + 1);; paramAdapterView = "")
              {
                localArrayList.add(new ProfileActivity.CardContactInfo(paramAdapterView, arrayOfString[paramInt], null));
                paramInt += 1;
                break;
              }
            }
          }
        }
        localAllInOne.bIZ = 3;
        ProfileActivity.b(paramView.getContext(), localAllInOne);
        paramInt = 1;
        break label270;
        paramAdapterView = (acff)amjp.a(this.this$0).getManager(51);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.e(localSearchHistory.uin);
          if (paramAdapterView != null)
          {
            aalb.bwg = true;
            aalb.a(paramView.getContext(), amjp.a(this.this$0), localSearchHistory.uin, 0, aqgv.c(paramAdapterView), false);
          }
          paramInt = 1;
          break label270;
        }
        paramInt = 0;
        break label270;
        paramAdapterView = (acdu)amjp.a(this.this$0).getManager(53);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.n(localSearchHistory.troopUin);
          if (paramAdapterView != null)
          {
            paramAdapterView = (DiscussionMemberInfo)paramAdapterView.get(localSearchHistory.uin);
            if (paramAdapterView != null)
            {
              aalb.bwg = true;
              aalb.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, paramAdapterView.memberName, false);
              paramInt = 1;
              break label270;
            }
          }
        }
        aalb.bwg = true;
        aalb.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label270;
        aalb.bwg = true;
        boolean bool = false;
        if ((paramView.getContext() instanceof UniteSearchActivity)) {
          bool = amkl.gM(localSearchHistory.uin);
        }
        if (!bool)
        {
          aalb.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false);
          paramInt = 1;
          break label270;
        }
        aprg.H(paramView.getContext(), null, localSearchHistory.uin);
        paramInt = 1;
        break label270;
        aalb.bwg = true;
        aalb.a(paramView.getContext(), amjp.a(this.this$0), localSearchHistory.uin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label270;
        if (!TextUtils.equals(localSearchHistory.uin, acbn.blw)) {
          break;
        }
        kbp.a(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
        kgw.a(paramView.getContext(), null, -1L, 1);
        paramInt = 1;
        break label270;
        kbp.a(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
        kgw.b(amjp.a(this.this$0), paramView.getContext(), 1, 0);
        break;
        label1163:
        if (localSearchHistory.type != 3000) {
          break label1243;
        }
        i = 3;
        break label316;
        if (this.this$0.fromType == 10)
        {
          paramInt = 2;
          break label331;
        }
        if (this.this$0.fromType != 1) {
          break label331;
        }
        paramInt = 1;
        break label331;
        label1213:
        if ((localSearchHistory.type == 1) || (localSearchHistory.type == 3000)) {
          paramInt = 2;
        } else {
          label1238:
          paramInt = 0;
        }
      }
      label1243:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjt
 * JD-Core Version:    0.7.0.1
 */