import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class won
  extends JobSegment<wop, whz>
{
  private int jdField_a_of_type_Int;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  private whw jdField_a_of_type_Whw;
  
  protected void a(JobContext paramJobContext, wop paramwop)
  {
    this.jdField_a_of_type_Whw = new whw(paramwop, new woo(this, paramJobContext, paramwop));
    this.jdField_a_of_type_Whw.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     won
 * JD-Core Version:    0.7.0.1
 */