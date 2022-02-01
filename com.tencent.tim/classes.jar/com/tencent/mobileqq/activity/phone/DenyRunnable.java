package com.tencent.mobileqq.activity.phone;

import akwo;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;

public class DenyRunnable
  implements Runnable
{
  private long Lp;
  private b a;
  private int mFromType = 0;
  private final WeakReference<Context> mRef;
  
  public DenyRunnable(Context paramContext, int paramInt)
  {
    this.mRef = new WeakReference(paramContext);
    this.mFromType = paramInt;
  }
  
  public DenyRunnable(Context paramContext, b paramb)
  {
    this.mRef = new WeakReference(paramContext);
    this.a = paramb;
  }
  
  public void BR(boolean paramBoolean)
  {
    Context localContext = (Context)this.mRef.get();
    if (QLog.isColorLevel()) {
      QLog.i("DenyRunnable", 2, String.format("defaultAction [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), localContext }));
    }
    if (localContext == null) {}
    while (paramBoolean) {
      return;
    }
    Intent localIntent = new Intent(localContext, GuideBindPhoneActivity.class);
    localIntent.putExtra("fromKeyForContactBind", this.mFromType);
    localContext.startActivity(localIntent);
  }
  
  public void crj()
  {
    this.Lp = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.i("DenyRunnable", 2, "onReqPermission: " + this.Lp);
    }
  }
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime() - this.Lp;
    if ((this.Lp == 0L) || (Math.abs(l) < 800L)) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DenyRunnable", 2, String.format("run [%s, %s, %s]", new Object[] { Long.valueOf(this.Lp), Long.valueOf(l), Boolean.valueOf(bool) }));
      }
      if (this.a != null)
      {
        this.a.r((Context)this.mRef.get(), bool);
        return;
      }
      BR(bool);
      return;
    }
  }
  
  public static class a
    implements DenyRunnable.b
  {
    private int mFromType = 2;
    private WeakReference<QQAppInterface> mRef;
    
    public a(QQAppInterface paramQQAppInterface)
    {
      this.mRef = new WeakReference(paramQQAppInterface);
    }
    
    public void r(Context paramContext, boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        if (VersionUtils.isM())
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)this.mRef.get();
          if (localQQAppInterface != null) {
            ((PhoneContactManagerImp)localQQAppInterface.getManager(11)).AP(true);
          }
          paramContext = new akwo(paramContext, paramContext.getPackageName());
        }
      }
      else {
        try
        {
          paramContext.dDC();
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          paramContext.dDD();
          return;
        }
      }
      Intent localIntent = new Intent(paramContext, GuideBindPhoneActivity.class);
      localIntent.putExtra("fromKeyForContactBind", this.mFromType);
      paramContext.startActivity(localIntent);
    }
  }
  
  public static abstract interface b
  {
    public abstract void r(Context paramContext, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DenyRunnable
 * JD-Core Version:    0.7.0.1
 */