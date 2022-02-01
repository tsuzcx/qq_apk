import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class xop
  implements xpm
{
  xop(xol paramxol, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(xpl paramxpl)
  {
    if (this.jdField_a_of_type_Xol.isCanceled()) {}
    do
    {
      return;
      yqp.a(this.jdField_a_of_type_Xol.a.jdField_a_of_type_JavaLangString, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Xol.a.c]);
    } while (!VideoViewVideoHolder.b(this.jdField_a_of_type_Xol.a, 12));
    VideoViewVideoHolder.a(this.jdField_a_of_type_Xol.a, 12);
    this.jdField_a_of_type_Xol.a.d = 1;
    VideoViewVideoHolder.a(this.jdField_a_of_type_Xol.a).a(this.jdField_a_of_type_Xol.a, paramxpl, VideoViewVideoHolder.b(this.jdField_a_of_type_Xol.a));
    yqu.c("video_ope", "play_finish", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xop
 * JD-Core Version:    0.7.0.1
 */