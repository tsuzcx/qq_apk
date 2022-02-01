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
    switch (paramIjkMediaFormat.getInteger("codec_profile_id"))
    {
    default: 
      return null;
    case 2292: 
      str = "High 4:4:4 Intra";
      break;
    case 2170: 
      str = "High 4:2:2 Intra";
      break;
    case 2158: 
      str = "High 10 Intra";
      break;
    case 578: 
      str = "Constrained Baseline";
      break;
    case 244: 
      str = "High 4:4:4 Predictive";
      break;
    case 144: 
      str = "High 4:4:4";
      break;
    case 122: 
      str = "High 4:2:2";
      break;
    case 110: 
      str = "High 10";
      break;
    case 100: 
      str = "High";
      break;
    case 88: 
      str = "Extended";
      break;
    case 77: 
      str = "Main";
      break;
    case 66: 
      str = "Baseline";
      break;
    case 44: 
      str = "CAVLC 4:4:4";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    String str = paramIjkMediaFormat.getString("codec_name");
    if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase("h264")))
    {
      int i = paramIjkMediaFormat.getInteger("codec_level");
      if (i < 10) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(" Profile Level ");
      localStringBuilder.append(i / 10 % 10);
      i %= 10;
      if (i != 0)
      {
        localStringBuilder.append(".");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkMediaFormat.4
 * JD-Core Version:    0.7.0.1
 */