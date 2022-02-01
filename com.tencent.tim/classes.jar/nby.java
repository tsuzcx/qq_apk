import android.app.Application;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerSDKMgr;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKMgr;", "Lcom/tencent/mobileqq/videoplatform/SDKInitListener;", "()V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKEventListener;", "initSDK", "", "installPlugin", "isInstalled", "", "onSDKInited", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nby
  implements SDKInitListener, nbq
{
  private static nbp a;
  public static final nby a;
  
  static
  {
    jdField_a_of_type_Nby = new nby();
  }
  
  public boolean Ff()
  {
    return allf.isSDKReady();
  }
  
  public void a(@NotNull nbp paramnbp)
  {
    Intrinsics.checkParameterIsNotNull(paramnbp, "listener");
    allf.a((Application)BaseApplicationImpl.getContext(), (SDKInitListener)this);
  }
  
  public void initSDK()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "initSuperPlayerSDK() finish");
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    nbp localnbp;
    if (paramBoolean)
    {
      localnbp = jdField_a_of_type_Nbp;
      if (localnbp != null) {
        localnbp.onInstalledSuccessed();
      }
    }
    do
    {
      return;
      localnbp = jdField_a_of_type_Nbp;
    } while (localnbp == null);
    localnbp.onInstalledFailed(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nby
 * JD-Core Version:    0.7.0.1
 */