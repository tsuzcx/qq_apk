package com.huawei.hianalytics.ab.bc.ef;

import android.util.Log;
import com.huawei.hianalytics.ab.gh.ab;

public class bc
{
  private boolean ab = false;
  private int bc = 4;
  
  private static String ab()
  {
    return "HiAnalyticsSDK_2.2.0.303" + ab.ab();
  }
  
  public void ab(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append("=======================================\n ").append(ab()).append("").append("\n=======================================");
    Log.i("HiAnalyticsSDK", localStringBuilder.toString());
    this.bc = paramInt;
    this.ab = true;
  }
  
  public void ab(int paramInt, String paramString1, String paramString2)
  {
    bc(paramInt, "HiAnalyticsSDK", paramString1 + "=> " + paramString2);
  }
  
  public void bc(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      Log.i(paramString1, paramString2);
      return;
    case 3: 
      Log.d(paramString1, paramString2);
      return;
    case 4: 
      Log.i(paramString1, paramString2);
      return;
    case 5: 
      Log.w(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public boolean bc(int paramInt)
  {
    return (this.ab) && (paramInt >= this.bc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ef.bc
 * JD-Core Version:    0.7.0.1
 */