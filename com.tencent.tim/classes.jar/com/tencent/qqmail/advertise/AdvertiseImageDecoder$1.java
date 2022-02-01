package com.tencent.qqmail.advertise;

import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.io.File;

class AdvertiseImageDecoder$1
  implements Runnable
{
  AdvertiseImageDecoder$1(AdvertiseImageDecoder paramAdvertiseImageDecoder, File paramFile) {}
  
  public void run()
  {
    this.this$0.clearFrameBitmap();
    if (FileUtil.copyFile(this.val$file, new File(this.this$0.getFrameImageName(1))) == 0) {
      this.this$0.deocdeFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.advertise.AdvertiseImageDecoder.1
 * JD-Core Version:    0.7.0.1
 */