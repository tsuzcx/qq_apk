import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.VideoFaceDetector;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class yrj
  implements EIPCResultCallback
{
  public yrj(ApolloRender paramApolloRender) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    VideoPrefsUtil.init(BaseApplicationImpl.getContext());
    VideoGlobalContext.setContext(BaseApplicationImpl.getContext());
    if (PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false))
    {
      this.a.mDetector = new VideoFaceDetector(PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), null));
      this.a.mDetector.init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yrj
 * JD-Core Version:    0.7.0.1
 */