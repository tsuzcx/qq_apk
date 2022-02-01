import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class xgy
  extends ParallelJobSegment<String, xgu>
{
  public int a;
  
  public xgy(xgs paramxgs, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    xhm localxhm = new xhm();
    localxhm.jdField_a_of_type_JavaLangString = paramString;
    localxhm.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localxhm.c = this.jdField_a_of_type_Int;
    }
    vqn.a().a(localxhm, new xgz(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgy
 * JD-Core Version:    0.7.0.1
 */