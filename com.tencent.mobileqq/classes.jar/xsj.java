import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class xsj
  implements xtl
{
  xsj(xsg paramxsg, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(xtg paramxtg)
  {
    if (this.jdField_a_of_type_Xsg.isCanceled()) {
      return;
    }
    yuk.a(this.jdField_a_of_type_Xsg.a.a, "onPrepared, [videoView=%d]", Integer.valueOf(System.identityHashCode(paramxtg)));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Xsg.a, "VP", SystemClock.uptimeMillis());
    this.jdField_a_of_type_Xsg.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsj
 * JD-Core Version:    0.7.0.1
 */