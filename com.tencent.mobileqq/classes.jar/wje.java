import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.List;

public class wje
  extends vcb
{
  public FeedVideoInfo a;
  public String a;
  public List<StoryVideoItem> a;
  public String b;
  
  public wje(ErrorMessage paramErrorMessage, String paramString)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GetVideoListEvent{mVideoItems=" + this.jdField_a_of_type_JavaUtilList.size() + ", feedId=" + this.jdField_a_of_type_JavaLangString + ", mUnionId=" + this.b + '}' + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wje
 * JD-Core Version:    0.7.0.1
 */