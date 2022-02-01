import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class jiy
{
  public static String TAG = "AVEnterPopActionSheetUtil";
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null)) {
      QLog.e(TAG, 1, "app == null || context == null || sessionInfo == null");
    }
    do
    {
      do
      {
        return;
      } while (jln.xR());
      jln localjln = jln.a(paramContext);
      int[] arrayOfInt = new int[5];
      localjln.setMainTitle(2131689654);
      arrayOfInt[0] = 1;
      localjln.addButton(2131721238);
      arrayOfInt[1] = 2;
      localjln.addButton(2131721260);
      localjln.addCancelButton(2131721058);
      localjln.a(new jiz());
      localjln.a(new jja(localjln, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramContext, paramInt));
      localjln.show();
    } while (paramInt != 3);
    if (paramSessionInfo.cZ == 1)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 2, "", "", "", "");
      return;
    }
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X800A517", "0X800A517", 0, 1, "", "", "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null)) {
      return;
    }
    QLog.w(TAG, 1, "enterGroupVideo,, isAudio[" + paramBoolean + "], msgSelfUin[" + paramQQAppInterface.getCurrentUin() + "], uinType[" + paramSessionInfo.cZ + "], groupId[" + paramSessionInfo.aTl + "], curFriendNick[" + paramSessionInfo.aTn + "], troopUin[" + paramSessionInfo.troopUin + "]");
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      xrc.a(paramQQAppInterface, paramContext, paramSessionInfo, 10, paramBoolean, paramQQAppInterface.getCurrentUin(), "");
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null)) {}
    do
    {
      return;
      QLog.w(TAG, 1, "enterC2CAudioVideo,, isAudio[" + paramBoolean + "], fromType[" + paramInt + "], msgSelfUin[" + paramQQAppInterface.getCurrentUin() + "], uinType[" + paramSessionInfo.cZ + "], groupId[" + paramSessionInfo.aTl + "], curFriendNick[" + paramSessionInfo.aTn + "], troopUin[" + paramSessionInfo.troopUin + "]");
      localObject = (ajdo)paramQQAppInterface.getManager(11);
    } while (localObject == null);
    String str;
    if (paramSessionInfo.cZ == 1006) {
      str = ((ajdo)localObject).dv(paramSessionInfo.aTl);
    }
    for (Object localObject = paramSessionInfo.aTl;; localObject = ((ajdo)localObject).di(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.cZ, str, paramSessionInfo.aTn, (String)localObject, paramBoolean, paramSessionInfo.troopUin, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.aTl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jiy
 * JD-Core Version:    0.7.0.1
 */