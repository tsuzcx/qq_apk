import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class yjw
{
  private static EIPCResult a()
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    while ((BaseApplicationImpl.getApplication().getRuntime() == null) || ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) || (QIPCClientHelper.getInstance() == null) || (QIPCClientHelper.getInstance().getClient() == null))
    {
      yny.b("GdtAnalysisConfigIPCUtil", "send error");
      return EIPCResult.createResult(-102, null);
    }
    yny.b("GdtAnalysisConfigIPCUtil", "send");
    return QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc", "analysis_update_config", null);
  }
  
  public static EIPCResult a(ymt paramymt, String paramString, Bundle paramBundle, int paramInt)
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    while ((BaseApplicationImpl.getApplication().getRuntime() == null) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) || (!TextUtils.equals(paramString, "analysis_update_config")))
    {
      yny.b("GdtAnalysisConfigIPCUtil", "receive error");
      return EIPCResult.createResult(-1, null);
    }
    paramymt = new Bundle();
    paramymt.putBoolean("enabled", yjx.a());
    yny.b("GdtAnalysisConfigIPCUtil", String.format("receive enabled:%b", new Object[] { Boolean.valueOf(yjx.a()) }));
    return EIPCResult.createSuccessResult(paramymt);
  }
  
  public static boolean a()
  {
    EIPCResult localEIPCResult = a();
    boolean bool;
    if (localEIPCResult == null) {
      bool = false;
    }
    for (;;)
    {
      yny.b("GdtAnalysisConfigIPCUtil", String.format("send threadId:%d enabled:%b", new Object[] { Long.valueOf(Thread.currentThread().getId()), Boolean.valueOf(bool) }));
      return bool;
      if (!localEIPCResult.isSuccess()) {
        bool = false;
      } else if (localEIPCResult.data == null) {
        bool = false;
      } else if (!localEIPCResult.data.containsKey("enabled")) {
        bool = false;
      } else {
        bool = localEIPCResult.data.getBoolean("enabled");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yjw
 * JD-Core Version:    0.7.0.1
 */