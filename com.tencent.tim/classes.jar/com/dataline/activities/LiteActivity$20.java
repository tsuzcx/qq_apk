package com.dataline.activities;

import android.content.Context;
import dx;

final class LiteActivity$20
  implements Runnable
{
  LiteActivity$20(Context paramContext, String paramString, LiteActivity.a parama) {}
  
  public void run()
  {
    String str = dx.i(this.val$context, this.aT);
    if (this.a != null) {
      this.a.onResult(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.20
 * JD-Core Version:    0.7.0.1
 */