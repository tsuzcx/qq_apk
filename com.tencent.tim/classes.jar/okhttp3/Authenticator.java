package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

public abstract interface Authenticator
{
  public static final Authenticator NONE = new Authenticator.1();
  
  @Nullable
  public abstract Request authenticate(@Nullable Route paramRoute, Response paramResponse)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Authenticator
 * JD-Core Version:    0.7.0.1
 */