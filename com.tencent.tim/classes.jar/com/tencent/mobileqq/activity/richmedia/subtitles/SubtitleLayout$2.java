package com.tencent.mobileqq.activity.richmedia.subtitles;

import aath;
import aatn;
import acfp;

class SubtitleLayout$2
  implements Runnable
{
  SubtitleLayout$2(SubtitleLayout paramSubtitleLayout) {}
  
  public void run()
  {
    if (SubtitleLayout.a(this.this$0))
    {
      if (SubtitleLayout.a(this.this$0) != null)
      {
        long l = System.currentTimeMillis();
        String str1 = acfp.m(2131715073);
        String str2 = "Record and speak with subtitles added.";
        if (!aath.aI(false))
        {
          str1 = acfp.m(2131715075);
          str2 = "Unable to Recognize Your Speaking due to Poor Internet Connection";
        }
        if (SubtitleLayout.a(this.this$0).v(false) <= 4) {
          SubtitleLayout.a(this.this$0).b(l, 1000L + l, str1, str2, true);
        }
      }
      SubtitleLayout.a(this.this$0, 1000);
      SubtitleLayout.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout.2
 * JD-Core Version:    0.7.0.1
 */