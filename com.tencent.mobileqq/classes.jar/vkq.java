import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;

public class vkq
  implements View.OnClickListener
{
  public vkq(AIOGallerySceneWithBusiness paramAIOGallerySceneWithBusiness, AIOShortVideoData paramAIOShortVideoData) {}
  
  public void onClick(View paramView)
  {
    AIOGallerySceneWithBusiness.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGallerySceneWithBusiness, AIOGallerySceneWithBusiness.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGallerySceneWithBusiness), "正在加载");
    boolean bool = DanceGameVideoManager.a().b();
    paramView = AIOGallerySceneWithBusiness.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGallerySceneWithBusiness);
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.h;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.e;
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      DanceMachineQQBrowserActivity.a(paramView, j, str, i, -999, 1, 0, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkq
 * JD-Core Version:    0.7.0.1
 */