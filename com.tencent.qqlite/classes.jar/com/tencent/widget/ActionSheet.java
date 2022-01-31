package com.tencent.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fho;
import fhp;
import fhr;
import fhs;
import java.util.ArrayList;

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
  public static final int k = 4;
  private static final int l = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fhr(this);
  private View jdField_a_of_type_AndroidViewView;
  private Window jdField_a_of_type_AndroidViewWindow;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = null;
  private ActionSheet.OnDismissListener jdField_a_of_type_ComTencentWidgetActionSheet$OnDismissListener = null;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new fhs(this);
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean;
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private boolean jdField_c_of_type_Boolean;
  private int m = -1;
  private int n = 300;
  
  protected ActionSheet(Context paramContext)
  {
    this(paramContext, 2131624166, true);
  }
  
  protected ActionSheet(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903052, null);
    super.setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131296500));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131296501));
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    setCanceledOnTouchOutside(true);
  }
  
  private int a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427511);
  }
  
  public static ActionSheet a(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext);
    paramContext.getWindow().setWindowAnimations(2131624165);
    return paramContext;
  }
  
  public static ActionSheet a(Context paramContext, int paramInt)
  {
    return new ActionSheet(paramContext, paramInt, false);
  }
  
  private void a(View paramView, int paramInt)
  {
    int i2 = 0;
    if (this.jdField_b_of_type_Boolean)
    {
      i1 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493104);
      if (4 != paramInt) {
        break label72;
      }
    }
    label72:
    for (ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(i1, -2);; localLayoutParams = new ViewGroup.LayoutParams(i1, (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493105)))
    {
      paramView.setLayoutParams(localLayoutParams);
      if (this.jdField_b_of_type_Boolean) {
        break label98;
      }
      return;
      i1 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131492905);
      break;
    }
    label98:
    int i1 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493106);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      paramView.setPadding(i1, i2, i1, paramInt);
      return;
      localLayoutParams.height = (localLayoutParams.height + i1 + i1);
      paramInt = i1;
      i2 = i1;
      continue;
      localLayoutParams.height += i1;
      paramInt = 0;
      i2 = i1;
      continue;
      localLayoutParams.height += i1 * 2;
      paramInt = 0;
      i2 = i1;
      continue;
      paramInt = 0;
      continue;
      localLayoutParams.height += i1;
      paramInt = i1;
    }
  }
  
  public static ActionSheet b(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, 2131624166, false);
    paramContext.getWindow().setWindowAnimations(2131624165);
    return paramContext;
  }
  
  private void b()
  {
    Object localObject1;
    int i3;
    int i2;
    Object localObject2;
    if (this.jdField_c_of_type_Boolean)
    {
      i1 = 0;
      while (i1 < this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject1 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
        if ((localObject1 instanceof RelativeLayout))
        {
          i3 = ((RelativeLayout)localObject1).getChildCount();
          i2 = 0;
          while (i2 < i3)
          {
            localObject2 = ((RelativeLayout)localObject1).getChildAt(i2);
            if (((localObject2 instanceof TextView)) && (((View)localObject2).getContentDescription() != null)) {
              ((TextView)localObject2).setTextColor(a(0));
            }
            i2 += 1;
          }
        }
        i1 += 1;
      }
    }
    c();
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903054, null);
      a((View)localObject1, 4);
      ((View)localObject1).setBackgroundDrawable(a(4));
      localObject2 = (TextView)((View)localObject1).findViewById(2131296507);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(this.jdField_a_of_type_JavaLangCharSequence);
      ((TextView)localObject2).setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      if (this.jdField_b_of_type_JavaLangCharSequence != null)
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131296508);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangCharSequence);
        ((TextView)localObject2).setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
      ((View)localObject1).setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, 0);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        i2 = i1 + this.jdField_a_of_type_JavaUtilArrayList.size();
        i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
        i1 = 0;
        if (i1 < i3)
        {
          localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903053, null);
          if (((this.jdField_a_of_type_JavaLangCharSequence == null) && (i1 == 0)) || (this.jdField_b_of_type_Boolean)) {
            ((View)localObject2).findViewById(2131296502).setVisibility(8);
          }
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = (TextView)((View)localObject2).findViewById(2131296504);
            label342:
            Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if (((Integer)((Pair)localPair.first).first).intValue() != -1)
            {
              ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131296503);
              localImageView.setBackgroundResource(((Integer)((Pair)localPair.first).first).intValue());
              localImageView.setVisibility(0);
            }
            ((TextView)localObject1).setText((CharSequence)((Pair)localPair.first).second);
            ((TextView)localObject1).setContentDescription((CharSequence)((Pair)localPair.first).second);
            ((TextView)localObject1).setTextColor(a(((Integer)localPair.second).intValue()));
            if ((i1 != 0) || (i2 != i3) || (i2 != 1)) {
              break label639;
            }
            a((View)localObject2, 0);
            localObject1 = a(0);
          }
          for (;;)
          {
            ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
            ((View)localObject2).setId(i1);
            ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
                this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
              }
              this.jdField_a_of_type_AndroidUtilSparseArray.append(i1, localObject2);
              if (i1 == this.m)
              {
                ((View)localObject2).findViewById(2131296506).setVisibility(0);
                ((View)localObject2).findViewById(2131296506).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131364358));
              }
            }
            i1 += 1;
            break;
            localObject1 = (TextView)((View)localObject2).findViewById(2131296505);
            ((TextView)localObject1).setVisibility(0);
            break label342;
            label639:
            if ((i1 == 0) && (i2 == i3) && (i2 > 1))
            {
              a((View)localObject2, 1);
              localObject1 = a(1);
            }
            else if ((i1 == i3 - 1) && (i2 > 1))
            {
              a((View)localObject2, 3);
              localObject1 = a(3);
            }
            else
            {
              a((View)localObject2, 2);
              localObject1 = a(2);
            }
          }
        }
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewWindow = getWindow();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewWindow.setGravity(51);
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindow.getAttributes();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      this.jdField_a_of_type_AndroidViewWindow.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      localLayoutParams.x = ((int)(localDisplayMetrics.widthPixels - this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493104) - 6.0F));
      localLayoutParams.y = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131492887) + 6);
      this.jdField_a_of_type_AndroidViewWindow.setAttributes(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_AndroidViewWindow.setGravity(17);
  }
  
  public Drawable a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      switch (paramInt)
      {
      default: 
        return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838130);
      case 0: 
        return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837513);
      case 1: 
        return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837516);
      case 2: 
        return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837510);
      case 3: 
        return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837507);
      }
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837517);
    }
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838130);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839287);
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Pair localPair = (Pair)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).first;
      if (localPair != null) {
        return ((CharSequence)localPair.second).toString();
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
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
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(new Pair(Integer.valueOf(paramInt), paramCharSequence), Integer.valueOf(-1));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (this.jdField_a_of_type_Boolean) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if ((paramInt1 >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(paramInt1);
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131296504);
        if ((localObject != null) && (TextView.class.isInstance(localObject)))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setText(paramCharSequence);
          ((TextView)localObject).setTextColor(a(paramInt2));
          paramCharSequence = new Pair(new Pair(Integer.valueOf(-1), paramCharSequence), Integer.valueOf(paramInt2));
          this.jdField_a_of_type_JavaUtilArrayList.set(paramInt1, paramCharSequence);
        }
      }
    }
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
      paramCharSequence = new Pair(new Pair(Integer.valueOf(-1), paramCharSequence), Integer.valueOf(paramInt));
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
    if (paramCharSequence != null)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(new Pair(Integer.valueOf(-1), paramCharSequence), Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (paramBoolean) {
        this.m = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence, 0, paramBoolean);
  }
  
  public void b(int paramInt)
  {
    b(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void b(int paramInt, CharSequence paramCharSequence)
  {
    a(paramInt, paramCharSequence, 0);
  }
  
  public void b(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
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
    if (!this.jdField_b_of_type_Boolean)
    {
      a(this);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fhp(this), 0L);
  }
  
  public void e(int paramInt)
  {
    if ((paramInt >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.m = paramInt;
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.m);
        if (localView != null)
        {
          localView.findViewById(2131296506).setVisibility(0);
          localView.findViewById(2131296506).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131364358));
        }
      }
    }
  }
  
  public void f(int paramInt)
  {
    if (paramInt > 0) {
      this.n = paramInt;
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
    b();
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fho(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.ActionSheet
 * JD-Core Version:    0.7.0.1
 */