import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class uvn
  extends ssp<uvr>
{
  private Stream<upb> a;
  
  public void a(uvr paramuvr)
  {
    this.a = Stream.of(paramuvr).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new uvp(null));
    this.a.subscribe(new uvo(this));
  }
  
  public void c()
  {
    veg.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvn
 * JD-Core Version:    0.7.0.1
 */