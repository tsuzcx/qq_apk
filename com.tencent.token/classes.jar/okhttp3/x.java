package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

class x
  implements w
{
  public List a(String paramString)
  {
    if (paramString == null) {
      throw new UnknownHostException("hostname == null");
    }
    try
    {
      List localList = Arrays.asList(InetAddress.getAllByName(paramString));
      return localList;
    }
    catch (NullPointerException localNullPointerException)
    {
      paramString = new UnknownHostException("Broken system behaviour for dns lookup of " + paramString);
      paramString.initCause(localNullPointerException);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.x
 * JD-Core Version:    0.7.0.1
 */