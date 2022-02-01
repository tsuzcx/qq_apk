import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class xne
  extends JobSegment<xng, xgq>
{
  private int jdField_a_of_type_Int;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xgn jdField_a_of_type_Xgn;
  
  protected void a(JobContext paramJobContext, xng paramxng)
  {
    this.jdField_a_of_type_Xgn = new xgn(paramxng, new xnf(this, paramJobContext, paramxng));
    this.jdField_a_of_type_Xgn.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xne
 * JD-Core Version:    0.7.0.1
 */