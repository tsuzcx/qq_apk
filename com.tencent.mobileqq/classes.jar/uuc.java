import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class uuc
{
  public StoryVideoItem a;
  public String a;
  public boolean a;
  public boolean b = true;
  
  public uuc(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof uuc)) {
      return TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((uuc)paramObject).jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uuc
 * JD-Core Version:    0.7.0.1
 */