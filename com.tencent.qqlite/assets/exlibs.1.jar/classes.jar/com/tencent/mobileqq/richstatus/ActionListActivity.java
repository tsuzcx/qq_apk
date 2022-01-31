package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import eav;
import eaw;
import eax;
import java.util.ArrayList;

public class ActionListActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, TabHost.OnTabChangeListener, IActionListener, IIconListener
{
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "k_action_id";
  static final boolean jdField_a_of_type_Boolean = true;
  private Intent jdField_a_of_type_AndroidContentIntent;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  TabHost jdField_a_of_type_AndroidWidgetTabHost;
  TabWidget jdField_a_of_type_AndroidWidgetTabWidget;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public ArrayList a;
  private int b;
  
  public ActionListActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "ActionListActivity.initData(), state tag size: " + this.jdField_a_of_type_JavaUtilArrayList.size() + " result: " + i);
    }
    if (i != 100)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(i);
      if ((this.b == -1) && ((i == 102) || (NetworkUtil.e(this)))) {
        d();
      }
    }
    i = getResources().getDisplayMetrics().widthPixels;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetTabWidget.removeAllViews();
      LayoutInflater localLayoutInflater = getLayoutInflater();
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int k = i / j;
      i = 0;
      while (i < j)
      {
        StateTag localStateTag = (StateTag)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2130903501, this.jdField_a_of_type_AndroidWidgetTabWidget, false);
        localTextView.setText(localStateTag.a);
        localTextView.setWidth(k);
        localTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetTabHost.addTab(this.jdField_a_of_type_AndroidWidgetTabHost.newTabSpec(localStateTag.a).setIndicator(localTextView).setContent(2131296497));
        i += 1;
      }
    }
    ((eax)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a();
    int j = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount();
    i = 0;
    while (i < j)
    {
      ((eaw)((GridView)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i)).getAdapter()).notifyDataSetChanged();
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "ActionListActivity.onGetActions(), result: " + paramInt1 + " message: " + paramInt2);
    }
    if (paramInt1 == 102) {
      c();
    }
    e();
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramInt2 == 201)) {
      a(paramInt1, paramBitmap);
    }
  }
  
  void a(int paramInt, Bitmap paramBitmap)
  {
    int k = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount();
    int i = 0;
    while (i < k)
    {
      GridView localGridView = (GridView)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i);
      int m = localGridView.getChildCount();
      int j = 0;
      while (j < m)
      {
        eav localeav = (eav)localGridView.getChildAt(j).getTag();
        if ((localeav != null) && (localeav.jdField_a_of_type_Int == paramInt)) {
          localeav.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(getResources(), paramBitmap, false, false));
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        break label35;
      }
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    for (;;)
    {
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
      label35:
      this.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoBackground(2130903051);
    this.jdField_a_of_type_AndroidWidgetTabHost = ((TabHost)findViewById(2131296496));
    this.jdField_a_of_type_AndroidWidgetTabHost.setup();
    this.jdField_a_of_type_AndroidWidgetTabHost.setOnTabChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTabWidget = this.jdField_a_of_type_AndroidWidgetTabHost.getTabWidget();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((MyViewPager)findViewById(2131296498));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new eax(this, null));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    this.b = getIntent().getIntExtra("k_action_id", -1);
    if (this.b == -1)
    {
      setTitle("你在做什么");
      this.h.setVisibility(8);
      setRightButton(2131363522, this);
    }
    for (;;)
    {
      this.h.setContentDescription(this.h.getText() + "按钮");
      this.j.setContentDescription(getResources().getString(2131363522) + "按钮");
      c();
      if (this.jdField_a_of_type_AndroidWidgetTabWidget.getChildCount() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTabWidget.setCurrentTab(0);
        this.jdField_a_of_type_AndroidWidgetTabWidget.focusCurrentTab(0);
      }
      if (paramBundle != null)
      {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("k_action_id", paramBundle.getLong("k_action_id", 0L));
        this.jdField_a_of_type_AndroidContentIntent.putExtra("k_action_text", paramBundle.getString("k_action_text"));
      }
      return true;
      setTitle(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.b).c);
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    super.doOnDestroy();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      paramBundle.putLong("k_action_id", this.jdField_a_of_type_AndroidContentIntent.getLongExtra("k_action_id", 0L));
      paramBundle.putString("k_action_text", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_action_text"));
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void finish()
  {
    super.finish();
    if (this.b == -1) {
      overridePendingTransition(0, 2130968584);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.j) {
      finish();
    }
    label12:
    ActionInfo localActionInfo;
    Intent localIntent;
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while ((paramView == null) || (!(paramView instanceof eav)));
      paramView = (eav)paramView;
      localActionInfo = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramView.jdField_a_of_type_Int);
      localIntent = new Intent();
      localIntent.putExtra("k_action_id", localActionInfo.jdField_i_of_type_Int);
      localIntent.putExtra("k_action_text", localActionInfo.d);
      if (localActionInfo.j == 1)
      {
        setResult(-1, localIntent);
        finish();
        return;
      }
    } while (localActionInfo.j == 0);
    View localView = null;
    for (;;)
    {
      try
      {
        int i = localActionInfo.j;
        switch (i)
        {
        default: 
          paramView = null;
          localView = paramView;
          if (localView == null) {
            break label12;
          }
          this.jdField_a_of_type_AndroidContentIntent = localIntent;
          startActivityForResult(localView, 0);
          return;
        }
      }
      catch (Exception localException4)
      {
        paramView = localException5;
        continue;
      }
      paramView = new Intent(this, ActionListActivity.class);
      try
      {
        paramView.putExtra("k_action_id", localActionInfo.jdField_i_of_type_Int);
      }
      catch (Exception localException1) {}
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            localView = paramView;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("Q.richstatus.", 2, localException1.getStackTrace().toString());
            localView = paramView;
            break;
            paramView = new Intent(this, ActionGridActivity.class);
            try
            {
              paramView.putExtra("k_action_id", localActionInfo.jdField_i_of_type_Int);
            }
            catch (Exception localException2) {}
          }
          continue;
          String str = localActionInfo.e.replace("$A", this.app.a());
          paramView = new Intent(this, ActionUrlActivity.class);
          try
          {
            paramView.putExtra("key_params_qq", str);
          }
          catch (Exception localException3) {}
        }
        continue;
        Object localObject = new Intent(this, Class.forName(localActionInfo.h));
        try
        {
          ((Intent)localObject).putExtra("param_plugin_gesturelock", true);
          paramView = (View)localObject;
          if (localActionInfo.jdField_i_of_type_JavaLangString == null) {
            break;
          }
          ((Intent)localObject).putExtra("key_params_qq", this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localActionInfo.jdField_i_of_type_JavaLangString, localActionInfo.jdField_i_of_type_Int, 0, ""));
          paramView = (View)localObject;
        }
        catch (Exception localException5)
        {
          paramView = (View)localObject;
          localObject = localException5;
        }
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTabHost.setCurrentTab(paramInt);
  }
  
  public void onTabChanged(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if ((i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (paramString.equals(((StateTag)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a)))
      {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i, false);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity
 * JD-Core Version:    0.7.0.1
 */