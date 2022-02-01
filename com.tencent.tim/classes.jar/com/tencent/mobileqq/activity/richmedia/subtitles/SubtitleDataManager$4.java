package com.tencent.mobileqq.activity.richmedia.subtitles;

import aauj;
import aauj.a;
import alwk;
import alwk.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class SubtitleDataManager$4
  implements Runnable
{
  public SubtitleDataManager$4(aauj paramaauj, alwk.a parama) {}
  
  public void run()
  {
    if (this.this$0.mListenerRef != null)
    {
      aauj.a locala = (aauj.a)this.this$0.mListenerRef.get();
      Iterator localIterator = this.this$0.sk.iterator();
      while (localIterator.hasNext())
      {
        alwk localalwk = (alwk)localIterator.next();
        if ((localalwk.b == this.a) && (localalwk.b != null)) {
          locala.y(localalwk.mID, 0, localalwk.b.mFile);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.4
 * JD-Core Version:    0.7.0.1
 */