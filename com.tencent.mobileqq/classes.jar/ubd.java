import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

public class ubd
  implements View.OnClickListener
{
  public ubd(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onClick(View paramView)
  {
    if (!bbfj.g(this.a.jdField_a_of_type_AndroidViewView.getContext()))
    {
      bcql.a(this.a.jdField_a_of_type_AndroidViewView.getContext(), 1, 2131694608, 0).a();
      return;
    }
    VideoViewVideoHolder.a(this.a, 2);
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ubd
 * JD-Core Version:    0.7.0.1
 */