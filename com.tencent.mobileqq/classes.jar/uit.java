import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class uit
  extends JobSegment<uiv, ucf>
{
  private int jdField_a_of_type_Int;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ucc jdField_a_of_type_Ucc;
  
  protected void a(JobContext paramJobContext, uiv paramuiv)
  {
    this.jdField_a_of_type_Ucc = new ucc(paramuiv, new uiu(this, paramJobContext, paramuiv));
    this.jdField_a_of_type_Ucc.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uit
 * JD-Core Version:    0.7.0.1
 */