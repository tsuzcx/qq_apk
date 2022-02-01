import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class xiq
  implements xjn
{
  xiq(xim paramxim, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(xjm paramxjm)
  {
    if (this.jdField_a_of_type_Xim.isCanceled()) {}
    do
    {
      return;
      ykq.a(this.jdField_a_of_type_Xim.a.jdField_a_of_type_JavaLangString, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Xim.a.c]);
    } while (!VideoViewVideoHolder.b(this.jdField_a_of_type_Xim.a, 12));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a, 12);
    this.jdField_a_of_type_Xim.a.d = 1;
    VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a).a(this.jdField_a_of_type_Xim.a, paramxjm, VideoViewVideoHolder.b(this.jdField_a_of_type_Xim.a));
    ykv.c("video_ope", "play_finish", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xiq
 * JD-Core Version:    0.7.0.1
 */