package com.qzone.report;

import android.util.SparseArray;

public class ExtendData
{
  private static final int EXTEND_COUNT = 11;
  public static final int EXTEND_POS_BUSINESS_REFER = 9;
  public static final int EXTEND_POS_DNS = 6;
  public static final int EXTEND_POS_DOWNLOAD_EXTRAINFO = 10;
  public static final int EXTEND_POS_IS_SD_EXIST = 2;
  public static final int EXTEND_POS_IS_USB = 7;
  public static final int EXTEND_POS_MODEL = 0;
  public static final int EXTEND_POS_OS = 1;
  public static final int EXTEND_POS_SD_AVAIL = 4;
  public static final int EXTEND_POS_SD_TOTAL = 3;
  public static final int EXTEND_POS_TASK_STATE = 8;
  public static final int EXTEND_POS_UPLOAD_PATH = 5;
  private SparseArray<String> extendDataList = new SparseArray(11);
  
  public String getExtendString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)this.extendDataList.get(0, ""));
    int i = 1;
    for (;;)
    {
      if (i >= 11) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append("|");
      localStringBuilder.append((String)this.extendDataList.get(i, ""));
      i += 1;
    }
  }
  
  public void put(int paramInt, String paramString)
  {
    this.extendDataList.put(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.report.ExtendData
 * JD-Core Version:    0.7.0.1
 */