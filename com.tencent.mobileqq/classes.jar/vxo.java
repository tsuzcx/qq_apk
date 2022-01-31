import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class vxo
  extends JobSegment<Integer, uvx>
{
  private uvw a;
  
  public vxo(@NonNull uvw paramuvw)
  {
    this.a = paramuvw;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((uvx)localObject).a.size() > 0) || (((uvx)localObject).b))
    {
      veg.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new tnh();
    ((tnh)localObject).a = this.a.a();
    syr.a().a((syv)localObject, new vxp(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxo
 * JD-Core Version:    0.7.0.1
 */