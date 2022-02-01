import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahgj
  extends ahgq
{
  public ahgj(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if ((this.e != null) && (this.e.isShowing())) {}
    label17:
    do
    {
      do
      {
        do
        {
          break label17;
          do
          {
            return;
          } while ((this.bf == null) || (paramBundle == null));
          if (QLog.isColorLevel()) {
            QLog.d("ForwardApolloGameMsgOption", 2, "[buildForwardDialig]extra:" + paramBundle.toString() + "mExtraData:" + this.bf.toString());
          }
          this.bf.putString("uin", paramBundle.getString("uin"));
          this.bf.putInt("uintype", paramBundle.getInt("uintype"));
          this.bf.putInt("share_result_key", 0);
          paramInt = this.bf.getInt("apollo.game.invite.from");
          if (paramInt != 4) {
            break;
          }
          localObject = new SessionInfo();
          ((SessionInfo)localObject).cZ = paramBundle.getInt("uintype");
          ((SessionInfo)localObject).aTl = paramBundle.getString("uin");
          ((SessionInfo)localObject).troopUin = paramBundle.getString("troop_uin");
          paramBundle = new ArkAppMessage();
          paramBundle.appName = "com.tencent.qqpay.b2c_redpacket";
          paramBundle.appView = "redpacket";
          paramBundle.appMinVersion = "1.0.0.1";
          paramBundle.appDesc = acfp.m(2131706434);
          paramBundle.promptText = acfp.m(2131706436);
          paramBundle.metaList = this.bf.getString("forward.apollo.redpacket_info", "");
          ujt.b(this.app, (SessionInfo)localObject, paramBundle);
        } while (this.mActivity == null);
        paramBundle = new Intent();
        paramBundle.putExtras(this.bf);
        this.mActivity.setResult(-1, paramBundle);
        this.mActivity.finish();
        return;
        if (paramInt != 2) {
          break;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("uin", paramBundle.getString("uin"));
        ((Bundle)localObject).putInt("uintype", paramBundle.getInt("uintype"));
        ((Bundle)localObject).putString("troop_uin", paramBundle.getString("troop_uin"));
        ((Bundle)localObject).putString("uinname", paramBundle.getString("uinname"));
        ((Bundle)localObject).putBoolean("launchApolloGame", true);
        ((Bundle)localObject).putInt("gameId", this.bf.getInt("forward.apollo.gameid"));
        ((Bundle)localObject).putInt("gameMode", this.bf.getInt("forward.apollo.gameMode"));
        ((Bundle)localObject).putInt("enter", 4);
      } while (this.mActivity == null);
      this.mIntent = new Intent(this.mActivity, SplashActivity.class);
      this.mIntent = wja.a(this.mIntent, new int[] { 2 });
      this.mIntent.putExtras((Bundle)localObject);
      this.mActivity.startActivity(this.mIntent);
      paramBundle = new Intent();
      paramBundle.putExtras(this.bf);
      this.mActivity.setResult(-1, paramBundle);
      this.mActivity.finish();
      return;
      Object localObject = new ApolloPanel.b();
      ((ApolloPanel.b)localObject).actionId = this.bf.getInt("forward.apollo.actionid");
      ((ApolloPanel.b)localObject).gameId = this.bf.getInt("forward.apollo.gameid");
      ((ApolloPanel.b)localObject).gameMode = this.bf.getInt("forward.apollo.gameMode");
      ((ApolloPanel.b)localObject).roomId = this.bf.getLong("forward.apollo.roomid");
      ((ApolloPanel.b)localObject).gameName = this.bf.getString("forward.apollo.gamename");
      ((ApolloPanel.b)localObject).actionName = this.bf.getString("forward.apollo.actionname");
      ((ApolloPanel.b)localObject).msgType = this.bf.getInt("forward.apollo.msgtype");
      ((ApolloPanel.b)localObject).gameExtendJson = this.bf.getString("forward.apollo.sharejson");
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.aTl = paramBundle.getString("uin");
      localSessionInfo.troopUin = paramBundle.getString("troop_uin");
      localSessionInfo.cZ = paramBundle.getInt("uintype");
      ApolloGameUtil.a(this.app, (ApolloPanel.b)localObject, localSessionInfo);
      aboy.CB(localSessionInfo.aTl);
      VipUtils.a(this.app, "cmshow", "Apollo", "game_msg_sent", ApolloUtil.a(localSessionInfo, this.app), 3, new String[] { "" + ((ApolloPanel.b)localObject).gameId });
    } while (this.mActivity == null);
    paramBundle = new Intent();
    paramBundle.putExtras(this.bf);
    this.mActivity.setResult(-1, paramBundle);
    this.mActivity.finish();
  }
  
  public void Kp(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardApolloGameMsgOption", 2, new Object[] { "[endForwardCallback], isCompleted:", Boolean.valueOf(paramBoolean) });
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("share_result_key", 1);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    if (this.mActivity != null)
    {
      this.mActivity.setResult(-1, localIntent);
      this.mActivity.finish();
    }
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void dnr()
  {
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
    if (anv()) {
      this.cs.add(U);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahgj
 * JD-Core Version:    0.7.0.1
 */