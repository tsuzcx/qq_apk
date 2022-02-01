package io.flutter.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

class FlutterActivityDelegate$1$1
  extends AnimatorListenerAdapter
{
  FlutterActivityDelegate$1$1(FlutterActivityDelegate.1 param1) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ((ViewGroup)FlutterActivityDelegate.access$000(this.this$1.this$0).getParent()).removeView(FlutterActivityDelegate.access$000(this.this$1.this$0));
    FlutterActivityDelegate.access$002(this.this$1.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.app.FlutterActivityDelegate.1.1
 * JD-Core Version:    0.7.0.1
 */