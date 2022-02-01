package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class WindowsLineEndingInputStream
  extends InputStream
{
  private final boolean ensureLineFeedAtEndOfFile;
  private boolean eofSeen = false;
  private boolean injectSlashN = false;
  private boolean slashNSeen = false;
  private boolean slashRSeen = false;
  private final InputStream target;
  
  public WindowsLineEndingInputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this.target = paramInputStream;
    this.ensureLineFeedAtEndOfFile = paramBoolean;
  }
  
  private int eofGame()
  {
    if (!this.ensureLineFeedAtEndOfFile) {}
    do
    {
      return -1;
      if ((!this.slashNSeen) && (!this.slashRSeen))
      {
        this.slashRSeen = true;
        return 13;
      }
    } while (this.slashNSeen);
    this.slashRSeen = false;
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
    if (i == 13)
    {
      bool1 = true;
      this.slashRSeen = bool1;
      if (i != 10) {
        break label69;
      }
    }
    label69:
    for (bool1 = bool2;; bool1 = false)
    {
      this.slashNSeen = bool1;
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
      throw new UnsupportedOperationException("Mark not supported");
    }
    finally {}
  }
  
  public int read()
    throws IOException
  {
    if (this.eofSeen) {
      return eofGame();
    }
    if (this.injectSlashN)
    {
      this.injectSlashN = false;
      return 10;
    }
    boolean bool = this.slashRSeen;
    int i = readWithUpdate();
    if (this.eofSeen) {
      return eofGame();
    }
    if ((i == 10) && (!bool))
    {
      this.injectSlashN = true;
      return 13;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.WindowsLineEndingInputStream
 * JD-Core Version:    0.7.0.1
 */