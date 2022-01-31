package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.coreui.R.styleable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;

public class CoordinatorLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int anchorGravity = 0;
  public int dodgeInsetEdges = 0;
  public int gravity = 0;
  public int insetEdge = 0;
  public int keyline = -1;
  View mAnchorDirectChild;
  int mAnchorId = -1;
  View mAnchorView;
  CoordinatorLayout.Behavior mBehavior;
  boolean mBehaviorResolved = false;
  Object mBehaviorTag;
  private boolean mDidAcceptNestedScrollNonTouch;
  private boolean mDidAcceptNestedScrollTouch;
  private boolean mDidBlockInteraction;
  private boolean mDidChangeAfterNestedScroll;
  int mInsetOffsetX;
  int mInsetOffsetY;
  final Rect mLastChildRect = new Rect();
  
  public CoordinatorLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  CoordinatorLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout_Layout);
    this.gravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
    this.mAnchorId = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
    this.anchorGravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
    this.keyline = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
    this.insetEdge = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
    this.dodgeInsetEdges = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
    this.mBehaviorResolved = localTypedArray.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
    if (this.mBehaviorResolved) {
      this.mBehavior = CoordinatorLayout.parseBehavior(paramContext, paramAttributeSet, localTypedArray.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
    }
    localTypedArray.recycle();
    if (this.mBehavior != null) {
      this.mBehavior.onAttachedToLayoutParams(this);
    }
  }
  
  public CoordinatorLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public CoordinatorLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public CoordinatorLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  private void resolveAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
  {
    this.mAnchorView = paramCoordinatorLayout.findViewById(this.mAnchorId);
    if (this.mAnchorView != null)
    {
      if (this.mAnchorView == paramCoordinatorLayout)
      {
        if (paramCoordinatorLayout.isInEditMode())
        {
          this.mAnchorDirectChild = null;
          this.mAnchorView = null;
          return;
        }
        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
      }
      View localView = this.mAnchorView;
      for (ViewParent localViewParent = this.mAnchorView.getParent(); (localViewParent != paramCoordinatorLayout) && (localViewParent != null); localViewParent = localViewParent.getParent())
      {
        if (localViewParent == paramView)
        {
          if (paramCoordinatorLayout.isInEditMode())
          {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
          }
          throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
      }
      this.mAnchorDirectChild = localView;
      return;
    }
    if (paramCoordinatorLayout.isInEditMode())
    {
      this.mAnchorDirectChild = null;
      this.mAnchorView = null;
      return;
    }
    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + paramCoordinatorLayout.getResources().getResourceName(this.mAnchorId) + " to anchor view " + paramView);
  }
  
  private boolean shouldDodge(View paramView, int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).insetEdge, paramInt);
    return (i != 0) && ((GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, paramInt) & i) == i);
  }
  
  private boolean verifyAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
  {
    if (this.mAnchorView.getId() != this.mAnchorId) {
      return false;
    }
    View localView = this.mAnchorView;
    for (ViewParent localViewParent = this.mAnchorView.getParent(); localViewParent != paramCoordinatorLayout; localViewParent = localViewParent.getParent())
    {
      if ((localViewParent == null) || (localViewParent == paramView))
      {
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
        return false;
      }
      if ((localViewParent instanceof View)) {
        localView = (View)localViewParent;
      }
    }
    this.mAnchorDirectChild = localView;
    return true;
  }
  
  boolean checkAnchorChanged()
  {
    return (this.mAnchorView == null) && (this.mAnchorId != -1);
  }
  
  boolean dependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return (paramView2 == this.mAnchorDirectChild) || (shouldDodge(paramView2, ViewCompat.getLayoutDirection(paramCoordinatorLayout))) || ((this.mBehavior != null) && (this.mBehavior.layoutDependsOn(paramCoordinatorLayout, paramView1, paramView2)));
  }
  
  boolean didBlockInteraction()
  {
    if (this.mBehavior == null) {
      this.mDidBlockInteraction = false;
    }
    return this.mDidBlockInteraction;
  }
  
  View findAnchorView(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    if (this.mAnchorId == -1)
    {
      this.mAnchorDirectChild = null;
      this.mAnchorView = null;
      return null;
    }
    if ((this.mAnchorView == null) || (!verifyAnchorView(paramView, paramCoordinatorLayout))) {
      resolveAnchorView(paramView, paramCoordinatorLayout);
    }
    return this.mAnchorView;
  }
  
  @IdRes
  public int getAnchorId()
  {
    return this.mAnchorId;
  }
  
  @Nullable
  public CoordinatorLayout.Behavior getBehavior()
  {
    return this.mBehavior;
  }
  
  boolean getChangedAfterNestedScroll()
  {
    return this.mDidChangeAfterNestedScroll;
  }
  
  Rect getLastChildRect()
  {
    return this.mLastChildRect;
  }
  
  void invalidateAnchor()
  {
    this.mAnchorDirectChild = null;
    this.mAnchorView = null;
  }
  
  boolean isBlockingInteractionBelow(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    if (this.mDidBlockInteraction) {
      return true;
    }
    boolean bool2 = this.mDidBlockInteraction;
    if (this.mBehavior != null) {}
    for (boolean bool1 = this.mBehavior.blocksInteractionBelow(paramCoordinatorLayout, paramView);; bool1 = false)
    {
      bool1 |= bool2;
      this.mDidBlockInteraction = bool1;
      return bool1;
    }
  }
  
  boolean isNestedScrollAccepted(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return this.mDidAcceptNestedScrollTouch;
    }
    return this.mDidAcceptNestedScrollNonTouch;
  }
  
  void resetChangedAfterNestedScroll()
  {
    this.mDidChangeAfterNestedScroll = false;
  }
  
  void resetNestedScroll(int paramInt)
  {
    setNestedScrollAccepted(paramInt, false);
  }
  
  void resetTouchBehaviorTracking()
  {
    this.mDidBlockInteraction = false;
  }
  
  public void setAnchorId(@IdRes int paramInt)
  {
    invalidateAnchor();
    this.mAnchorId = paramInt;
  }
  
  public void setBehavior(@Nullable CoordinatorLayout.Behavior paramBehavior)
  {
    if (this.mBehavior != paramBehavior)
    {
      if (this.mBehavior != null) {
        this.mBehavior.onDetachedFromLayoutParams();
      }
      this.mBehavior = paramBehavior;
      this.mBehaviorTag = null;
      this.mBehaviorResolved = true;
      if (paramBehavior != null) {
        paramBehavior.onAttachedToLayoutParams(this);
      }
    }
  }
  
  void setChangedAfterNestedScroll(boolean paramBoolean)
  {
    this.mDidChangeAfterNestedScroll = paramBoolean;
  }
  
  void setLastChildRect(Rect paramRect)
  {
    this.mLastChildRect.set(paramRect);
  }
  
  void setNestedScrollAccepted(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mDidAcceptNestedScrollTouch = paramBoolean;
      return;
    }
    this.mDidAcceptNestedScrollNonTouch = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */