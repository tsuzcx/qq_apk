import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class acee
  extends QIPCModule
{
  private static volatile acee a;
  
  public acee(String paramString)
  {
    super(paramString);
  }
  
  public static acee a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acee("ExtendFriendQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    localObject = (QQAppInterface)localObject;
    boolean bool;
    if ("notifyCampusFriendCertificateResult".equals(paramString))
    {
      bool = paramBundle.getBoolean("key_result");
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_CAMPUS_FRIEND_CERTIFICATE_RESULT ,result = " + bool);
      }
      paramString = (afsi)((QQAppInterface)localObject).getManager(264);
      if (paramString != null)
      {
        if (!bool) {
          break label132;
        }
        paramInt = 2;
        paramString.hS(paramInt, 1);
        ((afsg)((QQAppInterface)localObject).getBusinessHandler(127)).notifyUI(20, true, new Object[] { Integer.valueOf(2) });
      }
    }
    for (;;)
    {
      return null;
      label132:
      paramInt = 3;
      break;
      if ("notifyUploadSutudentIDResult".equals(paramString))
      {
        bool = paramBundle.getBoolean("key_result");
        paramString = (afsi)((QQAppInterface)localObject).getManager(264);
        if (bool)
        {
          paramString.hS(1, 2);
          ((afsg)((QQAppInterface)localObject).getBusinessHandler(127)).notifyUI(20, true, new Object[] { Integer.valueOf(2) });
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT ,result = " + bool);
        }
      }
      else if ("notifyUpdateSchoolInfo".equals(paramString))
      {
        paramString = paramBundle.getString("name", "");
        paramInt = paramBundle.getInt("category", 0);
        String str1 = paramBundle.getString("schoolid", "");
        int i = paramBundle.getInt("idx", 0);
        afsi localafsi = (afsi)((QQAppInterface)localObject).getManager(264);
        String str2 = localafsi.uH();
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_SCHOOL_INFO_UPDATE ，schoolName = " + paramString + "，oldSchoolName = " + str2);
        }
        if (!paramString.equals(str2)) {
          localafsi.hS(0, -1);
        }
        localafsi.h(i, paramString, str1, paramInt);
        ((afsg)((QQAppInterface)localObject).getBusinessHandler(127)).notifyUI(22, true, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acee
 * JD-Core Version:    0.7.0.1
 */