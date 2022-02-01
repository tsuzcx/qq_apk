import java.io.File;
import java.util.concurrent.Callable;

class anxc
  implements Callable<File>
{
  anxc(anxb paramanxb) {}
  
  public File G()
    throws Exception
  {
    if (anxb.a(this.a).exists()) {
      return anxb.a(this.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxc
 * JD-Core Version:    0.7.0.1
 */