import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class xir
  implements xjp
{
  xir(xim paramxim, StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(xjm paramxjm, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_Xim.isCanceled()) {
      return true;
    }
    ykq.e(this.jdField_a_of_type_Xim.a.a, "onError, setOnErrorListener [videoView, model=%d, what=%d, position=%d, extra=%s, Info=%s] = ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    if (paramInt2 == 102)
    {
      paramxjm.d();
      return true;
    }
    VideoViewVideoHolder.c(this.jdField_a_of_type_Xim.a, 7);
    VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_Xim.a, paramInt2);
    xim.b(this.jdField_a_of_type_Xim, new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_Xim.a), "wht=" + paramInt2 + ", mod=" + paramInt1 + ", " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xir
 * JD-Core Version:    0.7.0.1
 */