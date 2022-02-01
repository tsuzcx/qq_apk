package tv.danmaku.ijk.media.player.misc;

import java.io.IOException;

public abstract interface IMediaDataSource
{
  public abstract void close()
    throws IOException;
  
  public abstract long getSize()
    throws IOException;
  
  public abstract int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IMediaDataSource
 * JD-Core Version:    0.7.0.1
 */