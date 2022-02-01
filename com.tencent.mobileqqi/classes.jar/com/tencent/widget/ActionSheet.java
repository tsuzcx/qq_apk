package com.tencent.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import hvk;
import hvl;
import java.util.ArrayList;
import java.util.HashSet;

public class ActionSheet
  extends Dialog
{
  public static final int a = 0;
  public static final String a = "ActionSheet";
  @Deprecated
  public static final int b = 1;
  @Deprecated
  public static final int c = 2;
  @Deprecated
  public static final int d = 4;
  public static final int e = 3;
  public static final int f = 5;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = null;
  private ActionSheet.OnDismissListener jdField_a_of_type_ComTencentWidgetActionSheet$OnDismissListener = null;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean = false;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new hvk(this);
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private boolean jdField_c_of_type_Boolean;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new hvl(this);
  private boolean jdField_d_of_type_Boolean = true;
  private int k = -1;
  private int l = 300;
  
  protected ActionSheet(Context paramContext)
  {
    this(paramContext, false);
  }
  
  protected ActionSheet(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 2131624526);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903076, null));
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131231058));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131231059));
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, 2131624527);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903076, null));
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131231058));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131231059));
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131361867);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131361867);
    case 1: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131361867);
    case 2: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131361867);
    case 4: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131361867);
    case 3: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131361866);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getColor(2131361867);
  }
  
  public static ActionSheet a(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false);
    paramContext.getWindow().setWindowAnimations(2131624450);
    paramContext.setCanceledOnTouchOutside(true);
    Window localWindow = paramContext.getWindow();
    WindowManager localWindowManager = localWindow.getWindowManager();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = ((int)(localWindowManager.getDefaultDisplay().getWidth() * 0.85D));
    localWindow.setAttributes(localLayoutParams);
    return paramContext;
  }
  
  public static ActionSheet b(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true);
    paramContext.getWindow().setWindowAnimations(2131624450);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static ActionSheet c(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, true);
    paramContext.getWindow().setWindowAnimations(2131624450);
    paramContext.setCanceledOnTouchOutside(true);
    Window localWindow = paramContext.getWindow();
    WindowManager localWindowManager = localWindow.getWindowManager();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = ((int)(localWindowManager.getDefaultDisplay().getWidth() * 0.75D));
    localWindow.setAttributes(localLayoutParams);
    return paramContext;
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject;
    TextView localTextView;
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903079, null);
      localTextView = (TextView)((View)localObject).findViewById(2131231063);
      localTextView.setVisibility(0);
      localTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      localTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
      {
        localTextView.getPaint().setFlags(8);
        localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      if (this.jdField_b_of_type_JavaLangCharSequence != null)
      {
        localTextView = (TextView)((View)localObject).findViewById(2131231064);
        localTextView.setVisibility(0);
        localTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
        localTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject, 0);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.size();
        if (this.jdField_a_of_type_JavaLangCharSequence != null)
        {
          localObject = new View(getContext());
          ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, 4));
          ((View)localObject).setBackgroundColor(getContext().getResources().getColor(2131361905));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        }
        int n = this.jdField_a_of_type_JavaUtilArrayList.size();
        int m = 0;
        if (m < n)
        {
          localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903078, null);
          localTextView = (TextView)((View)localObject).findViewById(2131231061);
          Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localTextView.setText((CharSequence)localPair.first);
          localTextView.setContentDescription(localPair.first + "按钮");
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131361901));
          localTextView.setSingleLine(true);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          ((View)localObject).setId(m);
          ((View)localObject).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
          if (this.jdField_a_of_type_Boolean)
          {
            if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
              this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
            }
            this.jdField_a_of_type_AndroidUtilSparseArray.append(m, localObject);
            localObject = (ImageView)((View)localObject).findViewById(2131231062);
            if (m != this.k) {
              break label502;
            }
            ((ImageView)localObject).setBackgroundResource(2130840217);
          }
          for (;;)
          {
            if (m != n - 1)
            {
              localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
              ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
              ((ImageView)localObject).setBackgroundColor(getContext().getResources().getColor(2131361906));
              this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
            }
            m += 1;
            break;
            label502:
            ((ImageView)localObject).setBackgroundResource(2130840218);
          }
        }
      }
      if (this.jdField_c_of_type_JavaLangCharSequence != null)
      {
        localObject = (Button)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903077, null).findViewById(2131231060);
        if (this.jdField_b_of_type_AndroidViewView$OnClickListener == null) {
          break label582;
        }
        ((Button)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        ((Button)localObject).setText(this.jdField_c_of_type_JavaLangCharSequence);
        ((Button)localObject).setContentDescription(this.jdField_c_of_type_JavaLangCharSequence);
        this.jdField_c_of_type_Boolean = true;
        return;
        label582:
        ((Button)localObject).setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
    }
  }
  
  public Drawable a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837607);
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localPair != null) {
        return ((CharSequence)localPair.first).toString();
      }
    }
    return null;
  }
  
  public void a()
  {
    super.dismiss();
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0, paramBoolean);
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  @Deprecated
  public void a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramView, 0, localLayoutParams);
    }
  }
  
  public void a(ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = paramOnButtonClickListener;
  }
  
  public void a(ActionSheet.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (this.jdField_a_of_type_Boolean) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    a(paramCharSequence, paramInt, paramBoolean, true);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCharSequence != null)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (paramBoolean2) {
        break label139;
      }
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      label139:
      if (paramBoolean1) {
        this.k = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    if (paramCharSequence != null) {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence, 0, paramBoolean);
  }
  
  public void b()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(int paramInt)
  {
    b(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void b(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels * 3 / 4, -2, 1.0F);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, localLayoutParams);
    }
  }
  
  public void b(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void b(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    if (paramCharSequence != null) {
      this.jdField_c_of_type_JavaLangCharSequence = paramCharSequence;
    }
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void c(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt), 0);
  }
  
  public void c(CharSequence paramCharSequence)
  {
    a(paramCharSequence, 0);
  }
  
  public void d(int paramInt)
  {
    d(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void d(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_c_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public void e(int paramInt)
  {
    if ((paramInt >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.k = paramInt;
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.k);
        if (localView != null) {
          ((ImageView)localView.findViewById(2131231062)).setBackgroundResource(2130840217);
        }
      }
    }
  }
  
  public void f(int paramInt)
  {
    if (paramInt > 0) {
      this.l = paramInt;
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      dismiss();
      label11:
      return super.onPrepareOptionsMenu(paramMenu);
    }
    catch (Exception localException)
    {
      break label11;
    }
  }
  
  public void setContentView(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setContentView(View paramView)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void show()
  {
    super.show();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.ActionSheet
 * JD-Core Version:    0.7.0.1
 */