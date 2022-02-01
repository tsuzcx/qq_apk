package com.tencent.mobileqq.warbler;

public class Warbler
{
  private static boolean hasInit;
  
  private static void init()
  {
    if (hasInit) {
      return;
    }
    System.loadLibrary("warbler");
    hasInit = true;
  }
  
  public static boolean makeArtDebuggable()
  {
    init();
    return nativeMakeArtDebuggable();
  }
  
  private static native boolean nativeMakeArtDebuggable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.warbler.Warbler
 * JD-Core Version:    0.7.0.1
 */