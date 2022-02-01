package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class UnixLineEndingInputStream
  extends InputStream
{
  private final boolean ensureLineFeedAtEndOfFile;
  private boolean eofSeen = false;
  private boolean slashNSeen = false;
  private boolean slashRSeen = false;
  private final InputStream target;
  
  public UnixLineEndingInputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this.target = paramInputStream;
    this.ensureLineFeedAtEndOfFile = paramBoolean;
  }
  
  private int eofGame(boolean paramBoolean)
  {
    if ((paramBoolean) || (!this.ensureLineFeedAtEndOfFile)) {}
    while (this.slashNSeen) {
      return -1;
    }
    this.slashNSeen = true;
    return 10;
  }
  
  private int readWithUpdate()
    throws IOException
  {
    boolean bool2 = true;
    int i = this.target.read();
    if (i == -1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.eofSeen = bool1;
      if (!this.eofSeen) {
        break;
      }
      return i;
    }
    if (i == 10)
    {
      bool1 = true;
      this.slashNSeen = bool1;
      if (i != 13) {
        break label69;
      }
    }
    label69:
    for (bool1 = bool2;; bool1 = false)
    {
      this.slashRSeen = bool1;
      return i;
      bool1 = false;
      break;
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    this.target.close();
  }
  
  public void mark(int paramInt)
  {
    try
    {
      throw new UnsupportedOperationException("Mark notsupported");
    }
    finally {}
  }
  
  public int read()
    throws IOException
  {
    boolean bool = this.slashRSeen;
    int i;
    if (this.eofSeen) {
      i = eofGame(bool);
    }
    do
    {
      int j;
      do
      {
        return i;
        j = readWithUpdate();
        if (this.eofSeen) {
          return eofGame(bool);
        }
        if (this.slashRSeen) {
          return 10;
        }
        i = j;
      } while (!bool);
      i = j;
    } while (!this.slashNSeen);
    return read();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.UnixLineEndingInputStream
 * JD-Core Version:    0.7.0.1
 */