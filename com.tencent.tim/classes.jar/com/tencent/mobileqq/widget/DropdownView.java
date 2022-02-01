package com.tencent.mobileqq.widget;

import acfp;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import arfn;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DropdownView
  extends RelativeLayout
  implements PopupWindow.OnDismissListener
{
  private final RelativeLayout.LayoutParams G = new RelativeLayout.LayoutParams(-1, -1);
  public AutoCompleteView a;
  private ImageView arrow;
  public InputMethodManager d;
  public boolean dab = false;
  private float density;
  public Drawable gc;
  Drawable gd;
  private Context mContext;
  private ImageView vK;
  
  public DropdownView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.a = new AutoCompleteView(paramContext);
    init(paramContext);
  }
  
  public DropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new AutoCompleteView(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public DropdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new AutoCompleteView(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.d = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.density = paramContext.getResources().getDisplayMetrics().density;
    setLayoutParams(this.G);
    setPadding(0, 0, 0, 0);
    Object localObject1 = new RelativeLayout.LayoutParams(this.G);
    addView(this.a, (ViewGroup.LayoutParams)localObject1);
    this.a.setDropDownVerticalOffset(0);
    localObject1 = new LinearLayout(paramContext);
    new RelativeLayout.LayoutParams(this.G);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, this.a.getId());
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.vK = new ImageView(paramContext);
    this.vK.setPadding((int)(this.density * 10.0F), (int)(this.density * 10.0F), (int)(this.density * 15.0F), (int)(this.density * 10.0F));
    this.vK.setImageResource(2130839632);
    this.vK.setClickable(true);
    this.vK.setVisibility(8);
    this.vK.setContentDescription(acfp.m(2131705330));
    new LinearLayout.LayoutParams(this.G);
    localObject2 = new LinearLayout.LayoutParams((int)(44.0F * this.density), (int)(39.0F * this.density));
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout)localObject1).addView(this.vK, (ViewGroup.LayoutParams)localObject2);
    this.arrow = new ImageView(paramContext);
    this.arrow.setId(571);
    this.arrow.setPadding((int)(1.0F * this.density), (int)(this.density * 10.0F), (int)(this.density * 15.0F), (int)(this.density * 10.0F));
    this.arrow.setContentDescription(acfp.m(2131705331));
    this.gc = getResources().getDrawable(2130841405);
    this.gd = getResources().getDrawable(2130841406);
    this.arrow.setImageDrawable(this.gc);
    this.arrow.setClickable(true);
    paramContext = new LinearLayout.LayoutParams((int)(35.0F * this.density), (int)(33.0F * this.density));
    paramContext.gravity = 16;
    ((LinearLayout)localObject1).addView(this.arrow, paramContext);
    this.arrow.setOnClickListener(new arfn(this));
    try
    {
      paramContext = this.a.getClass().getSuperclass().getDeclaredField("mPopup");
      paramContext.setAccessible(true);
      paramContext = paramContext.get(this.a);
      paramContext.getClass().getMethod("setOnDismissListener", new Class[] { PopupWindow.OnDismissListener.class }).invoke(paramContext, new Object[] { this });
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public ImageView B()
  {
    return this.vK;
  }
  
  public ImageView C()
  {
    return this.arrow;
  }
  
  public AutoCompleteTextView a()
  {
    return this.a;
  }
  
  public void onDismiss()
  {
    this.arrow.setImageDrawable(this.gc);
    new Handler().postDelayed(new DropdownView.2(this), 500L);
  }
  
  public class AutoCompleteView
    extends AutoCompleteTextView
  {
    private boolean inited;
    
    public AutoCompleteView(Context paramContext)
    {
      super();
      setId(526);
      this.inited = true;
    }
    
    public AutoCompleteView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      setId(526);
      this.inited = true;
    }
    
    public AutoCompleteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setId(526);
      this.inited = true;
    }
    
    public boolean enoughToFilter()
    {
      return true;
    }
    
    public boolean isPopupShowing()
    {
      if (this.inited) {
        return super.isPopupShowing();
      }
      return false;
    }
    
    public void onEditorAction(int paramInt)
    {
      if (paramInt == 5)
      {
        View localView = focusSearch(130);
        if ((localView != null) && (!localView.requestFocus(130))) {
          throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
        }
      }
      else
      {
        super.onEditorAction(paramInt);
      }
    }
    
    protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      try
      {
        if (isPopupShowing()) {
          dismissDropDown();
        }
        return;
      }
      catch (Exception paramCharSequence) {}
    }
    
    protected void performFiltering(CharSequence paramCharSequence, int paramInt) {}
    
    public void showDropDown()
    {
      try
      {
        super.showDropDown();
        if (Build.VERSION.SDK_INT <= 8) {
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      try
      {
        Object localObject1 = getClass().getSuperclass().getDeclaredField("mDropDownList");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(this);
        localObject1.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(0) });
        return;
      }
      catch (Exception localException2)
      {
        try
        {
          Object localObject2 = getClass().getSuperclass().getDeclaredField("mPopup");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(this);
          Object localObject3 = localObject2.getClass().getDeclaredField("mDropDownList");
          ((Field)localObject3).setAccessible(true);
          localObject3 = ((Field)localObject3).get(localObject2);
          localObject3.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject3, new Object[] { Integer.valueOf(0) });
          ((PopupWindow)localObject2).setAnimationStyle(2130772368);
          return;
        }
        catch (Exception localException3) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DropdownView
 * JD-Core Version:    0.7.0.1
 */