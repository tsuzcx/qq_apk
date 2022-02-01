import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Map;

public class wwe
  extends wxz
{
  StoryVideoItem a;
  public xrn a;
  
  public wwe(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      ykq.c(this.b, "Error: ", new IllegalStateException("这里VideoItem为空, 临时保护, 可能存在逻辑异常"));
      b(false);
      return;
    }
    wlc localwlc = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout();
    if (localwlc != null)
    {
      this.jdField_a_of_type_Xrn = new xrk();
      this.jdField_a_of_type_Xrn.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, 0, 0, new wwf(this, localwlc));
      return;
    }
    a("result", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
    b(true);
  }
  
  protected void a(Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwe
 * JD-Core Version:    0.7.0.1
 */