package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetSkinListRsp;
import aadq;
import aqhq;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class RedPacketManager$3$1
  implements Runnable
{
  public RedPacketManager$3$1(aadq paramaadq, GetSkinListRsp paramGetSkinListRsp) {}
  
  public void run()
  {
    try
    {
      JceOutputStream localJceOutputStream = new JceOutputStream();
      localJceOutputStream.setServerEncoding("utf-8");
      this.jdField_a_of_type_WalletGetSkinListRsp.writeTo(localJceOutputStream);
      aqhq.writeFile(localJceOutputStream.toByteArray(), BaseApplicationImpl.getApplication().getFilesDir() + "skins" + this.jdField_a_of_type_Aadq.val$app.getCurrentAccountUin());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.3.1
 * JD-Core Version:    0.7.0.1
 */