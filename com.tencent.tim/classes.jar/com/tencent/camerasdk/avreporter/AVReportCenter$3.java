package com.tencent.camerasdk.avreporter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

class AVReportCenter$3
  implements Runnable
{
  AVReportCenter$3(AVReportCenter paramAVReportCenter, Map paramMap) {}
  
  public void run()
  {
    if (AVReportCenter.access$200(this.this$0) == null) {
      AVReportCenter.access$202(this.this$0, new Reporter(new File(AVReportCenter.access$000(this.this$0)), AVReportCenter.access$300(this.this$0)));
    }
    HashMap localHashMap = new HashMap();
    AVReportCenter.access$400(this.this$0, localHashMap);
    localHashMap.putAll(this.val$data);
    AVReportCenter.access$500(this.this$0, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.camerasdk.avreporter.AVReportCenter.3
 * JD-Core Version:    0.7.0.1
 */