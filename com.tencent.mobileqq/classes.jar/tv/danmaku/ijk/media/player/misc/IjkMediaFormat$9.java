package tv.danmaku.ijk.media.player.misc;

import java.util.Locale;

class IjkMediaFormat$9
  extends IjkMediaFormat.Formatter
{
  IjkMediaFormat$9(IjkMediaFormat paramIjkMediaFormat)
  {
    super(null);
  }
  
  protected String doFormat(IjkMediaFormat paramIjkMediaFormat)
  {
    int i = paramIjkMediaFormat.getInteger("channel_layout");
    if (i <= 0) {
      return null;
    }
    if (i == 4L) {
      return "mono";
    }
    if (i == 3L) {
      return "stereo";
    }
    return String.format(Locale.US, "%x", new Object[] { Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkMediaFormat.9
 * JD-Core Version:    0.7.0.1
 */