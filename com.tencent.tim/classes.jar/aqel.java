import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class aqel
{
  private static int dYO = -1;
  
  public static boolean a(Context paramContext, AppInterface paramAppInterface)
  {
    return (!FriendsStatusUtil.bc(paramContext)) || ((!paramAppInterface.isBackground_Pause) && (aqey.isScreenOn(BaseApplicationImpl.sApplication)));
  }
  
  public static boolean b(Context paramContext, AppInterface paramAppInterface)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    aejn localaejn = (aejn)aeif.a().o(528);
    boolean bool1 = bool3;
    if ((paramAppInterface instanceof QQAppInterface))
    {
      bool1 = bool3;
      if (localaejn != null)
      {
        bool1 = bool3;
        if (localaejn.cNu == 1)
        {
          if (dYO != -1) {
            break label87;
          }
          bool1 = SettingCloneUtil.readValue(paramContext, paramAppInterface.getCurrentAccountUin(), null, "qqsetting_qrlogin_set_mute", false);
          if (!bool1) {
            break label82;
          }
        }
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      dYO = i;
      return bool1;
    }
    label87:
    if (dYO == 1) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static void setMute(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      dYO = i;
      if (QLog.isColorLevel()) {
        QLog.d("NoDisturbUtil", 2, new Object[] { "setMuteStat:", Integer.valueOf(dYO) });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqel
 * JD-Core Version:    0.7.0.1
 */