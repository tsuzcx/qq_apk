import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class qns
  implements pno.a
{
  qns(qng.h paramh) {}
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    ram.w(this.a.a.TAG, "save video -info download error , vid:%s , error :%s", new Object[] { qng.h.a(this.a).mVid, paramErrorMessage.toString() });
    qem.a(qng.h.a(this.a), qng.h.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void bj(String paramString, int paramInt)
  {
    ram.w(this.a.a.TAG, "save video -info download cancel , vid:%s ", new Object[] { qng.h.a(this.a).mVid });
    qem.a(qng.h.a(this.a), qng.h.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void onSuccess(String paramString, int paramInt)
  {
    ram.w(this.a.a.TAG, "save -info download suc , start watermark ,vid:%s", new Object[] { qng.h.a(this.a).mVid });
    qem.a(qng.h.a(this.a), qng.h.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qns
 * JD-Core Version:    0.7.0.1
 */