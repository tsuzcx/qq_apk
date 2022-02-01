import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

public class ytb
{
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent, KplRoleInfo.WZRYUIinfo paramWZRYUIinfo)
  {
    switch (paramInt1)
    {
    default: 
      if ((paramInt2 != 3007) && (paramInt2 != 3019) && (paramInt2 != 2007) && (paramInt2 != 4007) && (paramInt2 != 2019)) {
        break label222;
      }
      paramString = new ProfileActivity.AllInOne(paramString, 25);
      paramString.bJa = 109;
      if ((paramInt2 != 3007) && (paramInt2 != 2007) && (paramInt2 != 4007)) {
        break;
      }
    }
    for (paramString.bJa = 14;; paramString.bJa = 15) {
      do
      {
        paramWZRYUIinfo = new Bundle();
        paramWZRYUIinfo.putInt("param_mode", 3);
        paramWZRYUIinfo.putParcelable("sysInfoExtres", paramIntent);
        NearbyPeopleProfileActivity.c(paramContext, paramString, paramWZRYUIinfo);
        return;
        a(paramContext, paramString, paramLong, paramInt2, paramIntent, paramWZRYUIinfo);
        return;
        a(paramContext, paramString, paramLong, paramInt2, paramIntent);
        return;
      } while ((paramInt2 != 3019) && (paramInt2 != 2019));
    }
    label222:
    paramString = new ProfileActivity.AllInOne(paramString, 25);
    paramString.bJa = 109;
    paramString.bIW = 1;
    if (paramInt1 == 6) {
      paramString.bIW = 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("sysInfoExtres", paramIntent);
    if (paramWZRYUIinfo != null) {
      paramString.data.putSerializable("param_wzry_data", paramWZRYUIinfo);
    }
    ProfileActivity.a(paramContext, paramString, localBundle);
  }
  
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt, Intent paramIntent)
  {
    if ((paramInt == 3007) || (paramInt == 3019) || (paramInt == 2007) || (paramInt == 4007) || (paramInt == 2019))
    {
      paramString = new ProfileActivity.AllInOne(paramString, 25);
      paramString.bJa = 109;
      if ((paramInt == 3007) || (paramInt == 2007) || (paramInt == 4007)) {}
      for (paramString.bJa = 14;; paramString.bJa = 15) {
        do
        {
          localBundle = new Bundle();
          localBundle.putInt("param_mode", 3);
          localBundle.putParcelable("sysInfoExtres", paramIntent);
          NearbyPeopleProfileActivity.c(paramContext, paramString, localBundle);
          return;
        } while ((paramInt != 3019) && (paramInt != 2019));
      }
    }
    paramString = new ProfileActivity.AllInOne(paramString, 25);
    paramString.bJa = 109;
    paramString.bJb = paramInt;
    paramString.troopUin = String.valueOf(paramLong);
    paramString.bIW = 1;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("sysInfoExtres", paramIntent);
    ProfileActivity.a(paramContext, paramString, localBundle);
  }
  
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt, Intent paramIntent, KplRoleInfo.WZRYUIinfo paramWZRYUIinfo)
  {
    if ((paramInt == 3007) || (paramInt == 3019) || (paramInt == 2007) || (paramInt == 2019) || (paramInt == 4007))
    {
      paramString = new ProfileActivity.AllInOne(paramString, 28);
      paramString.bJa = 109;
      if ((paramInt == 3007) || (paramInt == 2007) || (paramInt == 4007)) {}
      for (paramString.bJa = 14;; paramString.bJa = 15) {
        do
        {
          paramWZRYUIinfo = new Bundle();
          paramWZRYUIinfo.putInt("param_mode", 3);
          paramWZRYUIinfo.putParcelable("sysInfoExtres", paramIntent);
          NearbyPeopleProfileActivity.c(paramContext, paramString, paramWZRYUIinfo);
          return;
        } while ((paramInt != 3019) && (paramInt != 2019));
      }
    }
    paramString = new ProfileActivity.AllInOne(paramString, 28);
    paramString.bJa = 109;
    paramString.bJb = paramInt;
    paramString.troopUin = String.valueOf(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("sysInfoExtres", paramIntent);
    if (paramWZRYUIinfo != null) {
      paramString.data.putSerializable("param_wzry_data", paramWZRYUIinfo);
    }
    ProfileActivity.a(paramContext, paramString, localBundle);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent)
  {
    anot.a(paramQQAppInterface, "CliOper", "", "", "Verify_msg", "Verify_msg_prof", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageHelper", 2, "openProfileCard | sourceId = " + paramInt2);
    }
    paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface != null) {}
    for (boolean bool = paramQQAppInterface.isFriend(paramString);; bool = false)
    {
      if (bool)
      {
        paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 1);
        paramQQAppInterface.bJa = 109;
        ProfileActivity.b(paramContext, paramQQAppInterface);
      }
      for (;;)
      {
        return true;
        Object localObject = null;
        paramQQAppInterface = localObject;
        if (paramIntent != null)
        {
          paramQQAppInterface = localObject;
          if (paramIntent.hasExtra("param_wzry_data")) {
            paramQQAppInterface = (KplRoleInfo.WZRYUIinfo)paramIntent.getSerializableExtra("param_wzry_data");
          }
        }
        a(paramContext, paramString, paramLong, paramInt1, paramInt2, paramIntent, paramQQAppInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ytb
 * JD-Core Version:    0.7.0.1
 */