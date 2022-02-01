package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

public abstract interface Connection
{
  @Nullable
  public abstract Handshake handshake();
  
  public abstract Protocol protocol();
  
  public abstract Route route();
  
  public abstract Socket socket();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Connection
 * JD-Core Version:    0.7.0.1
 */