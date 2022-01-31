import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class uit
  implements svc
{
  uit(uis paramuis) {}
  
  public void a(String paramString, int paramInt)
  {
    veg.d(this.a.a.b, "save -info download suc , start watermark ,vid:%s", new Object[] { uis.a(this.a).mVid });
    tsu.a(uis.a(this.a), uis.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    veg.d(this.a.a.b, "save video -info download error , vid:%s , error :%s", new Object[] { uis.a(this.a).mVid, paramErrorMessage.toString() });
    tsu.a(uis.a(this.a), uis.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void b(String paramString, int paramInt)
  {
    veg.d(this.a.a.b, "save video -info download cancel , vid:%s ", new Object[] { uis.a(this.a).mVid });
    tsu.a(uis.a(this.a), uis.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uit
 * JD-Core Version:    0.7.0.1
 */