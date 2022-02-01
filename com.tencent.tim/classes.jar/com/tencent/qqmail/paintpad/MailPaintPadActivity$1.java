package com.tencent.qqmail.paintpad;

import com.tencent.qqmail.utilities.fileextention.FileUtil;

class MailPaintPadActivity$1
  implements Runnable
{
  MailPaintPadActivity$1(MailPaintPadActivity paramMailPaintPadActivity) {}
  
  public void run()
  {
    FileUtil.delFileBeforeCertianTime(FileUtil.getWebviewScreenshotDir(), 86400000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.1
 * JD-Core Version:    0.7.0.1
 */