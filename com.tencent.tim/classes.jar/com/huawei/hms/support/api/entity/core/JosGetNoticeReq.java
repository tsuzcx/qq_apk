package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.annotation.Packed;

public class JosGetNoticeReq
  extends JosBaseReq
{
  public static final int NOTICE_TYPE_CONN = 0;
  public static final int NOTICE_TYPE_SIGN = 1;
  @Packed
  private int noticeType;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public int getNoticeType()
  {
    return ((Integer)get(Integer.valueOf(this.noticeType))).intValue();
  }
  
  public void setNoticeType(int paramInt)
  {
    this.noticeType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.core.JosGetNoticeReq
 * JD-Core Version:    0.7.0.1
 */