import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class vks
  extends JobSegment<Integer, ujb>
{
  private uja a;
  
  public vks(@NonNull uja paramuja)
  {
    this.a = paramuja;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((ujb)localObject).a.size() > 0) || (((ujb)localObject).b))
    {
      urk.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new tal();
    ((tal)localObject).a = this.a.a();
    slv.a().a((slz)localObject, new vkt(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vks
 * JD-Core Version:    0.7.0.1
 */