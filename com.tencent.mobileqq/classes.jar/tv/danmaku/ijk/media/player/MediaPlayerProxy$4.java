package tv.danmaku.ijk.media.player;

class MediaPlayerProxy$4
  implements IMediaPlayer.OnBufferingUpdateListener
{
  MediaPlayerProxy$4(MediaPlayerProxy paramMediaPlayerProxy, IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    this.val$finalListener.onBufferingUpdate(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.MediaPlayerProxy.4
 * JD-Core Version:    0.7.0.1
 */