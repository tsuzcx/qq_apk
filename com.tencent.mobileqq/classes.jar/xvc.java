import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class xvc
  implements whm
{
  xvc(xvb paramxvb) {}
  
  public void a(String paramString, int paramInt)
  {
    yqp.d(this.a.a.b, "save -info download suc , start watermark ,vid:%s", new Object[] { xvb.a(this.a).mVid });
    xfe.a(xvb.a(this.a), xvb.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    yqp.d(this.a.a.b, "save video -info download error , vid:%s , error :%s", new Object[] { xvb.a(this.a).mVid, paramErrorMessage.toString() });
    xfe.a(xvb.a(this.a), xvb.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void b(String paramString, int paramInt)
  {
    yqp.d(this.a.a.b, "save video -info download cancel , vid:%s ", new Object[] { xvb.a(this.a).mVid });
    xfe.a(xvb.a(this.a), xvb.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvc
 * JD-Core Version:    0.7.0.1
 */