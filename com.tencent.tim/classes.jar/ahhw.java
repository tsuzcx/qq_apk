import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahhw
  extends ahgq
{
  protected ResultReceiver p;
  
  public ahhw(Intent paramIntent)
  {
    super(paramIntent);
    this.cgP = true;
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if ((this.e != null) && (this.e.isShowing())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    paramInt = paramBundle.getInt("uintype", -1);
    if ((paramInt == 0) || (paramInt == 1004))
    {
      localArrayList1.add(paramBundle.getString("uin"));
      localArrayList2.add("");
      localArrayList3.add(paramBundle.getString("uinname"));
      localArrayList4.add("1");
    }
    for (;;)
    {
      if (this.p != null)
      {
        paramBundle = new Bundle();
        paramBundle.putStringArrayList("choose_friend_uins", localArrayList1);
        paramBundle.putStringArrayList("choose_friend_phones", localArrayList2);
        paramBundle.putStringArrayList("choose_friend_names", localArrayList3);
        paramBundle.putStringArrayList("choose_friend_types", localArrayList4);
        this.p.send(0, paramBundle);
      }
      if (this.mActivity == null) {
        break;
      }
      this.mActivity.setResult(1);
      this.mActivity.finish();
      return;
      if (paramInt == 1006)
      {
        localArrayList1.add("");
        localArrayList2.add(paramBundle.getString("uin"));
        localArrayList3.add(paramBundle.getString("uinname"));
        localArrayList4.add("2");
      }
      else if (paramInt == 1)
      {
        localArrayList1.add(paramBundle.getString("uin"));
        localArrayList2.add("");
        localArrayList3.add(paramBundle.getString("uinname"));
        localArrayList4.add("4");
      }
      else if (paramInt == 3000)
      {
        localArrayList1.add(paramBundle.getString("uin"));
        localArrayList2.add("");
        localArrayList3.add(paramBundle.getString("uinname"));
        localArrayList4.add("8");
      }
    }
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    acff localacff = (acff)this.app.getManager(51);
    int i = this.mIntent.getIntExtra("choose_friend_h5_type", 0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 8001) && (localRecentUser.getType() != 7000)) {
        if ((localRecentUser.getType() == 0) && (!aqft.ri(localRecentUser.uin)) && (!aqft.rk(localRecentUser.uin)) && (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType())))
        {
          if ((localacff != null) && (localacff.isFriend(localRecentUser.uin)) && ((i == 1) || (i == 13))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (localRecentUser.getType() == 1)
        {
          if ((i == 4) || (i == 13) || (i == 12)) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.getType() == 3000) && ((i == 8) || (i == 13) || (i == 12))) {
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
    this.mIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
    this.mIntent.getBooleanExtra("choose_friend_is_contacts", false);
    int i = this.mIntent.getIntExtra("choose_friend_h5_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("h5ptv", 2, "bType=" + i);
    }
    if ((i == 1) && (anx())) {
      this.cs.add(S);
    }
    if (i == 4) {
      this.cs.add(T);
    }
    if (i == 8) {
      this.cs.add(U);
    }
    if (i == 13)
    {
      this.cs.add(S);
      this.cs.add(T);
      this.cs.add(U);
    }
    if (i == 12)
    {
      this.cs.add(T);
      this.cs.add(U);
    }
  }
  
  public String getTitle()
  {
    String str2 = this.mIntent.getStringExtra("choose_friend_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = acfp.m(2131706469);
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhw
 * JD-Core Version:    0.7.0.1
 */