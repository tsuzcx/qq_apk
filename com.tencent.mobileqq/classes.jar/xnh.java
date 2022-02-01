import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class xnh
  implements xmz
{
  private final xng a;
  
  public xnh(xng paramxng)
  {
    this.a = paramxng;
  }
  
  public void a(xna paramxna)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new wwd("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.c, this.a.d, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.a == 5) {
      localStream1 = localStream2.map(new wwa()).map(new wvq(this.a.a));
    }
    localStream1.subscribe(new xni(this, paramxna));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnh
 * JD-Core Version:    0.7.0.1
 */