package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.renderer.FlutterRenderer.RenderSurface;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.AccessibilityBridge.Action;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlutterJNI
{
  private static final String TAG = "FlutterJNI";
  @Nullable
  private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
  @Nullable
  private static String observatoryUri;
  private static float refreshRateFPS;
  @Nullable
  private AccessibilityDelegate accessibilityDelegate;
  @NonNull
  private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new HashSet();
  @NonNull
  private final Set<OnFirstFrameRenderedListener> firstFrameListeners = new HashSet();
  @NonNull
  private final Looper mainLooper = Looper.getMainLooper();
  @Nullable
  private Long nativePlatformViewId;
  @Nullable
  private PlatformMessageHandler platformMessageHandler;
  @Nullable
  private FlutterRenderer.RenderSurface renderSurface;
  
  private static void asyncWaitForVsync(long paramLong)
  {
    if (asyncWaitForVsyncDelegate != null)
    {
      asyncWaitForVsyncDelegate.asyncWaitForVsync(paramLong);
      return;
    }
    throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
  }
  
  private void ensureAttachedToNative()
  {
    if (this.nativePlatformViewId != null) {
      return;
    }
    throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
  }
  
  private void ensureNotAttachedToNative()
  {
    if (this.nativePlatformViewId == null) {
      return;
    }
    throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
  }
  
  private void ensureRunningOnMainThread()
  {
    if (Looper.myLooper() == this.mainLooper) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Methods marked with @UiThread must be executed on the main thread. Current thread: ");
    localStringBuilder.append(Thread.currentThread().getName());
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  @Nullable
  public static String getObservatoryUri()
  {
    return observatoryUri;
  }
  
  private void handlePlatformMessage(@NonNull String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.platformMessageHandler != null) {
      this.platformMessageHandler.handleMessageFromDart(paramString, paramArrayOfByte, paramInt);
    }
  }
  
  private void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.platformMessageHandler != null) {
      this.platformMessageHandler.handlePlatformMessageResponse(paramInt, paramArrayOfByte);
    }
  }
  
  private native long nativeAttach(@NonNull FlutterJNI paramFlutterJNI, boolean paramBoolean);
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativeDispatchEmptyPlatformMessage(long paramLong, @NonNull String paramString, int paramInt);
  
  private native void nativeDispatchPlatformMessage(long paramLong, @NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  private native void nativeDispatchPointerDataPacket(long paramLong, @NonNull ByteBuffer paramByteBuffer, int paramInt);
  
  private native void nativeDispatchSemanticsAction(long paramLong, int paramInt1, int paramInt2, @Nullable ByteBuffer paramByteBuffer, int paramInt3);
  
  private native Bitmap nativeGetBitmap(long paramLong);
  
  @UiThread
  public static native boolean nativeGetIsSoftwareRenderingEnabled();
  
  public static native void nativeInit(@NonNull Context paramContext, @NonNull String[] paramArrayOfString, @Nullable String paramString1, @NonNull String paramString2, @NonNull String paramString3);
  
  private native void nativeInvokePlatformMessageEmptyResponseCallback(long paramLong, int paramInt);
  
  private native void nativeInvokePlatformMessageResponseCallback(long paramLong, int paramInt1, @Nullable ByteBuffer paramByteBuffer, int paramInt2);
  
  @NonNull
  public static native FlutterCallbackInformation nativeLookupCallbackInformation(long paramLong);
  
  private native void nativeMarkTextureFrameAvailable(long paramLong1, long paramLong2);
  
  public static native void nativeOnVsync(long paramLong1, long paramLong2, long paramLong3);
  
  public static native void nativeRecordStartTimestamp(long paramLong);
  
  private native void nativeRegisterTexture(long paramLong1, long paramLong2, @NonNull SurfaceTexture paramSurfaceTexture);
  
  private native void nativeRunBundleAndSnapshotFromLibrary(long paramLong, @NonNull String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NonNull AssetManager paramAssetManager);
  
  private native void nativeSetAccessibilityFeatures(long paramLong, int paramInt);
  
  private native void nativeSetSemanticsEnabled(long paramLong, boolean paramBoolean);
  
  private native void nativeSetViewportMetrics(long paramLong, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14);
  
  private native void nativeSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSurfaceCreated(long paramLong, @NonNull Surface paramSurface);
  
  private native void nativeSurfaceDestroyed(long paramLong);
  
  private native void nativeUnregisterTexture(long paramLong1, long paramLong2);
  
  @UiThread
  private void onFirstFrame()
  {
    ensureRunningOnMainThread();
    if (this.renderSurface != null) {
      this.renderSurface.onFirstFrameRendered();
    }
    Iterator localIterator = this.firstFrameListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnFirstFrameRenderedListener)localIterator.next()).onFirstFrameRendered();
    }
  }
  
  private void onPreEngineRestart()
  {
    Iterator localIterator = this.engineLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((FlutterEngine.EngineLifecycleListener)localIterator.next()).onPreEngineRestart();
    }
  }
  
  public static void setAsyncWaitForVsyncDelegate(@Nullable AsyncWaitForVsyncDelegate paramAsyncWaitForVsyncDelegate)
  {
    asyncWaitForVsyncDelegate = paramAsyncWaitForVsyncDelegate;
  }
  
  public static void setRefreshRateFPS(float paramFloat)
  {
    refreshRateFPS = paramFloat;
  }
  
  @UiThread
  private void updateCustomAccessibilityActions(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString)
  {
    ensureRunningOnMainThread();
    if (this.accessibilityDelegate != null) {
      this.accessibilityDelegate.updateCustomAccessibilityActions(paramByteBuffer, paramArrayOfString);
    }
  }
  
  @UiThread
  private void updateSemantics(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString)
  {
    ensureRunningOnMainThread();
    if (this.accessibilityDelegate != null) {
      this.accessibilityDelegate.updateSemantics(paramByteBuffer, paramArrayOfString);
    }
  }
  
  @UiThread
  public void addEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener paramEngineLifecycleListener)
  {
    ensureRunningOnMainThread();
    this.engineLifecycleListeners.add(paramEngineLifecycleListener);
  }
  
  @UiThread
  public void addOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener)
  {
    ensureRunningOnMainThread();
    this.firstFrameListeners.add(paramOnFirstFrameRenderedListener);
  }
  
  @UiThread
  public void attachToNative(boolean paramBoolean)
  {
    ensureRunningOnMainThread();
    ensureNotAttachedToNative();
    this.nativePlatformViewId = Long.valueOf(nativeAttach(this, paramBoolean));
  }
  
  @UiThread
  public void detachFromNativeAndReleaseResources()
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDestroy(this.nativePlatformViewId.longValue());
    this.nativePlatformViewId = null;
  }
  
  @UiThread
  public void dispatchEmptyPlatformMessage(@NonNull String paramString, int paramInt)
  {
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeDispatchEmptyPlatformMessage(this.nativePlatformViewId.longValue(), paramString, paramInt);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(". Response ID: ");
    localStringBuilder.append(paramInt);
    Log.w("FlutterJNI", localStringBuilder.toString());
  }
  
  @UiThread
  public void dispatchPlatformMessage(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeDispatchPlatformMessage(this.nativePlatformViewId.longValue(), paramString, paramByteBuffer, paramInt1, paramInt2);
      return;
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ");
    paramByteBuffer.append(paramString);
    paramByteBuffer.append(". Response ID: ");
    paramByteBuffer.append(paramInt2);
    Log.w("FlutterJNI", paramByteBuffer.toString());
  }
  
  @UiThread
  public void dispatchPointerDataPacket(@NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDispatchPointerDataPacket(this.nativePlatformViewId.longValue(), paramByteBuffer, paramInt);
  }
  
  @UiThread
  public void dispatchSemanticsAction(int paramInt1, int paramInt2, @Nullable ByteBuffer paramByteBuffer, int paramInt3)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDispatchSemanticsAction(this.nativePlatformViewId.longValue(), paramInt1, paramInt2, paramByteBuffer, paramInt3);
  }
  
  public void dispatchSemanticsAction(int paramInt, @NonNull AccessibilityBridge.Action paramAction)
  {
    dispatchSemanticsAction(paramInt, paramAction, null);
  }
  
  public void dispatchSemanticsAction(int paramInt, @NonNull AccessibilityBridge.Action paramAction, @Nullable Object paramObject)
  {
    ensureAttachedToNative();
    if (paramObject != null) {
      paramObject = StandardMessageCodec.INSTANCE.encodeMessage(paramObject);
    }
    for (int i = paramObject.position();; i = 0)
    {
      dispatchSemanticsAction(paramInt, paramAction.value, paramObject, i);
      return;
      paramObject = null;
    }
  }
  
  @UiThread
  public Bitmap getBitmap()
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    return nativeGetBitmap(this.nativePlatformViewId.longValue());
  }
  
  @UiThread
  public void invokePlatformMessageEmptyResponseCallback(int paramInt)
  {
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeInvokePlatformMessageEmptyResponseCallback(this.nativePlatformViewId.longValue(), paramInt);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ");
    localStringBuilder.append(paramInt);
    Log.w("FlutterJNI", localStringBuilder.toString());
  }
  
  @UiThread
  public void invokePlatformMessageResponseCallback(int paramInt1, @Nullable ByteBuffer paramByteBuffer, int paramInt2)
  {
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeInvokePlatformMessageResponseCallback(this.nativePlatformViewId.longValue(), paramInt1, paramByteBuffer, paramInt2);
      return;
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ");
    paramByteBuffer.append(paramInt1);
    Log.w("FlutterJNI", paramByteBuffer.toString());
  }
  
  public boolean isAttached()
  {
    return this.nativePlatformViewId != null;
  }
  
  @UiThread
  public void markTextureFrameAvailable(long paramLong)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeMarkTextureFrameAvailable(this.nativePlatformViewId.longValue(), paramLong);
  }
  
  @UiThread
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceChanged(this.nativePlatformViewId.longValue(), paramInt1, paramInt2);
  }
  
  @UiThread
  public void onSurfaceCreated(@NonNull Surface paramSurface)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceCreated(this.nativePlatformViewId.longValue(), paramSurface);
  }
  
  @UiThread
  public void onSurfaceDestroyed()
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceDestroyed(this.nativePlatformViewId.longValue());
  }
  
  @UiThread
  public void registerTexture(long paramLong, @NonNull SurfaceTexture paramSurfaceTexture)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeRegisterTexture(this.nativePlatformViewId.longValue(), paramLong, paramSurfaceTexture);
  }
  
  @UiThread
  public void removeEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener paramEngineLifecycleListener)
  {
    ensureRunningOnMainThread();
    this.engineLifecycleListeners.remove(paramEngineLifecycleListener);
  }
  
  @UiThread
  public void removeOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener)
  {
    ensureRunningOnMainThread();
    this.firstFrameListeners.remove(paramOnFirstFrameRenderedListener);
  }
  
  @UiThread
  public void runBundleAndSnapshotFromLibrary(@NonNull String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NonNull AssetManager paramAssetManager)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeRunBundleAndSnapshotFromLibrary(this.nativePlatformViewId.longValue(), paramString1, paramString2, paramString3, paramAssetManager);
  }
  
  @UiThread
  public void setAccessibilityDelegate(@Nullable AccessibilityDelegate paramAccessibilityDelegate)
  {
    ensureRunningOnMainThread();
    this.accessibilityDelegate = paramAccessibilityDelegate;
  }
  
  @UiThread
  public void setAccessibilityFeatures(int paramInt)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetAccessibilityFeatures(this.nativePlatformViewId.longValue(), paramInt);
  }
  
  @UiThread
  public void setPlatformMessageHandler(@Nullable PlatformMessageHandler paramPlatformMessageHandler)
  {
    ensureRunningOnMainThread();
    this.platformMessageHandler = paramPlatformMessageHandler;
  }
  
  @UiThread
  public void setRenderSurface(@Nullable FlutterRenderer.RenderSurface paramRenderSurface)
  {
    ensureRunningOnMainThread();
    this.renderSurface = paramRenderSurface;
  }
  
  @UiThread
  public void setSemanticsEnabled(boolean paramBoolean)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetSemanticsEnabled(this.nativePlatformViewId.longValue(), paramBoolean);
  }
  
  @UiThread
  public void setViewportMetrics(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetViewportMetrics(this.nativePlatformViewId.longValue(), paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14);
  }
  
  @UiThread
  public void unregisterTexture(long paramLong)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeUnregisterTexture(this.nativePlatformViewId.longValue(), paramLong);
  }
  
  public static abstract interface AccessibilityDelegate
  {
    public abstract void updateCustomAccessibilityActions(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString);
    
    public abstract void updateSemantics(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString);
  }
  
  public static abstract interface AsyncWaitForVsyncDelegate
  {
    public abstract void asyncWaitForVsync(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterJNI
 * JD-Core Version:    0.7.0.1
 */