import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class vxi
  implements ujr
{
  vxi(vxh paramvxh) {}
  
  public void a(String paramString, int paramInt)
  {
    wsv.d(this.a.a.b, "save -info download suc , start watermark ,vid:%s", new Object[] { vxh.a(this.a).mVid });
    vhj.a(vxh.a(this.a), vxh.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    wsv.d(this.a.a.b, "save video -info download error , vid:%s , error :%s", new Object[] { vxh.a(this.a).mVid, paramErrorMessage.toString() });
    vhj.a(vxh.a(this.a), vxh.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void b(String paramString, int paramInt)
  {
    wsv.d(this.a.a.b, "save video -info download cancel , vid:%s ", new Object[] { vxh.a(this.a).mVid });
    vhj.a(vxh.a(this.a), vxh.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxi
 * JD-Core Version:    0.7.0.1
 */