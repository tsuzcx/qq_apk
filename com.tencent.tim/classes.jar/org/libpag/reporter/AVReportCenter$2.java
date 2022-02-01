package org.libpag.reporter;

import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class AVReportCenter$2
  implements Runnable
{
  AVReportCenter$2(AVReportCenter paramAVReportCenter, Map paramMap) {}
  
  public void run()
  {
    AVReportCenter localAVReportCenter;
    File localFile;
    Boolean localBoolean;
    if (AVReportCenter.access$200(this.this$0) == null)
    {
      localAVReportCenter = this.this$0;
      localFile = new File(AVReportCenter.access$000(this.this$0));
      localBoolean = AVReportCenter.access$300(this.this$0);
      if (!AVReportCenter.access$400(this.this$0)) {
        break label111;
      }
    }
    label111:
    for (Object localObject = AVReportCenter.access$500(this.this$0).getLooper();; localObject = null)
    {
      AVReportCenter.access$202(localAVReportCenter, new Reporter(localFile, localBoolean, (Looper)localObject));
      localObject = new HashMap();
      AVReportCenter.access$600(this.this$0, (Map)localObject);
      ((Map)localObject).putAll(this.val$data);
      AVReportCenter.access$700(this.this$0, (Map)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.reporter.AVReportCenter.2
 * JD-Core Version:    0.7.0.1
 */