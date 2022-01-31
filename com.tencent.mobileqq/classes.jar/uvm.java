import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class uvm
  extends JobSegment<uvo, uoy>
{
  private int jdField_a_of_type_Int;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uov jdField_a_of_type_Uov;
  
  protected void a(JobContext paramJobContext, uvo paramuvo)
  {
    this.jdField_a_of_type_Uov = new uov(paramuvo, new uvn(this, paramJobContext, paramuvo));
    this.jdField_a_of_type_Uov.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvm
 * JD-Core Version:    0.7.0.1
 */