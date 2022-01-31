import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class usu
  extends JobSegment<Integer, uvx>
{
  private uvw a;
  
  public usu(@NonNull uvw paramuvw)
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
    localObject = new tmt();
    ((tmt)localObject).a = this.a.a();
    ((tmt)localObject).b = QQStoryContext.a().b();
    syr.a().a((syv)localObject, new usv(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usu
 * JD-Core Version:    0.7.0.1
 */