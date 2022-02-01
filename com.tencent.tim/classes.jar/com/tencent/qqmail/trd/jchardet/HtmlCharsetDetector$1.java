package com.tencent.qqmail.trd.jchardet;

import java.io.PrintStream;

final class HtmlCharsetDetector$1
  implements nsICharsetDetectionObserver
{
  public void Notify(String paramString)
  {
    HtmlCharsetDetector.found = true;
    System.out.println("CHARSET = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.HtmlCharsetDetector.1
 * JD-Core Version:    0.7.0.1
 */