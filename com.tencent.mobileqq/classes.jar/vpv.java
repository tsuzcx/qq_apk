import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;

public class vpv
  implements View.OnClickListener
{
  public vpv(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onClick(View paramView)
  {
    if (!bdee.g(this.a.jdField_a_of_type_AndroidViewView.getContext()))
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidViewView.getContext(), 1, 2131694764, 0).a();
      return;
    }
    VideoViewVideoHolder.a(this.a, 2);
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpv
 * JD-Core Version:    0.7.0.1
 */