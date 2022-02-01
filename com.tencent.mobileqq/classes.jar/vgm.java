import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

class vgm
  implements SDKInitListener
{
  vgm(vgl paramvgl) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (paramBoolean) {
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq", "Q_CIRCLE_CLIENT_MODULE_NAME", "CLIENT_ACTION_INIT_SUCCESS", null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgm
 * JD-Core Version:    0.7.0.1
 */