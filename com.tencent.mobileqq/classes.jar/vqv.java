import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class vqv
  implements vrs
{
  vqv(vqr paramvqr, StoryVideoItem paramStoryVideoItem) {}
  
  public void b(vrr paramvrr)
  {
    if (this.jdField_a_of_type_Vqr.isCanceled()) {}
    do
    {
      return;
      wsv.a(this.jdField_a_of_type_Vqr.a.jdField_a_of_type_JavaLangString, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Vqr.a.c]);
    } while (!VideoViewVideoHolder.b(this.jdField_a_of_type_Vqr.a, 12));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a, 12);
    this.jdField_a_of_type_Vqr.a.d = 1;
    VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a).a(this.jdField_a_of_type_Vqr.a, paramvrr, VideoViewVideoHolder.b(this.jdField_a_of_type_Vqr.a));
    wta.c("video_ope", "play_finish", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqv
 * JD-Core Version:    0.7.0.1
 */