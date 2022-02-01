package com.tencent.tim.cloudfile.recent;

import ateh;
import atmk;
import atmk.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;

public class RecentHistoryFileManager$4
  implements Runnable
{
  public RecentHistoryFileManager$4(atmk paramatmk, String paramString1, List paramList, int paramInt, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    QLog.e("waterchen", 1, "Threadid:" + Thread.currentThread().getId() + " handleLoadListCompleted");
    atmk.a locala = (atmk.a)atmk.a(this.this$0).get(this.cHp);
    if (locala == null) {
      return;
    }
    locala.KH = this.KG;
    locala.errorCode = this.val$errorCode;
    locala.errorMessage = this.cHq;
    locala.hasMore = this.mt;
    if ((this.KG != null) && (this.KG.size() > 0))
    {
      locala.a.nM(this.KG);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RecentHistoryFileManager", 1, "waterchen file list handle finish, but list is null. should update UI thread.  taskID[" + locala.cHr + "] count[" + locala.KI.size() + "]");
    }
    ((ateh)atmk.a(this.this$0).getBusinessHandler(180)).notifyUI(27, true, new Object[] { Integer.valueOf(locala.fileType), Boolean.valueOf(locala.hasMore), Integer.valueOf(locala.operateType), Integer.valueOf(locala.errorCode), locala.errorMessage, locala.KI });
    atmk.c(this.this$0, this.cHp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.recent.RecentHistoryFileManager.4
 * JD-Core Version:    0.7.0.1
 */