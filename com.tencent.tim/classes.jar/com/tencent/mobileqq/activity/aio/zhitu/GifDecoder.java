package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;
import ykj;

public class GifDecoder
{
  private Bitmap[] bitmaps = new Bitmap[0];
  private int[] iL = new int[0];
  
  private native boolean nativeBitmapIteratorHasNext(long paramLong);
  
  private native ykj nativeBitmapIteratornext(long paramLong1, long paramLong2);
  
  private native void nativeClose(long paramLong);
  
  private native int nativeGetDelay(long paramLong, int paramInt);
  
  private native Bitmap nativeGetFrame(long paramLong, int paramInt);
  
  private native int nativeGetFrameCount(long paramLong);
  
  private native int nativeGetHeight(long paramLong);
  
  private native int nativeGetWidth(long paramLong);
  
  private native long nativeInit();
  
  private native boolean nativeLoad(long paramLong, String paramString);
  
  private native long nativeLoadUsingIterator(long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.GifDecoder
 * JD-Core Version:    0.7.0.1
 */