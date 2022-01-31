import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class wol
  extends uln<wop>
{
  private Stream<whz> a;
  
  public void a(wop paramwop)
  {
    this.a = Stream.of(paramwop).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new won(null));
    this.a.subscribe(new wom(this));
  }
  
  public void c()
  {
    wxe.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wol
 * JD-Core Version:    0.7.0.1
 */