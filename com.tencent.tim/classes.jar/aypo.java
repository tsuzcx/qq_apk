import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class aypo
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final String TAG = aypo.class.getSimpleName();
  private boolean VERBOSE;
  private aypp a;
  private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
  private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
  private boolean mFrameAvailable;
  private Object mFrameSyncObject = new Object();
  int mHeight;
  private ByteBuffer mPixelBuf;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  int mWidth;
  
  public aypo(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    buU();
    makeCurrent();
    setup();
  }
  
  private void buU()
  {
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
    {
      this.mEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.mEGLDisplay;
    int i = localObject.length;
    if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, (EGLConfig[])localObject, 0, i, arrayOfInt, 0)) {
      throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
    }
    this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    checkEglError("eglCreateContext");
    if (this.mEGLContext == null) {
      throw new RuntimeException("null context");
    }
    i = this.mWidth;
    int j = this.mHeight;
    this.mEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, localObject[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
    checkEglError("eglCreatePbufferSurface");
    if (this.mEGLSurface == null) {
      throw new RuntimeException("surface was null");
    }
  }
  
  private void checkEglError(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288) {
      throw new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i));
    }
  }
  
  private void setup()
  {
    this.a = new aypp();
    this.a.surfaceCreated();
    if (this.VERBOSE) {
      Log.d(TAG, "textureID=" + this.a.getTextureId());
    }
    this.mSurfaceTexture = new SurfaceTexture(this.a.getTextureId());
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.mPixelBuf = ByteBuffer.allocateDirect(this.mWidth * this.mHeight * 4);
    this.mPixelBuf.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  public Bitmap K()
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
      this.mPixelBuf.rewind();
      GLES20.glReadPixels(0, 0, this.mWidth, this.mHeight, 6408, 5121, this.mPixelBuf);
      this.mPixelBuf.rewind();
      localBitmap.copyPixelsFromBuffer(this.mPixelBuf);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e(TAG, 2, "getFrameBitmap() OOM!");
    }
    return null;
  }
  
  public void awaitNewImage()
  {
    synchronized (this.mFrameSyncObject)
    {
      for (;;)
      {
        boolean bool = this.mFrameAvailable;
        if (!bool) {
          try
          {
            this.mFrameSyncObject.wait(2500L);
            if (!this.mFrameAvailable) {
              throw new RuntimeException("frame wait timed out");
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
    this.a.checkGlError("before updateTexImage");
    this.mSurfaceTexture.updateTexImage();
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public void makeCurrent()
  {
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    Log.d(TAG, " new frame available");
    if (this.VERBOSE) {
      Log.d(TAG, "new frame available");
    }
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
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
    this.mEGLSurface = EGL14.EGL_NO_SURFACE;
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
 * Qualified Name:     aypo
 * JD-Core Version:    0.7.0.1
 */