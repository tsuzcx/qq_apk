import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class uir
  extends sft<uiv>
{
  private Stream<ucf> a;
  
  public void a(uiv paramuiv)
  {
    this.a = Stream.of(paramuiv).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new uit(null));
    this.a.subscribe(new uis(this));
  }
  
  public void c()
  {
    urk.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uir
 * JD-Core Version:    0.7.0.1
 */