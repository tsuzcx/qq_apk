package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;

final class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  @NonNull
  private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener = new FlutterSplashView.1(this);
  @Nullable
  private FlutterView flutterView;
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
  
  private boolean isSplashScreenNeededNow()
  {
    return (this.flutterView != null) && (this.flutterView.isAttachedToFlutterEngine()) && (!this.flutterView.hasRenderedFirstFrame()) && (!hasSplashCompleted());
  }
  
  private boolean isSplashScreenTransitionNeededNow()
  {
    return (this.flutterView != null) && (this.flutterView.isAttachedToFlutterEngine()) && (this.splashScreen != null) && (this.splashScreen.doesSplashViewRememberItsTransition()) && (wasPreviousSplashTransitionInterrupted());
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
  
  private boolean wasPreviousSplashTransitionInterrupted()
  {
    if (this.flutterView != null)
    {
      if (this.flutterView.isAttachedToFlutterEngine()) {
        return (this.flutterView.hasRenderedFirstFrame()) && (!hasSplashCompleted());
      }
      throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }
    throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
  }
  
  public void displayFlutterViewWithSplash(@NonNull FlutterView paramFlutterView, @Nullable SplashScreen paramSplashScreen)
  {
    if (this.flutterView != null)
    {
      this.flutterView.removeOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
      removeView(this.flutterView);
    }
    if (this.splashScreenView != null) {
      removeView(this.splashScreenView);
    }
    this.flutterView = paramFlutterView;
    addView(paramFlutterView);
    this.splashScreen = paramSplashScreen;
    if (paramSplashScreen != null)
    {
      if (!isSplashScreenNeededNow()) {
        break label110;
      }
      Log.v(TAG, "Showing splash screen UI.");
      this.splashScreenView = paramSplashScreen.createSplashView(getContext(), this.splashScreenState);
      addView(this.splashScreenView);
      paramFlutterView.addOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
    }
    label110:
    do
    {
      return;
      if (isSplashScreenTransitionNeededNow())
      {
        Log.v(TAG, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
        this.splashScreenView = paramSplashScreen.createSplashView(getContext(), this.splashScreenState);
        addView(this.splashScreenView);
        transitionToFlutter();
        return;
      }
    } while (paramFlutterView.isAttachedToFlutterEngine());
    Log.v(TAG, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
    paramFlutterView.addFlutterEngineAttachmentListener(this.flutterEngineAttachmentListener);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.previousCompletedSplashIsolate = paramParcelable.previousCompletedSplashIsolate;
    this.splashScreenState = paramParcelable.splashScreenState;
  }
  
  @Nullable
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.access$602(localSavedState, this.previousCompletedSplashIsolate);
    if (this.splashScreen != null) {}
    for (Bundle localBundle = this.splashScreen.saveSplashScreenState();; localBundle = null)
    {
      SavedState.access$702(localSavedState, localBundle);
      return localSavedState;
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static Parcelable.Creator CREATOR = new FlutterSplashView.SavedState.1();
    private String previousCompletedSplashIsolate;
    private Bundle splashScreenState;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.previousCompletedSplashIsolate = paramParcel.readString();
      this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.previousCompletedSplashIsolate);
      paramParcel.writeBundle(this.splashScreenState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */