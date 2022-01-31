import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.OnAdapterNotify;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;

public class vmu
  implements AIOGalleryAdapter.OnAdapterNotify
{
  public vmu(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void a(int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.a.a().findViewById(2131370997);
      if (localView != null) {}
    }
    do
    {
      do
      {
        return;
        localView.setVisibility(0);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(300L);
        localView.startAnimation(localAlphaAnimation);
        localView.postDelayed(new vmv(this, localView), 8000L);
        return;
        if (1 != paramInt) {
          break;
        }
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager == null) || (((AIOGalleryScene.av(this.a) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)AIOGalleryScene.aw(this.a)).b)) || (!this.a.c));
      return;
    } while ((2 != paramInt) || (this.a.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager == null) || (((AIOGalleryScene.ax(this.a) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)AIOGalleryScene.ay(this.a)).b)) || (this.a.c));
    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vmu
 * JD-Core Version:    0.7.0.1
 */