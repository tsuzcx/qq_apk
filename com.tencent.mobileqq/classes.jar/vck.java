import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.util.ArrayList;
import java.util.List;

public class vck
  extends vcb
{
  public int a;
  public String a;
  public List<VideoCollectionItem> a;
  public String b;
  public boolean e = true;
  
  public vck(String paramString, ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GetCollectionListEvent{isEnd=" + this.jdField_a_of_type_Boolean + ", isUpdated=" + this.e + ", isLocalData=" + this.b + ", isFirstPage=" + this.c + ", isRefreshFromLoadMore=" + this.d + ", collectionList=" + this.jdField_a_of_type_JavaUtilList + ", totalVideoCount=" + this.jdField_a_of_type_Int + ", context='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vck
 * JD-Core Version:    0.7.0.1
 */