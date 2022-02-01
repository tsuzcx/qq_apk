package com.tencent.weiyun.callback;

abstract class WeiyunCallback
{
  protected static final int INVALID_NATIVE_PTR = 0;
  protected static final int SUCCESS_CODE = 0;
  
  protected abstract void onNativeCallback(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.callback.WeiyunCallback
 * JD-Core Version:    0.7.0.1
 */