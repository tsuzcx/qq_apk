import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView;

public class xcu
  implements Animation.AnimationListener
{
  public xcu(ArtFilterItemView paramArtFilterItemView, EditVideoArtFilter paramEditVideoArtFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.a(true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xcu
 * JD-Core Version:    0.7.0.1
 */