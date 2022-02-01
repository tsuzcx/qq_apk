import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Map;

public class qbk
  extends qdh
{
  public qpm a;
  StoryVideoItem e;
  
  public qbk(StoryVideoItem paramStoryVideoItem)
  {
    this.e = paramStoryVideoItem;
  }
  
  protected void M(Map<String, Object> paramMap) {}
  
  public void bnE()
  {
    if (this.e == null)
    {
      ram.e(this.TAG, "Error: ", new IllegalStateException("这里VideoItem为空, 临时保护, 可能存在逻辑异常"));
      sA(false);
      return;
    }
    if (this.e.getInteractLayout() != null)
    {
      this.a = new qph.b();
      this.a.a(this.e.mVideoThumbnailUrl, 0, 0, new qbl(this));
      return;
    }
    p("result", this.e.mVideoThumbnailUrl);
    sA(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbk
 * JD-Core Version:    0.7.0.1
 */