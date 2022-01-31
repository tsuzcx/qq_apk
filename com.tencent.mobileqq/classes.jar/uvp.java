import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class uvp
  extends JobSegment<uvr, upb>
{
  private int jdField_a_of_type_Int;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uoy jdField_a_of_type_Uoy;
  
  protected void a(JobContext paramJobContext, uvr paramuvr)
  {
    this.jdField_a_of_type_Uoy = new uoy(paramuvr, new uvq(this, paramJobContext, paramuvr));
    this.jdField_a_of_type_Uoy.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvp
 * JD-Core Version:    0.7.0.1
 */