package com.tencent.common.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ViewFlipper;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InnerFrameManager
  extends ViewFlipper
  implements ViewStub.OnInflateListener
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private Activity jdField_a_of_type_AndroidAppActivity = null;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = false;
  
  public InnerFrameManager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerFrameManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new InnerFrame(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(paramContext, 0);
  }
  
  public int a()
  {
    return getDisplayedChild() - 1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    ((InnerFrame)getChildAt(getDisplayedChild())).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsBundle = null;
    a(paramInt, true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    paramInt += 1;
    if (getDisplayedChild() == paramInt) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      ((InnerFrame)getChildAt(getDisplayedChild())).b();
    }
    ((InnerFrame)getChildAt(getDisplayedChild())).c();
    getChildAt(paramInt).setVisibility(0);
    if (paramBoolean) {
      if (getDisplayedChild() != 0)
      {
        if (getDisplayedChild() >= paramInt) {
          break label135;
        }
        setInAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130968612);
        setOutAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130968613);
      }
    }
    for (;;)
    {
      setDisplayedChild(paramInt);
      ((InnerFrame)getChildAt(paramInt)).b(this.jdField_a_of_type_AndroidOsBundle);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      ((InnerFrame)getChildAt(paramInt)).a();
      return;
      label135:
      setInAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130968610);
      setOutAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130968611);
      continue;
      setInAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130968624);
      setOutAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130968624);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    int j = getChildCount();
    int i = 1;
    while (i < j)
    {
      ((ViewStub)getChildAt(i)).setOnInflateListener(this);
      i += 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    ((InnerFrame)getChildAt(getDisplayedChild())).b();
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).d();
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    paramViewStub = (InnerFrame)paramView;
    this.jdField_a_of_type_JavaUtilSet.add(paramViewStub);
    paramViewStub.setActivity(this.jdField_a_of_type_AndroidAppActivity);
    paramViewStub.setInnerFrameManager(this);
    paramViewStub.setAppIntf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramViewStub.a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void setAppIntf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).setAppIntf(paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.app.InnerFrameManager
 * JD-Core Version:    0.7.0.1
 */