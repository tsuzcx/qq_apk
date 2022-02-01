package tv.danmaku.ijk.media.player;

class MediaPlayerProxy$7
  implements IMediaPlayer.OnErrorListener
{
  MediaPlayerProxy$7(MediaPlayerProxy paramMediaPlayerProxy, IMediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    return this.val$finalListener.onError(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.MediaPlayerProxy.7
 * JD-Core Version:    0.7.0.1
 */