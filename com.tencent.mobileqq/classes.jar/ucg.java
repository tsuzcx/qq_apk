import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class ucg
  implements udd
{
  ucg(ucc paramucc, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(udc paramudc)
  {
    if (this.jdField_a_of_type_Ucc.isCanceled()) {}
    do
    {
      return;
      veg.a(this.jdField_a_of_type_Ucc.a.jdField_a_of_type_JavaLangString, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Ucc.a.c]);
    } while (!VideoViewVideoHolder.b(this.jdField_a_of_type_Ucc.a, 12));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a, 12);
    this.jdField_a_of_type_Ucc.a.d = 1;
    VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a).a(this.jdField_a_of_type_Ucc.a, paramudc, VideoViewVideoHolder.b(this.jdField_a_of_type_Ucc.a));
    vel.c("video_ope", "play_finish", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucg
 * JD-Core Version:    0.7.0.1
 */