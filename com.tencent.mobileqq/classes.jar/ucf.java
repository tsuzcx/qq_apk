import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class ucf
  implements udh
{
  ucf(ucc paramucc, StoryVideoItem paramStoryVideoItem) {}
  
  public void a_(udc paramudc)
  {
    if (this.jdField_a_of_type_Ucc.isCanceled()) {
      return;
    }
    veg.a(this.jdField_a_of_type_Ucc.a.a, "onPrepared, [videoView=%d]", Integer.valueOf(System.identityHashCode(paramudc)));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a, "VP", SystemClock.uptimeMillis());
    this.jdField_a_of_type_Ucc.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucf
 * JD-Core Version:    0.7.0.1
 */