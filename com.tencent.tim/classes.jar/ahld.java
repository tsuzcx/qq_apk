import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahld
  extends ahgq
{
  public ahld(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if ((this.e != null) && (this.e.isShowing())) {
      return;
    }
    if (this.mIntent.getIntExtra("openAIOForPtt", 0) != 1)
    {
      am(2131696693);
      long l = this.mIntent.getLongExtra("appid", -1L);
      localObject = this.mActivity;
      QQAppInterface localQQAppInterface = this.app;
      String str = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("uintype");
      UiApiPlugin.a((Activity)localObject, localQQAppInterface, l, new String[] { str }, new int[] { paramInt });
      return;
    }
    Object localObject = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
    this.bf.putString("uin", paramBundle.getString("uin"));
    this.bf.putInt("uintype", paramBundle.getInt("uintype"));
    this.bf.putString("uinname", paramBundle.getString("uinname"));
    ((Intent)localObject).putExtras(this.bf);
    ((Intent)localObject).putExtra("open_chat_from_voice_changer_guide", true);
    this.mActivity.startActivity((Intent)localObject);
    this.mActivity.finish();
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (((!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() == 0) && (e(S))) || ((localRecentUser.getType() == 1) && (!kj(localRecentUser.uin)) && (e(T))) || ((localRecentUser.getType() == 1006) && (e(ahgg.a.Y))) || ((localRecentUser.getType() == 3000) && (e(U))))) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.cgP)))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void dnr()
  {
    int i = this.mIntent.getIntExtra("acceptType", 13);
    if (((i & 0x1) != 0) && (anx())) {
      this.cs.add(S);
    }
    if (((i & 0x4) != 0) && (anw())) {
      this.cs.add(T);
    }
    if (((i & 0x8) != 0) && (anv())) {
      this.cs.add(U);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahld
 * JD-Core Version:    0.7.0.1
 */