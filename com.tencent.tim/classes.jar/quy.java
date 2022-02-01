import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.List;

public class quy
{
  private plx.d<qvc> a;
  
  public void brc()
  {
    try
    {
      if (this.a != null)
      {
        this.a.destroy();
        this.a = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void eD(List<qvc> paramList)
  {
    try
    {
      if (this.a == null) {
        this.a = new plx.d(new quy.a());
      }
      this.a.dR(paramList);
      return;
    }
    finally {}
  }
  
  public static class a
    extends plx.a<qvc>
  {
    private Stream<qrl.b> c;
    
    public void a(qvc paramqvc)
    {
      this.c = Stream.of(paramqvc).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new quy.b(null));
      this.c.subscribe(new qva(this));
    }
    
    public void destroy()
    {
      ram.w("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
      if (this.c != null)
      {
        this.c.cancel();
        this.c = null;
      }
    }
  }
  
  static class b
    extends JobSegment<qvc, qrl.b>
  {
    private int bmm;
    private qrl e;
    private List<CommentEntry> nh = new ArrayList();
    
    protected void a(JobContext paramJobContext, qvc paramqvc)
    {
      this.e = new qrl(paramqvc, new qvb(this, paramJobContext, paramqvc));
      this.e.aPh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     quy
 * JD-Core Version:    0.7.0.1
 */