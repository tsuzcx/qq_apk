import com.tencent.ad.tangram.process.AdProcessManagerAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

public class yje
  implements AdProcessManagerAdapter
{
  public Boolean isOnMainProcess()
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    while (BaseApplicationImpl.getApplication().getRuntime() == null) {
      return null;
    }
    return Boolean.valueOf(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface);
  }
  
  public Boolean isWebProcessRunning()
  {
    Object localObject = isWebProcessRunningForPreloading();
    if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
      return Boolean.valueOf(true);
    }
    localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {}
    for (;;)
    {
      return null;
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        try
        {
          boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
          return Boolean.valueOf(bool);
        }
        catch (Throwable localThrowable)
        {
          yny.d("GdtProcessManagerAdapter", "isWebProcessRunning", localThrowable);
        }
      }
    }
  }
  
  public Boolean isWebProcessRunningForPreloading()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
    } while ((localObject == null) || (!(localObject instanceof ToolAppRuntime)));
    return Boolean.valueOf(bbca.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yje
 * JD-Core Version:    0.7.0.1
 */