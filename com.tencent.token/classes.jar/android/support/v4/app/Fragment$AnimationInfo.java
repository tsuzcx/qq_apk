package android.support.v4.app;

import android.animation.Animator;
import android.view.View;

class Fragment$AnimationInfo
{
  private Boolean mAllowEnterTransitionOverlap;
  private Boolean mAllowReturnTransitionOverlap;
  View mAnimatingAway;
  Animator mAnimator;
  private Object mEnterTransition = null;
  SharedElementCallback mEnterTransitionCallback = null;
  boolean mEnterTransitionPostponed;
  private Object mExitTransition = null;
  SharedElementCallback mExitTransitionCallback = null;
  boolean mIsHideReplaced;
  int mNextAnim;
  int mNextTransition;
  int mNextTransitionStyle;
  private Object mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
  private Object mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
  private Object mSharedElementEnterTransition = null;
  private Object mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
  Fragment.OnStartEnterTransitionListener mStartEnterTransitionListener;
  int mStateAfterAnimating;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.Fragment.AnimationInfo
 * JD-Core Version:    0.7.0.1
 */