package com.tencent.thumbplayer.api.proxy;

import android.content.Context;
import com.tencent.thumbplayer.datatransport.TPPreloadProxyImpl;

public class TPP2PProxyFactory
{
  public static ITPPreloadProxy createPreloadManager(Context paramContext, int paramInt)
  {
    return new TPPreloadProxyImpl(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.proxy.TPP2PProxyFactory
 * JD-Core Version:    0.7.0.1
 */