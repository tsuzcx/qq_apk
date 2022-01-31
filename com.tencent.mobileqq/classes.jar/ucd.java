import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class ucd
  implements uda
{
  ucd(ubz paramubz, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(ucz paramucz)
  {
    if (this.jdField_a_of_type_Ubz.isCanceled()) {}
    do
    {
      return;
      ved.a(this.jdField_a_of_type_Ubz.a.jdField_a_of_type_JavaLangString, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Ubz.a.c]);
    } while (!VideoViewVideoHolder.b(this.jdField_a_of_type_Ubz.a, 12));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a, 12);
    this.jdField_a_of_type_Ubz.a.d = 1;
    VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a).a(this.jdField_a_of_type_Ubz.a, paramucz, VideoViewVideoHolder.b(this.jdField_a_of_type_Ubz.a));
    vei.c("video_ope", "play_finish", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucd
 * JD-Core Version:    0.7.0.1
 */