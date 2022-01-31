import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

public class ubt
  implements View.OnClickListener
{
  public ubt(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onClick(View paramView)
  {
    if (!bbev.g(this.a.jdField_a_of_type_AndroidViewView.getContext()))
    {
      bcpw.a(this.a.jdField_a_of_type_AndroidViewView.getContext(), 1, 2131694607, 0).a();
      return;
    }
    veg.d(this.a.jdField_a_of_type_JavaLangString, "video view error, retry, show loading view");
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    this.a.a(10, true, "retry play");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ubt
 * JD-Core Version:    0.7.0.1
 */