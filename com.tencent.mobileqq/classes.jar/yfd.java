import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class yfd
  extends JobSegment<Integer, yig>
{
  private yif a;
  
  public yfd(@NonNull yif paramyif)
  {
    this.a = paramyif;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((yig)localObject).a.size() > 0) || (((yig)localObject).b))
    {
      yqp.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new wzd();
    ((wzd)localObject).a = this.a.a();
    ((wzd)localObject).b = QQStoryContext.a().b();
    wlb.a().a((wlf)localObject, new yfe(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfd
 * JD-Core Version:    0.7.0.1
 */