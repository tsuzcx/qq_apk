import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Map;

public class xfr
  extends xho
{
  StoryVideoItem a;
  public ybh a;
  
  public xfr(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      yuk.c(this.b, "Error: ", new IllegalStateException("这里VideoItem为空, 临时保护, 可能存在逻辑异常"));
      b(false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout() != null)
    {
      this.jdField_a_of_type_Ybh = new ybe();
      this.jdField_a_of_type_Ybh.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, 0, 0, new xfs(this));
      return;
    }
    a("result", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
    b(true);
  }
  
  protected void a(Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfr
 * JD-Core Version:    0.7.0.1
 */