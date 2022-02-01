package tv.danmaku.ijk.media.player.misc;

import java.io.IOException;

public abstract interface IAndroidIO
{
  public abstract int close()
    throws IOException;
  
  public abstract int open(String paramString)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt)
    throws IOException;
  
  public abstract long seek(long paramLong, int paramInt)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IAndroidIO
 * JD-Core Version:    0.7.0.1
 */