package com.tencent.mobileqq.ark.API;

import adoh;
import adoh.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$1
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$1(adoh.a parama, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = adoh.uF.iterator();
    while (localIterator.hasNext())
    {
      adoh localadoh = (adoh)((WeakReference)localIterator.next()).get();
      if (localadoh != null) {
        localadoh.onPlayStateChanged(this.cnn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.1
 * JD-Core Version:    0.7.0.1
 */