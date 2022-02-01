import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class wtv
  implements wus
{
  wtv(wtr paramwtr, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(wur paramwur)
  {
    if (this.jdField_a_of_type_Wtr.isCanceled()) {}
    do
    {
      return;
      xvv.a(this.jdField_a_of_type_Wtr.a.jdField_a_of_type_JavaLangString, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Wtr.a.c]);
    } while (!VideoViewVideoHolder.b(this.jdField_a_of_type_Wtr.a, 12));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Wtr.a, 12);
    this.jdField_a_of_type_Wtr.a.d = 1;
    VideoViewVideoHolder.a(this.jdField_a_of_type_Wtr.a).a(this.jdField_a_of_type_Wtr.a, paramwur, VideoViewVideoHolder.b(this.jdField_a_of_type_Wtr.a));
    xwa.c("video_ope", "play_finish", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtv
 * JD-Core Version:    0.7.0.1
 */