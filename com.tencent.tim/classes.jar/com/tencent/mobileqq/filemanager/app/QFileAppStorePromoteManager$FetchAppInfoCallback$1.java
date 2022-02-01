package com.tencent.mobileqq.filemanager.app;

import agil;
import agil.a;
import agil.c;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.HashMap;
import java.util.List;

public class QFileAppStorePromoteManager$FetchAppInfoCallback$1
  implements Runnable
{
  public QFileAppStorePromoteManager$FetchAppInfoCallback$1(agil.a parama, int paramInt1, int paramInt2, List paramList) {}
  
  public void run()
  {
    agil.c localc = (agil.c)agil.a(this.b.this$0).get(Integer.valueOf(this.cXi));
    if (localc != null) {
      if (this.val$ret != 0) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      localc.a(bool, (AppDetail)this.val$appInfoList.get(0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.FetchAppInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */