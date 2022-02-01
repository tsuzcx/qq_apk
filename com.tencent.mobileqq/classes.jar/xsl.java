import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class xsl
  implements xtj
{
  xsl(xsg paramxsg, StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(xtg paramxtg, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_Xsg.isCanceled()) {
      return true;
    }
    yuk.e(this.jdField_a_of_type_Xsg.a.a, "onError, setOnErrorListener [videoView, model=%d, what=%d, position=%d, extra=%s, Info=%s] = ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    if (paramInt2 == 102)
    {
      paramxtg.d();
      return true;
    }
    VideoViewVideoHolder.c(this.jdField_a_of_type_Xsg.a, 7);
    VideoViewVideoHolder.a(this.jdField_a_of_type_Xsg.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_Xsg.a, paramInt2);
    xsg.b(this.jdField_a_of_type_Xsg, new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_Xsg.a), "wht=" + paramInt2 + ", mod=" + paramInt1 + ", " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsl
 * JD-Core Version:    0.7.0.1
 */