package com.tencent.mobileqq.troop.enterEffect;

import apdr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

public class TroopEnterEffectManager$2
  implements Runnable
{
  public TroopEnterEffectManager$2(apdr paramapdr, group_effect_commu.TGetMyEffectRsp0x2 paramTGetMyEffectRsp0x2) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = BaseApplication.getContext().openFileOutput("troop_enter_effect_config_" + this.this$0.mApp.getCurrentAccountUin(), 0);
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.write(this.a.toByteArray());
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.flush();
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.close();
      }
      catch (IOException localIOException4)
      {
        FileOutputStream localFileOutputStream;
        localObject3 = localIOException1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localIOException1;
        QLog.e("TroopEnterEffect", 2, QLog.getStackTraceString(localIOException4));
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
          return;
        }
        catch (IOException localIOException2) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TroopEnterEffect", 2, QLog.getStackTraceString(localIOException2));
        return;
      }
      finally
      {
        if (localObject3 == null) {
          break label155;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("TroopEnterEffect", 2, QLog.getStackTraceString(localIOException1));
          return;
        }
      }
    }
    try
    {
      localObject3.close();
      label155:
      throw localObject2;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopEnterEffect", 2, QLog.getStackTraceString(localIOException3));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager.2
 * JD-Core Version:    0.7.0.1
 */