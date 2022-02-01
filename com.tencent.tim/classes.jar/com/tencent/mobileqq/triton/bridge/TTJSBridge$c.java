package com.tencent.mobileqq.triton.bridge;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.c;

class TTJSBridge$c
  implements Runnable
{
  TTJSBridge$c(TTJSBridge paramTTJSBridge, int paramInt, String paramString) {}
  
  public void run()
  {
    TTJSBridge localTTJSBridge = this.c;
    c.a(localTTJSBridge, TTJSBridge.a(localTTJSBridge).k(), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.TTJSBridge.c
 * JD-Core Version:    0.7.0.1
 */