import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class vls
  implements vlk
{
  private final vlr a;
  
  public vls(vlr paramvlr)
  {
    this.a = paramvlr;
  }
  
  public void a(vll paramvll)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new uun("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.c, this.a.d, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.a == 5) {
      localStream1 = localStream2.map(new uuk()).map(new uua(this.a.a));
    }
    localStream1.subscribe(new vlt(this, paramvll));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vls
 * JD-Core Version:    0.7.0.1
 */