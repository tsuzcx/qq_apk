import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class ylr
  extends wiu<ylv>
{
  private Stream<yff> a;
  
  public void a(ylv paramylv)
  {
    this.a = Stream.of(paramylv).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new ylt(null));
    this.a.subscribe(new yls(this));
  }
  
  public void c()
  {
    yuk.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylr
 * JD-Core Version:    0.7.0.1
 */