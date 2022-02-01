package tv.danmaku.ijk.media.player.misc;

import java.util.Locale;

class IjkMediaFormat$8
  extends IjkMediaFormat.Formatter
{
  IjkMediaFormat$8(IjkMediaFormat paramIjkMediaFormat)
  {
    super(null);
  }
  
  protected String doFormat(IjkMediaFormat paramIjkMediaFormat)
  {
    int i = paramIjkMediaFormat.getInteger("sample_rate");
    if (i <= 0) {
      return null;
    }
    return String.format(Locale.US, "%d Hz", new Object[] { Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkMediaFormat.8
 * JD-Core Version:    0.7.0.1
 */