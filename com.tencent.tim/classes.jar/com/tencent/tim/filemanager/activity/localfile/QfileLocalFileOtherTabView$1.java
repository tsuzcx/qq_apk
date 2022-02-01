package com.tencent.tim.filemanager.activity.localfile;

import audn;
import audt;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class QfileLocalFileOtherTabView$1
  implements Runnable
{
  QfileLocalFileOtherTabView$1(QfileLocalFileOtherTabView paramQfileLocalFileOtherTabView) {}
  
  public void run()
  {
    Object localObject2 = audn.a().vZ();
    Object localObject1 = new HashMap();
    if (this.this$0.b.sB() != 9) {}
    for (boolean bool = true;; bool = false)
    {
      audt.a(bool, (String)localObject2, "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject1, null);
      localObject2 = audn.a().vY();
      if (localObject2 != null) {
        audt.a(bool, (String)localObject2, "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject1, null);
      }
      audt.ai((Map)localObject1);
      localObject2 = new LinkedHashMap();
      ((LinkedHashMap)localObject2).put("压缩文件", new ArrayList());
      ((LinkedHashMap)localObject2).put("电子书", new ArrayList());
      ((LinkedHashMap)localObject2).put("更多", new ArrayList());
      Iterator localIterator = ((HashMap)localObject1).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((List)((LinkedHashMap)localObject2).get(this.this$0.kN(str))).addAll((Collection)((HashMap)localObject1).get(str));
      }
    }
    localObject1 = ((LinkedHashMap)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((List)((LinkedHashMap)localObject2).get((String)((Iterator)localObject1).next())).size() == 0) {
        ((Iterator)localObject1).remove();
      }
    }
    QfileLocalFileOtherTabView.a(this.this$0, new QfileLocalFileOtherTabView.1.1(this, (LinkedHashMap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileOtherTabView.1
 * JD-Core Version:    0.7.0.1
 */