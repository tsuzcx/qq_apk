package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.text.TextUtils;
import apkm;
import apky;
import awjs;

public class AudioItem$1
  implements Runnable
{
  public AudioItem$1(apky paramapky, apkm paramapkm) {}
  
  public void run()
  {
    String str = awjs.so(this.b.mUrl);
    this.b.setPath(str);
    if (!TextUtils.isEmpty(str)) {
      ((Activity)apky.a(this.this$0)).runOnUiThread(new AudioItem.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.1
 * JD-Core Version:    0.7.0.1
 */