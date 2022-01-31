import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class vqb
  implements vpt
{
  private final vqa a;
  
  public vqb(vqa paramvqa)
  {
    this.a = paramvqa;
  }
  
  public void a(vpu paramvpu)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new uyw("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.c, this.a.d, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.a == 5) {
      localStream1 = localStream2.map(new uyt()).map(new uyj(this.a.a));
    }
    localStream1.subscribe(new vqc(this, paramvpu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqb
 * JD-Core Version:    0.7.0.1
 */