package com.tencent.biz.qqstory.takevideo.music;

import pmz;
import rkb;

class EditVideoMusicDialog$3
  implements Runnable
{
  EditVideoMusicDialog$3(EditVideoMusicDialog paramEditVideoMusicDialog, String paramString) {}
  
  public void run()
  {
    String str = rkb.gh(this.aAP);
    this.this$0.a = new pmz();
    this.this$0.a.setRetryCount(1);
    this.this$0.a.a(this.this$0);
    this.this$0.a.a(this.aAP, str, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.3
 * JD-Core Version:    0.7.0.1
 */