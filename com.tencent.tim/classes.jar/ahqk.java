import java.io.IOException;
import java.io.Reader;

public final class ahqk
  extends ahqi
{
  private final char[] buffer = new char['ÿ'];
  private int bufferIndex;
  private int dataLen;
  private int length;
  private int offset;
  private final char[] p = new char[1024];
  private int start;
  private int status = -1;
  
  public ahqk(Reader paramReader)
  {
    this.a = paramReader;
  }
  
  private final ahqg b()
  {
    if (this.length > 0)
    {
      String str2 = "other";
      String str1 = str2;
      switch (Character.getType(this.buffer[0]))
      {
      default: 
        str1 = str2;
      }
      for (;;)
      {
        return new ahqg(new String(this.buffer, 0, this.length), this.start, this.start + this.length, str1);
        str1 = "num";
        continue;
        str1 = "en";
        continue;
        str1 = "cn";
      }
    }
    return null;
  }
  
  private final void b(char paramChar)
  {
    if (this.length == 0) {
      this.start = (this.offset - 1);
    }
    char[] arrayOfChar = this.buffer;
    int i = this.length;
    this.length = (i + 1);
    arrayOfChar[i] = Character.toLowerCase(paramChar);
  }
  
  public final ahqg a()
    throws IOException
  {
    this.length = 0;
    this.start = this.offset;
    char c;
    do
    {
      this.offset += 1;
      if (this.bufferIndex >= this.dataLen)
      {
        this.dataLen = this.a.read(this.p);
        this.bufferIndex = 0;
      }
      if (this.dataLen == -1)
      {
        this.status = -1;
        return b();
      }
      char[] arrayOfChar = this.p;
      int i = this.bufferIndex;
      this.bufferIndex = (i + 1);
      c = arrayOfChar[i];
      switch (Character.getType(c))
      {
      }
    } while (this.length <= 0);
    return b();
    if (this.status == -1) {
      this.status = 0;
    }
    do
    {
      do
      {
        b(c);
        if (this.length != 255) {
          break;
        }
        return b();
      } while (this.status == 0);
      this.status = 0;
    } while (this.length <= 0);
    this.bufferIndex -= 1;
    this.offset -= 1;
    return b();
    if (this.status == -1) {
      this.status = 1;
    }
    do
    {
      do
      {
        b(c);
        if (this.length != 255) {
          break;
        }
        return b();
      } while (this.status == 1);
      this.status = 1;
    } while (this.length <= 0);
    this.bufferIndex -= 1;
    this.offset -= 1;
    return b();
    if (this.status == -1) {
      this.status = 2;
    }
    do
    {
      do
      {
        b(c);
        return b();
      } while (this.status == 2);
      this.status = 2;
    } while (this.length <= 0);
    this.bufferIndex -= 1;
    this.offset -= 1;
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqk
 * JD-Core Version:    0.7.0.1
 */