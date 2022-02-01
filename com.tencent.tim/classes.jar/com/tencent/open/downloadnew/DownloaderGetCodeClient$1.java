package com.tencent.open.downloadnew;

import android.os.Bundle;
import arwt;
import arzg;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.util.Map;

public class DownloaderGetCodeClient$1
  implements Runnable
{
  public DownloaderGetCodeClient$1(arzg paramarzg, String paramString, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (((Boolean)arzg.a(this.this$0).get(arzg.a(this.this$0, this.abn, this.cPs))).booleanValue())
    {
      arwt.d("DownloaderGetCodeClient", "last request not back,retry ......");
      QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", this.val$params, arzg.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeClient.1
 * JD-Core Version:    0.7.0.1
 */