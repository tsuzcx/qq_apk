import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Map;

public class tpj
  extends trg
{
  StoryVideoItem a;
  public ula a;
  
  public tpj(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      ved.c(this.b, "Error: ", new IllegalStateException("这里VideoItem为空, 临时保护, 可能存在逻辑异常"));
      b(false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout() != null)
    {
      this.jdField_a_of_type_Ula = new ukx();
      this.jdField_a_of_type_Ula.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, 0, 0, new tpk(this));
      return;
    }
    a("result", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
    b(true);
  }
  
  protected void a(Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpj
 * JD-Core Version:    0.7.0.1
 */