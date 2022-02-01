package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import apkm;
import apky;
import apky.a;
import apky.b;
import aplb.a;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  public AudioItem$AudioUploadCallback$1(apky.a parama) {}
  
  public void run()
  {
    apky.b localb;
    if (this.a.c.mPosition < this.a.this$0.e.getAdapter().getItemCount())
    {
      this.a.this$0.a.c(this.a.this$0.e.findViewHolderForAdapterPosition(this.a.c.mPosition), true);
      localb = (apky.b)this.a.this$0.e.findViewHolderForAdapterPosition(this.a.c.mPosition);
      if (localb != null)
      {
        if (!this.a.c.mIsPlaying) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)apky.a(this.a.this$0).getResources().getDrawable(2130772338);
        localb.mIcon.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localb.cM.setVisibility(0);
      localb.mIcon.setVisibility(0);
      localb.mN.setVisibility(4);
      return;
      label171:
      localb.mIcon.setImageResource(2130847905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */