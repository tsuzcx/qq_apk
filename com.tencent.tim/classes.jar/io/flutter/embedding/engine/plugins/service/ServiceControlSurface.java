package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;

public abstract interface ServiceControlSurface
{
  public abstract void attachToService(@NonNull Service paramService, @NonNull Lifecycle paramLifecycle, boolean paramBoolean);
  
  public abstract void detachFromService();
  
  public abstract void onMoveToBackground();
  
  public abstract void onMoveToForeground();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.service.ServiceControlSurface
 * JD-Core Version:    0.7.0.1
 */