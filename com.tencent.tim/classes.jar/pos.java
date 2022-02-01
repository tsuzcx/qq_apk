import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class pos
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  public pos.a a;
  protected AtomicInteger ai = new AtomicInteger(0);
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    startUpload();
  }
  
  public void a(pos.a parama)
  {
    this.a = parama;
  }
  
  protected void bmd()
  {
    if (this.a != null) {
      this.a.a(this);
    }
  }
  
  protected abstract void startUpload();
  
  public static abstract interface a
  {
    public abstract void a(pos parampos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pos
 * JD-Core Version:    0.7.0.1
 */