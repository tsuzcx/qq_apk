package com.tencent.mobileqq.activity.qwallet;

import Wallet.PfaFriendRsp;
import aagd;
import aagi;
import aqhq;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import zzn;

public final class TopayManager$2
  implements Runnable
{
  public void run()
  {
    if (zzn.a == null) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = aagd.getQQAppInterface();
    if (localObject2 != null) {}
    try
    {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = aagi.bcU + (String)localObject1;
      localObject1 = localObject2;
      if (zzn.EP == 1)
      {
        localObject1 = localObject2;
        if (zzn.bGQ > 0)
        {
          localObject1 = localObject2;
          if (zzn.bGQ < 3) {
            localObject1 = (String)localObject2 + "_" + zzn.EP + "_" + zzn.bGQ;
          }
        }
      }
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new JceOutputStream();
      ((JceOutputStream)localObject2).setServerEncoding("utf-8");
      zzn.a.writeTo((JceOutputStream)localObject2);
      aqhq.writeFile(((JceOutputStream)localObject2).toByteArray(), (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TopayManager.2
 * JD-Core Version:    0.7.0.1
 */