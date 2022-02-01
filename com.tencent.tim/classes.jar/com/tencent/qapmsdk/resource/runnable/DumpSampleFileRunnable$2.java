package com.tencent.qapmsdk.resource.runnable;

import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import java.util.Iterator;

class DumpSampleFileRunnable$2
  implements IReporter.ReportResultCallback
{
  DumpSampleFileRunnable$2(DumpSampleFileRunnable paramDumpSampleFileRunnable, Iterator paramIterator, int paramInt) {}
  
  public void onFailure(int paramInt1, String paramString, int paramInt2) {}
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    DumpSampleFileRunnable.access$000(this.this$0, this.val$fileIterator, this.val$remainReportCount - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.runnable.DumpSampleFileRunnable.2
 * JD-Core Version:    0.7.0.1
 */