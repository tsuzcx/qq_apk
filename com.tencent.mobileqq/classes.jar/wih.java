import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class wih
  extends ParallelJobSegment<String, wid>
{
  public int a;
  
  public wih(wib paramwib, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    wiv localwiv = new wiv();
    localwiv.jdField_a_of_type_JavaLangString = paramString;
    localwiv.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localwiv.c = this.jdField_a_of_type_Int;
    }
    urp.a().a(localwiv, new wii(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wih
 * JD-Core Version:    0.7.0.1
 */