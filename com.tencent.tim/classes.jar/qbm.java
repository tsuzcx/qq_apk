import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import java.util.Map;

public class qbm
  extends qdh
{
  public qpm a;
  StoryVideoItem e;
  
  public qbm(StoryVideoItem paramStoryVideoItem)
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
    StoryVideoItem.b localb = this.e.getPollLayout();
    if (localb != null)
    {
      this.a = new qph.b();
      this.a.a(this.e.mVideoThumbnailUrl, 0, 0, new qbn(this, localb));
      return;
    }
    p("result", this.e.mVideoThumbnailUrl);
    sA(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbm
 * JD-Core Version:    0.7.0.1
 */