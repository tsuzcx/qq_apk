import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class xkj
  extends JobSegment<Integer, xnm>
{
  private xnl a;
  
  public xkj(@NonNull xnl paramxnl)
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
    localObject = new weo();
    ((weo)localObject).a = this.a.a();
    ((weo)localObject).b = QQStoryContext.a().b();
    vqn.a().a((vqr)localObject, new xkk(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkj
 * JD-Core Version:    0.7.0.1
 */