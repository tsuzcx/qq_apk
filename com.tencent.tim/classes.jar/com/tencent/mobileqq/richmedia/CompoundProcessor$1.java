package com.tencent.mobileqq.richmedia;

import alvp;
import alvs;
import android.os.Bundle;
import aqip;

public class CompoundProcessor$1
  implements Runnable
{
  public CompoundProcessor$1(alvp paramalvp) {}
  
  public void run()
  {
    alvs localalvs = alvs.a();
    String str = this.this$0.mY(this.this$0.mVideoFileSourceDir);
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.this$0.bYG);
    localBundle.putString("full_video_path", str);
    localBundle.putInt("video_slices_total_time_length", this.this$0.dym);
    localalvs.a(103, -1, localBundle);
    aqip.bj(this.this$0.bYG, "clicompCompoundProcessor.compressSourceYUV", "path = " + str + ",totalTime = " + this.this$0.dym);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.CompoundProcessor.1
 * JD-Core Version:    0.7.0.1
 */