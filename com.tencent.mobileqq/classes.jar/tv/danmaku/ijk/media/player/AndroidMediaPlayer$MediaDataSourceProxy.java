package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.media.MediaDataSource;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

@TargetApi(23)
class AndroidMediaPlayer$MediaDataSourceProxy
  extends MediaDataSource
{
  private final IMediaDataSource mMediaDataSource;
  
  public AndroidMediaPlayer$MediaDataSourceProxy(IMediaDataSource paramIMediaDataSource)
  {
    this.mMediaDataSource = paramIMediaDataSource;
  }
  
  public void close()
  {
    this.mMediaDataSource.close();
  }
  
  public long getSize()
  {
    return this.mMediaDataSource.getSize();
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.mMediaDataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.AndroidMediaPlayer.MediaDataSourceProxy
 * JD-Core Version:    0.7.0.1
 */