import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class ucn
  extends ParallelJobSegment<String, ucj>
{
  public int a;
  
  public ucn(uch paramuch, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    udb localudb = new udb();
    localudb.jdField_a_of_type_JavaLangString = paramString;
    localudb.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localudb.c = this.jdField_a_of_type_Int;
    }
    slv.a().a(localudb, new uco(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucn
 * JD-Core Version:    0.7.0.1
 */