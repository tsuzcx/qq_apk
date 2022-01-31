package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MessageForQQWalletMsg
  extends ChatMessage
{
  private static int QQWALLET_MSGTYPE_TRANSFER = 1;
  private static int VERSION = 1;
  public QQWalletTransferMsg mQQWalletTransferMsg;
  
  public MessageForQQWalletMsg() {}
  
  public MessageForQQWalletMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    init(paramLong1, paramLong2, paramLong3, "[QQWallet Msg]", paramLong4, -2025, paramInt, paramLong5);
  }
  
  protected void doParse()
  {
    try
    {
      this.mQQWalletTransferMsg = new QQWalletTransferMsg();
      ObjectInputStream localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
      if ((localObjectInputStream.readInt() == VERSION) && (localObjectInputStream.readInt() == QQWALLET_MSGTYPE_TRANSFER)) {
        this.mQQWalletTransferMsg.readExternal(localObjectInputStream);
      }
      localObjectInputStream.close();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.qqwalletmsg", 2, "convert byte array to QQWalletMsg failed", localException);
      }
      this.mQQWalletTransferMsg = null;
    }
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public String getMsgSummary()
  {
    if ((this.mQQWalletTransferMsg != null) && (this.mQQWalletTransferMsg.elem != null)) {
      return this.mQQWalletTransferMsg.elem.notice;
    }
    return "[Transfer]";
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if (this.mQQWalletTransferMsg != null) {
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeInt(VERSION);
      localObjectOutputStream.writeInt(QQWALLET_MSGTYPE_TRANSFER);
      this.mQQWalletTransferMsg.writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      this.msgData = localByteArrayOutputStream.toByteArray();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.qqwalletmsg", 2, "convert QQWalletMsg to byte array failed", localException);
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletMsg
 * JD-Core Version:    0.7.0.1
 */