package com.tencent.mobileqq.emoticonview;

import afmf;
import afqx;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemEmoticonPanel
  extends RelativeLayout
{
  protected EmoticonPagerAdapter a;
  private a a;
  protected boolean car;
  protected Context context;
  protected EmoticonPagerRadioGroup d;
  protected View root;
  protected ViewPager viewPager;
  
  public SystemEmoticonPanel(Context paramContext, afmf paramafmf)
  {
    this(paramContext, paramafmf, false);
  }
  
  public SystemEmoticonPanel(Context paramContext, afmf paramafmf, boolean paramBoolean)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 24) {}
    try
    {
      Field localField = Class.forName("android.view.LayoutInflater").getDeclaredField("sConstructorMap");
      localField.setAccessible(true);
      ((HashMap)localField.get(LayoutInflater.from(paramContext))).remove("android.support.v4.view.ViewPager");
      this.root = LayoutInflater.from(paramContext).inflate(getLayoutId(), this);
      this.car = paramBoolean;
      a(paramContext, paramafmf);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localClassNotFoundException);
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localNoSuchFieldException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localIllegalAccessException);
      }
    }
  }
  
  public SystemEmoticonPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public SystemEmoticonPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  protected void a(Context paramContext, afmf paramafmf)
  {
    this.d = ((EmoticonPagerRadioGroup)this.root.findViewById(2131376602));
    this.viewPager = ((ViewPager)this.root.findViewById(2131381896));
    this.d.setViewPager(this.viewPager);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new afqx(paramContext, paramafmf, 0));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.kv(localArrayList);
    this.viewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
    this.viewPager.setCurrentItem(0);
    this.d.MF(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.getCount());
  }
  
  public void destory()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.destroy();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel$a != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel$a.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected int getLayoutId()
  {
    return 2131559296;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        i = paramMotionEvent.getAction() & 0xFF;
        if (i != 0) {
          continue;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("SystemEmoticonPanel", 1, "onInterceptTouchEvent failed", localException);
        continue;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setCallBack(afmf paramafmf)
  {
    a(this.context, paramafmf);
  }
  
  public void setDispatchKeyEventListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonPanel
 * JD-Core Version:    0.7.0.1
 */