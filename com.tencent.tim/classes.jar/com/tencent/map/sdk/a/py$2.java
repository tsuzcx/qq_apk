package com.tencent.map.sdk.a;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class py$2
  implements pv.g
{
  py$2(py parampy) {}
  
  public final EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    try
    {
      paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, py.b(this.a), null);
      return paramEGL10;
    }
    catch (OutOfMemoryError paramEGL10)
    {
      return null;
    }
    catch (IllegalArgumentException paramEGL10) {}
    return null;
  }
  
  public final void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.py.2
 * JD-Core Version:    0.7.0.1
 */