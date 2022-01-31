import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class vve
  implements vwb
{
  vve(vva paramvva, StoryVideoItem paramStoryVideoItem) {}
  
  public void b(vwa paramvwa)
  {
    if (this.jdField_a_of_type_Vva.isCanceled()) {}
    do
    {
      return;
      wxe.a(this.jdField_a_of_type_Vva.a.jdField_a_of_type_JavaLangString, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Vva.a.c]);
    } while (!VideoViewVideoHolder.b(this.jdField_a_of_type_Vva.a, 12));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Vva.a, 12);
    this.jdField_a_of_type_Vva.a.d = 1;
    VideoViewVideoHolder.a(this.jdField_a_of_type_Vva.a).a(this.jdField_a_of_type_Vva.a, paramvwa, VideoViewVideoHolder.b(this.jdField_a_of_type_Vva.a));
    wxj.c("video_ope", "play_finish", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vve
 * JD-Core Version:    0.7.0.1
 */