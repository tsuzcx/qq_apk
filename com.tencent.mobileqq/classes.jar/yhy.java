import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class yhy
  extends JobSegment<yia, ybk>
{
  private int jdField_a_of_type_Int;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ybh jdField_a_of_type_Ybh;
  
  protected void a(JobContext paramJobContext, yia paramyia)
  {
    this.jdField_a_of_type_Ybh = new ybh(paramyia, new yhz(this, paramJobContext, paramyia));
    this.jdField_a_of_type_Ybh.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhy
 * JD-Core Version:    0.7.0.1
 */