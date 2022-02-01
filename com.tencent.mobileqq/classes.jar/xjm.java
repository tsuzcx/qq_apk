import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class xjm
  implements xje
{
  private final xjl a;
  
  public xjm(xjl paramxjl)
  {
    this.a = paramxjl;
  }
  
  public void a(xjf paramxjf)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new wsi("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.c, this.a.d, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.a == 5) {
      localStream1 = localStream2.map(new wsf()).map(new wrv(this.a.a));
    }
    localStream1.subscribe(new xjn(this, paramxjf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjm
 * JD-Core Version:    0.7.0.1
 */