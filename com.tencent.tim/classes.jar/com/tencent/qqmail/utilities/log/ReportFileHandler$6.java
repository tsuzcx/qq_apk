package com.tencent.qqmail.utilities.log;

import java.io.File;
import rx.Observable;
import rx.functions.Func0;

class ReportFileHandler$6
  implements Func0<Observable<File>>
{
  ReportFileHandler$6(ReportFileHandler paramReportFileHandler) {}
  
  public Observable<File> call()
  {
    Object localObject;
    File[] arrayOfFile2;
    int i;
    int j;
    label56:
    File[] arrayOfFile1;
    if ((ReportFileHandler.access$300(this.this$0)) && (ReportFileHandler.access$400(this.this$0) != null))
    {
      localObject = ReportFileHandler.access$200(this.this$0).listFiles();
      arrayOfFile2 = ReportFileHandler.access$500(this.this$0).listFiles();
      if (localObject == null)
      {
        i = 0;
        if (arrayOfFile2 != null) {
          break label125;
        }
        j = 0;
        arrayOfFile1 = new File[j + i];
        if (localObject == null) {
          break label150;
        }
        i = localObject.length + 0;
        System.arraycopy(localObject, 0, arrayOfFile1, 0, i);
      }
    }
    for (;;)
    {
      localObject = arrayOfFile1;
      if (arrayOfFile2 != null) {
        System.arraycopy(arrayOfFile2, 0, arrayOfFile1, i, arrayOfFile2.length);
      }
      for (localObject = arrayOfFile1;; localObject = ReportFileHandler.access$200(this.this$0).listFiles())
      {
        if ((localObject == null) || (localObject.length <= 0)) {
          break label146;
        }
        return Observable.from((Object[])localObject);
        i = localObject.length;
        break;
        label125:
        j = arrayOfFile2.length;
        break label56;
      }
      label146:
      return Observable.empty();
      label150:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.ReportFileHandler.6
 * JD-Core Version:    0.7.0.1
 */