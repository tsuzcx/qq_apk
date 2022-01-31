import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Map;

public class tpl
  extends trg
{
  StoryVideoItem a;
  public ula a;
  
  public tpl(StoryVideoItem paramStoryVideoItem)
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
    tej localtej = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout();
    if (localtej != null)
    {
      this.jdField_a_of_type_Ula = new ukx();
      this.jdField_a_of_type_Ula.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, 0, 0, new tpm(this, localtej));
      return;
    }
    a("result", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
    b(true);
  }
  
  protected void a(Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpl
 * JD-Core Version:    0.7.0.1
 */