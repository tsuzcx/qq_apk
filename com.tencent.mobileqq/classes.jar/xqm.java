import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class xqm
  extends JobSegment<Integer, wov>
{
  private wou a;
  
  public xqm(@NonNull wou paramwou)
  {
    this.a = paramwou;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((wov)localObject).a.size() > 0) || (((wov)localObject).b))
    {
      wxe.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new vgf();
    ((vgf)localObject).a = this.a.a();
    urp.a().a((urt)localObject, new xqn(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqm
 * JD-Core Version:    0.7.0.1
 */