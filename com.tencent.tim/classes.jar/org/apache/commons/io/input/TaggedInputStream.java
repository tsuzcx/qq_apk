package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.io.TaggedIOException;

public class TaggedInputStream
  extends ProxyInputStream
{
  private final Serializable tag = UUID.randomUUID();
  
  public TaggedInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  protected void handleIOException(IOException paramIOException)
    throws IOException
  {
    throw new TaggedIOException(paramIOException, this.tag);
  }
  
  public boolean isCauseOf(Throwable paramThrowable)
  {
    return TaggedIOException.isTaggedWith(paramThrowable, this.tag);
  }
  
  public void throwIfCauseOf(Throwable paramThrowable)
    throws IOException
  {
    TaggedIOException.throwCauseIfTaggedWith(paramThrowable, this.tag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.TaggedInputStream
 * JD-Core Version:    0.7.0.1
 */