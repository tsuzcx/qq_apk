package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Intent;
import com.jg.JgClassChecked;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.RECEIVERCHECK, com.jg.EType.INTENTCHECK})
public class XGSysNotifaction
{
  private int a;
  private Notification b;
  private String c;
  private Intent d;
  private int e;
  private Object f;
  
  public XGSysNotifaction(String paramString, int paramInt1, Notification paramNotification, Intent paramIntent, int paramInt2, Object paramObject)
  {
    this.c = paramString;
    this.a = paramInt1;
    this.b = paramNotification;
    this.d = paramIntent;
    this.e = paramInt2;
    this.f = paramObject;
  }
  
  public String getAppPkg()
  {
    return this.c;
  }
  
  public Notification getNotifaction()
  {
    return this.b;
  }
  
  public Object getNotificationChannle()
  {
    return this.f;
  }
  
  public int getNotifyId()
  {
    return this.a;
  }
  
  public Intent getPendintIntent()
  {
    return this.d;
  }
  
  public int getPendintIntentFlag()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGSysNotifaction
 * JD-Core Version:    0.7.0.1
 */