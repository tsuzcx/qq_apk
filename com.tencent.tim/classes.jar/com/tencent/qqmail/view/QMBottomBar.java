package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.content.ContextCompat;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.qmui.alpha.QMUIAlphaButton;
import com.tencent.qqmail.utilities.ui.QMImageButton;

public class QMBottomBar
  extends LinearLayout
{
  public static final int BOTTOMBAR_BUTTON_TYPE_NORMAL = 0;
  public static final int BOTTOMBAR_BUTTON_TYPE_RED = 1;
  private static final int STYLE_DARK = 1;
  private static final int STYLE_DEFAULT = 0;
  private Context context = QMApplicationContext.sharedInstance();
  private int style = 0;
  
  public QMBottomBar(Context paramContext)
  {
    this(paramContext, null);
    setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297365), 80));
  }
  
  public QMBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QMBottomBar);
    this.style = paramContext.getInt(R.styleable.QMBottomBar_bottombarStyle, 0);
    paramContext.recycle();
    if (this.style == 0) {
      setBackgroundResource(2130850553);
    }
    while (this.style != 1) {
      return;
    }
    setBackgroundResource(2131166572);
  }
  
  private QMUIAlphaButton createBottomBarButton(int paramInt, String paramString)
  {
    QMBottomBar.1 local1 = new QMBottomBar.1(this, this.context);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    local1.setLayoutParams((ViewGroup.LayoutParams)localObject);
    local1.setPadding(0, 0, 0, 0);
    local1.setGravity(17);
    local1.setMinimumWidth(0);
    local1.setMinimumHeight(0);
    local1.setTextSize(0, getResources().getDimensionPixelSize(2131297364));
    local1.setEllipsize(TextUtils.TruncateAt.END);
    local1.setSingleLine();
    if (paramInt == 0)
    {
      localObject = getContext();
      if (this.style == 0)
      {
        paramInt = 2131166572;
        local1.setTextColor(ContextCompat.getColorStateList((Context)localObject, paramInt));
      }
    }
    for (;;)
    {
      local1.setBackgroundResource(0);
      local1.setText(paramString);
      return local1;
      paramInt = 2131166586;
      break;
      if (paramInt == 1) {
        local1.setTextColor(ContextCompat.getColorStateList(getContext(), 2131166582));
      }
    }
  }
  
  public QMUIAlphaButton addButton(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    paramString = createBottomBarButton(paramInt, paramString);
    FrameLayout localFrameLayout = new FrameLayout(paramString.getContext());
    localFrameLayout.addView(paramString);
    Object localObject = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(localFrameLayout);
    localObject = new View(paramString.getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    ((View)localObject).setLayoutParams(localLayoutParams);
    paramString.setTag(localObject);
    localFrameLayout.addView((View)localObject);
    paramString.setOnClickListener(paramOnClickListener);
    return paramString;
  }
  
  public QMImageButton addButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    QMBottomBar.2 local2 = new QMBottomBar.2(this, this.context);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    Object localObject = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(2131297367), -1, 1.0F);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(localFrameLayout);
    localObject = new FrameLayout.LayoutParams(-1, -1, 1);
    ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    local2.setImageResource(paramInt);
    local2.setMinimumWidth(0);
    local2.setOnClickListener(paramOnClickListener);
    local2.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localFrameLayout.addView(local2);
    paramOnClickListener = new View(this.context);
    localObject = new FrameLayout.LayoutParams(-1, -1, 1);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    paramOnClickListener.setLayoutParams((ViewGroup.LayoutParams)localObject);
    local2.setTag(paramOnClickListener);
    localFrameLayout.addView(paramOnClickListener);
    return local2;
  }
  
  public View getBottomBarButton(int paramInt)
  {
    FrameLayout localFrameLayout = (FrameLayout)getChildAt(paramInt);
    if (localFrameLayout == null) {
      return null;
    }
    return localFrameLayout.getChildAt(0);
  }
  
  public void setOnClickListener(int paramInt, View.OnClickListener paramOnClickListener)
  {
    View localView = getBottomBarButton(paramInt);
    if (localView != null) {
      localView.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMBottomBar
 * JD-Core Version:    0.7.0.1
 */