import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.a;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajvx
  implements View.OnClickListener
{
  ajvx(ajvw paramajvw) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.a.c(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvx
 * JD-Core Version:    0.7.0.1
 */