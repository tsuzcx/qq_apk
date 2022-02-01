import javax.net.ssl.SSLException;
import org.apache.http.conn.ssl.AbstractVerifier;

final class jqd
  extends AbstractVerifier
{
  jqd(String paramString) {}
  
  public final String toString()
  {
    return "CUSTOM_COMPATIBLE";
  }
  
  public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException
  {
    verify(this.TX, paramArrayOfString1, paramArrayOfString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     jqd
 * JD-Core Version:    0.7.0.1
 */