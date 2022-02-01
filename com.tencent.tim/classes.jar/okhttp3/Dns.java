package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public abstract interface Dns
{
  public static final Dns SYSTEM = new Dns.1();
  
  public abstract List<InetAddress> lookup(String paramString)
    throws UnknownHostException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Dns
 * JD-Core Version:    0.7.0.1
 */