import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class tkh
  implements tjz
{
  private final tkg a;
  
  public tkh(tkg paramtkg)
  {
    this.a = paramtkg;
  }
  
  public void a(tka paramtka)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new stc("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.c, this.a.d, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.a == 5) {
      localStream1 = localStream2.map(new ssz()).map(new ssp(this.a.a));
    }
    localStream1.subscribe(new tki(this, paramtka));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkh
 * JD-Core Version:    0.7.0.1
 */