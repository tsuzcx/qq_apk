package com.tencent.mobileqq.activity.aio.photo;

import anot;
import com.tencent.util.Pair;
import java.util.ArrayList;

class PhotoListPanel$4
  implements Runnable
{
  PhotoListPanel$4(PhotoListPanel paramPhotoListPanel, Pair paramPair, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((!((ArrayList)this.g.first).isEmpty()) || (!((ArrayList)this.g.second).isEmpty()))
    {
      this.this$0.a(this.g, this.bjS);
      anfr.akV = System.currentTimeMillis();
    }
    anot.a(null, "CliOper", "", "", this.aWu, this.aWu, 0, 0, this.aWv, this.aWw, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.4
 * JD-Core Version:    0.7.0.1
 */