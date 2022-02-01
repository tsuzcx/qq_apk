import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class yfn
  extends ParallelJobSegment<String, yfj>
{
  public int a;
  
  public yfn(yfh paramyfh, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    ygb localygb = new ygb();
    localygb.jdField_a_of_type_JavaLangString = paramString;
    localygb.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localygb.c = this.jdField_a_of_type_Int;
    }
    wow.a().a(localygb, new yfo(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfn
 * JD-Core Version:    0.7.0.1
 */