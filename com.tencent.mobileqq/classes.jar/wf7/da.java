package wf7;

import android.text.TextUtils;
import java.util.Arrays;

public class da
{
  public static int p(String paramString)
  {
    paramString = paramString.split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      boolean[] arrayOfBoolean = new boolean[11];
      int i = 0;
      Arrays.fill(arrayOfBoolean, false);
      int j = paramString.length;
      while (i < j)
      {
        CharSequence localCharSequence = paramString[i];
        if (!TextUtils.isEmpty(localCharSequence)) {}
        try
        {
          int k = Integer.parseInt(localCharSequence);
          if ((k > 0) && (k < 11)) {
            arrayOfBoolean[k] = true;
          }
        }
        catch (Exception localException)
        {
          label72:
          break label72;
        }
        i += 1;
      }
      if (arrayOfBoolean[2] != 0) {
        return 2;
      }
      if (arrayOfBoolean[6] != 0) {
        return 6;
      }
      if (arrayOfBoolean[4] != 0) {
        return 4;
      }
      if (arrayOfBoolean[10] != 0) {
        return 10;
      }
      if (arrayOfBoolean[3] != 0) {
        return 3;
      }
      if (arrayOfBoolean[8] != 0) {
        return 8;
      }
      if (arrayOfBoolean[9] != 0) {
        return 9;
      }
      if (arrayOfBoolean[7] != 0) {
        return 7;
      }
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.da
 * JD-Core Version:    0.7.0.1
 */