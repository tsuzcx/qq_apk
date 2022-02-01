package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.Context;
import android.graphics.Paint;
import android.text.style.ForegroundColorSpan;
import android.util.SparseIntArray;
import aoff;
import nqg;
import nqi;

public class BiuNicknameSpan
  extends ForegroundColorSpan
  implements nqg, nqi
{
  private int displayWidth = -1;
  public long mFeedId;
  private String mNickname;
  public String mUin;
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    super(-15504151);
    this.mUin = paramString;
    this.mFeedId = paramLong;
    if (paramCharSequence != null) {}
    for (paramString = paramCharSequence.toString();; paramString = "")
    {
      this.mNickname = paramString;
      return;
    }
  }
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence, Context paramContext, Paint paramPaint, int paramInt)
  {
    super(-15504151);
    this.mUin = paramString;
    this.mFeedId = paramLong;
    if (paramCharSequence != null) {}
    for (paramString = paramCharSequence.toString();; paramString = "")
    {
      this.mNickname = paramString;
      return;
    }
  }
  
  public static String d(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int k = paramCharSequence.codePointAt(i);
      int j;
      if ((k == 20) && (i < paramCharSequence.length() - 1))
      {
        paramCharSequence.delete(i, i + 2);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (aoff.ah.get(k, -1) < 0);
      if ((k > 65535) && (paramCharSequence.length() >= i + 2)) {
        paramCharSequence.delete(i, i + 2);
      }
      for (;;)
      {
        j = i - 1;
        break;
        paramCharSequence.delete(i, i + 1);
      }
    }
    return paramCharSequence.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan
 * JD-Core Version:    0.7.0.1
 */