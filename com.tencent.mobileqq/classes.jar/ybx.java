import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class ybx
  extends vzo<ycb>
{
  private Stream<xvl> a;
  
  public void a(ycb paramycb)
  {
    this.a = Stream.of(paramycb).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new ybz(null));
    this.a.subscribe(new yby(this));
  }
  
  public void c()
  {
    ykq.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybx
 * JD-Core Version:    0.7.0.1
 */