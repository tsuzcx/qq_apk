import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class uvk
  extends ssm<uvo>
{
  private Stream<uoy> a;
  
  public void a(uvo paramuvo)
  {
    this.a = Stream.of(paramuvo).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new uvm(null));
    this.a.subscribe(new uvl(this));
  }
  
  public void c()
  {
    ved.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvk
 * JD-Core Version:    0.7.0.1
 */