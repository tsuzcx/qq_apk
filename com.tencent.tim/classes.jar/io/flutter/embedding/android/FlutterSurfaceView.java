package io.flutter.embedding.android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterRenderer.RenderSurface;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlutterSurfaceView
  extends SurfaceView
  implements FlutterRenderer.RenderSurface
{
  private static final String TAG = "FlutterSurfaceView";
  @Nullable
  private FlutterRenderer flutterRenderer;
  private boolean isAttachedToFlutterRenderer = false;
  private boolean isSurfaceAvailableForRendering = false;
  @NonNull
  private Set<OnFirstFrameRenderedListener> onFirstFrameRenderedListeners = new HashSet();
  private final boolean renderTransparently;
  private final SurfaceHolder.Callback surfaceCallback = new FlutterSurfaceView.1(this);
  
  public FlutterSurfaceView(@NonNull Context paramContext)
  {
    this(paramContext, null, false);
  }
  
  public FlutterSurfaceView(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  private FlutterSurfaceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    this.renderTransparently = paramBoolean;
    init();
  }
  
  public FlutterSurfaceView(@NonNull Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private void changeSurfaceSize(int paramInt1, int paramInt2)
  {
    if (this.flutterRenderer != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Notifying FlutterRenderer that Android surface size has changed to ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" x ");
      localStringBuilder.append(paramInt2);
      Log.v("FlutterSurfaceView", localStringBuilder.toString());
      this.flutterRenderer.surfaceChanged(paramInt1, paramInt2);
      return;
    }
    throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
  }
  
  private void connectSurfaceToRenderer()
  {
    if ((this.flutterRenderer != null) && (getHolder() != null))
    {
      this.flutterRenderer.surfaceCreated(getHolder().getSurface());
      return;
    }
    throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
  }
  
  private void disconnectSurfaceFromRenderer()
  {
    if (this.flutterRenderer != null)
    {
      this.flutterRenderer.surfaceDestroyed();
      return;
    }
    throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
  }
  
  private void init()
  {
    if (this.renderTransparently)
    {
      getHolder().setFormat(-2);
      setZOrderOnTop(true);
    }
    getHolder().addCallback(this.surfaceCallback);
    setAlpha(0.0F);
  }
  
  public void addOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener)
  {
    this.onFirstFrameRenderedListeners.add(paramOnFirstFrameRenderedListener);
  }
  
  public void attachToRenderer(@NonNull FlutterRenderer paramFlutterRenderer)
  {
    Log.v("FlutterSurfaceView", "Attaching to FlutterRenderer.");
    if (this.flutterRenderer != null)
    {
      Log.v("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
      this.flutterRenderer.detachFromRenderSurface();
    }
    this.flutterRenderer = paramFlutterRenderer;
    this.isAttachedToFlutterRenderer = true;
    if (this.isSurfaceAvailableForRendering)
    {
      Log.v("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
      connectSurfaceToRenderer();
    }
  }
  
  public void detachFromRenderer()
  {
    if (this.flutterRenderer != null)
    {
      if (getWindowToken() != null)
      {
        Log.v("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
        disconnectSurfaceFromRenderer();
      }
      setAlpha(0.0F);
      this.flutterRenderer = null;
      this.isAttachedToFlutterRenderer = false;
      return;
    }
    Log.w("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
  }
  
  public void onFirstFrameRendered()
  {
    Log.v("FlutterSurfaceView", "onFirstFrameRendered()");
    setAlpha(1.0F);
    Iterator localIterator = this.onFirstFrameRenderedListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnFirstFrameRenderedListener)localIterator.next()).onFirstFrameRendered();
    }
  }
  
  public void removeOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener)
  {
    this.onFirstFrameRenderedListeners.remove(paramOnFirstFrameRenderedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView
 * JD-Core Version:    0.7.0.1
 */