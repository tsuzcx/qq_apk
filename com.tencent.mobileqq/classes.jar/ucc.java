import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class ucc
  implements ude
{
  ucc(ubz paramubz, StoryVideoItem paramStoryVideoItem) {}
  
  public void a_(ucz paramucz)
  {
    if (this.jdField_a_of_type_Ubz.isCanceled()) {
      return;
    }
    ved.a(this.jdField_a_of_type_Ubz.a.a, "onPrepared, [videoView=%d]", Integer.valueOf(System.identityHashCode(paramucz)));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a, "VP", SystemClock.uptimeMillis());
    this.jdField_a_of_type_Ubz.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucc
 * JD-Core Version:    0.7.0.1
 */