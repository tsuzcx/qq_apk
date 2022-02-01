package tv.danmaku.ijk.media.player.misc;

public abstract interface IAndroidIO
{
  public abstract int close();
  
  public abstract int open(String paramString);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt);
  
  public abstract long seek(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IAndroidIO
 * JD-Core Version:    0.7.0.1
 */