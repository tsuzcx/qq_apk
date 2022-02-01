import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class vgl
  extends QIPCModule
{
  public vgl(String paramString)
  {
    super(paramString);
  }
  
  private void a()
  {
    azjl.a(BaseApplicationImpl.context, new vgm(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("QCircleHostIPCModule", 1, "receive action:" + paramString + " callbackId:" + paramInt);
    if ("HOST_ACTION_INIT_PLAY_SDK".equals(paramString)) {
      a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgl
 * JD-Core Version:    0.7.0.1
 */