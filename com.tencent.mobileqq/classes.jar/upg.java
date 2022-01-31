import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class upg
  extends ParallelJobSegment<String, upc>
{
  public int a;
  
  public upg(upa paramupa, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    upu localupu = new upu();
    localupu.jdField_a_of_type_JavaLangString = paramString;
    localupu.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localupu.c = this.jdField_a_of_type_Int;
    }
    syo.a().a(localupu, new uph(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upg
 * JD-Core Version:    0.7.0.1
 */