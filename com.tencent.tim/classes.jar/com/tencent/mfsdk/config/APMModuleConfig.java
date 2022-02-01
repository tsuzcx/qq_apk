package com.tencent.mfsdk.config;

import android.text.TextUtils;
import org.json.JSONObject;

public class APMModuleConfig
{
  public static final JSONObject EMPTY = new JSONObject();
  public float evenRatio = 0.01F;
  public int maxReport = 10;
  public int stackDepth = 6;
  public String strategy = "";
  public int threshold = 100;
  public float userRatio = 0.001F;
  
  public boolean canOpenPlugin()
  {
    return this.userRatio > Math.random();
  }
  
  @Deprecated
  public final String getOldStrategy(String paramString)
  {
    String str = this.strategy;
    if (TextUtils.isEmpty(str)) {
      return paramString;
    }
    return str;
  }
  
  public String toString()
  {
    return "threshold=" + this.threshold + ", maxReport=" + this.maxReport + ", userRatio=" + this.userRatio + ", evenRatio=" + this.evenRatio + ", stackDepth=" + this.stackDepth + ", strategy='" + this.strategy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.config.APMModuleConfig
 * JD-Core Version:    0.7.0.1
 */