package com.tencent.mobileqq.filemanager.activity.localfile;

import acfp;
import ahaf;
import ahap;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
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
    Object localObject2 = new HashMap();
    if (this.this$0.a.sB() != 8) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = this.this$0.AS.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ahap.a(bool, ((QfileTabBarView.a)((Iterator)localObject1).next()).wd(), "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
      }
    }
    if (this.this$0.cdi) {}
    for (Object localObject1 = ahaf.a().vY();; localObject1 = null)
    {
      if (localObject1 != null) {
        ahap.a(bool, (String)localObject1, "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
      }
      ahap.ai((Map)localObject2);
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put(acfp.m(2131711097), new ArrayList());
      ((LinkedHashMap)localObject1).put(acfp.m(2131711102), new ArrayList());
      ((LinkedHashMap)localObject1).put(acfp.m(2131711089), new ArrayList());
      Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((List)((LinkedHashMap)localObject1).get(this.this$0.kN(str))).addAll((Collection)((HashMap)localObject2).get(str));
      }
    }
    localObject2 = ((LinkedHashMap)localObject1).keySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((List)((LinkedHashMap)localObject1).get((String)((Iterator)localObject2).next())).size() == 0) {
        ((Iterator)localObject2).remove();
      }
    }
    QfileLocalFileOtherTabView.a(this.this$0, new QfileLocalFileOtherTabView.1.1(this, (LinkedHashMap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView.1
 * JD-Core Version:    0.7.0.1
 */