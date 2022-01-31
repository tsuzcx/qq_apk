import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class wke
  extends JobSegment<wkg, wdq>
{
  private int jdField_a_of_type_Int;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  private wdn jdField_a_of_type_Wdn;
  
  protected void a(JobContext paramJobContext, wkg paramwkg)
  {
    this.jdField_a_of_type_Wdn = new wdn(paramwkg, new wkf(this, paramJobContext, paramwkg));
    this.jdField_a_of_type_Wdn.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wke
 * JD-Core Version:    0.7.0.1
 */