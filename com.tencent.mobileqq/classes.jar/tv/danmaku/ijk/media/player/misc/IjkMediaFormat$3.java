package tv.danmaku.ijk.media.player.misc;

import java.util.Locale;

class IjkMediaFormat$3
  extends IjkMediaFormat.Formatter
{
  IjkMediaFormat$3(IjkMediaFormat paramIjkMediaFormat)
  {
    super(null);
  }
  
  protected String doFormat(IjkMediaFormat paramIjkMediaFormat)
  {
    int i = paramIjkMediaFormat.getInteger("bitrate");
    if (i <= 0) {
      return null;
    }
    if (i < 1000) {
      return String.format(Locale.US, "%d bit/s", new Object[] { Integer.valueOf(i) });
    }
    return String.format(Locale.US, "%d kb/s", new Object[] { Integer.valueOf(i / 1000) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkMediaFormat.3
 * JD-Core Version:    0.7.0.1
 */