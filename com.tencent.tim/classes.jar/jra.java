import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

final class jra
  extends ThreadLocal<CharsetDecoder>
{
  protected CharsetDecoder a()
  {
    return Charset.forName("UTF-8").newDecoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jra
 * JD-Core Version:    0.7.0.1
 */