import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class txa
  implements tws
{
  private final twz a;
  
  public txa(twz paramtwz)
  {
    this.a = paramtwz;
  }
  
  public void a(twt paramtwt)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new tfv("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.c, this.a.d, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.a == 5) {
      localStream1 = localStream2.map(new tfs()).map(new tfi(this.a.a));
    }
    localStream1.subscribe(new txb(this, paramtwt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txa
 * JD-Core Version:    0.7.0.1
 */