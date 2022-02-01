package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class DemuxOutputStream
  extends OutputStream
{
  private final InheritableThreadLocal<OutputStream> outputStreamThreadLocal = new InheritableThreadLocal();
  
  public OutputStream bindStream(OutputStream paramOutputStream)
  {
    OutputStream localOutputStream = (OutputStream)this.outputStreamThreadLocal.get();
    this.outputStreamThreadLocal.set(paramOutputStream);
    return localOutputStream;
  }
  
  public void close()
    throws IOException
  {
    OutputStream localOutputStream = (OutputStream)this.outputStreamThreadLocal.get();
    if (localOutputStream != null) {
      localOutputStream.close();
    }
  }
  
  public void flush()
    throws IOException
  {
    OutputStream localOutputStream = (OutputStream)this.outputStreamThreadLocal.get();
    if (localOutputStream != null) {
      localOutputStream.flush();
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    OutputStream localOutputStream = (OutputStream)this.outputStreamThreadLocal.get();
    if (localOutputStream != null) {
      localOutputStream.write(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.output.DemuxOutputStream
 * JD-Core Version:    0.7.0.1
 */