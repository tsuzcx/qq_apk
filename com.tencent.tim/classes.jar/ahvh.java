import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.web.QQGameIpcHandle.1.1;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class ahvh
  implements EIPCResultCallback
{
  ahvh(ahvg paramahvg, ahvg.a parama, String paramString, boolean paramBoolean) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGameIpcHandle.1.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvh
 * JD-Core Version:    0.7.0.1
 */