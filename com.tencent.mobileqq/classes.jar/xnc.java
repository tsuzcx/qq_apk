import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class xnc
  extends vkt<xng>
{
  private Stream<xgq> a;
  
  public void a(xng paramxng)
  {
    this.a = Stream.of(paramxng).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new xne(null));
    this.a.subscribe(new xnd(this));
  }
  
  public void c()
  {
    xvv.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnc
 * JD-Core Version:    0.7.0.1
 */