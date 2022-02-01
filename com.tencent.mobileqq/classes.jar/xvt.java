import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class xvt
  extends ParallelJobSegment<String, xvp>
{
  public int a;
  
  public xvt(xvn paramxvn, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    xwh localxwh = new xwh();
    localxwh.jdField_a_of_type_JavaLangString = paramString;
    localxwh.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localxwh.c = this.jdField_a_of_type_Int;
    }
    wfi.a().a(localxwh, new xvu(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvt
 * JD-Core Version:    0.7.0.1
 */