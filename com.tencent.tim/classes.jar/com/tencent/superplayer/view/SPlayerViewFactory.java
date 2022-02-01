package com.tencent.superplayer.view;

import android.content.Context;
import android.os.Build.VERSION;

public class SPlayerViewFactory
{
  public static ISPlayerViewBase createPlayView(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 14)) {
      return new SPlayerTextureView(paramContext);
    }
    return new SPlayerSurfaceView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerViewFactory
 * JD-Core Version:    0.7.0.1
 */