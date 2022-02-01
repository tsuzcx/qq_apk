package com.tencent.secframework;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.secprotocol.ByteData;
import com.tencent.secprotocol.ByteData.a;
import com.tencent.token.ah;
import com.tencent.token.x;

public class TsakDispatchSrv
{
  public static Handler mTaskHandler;
  public String mAppID = "";
  public String mDevID = "";
  public final String mThradName = "PoolThread";
  public HandlerThread mhandlerThread = null;
  public x subClassTask;
  
  public TsakDispatchSrv()
  {
    try
    {
      this.mhandlerThread = new HandlerThread("PoolThread");
      this.mhandlerThread.start();
      mTaskHandler = new a(this.mhandlerThread.getLooper());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private native int runTask(Context paramContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  public void addTask(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      Object localObject = new ah(paramInt2, paramInt3, paramObject);
      Message localMessage = mTaskHandler.obtainMessage(paramInt1);
      localMessage.obj = localObject;
      localObject = new StringBuilder("reportsrv_java --> putType: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" cmd: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" reqTyep: ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" cabk report log ");
      ((StringBuilder)localObject).append(paramObject);
      mTaskHandler.sendMessage(localMessage);
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void executeTask(int paramInt1, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return;
    }
    long l1 = paramInt1;
    long l2 = paramInt2;
    long l3 = paramInt3;
    try
    {
      runTask(null, l1, l2, l3, 0L, paramObject1, this.mAppID, null, paramObject2);
      return;
    }
    catch (Exception paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public Handler getTaskHandler()
  {
    return mTaskHandler;
  }
  
  public void setTerminalInfo(Context paramContext, String paramString1, String paramString2, x paramx)
  {
    this.mAppID = paramString1;
    this.mDevID = paramString2;
    this.subClassTask = paramx;
  }
  
  public final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      ah localah = (ah)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
      case 163: 
        if (TsakDispatchSrv.access$000(TsakDispatchSrv.this) != null)
        {
          paramMessage = TsakDispatchSrv.access$000(TsakDispatchSrv.this);
          int i = localah.a;
          ((ByteData.a)paramMessage).a.myTasks(i, localah);
          return;
        }
        break;
      case 161: 
      case 162: 
        StringBuilder localStringBuilder = new StringBuilder("cmd: ");
        localStringBuilder.append(localah.a);
        localStringBuilder.append(" reqType: ");
        localStringBuilder.append(localah.b);
        TsakDispatchSrv.this.executeTask(paramMessage.what, localah.a, localah.b, localah.c, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.secframework.TsakDispatchSrv
 * JD-Core Version:    0.7.0.1
 */