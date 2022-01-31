import com.tencent.TMG.sdk.AVVideoCtrl.RemoteVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

class ygg
  extends AVVideoCtrl.RemoteVideoPreviewCallback
{
  ygg(ygd paramygd) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = CmGameUtil.a(AVCameraCaptureModel.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((CmGameLauncher)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new ygh(this, paramVideoFrame, (ApolloSurfaceView)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ygg
 * JD-Core Version:    0.7.0.1
 */