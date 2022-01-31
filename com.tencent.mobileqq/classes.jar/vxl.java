import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class vxl
  extends JobSegment<Integer, uvu>
{
  private uvt a;
  
  public vxl(@NonNull uvt paramuvt)
  {
    this.a = paramuvt;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((uvu)localObject).a.size() > 0) || (((uvu)localObject).b))
    {
      ved.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new tne();
    ((tne)localObject).a = this.a.a();
    syo.a().a((sys)localObject, new vxm(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxl
 * JD-Core Version:    0.7.0.1
 */