import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahmk
  extends ahgq
{
  boolean chw = false;
  
  public ahmk(Intent paramIntent)
  {
    super(paramIntent);
    this.cgP = true;
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if ((this.e != null) && (this.e.isShowing())) {
      return;
    }
    ahml localahml = new ahml(this);
    paramInt = paramBundle.getInt("uintype");
    String str1 = paramBundle.getString("troop_uin");
    String str2 = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("uinname");
    if ((paramInt == 0) || (paramInt == 1004)) {
      ChatActivityUtils.a(this.app, this.mActivity, paramInt, str2, paramBundle, "", true, str1, true, true, localahml, "from_internal");
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "10", "", "", "");
      return;
      if (paramInt == 1006) {
        ChatActivityUtils.a(this.app, this.mActivity, paramInt, "0", paramBundle, str2, true, str1, true, true, localahml, "from_internal");
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
        if ((localRecentUser.getType() == 0) && (!aqft.ri(localRecentUser.uin)) && (!aqft.rk(localRecentUser.uin)) && (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType())))
        {
          if ((localacff != null) && (localacff.isFriend(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.getType() == 1006) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.cgP))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean anj()
  {
    super.anj();
    this.chw = this.mIntent.getBooleanExtra("fromWebXman", false);
    return true;
  }
  
  public void cph()
  {
    anot.a(this.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "2", "", "", "");
    if (this.chw) {
      anot.a(this.app, "CliOper", "", "", "0X8004D9C", "0X8004D9C", 0, 0, "", "", "", "");
    }
  }
  
  protected void dnr()
  {
    if (anx()) {
      this.cs.add(S);
    }
    this.cs.add(Z);
    if (anu()) {
      this.cs.add(Y);
    }
  }
  
  public void dnx()
  {
    anot.a(this.app, "CliOper", "", "", "Two_call", "Tc_msg_search", 0, 0, "", "", "", "");
  }
  
  public String getTitle()
  {
    return acfp.m(2131706562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmk
 * JD-Core Version:    0.7.0.1
 */