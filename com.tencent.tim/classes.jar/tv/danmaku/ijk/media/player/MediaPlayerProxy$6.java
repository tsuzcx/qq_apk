package tv.danmaku.ijk.media.player;

class MediaPlayerProxy$6
  implements IMediaPlayer.OnVideoSizeChangedListener
{
  MediaPlayerProxy$6(MediaPlayerProxy paramMediaPlayerProxy, IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener) {}
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    this.val$finalListener.onVideoSizeChanged(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.MediaPlayerProxy.6
 * JD-Core Version:    0.7.0.1
 */