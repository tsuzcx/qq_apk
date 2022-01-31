import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class whj
  extends JobSegment<Integer, wkm>
{
  private wkl a;
  
  public whj(@NonNull wkl paramwkl)
  {
    this.a = paramwkl;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((wkm)localObject).a.size() > 0) || (((wkm)localObject).b))
    {
      wsv.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new vbi();
    ((vbi)localObject).a = this.a.a();
    ((vbi)localObject).b = QQStoryContext.a().b();
    ung.a().a((unk)localObject, new whk(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whj
 * JD-Core Version:    0.7.0.1
 */