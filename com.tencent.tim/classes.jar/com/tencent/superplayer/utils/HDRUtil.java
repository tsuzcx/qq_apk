package com.tencent.superplayer.utils;

import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public class HDRUtil
{
  public static final String HDR_NOT_SUPPORT = "notSupport";
  private static final String SEPARATOR = ",";
  private static boolean hasHDRChecked = false;
  private static StringBuilder hdrSupportStr = new StringBuilder();
  
  public static String getHDRSupportListStr()
  {
    int i = 0;
    label131:
    for (;;)
    {
      try
      {
        if (!hasHDRChecked)
        {
          hasHDRChecked = true;
          if (i <= 3)
          {
            if (!TPThumbplayerCapabilityHelper.isHDRsupport(i, 0, 0)) {
              break label131;
            }
            hdrSupportStr.append(i);
            hdrSupportStr.append(",");
            break label131;
          }
          if ((hdrSupportStr.length() > 0) && (hdrSupportStr.lastIndexOf(",") == hdrSupportStr.length() - 1)) {
            hdrSupportStr.deleteCharAt(hdrSupportStr.length() - 1);
          }
        }
        else
        {
          String str = hdrSupportStr.toString();
          return str;
        }
        if (hdrSupportStr.length() == 0)
        {
          hdrSupportStr.append("notSupport");
          continue;
          i += 1;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.HDRUtil
 * JD-Core Version:    0.7.0.1
 */