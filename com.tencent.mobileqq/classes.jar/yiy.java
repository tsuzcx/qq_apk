import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class yiy
  extends JobSegment<Integer, ymb>
{
  private yma a;
  
  public yiy(@NonNull yma paramyma)
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
    localObject = new xcy();
    ((xcy)localObject).a = this.a.a();
    ((xcy)localObject).b = QQStoryContext.a().b();
    wow.a().a((wpa)localObject, new yiz(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiy
 * JD-Core Version:    0.7.0.1
 */