package com.tencent.mobileqq.richmedia.capture.view;

import aatg;
import aauj;
import aauj.a;
import alwa;
import alwk;
import alwk.a;
import alwx;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import anot;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import wja;

public class SubtitleProviderView
  extends ProviderView
  implements aauj.a, AdapterView.c
{
  public static final int dAh = wja.dp2px(64.0F, BaseApplication.getContext().getResources());
  public static final int dyn = wja.dp2px(12.0F, BaseApplication.getContext().getResources());
  private alwa a;
  private GridView e;
  private RelativeLayout lK;
  private List<alwk> vv = new ArrayList();
  
  public SubtitleProviderView(Context paramContext)
  {
    super(paramContext);
    aauj.a().init(true);
  }
  
  private void initData()
  {
    this.vv.clear();
    Object localObject = new alwk();
    ((alwk)localObject).mID = 0;
    this.vv.add(localObject);
    localObject = aauj.a().cd();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      this.vv.addAll((Collection)localObject);
    }
    if (this.a != null) {
      this.a.notifyDataSetChanged();
    }
  }
  
  public void cyE()
  {
    initData();
  }
  
  public void dKI()
  {
    if (this.a != null) {
      this.a.notifyDataSetChanged();
    }
  }
  
  public void gv(int paramInt1, int paramInt2)
  {
    if (this.a != null)
    {
      int j = this.e.getFirstVisiblePosition();
      int k = this.e.getLastVisiblePosition();
      int i = j;
      if (i <= k)
      {
        if (i < 0) {}
        alwk localalwk;
        do
        {
          i += 1;
          break;
          localalwk = (alwk)this.vv.get(i);
        } while ((localalwk == null) || (localalwk.mID != paramInt1) || (!localalwk.czX));
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleProviderView", 2, "onProgressUpdate index: " + i + " progress: " + paramInt2);
        }
        View localView = this.e.getChildAt(i - j);
        this.a.b(localalwk, localView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setNeedTabBar(false);
    super.onCreate(paramBundle);
    aauj.a().a(this);
    this.lK = ((RelativeLayout)this.mContentView);
    if (this.lK == null) {
      this.lK = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561634, this, false));
    }
    addContentView(this.lK);
    this.e = new GridView(this.mContext);
    this.lK.addView(this.e);
    this.e.setNumColumns(-1);
    this.e.setColumnWidth(dAh);
    int j = this.mContext.getResources().getDisplayMetrics().widthPixels - dyn * 2;
    int i = j / dAh;
    j -= dAh * i;
    if (j > 0)
    {
      i = j / (i - 1);
      this.e.setHorizontalSpacing(i);
    }
    for (;;)
    {
      this.e.setVerticalSpacing(dyn);
      this.e.setVerticalScrollBarEnabled(false);
      this.e.setPadding(dyn, dyn, dyn, dyn);
      this.e.setClipToPadding(false);
      this.e.setSelector(new ColorDrawable(0));
      this.e.setFocusable(false);
      this.e.setClickable(false);
      this.a = new alwa(this.mContext);
      this.a.setData(this.vv);
      this.a.dyp = 0;
      this.e.setAdapter(this.a);
      this.a.notifyDataSetChanged();
      this.e.setOnItemClickListener(this);
      if (aauj.a().getState() == 2) {
        initData();
      }
      return;
      this.e.setHorizontalSpacing(0);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.vv == null) || (this.vv.size() == 0) || (paramInt < 0) || (paramInt >= this.vv.size()) || (this.a == null)) {}
    do
    {
      return;
      paramAdapterView = (alwk)this.vv.get(paramInt);
    } while (paramAdapterView == null);
    this.a.dyp = paramAdapterView.mID;
    if (paramAdapterView.mID != 0)
    {
      anot.a(null, "dc00898", "", "", "0X8008757", "0X8008757", 0, 0, "", "", "", "");
      alwx.Tz(aatg.fN(paramAdapterView.mID));
      if (paramAdapterView.isResourceReady())
      {
        paramAdapterView.czX = false;
        if (this.c != null)
        {
          paramView = this.c;
          paramInt = paramAdapterView.mID;
          if (paramAdapterView.b != null) {
            break label177;
          }
          paramAdapterView = null;
          paramView.dC(paramInt, paramAdapterView);
        }
      }
    }
    for (;;)
    {
      this.a.notifyDataSetChanged();
      return;
      label177:
      paramAdapterView = paramAdapterView.b.mFile;
      break;
      paramAdapterView.czX = true;
      aauj.a().a(paramAdapterView.bZa, paramAdapterView.b);
      continue;
      if (this.c != null) {
        this.c.dC(paramAdapterView.mID, null);
      }
    }
  }
  
  public void y(int paramInt1, int paramInt2, String paramString)
  {
    View localView;
    if (this.a != null)
    {
      int j = this.e.getFirstVisiblePosition();
      int k = this.e.getLastVisiblePosition();
      int i = j;
      if (i <= k)
      {
        if (i < 0) {}
        do
        {
          i += 1;
          break;
          paramString = (alwk)this.vv.get(i);
          localView = this.e.getChildAt(i - j);
          if (paramString != null) {
            paramString.czX = false;
          }
        } while ((paramString == null) || (paramString.mID != paramInt1));
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleProviderView", 2, "onDownloadResult index: " + i);
        }
        if (paramInt2 != 0) {
          break label222;
        }
        this.a.a(paramString, localView);
      }
    }
    for (;;)
    {
      this.a.b(paramString, localView);
      if ((this.a != null) && (this.a.dyp == paramInt1) && (paramString.isResourceReady()))
      {
        paramString.czX = false;
        if (this.c != null)
        {
          if (paramString.b == null) {
            break;
          }
          this.c.dC(paramString.mID, paramString.b.mFile);
        }
      }
      return;
      label222:
      this.a.a(paramString, localView);
    }
    this.c.dC(paramString.mID, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.SubtitleProviderView
 * JD-Core Version:    0.7.0.1
 */