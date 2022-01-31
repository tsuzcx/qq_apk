import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class uhj
{
  public StoryVideoItem a;
  public String a;
  public boolean a;
  public boolean b = true;
  
  public uhj(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof uhj)) {
      return TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((uhj)paramObject).jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhj
 * JD-Core Version:    0.7.0.1
 */