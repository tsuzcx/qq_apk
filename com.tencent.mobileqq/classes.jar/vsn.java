import android.os.SystemClock;
import com.tribe.async.async.JobSegment;

public abstract class vsn<IN, OUT>
  extends JobSegment<IN, OUT>
{
  protected long a;
  private final String a;
  private long b;
  
  public vsn()
  {
    this.jdField_a_of_type_JavaLangString = ("Q.qqstory.publish.edit." + getClass().getSimpleName());
  }
  
  public void call(IN paramIN)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    super.call(paramIN);
  }
  
  public void notifyError(Error paramError)
  {
    this.b = SystemClock.uptimeMillis();
    super.notifyError(paramError);
  }
  
  public void notifyResult(OUT paramOUT)
  {
    this.b = SystemClock.uptimeMillis();
    super.notifyResult(paramOUT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsn
 * JD-Core Version:    0.7.0.1
 */