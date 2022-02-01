package cooperation.qqreader;

import aqhq;
import avls;
import avoc;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import mqq.app.AppRuntime;

final class QRBridgeUtil$1
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      avoc.e("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    avls localavls = new avls();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localavls);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localavls.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      aqhq.delete((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */