import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class wos
  implements wok
{
  private final wor a;
  
  public wos(wor paramwor)
  {
    this.a = paramwor;
  }
  
  public void a(wol paramwol)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new vxt("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.c, this.a.d, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.a == 5) {
      localStream1 = localStream2.map(new vxq()).map(new vxg(this.a.a));
    }
    localStream1.subscribe(new wot(this, paramwol));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wos
 * JD-Core Version:    0.7.0.1
 */