package com.tencent.mobileqq.vas;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import aogh;
import aogh.a;
import aqqm;
import aqqo;
import aqqp;
import aqqq;
import aqsm;
import aqsw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;
import java.io.Serializable;

public class QuickUpdateIPCModule
  extends QIPCModule
{
  private static String ACTION_DOWNLOAD = "download";
  private static QuickUpdateIPCModule a;
  private static String cvW = "query_version";
  
  public QuickUpdateIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QuickUpdateIPCModule a()
  {
    try
    {
      if (a == null) {
        a = new QuickUpdateIPCModule("QuickUpdateIPCModule");
      }
      QuickUpdateIPCModule localQuickUpdateIPCModule = a;
      return localQuickUpdateIPCModule;
    }
    finally {}
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean, aqqm paramaqqm)
  {
    Params localParams = new Params(null);
    localParams.intVal = paramInt;
    localParams.boolVal = paramBoolean;
    localParams.strVal1 = paramString;
    paramString = new Bundle();
    paramString.putSerializable("params", localParams);
    QIPCClientHelper.getInstance().callServer("QuickUpdateIPCModule", cvW, paramString, new aqqp(paramaqqm));
  }
  
  public static void a(long paramLong, String paramString, aogh paramaogh)
  {
    Bundle localBundle = new Bundle();
    if (paramaogh != null) {
      localBundle.putParcelable("binder", new BinderWarpper(paramaogh.asBinder()));
    }
    localBundle.putLong("bid", paramLong);
    localBundle.putString("scid", paramString);
    QIPCClientHelper.getInstance().callServer("QuickUpdateIPCModule", ACTION_DOWNLOAD, localBundle, null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle.setClassLoader(BinderWarpper.class.getClassLoader());
    Object localObject;
    if (ACTION_DOWNLOAD.equals(paramString))
    {
      long l = paramBundle.getLong("bid");
      localObject = paramBundle.getString("scid");
      paramString = null;
      if (paramBundle.containsKey("binder")) {
        paramString = new a(l, (String)localObject, aogh.a.asInterface(((BinderWarpper)paramBundle.getParcelable("binder")).binder), null);
      }
      QLog.e("QuickUpdateIPCModule", 1, "download listener: " + paramString);
      aqsw.a(l).download(null, l, (String)localObject, paramString, false);
    }
    for (;;)
    {
      return null;
      if (cvW.equals(paramString))
      {
        paramString = (Params)paramBundle.getSerializable("params");
        localObject = BaseApplicationImpl.getApplication();
        if (localObject == null)
        {
          QLog.e("QuickUpdateIPCModule", 1, "onCall fail null application");
          callbackResult(paramInt, EIPCResult.createResult(-102, paramBundle));
        }
        else
        {
          ((VasQuickUpdateManager)((QQAppInterface)((BaseApplicationImpl)localObject).getRuntime()).getManager(184)).queryItemVersion(paramString.intVal, paramString.strVal1, paramString.boolVal, false, 10000L, new aqqo(this, paramInt));
        }
      }
    }
  }
  
  public static class Params
    implements Serializable
  {
    public boolean boolVal;
    public int intVal;
    public String strVal1;
    public String strVal2;
  }
  
  static class a
    implements IBinder.DeathRecipient, aqqq
  {
    private aogh a;
    private long bid;
    private String scid;
    
    private a(long paramLong, String paramString, aogh paramaogh)
    {
      this.bid = paramLong;
      this.scid = paramString;
      this.a = paramaogh;
      try
      {
        paramaogh.asBinder().linkToDeath(this, 0);
        return;
      }
      catch (RemoteException paramString)
      {
        QLog.e("QuickUpdateIPCModule", 1, "linkToDeath fail: " + this, paramString);
      }
    }
    
    public void binderDied()
    {
      QLog.e("QuickUpdateIPCModule", 1, "binderDied: " + this);
      aqsw.a(this.bid).removeListener(this.bid, this.scid, this);
    }
    
    public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      QLog.e("QuickUpdateIPCModule", 1, "onCompleted: " + paramInt1 + ", " + this);
      try
      {
        this.a.onComplete(paramString1, paramInt1);
        return;
      }
      catch (RemoteException paramQQAppInterface)
      {
        QLog.e("QuickUpdateIPCModule", 1, "onCompleted: " + this, paramQQAppInterface);
      }
    }
    
    public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
    {
      try
      {
        this.a.onProgress(paramString1, paramLong2, paramLong3);
        return;
      }
      catch (RemoteException paramQQAppInterface)
      {
        QLog.e("QuickUpdateIPCModule", 1, "onProgress: " + this, paramQQAppInterface);
      }
    }
    
    public String toString()
    {
      return this.bid + "_" + this.scid + "," + super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.QuickUpdateIPCModule
 * JD-Core Version:    0.7.0.1
 */