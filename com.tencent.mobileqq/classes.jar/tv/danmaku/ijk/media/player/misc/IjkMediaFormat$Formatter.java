package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;

abstract class IjkMediaFormat$Formatter
{
  protected abstract String doFormat(IjkMediaFormat paramIjkMediaFormat);
  
  public String format(IjkMediaFormat paramIjkMediaFormat)
  {
    String str = doFormat(paramIjkMediaFormat);
    paramIjkMediaFormat = str;
    if (TextUtils.isEmpty(str)) {
      paramIjkMediaFormat = getDefaultString();
    }
    return paramIjkMediaFormat;
  }
  
  protected String getDefaultString()
  {
    return "N/A";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
 * JD-Core Version:    0.7.0.1
 */