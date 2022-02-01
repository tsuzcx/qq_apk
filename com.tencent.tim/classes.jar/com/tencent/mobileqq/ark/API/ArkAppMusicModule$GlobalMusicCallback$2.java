package com.tencent.mobileqq.ark.API;

import adoh;
import adoh.a;
import com.tencent.mobileqq.music.SongInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$2
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$2(adoh.a parama, SongInfo paramSongInfo) {}
  
  public void run()
  {
    Iterator localIterator = adoh.uF.iterator();
    while (localIterator.hasNext())
    {
      adoh localadoh = (adoh)((WeakReference)localIterator.next()).get();
      if (localadoh != null) {
        localadoh.onPlaySongChanged(this.h);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.2
 * JD-Core Version:    0.7.0.1
 */