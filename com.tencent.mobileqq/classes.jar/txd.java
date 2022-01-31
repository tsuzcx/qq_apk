import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class txd
  implements twv
{
  private final txc a;
  
  public txd(txc paramtxc)
  {
    this.a = paramtxc;
  }
  
  public void a(tww paramtww)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new tfy("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.c, this.a.d, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.a == 5) {
      localStream1 = localStream2.map(new tfv()).map(new tfl(this.a.a));
    }
    localStream1.subscribe(new txe(this, paramtww));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txd
 * JD-Core Version:    0.7.0.1
 */