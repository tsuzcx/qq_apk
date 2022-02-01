package com.tencent.mobileqq.servlet;

import android.content.ContentResolver;
import android.content.ContentValues;
import aneo;
import avsd;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;
import sxe;

public class QZoneManagerImp$3
  implements Runnable
{
  public QZoneManagerImp$3(aneo paramaneo, avsd paramavsd, int paramInt) {}
  
  public void run()
  {
    if (aneo.a(this.this$0) == null) {
      return;
    }
    ContentValues localContentValues = this.b.b();
    localContentValues.put("own_uin", aneo.a(this.this$0).getAccount());
    localContentValues.put("type", Integer.valueOf(this.val$type));
    try
    {
      aneo.a(this.this$0).getApplication().getContentResolver().insert(sxe.u, localContentValues);
      return;
    }
    catch (Exception localException)
    {
      this.this$0.f(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.3
 * JD-Core Version:    0.7.0.1
 */