package com.tencent.biz.videostory.widget.view.smartmusicview;

import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import srs;

public class EditVideoSmartMusicPart$9
  implements Runnable
{
  public EditVideoSmartMusicPart$9(srs paramsrs) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT > 25)
    {
      VibrationEffect localVibrationEffect = VibrationEffect.createOneShot(50, -1);
      this.this$0.getVibrator().vibrate(localVibrationEffect);
      return;
    }
    this.this$0.getVibrator().vibrate(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.9
 * JD-Core Version:    0.7.0.1
 */