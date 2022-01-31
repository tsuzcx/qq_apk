import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class vqu
  implements vrw
{
  vqu(vqr paramvqr, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(vrr paramvrr)
  {
    if (this.jdField_a_of_type_Vqr.isCanceled()) {
      return;
    }
    wsv.a(this.jdField_a_of_type_Vqr.a.a, "onPrepared, [videoView=%d]", Integer.valueOf(System.identityHashCode(paramvrr)));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a, "VP", SystemClock.uptimeMillis());
    this.jdField_a_of_type_Vqr.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqu
 * JD-Core Version:    0.7.0.1
 */