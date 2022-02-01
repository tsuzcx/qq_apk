import android.view.View;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.a;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;

public class ajvw
  implements ajzb
{
  public ajvw(StoryPlayController paramStoryPlayController, VideoPlayerPagerAdapter.a parama, VideoData paramVideoData) {}
  
  public void a(String paramString, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a().Fb.findViewById(2131370435).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.dzW();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.setOnClickListener(new ajvx(this));
  }
  
  public void iR(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a().Fb.findViewById(2131370435).setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
    this.this$0.a.hideProgress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvw
 * JD-Core Version:    0.7.0.1
 */