import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Adapter;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;

public final class ysc
  implements AdIPCManager.Adapter
{
  public AdIPCManager.Result receive(String paramString, AdIPCManager.Params paramParams)
  {
    boolean bool = false;
    AdIPCManager.Result localResult2 = new AdIPCManager.Result();
    AdIPCManager.Result localResult1;
    if (TextUtils.isEmpty(paramString)) {
      localResult1 = localResult2;
    }
    for (;;)
    {
      if (localResult1 != null) {
        bool = localResult1.success;
      }
      yxp.b("GdtIPCAdapter", String.format("receive action:%s result:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
      return localResult1;
      Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
      localResult1 = localResult2;
      if (localBoolean != null)
      {
        localResult1 = localResult2;
        if (localBoolean.booleanValue())
        {
          localResult1 = localResult2;
          if (QIPCClientHelper.getInstance() != null)
          {
            localResult1 = localResult2;
            if (QIPCClientHelper.getInstance().getClient() != null) {
              localResult1 = AdIPCManager.INSTANCE.receive(paramString, paramParams);
            }
          }
        }
      }
    }
  }
  
  public AdIPCManager.Result send(String paramString, AdIPCManager.Params paramParams)
  {
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    if (TextUtils.isEmpty(paramString)) {
      if (localResult == null) {
        break label148;
      }
    }
    label148:
    for (boolean bool = localResult.success;; bool = false)
    {
      yxp.b("GdtIPCAdapter", String.format("send action:%s result:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
      return localResult;
      Object localObject = AdProcessManager.INSTANCE.isOnMainProcess();
      if ((localObject == null) || (((Boolean)localObject).booleanValue()) || (QIPCClientHelper.getInstance() == null) || (QIPCClientHelper.getInstance().getClient() == null)) {
        break;
      }
      localObject = QIPCClientHelper.getInstance().getClient();
      if (paramParams != null) {}
      for (paramParams = paramParams.bundle;; paramParams = null)
      {
        paramParams = ((EIPCClient)localObject).callServer("gdt_ipc", paramString, paramParams);
        if (paramParams == null) {
          break;
        }
        localResult.success = paramParams.isSuccess();
        localResult.bundle = paramParams.data;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysc
 * JD-Core Version:    0.7.0.1
 */