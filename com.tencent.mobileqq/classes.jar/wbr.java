import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class wbr
  implements uoa
{
  wbr(wbq paramwbq) {}
  
  public void a(String paramString, int paramInt)
  {
    wxe.d(this.a.a.b, "save -info download suc , start watermark ,vid:%s", new Object[] { wbq.a(this.a).mVid });
    vls.a(wbq.a(this.a), wbq.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    wxe.d(this.a.a.b, "save video -info download error , vid:%s , error :%s", new Object[] { wbq.a(this.a).mVid, paramErrorMessage.toString() });
    vls.a(wbq.a(this.a), wbq.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void b(String paramString, int paramInt)
  {
    wxe.d(this.a.a.b, "save video -info download cancel , vid:%s ", new Object[] { wbq.a(this.a).mVid });
    vls.a(wbq.a(this.a), wbq.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbr
 * JD-Core Version:    0.7.0.1
 */