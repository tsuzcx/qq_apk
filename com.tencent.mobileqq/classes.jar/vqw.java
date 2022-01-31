import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class vqw
  implements vru
{
  vqw(vqr paramvqr, StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(vrr paramvrr, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_Vqr.isCanceled()) {
      return true;
    }
    wsv.e(this.jdField_a_of_type_Vqr.a.a, "onError, setOnErrorListener [videoView, model=%d, what=%d, position=%d, extra=%s, Info=%s] = ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    if (paramInt2 == 102)
    {
      paramvrr.d();
      return true;
    }
    VideoViewVideoHolder.c(this.jdField_a_of_type_Vqr.a, 7);
    VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_Vqr.a, paramInt2);
    vqr.b(this.jdField_a_of_type_Vqr, new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_Vqr.a), "wht=" + paramInt2 + ", mod=" + paramInt1 + ", " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqw
 * JD-Core Version:    0.7.0.1
 */