import android.app.Activity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class vkk
  implements EIPCResultCallback
{
  vkk(vki paramvki) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      AIOGalleryScene.M(this.a.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkk
 * JD-Core Version:    0.7.0.1
 */