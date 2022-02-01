import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class zns
  extends JobSegment<Integer, ymb>
{
  private yma a;
  
  public zns(@NonNull yma paramyma)
  {
    this.a = paramyma;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((ymb)localObject).a.size() > 0) || (((ymb)localObject).b))
    {
      yuk.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new xdm();
    ((xdm)localObject).a = this.a.a();
    wow.a().a((wpa)localObject, new znt(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zns
 * JD-Core Version:    0.7.0.1
 */