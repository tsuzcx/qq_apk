package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;

class IjkMediaFormat$4
  extends IjkMediaFormat.Formatter
{
  IjkMediaFormat$4(IjkMediaFormat paramIjkMediaFormat)
  {
    super(null);
  }
  
  protected String doFormat(IjkMediaFormat paramIjkMediaFormat)
  {
    String str;
    switch (paramIjkMediaFormat.getInteger("codec_profile_id"))
    {
    default: 
      return null;
    case 66: 
      str = "Baseline";
    }
    StringBuilder localStringBuilder;
    int i;
    for (;;)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      str = paramIjkMediaFormat.getString("codec_name");
      if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("h264"))) {
        break label301;
      }
      i = paramIjkMediaFormat.getInteger("codec_level");
      if (i >= 10) {
        break;
      }
      return localStringBuilder.toString();
      str = "Constrained Baseline";
      continue;
      str = "Main";
      continue;
      str = "Extended";
      continue;
      str = "High";
      continue;
      str = "High 10";
      continue;
      str = "High 10 Intra";
      continue;
      str = "High 4:2:2";
      continue;
      str = "High 4:2:2 Intra";
      continue;
      str = "High 4:4:4";
      continue;
      str = "High 4:4:4 Predictive";
      continue;
      str = "High 4:4:4 Intra";
      continue;
      str = "CAVLC 4:4:4";
    }
    localStringBuilder.append(" Profile Level ");
    localStringBuilder.append(i / 10 % 10);
    if (i % 10 != 0)
    {
      localStringBuilder.append(".");
      localStringBuilder.append(i % 10);
    }
    label301:
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkMediaFormat.4
 * JD-Core Version:    0.7.0.1
 */