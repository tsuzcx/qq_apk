import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class zjx
  extends JobSegment<Integer, yig>
{
  private yif a;
  
  public zjx(@NonNull yif paramyif)
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
    localObject = new wzr();
    ((wzr)localObject).a = this.a.a();
    wlb.a().a((wlf)localObject, new zjy(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjx
 * JD-Core Version:    0.7.0.1
 */