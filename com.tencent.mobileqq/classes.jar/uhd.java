import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem;
import java.util.ArrayList;
import java.util.List;

public class uhd
  extends swh
{
  public int a;
  public String a;
  public List<ShareGroupCollectionItem> a;
  
  public uhd(ErrorMessage paramErrorMessage, String paramString)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GetShareGroupListEvent{mShareGroupList=" + this.jdField_a_of_type_JavaUtilList.size() + ", mShareGroupTotalCount=" + this.jdField_a_of_type_Int + ", errorCode=" + this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode + ", isLocalData=" + this.b + ", isFirstPage=" + this.c + ", isEnd=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhd
 * JD-Core Version:    0.7.0.1
 */