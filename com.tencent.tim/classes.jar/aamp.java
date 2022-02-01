import android.content.Intent;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.RegisterGuideView;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginGuideView;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aamp
{
  public static final String[] dg = { "H60-L02", "H60-L01" };
  
  public static GuideBaseFragment a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    switch (f(paramBaseActivity.getIntent()))
    {
    default: 
      return new TimLoginQQView(paramQQAppInterface);
    case 102: 
      return new LoginView(paramQQAppInterface);
    case 101: 
      return new RegisterGuideView(paramQQAppInterface);
    case 103: 
      return new TimLoginGuideView(paramQQAppInterface);
    }
    return new TimLoginQQView(paramQQAppInterface);
  }
  
  private static int f(Intent paramIntent)
  {
    Object localObject = BaseApplicationImpl.sApplication.getAllAccounts();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (SimpleAccount)((List)localObject).get(0);
      if ((localObject != null) && (!((SimpleAccount)localObject).isLoginByWx())) {
        return 104;
      }
    }
    boolean bool1 = paramIntent.getBooleanExtra("from_register_guide", false);
    boolean bool2 = paramIntent.getBooleanExtra("isActionSend", false);
    boolean bool3 = paramIntent.getBooleanExtra("from_register_choose", false);
    if ((!bool1) && (!bool2) && (!bool3)) {
      return 103;
    }
    return 104;
  }
  
  public static boolean h(String[] paramArrayOfString)
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("GuideHandler", 2, "isKeyBoardBlackList model=" + str);
    }
    boolean bool1 = bool2;
    int j;
    int i;
    if (str != null)
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (str.equals(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aamp
 * JD-Core Version:    0.7.0.1
 */