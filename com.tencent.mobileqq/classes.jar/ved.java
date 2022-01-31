import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Map;

public class ved
  extends vfy
{
  StoryVideoItem a;
  public vzs a;
  
  public ved(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      wsv.c(this.b, "Error: ", new IllegalStateException("这里VideoItem为空, 临时保护, 可能存在逻辑异常"));
      b(false);
      return;
    }
    utb localutb = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout();
    if (localutb != null)
    {
      this.jdField_a_of_type_Vzs = new vzp();
      this.jdField_a_of_type_Vzs.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, 0, 0, new vee(this, localutb));
      return;
    }
    a("result", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
    b(true);
  }
  
  protected void a(Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ved
 * JD-Core Version:    0.7.0.1
 */