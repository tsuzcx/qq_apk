package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.Properties;
import kxm;
import myi;
import nbm;

public class VideoPlayerWrapper$1
  implements Runnable
{
  public VideoPlayerWrapper$1(myi parammyi, nbm paramnbm) {}
  
  public void run()
  {
    Object localObject = this.b.getStreamDumpInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = kxm.a((String)localObject);
      if (localObject != null) {
        this.this$0.vF = Long.parseLong(((Properties)localObject).getProperty("VideoBitRate"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */