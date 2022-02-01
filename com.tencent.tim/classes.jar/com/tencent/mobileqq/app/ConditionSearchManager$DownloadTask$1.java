package com.tencent.mobileqq.app;

import accv;
import accv.a;
import aopo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConditionSearchManager$DownloadTask$1
  implements Runnable
{
  public ConditionSearchManager$DownloadTask$1(accv.a parama, String paramString, File paramFile, QQAppInterface paramQQAppInterface, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    long l2 = -1L;
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "DownloadTask runnable start, url=" + this.bka);
    }
    Object localObject = MsfSdkUtils.insertMtype("ConfigCheck", this.bka);
    int i = HttpDownloadUtil.a(accv.a.a(this.this$0), (String)localObject, this.val$f);
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | download result = " + bool);
      }
      localObject = (accv)this.g.getManager(59);
      if (localObject != null) {
        ((accv)localObject).a(i, this.val$f, this.b);
      }
      localObject = (aopo)accv.a.b(this.this$0).getManager(193);
      String str = this.bka;
      long l1 = l2;
      if (bool)
      {
        l1 = l2;
        if (this.val$f.exists()) {
          l1 = this.val$f.length();
        }
      }
      ((aopo)localObject).be(str, l1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask.1
 * JD-Core Version:    0.7.0.1
 */