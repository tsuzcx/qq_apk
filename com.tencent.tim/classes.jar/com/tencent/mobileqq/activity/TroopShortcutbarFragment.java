package com.tencent.mobileqq.activity;

import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aoop;
import apou;
import apox;
import apoy;
import apoz;
import appa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import weh;
import wei;
import wej;

public class TroopShortcutbarFragment
  extends IphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  TextView GR;
  appa a;
  int bMD;
  boolean bbQ;
  Switch d;
  LinearLayout gN;
  boolean isDestory = false;
  public FragmentActivity mActivity;
  private QQAppInterface mApp;
  public long mTroopCode;
  public ArrayList<Pair<URLDrawable, URLImageView>> pT = new ArrayList();
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mActivity = getActivity();
    if ((this.mActivity == null) || (this.mActivity.app == null) || (this.mContentView == null))
    {
      QLog.e("TroopShortcutbarFragment", 1, "doOnCreateView error mActivity:" + this.mActivity + " mContentView:" + this.mContentView);
      return;
    }
    this.mApp = this.mActivity.app;
    this.isDestory = false;
    this.d = ((Switch)this.mContentView.findViewById(2131378111));
    this.d.setOnCheckedChangeListener(this);
    this.d.setTag(new wei());
    this.GR = ((TextView)this.mContentView.findViewById(2131378268));
    this.gN = ((LinearLayout)this.mContentView.findViewById(2131378267));
    paramViewGroup = this.mActivity.getIntent();
    paramLayoutInflater = paramViewGroup.getStringExtra("troopuin");
    this.mTroopCode = Long.parseLong(paramLayoutInflater);
    this.bMD = ((int)paramViewGroup.getLongExtra("trooptype", 0L));
    this.bbQ = paramViewGroup.getBooleanExtra("isManagerPage", false);
    paramViewGroup = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramViewGroup instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramViewGroup);
    }
    if (this.mApp != null)
    {
      this.a = new weh(this.mApp, this);
      this.mApp.addObserver(this.a);
    }
    yh(true);
    setTitle(acfp.m(2131698441));
    paramViewGroup = this.leftView;
    paramBundle = getString(2131691039);
    if (paramViewGroup != null)
    {
      paramViewGroup.setText("");
      paramViewGroup.setContentDescription(paramBundle);
    }
    anot.a(null, "dc00898", "", "", "0X800AAD8", "0X800AAD8", 0, 0, "", paramLayoutInflater, String.valueOf(this.bMD), "");
  }
  
  public int getContentLayoutId()
  {
    return 2131560102;
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    if (!this.d.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("disabled", bool);
      this.mActivity.setResult(-1, localIntent);
      this.pT.clear();
      getActivity().finish();
      return true;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.mApp == null) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      wei localwei = (wei)paramCompoundButton.getTag();
      apox localapox = (apox)this.mApp.getBusinessHandler(171);
      Object localObject = (apoz)this.mApp.getManager(355);
      apoy localapoy = ((apoz)localObject).b(Long.valueOf(this.mTroopCode));
      int i;
      if (paramBoolean)
      {
        i = 0;
        label75:
        if ((localwei == null) || (localapox == null) || (localObject == null) || (localapoy == null)) {
          break label208;
        }
        if (localwei.type != 0) {
          break label258;
        }
        if (((!this.bbQ) || (localapoy.LD() == i)) && ((this.bbQ) || (localapoy.LC() == i))) {
          continue;
        }
        if (!this.bbQ) {
          break label210;
        }
        localapoy.WV(i);
      }
      for (;;)
      {
        localapox.g(this.mTroopCode, i, this.bbQ);
        if (!paramBoolean) {
          break label219;
        }
        anot.a(null, "dc00898", "", "", "0X800AAD9", "0X800AAD9", 0, 0, "", String.valueOf(this.mTroopCode), String.valueOf(this.bMD), "");
        break;
        i = 1;
        break label75;
        label208:
        break;
        label210:
        localapoy.WU(i);
      }
      label219:
      anot.a(null, "dc00898", "", "", "0X800AADA", "0X800AADA", 0, 0, "", String.valueOf(this.mTroopCode), String.valueOf(this.bMD), "");
      continue;
      label258:
      if ((localapoy.cO(localwei.appId)) && (!paramBoolean))
      {
        localapox.g(this.mTroopCode, i, this.bbQ);
        anot.a(null, "dc00898", "", "", "0X800AADA", "0X800AADA", 0, 0, "", String.valueOf(this.mTroopCode), String.valueOf(this.bMD), "");
        anot.a(null, "dc00898", "", "", "0X800AADC", "0X800AADC", 0, 0, String.valueOf(localwei.appId), String.valueOf(this.mTroopCode), String.valueOf(this.bMD), "");
      }
      else
      {
        localObject = localapoy.a(localwei.appId);
        if ((localObject != null) && (((apou)localObject).Lz() != i))
        {
          ((apou)localObject).WS(i);
          long l1 = this.mTroopCode;
          long l2 = localwei.appId;
          if (paramBoolean) {}
          for (i = 0;; i = 1)
          {
            localapox.p(l1, l2, i);
            if (!paramBoolean) {
              break label485;
            }
            anot.a(null, "dc00898", "", "", "0X800AADB", "0X800AADB", 0, 0, String.valueOf(((apou)localObject).hw()), String.valueOf(this.mTroopCode), String.valueOf(this.bMD), "");
            break;
          }
          label485:
          anot.a(null, "dc00898", "", "", "0X800AADC", "0X800AADC", 0, 0, String.valueOf(((apou)localObject).hw()), String.valueOf(this.mTroopCode), String.valueOf(this.bMD), "");
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.isDestory = true;
    if (this.mApp != null) {
      this.mApp.removeObserver(this.a);
    }
    this.a = null;
    super.onDestroy();
  }
  
  public void onFinish()
  {
    Intent localIntent = new Intent();
    if (!this.d.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("disabled", bool);
      this.mActivity.setResult(-1, localIntent);
      super.onFinish();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.isDestory = false;
    yh(true);
  }
  
  public void yh(boolean paramBoolean)
  {
    if (this.isDestory) {}
    Object localObject1;
    do
    {
      do
      {
        return;
      } while (this.mApp == null);
      localObject2 = (apoz)this.mApp.getManager(355);
      localObject1 = (apox)this.mApp.getBusinessHandler(171);
    } while (localObject2 == null);
    Object localObject2 = ((apoz)localObject2).b(Long.valueOf(this.mTroopCode));
    if (localObject2 != null)
    {
      if ((paramBoolean) && (((apoy)localObject2).hx() < System.currentTimeMillis()) && (localObject1 != null)) {
        ((apox)localObject1).aW(this.mTroopCode, this.bMD);
      }
      if (((this.bbQ) && (((apoy)localObject2).LD() == 0)) || ((!this.bbQ) && (((apoy)localObject2).LC() == 0)))
      {
        this.d.setChecked(true);
        this.GR.setText(2131698439);
        localObject1 = ((apoy)localObject2).dU();
        this.gN.removeAllViews();
        this.pT.clear();
        localObject1 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          label164:
          if (!((Iterator)localObject1).hasNext()) {
            break label477;
          }
          localObject2 = (apou)((Iterator)localObject1).next();
          try
          {
            if ((this.bbQ) || (((apou)localObject2).Lz() != 1))
            {
              localObject3 = LayoutInflater.from(this.mActivity).inflate(2131561777, null);
              this.gN.addView((View)localObject3);
              localObject4 = LayoutInflater.from(this.mActivity).inflate(2131561775, null);
              ((View)localObject4).setBackgroundResource(2130851773);
              this.gN.addView((View)localObject4);
              ((View)localObject4).getLayoutParams().height = 2;
              ((TextView)((View)localObject3).findViewById(2131379769)).setText(((apou)localObject2).getAppName());
              localObject4 = (Switch)((View)localObject3).findViewById(2131378109);
              if (!this.bbQ) {
                break label524;
              }
              wei localwei = new wei();
              localwei.type = 1;
              localwei.appId = ((apou)localObject2).hw();
              ((Switch)localObject4).setTag(localwei);
              if (((apou)localObject2).Lz() != 0) {
                break label519;
              }
              paramBoolean = true;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              Object localObject4;
              if (QLog.isColorLevel()) {
                QLog.e("TroopShortcutbarFragment", 2, "TroopShortcutbarFragment.updateView got OOM, e:" + localOutOfMemoryError.getMessage());
              }
              System.gc();
              return;
              paramBoolean = false;
              continue;
              ((Switch)localObject4).setVisibility(8);
            }
          }
          catch (InflateException localInflateException)
          {
            if (!QLog.isColorLevel()) {
              break label570;
            }
            QLog.e("TroopShortcutbarFragment", 2, "TroopShortcutbarFragment.updateView got InflateException, e:" + localInflateException.getMessage());
            System.gc();
            return;
          }
        }
        ((Switch)localObject4).setChecked(paramBoolean);
        ((Switch)localObject4).setOnCheckedChangeListener(this);
        Object localObject3 = (URLImageView)((View)localObject3).findViewById(2131378266);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject4).mUseAutoScaleParams = false;
        if (((apou)localObject2).Bv() != null)
        {
          localObject2 = URLDrawable.getDrawable(((apou)localObject2).Bv(), (URLDrawable.URLDrawableOptions)localObject4);
          if (ThemeUtil.isInNightMode(this.mApp)) {
            ((URLImageView)localObject3).setColorFilter(1996488704);
          }
          if (((URLDrawable)localObject2).getStatus() == 1)
          {
            localObject2 = ((URLDrawable)localObject2).getCurrDrawable();
            if ((localObject2 instanceof RegionDrawable))
            {
              ((URLImageView)localObject3).setImageBitmap(((RegionDrawable)localObject2).getBitmap());
              ((URLImageView)localObject3).setVisibility(0);
            }
          }
        }
        for (;;)
        {
          this.gN.setVisibility(0);
          break label164;
          label477:
          break;
          label519:
          label524:
          label570:
          this.pT.add(new Pair(localObject2, localObject3));
          ((URLDrawable)localObject2).setURLDrawableListener(new wej(this));
          if (!((URLDrawable)localObject2).isDownloadStarted())
          {
            ((URLDrawable)localObject2).startDownload();
            continue;
            ((URLImageView)localObject3).setImageDrawable(getResources().getDrawable(2130844521));
          }
        }
      }
      this.d.setChecked(false);
      this.GR.setText(2131698440);
      this.gN.setVisibility(4);
      return;
    }
    if ((paramBoolean) && (localInflateException != null)) {
      localInflateException.aW(this.mTroopCode, this.bMD);
    }
    this.d.setChecked(false);
    this.GR.setText(2131698440);
    this.gN.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopShortcutbarFragment
 * JD-Core Version:    0.7.0.1
 */