import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class acfe
  extends QIPCModule
{
  private static volatile acfe a;
  
  public acfe(String paramString)
  {
    super(paramString);
  }
  
  public static acfe a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acfe("FriendQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private void c(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    int i = 1;
    String str = paramBundle.getString("KEY_UIN");
    int j = paramBundle.getInt("KEY_SCF_SWITCH_TYPE");
    boolean bool = paramBundle.getBoolean("KEY_SCF_SWITCH_STATUS");
    if (QLog.isColorLevel()) {
      QLog.d("FriendQIPCModule", 2, String.format("SCP set switch, switchType: %s, switchStatus", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) }));
    }
    paramBundle = (acff)paramQQAppInterface.getManager(51);
    if (j == 1) {
      if (bool)
      {
        paramBundle.DQ(str);
        SpecialCareInfo localSpecialCareInfo = new SpecialCareInfo();
        localSpecialCareInfo.globalSwitch = 1;
        localSpecialCareInfo.specialRingSwitch = 1;
        localSpecialCareInfo.friendRingId = 1;
        localSpecialCareInfo.qzoneSwitch = 1;
        localSpecialCareInfo.uin = str;
        paramBundle.a(localSpecialCareInfo);
        abbf.a(str, "1", paramQQAppInterface);
      }
    }
    do
    {
      do
      {
        return;
        paramBundle.DQ(str);
        return;
      } while (j != 2);
      paramQQAppInterface = paramBundle.a(str);
    } while (paramQQAppInterface == null);
    if (bool) {}
    for (;;)
    {
      paramQQAppInterface.qzoneSwitch = i;
      paramBundle.a(paramQQAppInterface);
      return;
      i = 0;
    }
  }
  
  private EIPCResult d(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("KEY_UIN");
    paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
    Bundle localBundle = new Bundle();
    if (paramQQAppInterface != null) {}
    for (boolean bool = paramQQAppInterface.isFriend(paramBundle);; bool = false)
    {
      localBundle.putBoolean("KEY_IS_FRIEND", bool);
      if (QLog.isColorLevel()) {
        QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, isFriend: %s", new Object[] { paramBundle, Boolean.valueOf(bool) }));
      }
      return EIPCResult.createSuccessResult(localBundle);
    }
  }
  
  private EIPCResult e(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("KEY_UIN");
    acff localacff = (acff)paramQQAppInterface.getManager(51);
    Bundle localBundle = new Bundle();
    boolean bool;
    if (localacff != null)
    {
      bool = localacff.isFriend(paramBundle);
      if (!bool) {
        break label157;
      }
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
      if (paramQQAppInterface == null) {
        break label157;
      }
      int i = paramQQAppInterface.xy();
      if (((i != 9) && (i != 8) && (i != 4) && (i != 2)) || (!paramQQAppInterface.Uy())) {
        break label157;
      }
      paramQQAppInterface = paramQQAppInterface.a(paramBundle);
      if (paramQQAppInterface == null) {
        break label157;
      }
    }
    label157:
    for (paramQQAppInterface = paramQQAppInterface.unifiedCode;; paramQQAppInterface = null)
    {
      localBundle.putString("PHONE_NUMBER", paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, phoneNumber: %s", new Object[] { paramBundle, paramQQAppInterface }));
      }
      return EIPCResult.createSuccessResult(localBundle);
      bool = false;
      break;
    }
  }
  
  private EIPCResult f(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("KEY_UIN");
    paramBundle = ((acff)paramQQAppInterface.getManager(51)).a(str1);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_SCF_INFO", paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("FriendQIPCModule", 2, String.format("getSCFInfo: %s", new Object[] { paramBundle }));
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    String str2 = "special_care_voice_red_dot" + paramQQAppInterface.getCurrentAccountUin();
    paramBundle = aqmk.a(localSharedPreferences, str2, null);
    paramQQAppInterface = paramBundle;
    if (paramBundle == null) {
      paramQQAppInterface = new HashSet();
    }
    if (paramQQAppInterface.add(str1))
    {
      localBundle.putBoolean("KEY_SCF_VOICE_NEW_FLAG", true);
      paramBundle = localSharedPreferences.edit();
      aqmk.a(paramBundle, str2, paramQQAppInterface.toArray());
      paramBundle.commit();
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(localBundle);
      localBundle.putBoolean("KEY_SCF_VOICE_NEW_FLAG", false);
    }
  }
  
  private EIPCResult g(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("KEY_UIN");
    ExtensionInfo localExtensionInfo = ((acff)paramQQAppInterface.getManager(51)).a(paramBundle, false);
    if (localExtensionInfo != null) {}
    for (int i = localExtensionInfo.friendRingId;; i = 0)
    {
      paramQQAppInterface = aean.a(paramQQAppInterface).d(i, paramBundle, 0);
      paramBundle = new Bundle();
      paramBundle.putString("KEY_SCF_RING_NAME", paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("FriendQIPCModule", 2, String.format("SCP getRingName, ringId: %s, ringName: %s", new Object[] { Integer.valueOf(i), paramQQAppInterface }));
      }
      return EIPCResult.createSuccessResult(paramBundle);
    }
  }
  
  private EIPCResult h(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getStringArrayList("KEY_BE_DELETE_SINGLE_WAY_FRIENDS");
    QLog.d("FriendQIPCModule", 1, "delete single way friends: " + paramBundle);
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      ((acmb)paramQQAppInterface.getBusinessHandler(26)).notifyUI(5, true, paramBundle);
    }
    return EIPCResult.createSuccessResult(null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("ACTION_IS_FRIEND".equals(paramString)) {
      return d((QQAppInterface)localObject, paramBundle);
    }
    if ("ACTION_GET_PHONE_NUMBER".equals(paramString)) {
      return e((QQAppInterface)localObject, paramBundle);
    }
    if ("ACTION_GET_SPECIAL_CARE_INFO".equals(paramString)) {
      return f((QQAppInterface)localObject, paramBundle);
    }
    if ("ACTION_GET_SCF_RING_NAME".equals(paramString)) {
      return g((QQAppInterface)localObject, paramBundle);
    }
    if ("ACTION_SET_SAVE_SWITCH".equals(paramString)) {
      c((QQAppInterface)localObject, paramBundle);
    }
    while (!"ACTION_DELETE_SINGLE_WAY_FRIENDS".equals(paramString)) {
      return null;
    }
    return h((QQAppInterface)localObject, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfe
 * JD-Core Version:    0.7.0.1
 */