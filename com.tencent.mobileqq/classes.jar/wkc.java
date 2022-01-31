import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class wkc
  extends uhe<wkg>
{
  private Stream<wdq> a;
  
  public void a(wkg paramwkg)
  {
    this.a = Stream.of(paramwkg).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new wke(null));
    this.a.subscribe(new wkd(this));
  }
  
  public void c()
  {
    wsv.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkc
 * JD-Core Version:    0.7.0.1
 */