package com.tencent.qqmail.utilities;

import android.util.Log;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;

final class OneStepUtils$1
  implements DataListener
{
  public void onDataChange(long paramLong)
  {
    Log.d("OneStepUtils", "onDataChange, size:" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.OneStepUtils.1
 * JD-Core Version:    0.7.0.1
 */