package com.tencent.tim.cloudfile.recent;

import ateh;
import atgi;
import atmk;
import atmk.a;
import atml;
import audx;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class RecentHistoryFileManager$5
  implements Runnable
{
  public RecentHistoryFileManager$5(atmk paramatmk, String paramString, long paramLong, Object paramObject) {}
  
  public void run()
  {
    atmk.a locala = (atmk.a)atmk.a(this.this$0).get(this.cHp);
    if (locala == null) {}
    do
    {
      return;
      locala.eqs += 1;
      Iterator localIterator = locala.KH.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (CloudHistoryInfo)localIterator.next();
        if (((CloudHistoryInfo)localObject).historyId == this.ayp)
        {
          localObject = audx.a((CloudHistoryInfo)localObject, this.fR);
          if (localObject != null) {
            locala.KI.add(localObject);
          } else {
            atgi.a().a(this.ayp, new atml(this));
          }
        }
      }
    } while (locala.eqs < locala.KH.size());
    if (QLog.isColorLevel()) {
      QLog.e("RecentHistoryFileManager", 1, "all fileInfo handle finish. should update UI thread.  taskID[" + locala.cHr + "] count[" + locala.KI.size() + "]");
    }
    ((ateh)atmk.a(this.this$0).getBusinessHandler(180)).notifyUI(27, true, new Object[] { Integer.valueOf(locala.fileType), Boolean.valueOf(locala.hasMore), Integer.valueOf(locala.operateType), Integer.valueOf(locala.errorCode), locala.errorMessage, locala.KI });
    atmk.c(this.this$0, this.cHp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.recent.RecentHistoryFileManager.5
 * JD-Core Version:    0.7.0.1
 */