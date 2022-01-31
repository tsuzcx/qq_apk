package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.CompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.mobileqqi.R.styleable;

public class ActionMenuItemView
  extends CompatTextView
  implements ActionMenuView.ActionMenuChildView, MenuView.ItemView, View.OnClickListener, View.OnLongClickListener
{
  private static final String TAG = "ActionMenuItemView";
  private boolean mAllowTextWithIcon;
  private boolean mExpandedFormat;
  private Drawable mIcon;
  private MenuItemImpl mItemData;
  private MenuBuilder.ItemInvoker mItemInvoker;
  private int mMinWidth;
  private int mSavedPaddingLeft;
  private CharSequence mTitle;
  
  public ActionMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mAllowTextWithIcon = paramContext.getResources().getBoolean(2131296260);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.f, 0, 0);
    this.mMinWidth = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
    setOnClickListener(this);
    setOnLongClickListener(this);
    setTransformationMethod(new ActionMenuItemView.AllCapsTransformationMethod(this));
    this.mSavedPaddingLeft = -1;
  }
  
  private void updateTextButtonVisibility()
  {
    int k = 0;
    int i;
    if (!TextUtils.isEmpty(this.mTitle))
    {
      i = 1;
      if (this.mIcon != null)
      {
        j = k;
        if (!this.mItemData.showsTextAsAction()) {
          break label51;
        }
        if (!this.mAllowTextWithIcon)
        {
          j = k;
          if (!this.mExpandedFormat) {
            break label51;
          }
        }
      }
      int j = 1;
      label51:
      if ((i & j) == 0) {
        break label75;
      }
    }
    label75:
    for (CharSequence localCharSequence = this.mTitle;; localCharSequence = null)
    {
      setText(localCharSequence);
      return;
      i = 0;
      break;
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return this.mItemData;
  }
  
  public boolean hasText()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.mItemData = paramMenuItemImpl;
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitleForItemView(this));
    setId(paramMenuItemImpl.getItemId());
    if (paramMenuItemImpl.isVisible()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      setVisibility(paramInt);
      setEnabled(paramMenuItemImpl.isEnabled());
      return;
    }
  }
  
  public boolean needsDividerAfter()
  {
    return hasText();
  }
  
  public boolean needsDividerBefore()
  {
    return (hasText()) && (this.mItemData.getIcon() == null);
  }
  
  public void onClick(View paramView)
  {
    if (this.mItemInvoker != null) {
      this.mItemInvoker.invokeItem(this.mItemData);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (hasText()) {
      return false;
    }
    paramView = new int[2];
    Rect localRect = new Rect();
    getLocationOnScreen(paramView);
    getWindowVisibleDisplayFrame(localRect);
    Object localObject = getContext();
    int i = getWidth();
    int j = getHeight();
    int k = paramView[1];
    int m = j / 2;
    int n = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
    localObject = Toast.makeText((Context)localObject, this.mItemData.getTitle(), 0);
    if (k + m < localRect.height()) {
      ((Toast)localObject).setGravity(53, n - paramView[0] - i / 2, j);
    }
    for (;;)
    {
      ((Toast)localObject).show();
      return true;
      ((Toast)localObject).setGravity(81, 0, j);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = hasText();
    if ((bool) && (this.mSavedPaddingLeft >= 0)) {
      super.setPadding(this.mSavedPaddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == -2147483648) {}
    for (paramInt1 = Math.min(paramInt1, this.mMinWidth);; paramInt1 = this.mMinWidth)
    {
      if ((i != 1073741824) && (this.mMinWidth > 0) && (j < paramInt1)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      }
      if ((!bool) && (this.mIcon != null)) {
        super.setPadding((getMeasuredWidth() - this.mIcon.getIntrinsicWidth()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
      return;
    }
  }
  
  public boolean prefersCondensedTitle()
  {
    return true;
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.mExpandedFormat != paramBoolean)
    {
      this.mExpandedFormat = paramBoolean;
      if (this.mItemData != null) {
        this.mItemData.actionFormatChanged();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    updateTextButtonVisibility();
  }
  
  public void setItemInvoker(MenuBuilder.ItemInvoker paramItemInvoker)
  {
    this.mItemInvoker = paramItemInvoker;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSavedPaddingLeft = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    setContentDescription(this.mTitle);
    updateTextButtonVisibility();
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */