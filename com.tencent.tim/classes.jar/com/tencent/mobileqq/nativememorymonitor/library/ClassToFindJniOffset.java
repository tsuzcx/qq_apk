package com.tencent.mobileqq.nativememorymonitor.library;

import android.os.Build.VERSION;

public class ClassToFindJniOffset
{
  public static long mark2ArtMethod;
  public static long markArtMethod;
  
  public static void initFromJava()
  {
    if ((Build.VERSION.SDK_INT < 30) || (markArtMethod != 0L)) {
      return;
    }
    markArtMethod = Utils.getArtMethod(ClassToFindJniOffset.class, "mark", new Class[0]);
    mark2ArtMethod = Utils.getArtMethod(ClassToFindJniOffset.class, "mark2", new Class[0]);
  }
  
  public static native void mark();
  
  public static void mark2() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nativememorymonitor.library.ClassToFindJniOffset
 * JD-Core Version:    0.7.0.1
 */