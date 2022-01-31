import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class uce
  implements udc
{
  uce(ubz paramubz, StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(ucz paramucz, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_Ubz.isCanceled()) {
      return true;
    }
    ved.e(this.jdField_a_of_type_Ubz.a.a, "onError, setOnErrorListener [videoView, model=%d, what=%d, position=%d, extra=%s, Info=%s] = ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    if (paramInt2 == 102)
    {
      paramucz.d();
      return true;
    }
    VideoViewVideoHolder.c(this.jdField_a_of_type_Ubz.a, 7);
    VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_Ubz.a, paramInt2);
    ubz.b(this.jdField_a_of_type_Ubz, new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_Ubz.a), "wht=" + paramInt2 + ", mod=" + paramInt1 + ", " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uce
 * JD-Core Version:    0.7.0.1
 */