import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class upj
  extends ParallelJobSegment<String, upf>
{
  public int a;
  
  public upj(upd paramupd, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    upx localupx = new upx();
    localupx.jdField_a_of_type_JavaLangString = paramString;
    localupx.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localupx.c = this.jdField_a_of_type_Int;
    }
    syr.a().a(localupx, new upk(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upj
 * JD-Core Version:    0.7.0.1
 */