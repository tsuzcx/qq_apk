package tv.danmaku.ijk.media.player.misc;

public abstract interface IMediaDataSource
{
  public abstract void close();
  
  public abstract long getSize();
  
  public abstract int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IMediaDataSource
 * JD-Core Version:    0.7.0.1
 */