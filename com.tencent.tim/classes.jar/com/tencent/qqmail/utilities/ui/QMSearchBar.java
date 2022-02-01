package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.qqmail.qmui.alpha.QMUIAlphaButton;

public class QMSearchBar
  extends RelativeLayout
{
  public static final int BTN_TYPE_BLUE = 1;
  public static final int BTN_TYPE_ICON = 2;
  public static final int BTN_TYPE_NORMAL = 0;
  Context context;
  private LinearLayout mainWrap;
  private QMUIAlphaButton searchBtn;
  private TextView searchInitHint;
  public LinearLayout searchInitWrap;
  public EditText searchInput;
  public ImageButton searchInputCleaner;
  private View searchMask;
  public LinearLayout searchingWrap;
  
  public QMSearchBar(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  public QMSearchBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  private void initFrame()
  {
    this.mainWrap = new LinearLayout(this.context);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299361));
    this.mainWrap.setLayoutParams(localLayoutParams);
    this.mainWrap.setGravity(17);
    this.mainWrap.setBackgroundColor(ContextCompat.getColor(this.context, 2131166586));
    addView(this.mainWrap);
  }
  
  private void initMask()
  {
    this.searchMask = new View(this.context);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299361));
    this.searchMask.setLayoutParams(localLayoutParams);
    this.searchMask.setBackgroundColor(ContextCompat.getColor(this.context, 2131166567));
    this.searchMask.setClickable(true);
    addView(this.searchMask);
  }
  
  public TextView getBtnRight()
  {
    return this.searchBtn;
  }
  
  public void setBtnRight()
  {
    setBtnRight(getResources().getString(2131693000));
  }
  
  public void setBtnRight(String paramString)
  {
    if (this.searchBtn == null)
    {
      this.searchBtn = QMUIAlphaButton.generateRegularBtn(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      localLayoutParams.setMargins(-QMUIKit.dpToPx(8), 0, 0, 0);
      this.searchBtn.setLayoutParams(localLayoutParams);
      this.mainWrap.addView(this.searchBtn);
    }
    this.searchBtn.setText(paramString);
  }
  
  public void setSearchHint(int paramInt)
  {
    if (this.searchInitHint != null) {
      this.searchInitHint.setText(getResources().getString(2131719263));
    }
    if (this.searchInput != null)
    {
      if (paramInt != 0) {
        this.searchInput.setHint(getResources().getString(2131719263) + getResources().getString(paramInt));
      }
    }
    else {
      return;
    }
    this.searchInput.setHint(getResources().getString(2131719263) + getResources().getString(2131690284));
  }
  
  public void setSearchHint(String paramString)
  {
    if (this.searchInitHint != null) {
      this.searchInitHint.setText(getResources().getString(2131719263));
    }
    if (this.searchInput != null)
    {
      if (paramString != null) {
        this.searchInput.setHint(getResources().getString(2131719263) + paramString);
      }
    }
    else {
      return;
    }
    this.searchInput.setHint(getResources().getString(2131719263) + getResources().getString(2131690284));
  }
  
  public void setSearchbarEnable(boolean paramBoolean)
  {
    setSearchbarInputEnable(true);
    if (this.searchMask == null) {
      initMask();
    }
    super.setEnabled(paramBoolean);
    if (paramBoolean) {
      this.searchMask.setVisibility(8);
    }
    for (;;)
    {
      if (this.searchBtn != null) {
        this.searchBtn.setEnabled(paramBoolean);
      }
      return;
      this.searchMask.setVisibility(0);
    }
  }
  
  public void setSearchbarInputEnable(boolean paramBoolean)
  {
    if (this.searchMask != null) {
      this.searchMask.setVisibility(8);
    }
  }
  
  public void setStateNormal()
  {
    if (this.mainWrap == null) {
      initFrame();
    }
    if (this.searchInitWrap == null)
    {
      this.searchInitWrap = new LinearLayout(this.context);
      Object localObject = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131299362), 1.0F);
      ((LinearLayout.LayoutParams)localObject).setMargins(getResources().getDimensionPixelSize(2131297032), 0, getResources().getDimensionPixelSize(2131297032), 0);
      this.searchInitWrap.setLayoutParams((ViewGroup.LayoutParams)localObject);
      QMUIHelper.setBackground(this.searchInitWrap, ContextCompat.getDrawable(this.context, 2130850626));
      this.searchInitWrap.setGravity(16);
      this.searchInitWrap.setOrientation(0);
      this.mainWrap.addView(this.searchInitWrap);
      localObject = new ImageView(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(getResources().getDimensionPixelSize(2131299370), 0, getResources().getDimensionPixelSize(2131299371), 0);
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      QMUIHelper.setBackground((View)localObject, ContextCompat.getDrawable(this.context, 2130841048));
      this.searchInitWrap.addView((View)localObject);
      this.searchInitHint = new TextView(this.context);
      this.searchInitHint.setTextColor(getResources().getColor(2131166574));
      this.searchInitHint.setTextSize(2, 12.0F);
      this.searchInitHint.setText(getResources().getString(2131719263));
      this.searchInitWrap.addView(this.searchInitHint);
    }
    for (;;)
    {
      if (this.searchingWrap != null) {
        this.searchingWrap.setVisibility(8);
      }
      return;
      this.searchInitWrap.setVisibility(0);
    }
  }
  
  public void setStateSearch()
  {
    if (this.mainWrap == null) {
      initFrame();
    }
    if (this.searchingWrap == null)
    {
      this.searchingWrap = new LinearLayout(this.context);
      Object localObject = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131299362), 1.0F);
      ((LinearLayout.LayoutParams)localObject).setMargins(getResources().getDimensionPixelSize(2131297032), 0, getResources().getDimensionPixelSize(2131297032), 0);
      this.searchingWrap.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.searchingWrap.setBackgroundResource(2130850626);
      this.searchingWrap.setGravity(16);
      this.searchingWrap.setOrientation(0);
      this.mainWrap.addView(this.searchingWrap);
      localObject = new ImageView(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(getResources().getDimensionPixelSize(2131299370), 0, getResources().getDimensionPixelSize(2131299371), 0);
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      ((ImageView)localObject).setBackgroundResource(2130841048);
      this.searchingWrap.addView((View)localObject);
      this.searchInput = new EditText(this.context);
      localObject = new LinearLayout.LayoutParams(0, -1, 1.0F);
      this.searchInput.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.searchInput.setBackgroundColor(ContextCompat.getColor(this.context, 2131166585));
      this.searchInput.setTextColor(ContextCompat.getColor(this.context, 2131166572));
      this.searchInput.setHint(getResources().getString(2131719263));
      this.searchInput.setHintTextColor(getResources().getColor(2131166574));
      this.searchInput.setTextSize(0, getResources().getDimensionPixelSize(2131299363));
      this.searchInput.setSingleLine(true);
      this.searchInput.setPadding(0, 0, 0, 0);
      this.searchInput.setImeOptions(2);
      this.searchingWrap.addView(this.searchInput);
      this.searchInputCleaner = new ImageButton(this.context);
      localObject = new LinearLayout.LayoutParams(-2, -1);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.searchInputCleaner.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.searchInputCleaner.setBackgroundResource(0);
      this.searchInputCleaner.setPadding(getResources().getDimensionPixelSize(2131299368), 0, getResources().getDimensionPixelSize(2131299369), 0);
      this.searchInputCleaner.setScaleType(ImageView.ScaleType.CENTER);
      this.searchInputCleaner.setImageDrawable(getResources().getDrawable(2130841401));
      this.searchInputCleaner.setVisibility(8);
      this.searchingWrap.addView(this.searchInputCleaner);
      localObject = new QMSearchBar.1(this);
      this.searchInput.addTextChangedListener((TextWatcher)localObject);
      this.searchInputCleaner.setOnClickListener(new QMSearchBar.2(this));
    }
    for (;;)
    {
      if (this.searchInitWrap != null) {
        this.searchInitWrap.setVisibility(8);
      }
      return;
      this.searchingWrap.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMSearchBar
 * JD-Core Version:    0.7.0.1
 */