package com.tencent.mobileqq.colornote.settings;

import aeay;
import aebq;
import aebr;
import aecz;
import aedc;
import aedf;
import aedg;
import aedh;
import aedn;
import ahbr;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ColorNoteSettingFragment
  extends IphoneTitleBarFragment
{
  private TextView QX;
  private SettingSectionContainer a;
  private FormSwitchItem aT;
  private Activity mActivity;
  
  public static void a(Context paramContext, Class<? extends ColorNoteSettingFragment> paramClass, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramClass == null)) {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        if (paramContext != null) {
          break label62;
        }
        paramContext = "context ";
        paramBundle = paramBundle.append(paramContext);
        if (paramClass != null) {
          break label68;
        }
        paramContext = "fragment ";
        label42:
        QLog.d("ColorNoteSettingFragment", 0, paramContext + "is null");
      }
    }
    label62:
    label68:
    do
    {
      return;
      paramContext = "";
      break;
      paramContext = "";
      break label42;
      anot.a(null, "dc00898", "", "", "0X800AA7E", "0X800AA7E", paramBundle.getInt("start_from", 1), 0, "", "", "", "");
      paramBundle = new Intent();
      paramBundle.addFlags(268435456);
      paramBundle.addFlags(536870912);
      paramBundle.addFlags(67108864);
      PublicFragmentActivity.b.start(paramContext, paramBundle, PublicFragmentActivity.class, paramClass);
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteSettingFragment", 0, "start fragment: " + paramClass.getName());
  }
  
  private void cVN()
  {
    this.a = ((SettingSectionContainer)this.mContentView.findViewById(2131364916));
    this.a.removeAllViews();
    SparseArray localSparseArray = g();
    int[] arrayOfInt = aedc.kO;
    int j = arrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject1 = aedc.a(k);
      if ((localObject1 == null) || (TextUtils.isEmpty(((aedn)localObject1).getTitle()))) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = aedc.aU((List)localSparseArray.get(k));
        ColorNoteSettingBaseSection localColorNoteSettingBaseSection = new ColorNoteSettingBaseSection(this.mActivity);
        aecz localaecz = new aecz();
        localColorNoteSettingBaseSection.setAdapter(localaecz);
        localaecz.setData((List)localObject2, k);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.mContentView.getContext().getResources().getDimensionPixelSize(2131299399);
        localColorNoteSettingBaseSection.setHeaderOnClickListener(new aedf(this, (aedn)localObject1, k));
        localObject1 = ((aedn)localObject1).getTitle();
        localColorNoteSettingBaseSection.setHeaderTitle((CharSequence)localObject1);
        localColorNoteSettingBaseSection.setContentDescription((CharSequence)localObject1);
        this.a.addView(localColorNoteSettingBaseSection, (ViewGroup.LayoutParams)localObject2);
        aedc.jc(k);
      }
    }
    setTitle(getString(2131691747));
  }
  
  private SparseArray<List<ColorNote>> g()
  {
    Object localObject1 = aedc.kO;
    SparseArray localSparseArray = new SparseArray(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      int k = localObject1[i];
      localSparseArray.put(k, aedc.T(k));
      i += 1;
    }
    List localList = (List)localSparseArray.get(17039360);
    localObject1 = new ArrayList();
    Object localObject2 = localList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ColorNote)((Iterator)localObject2).next();
      if (ahbr.de(((ColorNote)localObject3).getSubType()) == 4) {
        ((List)localObject1).add(localObject3);
      }
    }
    localList.removeAll((Collection)localObject1);
    localList = aedc.T(16908288);
    localObject2 = aedc.T(16908290);
    Object localObject3 = (List)localSparseArray.get(17104896);
    if ((localList != null) && (localList.size() > 0)) {
      ((List)localObject3).addAll(localList);
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      ((List)localObject3).addAll((Collection)localObject2);
    }
    if (((List)localObject1).size() > 0) {
      ((List)localObject3).addAll((Collection)localObject1);
    }
    Collections.sort((List)localObject3, new aedg(this));
    return localSparseArray;
  }
  
  private void initSettings()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aebq localaebq = aebr.a();
    if ((localaebq != null) && (localaebq.agp())) {}
    for (int i = 1;; i = 0)
    {
      if ((aeay.an(localQQAppInterface)) && (i != 0)) {}
      for (boolean bool = true;; bool = false)
      {
        this.aT = ((FormSwitchItem)this.mContentView.findViewById(2131364912));
        this.QX = ((TextView)this.mContentView.findViewById(2131364913));
        if (i != 0)
        {
          this.aT.setVisibility(0);
          this.QX.setVisibility(0);
          this.aT.setChecked(bool);
          this.aT.setOnCheckedChangeListener(new aedh(this, localQQAppInterface));
        }
        return;
      }
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    cVN();
    initSettings();
  }
  
  public int getContentLayoutId()
  {
    return 2131559020;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ColorNoteSettingFragment.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment
 * JD-Core Version:    0.7.0.1
 */