package com.tencent.mobileqq.emoticonview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import fow;
import fox;
import foy;
import foz;
import fpa;

public class HorizonEmoticonTabs
  extends HorizontalScrollView
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "HorizonEmoticonTabs";
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private HorizonEmoticonTabs.EmoticonTabChangeListener jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs$EmoticonTabChangeListener;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  
  @TargetApi(9)
  public HorizonEmoticonTabs(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_b_of_type_Int = ((int)paramContext.getResources().getDimension(2131427518));
    this.c = ((int)paramContext.getResources().getDimension(2131427519));
    if (Build.VERSION.SDK_INT > 8) {
      setOverScrollMode(2);
    }
  }
  
  private void a(boolean paramBoolean, View paramView, int paramInt)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131231654);
    View localView = paramView.findViewById(2131231651);
    paramView.findViewById(2131231652).setSelected(paramBoolean);
    localImageView.setSelected(paramBoolean);
    if (!paramBoolean)
    {
      localView.setBackgroundResource(2130839116);
      if (paramInt > 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt - 1).findViewById(2131231651).setBackgroundResource(2130839116);
      }
    }
    do
    {
      return;
      localView.setBackgroundResource(2130837641);
    } while (paramInt <= 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt - 1).findViewById(2131231651).setBackgroundResource(2130837641);
  }
  
  private void d()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (this.jdField_a_of_type_Int < j)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int);
        j = (int)getResources().getDimension(2131427515);
        int m = super.getMeasuredWidth();
        int[] arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        int k = arrayOfInt[0];
        int n = localView.getMeasuredWidth();
        if (k + n > m + j) {
          i = k + n - j;
        }
        while (i != 0)
        {
          post(new fpa(this, i));
          return;
          if (k < j) {
            i = k - j;
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs$EmoticonTabChangeListener = null;
  }
  
  public void a(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    ((ImageView)localView.findViewById(2131231653)).setVisibility(0);
  }
  
  public void a(Drawable paramDrawable, int paramInt)
  {
    post(new foy(this, paramInt, paramDrawable));
  }
  
  public void a(EmoticonViewBinder paramEmoticonViewBinder, int paramInt, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() != this))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new FrameLayout.LayoutParams(-2, -1));
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();
    for (;;)
    {
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903664, null);
        ImageView localImageView = (ImageView)localView.findViewById(2131231654);
        Object localObject = localView.findViewById(2131231651);
        if (paramBoolean)
        {
          i = 0;
          ((View)localObject).setVisibility(i);
          localImageView.setAdjustViewBounds(false);
          localObject = Boolean.valueOf(false);
          if ((paramEmoticonViewBinder instanceof ActionTabViewBinder)) {
            localObject = Boolean.valueOf(true);
          }
          localView.setTag(localObject);
          Drawable localDrawable = paramEmoticonViewBinder.a(this.jdField_a_of_type_AndroidContentContext);
          localObject = localDrawable;
          if (localDrawable == null)
          {
            localObject = localDrawable;
            if ((paramEmoticonViewBinder instanceof BigEmoticonViewBinder))
            {
              paramEmoticonViewBinder = (BigEmoticonViewBinder)paramEmoticonViewBinder;
              localObject = BigEmoticonViewBinder.b(this.jdField_a_of_type_AndroidContentContext);
              paramEmoticonViewBinder.a.status = 0;
              ThreadManager.b(new fow(this, localQQAppInterface, paramEmoticonViewBinder));
            }
          }
          if (localObject != null)
          {
            localImageView.setImageDrawable((Drawable)localObject);
            ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
          }
          localView.setOnClickListener(this);
          paramEmoticonViewBinder = new LinearLayout.LayoutParams(paramInt, -1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, paramEmoticonViewBinder);
          if (QLog.isColorLevel()) {
            QLog.d("HorizonEmoticonTabs", 2, "[Performance] addTab1, duration=" + (System.currentTimeMillis() - l));
          }
          return;
        }
      }
      catch (InflateException paramEmoticonViewBinder)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("HorizonEmoticonTabs", 2, "addFirstTab error: " + paramEmoticonViewBinder.getMessage());
        return;
      }
      int i = 4;
    }
  }
  
  public void a(EmoticonViewBinder paramEmoticonViewBinder, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() != this))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new FrameLayout.LayoutParams(-2, -1));
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();
    for (;;)
    {
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903215, null);
        ImageView localImageView2 = (ImageView)localView.findViewById(2131231654);
        ImageView localImageView1 = (ImageView)localView.findViewById(2131231653);
        Object localObject1 = localView.findViewById(2131231651);
        if (paramBoolean)
        {
          i = 0;
          ((View)localObject1).setVisibility(i);
          localImageView2.setAdjustViewBounds(false);
          localObject1 = Boolean.valueOf(false);
          if ((paramEmoticonViewBinder instanceof ActionTabViewBinder)) {
            localObject1 = Boolean.valueOf(true);
          }
          localView.setTag(localObject1);
          Object localObject2 = paramEmoticonViewBinder.a(this.jdField_a_of_type_AndroidContentContext);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if ((paramEmoticonViewBinder instanceof BigEmoticonViewBinder))
            {
              localObject2 = (BigEmoticonViewBinder)paramEmoticonViewBinder;
              localObject1 = BigEmoticonViewBinder.b(this.jdField_a_of_type_AndroidContentContext);
              ((BigEmoticonViewBinder)localObject2).a.status = 0;
              ThreadManager.b(new fox(this, localQQAppInterface, (BigEmoticonViewBinder)localObject2));
            }
          }
          if (localObject1 != null)
          {
            localImageView2.setImageDrawable((Drawable)localObject1);
            ((Drawable)localObject1).setBounds(0, 0, this.c, this.c);
            if ((paramEmoticonViewBinder instanceof BigEmoticonViewBinder))
            {
              paramEmoticonViewBinder = (BigEmoticonViewBinder)paramEmoticonViewBinder;
              if ((paramEmoticonViewBinder.a != null) && (EmoticonUtils.a(paramEmoticonViewBinder.a)) && (EmoticonUtils.c(paramEmoticonViewBinder.a.updateFlag)) && (paramEmoticonViewBinder.a.valid) && (!paramEmoticonViewBinder.a.hasReadUpdatePage))
              {
                localImageView1.setVisibility(0);
                ReportController.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_hdshow", 0, 0, paramEmoticonViewBinder.a.epId, "", "", "");
              }
            }
          }
          localView.setOnClickListener(this);
          paramEmoticonViewBinder = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, paramEmoticonViewBinder);
          if (QLog.isColorLevel()) {
            QLog.d("HorizonEmoticonTabs", 2, "[Performance] addTab2, duration=" + (System.currentTimeMillis() - l));
          }
          return;
        }
      }
      catch (InflateException paramEmoticonViewBinder)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("HorizonEmoticonTabs", 2, "addSecondTab error: " + paramEmoticonViewBinder.getMessage());
        return;
      }
      int i = 4;
    }
  }
  
  public boolean a(int paramInt)
  {
    return ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt).findViewById(2131231653)).getVisibility() == 0;
  }
  
  public void b()
  {
    super.removeAllViews();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void c()
  {
    b();
    a();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    label26:
    label224:
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      Object localObject = null;
      int i = 0;
      if (i < j)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (localObject == paramView) {
          paramView = (View)localObject;
        }
      }
      for (;;)
      {
        if ((i == -1) || (i >= j) || (paramView == null)) {
          break label224;
        }
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs$EmoticonTabChangeListener != null)) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs$EmoticonTabChangeListener.a(this.jdField_a_of_type_Int, i);
        }
        if (!((Boolean)paramView.getTag()).booleanValue())
        {
          if (this.jdField_a_of_type_Int < j) {
            a(false, this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int), this.jdField_a_of_type_Int);
          }
          if (paramView != null)
          {
            localObject = (ImageView)paramView.findViewById(2131231653);
            if (localObject != null) {
              ((ImageView)localObject).setVisibility(8);
            }
            a(true, paramView, i);
          }
          this.jdField_a_of_type_Int = i;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonMainPanel", 2, "[Performance] TabsChanged duration:" + (System.currentTimeMillis() - l));
        return;
        i += 1;
        break label26;
        paramView = (View)localObject;
        i = -1;
      }
    }
  }
  
  public void setEmoticonTabChangeListener(HorizonEmoticonTabs.EmoticonTabChangeListener paramEmoticonTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs$EmoticonTabChangeListener = paramEmoticonTabChangeListener;
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setSelectedIndex(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    while (paramInt >= this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()) {
      return;
    }
    onClick(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt));
    this.jdField_a_of_type_Int = paramInt;
    super.postDelayed(new foz(this), 200L);
  }
  
  public void setSelectedIndex(int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    setSelectedIndex(paramInt);
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HorizonEmoticonTabs
 * JD-Core Version:    0.7.0.1
 */