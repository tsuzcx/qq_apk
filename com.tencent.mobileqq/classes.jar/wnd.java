import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class wnd
{
  public StoryVideoItem a;
  public String a;
  public boolean a;
  public boolean b = true;
  
  public wnd(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof wnd)) {
      return TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((wnd)paramObject).jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnd
 * JD-Core Version:    0.7.0.1
 */