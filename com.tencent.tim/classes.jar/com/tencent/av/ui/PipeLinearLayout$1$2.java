package com.tencent.av.ui;

import acfp;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

class PipeLinearLayout$1$2
  implements Runnable
{
  PipeLinearLayout$1$2(PipeLinearLayout.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (!PipeLinearLayout.a(this.a.this$0))
    {
      int i = 0;
      while ((i < this.iP.size()) && (i < PipeLinearLayout.a(this.a.this$0).length))
      {
        ImageView localImageView = (ImageView)this.a.this$0.findViewById(PipeLinearLayout.a(this.a.this$0)[i]);
        localImageView.setImageBitmap(PipeLinearLayout.a(this.a.this$0, ((Long)PipeLinearLayout.a(this.a.this$0).get(i)).longValue()));
        localImageView.setVisibility(0);
        i += 1;
      }
      ((TextView)this.a.this$0.findViewById(2131371231)).setText(PipeLinearLayout.b(this.a.this$0).size() + acfp.m(2131709662));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.PipeLinearLayout.1.2
 * JD-Core Version:    0.7.0.1
 */