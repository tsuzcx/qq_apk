import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class ybs
  extends ParallelJobSegment<String, ybo>
{
  public int a;
  
  public ybs(ybm paramybm, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    ycg localycg = new ycg();
    localycg.jdField_a_of_type_JavaLangString = paramString;
    localycg.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localycg.c = this.jdField_a_of_type_Int;
    }
    wlb.a().a(localycg, new ybt(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybs
 * JD-Core Version:    0.7.0.1
 */