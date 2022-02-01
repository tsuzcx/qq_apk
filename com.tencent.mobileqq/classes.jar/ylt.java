import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class ylt
  extends JobSegment<ylv, yff>
{
  private int jdField_a_of_type_Int;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yfc jdField_a_of_type_Yfc;
  
  protected void a(JobContext paramJobContext, ylv paramylv)
  {
    this.jdField_a_of_type_Yfc = new yfc(paramylv, new ylu(this, paramJobContext, paramylv));
    this.jdField_a_of_type_Yfc.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylt
 * JD-Core Version:    0.7.0.1
 */