import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class ygo
{
  public StoryVideoItem a;
  public String a;
  public boolean a;
  public boolean b = true;
  
  public ygo(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ygo)) {
      return TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((ygo)paramObject).jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygo
 * JD-Core Version:    0.7.0.1
 */