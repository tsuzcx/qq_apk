package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetGroupRedPackListRsp;
import aagi;
import android.text.TextUtils;
import aqhq;
import com.qq.taf.jce.JceOutputStream;
import java.io.File;

class RedPacketManager$8
  implements Runnable
{
  RedPacketManager$8(RedPacketManager paramRedPacketManager, GetGroupRedPackListRsp paramGetGroupRedPackListRsp, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.b == null) || (TextUtils.isEmpty(this.bcv))) {
      return;
    }
    try
    {
      String str = aagi.bcV + this.bcv + this.val$groupUin + "_" + this.cgi;
      Object localObject = new File(str);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("utf-8");
      this.b.writeTo((JceOutputStream)localObject);
      aqhq.writeFile(((JceOutputStream)localObject).toByteArray(), str);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.8
 * JD-Core Version:    0.7.0.1
 */