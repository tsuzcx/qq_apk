package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetSkinListRsp;
import aqhq;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class RedPacketManager$2
  implements Runnable
{
  RedPacketManager$2(RedPacketManager paramRedPacketManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject = aqhq.readFile(BaseApplicationImpl.getApplication().getFilesDir() + "skins" + this.val$app.getCurrentAccountUin());
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = new JceInputStream((byte[])localObject);
        ((JceInputStream)localObject).setServerEncoding("utf-8");
        GetSkinListRsp localGetSkinListRsp = new GetSkinListRsp();
        localGetSkinListRsp.readFrom((JceInputStream)localObject);
        if (localGetSkinListRsp != null) {
          this.val$app.runOnUiThread(new RedPacketManager.2.1(this, localGetSkinListRsp));
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.2
 * JD-Core Version:    0.7.0.1
 */