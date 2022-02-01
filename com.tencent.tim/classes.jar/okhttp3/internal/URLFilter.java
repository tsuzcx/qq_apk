package okhttp3.internal;

import java.io.IOException;
import java.net.URL;

public abstract interface URLFilter
{
  public abstract void checkURLPermitted(URL paramURL)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.URLFilter
 * JD-Core Version:    0.7.0.1
 */