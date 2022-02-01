package com.idlefish.flutterboost.containers;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.idlefish.flutterboost.Debuger;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;

public class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  @NonNull
  private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener = new FlutterSplashView.1(this);
  @Nullable
  private XFlutterView flutterView;
  private Handler handler = new Handler();
  private FlutterEngine mFlutterEngine;
  @NonNull
  private final OnFirstFrameRenderedListener onFirstFrameRenderedListener = new FlutterSplashView.2(this);
  @NonNull
  private final Runnable onTransitionComplete = new FlutterSplashView.3(this);
  @Nullable
  private String previousCompletedSplashIsolate;
  @Nullable
  private SplashScreen splashScreen;
  @Nullable
  private Bundle splashScreenState;
  @Nullable
  private View splashScreenView;
  @Nullable
  private String transitioningIsolateId;
  
  public FlutterSplashView(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public FlutterSplashView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlutterSplashView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSaveEnabled(true);
    if (this.mFlutterEngine == null) {
      this.mFlutterEngine = FlutterBoost.instance().engineProvider();
    }
  }
  
  private boolean hasSplashCompleted()
  {
    if (this.flutterView != null)
    {
      if (this.flutterView.isAttachedToFlutterEngine()) {
        return (this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null) && (this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.previousCompletedSplashIsolate));
      }
      throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }
    throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
  }
  
  private void transitionToFlutter()
  {
    this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Transitioning splash screen to a Flutter UI. Isolate: ");
    localStringBuilder.append(this.transitioningIsolateId);
    Log.v(str, localStringBuilder.toString());
    this.splashScreen.transitionToFlutter(this.onTransitionComplete);
  }
  
  public void displayFlutterViewWithSplash(@NonNull XFlutterView paramXFlutterView, @Nullable SplashScreen paramSplashScreen)
  {
    if (this.flutterView != null)
    {
      this.flutterView.removeOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
      removeView(this.flutterView);
    }
    if (this.splashScreenView != null) {
      removeView(this.splashScreenView);
    }
    this.flutterView = paramXFlutterView;
    addView(paramXFlutterView);
    this.splashScreen = paramSplashScreen;
    if (paramSplashScreen != null)
    {
      this.splashScreenView = paramSplashScreen.createSplashView(getContext(), this.splashScreenState);
      this.splashScreenView.setBackgroundColor(-1);
      addView(this.splashScreenView);
      paramXFlutterView.addOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
    }
  }
  
  public void onAttach()
  {
    Debuger.log("BoostFlutterView onAttach");
    this.flutterView.attachToFlutterEngine(this.mFlutterEngine);
  }
  
  public void onDetach()
  {
    Debuger.log("BoostFlutterView onDetach");
    this.flutterView.detachFromFlutterEngine();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.handler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */