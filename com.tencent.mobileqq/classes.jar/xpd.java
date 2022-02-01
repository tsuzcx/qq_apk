import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class xpd
  implements wcb
{
  xpd(xpc paramxpc) {}
  
  public void a(String paramString, int paramInt)
  {
    ykq.d(this.a.a.b, "save -info download suc , start watermark ,vid:%s", new Object[] { xpc.a(this.a).mVid });
    wzk.a(xpc.a(this.a), xpc.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    ykq.d(this.a.a.b, "save video -info download error , vid:%s , error :%s", new Object[] { xpc.a(this.a).mVid, paramErrorMessage.toString() });
    wzk.a(xpc.a(this.a), xpc.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void b(String paramString, int paramInt)
  {
    ykq.d(this.a.a.b, "save video -info download cancel , vid:%s ", new Object[] { xpc.a(this.a).mVid });
    wzk.a(xpc.a(this.a), xpc.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpd
 * JD-Core Version:    0.7.0.1
 */