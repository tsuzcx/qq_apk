package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public abstract interface SplashScreen
{
  @Nullable
  public abstract View createSplashView(@NonNull Context paramContext, @Nullable Bundle paramBundle);
  
  @SuppressLint({"NewApi"})
  public abstract boolean doesSplashViewRememberItsTransition();
  
  @SuppressLint({"NewApi"})
  @Nullable
  public abstract Bundle saveSplashScreenState();
  
  public abstract void transitionToFlutter(@NonNull Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.android.SplashScreen
 * JD-Core Version:    0.7.0.1
 */