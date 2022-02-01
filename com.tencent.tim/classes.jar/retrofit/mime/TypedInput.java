package retrofit.mime;

import java.io.IOException;
import java.io.InputStream;

public abstract interface TypedInput
{
  public abstract InputStream in()
    throws IOException;
  
  public abstract long length();
  
  public abstract String mimeType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.mime.TypedInput
 * JD-Core Version:    0.7.0.1
 */