import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class yfn
{
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((!paramActivity.getBooleanExtra("showFirstStructMsg", false)) || (!paramBoolean));
        if (QLog.isColorLevel()) {
          QLog.d("send3rdAppStructMsg", 2, "send first struct msg");
        }
        paramActivity = paramActivity.getByteArrayExtra("stuctmsg_bytes");
      } while (paramActivity == null);
      paramActivity = anre.a(paramActivity);
    } while (paramActivity == null);
    aqmf.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.cZ, paramActivity, null);
    anot.a(paramQQAppInterface, "CliOper", "", paramSessionInfo.aTl, "0X8004B51", "0X8004B51", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (0 != 0) {
      throw new NullPointerException();
    }
    swe localswe = new swe(paramFragmentActivity);
    String str = paramFragmentActivity.getString(2131720024);
    if (paramString != null) {}
    for (paramString = str + paramString;; paramString = str)
    {
      paramAbsShareMsg = new yfo(paramAbsShareMsg, paramFragmentActivity, paramFragmentActivity, paramQQAppInterface, paramSessionInfo);
      localswe.c(paramString, paramAbsShareMsg);
      localswe.tV(paramFragmentActivity.getResources().getString(2131720031));
      localswe.a(paramAbsShareMsg);
      localswe.vh(false);
      localswe.show();
      anot.a(paramQQAppInterface, "CliOper", "", paramSessionInfo.aTl, "0X8004B54", "0X8004B54", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, SessionInfo paramSessionInfo)
  {
    boolean bool = false;
    anot.a(paramQQAppInterface, "CliOper", "", paramSessionInfo.aTl, "0X8004B53", "0X8004B53", 0, 0, "", "", "", "");
    Object localObject = paramFragmentActivity.getIntent().getByteArrayExtra("stuctmsg_bytes");
    String str = paramFragmentActivity.getIntent().getStringExtra("thirdAppDisplayName");
    localObject = anre.a((byte[])localObject);
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {}
    for (localObject = (AbsShareMsg)localObject;; localObject = null)
    {
      if ("webview".equals(paramFragmentActivity.getIntent().getStringExtra("from")))
      {
        aqhv.dZn -= 1;
        if (!(paramFragmentActivity instanceof SplashActivity))
        {
          paramFragmentActivity.finish();
          bool = true;
        }
        return bool;
      }
      a(paramQQAppInterface, paramFragmentActivity, paramSessionInfo, (AbsShareMsg)localObject, str);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent.getBooleanExtra("from3rdApp", false))
    {
      bool1 = bool2;
      if (paramIntent.getBooleanExtra("showFirstStructMsg", false))
      {
        paramIntent = paramIntent.getByteArrayExtra("stuctmsg_bytes");
        bool1 = bool2;
        if (paramIntent != null)
        {
          paramIntent = anre.a(paramIntent);
          long l = amzo.seq;
          paramSessionInfo = anbi.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.aTl, paramSessionInfo.aTl, paramSessionInfo.cZ, l, paramIntent);
          paramIntent = new ArrayList();
          paramIntent.add(paramSessionInfo);
          paramQQAppInterface.b().t(paramIntent, paramQQAppInterface.getCurrentAccountUin());
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfn
 * JD-Core Version:    0.7.0.1
 */