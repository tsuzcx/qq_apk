package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;
import rkc;

class EditVideoMusic$3
  extends AudioPlayer
{
  EditVideoMusic$3(EditVideoMusic paramEditVideoMusic, Context paramContext, AudioPlayerBase.a parama, rkc paramrkc)
  {
    super(paramContext, parama);
  }
  
  public void onCompletion()
  {
    super.onCompletion();
    this.this$0.b.seekPlay(this.a.aAR, this.a.start);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic.3
 * JD-Core Version:    0.7.0.1
 */