package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class AppendableOutputStream<T extends Appendable>
  extends OutputStream
{
  private final T appendable;
  
  public AppendableOutputStream(T paramT)
  {
    this.appendable = paramT;
  }
  
  public T getAppendable()
  {
    return this.appendable;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.appendable.append((char)paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.output.AppendableOutputStream
 * JD-Core Version:    0.7.0.1
 */