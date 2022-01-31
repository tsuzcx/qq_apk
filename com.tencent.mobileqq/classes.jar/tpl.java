import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class tpl
  implements tqj
{
  tpl(tpg paramtpg, StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(tqg paramtqg, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_Tpg.isCanceled()) {
      return true;
    }
    urk.e(this.jdField_a_of_type_Tpg.a.a, "onError, setOnErrorListener [videoView, model=%d, what=%d, position=%d, extra=%s, Info=%s] = ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    if (paramInt2 == 102)
    {
      paramtqg.d();
      return true;
    }
    VideoViewVideoHolder.c(this.jdField_a_of_type_Tpg.a, 7);
    VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_Tpg.a, paramInt2);
    tpg.b(this.jdField_a_of_type_Tpg, new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_Tpg.a), "wht=" + paramInt2 + ", mod=" + paramInt1 + ", " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpl
 * JD-Core Version:    0.7.0.1
 */