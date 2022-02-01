package com.tencent.android.tpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.message.d;
import com.tencent.android.tpush.message.d.a;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.RECEIVERCHECK, com.jg.EType.INTENTCHECK})
public class XGNotifaction
{
  private int a = 0;
  private Notification b = null;
  private String c = null;
  private String d = null;
  private String e = null;
  private Context f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  
  public XGNotifaction(Context paramContext, int paramInt, Notification paramNotification, d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.f = paramContext.getApplicationContext();
    this.a = paramInt;
    this.b = paramNotification;
    this.c = paramd.d();
    this.d = paramd.e();
    this.e = paramd.f();
    this.g = paramd.l().d;
    this.h = paramd.l().f;
    this.i = paramd.l().b;
  }
  
  public boolean doNotify()
  {
    if ((this.b != null) && (this.f != null))
    {
      NotificationManager localNotificationManager = (NotificationManager)this.f.getSystemService("notification");
      if (localNotificationManager != null)
      {
        localNotificationManager.notify(this.a, this.b);
        return true;
      }
    }
    return false;
  }
  
  public String getContent()
  {
    return this.d;
  }
  
  public String getCustomContent()
  {
    return this.e;
  }
  
  public Notification getNotifaction()
  {
    return this.b;
  }
  
  public int getNotifyId()
  {
    return this.a;
  }
  
  public String getTargetActivity()
  {
    return this.i;
  }
  
  public String getTargetIntent()
  {
    return this.g;
  }
  
  public String getTargetUrl()
  {
    return this.h;
  }
  
  public String getTitle()
  {
    return this.c;
  }
  
  public void setNotifyId(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String toString()
  {
    return "XGNotifaction [notifyId=" + this.a + ", title=" + this.c + ", content=" + this.d + ", customContent=" + this.e + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGNotifaction
 * JD-Core Version:    0.7.0.1
 */