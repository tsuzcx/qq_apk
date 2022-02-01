import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class yhw
  extends wez<yia>
{
  private Stream<ybk> a;
  
  public void a(yia paramyia)
  {
    this.a = Stream.of(paramyia).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new yhy(null));
    this.a.subscribe(new yhx(this));
  }
  
  public void c()
  {
    yqp.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhw
 * JD-Core Version:    0.7.0.1
 */