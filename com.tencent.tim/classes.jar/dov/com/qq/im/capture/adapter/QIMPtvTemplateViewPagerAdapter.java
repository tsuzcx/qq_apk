package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import ankq;
import axov;
import axpa;
import axql;
import ayzs;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.view.ProviderView.a;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import wja;

public class QIMPtvTemplateViewPagerAdapter
  extends PagerAdapter
{
  private List<axql> Ft;
  private ayzs a;
  ProviderView.a b;
  private int eCJ;
  private AdapterView.c h;
  private Context mContext;
  public HashMap<Integer, GridView> mF = new HashMap();
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, ProviderView.a parama, int paramInt)
  {
    this.mContext = paramContext;
    this.b = parama;
    this.eCJ = paramInt;
    this.a = ((ayzs)axov.a(3));
  }
  
  public axql a(int paramInt)
  {
    if ((this.Ft != null) && (this.Ft.size() > paramInt) && (paramInt >= 0)) {
      return (axql)this.Ft.get(paramInt);
    }
    return null;
  }
  
  public axql a(axql paramaxql)
  {
    if (paramaxql == null) {
      return paramaxql;
    }
    int i;
    label17:
    int j;
    label25:
    axql localaxql;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (ankq.ayc()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localaxql = new axql();
      localaxql.categoryId = paramaxql.categoryId;
      localaxql.categoryName = paramaxql.categoryName;
      localaxql.dvY = paramaxql.dvY;
      localaxql.Fv = new ArrayList();
      if ((paramaxql.Fv == null) || (paramaxql.Fv.size() <= 0)) {
        break label198;
      }
      paramaxql = paramaxql.Fv.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!paramaxql.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaxql.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localaxql.Fv.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localaxql;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.mF.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.mF.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (axpa)paramViewGroup.getAdapter();
      this.a.d(paramViewGroup);
    }
  }
  
  public int getCount()
  {
    return this.Ft.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "instantiateItem position = " + paramInt);
    }
    GridView localGridView = (GridView)this.mF.get(Integer.valueOf(paramInt));
    int j;
    axpa localaxpa;
    if (localGridView == null)
    {
      localGridView = new GridView(this.mContext);
      localGridView.setNumColumns(-1);
      int n = wja.dp2px(60.0F, this.mContext.getResources());
      localGridView.setColumnWidth(n);
      int i = wja.dp2px(12.0F, this.mContext.getResources());
      j = wja.dp2px(10.0F, this.mContext.getResources());
      int k = wja.dp2px(18.0F, this.mContext.getResources());
      int i1 = this.mContext.getResources().getDisplayMetrics().widthPixels - k * 2;
      int m = (i1 + j) / (n + j);
      n = i1 - n * m;
      if (n > j)
      {
        localGridView.setHorizontalSpacing(n / (m - 1));
        localGridView.setVerticalSpacing(i);
        localGridView.setVerticalScrollBarEnabled(false);
        localGridView.setPadding(k, k, k, i * 4);
        localGridView.setClipToPadding(false);
        localGridView.setSelector(new ColorDrawable(0));
        localaxpa = new axpa(this.mContext, localGridView, this.b, this.eCJ);
        this.a.a(localaxpa, 112);
        this.a.a(localaxpa, 113);
        this.a.a(localaxpa, 114);
        this.a.a(localaxpa, 115);
        if (paramInt == 0) {
          this.a.a(localaxpa, 111);
        }
        localGridView.setOnItemClickListener(this.h);
        this.mF.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localaxpa.oI(a((axql)this.Ft.get(paramInt)).Fv);
      localGridView.setAdapter(localaxpa);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localaxpa);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localaxpa = (axpa)localGridView.getAdapter();
      this.a.a(localaxpa, 112);
      this.a.a(localaxpa, 113);
      this.a.a(localaxpa, 114);
      this.a.a(localaxpa, 115);
      if (paramInt == 0) {
        this.a.a(localaxpa, 111);
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void lV(List<axql> paramList)
  {
    this.Ft = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */