package com.tencent.qqmail.bottle.fragment.adapter;

import android.content.Context;
import com.tencent.qqmail.QMApplicationContext;

final class CommonUI
{
  private static final String TAG = "CommonUI";
  
  public static String getFormatDistance(int paramInt, String paramString)
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    int i = paramInt / 1000;
    String str;
    if ((paramInt > 0) && (i == 0))
    {
      paramString = localQMApplicationContext.getString(2131690968);
      str = paramInt + paramString;
    }
    do
    {
      return str;
      if ((paramInt > 0) && (i <= 5))
      {
        paramString = localQMApplicationContext.getString(2131690967);
        return i + paramString;
      }
      if (paramString == null) {
        break;
      }
      str = paramString;
    } while (paramString.length() > 0);
    return localQMApplicationContext.getString(2131690966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.adapter.CommonUI
 * JD-Core Version:    0.7.0.1
 */