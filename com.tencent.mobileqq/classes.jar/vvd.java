import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class vvd
  implements vwf
{
  vvd(vva paramvva, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(vwa paramvwa)
  {
    if (this.jdField_a_of_type_Vva.isCanceled()) {
      return;
    }
    wxe.a(this.jdField_a_of_type_Vva.a.a, "onPrepared, [videoView=%d]", Integer.valueOf(System.identityHashCode(paramvwa)));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Vva.a, "VP", SystemClock.uptimeMillis());
    this.jdField_a_of_type_Vva.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvd
 * JD-Core Version:    0.7.0.1
 */