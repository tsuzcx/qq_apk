package com.tencent.mobileqq.activity.shortvideo;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$5
  implements Runnable
{
  ShortVideoPlayActivity$5(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    if (this.this$0.isPlaying())
    {
      if (this.this$0.mDuration <= 0L) {
        this.this$0.cAC();
      }
      if ((this.this$0.fa != null) && (this.this$0.fa.get() != null)) {
        ShortVideoPlayActivity.a(this.this$0, ((ISuperPlayer)this.this$0.fa.get()).getCurrentPositionMs());
      }
      if (ShortVideoPlayActivity.a(this.this$0) != 0L)
      {
        ShortVideoPlayActivity.a(this.this$0, (int)(ShortVideoPlayActivity.a(this.this$0) * 10000L / this.this$0.mDuration + 0.5D));
        if (!ShortVideoPlayActivity.a(this.this$0)) {
          ShortVideoPlayActivity.b(this.this$0, ShortVideoPlayActivity.a(this.this$0));
        }
        if (!ShortVideoPlayActivity.b(this.this$0))
        {
          this.this$0.mSeekBar.setProgress(ShortVideoPlayActivity.a(this.this$0));
          this.this$0.gJ(ShortVideoPlayActivity.a(this.this$0));
        }
      }
    }
    if ((this.this$0.fa == null) || (this.this$0.mFileSize == 0L) || (this.this$0.LD)) {}
    try
    {
      ShortVideoPlayActivity.b(this.this$0, (int)(this.this$0.ap * 10000L / this.this$0.mFileSize));
      label249:
      if (this.this$0.mSeekBar.getSecondaryProgress() != ShortVideoPlayActivity.b(this.this$0)) {
        this.this$0.mSeekBar.setSecondaryProgress(ShortVideoPlayActivity.b(this.this$0));
      }
      if ((this.this$0.isBuffering()) && (ShortVideoPlayActivity.c(this.this$0) > 0) && (ShortVideoPlayActivity.a(this.this$0) != null) && (ShortVideoPlayActivity.a(this.this$0).getVisibility() == 0))
      {
        String str = ShortVideoUtils.g(this.this$0.mContext, ShortVideoPlayActivity.c(this.this$0) * 1024);
        ShortVideoPlayActivity.a(this.this$0).setText(str + "/s");
      }
      if (this.this$0.isFinishing()) {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "check progress, while finishing");
        }
      }
      while (this.this$0.mHandler.get() == null)
      {
        return;
        ShortVideoPlayActivity.b(this.this$0, 10000);
        break;
      }
      ((MqqHandler)this.this$0.mHandler.get()).postDelayed(this.this$0.eu, 50L);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label249;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */