import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apwh
{
  private int dXH;
  private int mType;
  
  public static apwh a(View paramView)
  {
    apwh localapwh2 = (apwh)paramView.getTag();
    apwh localapwh1 = localapwh2;
    if (localapwh2 == null)
    {
      localapwh1 = new apwh();
      paramView.setTag(localapwh1);
    }
    return localapwh1;
  }
  
  private int b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = aqgx.m(paramQQAppInterface.getCurrentAccountUin(), "troop_game_feed", paramSessionInfo.aTl);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read game feed red dot, num=" + i);
    }
    if (i > 0) {
      return 1;
    }
    i = aqgx.m(paramQQAppInterface.getCurrentAccountUin(), "troop_album_feed", paramSessionInfo.troopUin);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read album feed red dot, num=" + i);
    }
    if (i > 0) {
      return 6;
    }
    boolean bool = aprg.W(paramQQAppInterface, paramSessionInfo.aTl);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "needShowRobotRedDot:" + bool);
    }
    if (bool) {
      return 2;
    }
    if (aoij.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false))
    {
      paramQQAppInterface = (aeof)aeif.a().o(535);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.bVl)) {
        return 3;
      }
      paramQQAppInterface = ((aenw)aeif.a().o(551)).a(4);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.bVi)) {
        return 4;
      }
    }
    return 0;
  }
  
  public boolean j(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.mType = b(paramQQAppInterface, paramSessionInfo);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "needShow: " + this.mType);
    }
    return this.mType != 0;
  }
  
  public void p(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.mType = b(paramQQAppInterface, paramSessionInfo);
    switch (this.mType)
    {
    default: 
      return;
    case 2: 
      aprg.ab(paramQQAppInterface, false);
      return;
    case 3: 
    case 4: 
      aoij.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
      return;
    case 5: 
      anot.b(null, "dc00898", "", paramSessionInfo.aTl, "qq_vip", "0X800A8F5", this.dXH, 1, 0, "", "", "", "");
    }
    aqgx.v(paramQQAppInterface.getCurrentAccountUin(), "troop_album_feed", paramSessionInfo.troopUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwh
 * JD-Core Version:    0.7.0.1
 */