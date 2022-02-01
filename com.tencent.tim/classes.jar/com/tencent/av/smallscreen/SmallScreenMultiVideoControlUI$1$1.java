package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import aqmj;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class SmallScreenMultiVideoControlUI$1$1
  implements Runnable
{
  SmallScreenMultiVideoControlUI$1$1(SmallScreenMultiVideoControlUI.1 param1, long paramLong) {}
  
  public void run()
  {
    if ((this.a.this$0.bJ() == this.kS) && (!aqmj.j(this.a.this$0.mApp.getApp().getApplicationContext()).getBoolean("kick_out_self", false))) {
      this.a.this$0.jg(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.1.1
 * JD-Core Version:    0.7.0.1
 */