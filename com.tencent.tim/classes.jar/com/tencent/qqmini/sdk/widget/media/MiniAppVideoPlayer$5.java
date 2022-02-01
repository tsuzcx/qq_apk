package com.tencent.qqmini.sdk.widget.media;

import android.widget.ImageView;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import java.io.File;

class MiniAppVideoPlayer$5
  implements MediaUtils.OnLoadVideoImageListener
{
  MiniAppVideoPlayer$5(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onLoadImage(File paramFile)
  {
    if ((MiniAppVideoPlayer.access$2500(this.this$0) != null) && (paramFile != null)) {
      MiniAppVideoPlayer.access$2500(this.this$0).setImageBitmap(ImageUtil.getLocalBitmap(paramFile.getAbsolutePath()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */