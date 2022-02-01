package com.tencent.mobileqq.forward;

import acbn;
import aghw;
import ahjq;
import android.os.Bundle;
import avja;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class ForwardQFavBatchOption$2
  implements Runnable
{
  public ForwardQFavBatchOption$2(ahjq paramahjq, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    switch (this.val$bundle.getInt("qfavType"))
    {
    }
    String str;
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      str = acbn.bkw;
      localFileManagerEntity = avja.a(this.val$bundle, str, 7);
    } while (localFileManagerEntity == null);
    this.this$0.app.a().a(localFileManagerEntity, str, 6000, this.bES);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption.2
 * JD-Core Version:    0.7.0.1
 */