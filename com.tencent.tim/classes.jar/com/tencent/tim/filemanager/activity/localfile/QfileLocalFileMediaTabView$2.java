package com.tencent.tim.filemanager.activity.localfile;

import audn;
import audt;
import java.util.HashMap;

class QfileLocalFileMediaTabView$2
  implements Runnable
{
  QfileLocalFileMediaTabView$2(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView) {}
  
  public void run()
  {
    HashMap localHashMap1 = new HashMap();
    String str = audn.a().vY();
    if ((QfileLocalFileMediaTabView.a(this.this$0) & 0x1) > 0)
    {
      audt.a(true, audn.a().vZ(), ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap1, null);
      if (str != null) {
        audt.a(true, str, ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap1, null);
      }
      audt.ai(localHashMap1);
    }
    HashMap localHashMap2 = new HashMap();
    if ((QfileLocalFileMediaTabView.a(this.this$0) & 0x2) > 0)
    {
      audt.a(true, audn.a().vZ(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap2, null);
      if (str != null) {
        audt.a(true, str, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap2, null);
      }
      audt.ai(localHashMap2);
    }
    QfileLocalFileMediaTabView.a(this.this$0, new QfileLocalFileMediaTabView.2.1(this, localHashMap2, localHashMap1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileMediaTabView.2
 * JD-Core Version:    0.7.0.1
 */