package com.tencent.mobileqq.richstatus;

import acfp;
import amev;
import amff;
import amfh;
import amhg;
import amhj;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import anot;
import aqiw;
import arhz;
import arjh;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.QRBridgeActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class ActionListActivity
  extends IphoneTitleBarActivity
  implements amff, amfh, ViewPager.OnPageChangeListener, View.OnClickListener, TabHost.OnTabChangeListener
{
  static final boolean bTE = AppSetting.enableTalkBack;
  TabHost jdField_a_of_type_AndroidWidgetTabHost;
  TabWidget jdField_a_of_type_AndroidWidgetTabWidget;
  private Intent am;
  ArrayList<amhg> bh = new ArrayList();
  private amhj d;
  private int mActionId;
  ViewPager mViewPager;
  
  private void initData()
  {
    int i = this.d.r(this.bh);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "ActionListActivity.initData(), state tag size: " + this.bh.size() + " result: " + i);
    }
    if (i != 100)
    {
      this.d.ja(i);
      if ((this.mActionId == -1) && ((i == 102) || (aqiw.isNetSupport(this)))) {
        startTitleProgress();
      }
    }
    i = getResources().getDisplayMetrics().widthPixels;
    if ((this.bh != null) && (this.bh.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetTabWidget.removeAllViews();
      LayoutInflater localLayoutInflater = getLayoutInflater();
      j = this.bh.size();
      int k = i / j;
      i = 0;
      while (i < j)
      {
        amhg localamhg = (amhg)this.bh.get(i);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131561377, this.jdField_a_of_type_AndroidWidgetTabWidget, false);
        localTextView.setText(localamhg.tagName);
        localTextView.setWidth(k);
        localTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetTabHost.addTab(this.jdField_a_of_type_AndroidWidgetTabHost.newTabSpec(localamhg.tagName).setIndicator(localTextView).setContent(2131361824));
        i += 1;
      }
    }
    ((c)this.mViewPager.getAdapter()).bSJ();
    int j = this.mViewPager.getChildCount();
    i = 0;
    while (i < j)
    {
      ((b)((GridView)this.mViewPager.getChildAt(i)).getAdapter()).notifyDataSetChanged();
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramInt2 == 201)) {
      e(paramInt1, paramBitmap);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      if (this.am != null) {
        break label35;
      }
      this.am = paramIntent;
    }
    for (;;)
    {
      setResult(-1, this.am);
      finish();
      return;
      label35:
      this.am.putExtras(paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558462);
    this.jdField_a_of_type_AndroidWidgetTabHost = ((TabHost)findViewById(2131379147));
    this.jdField_a_of_type_AndroidWidgetTabHost.setup();
    this.jdField_a_of_type_AndroidWidgetTabHost.setOnTabChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTabWidget = this.jdField_a_of_type_AndroidWidgetTabHost.getTabWidget();
    this.mViewPager = ((MyViewPager)findViewById(2131381929));
    this.mViewPager.setOnPageChangeListener(this);
    this.mViewPager.setAdapter(new c(null));
    this.d = ((amhj)this.app.getManager(15));
    this.d.addListener(this);
    this.mActionId = getIntent().getIntExtra("k_action_id", -1);
    if (this.mActionId == -1)
    {
      setTitle(acfp.m(2131701982));
      this.leftView.setVisibility(8);
      setRightButton(2131721059, this);
    }
    for (;;)
    {
      if (bTE)
      {
        this.leftView.setContentDescription(this.leftView.getText() + acfp.m(2131701981));
        this.rightViewText.setContentDescription(getResources().getString(2131721059) + acfp.m(2131701980));
      }
      initData();
      if (this.jdField_a_of_type_AndroidWidgetTabWidget.getChildCount() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTabWidget.setCurrentTab(0);
        this.jdField_a_of_type_AndroidWidgetTabWidget.focusCurrentTab(0);
      }
      if (paramBundle != null)
      {
        this.am = new Intent();
        this.am.putExtra("k_action_id", paramBundle.getLong("k_action_id", 0L));
        this.am.putExtra("k_action_text", paramBundle.getString("k_action_text"));
      }
      return true;
      amev localamev = this.d.a(this.mActionId);
      if (localamev != null) {
        setTitle(localamev.title);
      } else {
        setTitle(acfp.m(2131701979));
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.d.removeListener(this);
    super.doOnDestroy();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (this.am != null)
    {
      paramBundle.putLong("k_action_id", this.am.getLongExtra("k_action_id", 0L));
      paramBundle.putString("k_action_text", this.am.getStringExtra("k_action_text"));
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  void e(int paramInt, Bitmap paramBitmap)
  {
    int k = this.mViewPager.getChildCount();
    int i = 0;
    while (i < k)
    {
      GridView localGridView = (GridView)this.mViewPager.getChildAt(i);
      int m = localGridView.getChildCount();
      int j = 0;
      while (j < m)
      {
        a locala = (a)localGridView.getChildAt(j).getTag();
        if ((locala != null) && (locala.actionId == paramInt)) {
          locala.Dk.setImageDrawable(new arjh(getResources(), paramBitmap, false, false));
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.mActionId == -1) {
      overridePendingTransition(0, 2130771990);
    }
  }
  
  public void fk(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "ActionListActivity.onGetActions(), result: " + paramInt1 + " message: " + paramInt2);
    }
    if (paramInt1 == 102) {
      initData();
    }
    stopTitleProgress();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText) {
      finish();
    }
    amev localamev;
    Intent localIntent;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = paramView.getTag();
        if ((localObject == null) || ((localObject instanceof a)))
        {
          localObject = (a)localObject;
          localamev = this.d.a(((a)localObject).actionId);
          if (localamev != null)
          {
            localIntent = new Intent();
            localIntent.putExtra("k_action_id", localamev.id);
            localIntent.putExtra("k_action_text", localamev.name);
            if (localamev.type != 1) {
              break;
            }
            anot.a(this.app, "CliOper", "", "", "0X8006988", "0X8006988", 0, 0, Integer.toString(localamev.id), "", "", "");
            setResult(-1, localIntent);
            finish();
          }
        }
      }
    } while (localamev.type == 0);
    for (;;)
    {
      try
      {
        int i = localamev.type;
        switch (i)
        {
        default: 
          localObject = null;
        }
      }
      catch (Exception localException3)
      {
        try
        {
          ((Intent)localObject).putExtra("param_plugin_gesturelock", true);
          if (localException2.bZS != null) {
            ((Intent)localObject).putExtra("key_params_qq", this.d.d(localException2.bZS, localException2.id, 0, ""));
          }
          if (!QRBridgeActivity.dnn) {
            continue;
          }
          if (!QRBridgeActivity.dno)
          {
            arhz localarhz = new arhz(this, getTitleBarHeight());
            localarhz.setMessage(acfp.m(2131701978));
            new SplashDialogWrapper(this, localarhz, acfp.m(2131701977), "qqreaderplugin.apk", true, 10000).show();
            QRBridgeActivity.dno = true;
          }
        }
        catch (Exception localException4) {}
        localException3 = localException3;
        localObject = null;
        continue;
        continue;
      }
      if (localObject == null) {
        break;
      }
      this.am = localIntent;
      startActivityForResult((Intent)localObject, 0);
      break;
      localObject = new Intent(this, ActionListActivity.class);
      try
      {
        ((Intent)localObject).putExtra("k_action_id", localamev.id);
      }
      catch (Exception localException1) {}
    }
    for (;;)
    {
      for (;;)
      {
        QLog.e("Q.richstatus.", 1, "", localException1);
        break;
        localObject = null;
        break;
        String str = localException1.baseUrl.replace("$A", this.app.getCurrentAccountUin());
        localObject = new Intent(this, ActionUrlActivity.class);
        try
        {
          ((Intent)localObject).putExtra("key_params_qq", str);
        }
        catch (Exception localException2) {}
      }
    }
    localException2.bZR = localException2.bZR.replace("com.qqreader.QRBridgeActivity", "cooperation.qqreader.QRBridgeActivity");
    localObject = new Intent(this, Class.forName(localException2.bZR));
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
      if ((i >= this.bh.size()) || (paramString.equals(((amhg)this.bh.get(i)).tagName)))
      {
        this.mViewPager.setCurrentItem(i, false);
        return;
      }
      i += 1;
    }
  }
  
  static class a
  {
    public ImageView Dk;
    public TextView Yb;
    public int actionId;
  }
  
  class b
    extends BaseAdapter
  {
    private ArrayList<Integer> zo;
    
    public b()
    {
      Object localObject;
      this.zo = localObject;
    }
    
    public int getCount()
    {
      if (this.zo == null) {
        return 0;
      }
      return this.zo.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.zo.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ActionListActivity.a locala;
      if (paramView == null)
      {
        paramView = ActionListActivity.this.getLayoutInflater().inflate(2131563128, paramViewGroup, false);
        locala = new ActionListActivity.a(null);
        locala.Dk = ((ImageView)paramView.findViewById(2131378905));
        locala.Yb = ((TextView)paramView.findViewById(2131378906));
        paramView.setTag(locala);
      }
      for (;;)
      {
        locala = (ActionListActivity.a)paramView.getTag();
        amev localamev = ActionListActivity.a(ActionListActivity.this).a(((Integer)this.zo.get(paramInt)).intValue());
        if ((localamev != null) && (locala.actionId != localamev.id))
        {
          locala.actionId = localamev.id;
          locala.Dk.setImageDrawable(new arjh(ActionListActivity.this.getResources(), ActionListActivity.a(ActionListActivity.this).i(localamev.id, 201), false, false));
          locala.Yb.setText(localamev.title);
          if (localamev.type != 1) {
            break label226;
          }
          locala.Yb.setCompoundDrawables(null, null, null, null);
        }
        for (;;)
        {
          paramView.setOnClickListener(ActionListActivity.this);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          label226:
          locala.Yb.setCompoundDrawablesWithIntrinsicBounds(null, null, ActionListActivity.this.getResources().getDrawable(2130839512), null);
          locala.Yb.setCompoundDrawablePadding(10);
        }
      }
    }
  }
  
  class c
    extends PagerAdapter
  {
    private ArrayList<GridView> zp = new ArrayList();
    
    private c() {}
    
    public void bSJ()
    {
      this.zp.clear();
      try
      {
        Iterator localIterator = ActionListActivity.this.bh.iterator();
        while (localIterator.hasNext())
        {
          amhg localamhg = (amhg)localIterator.next();
          GridView localGridView = new GridView(ActionListActivity.this.getApplicationContext());
          localGridView.setNumColumns(3);
          localGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          localGridView.setSelector(new ColorDrawable(0));
          localGridView.setScrollingCacheEnabled(false);
          localGridView.setAdapter(new ActionListActivity.b(ActionListActivity.this, localamhg.gF));
          this.zp.add(localGridView);
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        System.gc();
        super.notifyDataSetChanged();
      }
    }
    
    public void destroyItem(View paramView, int paramInt, Object paramObject) {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)this.zp.get(paramInt));
    }
    
    public int getCount()
    {
      return this.zp.size();
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      GridView localGridView = (GridView)this.zp.get(paramInt);
      paramViewGroup.addView(localGridView);
      return localGridView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity
 * JD-Core Version:    0.7.0.1
 */