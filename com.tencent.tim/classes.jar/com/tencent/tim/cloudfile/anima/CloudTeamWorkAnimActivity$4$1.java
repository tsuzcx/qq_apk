package com.tencent.tim.cloudfile.anima;

import android.graphics.Bitmap;
import android.widget.ImageView;
import atjk;
import wja;

public class CloudTeamWorkAnimActivity$4$1
  implements Runnable
{
  public CloudTeamWorkAnimActivity$4$1(atjk paramatjk) {}
  
  public void run()
  {
    CloudTeamWorkAnimActivity.a(this.a.this$0);
    if (CloudTeamWorkAnimActivity.b(this.a.this$0))
    {
      Bitmap localBitmap = CloudTeamWorkAnimActivity.a(this.a.this$0, CloudTeamWorkAnimActivity.a(this.a.this$0), wja.dp2px(CloudTeamWorkAnimActivity.a(this.a.this$0), this.a.this$0.getResources()));
      CloudTeamWorkAnimActivity.a(this.a.this$0, localBitmap);
    }
    if (CloudTeamWorkAnimActivity.a(this.a.this$0) != null)
    {
      CloudTeamWorkAnimActivity.b(this.a.this$0, true);
      CloudTeamWorkAnimActivity.a(this.a.this$0).setImageBitmap(CloudTeamWorkAnimActivity.a(this.a.this$0));
      CloudTeamWorkAnimActivity.a(this.a.this$0).startAnimation(CloudTeamWorkAnimActivity.a(this.a.this$0));
      return;
    }
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity.4.1
 * JD-Core Version:    0.7.0.1
 */