import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class xai
  implements vng
{
  xai(xah paramxah) {}
  
  public void a(String paramString, int paramInt)
  {
    xvv.d(this.a.a.b, "save -info download suc , start watermark ,vid:%s", new Object[] { xah.a(this.a).mVid });
    wkp.a(xah.a(this.a), xah.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    xvv.d(this.a.a.b, "save video -info download error , vid:%s , error :%s", new Object[] { xah.a(this.a).mVid, paramErrorMessage.toString() });
    wkp.a(xah.a(this.a), xah.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void b(String paramString, int paramInt)
  {
    xvv.d(this.a.a.b, "save video -info download cancel , vid:%s ", new Object[] { xah.a(this.a).mVid });
    wkp.a(xah.a(this.a), xah.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xai
 * JD-Core Version:    0.7.0.1
 */