import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class tjq
  extends QIPCModule
{
  private static volatile tjq a;
  
  private tjq(String paramString)
  {
    super(paramString);
  }
  
  public static tjq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new tjq("gdt_ipc");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    tkw.i("gdt_ipc", "Action  " + paramString);
    if ("do_app_jump".equals(paramString))
    {
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        paramString = (tkx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(110);
        paramBundle.setClassLoader(getClass().getClassLoader());
        paramBundle = (GdtBaseAdItem)paramBundle.getParcelable("gdtBaseAdItem");
        paramString.a(BaseApplicationImpl.getContext(), paramBundle);
        callbackResult(paramInt, EIPCResult.createSuccessResult(null));
      }
    }
    else {
      return null;
    }
    callbackResult(paramInt, EIPCResult.createResult(-1, null));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjq
 * JD-Core Version:    0.7.0.1
 */