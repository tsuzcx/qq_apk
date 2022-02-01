package tv.danmaku.ijk.media.player.misc;

import java.util.Locale;

class IjkMediaFormat$6
  extends IjkMediaFormat.Formatter
{
  IjkMediaFormat$6(IjkMediaFormat paramIjkMediaFormat)
  {
    super(null);
  }
  
  protected String doFormat(IjkMediaFormat paramIjkMediaFormat)
  {
    int i = paramIjkMediaFormat.getInteger("width");
    int j = paramIjkMediaFormat.getInteger("height");
    int k = paramIjkMediaFormat.getInteger("sar_num");
    int m = paramIjkMediaFormat.getInteger("sar_den");
    if ((i <= 0) || (j <= 0)) {
      return null;
    }
    if ((k <= 0) || (m <= 0)) {
      return String.format(Locale.US, "%d x %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
    return String.format(Locale.US, "%d x %d [SAR %d:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkMediaFormat.6
 * JD-Core Version:    0.7.0.1
 */