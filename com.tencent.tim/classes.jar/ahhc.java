import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahhc
  extends ahgq
{
  int EP = 0;
  int bGQ = 0;
  private String bKz;
  protected ResultReceiver p;
  
  public ahhc(Intent paramIntent)
  {
    super(paramIntent);
    this.cgP = true;
    this.EP = paramIntent.getIntExtra("choose_friend_businessType", 0);
    this.bGQ = paramIntent.getIntExtra("choose_friend_businessSubType", 0);
  }
  
  private boolean anB()
  {
    return (this.EP == 1) && (this.bGQ == 1);
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if (anB())
    {
      super.H(paramInt, paramBundle);
      anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.list", 0, 0, "", "", "", "");
      anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerconfirmpage.show", 0, 0, "", "", "", "");
    }
    label271:
    label297:
    do
    {
      do
      {
        return;
        if ((this.EP == 1) && (this.bGQ == 2)) {
          anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.list", 0, 0, "", "", "", "");
        }
      } while ((this.e != null) && (this.e.isShowing()));
      boolean bool;
      String str3;
      String str2;
      String str1;
      String str4;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("choose_friend_needConfirm");
        if (!bool) {
          break label297;
        }
        str3 = paramBundle.getString("choose_friend_confirmTitle");
        str2 = paramBundle.getString("choose_friend_confirmContent");
        str1 = str2;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (str2.contains("[nick]"))
          {
            str4 = paramBundle.getString("uin");
            str1 = paramBundle.getString("uinname");
            if (TextUtils.isEmpty(str1)) {
              break label271;
            }
            str1 = str2.replace("[nick]", str1);
          }
        }
      }
      for (;;)
      {
        aqha.a(this.mActivity, 230, str3, str1, acfp.m(2131706450), acfp.m(2131706448), new ahhd(this, paramInt, paramBundle), new ahhe(this)).show();
        return;
        bool = false;
        break;
        str1 = str2;
        if (!TextUtils.isEmpty(str4)) {
          str1 = str2.replace("[nick]", str4);
        }
      }
      if (this.p != null)
      {
        paramBundle = a(paramInt, paramBundle);
        this.p.send(0, paramBundle);
      }
    } while (this.mActivity == null);
    this.mActivity.setResult(1);
    this.mActivity.finish();
  }
  
  protected Bundle a(int paramInt, Bundle paramBundle)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList6 = new ArrayList();
    ArrayList localArrayList7 = new ArrayList();
    int j;
    if (paramBundle != null)
    {
      j = paramBundle.getInt("uintype", -1);
      if ((j != 0) && (j != 1004)) {
        break label195;
      }
      localArrayList1.add(paramBundle.getString("uin"));
      localArrayList2.add("");
      localArrayList3.add(paramBundle.getString("uinname"));
    }
    label195:
    Object localObject;
    String str;
    int i;
    do
    {
      do
      {
        for (;;)
        {
          paramBundle = new Bundle();
          paramBundle.putStringArrayList("choose_friend_uins", localArrayList1);
          paramBundle.putStringArrayList("choose_friend_phones", localArrayList2);
          paramBundle.putStringArrayList("choose_friend_names", localArrayList3);
          if (localArrayList4.size() > 0)
          {
            paramBundle.putStringArrayList("choose_friend_group_uins", localArrayList4);
            paramBundle.putStringArrayList("choose_friend_group_names", localArrayList5);
            paramBundle.putIntegerArrayList("choose_friend_group_counts", localArrayList6);
            paramBundle.putIntegerArrayList("choose_friend_group_types", localArrayList7);
          }
          return paramBundle;
          if (j != 1006) {
            break;
          }
          localArrayList1.add("");
          localArrayList2.add(paramBundle.getString("uin"));
          localArrayList3.add(paramBundle.getString("uinname"));
        }
      } while ((j != 3000) && (j != 1));
      localObject = paramBundle.getString("uinname");
      str = paramBundle.getString("uin");
      i = 0;
    } while (TextUtils.isEmpty(str));
    if (j == 1)
    {
      localArrayList7.add(Integer.valueOf(4));
      paramBundle = (TroopManager)this.app.getManager(52);
      if (paramBundle == null) {
        break label446;
      }
      paramBundle = paramBundle.c(str);
      if (paramBundle == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = paramBundle.wMemberNum;; paramInt = 0)
    {
      paramBundle = (Bundle)localObject;
      for (;;)
      {
        localArrayList4.add(str);
        localObject = paramBundle;
        if (paramBundle == null) {
          localObject = "";
        }
        localArrayList5.add(localObject);
        localArrayList6.add(Integer.valueOf(paramInt));
        break;
        paramInt = i;
        if (j == 3000)
        {
          localArrayList7.add(Integer.valueOf(8));
          paramBundle = (acdu)this.app.getManager(53);
          paramInt = i;
          if (paramBundle != null)
          {
            i = paramBundle.cn(str);
            paramBundle = paramBundle.a(str);
            paramInt = i;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.discussionName;
              paramInt = i;
              continue;
            }
          }
        }
        paramBundle = (Bundle)localObject;
      }
    }
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    acff localacff = (acff)this.app.getManager(51);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 8001) && (localRecentUser.getType() != 7000)) {
        if ((localRecentUser.getType() == 0) && (!aqft.ri(localRecentUser.uin)) && (!aqft.rk(localRecentUser.uin)) && (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType())) && (e(S)))
        {
          if ((localacff != null) && (localacff.isFriend(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.getType() == 1006) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.cgP)))
        {
          if (e(S)) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (((localRecentUser.getType() == 1) && (e(T))) || ((localRecentUser.getType() == 3000) && (e(U)))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean anj()
  {
    super.anj();
    this.p = ((ResultReceiver)this.mIntent.getParcelableExtra("choose_friend_callback"));
    return true;
  }
  
  protected void dnr()
  {
    boolean bool1 = this.mIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
    boolean bool2 = this.mIntent.getBooleanExtra("choose_friend_is_contacts", false);
    boolean bool3 = this.mIntent.getBooleanExtra("choose_friend_is_groupchats", false);
    boolean bool4 = this.mIntent.getBooleanExtra("choose_friend_is_create_group_chat", false);
    if ((bool1) && (anx()))
    {
      this.cs.add(S);
      if ((!bool2) || (!anu())) {
        break label175;
      }
      this.cs.add(Y);
      label97:
      if (!bool3) {
        break label191;
      }
      this.cs.add(T);
      this.cs.add(U);
      label127:
      if (!bool4) {
        break label220;
      }
      this.cs.remove(ac);
    }
    for (;;)
    {
      this.cs.add(Z);
      return;
      this.cs.remove(S);
      break;
      label175:
      this.cs.remove(Y);
      break label97;
      label191:
      this.cs.remove(T);
      this.cs.remove(U);
      break label127;
      label220:
      this.cs.add(ac);
    }
  }
  
  protected void dnv()
  {
    String str = this.e.getEditString();
    this.bf.putString("emsg", str);
    if ((this.EP <= 0) || (this.p == null)) {}
    do
    {
      do
      {
        return;
        Object localObject = a(ahgg.a.R.intValue(), this.bf);
        ((Bundle)localObject).putString("emsg", str);
        this.p.send(0, (Bundle)localObject);
        if ((this.bGQ > 0) && (this.mActivity != null))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtras(this.bf);
          this.mActivity.setResult(-1, (Intent)localObject);
          this.mActivity.finish();
        }
      } while (!anB());
      anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "editsay.button", 0, 0, "", "", "", "");
    } while ((TextUtils.isEmpty(str)) || (str.equals(this.bKz)));
    anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerconfirmpage.send", 0, 0, "", "", "", "");
  }
  
  public String getTitle()
  {
    String str2 = this.mIntent.getStringExtra("choose_friend_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = acfp.m(2131706452);
    }
    return str1;
  }
  
  public String wn()
  {
    if (anB())
    {
      String str2 = this.mIntent.getStringExtra("choose_friend_dialog_sub_title");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = acfp.m(2131706449);
      }
      return str1;
    }
    return super.wn();
  }
  
  protected String wp()
  {
    if (anB())
    {
      String str2 = this.mIntent.getStringExtra("choose_friend_dialog_input");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "给TA留言";
      }
      this.bKz = str1;
      return str1;
    }
    return super.wp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhc
 * JD-Core Version:    0.7.0.1
 */