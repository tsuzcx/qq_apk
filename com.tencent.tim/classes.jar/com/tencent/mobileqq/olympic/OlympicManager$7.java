package com.tencent.mobileqq.olympic;

import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;

class OlympicManager$7
  implements Runnable
{
  OlympicManager$7(OlympicManager paramOlympicManager, TorchInfo paramTorchInfo) {}
  
  public void run()
  {
    synchronized (OlympicManager.b(this.this$0))
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
        localObjectOutputStream.writeObject(this.b);
        localObjectOutputStream.close();
        localByteArrayOutputStream.close();
        aqhq.a(new File(BaseApplicationImpl.sApplication.getFilesDir(), "olympic_torchinfo_" + this.this$0.mApp.getAccount()).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicManager.7
 * JD-Core Version:    0.7.0.1
 */