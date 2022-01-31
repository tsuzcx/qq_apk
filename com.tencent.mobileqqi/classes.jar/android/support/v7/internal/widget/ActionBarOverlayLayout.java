package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarOverlayLayout
  extends FrameLayout
{
  static final int[] mActionBarSizeAttr = { 2130771982 };
  private ActionBar mActionBar;
  private View mActionBarBottom;
  private int mActionBarHeight;
  private View mActionBarTop;
  private ActionBarView mActionView;
  private ActionBarContainer mContainerView;
  private View mContent;
  private final Rect mZeroRect = new Rect(0, 0, 0, 0);
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private boolean applyInsets(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool2 = false;
    paramView = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (paramView.leftMargin != paramRect.left)
      {
        paramView.leftMargin = paramRect.left;
        bool1 = true;
      }
    }
    paramBoolean1 = bool1;
    if (paramBoolean2)
    {
      paramBoolean1 = bool1;
      if (paramView.topMargin != paramRect.top)
      {
        paramView.topMargin = paramRect.top;
        paramBoolean1 = true;
      }
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4)
    {
      paramBoolean2 = paramBoolean1;
      if (paramView.rightMargin != paramRect.right)
      {
        paramView.rightMargin = paramRect.right;
        paramBoolean2 = true;
      }
    }
    if ((paramBoolean3) && (paramView.bottomMargin != paramRect.bottom))
    {
      paramView.bottomMargin = paramRect.bottom;
      return true;
    }
    return paramBoolean2;
  }
  
  private void init(Context paramContext)
  {
    paramContext = getContext().getTheme().obtainStyledAttributes(mActionBarSizeAttr);
    this.mActionBarHeight = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
  }
  
  void pullChildren()
  {
    if (this.mContent == null)
    {
      this.mContent = findViewById(2131230741);
      if (this.mContent == null) {
        this.mContent = findViewById(16908290);
      }
      this.mActionBarTop = findViewById(2131230931);
      this.mContainerView = ((ActionBarContainer)findViewById(2131230926));
      this.mActionView = ((ActionBarView)findViewById(2131230927));
      this.mActionBarBottom = findViewById(2131230929);
    }
  }
  
  public void setActionBar(ActionBar paramActionBar)
  {
    this.mActionBar = paramActionBar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */