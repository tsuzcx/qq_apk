package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class MessageForFunnyFace
  extends ChatMessage
{
  private static final String TAG = MessageForFunnyFace.class.getSimpleName();
  public FunnyFaceMessage mFunnyFaceMessage = null;
  
  protected void doParse()
  {
    try
    {
      this.mFunnyFaceMessage = new FunnyFaceMessage();
      this.mFunnyFaceMessage.readExternal(new ObjectInputStream(new ByteArrayInputStream(this.msgData)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.mFunnyFaceMessage = null;
    }
  }
  
  public boolean msgEquals(MessageForFunnyFace paramMessageForFunnyFace)
  {
    boolean bool = true;
    if (paramMessageForFunnyFace == null) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "msgEquals, obj = null");
      }
    }
    do
    {
      return false;
      if (paramMessageForFunnyFace == this)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "msgEquals, obj == this");
        }
        return true;
      }
      if ((paramMessageForFunnyFace instanceof MessageForFunnyFace)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "msgEquals, obj not MessageForFunnyFace");
    return false;
    parse();
    paramMessageForFunnyFace.parse();
    if (this.mFunnyFaceMessage == null)
    {
      if (paramMessageForFunnyFace.mFunnyFaceMessage == null) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "msgEquals, mFunnyFaceMessage == null : " + bool);
        }
        return bool;
        bool = false;
      }
    }
    return this.mFunnyFaceMessage.msgEquals(paramMessageForFunnyFace.mFunnyFaceMessage);
  }
  
  protected void prewrite()
  {
    if (this.mFunnyFaceMessage != null) {}
    try
    {
      this.msgData = this.mFunnyFaceMessage.getBytes();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFunnyFace
 * JD-Core Version:    0.7.0.1
 */