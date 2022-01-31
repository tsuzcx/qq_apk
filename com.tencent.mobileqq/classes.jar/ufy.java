import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class ufy
  extends JobSegment<Integer, ujb>
{
  private uja a;
  
  public ufy(@NonNull uja paramuja)
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
    localObject = new szx();
    ((szx)localObject).a = this.a.a();
    ((szx)localObject).b = QQStoryContext.a().b();
    slv.a().a((slz)localObject, new ufz(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufy
 * JD-Core Version:    0.7.0.1
 */