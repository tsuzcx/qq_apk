import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class apzn
  extends InputStream
{
  private boolean cTc = true;
  private int chunkSize;
  private boolean closed;
  private boolean eof;
  private InputStream mInputStream;
  private int pos;
  
  public apzn(InputStream paramInputStream)
  {
    this.mInputStream = paramInputStream;
  }
  
  private boolean aBI()
    throws IOException
  {
    if (!this.cTc) {}
    for (boolean bool = aBJ();; bool = false)
    {
      this.chunkSize = d(this.mInputStream);
      this.cTc = false;
      this.pos = 0;
      if (this.chunkSize == 0) {
        this.eof = true;
      }
      return (this.chunkSize >= 0) && (bool);
    }
  }
  
  private boolean aBJ()
    throws IOException
  {
    int i = this.mInputStream.read();
    int j = this.mInputStream.read();
    return (i == 13) && (j == 10);
  }
  
  private static int d(InputStream paramInputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInputStream == null) {
      return -1;
    }
    int i = 0;
    for (;;)
    {
      if (i != -1)
      {
        int j = paramInputStream.read();
        if (j == 123)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ChunkedInputStream", 1, "Server did not return any chunk");
          return -1;
        }
        switch (i)
        {
        default: 
          break;
        case 0: 
          if (j == 13) {
            i = 1;
          } else {
            localStringBuilder.append((char)j);
          }
          break;
        case 1: 
          if (j == 10) {
            i = -1;
          } else {
            throw new IOException("Read CRLF invalid!");
          }
          break;
        }
      }
    }
    return Integer.parseInt(localStringBuilder.toString(), 16);
  }
  
  public byte[] az()
    throws IOException
  {
    boolean bool = true;
    if (!this.cTc) {
      bool = aBJ();
    }
    this.cTc = false;
    if (this.mInputStream == null) {
      return new byte[0];
    }
    this.chunkSize = d(this.mInputStream);
    if (4 == this.chunkSize) {
      read(new byte[4], 0, 4);
    }
    if ((this.chunkSize <= 0) || (!bool)) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[this.chunkSize];
    int i = this.chunkSize;
    int j;
    do
    {
      j = read(arrayOfByte, this.pos, i);
      if (j < 0) {
        return new byte[0];
      }
      j = i - j;
      i = j;
    } while (j > 0);
    return arrayOfByte;
  }
  
  public int read()
    throws IOException
  {
    if (this.closed) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.eof) {}
    do
    {
      return -1;
      if (this.pos < this.chunkSize) {
        break;
      }
      aBI();
    } while (this.eof);
    this.pos += 1;
    return this.mInputStream.read();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = -1;
    if (this.closed) {
      throw new IOException("Attempted read from closed stream.");
    }
    int i;
    if (this.eof) {
      i = j;
    }
    do
    {
      boolean bool;
      do
      {
        do
        {
          return i;
          if (this.pos < this.chunkSize) {
            break;
          }
          bool = aBI();
          i = j;
        } while (this.eof);
        i = j;
      } while (!bool);
      paramInt2 = Math.min(paramInt2, this.chunkSize - this.pos);
      paramInt1 = this.mInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      this.pos += paramInt1;
      i = paramInt1;
    } while (this.pos != this.chunkSize);
    this.pos = 0;
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzn
 * JD-Core Version:    0.7.0.1
 */