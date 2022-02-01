package com.tencent.mobileqq.richmedia.capture.adapter;

import alvx;
import alwd;
import alwl;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import anjg;
import ankq;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView.a;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import wja;

public class PtvTemplateViewPagerAdapter
  extends PagerAdapter
{
  private List<alwl> Ft = new CopyOnWriteArrayList();
  ProviderView.a b;
  boolean czH = true;
  private AppInterface mApp;
  private Context mContext;
  public HashMap<Integer, GridView> mF = new HashMap();
  
  public PtvTemplateViewPagerAdapter(Context paramContext, AppInterface paramAppInterface, ProviderView.a parama, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mApp = paramAppInterface;
    this.b = parama;
    this.czH = paramBoolean;
  }
  
  public alwl a(alwl paramalwl)
  {
    if (paramalwl == null) {
      return paramalwl;
    }
    int i;
    label17:
    int j;
    label25:
    alwl localalwl;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (ankq.ayc()) {
        break label205;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label208;
      }
      localalwl = new alwl();
      localalwl.categoryId = paramalwl.categoryId;
      localalwl.categoryName = paramalwl.categoryName;
      localalwl.czY = paramalwl.czY;
      localalwl.dyC = paramalwl.dyC;
      localalwl.bZc = paramalwl.bZc;
      localalwl.Fv = new ArrayList();
      if ((paramalwl.Fv == null) || (paramalwl.Fv.size() <= 0)) {
        break label216;
      }
      paramalwl = paramalwl.Fv.iterator();
    }
    label128:
    label205:
    label208:
    label214:
    for (;;)
    {
      if (!paramalwl.hasNext()) {
        break label216;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramalwl.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 9))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label214;
        }
        localalwl.Fv.add(localPtvTemplateInfo);
        break label128;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label216:
    return localalwl;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.mF.get(Integer.valueOf(paramInt)));
  }
  
  public int getCount()
  {
    return this.Ft.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateViewPagerAdapter", 2, "instantiateItem position = " + paramInt);
    }
    GridView localGridView = (GridView)this.mF.get(Integer.valueOf(paramInt));
    if (localGridView == null)
    {
      localGridView = new GridView(this.mContext);
      localGridView.setNumColumns(-1);
      int m = wja.dp2px(64.0F, this.mContext.getResources());
      localGridView.setColumnWidth(m);
      int i = wja.dp2px(12.0F, this.mContext.getResources());
      int j = wja.dp2px(12.0F, this.mContext.getResources());
      int n = this.mContext.getResources().getDisplayMetrics().widthPixels - j * 2;
      int k = n / m;
      m = n - m * k;
      if (m > 0)
      {
        localGridView.setHorizontalSpacing(m / (k - 1));
        localGridView.setVerticalSpacing(i);
        localGridView.setVerticalScrollBarEnabled(false);
        localGridView.setPadding(j, j, j, wja.dp2px(12.0F, this.mContext.getResources()) * 4);
        localGridView.setClipToPadding(false);
        localGridView.setSelector(new ColorDrawable(0));
        if (paramInt < this.Ft.size())
        {
          Object localObject = a(anjg.c((alwl)this.Ft.get(paramInt)));
          alvx localalvx = new alvx(this.mApp, this.mContext, localGridView, this.b, (alwl)localObject, this.czH);
          localGridView.setAdapter(localalvx);
          localalvx.aa(((alwl)localObject).Fv, 0);
          localObject = alwd.a();
          ((alwd)localObject).a(localalvx, 112);
          ((alwd)localObject).a(localalvx, 113);
          if (paramInt == 0) {
            ((alwd)localObject).a(localalvx, 111);
          }
        }
        this.mF.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      paramViewGroup.addView(localGridView);
      return localGridView;
      localGridView.setHorizontalSpacing(0);
      break;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void lV(List<alwl> paramList)
  {
    this.Ft.clear();
    this.Ft.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */