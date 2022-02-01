import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class xdn
  implements xdf
{
  private final xdm a;
  
  public xdn(xdm paramxdm)
  {
    this.a = paramxdm;
  }
  
  public void a(xdg paramxdg)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new wmo("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.c, this.a.d, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.a == 5) {
      localStream1 = localStream2.map(new wml()).map(new wmb(this.a.a));
    }
    localStream1.subscribe(new xdo(this, paramxdg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdn
 * JD-Core Version:    0.7.0.1
 */