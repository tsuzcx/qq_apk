import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class awop
  extends QIPCModule
{
  public static awop a;
  
  private awop()
  {
    super("WadlQIPCModule");
  }
  
  public static awop a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awop();
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if (!(paramBundle instanceof QQAppInterface)) {
      return null;
    }
    paramBundle = (QQAppInterface)paramBundle;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ("action.getSkey".equals(paramString))
    {
      paramString = ((TicketManager)paramBundle.getManager(2)).getSkey(paramBundle.getCurrentAccountUin());
      paramBundle = new Bundle();
      if (paramString != null) {}
      for (;;)
      {
        paramBundle.putString("skey", paramString);
        return EIPCResult.createSuccessResult(paramBundle);
        paramString = "";
      }
    }
    if ("action.getUin".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putLong("uin", paramBundle.getLongAccountUin());
      return EIPCResult.createSuccessResult(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awop
 * JD-Core Version:    0.7.0.1
 */