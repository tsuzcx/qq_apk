import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class uiq
  implements suz
{
  uiq(uip paramuip) {}
  
  public void a(String paramString, int paramInt)
  {
    ved.d(this.a.a.b, "save -info download suc , start watermark ,vid:%s", new Object[] { uip.a(this.a).mVid });
    tsr.a(uip.a(this.a), uip.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    ved.d(this.a.a.b, "save video -info download error , vid:%s , error :%s", new Object[] { uip.a(this.a).mVid, paramErrorMessage.toString() });
    tsr.a(uip.a(this.a), uip.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void b(String paramString, int paramInt)
  {
    ved.d(this.a.a.b, "save video -info download cancel , vid:%s ", new Object[] { uip.a(this.a).mVid });
    tsr.a(uip.a(this.a), uip.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uiq
 * JD-Core Version:    0.7.0.1
 */