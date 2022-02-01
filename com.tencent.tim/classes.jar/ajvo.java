import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.CustomViewPager;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView.b;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.qphone.base.util.QLog;

public class ajvo
  implements StuffContainerView.b
{
  public ajvo(SmallVideoFragment paramSmallVideoFragment) {}
  
  public void lP(int paramInt)
  {
    Object localObject;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a() != null)
    {
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a().id;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a() == null) {
        break label168;
      }
    }
    label168:
    for (long l = this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a().ads;; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Native_ShortVideo_Report", 2, "onClickClose report module=short_video, action=view_click, obj1=6, res2=" + (String)localObject + ", anchor=" + l);
      }
      localObject = (VideoPlayerPagerAdapter)this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
      if ((((VideoPlayerPagerAdapter)localObject).getView(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof ShortVideoCommentsView)) {
        ((ShortVideoCommentsView)((VideoPlayerPagerAdapter)localObject).getView(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).dAe();
      }
      this.this$0.dzD();
      return;
      localObject = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvo
 * JD-Core Version:    0.7.0.1
 */