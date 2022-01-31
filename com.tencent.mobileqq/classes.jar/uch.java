import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class uch
  implements udf
{
  uch(ucc paramucc, StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(udc paramudc, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_Ucc.isCanceled()) {
      return true;
    }
    veg.e(this.jdField_a_of_type_Ucc.a.a, "onError, setOnErrorListener [videoView, model=%d, what=%d, position=%d, extra=%s, Info=%s] = ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    if (paramInt2 == 102)
    {
      paramudc.d();
      return true;
    }
    VideoViewVideoHolder.c(this.jdField_a_of_type_Ucc.a, 7);
    VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_Ucc.a, paramInt2);
    ucc.b(this.jdField_a_of_type_Ucc, new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_Ucc.a), "wht=" + paramInt2 + ", mod=" + paramInt1 + ", " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uch
 * JD-Core Version:    0.7.0.1
 */