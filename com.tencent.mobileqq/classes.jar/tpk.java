import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class tpk
  implements tqh
{
  tpk(tpg paramtpg, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(tqg paramtqg)
  {
    if (this.jdField_a_of_type_Tpg.isCanceled()) {}
    do
    {
      return;
      urk.a(this.jdField_a_of_type_Tpg.a.jdField_a_of_type_JavaLangString, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Tpg.a.c]);
    } while (!VideoViewVideoHolder.b(this.jdField_a_of_type_Tpg.a, 12));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a, 12);
    this.jdField_a_of_type_Tpg.a.d = 1;
    VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a).a(this.jdField_a_of_type_Tpg.a, paramtqg, VideoViewVideoHolder.b(this.jdField_a_of_type_Tpg.a));
    urp.c("video_ope", "play_finish", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpk
 * JD-Core Version:    0.7.0.1
 */