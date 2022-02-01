package com.tencent.tim.filemanager.activity.delDownloadFile;

import android.content.Context;
import aueh;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.localfile.QfileLocalFileMediaTabView;

public class QfileLocalFileDelMediaTabView
  extends QfileLocalFileMediaTabView
{
  public QfileLocalFileDelMediaTabView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void dfD()
  {
    this.b.a(this);
    this.runnable = new QfileLocalFileDelMediaTabView.1(this);
    ThreadManager.executeOnFileThread(this.runnable);
  }
  
  String getFileType(String paramString)
  {
    paramString = aueh.getExtension(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return "其他";
    }
    paramString = paramString.toLowerCase();
    if (".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString)) {
      return "视频";
    }
    if (".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|".contains(paramString)) {
      return "音乐";
    }
    return "其他";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView
 * JD-Core Version:    0.7.0.1
 */