package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mnr;
import nch;
import obc;

public class CompressVideoTaskStep$1$1
  implements Runnable
{
  public CompressVideoTaskStep$1$1(mnr parammnr, int paramInt, String paramString, nch paramnch) {}
  
  public void run()
  {
    QLog.i("RIJUGC.CompressVideoTaskStep", 1, "onCompressFinished, retCode =" + this.val$retCode + ",outPath = " + this.val$outPath);
    String str2 = "";
    String str1 = str2;
    if (this.val$outPath != null)
    {
      str1 = str2;
      if (!this.val$outPath.isEmpty()) {
        str1 = obc.getFileMd5(new File(this.val$outPath));
      }
    }
    QLog.i("RIJUGC.CompressVideoTaskStep", 1, "get Md5, md5=" + str1);
    ThreadManagerV2.getUIHandlerV2().post(new CompressVideoTaskStep.1.1.1(this, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.CompressVideoTaskStep.1.1
 * JD-Core Version:    0.7.0.1
 */