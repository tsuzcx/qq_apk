package io.flutter.embedding.engine.renderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(16)
public class FlutterRenderer
  implements TextureRegistry
{
  private static final String TAG = "FlutterRenderer";
  private final FlutterJNI flutterJNI;
  private boolean hasRenderedFirstFrame = false;
  private final AtomicLong nextTextureId = new AtomicLong(0L);
  private final OnFirstFrameRenderedListener onFirstFrameRenderedListener = new FlutterRenderer.1(this);
  private RenderSurface renderSurface;
  
  public FlutterRenderer(@NonNull FlutterJNI paramFlutterJNI)
  {
    this.flutterJNI = paramFlutterJNI;
    this.flutterJNI.addOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
  }
  
  private void markTextureFrameAvailable(long paramLong)
  {
    this.flutterJNI.markTextureFrameAvailable(paramLong);
  }
  
  private void registerTexture(long paramLong, @NonNull SurfaceTexture paramSurfaceTexture)
  {
    this.flutterJNI.registerTexture(paramLong, paramSurfaceTexture);
  }
  
  private void unregisterTexture(long paramLong)
  {
    this.flutterJNI.unregisterTexture(paramLong);
  }
  
  public void addOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener)
  {
    this.flutterJNI.addOnFirstFrameRenderedListener(paramOnFirstFrameRenderedListener);
    if (this.hasRenderedFirstFrame) {
      paramOnFirstFrameRenderedListener.onFirstFrameRendered();
    }
  }
  
  public void attachToRenderSurface(@NonNull RenderSurface paramRenderSurface)
  {
    Log.v("FlutterRenderer", "Attaching to RenderSurface.");
    if (this.renderSurface != null)
    {
      Log.v("FlutterRenderer", "Already attached to a RenderSurface. Detaching from old one and attaching to new one.");
      detachFromRenderSurface();
    }
    this.renderSurface = paramRenderSurface;
    this.renderSurface.attachToRenderer(this);
    this.flutterJNI.setRenderSurface(paramRenderSurface);
  }
  
  @TargetApi(16)
  public TextureRegistry.SurfaceTextureEntry createSurfaceTexture()
  {
    Log.v("FlutterRenderer", "Creating a SurfaceTexture.");
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    SurfaceTextureRegistryEntry localSurfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), localSurfaceTexture);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("New SurfaceTexture ID: ");
    localStringBuilder.append(localSurfaceTextureRegistryEntry.id());
    Log.v("FlutterRenderer", localStringBuilder.toString());
    registerTexture(localSurfaceTextureRegistryEntry.id(), localSurfaceTexture);
    return localSurfaceTextureRegistryEntry;
  }
  
  public void detachFromRenderSurface()
  {
    Log.v("FlutterRenderer", "Detaching from RenderSurface.");
    if (this.renderSurface != null)
    {
      this.renderSurface.detachFromRenderer();
      this.renderSurface = null;
      surfaceDestroyed();
      this.flutterJNI.setRenderSurface(null);
    }
  }
  
  public void dispatchPointerDataPacket(@NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    this.flutterJNI.dispatchPointerDataPacket(paramByteBuffer, paramInt);
  }
  
  public void dispatchSemanticsAction(int paramInt1, int paramInt2, @Nullable ByteBuffer paramByteBuffer, int paramInt3)
  {
    this.flutterJNI.dispatchSemanticsAction(paramInt1, paramInt2, paramByteBuffer, paramInt3);
  }
  
  public Bitmap getBitmap()
  {
    return this.flutterJNI.getBitmap();
  }
  
  public boolean hasRenderedFirstFrame()
  {
    return this.hasRenderedFirstFrame;
  }
  
  public boolean isAttachedTo(@NonNull RenderSurface paramRenderSurface)
  {
    return this.renderSurface == paramRenderSurface;
  }
  
  public boolean isSoftwareRenderingEnabled()
  {
    return FlutterJNI.nativeGetIsSoftwareRenderingEnabled();
  }
  
  public void removeOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener)
  {
    this.flutterJNI.removeOnFirstFrameRenderedListener(paramOnFirstFrameRenderedListener);
  }
  
  public void setAccessibilityFeatures(int paramInt)
  {
    this.flutterJNI.setAccessibilityFeatures(paramInt);
  }
  
  public void setSemanticsEnabled(boolean paramBoolean)
  {
    this.flutterJNI.setSemanticsEnabled(paramBoolean);
  }
  
  public void setViewportMetrics(@NonNull ViewportMetrics paramViewportMetrics)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Setting viewport metrics\nSize: ");
    localStringBuilder.append(paramViewportMetrics.width);
    localStringBuilder.append(" x ");
    localStringBuilder.append(paramViewportMetrics.height);
    localStringBuilder.append("\nPadding - L: ");
    localStringBuilder.append(paramViewportMetrics.paddingLeft);
    localStringBuilder.append(", T: ");
    localStringBuilder.append(paramViewportMetrics.paddingTop);
    localStringBuilder.append(", R: ");
    localStringBuilder.append(paramViewportMetrics.paddingRight);
    localStringBuilder.append(", B: ");
    localStringBuilder.append(paramViewportMetrics.paddingBottom);
    localStringBuilder.append("\nInsets - L: ");
    localStringBuilder.append(paramViewportMetrics.viewInsetLeft);
    localStringBuilder.append(", T: ");
    localStringBuilder.append(paramViewportMetrics.viewInsetTop);
    localStringBuilder.append(", R: ");
    localStringBuilder.append(paramViewportMetrics.viewInsetRight);
    localStringBuilder.append(", B: ");
    localStringBuilder.append(paramViewportMetrics.viewInsetBottom);
    localStringBuilder.append("\nSystem Gesture Insets - L: ");
    localStringBuilder.append(paramViewportMetrics.systemGestureInsetLeft);
    localStringBuilder.append(", T: ");
    localStringBuilder.append(paramViewportMetrics.systemGestureInsetTop);
    localStringBuilder.append(", R: ");
    localStringBuilder.append(paramViewportMetrics.systemGestureInsetRight);
    localStringBuilder.append(", B: ");
    localStringBuilder.append(paramViewportMetrics.viewInsetBottom);
    Log.v("FlutterRenderer", localStringBuilder.toString());
    this.flutterJNI.setViewportMetrics(paramViewportMetrics.devicePixelRatio, paramViewportMetrics.width, paramViewportMetrics.height, paramViewportMetrics.paddingTop, paramViewportMetrics.paddingRight, paramViewportMetrics.paddingBottom, paramViewportMetrics.paddingLeft, paramViewportMetrics.viewInsetTop, paramViewportMetrics.viewInsetRight, paramViewportMetrics.viewInsetBottom, paramViewportMetrics.viewInsetLeft, paramViewportMetrics.systemGestureInsetTop, paramViewportMetrics.systemGestureInsetRight, paramViewportMetrics.systemGestureInsetBottom, paramViewportMetrics.systemGestureInsetLeft);
  }
  
  public void surfaceChanged(int paramInt1, int paramInt2)
  {
    this.flutterJNI.onSurfaceChanged(paramInt1, paramInt2);
  }
  
  public void surfaceCreated(@NonNull Surface paramSurface)
  {
    this.flutterJNI.onSurfaceCreated(paramSurface);
  }
  
  public void surfaceDestroyed()
  {
    this.flutterJNI.onSurfaceDestroyed();
  }
  
  public static abstract interface RenderSurface
  {
    public abstract void addOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener);
    
    public abstract void attachToRenderer(@NonNull FlutterRenderer paramFlutterRenderer);
    
    public abstract void detachFromRenderer();
    
    public abstract void onFirstFrameRendered();
    
    public abstract void removeOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener);
  }
  
  final class SurfaceTextureRegistryEntry
    implements TextureRegistry.SurfaceTextureEntry
  {
    private final long id;
    private SurfaceTexture.OnFrameAvailableListener onFrameListener = new FlutterRenderer.SurfaceTextureRegistryEntry.1(this);
    private boolean released;
    @NonNull
    private final SurfaceTexture surfaceTexture;
    
    SurfaceTextureRegistryEntry(@NonNull long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      this.id = paramLong;
      this.surfaceTexture = paramSurfaceTexture;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener, new Handler());
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener);
    }
    
    public long id()
    {
      return this.id;
    }
    
    public void release()
    {
      if (this.released) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Releasing a SurfaceTexture (");
      localStringBuilder.append(this.id);
      localStringBuilder.append(").");
      Log.v("FlutterRenderer", localStringBuilder.toString());
      this.surfaceTexture.release();
      FlutterRenderer.this.unregisterTexture(this.id);
      this.released = true;
    }
    
    @NonNull
    public SurfaceTexture surfaceTexture()
    {
      return this.surfaceTexture;
    }
  }
  
  public static final class ViewportMetrics
  {
    public float devicePixelRatio = 1.0F;
    public int height = 0;
    public int paddingBottom = 0;
    public int paddingLeft = 0;
    public int paddingRight = 0;
    public int paddingTop = 0;
    public int systemGestureInsetBottom = 0;
    public int systemGestureInsetLeft = 0;
    public int systemGestureInsetRight = 0;
    public int systemGestureInsetTop = 0;
    public int viewInsetBottom = 0;
    public int viewInsetLeft = 0;
    public int viewInsetRight = 0;
    public int viewInsetTop = 0;
    public int width = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.FlutterRenderer
 * JD-Core Version:    0.7.0.1
 */