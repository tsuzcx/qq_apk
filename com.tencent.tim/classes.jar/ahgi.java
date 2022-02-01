import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahgi
  extends ahgq
{
  public ahgi(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if ((this.e != null) && (this.e.isShowing())) {
      return;
    }
    this.bf.putString("uin", paramBundle.getString("uin"));
    this.bf.putInt("uintype", paramBundle.getInt("uintype"));
    this.bf.putBoolean("apollo_forward_key", true);
    this.bf.putBoolean("isBack2Root", true);
    this.mIntent = new Intent(this.mActivity, SplashActivity.class);
    this.mIntent = wja.a(this.mIntent, new int[] { 2 });
    this.mIntent.putExtras(this.bf);
    this.mActivity.startActivity(this.mIntent);
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public boolean anj()
  {
    super.anj();
    return true;
  }
  
  protected void dnr()
  {
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
  }
  
  public void dnt()
  {
    super.dnt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahgi
 * JD-Core Version:    0.7.0.1
 */