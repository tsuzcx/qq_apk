import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class tvx
  implements sig
{
  tvx(tvw paramtvw) {}
  
  public void a(String paramString, int paramInt)
  {
    urk.d(this.a.a.b, "save -info download suc , start watermark ,vid:%s", new Object[] { tvw.a(this.a).mVid });
    tfy.a(tvw.a(this.a), tvw.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    urk.d(this.a.a.b, "save video -info download error , vid:%s , error :%s", new Object[] { tvw.a(this.a).mVid, paramErrorMessage.toString() });
    tfy.a(tvw.a(this.a), tvw.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void b(String paramString, int paramInt)
  {
    urk.d(this.a.a.b, "save video -info download cancel , vid:%s ", new Object[] { tvw.a(this.a).mVid });
    tfy.a(tvw.a(this.a), tvw.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvx
 * JD-Core Version:    0.7.0.1
 */