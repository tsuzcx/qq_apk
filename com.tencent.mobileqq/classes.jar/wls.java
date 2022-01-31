import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class wls
  extends JobSegment<Integer, wov>
{
  private wou a;
  
  public wls(@NonNull wou paramwou)
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
    localObject = new vfr();
    ((vfr)localObject).a = this.a.a();
    ((vfr)localObject).b = QQStoryContext.a().b();
    urp.a().a((urt)localObject, new wlt(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wls
 * JD-Core Version:    0.7.0.1
 */