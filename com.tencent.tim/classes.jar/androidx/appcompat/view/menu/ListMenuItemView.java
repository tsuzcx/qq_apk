package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import b.a;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuItemView
  extends LinearLayout
  implements AbsListView.SelectionBoundsAdjuster, MenuView.ItemView
{
  private static final String TAG = "ListMenuItemView";
  private Drawable mBackground;
  private CheckBox mCheckBox;
  private LinearLayout mContent;
  private boolean mForceShowIcon;
  private ImageView mGroupDivider;
  private boolean mHasListDivider;
  private ImageView mIconView;
  private LayoutInflater mInflater;
  private MenuItemImpl mItemData;
  private int mMenuType;
  private boolean mPreserveIconSpacing;
  private RadioButton mRadioButton;
  private TextView mShortcutView;
  private Drawable mSubMenuArrow;
  private ImageView mSubMenuArrowView;
  private int mTextAppearance;
  private Context mTextAppearanceContext;
  private TextView mTitleView;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034766);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, b.a.MenuView, paramInt, 0);
    this.mBackground = paramAttributeSet.getDrawable(b.a.MenuView_android_itemBackground);
    this.mTextAppearance = paramAttributeSet.getResourceId(b.a.MenuView_android_itemTextAppearance, -1);
    this.mPreserveIconSpacing = paramAttributeSet.getBoolean(b.a.MenuView_preserveIconSpacing, false);
    this.mTextAppearanceContext = paramContext;
    this.mSubMenuArrow = paramAttributeSet.getDrawable(b.a.MenuView_subMenuArrow);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, new int[] { 16843049 }, 2131034526, 0);
    this.mHasListDivider = paramContext.hasValue(0);
    paramAttributeSet.recycle();
    paramContext.recycle();
  }
  
  private void addContentView(View paramView)
  {
    addContentView(paramView, -1);
  }
  
  private void addContentView(View paramView, int paramInt)
  {
    if (this.mContent != null)
    {
      this.mContent.addView(paramView, paramInt);
      return;
    }
    addView(paramView, paramInt);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(getContext());
    }
    return this.mInflater;
  }
  
  private void insertCheckBox()
  {
    this.mCheckBox = ((CheckBox)getInflater().inflate(2131558414, this, false));
    addContentView(this.mCheckBox);
  }
  
  private void insertIconView()
  {
    this.mIconView = ((ImageView)getInflater().inflate(2131558415, this, false));
    addContentView(this.mIconView, 0);
  }
  
  private void insertRadioButton()
  {
    this.mRadioButton = ((RadioButton)getInflater().inflate(2131558417, this, false));
    addContentView(this.mRadioButton);
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mSubMenuArrowView != null)
    {
      localImageView = this.mSubMenuArrowView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    if ((this.mGroupDivider != null) && (this.mGroupDivider.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mGroupDivider.getLayoutParams();
      int i = paramRect.top;
      int j = this.mGroupDivider.getHeight();
      int k = localLayoutParams.topMargin;
      paramRect.top = (localLayoutParams.bottomMargin + (j + k) + i);
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return this.mItemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.mItemData = paramMenuItemImpl;
    this.mMenuType = paramInt;
    if (paramMenuItemImpl.isVisible()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      setVisibility(paramInt);
      setTitle(paramMenuItemImpl.getTitleForItemView(this));
      setCheckable(paramMenuItemImpl.isCheckable());
      setShortcut(paramMenuItemImpl.shouldShowShortcut(), paramMenuItemImpl.getShortcut());
      setIcon(paramMenuItemImpl.getIcon());
      setEnabled(paramMenuItemImpl.isEnabled());
      setSubMenuArrowVisible(paramMenuItemImpl.hasSubMenu());
      setContentDescription(paramMenuItemImpl.getContentDescription());
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ViewCompat.setBackground(this, this.mBackground);
    this.mTitleView = ((TextView)findViewById(2131379769));
    if (this.mTextAppearance != -1) {
      this.mTitleView.setTextAppearance(this.mTextAppearanceContext, this.mTextAppearance);
    }
    this.mShortcutView = ((TextView)findViewById(2131378261));
    this.mSubMenuArrowView = ((ImageView)findViewById(2131378948));
    if (this.mSubMenuArrowView != null) {
      this.mSubMenuArrowView.setImageDrawable(this.mSubMenuArrow);
    }
    this.mGroupDivider = ((ImageView)findViewById(2131368164));
    this.mContent = ((LinearLayout)findViewById(2131365360));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mIconView != null) && (this.mPreserveIconSpacing))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.mIconView.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mRadioButton == null) && (this.mCheckBox == null)) {}
    label121:
    do
    {
      return;
      Object localObject2;
      if (this.mItemData.isExclusiveCheckable())
      {
        if (this.mRadioButton == null) {
          insertRadioButton();
        }
        localObject2 = this.mRadioButton;
      }
      for (Object localObject1 = this.mCheckBox;; localObject1 = this.mRadioButton)
      {
        if (!paramBoolean) {
          break label121;
        }
        ((CompoundButton)localObject2).setChecked(this.mItemData.isChecked());
        if (((CompoundButton)localObject2).getVisibility() != 0) {
          ((CompoundButton)localObject2).setVisibility(0);
        }
        if ((localObject1 == null) || (((CompoundButton)localObject1).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject1).setVisibility(8);
        return;
        if (this.mCheckBox == null) {
          insertCheckBox();
        }
        localObject2 = this.mCheckBox;
      }
      if (this.mCheckBox != null) {
        this.mCheckBox.setVisibility(8);
      }
    } while (this.mRadioButton == null);
    this.mRadioButton.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.mItemData.isExclusiveCheckable()) {
      if (this.mRadioButton == null) {
        insertRadioButton();
      }
    }
    for (Object localObject = this.mRadioButton;; localObject = this.mCheckBox)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.mCheckBox == null) {
        insertCheckBox();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
    this.mPreserveIconSpacing = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mGroupDivider != null)
    {
      localImageView = this.mGroupDivider;
      if ((this.mHasListDivider) || (!paramBoolean)) {
        break label31;
      }
    }
    label31:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if ((this.mItemData.shouldShowIcon()) || (this.mForceShowIcon))
    {
      i = 1;
      if ((i != 0) || (this.mPreserveIconSpacing)) {
        break label36;
      }
    }
    label36:
    while ((this.mIconView == null) && (paramDrawable == null) && (!this.mPreserveIconSpacing))
    {
      return;
      i = 0;
      break;
    }
    if (this.mIconView == null) {
      insertIconView();
    }
    if ((paramDrawable != null) || (this.mPreserveIconSpacing))
    {
      ImageView localImageView = this.mIconView;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.mIconView.getVisibility() == 0) {
          break;
        }
        this.mIconView.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.mIconView.setVisibility(8);
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar)
  {
    if ((paramBoolean) && (this.mItemData.shouldShowShortcut())) {}
    for (paramChar = '\000';; paramChar = '\b')
    {
      if (paramChar == 0) {
        this.mShortcutView.setText(this.mItemData.getShortcutLabel());
      }
      if (this.mShortcutView.getVisibility() != paramChar) {
        this.mShortcutView.setVisibility(paramChar);
      }
      return;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.mTitleView.setText(paramCharSequence);
      if (this.mTitleView.getVisibility() != 0) {
        this.mTitleView.setVisibility(0);
      }
    }
    while (this.mTitleView.getVisibility() == 8) {
      return;
    }
    this.mTitleView.setVisibility(8);
  }
  
  public boolean showsIcon()
  {
    return this.mForceShowIcon;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */