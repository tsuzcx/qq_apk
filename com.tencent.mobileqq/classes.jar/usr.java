import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class usr
  extends JobSegment<Integer, uvu>
{
  private uvt a;
  
  public usr(@NonNull uvt paramuvt)
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
    localObject = new tmq();
    ((tmq)localObject).a = this.a.a();
    ((tmq)localObject).b = QQStoryContext.a().b();
    syo.a().a((sys)localObject, new uss(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usr
 * JD-Core Version:    0.7.0.1
 */