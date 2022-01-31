import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class tpj
  implements tql
{
  tpj(tpg paramtpg, StoryVideoItem paramStoryVideoItem) {}
  
  public void a_(tqg paramtqg)
  {
    if (this.jdField_a_of_type_Tpg.isCanceled()) {
      return;
    }
    urk.a(this.jdField_a_of_type_Tpg.a.a, "onPrepared, [videoView=%d]", Integer.valueOf(System.identityHashCode(paramtqg)));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a, "VP", SystemClock.uptimeMillis());
    this.jdField_a_of_type_Tpg.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpj
 * JD-Core Version:    0.7.0.1
 */