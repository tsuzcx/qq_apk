import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.TimeoutException;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
public class aypm
  implements SurfaceTexture.OnFrameAvailableListener
{
  private aypn a;
  private EGLContext mEGLContext = EGL10.EGL_NO_CONTEXT;
  private EGLDisplay mEGLDisplay = EGL10.EGL_NO_DISPLAY;
  private EGLSurface mEGLSurface = EGL10.EGL_NO_SURFACE;
  private EGL10 mEgl;
  private boolean mFrameAvailable;
  private Object mFrameSyncObject = new Object();
  int mHeight;
  private ByteBuffer mPixelBuf;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  int mWidth;
  
  public aypm(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    buU();
    makeCurrent();
    setup();
  }
  
  private void buU()
  {
    this.mEGLDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEGLDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    Object localObject = new int[2];
    if (!this.mEgl.eglInitialize(this.mEGLDisplay, (int[])localObject))
    {
      this.mEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGL10 localEGL10 = this.mEgl;
    EGLDisplay localEGLDisplay = this.mEGLDisplay;
    int i = localObject.length;
    if (!localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, (EGLConfig[])localObject, i, arrayOfInt)) {
      throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
    }
    this.mEGLContext = this.mEgl.eglCreateContext(this.mEGLDisplay, localObject[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    checkEglError("eglCreateContext");
    if (this.mEGLContext == null) {
      throw new RuntimeException("null context");
    }
    i = this.mWidth;
    int j = this.mHeight;
    this.mEGLSurface = this.mEgl.eglCreatePbufferSurface(this.mEGLDisplay, localObject[0], new int[] { 12375, i, 12374, j, 12344 });
    checkEglError("eglCreatePbufferSurface");
    if (this.mEGLSurface == null) {
      throw new RuntimeException("surface was null");
    }
  }
  
  private void checkEglError(String paramString)
  {
    int i = this.mEgl.eglGetError();
    if (i != 12288) {
      throw new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i));
    }
  }
  
  private void setup()
  {
    this.a = new aypn();
    this.a.surfaceCreated();
    Log.d("CodecOutputSurface", "textureID=" + this.a.getTextureId());
    this.mSurfaceTexture = new SurfaceTexture(this.a.getTextureId());
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.mPixelBuf = ByteBuffer.allocateDirect(this.mWidth * this.mHeight * 4);
    this.mPixelBuf.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  public Bitmap K()
  {
    this.mPixelBuf.rewind();
    GLES20.glReadPixels(0, 0, this.mWidth, this.mHeight, 6408, 5121, this.mPixelBuf);
    Bitmap localBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
    this.mPixelBuf.rewind();
    localBitmap.copyPixelsFromBuffer(this.mPixelBuf);
    Log.d("CodecOutputSurface", "getFrameBitmap() finish...");
    return localBitmap;
  }
  
  public void XT()
  {
    this.a.checkGlError("before updateTexImage");
    this.mSurfaceTexture.updateTexImage();
  }
  
  public void awaitNewImage()
    throws TimeoutException
  {
    Log.e("CodecOutputSurface", "awaitNewImage");
    synchronized (this.mFrameSyncObject)
    {
      for (;;)
      {
        boolean bool = this.mFrameAvailable;
        if (!bool) {
          try
          {
            this.mFrameSyncObject.wait(1L);
            if (!this.mFrameAvailable) {
              throw new TimeoutException("frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
    }
    this.mFrameAvailable = false;
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public void makeCurrent()
  {
    if (!this.mEgl.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    Log.e("CodecOutputSurface", "onFrameAvailable new frame available");
    synchronized (this.mFrameSyncObject)
    {
      if (this.mFrameAvailable) {
        throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
    }
    this.mFrameAvailable = true;
    this.mFrameSyncObject.notifyAll();
  }
  
  public void release()
  {
    if (this.mEGLDisplay != EGL10.EGL_NO_DISPLAY)
    {
      this.mEgl.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
      this.mEgl.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      this.mEgl.eglMakeCurrent(this.mEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.mEgl.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL10.EGL_NO_DISPLAY;
    this.mEGLContext = EGL10.EGL_NO_CONTEXT;
    this.mEGLSurface = EGL10.EGL_NO_SURFACE;
    this.mSurface.release();
    this.a = null;
    this.mSurface = null;
    this.mSurfaceTexture = null;
  }
  
  public void tQ(boolean paramBoolean)
  {
    this.a.drawFrame(this.mSurfaceTexture, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypm
 * JD-Core Version:    0.7.0.1
 */