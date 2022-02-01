import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class aqjm
  extends PipedInputStream
{
  private int dZB = 1024;
  
  public aqjm(PipedOutputStream paramPipedOutputStream, int paramInt)
    throws IOException
  {
    super(paramPipedOutputStream);
    this.dZB = paramInt;
  }
  
  protected void receive(int paramInt)
    throws IOException
  {
    try
    {
      if (this.buffer.length != this.dZB) {
        this.buffer = new byte[this.dZB];
      }
      super.receive(paramInt);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjm
 * JD-Core Version:    0.7.0.1
 */