package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Intent;
import tij;
import tkw;

final class GdtMotiveVideoFragment$1
  implements Runnable
{
  GdtMotiveVideoFragment$1(Activity paramActivity, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      tij localtij = new tij(this.val$activity);
      localtij.setIntent(this.val$intent);
      localtij.show();
      return;
    }
    catch (Exception localException)
    {
      tkw.i("GdtMotiveVideoFragment", "dialog.show() err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */