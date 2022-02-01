package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import anqz;
import aoop;
import aqnm;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.b;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.d;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import yrh;

public class ConnectionsTabLayout
  extends TabLayoutCompat
  implements TabLayoutCompat.b
{
  private ArrayList<yrh> mg = new ArrayList();
  
  public ConnectionsTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConnectionsTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ConnectionsTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(TabLayoutCompat.d paramd, a parama, yrh paramyrh)
  {
    if ((paramd == null) || (parama == null) || (paramyrh == null)) {}
    label236:
    label246:
    for (;;)
    {
      return;
      paramd.a(Integer.valueOf(paramyrh.tab_id));
      parama.fe.setText(paramyrh.aZz);
      paramd = getContext().getResources().getString(2131701427, new Object[] { Integer.valueOf(paramyrh.caI) });
      if (!paramyrh.boq) {
        paramd = getContext().getResources().getString(2131701425);
      }
      parama.cB.setText(paramd);
      paramd = a(paramyrh.aZA, paramyrh.aZB);
      if (paramd != null) {
        parama.aL.setImageDrawable(paramd);
      }
      int i = getContext().getResources().getColor(2131167436);
      int j = Color.parseColor("#F5F6FA");
      paramd = f(i, j);
      if (paramd != null)
      {
        parama.ux.setBackgroundDrawable(paramd);
        if (i == 0) {
          break label236;
        }
        parama.b.setDrawColor(i);
      }
      for (;;)
      {
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label246;
        }
        paramd = getContext().getResources().getColorStateList(2131166698);
        paramyrh = getContext().getResources().getColorStateList(2131166700);
        parama.fe.setTextColor(paramd);
        parama.cB.setTextColor(paramyrh);
        return;
        parama.ux.setImageResource(2130851539);
        break;
        parama.b.setDrawColor(j);
      }
    }
  }
  
  private URLDrawable getDrawable(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    URLDrawable localURLDrawable;
    do
    {
      return localObject;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectionsTabLayout", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void init()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  public void Ew(int paramInt)
  {
    int i = qP();
    if (i == paramInt) {
      if (QLog.isColorLevel()) {
        QLog.d("ConnectionsTabLayout", 2, "selectTabWithoutCallback viewPosition ->" + i + ",position =" + paramInt);
      }
    }
    TabLayoutCompat.d locald;
    do
    {
      return;
      locald = a(paramInt);
    } while (locald == null);
    locald.baB();
  }
  
  public int a(ArrayList<yrh> paramArrayList, int paramInt)
  {
    int k;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      k = 0;
      return k;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      k = j;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (((yrh)paramArrayList.get(i)).tab_id == paramInt) {
        j = i;
      }
      i += 1;
    }
  }
  
  public Drawable a(String paramString1, String paramString2)
  {
    String str = null;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    URLDrawable localURLDrawable;
    if (!TextUtils.isEmpty(paramString1))
    {
      localURLDrawable = getDrawable(paramString1);
      paramString1 = localURLDrawable;
      if (localURLDrawable != null) {
        localURLDrawable.startDownload();
      }
    }
    for (paramString1 = localURLDrawable;; paramString1 = null)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = getDrawable(paramString2);
        str = paramString2;
        if (paramString2 != null)
        {
          paramString2.startDownload();
          str = paramString2;
        }
      }
      if (paramString1 != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, paramString1);
      }
      if (str != null) {
        localStateListDrawable.addState(new int[] { -16842913 }, str);
      }
      return localStateListDrawable;
    }
  }
  
  public void a(TabLayoutCompat.d paramd)
  {
    new a(paramd.getCustomView()).bgV();
  }
  
  public void b(TabLayoutCompat.d paramd)
  {
    new a(paramd.getCustomView()).bgW();
  }
  
  public void c(TabLayoutCompat.d paramd) {}
  
  public Drawable f(int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      localObject = null;
    }
    StateListDrawable localStateListDrawable;
    anqz localanqz;
    do
    {
      return localObject;
      localObject = new anqz(paramInt1, 50, 50, aqnm.dip2px(6.0F));
      localStateListDrawable = new StateListDrawable();
      localanqz = new anqz(paramInt2, 50, 50, aqnm.dip2px(6.0F));
      if (localObject != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
      }
      localObject = localStateListDrawable;
    } while (localanqz == null);
    localStateListDrawable.addState(new int[] { -16842913 }, localanqz);
    return localStateListDrawable;
  }
  
  public void u(ArrayList<yrh> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConnectionsTabLayout", 2, "createTab infos: null");
      }
      return;
    }
    this.mg.clear();
    this.mg.addAll(paramArrayList);
    removeAllTabs();
    a(this);
    if (this.mg.size() <= 3)
    {
      setTabMode(1);
      setTabGravity(0);
    }
    int i;
    for (;;)
    {
      i = a(paramArrayList, paramInt);
      paramInt = 0;
      label82:
      if (paramInt >= this.mg.size()) {
        break label182;
      }
      paramArrayList = a();
      if (paramArrayList != null) {
        break label131;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ConnectionsTabLayout", 2, "createTab newTab: null");
      return;
      setTabMode(0);
      setTabGravity(1);
    }
    label131:
    paramArrayList.b(2131561506);
    a(paramArrayList, new a(paramArrayList.getCustomView()), (yrh)this.mg.get(paramInt));
    if (i == paramInt) {
      a(paramArrayList, true);
    }
    for (;;)
    {
      paramInt += 1;
      break label82;
      label182:
      break;
      a(paramArrayList, false);
    }
  }
  
  public void v(ArrayList<yrh> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConnectionsTabLayout", 2, "updateTabs infos: " + paramArrayList);
      }
      return;
    }
    this.mg.clear();
    this.mg.addAll(paramArrayList);
    int i = paramArrayList.size();
    if (getTabCount() != i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConnectionsTabLayout", 2, "updateTabs getTabCount() != infoSize " + getTabCount() + ", infoSize =" + i);
      }
      u(paramArrayList, paramInt);
      return;
    }
    i = a(paramArrayList, paramInt);
    paramInt = 0;
    label134:
    a locala;
    if (paramInt < getTabCount())
    {
      paramArrayList = a(paramInt);
      if (paramArrayList != null)
      {
        yrh localyrh = (yrh)this.mg.get(paramInt);
        locala = new a(paramArrayList.getCustomView());
        a(paramArrayList, locala, localyrh);
        if (i != paramInt) {
          break label209;
        }
        Ew(paramInt);
        locala.bgV();
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label134;
      break;
      label209:
      locala.bgW();
    }
  }
  
  public static class a
  {
    ImageView aL;
    TriangleView b;
    TextView cB;
    TextView fe;
    ImageView ux;
    
    public a(View paramView)
    {
      this.aL = ((ImageView)paramView.findViewById(2131372342));
      this.ux = ((ImageView)paramView.findViewById(2131372339));
      this.fe = ((TextView)paramView.findViewById(2131372343));
      this.cB = ((TextView)paramView.findViewById(2131372341));
      this.b = ((TriangleView)paramView.findViewById(2131380179));
    }
    
    public void bgV()
    {
      if (this.aL != null) {
        this.aL.setSelected(true);
      }
      if (this.ux != null) {
        this.ux.setSelected(true);
      }
      if (this.fe != null) {
        this.fe.setSelected(true);
      }
      if (this.cB != null) {
        this.cB.setSelected(true);
      }
      if (this.b != null) {
        this.b.setVisibility(0);
      }
    }
    
    public void bgW()
    {
      if (this.aL != null) {
        this.aL.setSelected(false);
      }
      if (this.ux != null) {
        this.ux.setSelected(false);
      }
      if (this.fe != null) {
        this.fe.setSelected(false);
      }
      if (this.cB != null) {
        this.cB.setSelected(false);
      }
      if (this.b != null) {
        this.b.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabLayout
 * JD-Core Version:    0.7.0.1
 */