package tv.danmaku.ijk.media.player.misc;

class IjkMediaFormat$7
  extends IjkMediaFormat.Formatter
{
  IjkMediaFormat$7(IjkMediaFormat paramIjkMediaFormat)
  {
    super(null);
  }
  
  protected String doFormat(IjkMediaFormat paramIjkMediaFormat)
  {
    int i = paramIjkMediaFormat.getInteger("fps_num");
    int j = paramIjkMediaFormat.getInteger("fps_den");
    if ((i <= 0) || (j <= 0)) {
      return null;
    }
    return String.valueOf(i / j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkMediaFormat.7
 * JD-Core Version:    0.7.0.1
 */