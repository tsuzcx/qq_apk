package com.tencent.qqmail.utilities;

import com.tencent.qqmail.trd.jchardet.nsICharsetDetectionObserver;

class FileCharsetDetector$1
  implements nsICharsetDetectionObserver
{
  FileCharsetDetector$1(FileCharsetDetector paramFileCharsetDetector) {}
  
  public void Notify(String paramString)
  {
    FileCharsetDetector.access$002(this.this$0, true);
    FileCharsetDetector.access$102(this.this$0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.FileCharsetDetector.1
 * JD-Core Version:    0.7.0.1
 */