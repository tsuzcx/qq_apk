import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class wdy
  extends ParallelJobSegment<String, wdu>
{
  public int a;
  
  public wdy(wds paramwds, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    wem localwem = new wem();
    localwem.jdField_a_of_type_JavaLangString = paramString;
    localwem.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localwem.c = this.jdField_a_of_type_Int;
    }
    ung.a().a(localwem, new wdz(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdy
 * JD-Core Version:    0.7.0.1
 */