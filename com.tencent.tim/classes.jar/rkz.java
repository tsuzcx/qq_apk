import android.os.SystemClock;
import com.tribe.async.async.JobSegment;

public abstract class rkz<IN, OUT>
  extends JobSegment<IN, OUT>
{
  private long Ci;
  private final String TAG = "Q.qqstory.publish.edit." + getClass().getSimpleName();
  protected long mRunStartTime;
  
  public void call(IN paramIN)
  {
    this.mRunStartTime = SystemClock.uptimeMillis();
    super.call(paramIN);
  }
  
  public void notifyError(Error paramError)
  {
    this.Ci = SystemClock.uptimeMillis();
    super.notifyError(paramError);
  }
  
  public void notifyResult(OUT paramOUT)
  {
    this.Ci = SystemClock.uptimeMillis();
    super.notifyResult(paramOUT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkz
 * JD-Core Version:    0.7.0.1
 */