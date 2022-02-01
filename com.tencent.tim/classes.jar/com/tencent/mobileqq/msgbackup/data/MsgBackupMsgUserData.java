package com.tencent.mobileqq.msgbackup.data;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public class MsgBackupMsgUserData
  extends RecentBaseData
{
  public String extra;
  public String name;
  public String uin;
  public int uinType;
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public long eI()
  {
    return 0L;
  }
  
  public long eJ()
  {
    return 0L;
  }
  
  public int ng()
  {
    return this.uinType;
  }
  
  public String qx()
  {
    return this.uin;
  }
  
  public String toString()
  {
    return this.uin + "_" + this.uinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData
 * JD-Core Version:    0.7.0.1
 */