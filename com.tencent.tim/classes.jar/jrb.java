import java.nio.charset.Charset;

final class jrb
  extends ThreadLocal<Charset>
{
  protected Charset b()
  {
    return Charset.forName("UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrb
 * JD-Core Version:    0.7.0.1
 */