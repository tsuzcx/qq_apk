package retrofit.mime;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface TypedOutput
{
  public abstract String fileName();
  
  public abstract long length();
  
  public abstract String mimeType();
  
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.mime.TypedOutput
 * JD-Core Version:    0.7.0.1
 */