package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ListMenuItemView
  extends LinearLayout
  implements MenuView.ItemView
{
  private static final String TAG = "ListMenuItemView";
  private Drawable mBackground;
  private CheckBox mCheckBox;
  private boolean mForceShowIcon;
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
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    this.mBackground = paramAttributeSet.getDrawable(R.styleable.MenuView_android_itemBackground);
    this.mTextAppearance = paramAttributeSet.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
    this.mPreserveIconSpacing = paramAttributeSet.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
    this.mTextAppearanceContext = paramContext;
    this.mSubMenuArrow = paramAttributeSet.getDrawable(R.styleable.MenuView_subMenuArrow);
    paramAttributeSet.recycle();
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
    this.mCheckBox = ((CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false));
    addView(this.mCheckBox);
  }
  
  private void insertIconView()
  {
    this.mIconView = ((ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false));
    addView(this.mIconView, 0);
  }
  
  private void insertRadioButton()
  {
    this.mRadioButton = ((RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false));
    addView(this.mRadioButton);
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
    this.mTitleView = ((TextView)findViewById(R.id.title));
    if (this.mTextAppearance != -1) {
      this.mTitleView.setTextAppearance(this.mTextAppearanceContext, this.mTextAppearance);
    }
    this.mShortcutView = ((TextView)findViewById(R.id.shortcut));
    this.mSubMenuArrowView = ((ImageView)findViewById(R.id.submenuarrow));
    if (this.mSubMenuArrowView != null) {
      this.mSubMenuArrowView.setImageDrawable(this.mSubMenuArrow);
    }
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
    label51:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (this.mItemData.isExclusiveCheckable())
      {
        if (this.mRadioButton == null) {
          insertRadioButton();
        }
        localObject1 = this.mRadioButton;
        localObject2 = this.mCheckBox;
        if (!paramBoolean) {
          break label139;
        }
        ((CompoundButton)localObject1).setChecked(this.mItemData.isChecked());
        if (!paramBoolean) {
          break label133;
        }
      }
      for (int i = 0;; i = 8)
      {
        if (((CompoundButton)localObject1).getVisibility() != i) {
          ((CompoundButton)localObject1).setVisibility(i);
        }
        if ((localObject2 == null) || (((CompoundButton)localObject2).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject2).setVisibility(8);
        return;
        if (this.mCheckBox == null) {
          insertCheckBox();
        }
        localObject1 = this.mCheckBox;
        localObject2 = this.mRadioButton;
        break label51;
      }
      if (this.mCheckBox != null) {
        this.mCheckBox.setVisibility(8);
      }
    } while (this.mRadioButton == null);
    label133:
    label139:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */