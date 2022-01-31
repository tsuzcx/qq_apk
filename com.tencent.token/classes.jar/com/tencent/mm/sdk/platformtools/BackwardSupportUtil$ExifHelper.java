package com.tencent.mm.sdk.platformtools;

import android.media.ExifInterface;
import java.io.IOException;

public class BackwardSupportUtil$ExifHelper
{
  public static int getExifOrientation(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      int i;
      if (paramString != null)
      {
        i = paramString.getAttributeInt("Orientation", -1);
        if (i == -1) {}
      }
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BackwardSupportUtil", "cannot read exif" + paramString);
        paramString = null;
      }
      return 90;
    }
    return 180;
    return 270;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper
 * JD-Core Version:    0.7.0.1
 */