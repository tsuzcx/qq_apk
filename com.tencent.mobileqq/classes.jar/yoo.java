import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class yoo
  extends JobSegment<Integer, xnm>
{
  private xnl a;
  
  public yoo(@NonNull xnl paramxnl)
  {
    this.a = paramxnl;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((xnm)localObject).a.size() > 0) || (((xnm)localObject).b))
    {
      xvv.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new wfc();
    ((wfc)localObject).a = this.a.a();
    vqn.a().a((vqr)localObject, new yop(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yoo
 * JD-Core Version:    0.7.0.1
 */