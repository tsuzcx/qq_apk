import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class xze
  extends JobSegment<Integer, ych>
{
  private ycg a;
  
  public xze(@NonNull ycg paramycg)
  {
    this.a = paramycg;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((ych)localObject).a.size() > 0) || (((ych)localObject).b))
    {
      ykq.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new wtj();
    ((wtj)localObject).a = this.a.a();
    ((wtj)localObject).b = QQStoryContext.a().b();
    wfi.a().a((wfm)localObject, new xzf(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xze
 * JD-Core Version:    0.7.0.1
 */