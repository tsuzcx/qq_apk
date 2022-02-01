package com.tencent.gamecenter.appointment;

import android.text.TextUtils;
import ascc;
import awok;
import awol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;
import tba;

class GameCenterReceiver$1
  implements Runnable
{
  GameCenterReceiver$1(GameCenterReceiver paramGameCenterReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = ascc.qR(this.val$packageName);
    Iterator localIterator;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        awok.eEF();
        if (TextUtils.equals(this.val$actionName, "android.intent.action.PACKAGE_REMOVED"))
        {
          synchronized (this.this$0.listeners)
          {
            localObject1 = new WadlResult(new WadlParams((String)localObject1, this.val$packageName));
            ((WadlResult)localObject1).bBa = 11;
            localIterator = this.this$0.listeners.iterator();
            if (!localIterator.hasNext()) {
              break label147;
            }
            ((tba)localIterator.next()).b((WadlResult)localObject1);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GameCenterReceiver", 2, "receiveSystemInstallAction exception:" + localException.getMessage());
        }
      }
    }
    label147:
    do
    {
      do
      {
        do {}while (BaseApplicationImpl.sProcessId != 1);
        awok.a().jG("doUninstallAppCompleted", this.val$packageName);
        return;
      } while (!TextUtils.equals(this.val$actionName, "android.intent.action.PACKAGE_ADDED"));
      synchronized (this.this$0.listeners)
      {
        WadlResult localWadlResult = new WadlResult(new WadlParams(str, this.val$packageName));
        localWadlResult.bBa = 9;
        localIterator = this.this$0.listeners.iterator();
        if (localIterator.hasNext()) {
          ((tba)localIterator.next()).a(localWadlResult);
        }
      }
    } while (BaseApplicationImpl.sProcessId != 1);
    awok.a().jG("doInstallAppCompleted", this.val$packageName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.1
 * JD-Core Version:    0.7.0.1
 */