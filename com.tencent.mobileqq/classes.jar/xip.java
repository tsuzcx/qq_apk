import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class xip
  implements xjr
{
  xip(xim paramxim, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(xjm paramxjm)
  {
    if (this.jdField_a_of_type_Xim.isCanceled()) {
      return;
    }
    ykq.a(this.jdField_a_of_type_Xim.a.a, "onPrepared, [videoView=%d]", Integer.valueOf(System.identityHashCode(paramxjm)));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a, "VP", SystemClock.uptimeMillis());
    this.jdField_a_of_type_Xim.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xip
 * JD-Core Version:    0.7.0.1
 */