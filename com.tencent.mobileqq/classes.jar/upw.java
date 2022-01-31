import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.LikeEntry;
import java.util.List;

public class upw
  extends ssk
{
  public int a;
  public String a;
  public List<LikeEntry> a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  
  public upw(ErrorMessage paramErrorMessage, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GetLikeListEvent{feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", isForDetail=" + this.jdField_a_of_type_Boolean + ", mType=" + this.jdField_a_of_type_Int + ", mLikeCount=" + this.b + ", mHasLike=" + this.c + ", mLikeEntryList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upw
 * JD-Core Version:    0.7.0.1
 */