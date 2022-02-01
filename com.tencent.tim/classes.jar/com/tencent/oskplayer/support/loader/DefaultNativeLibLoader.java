package com.tencent.oskplayer.support.loader;

public class DefaultNativeLibLoader
  implements NativeLibLoader
{
  public NativeLibLoader.State isLibReadyToLoad(String paramString)
  {
    return NativeLibLoader.State.TRUE;
  }
  
  public void loadLibrary(String paramString)
    throws UnsatisfiedLinkError, SecurityException
  {
    System.loadLibrary(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.support.loader.DefaultNativeLibLoader
 * JD-Core Version:    0.7.0.1
 */