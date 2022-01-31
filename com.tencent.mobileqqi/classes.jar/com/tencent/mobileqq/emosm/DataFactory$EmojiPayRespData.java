package com.tencent.mobileqq.emosm;

import android.os.Bundle;

public class DataFactory$EmojiPayRespData
{
  public String message = "";
  public int payChannel = -1;
  public int payState = -1;
  public int provideState = -1;
  public int realSaveNum = 0;
  public int result = -1;
  
  public DataFactory$EmojiPayRespData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    this.result = paramInt1;
    this.realSaveNum = paramInt2;
    this.payChannel = paramInt3;
    this.payState = paramInt4;
    this.provideState = paramInt5;
    this.message = paramString;
  }
  
  public static EmojiPayRespData makeEmojiPayRespData(Bundle paramBundle)
  {
    int j = 0;
    int n = -1;
    String str = "";
    int i;
    int k;
    int m;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("result", -1);
      j = paramBundle.getInt("realSaveNum", 0);
      k = paramBundle.getInt("payChannel", -1);
      m = paramBundle.getInt("payState", -1);
      n = paramBundle.getInt("provideState", -1);
    }
    for (paramBundle = paramBundle.getString("message");; paramBundle = str)
    {
      return new EmojiPayRespData(i, j, k, m, n, paramBundle);
      m = -1;
      k = -1;
      i = -1;
    }
  }
  
  public Bundle getBundleData()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", this.result);
    localBundle.putInt("realSaveNum", this.realSaveNum);
    localBundle.putInt("payChannel", this.payChannel);
    localBundle.putInt("payState", this.payState);
    localBundle.putInt("provideState", this.provideState);
    localBundle.putString("message", this.message);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.DataFactory.EmojiPayRespData
 * JD-Core Version:    0.7.0.1
 */