import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class ybz
  extends JobSegment<ycb, xvl>
{
  private int jdField_a_of_type_Int;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xvi jdField_a_of_type_Xvi;
  
  protected void a(JobContext paramJobContext, ycb paramycb)
  {
    this.jdField_a_of_type_Xvi = new xvi(paramycb, new yca(this, paramJobContext, paramycb));
    this.jdField_a_of_type_Xvi.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybz
 * JD-Core Version:    0.7.0.1
 */