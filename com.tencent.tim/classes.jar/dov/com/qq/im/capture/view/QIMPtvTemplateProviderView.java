package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anho;
import anjo;
import aqnm;
import axov;
import axpa;
import axql;
import axrf;
import axxp;
import ayzs;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import rpw;
import wja;

public class QIMPtvTemplateProviderView
  extends ProviderView
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, anho, QIMSlidingTabView.a
{
  private ImageView Dg;
  private ImageView Dh;
  List<axql> Ft = new CopyOnWriteArrayList();
  private View Gs;
  private axql jdField_a_of_type_Axql;
  public axrf a;
  QIMPtvTemplateViewPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter;
  QQViewPager b;
  ayzs c;
  private boolean cBm;
  private boolean dtJ = true;
  private boolean dtb;
  private boolean dwU;
  private boolean dxm;
  int dzN = 1;
  private int dzP = -1;
  private TextView mTipsTextView;
  
  public QIMPtvTemplateProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Axrf = new axxp(this);
  }
  
  private ArrayList<QIMSlidingTabView.b> dx()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_c_of_type_Ayzs != null) {}
    for (int i = this.jdField_c_of_type_Ayzs.Io();; i = -1)
    {
      int j = 0;
      while (j < this.Ft.size())
      {
        axql localaxql = (axql)this.Ft.get(j);
        if ((i != -1) && (i == localaxql.categoryId)) {
          this.dzN = j;
        }
        QIMSlidingTabView.b localb = new QIMSlidingTabView.b();
        localb.tabName = localaxql.categoryName;
        localb.czY = localaxql.czY;
        localArrayList.add(localb);
        j += 1;
      }
      return localArrayList;
    }
  }
  
  protected Bundle D()
  {
    Bundle localBundle = new Bundle();
    if (this.b != null)
    {
      int i = this.b.getCurrentItem();
      if ((this.Ft != null) && (i >= 0) && (i < this.Ft.size()))
      {
        axql localaxql = (axql)this.Ft.get(i);
        String str = localaxql.categoryName;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateProviderView", 2, "save " + localaxql.categoryName);
          }
          localBundle.putString("ProviderView.select_item_category", str);
        }
      }
    }
    return localBundle;
  }
  
  protected int QW()
  {
    return 2131561136;
  }
  
  @TargetApi(9)
  public void TX(int paramInt)
  {
    this.b.setCurrentItem(paramInt);
    if (paramInt != 1) {
      ePc();
    }
  }
  
  public void Xe(boolean paramBoolean)
  {
    if (!this.mInited) {
      return;
    }
    this.Ft = this.jdField_c_of_type_Ayzs.d(paramBoolean);
    int j = this.dzN;
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (this.b != null)
      {
        i = j;
        if (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter != null)
        {
          if (this.dtJ) {
            break label360;
          }
          i = this.b.getCurrentItem();
          axql localaxql1 = this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(i);
          if (localaxql1 == null) {
            break label360;
          }
          i = 0;
          label81:
          if (i >= this.Ft.size()) {
            break label360;
          }
          axql localaxql2 = (axql)this.Ft.get(i);
          if ((localaxql2 == null) || (TextUtils.isEmpty(localaxql2.categoryName)) || (!localaxql2.categoryName.equals(localaxql1.categoryName))) {
            break label344;
          }
        }
      }
    }
    for (;;)
    {
      this.dtJ = false;
      if (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter != null) {
        this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.lV(this.Ft);
      }
      if (this.b != null) {
        this.b.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter);
      }
      if (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)
      {
        this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.eL(dx());
        this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
      }
      j = i;
      if (i >= this.Ft.size())
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("PtvTemplateProviderView", 2, "resetPos " + i + " not exist, mTabList size = " + this.Ft.size());
          j = 0;
        }
      }
      if ((this.Ft.size() > 0) && (this.b != null) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView != null))
      {
        this.b.setCurrentItem(j);
        this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(j);
      }
      if (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView == null) {
        break;
      }
      i = this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.getScrollX();
      if (this.mTipsTextView == null)
      {
        dLx();
        return;
        label344:
        i += 1;
        break label81;
      }
      if (i == 0) {
        break;
      }
      dLw();
      return;
      label360:
      i = j;
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 114) || (paramVarArgs == null) || (paramVarArgs.length != 1)) {
      return;
    }
    dLw();
  }
  
  public void apk()
  {
    super.apk();
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null)
    {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.a(null, "");
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.adg(null);
    }
    if (this.jdField_c_of_type_Ayzs != null)
    {
      this.jdField_c_of_type_Ayzs.aq("0", 0, "");
      axpa.eGt = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "onClear");
    }
  }
  
  public void aq(int paramInt, String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("selectCategoryAndItem");
      ((StringBuilder)localObject).append("  category=").append(paramInt);
      ((StringBuilder)localObject).append(", categoryName=").append(paramString1);
      ((StringBuilder)localObject).append(", itemId=").append(paramString2);
      ((StringBuilder)localObject).append(", mTabListSize=").append(this.Ft.size());
      QLog.d("PtvTemplateProviderView", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    if (i < this.Ft.size()) {
      if ((paramInt != -1) && (((axql)this.Ft.get(i)).categoryId == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label135:
      a().TX(paramInt);
      localObject = (axql)this.Ft.get(this.b.getCurrentItem());
      i = 0;
      label167:
      if (i < ((axql)localObject).Fv.size())
      {
        paramString1 = (PtvTemplateManager.PtvTemplateInfo)((axql)localObject).Fv.get(i);
        if (!paramString1.id.equals(paramString2)) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, "itemInfo= " + paramString1 + ",index=" + paramInt + ",pos=" + i);
        }
        if (paramString1 != null)
        {
          if (paramString1.isWsBanner()) {
            rpw.a(this.mContext, paramString1);
          }
        }
        else
        {
          return;
          if ((paramString1 != null) && (paramString1.equals(((axql)this.Ft.get(i)).categoryName)))
          {
            paramInt = i;
            break label135;
          }
          i += 1;
          break;
          i += 1;
          break label167;
        }
        postDelayed(new QIMPtvTemplateProviderView.2(this, paramString1), 200L);
        return;
        i = 0;
        paramString1 = null;
      }
      paramInt = 0;
    }
  }
  
  public boolean bg(int paramInt1, int paramInt2)
  {
    if (this.mApp == null) {}
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.mApp)
    {
      localObject = getContext().getSharedPreferences(anjo.cer + ((AppRuntime)localObject).getAccount(), 4);
      if (!((SharedPreferences)localObject).getBoolean(paramInt1 + "&" + paramInt2, false)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, already shown, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
      }
      return true;
    }
    if (((SharedPreferences)localObject).contains(String.valueOf(paramInt1)))
    {
      if (((SharedPreferences)localObject).getInt(String.valueOf(paramInt1), 0) > paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, exist high version, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
        }
        return true;
      }
      ((SharedPreferences)localObject).edit().remove(String.valueOf(paramInt1)).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, not shown, id: ", Integer.valueOf(paramInt1), " tipver: ", Integer.valueOf(paramInt2) });
    }
    return false;
  }
  
  public void dKI()
  {
    super.dKI();
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateProviderView", 2, "onProviderShow isAccountChange=" + this.dwU + " isInit=" + isInit());
    }
    if ((isInit()) && (this.dwU))
    {
      updateData();
      this.dwU = false;
      return;
    }
    Xe(false);
  }
  
  public void dLs()
  {
    super.dLs();
    if (this.b != null) {
      this.b.removeAllViews();
    }
    if (this.cBm) {
      dLw();
    }
  }
  
  public void dLw()
  {
    if ((this.mTipsTextView != null) && (this.mTipsTextView.getVisibility() == 0))
    {
      this.Gs = null;
      this.mTipsTextView.setVisibility(8);
      this.Dg.setVisibility(8);
      if (this.Dh != null) {
        this.Dh.setVisibility(8);
      }
      if (this.jdField_a_of_type_Axql != null) {
        if (this.mApp != null) {
          break label192;
        }
      }
    }
    label192:
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.mApp)
    {
      String str = this.jdField_a_of_type_Axql.categoryId + "&" + this.jdField_a_of_type_Axql.dyC;
      localObject = getContext().getSharedPreferences(anjo.cer + ((AppRuntime)localObject).getAccount(), 4).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(str, true);
      ((SharedPreferences.Editor)localObject).putInt(String.valueOf(this.jdField_a_of_type_Axql.categoryId), this.jdField_a_of_type_Axql.dyC);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public void dLx()
  {
    int i;
    label35:
    int j;
    int m;
    int i2;
    int k;
    label238:
    Object localObject3;
    label298:
    label311:
    label360:
    RelativeLayout.LayoutParams localLayoutParams;
    int n;
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView;
        if (localObject1 != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i1;
        Context localContext;
        label561:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, showTipsLayout ", localException.getMessage() });
        continue;
      }
      finally {}
      return;
      if (!this.cBm)
      {
        localObject1 = this.jdField_c_of_type_Ayzs.d(false);
        i = 0;
        if (i < ((ArrayList)localObject1).size())
        {
          this.jdField_a_of_type_Axql = ((axql)((ArrayList)localObject1).get(i));
          if ((this.jdField_a_of_type_Axql.bZc == null) || (bg(this.jdField_a_of_type_Axql.categoryId, this.jdField_a_of_type_Axql.dyC))) {
            break label975;
          }
          this.dzP = i;
        }
        if ((this.dzP != -1) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.dy().size() > this.dzP)) {
          this.Gs = ((View)this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.dy().get(this.dzP));
        }
      }
      if ((this.Gs != null) && (this.jdField_a_of_type_Axql != null))
      {
        i = this.Gs.getLeft();
        j = this.Gs.getRight();
        m = this.Gs.getWidth();
        if ((i != 0) || (j != 0))
        {
          i2 = aqnm.getScreenWidth();
          i1 = this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.getScrollX();
          j = m / 2 + i - i1;
          k = wja.dp2px(30.0F, getContext().getResources());
          if ((j <= 0) || (j + k >= i2)) {
            break label982;
          }
          j = 1;
          this.cBm = true;
          if ((this.mTipsTextView == null) && (j != 0) && (this.dzM == 2))
          {
            if ((this.mBaseView == null) || (!(this.mBaseView instanceof RelativeLayout))) {
              continue;
            }
            if (this.oa == null) {
              break label987;
            }
            localObject1 = (RelativeLayout)this.oa.getParent();
            if (this.oa == null) {
              break label996;
            }
            localObject3 = this.oa;
            localContext = getContext();
            this.Dg = new ImageView(localContext);
            this.Dg.setId(2131378277);
            if (!this.jdField_a_of_type_Axql.czY) {
              break label1005;
            }
            this.Dg.setImageResource(2130850733);
            localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(20.0F, localContext.getResources()), wja.dp2px(10.0F, localContext.getResources()));
            localLayoutParams.addRule(2, ((View)localObject3).getId());
            localLayoutParams.addRule(9);
            localLayoutParams.leftMargin = (m / 2 + i - wja.dp2px(20.0F, localContext.getResources()) / 2);
            localLayoutParams.bottomMargin = 5;
            ((RelativeLayout)localObject1).addView(this.Dg, localLayoutParams);
            this.mTipsTextView = new TextView(localContext);
            this.mTipsTextView.setText(this.jdField_a_of_type_Axql.bZc);
            k = wja.dp2px(5.0F, localContext.getResources());
            n = wja.dp2px(5.0F, localContext.getResources());
            if (!this.jdField_a_of_type_Axql.czY) {
              break label1018;
            }
            this.mTipsTextView.setTextColor(Color.parseColor("#FBD49D"));
            this.mTipsTextView.setBackgroundResource(2130850735);
            this.mTipsTextView.setPadding(wja.dp2px(30.0F, localContext.getResources()), k, n, k);
            this.mTipsTextView.setTextSize(1, 16.0F);
            this.mTipsTextView.setGravity(17);
            this.mTipsTextView.setSingleLine();
            this.mTipsTextView.measure(-2, -2);
            k = this.mTipsTextView.getMeasuredWidth();
            if (!this.jdField_a_of_type_Axql.czY) {
              break label1066;
            }
            k += wja.dp2px(17.0F, localContext.getResources());
          }
        }
      }
    }
    label1066:
    for (;;)
    {
      m = m / 2 + i - k / 2;
      n = i2 - m - k;
      i = 16;
      if ((n >= 16) || (k + 32 >= i2)) {
        break label1085;
      }
      if (n >= 16) {
        break label1079;
      }
      break label1069;
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(2, 2131378277);
      localLayoutParams.addRule(9);
      if (this.jdField_a_of_type_Axql.czY) {
        localLayoutParams.setMargins(wja.dp2px(17.0F, localContext.getResources()) + k, 0, i, 0);
      }
      for (;;)
      {
        ((RelativeLayout)localObject1).addView(this.mTipsTextView, localLayoutParams);
        if (this.jdField_a_of_type_Axql.czY)
        {
          this.Dh = new ImageView(localContext);
          this.Dh.setImageResource(2130850736);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, ((View)localObject3).getId());
          localLayoutParams.addRule(9);
          localLayoutParams.leftMargin = k;
          localLayoutParams.bottomMargin = wja.dp2px(3.0F, localContext.getResources());
          ((RelativeLayout)localObject1).addView(this.Dh, localLayoutParams);
        }
        if ((this.mTipsTextView == null) || (j == 0)) {
          break;
        }
        this.mTipsTextView.setTranslationX(-i1);
        this.Dg.setTranslationX(-i1);
        this.mTipsTextView.setVisibility(0);
        this.Dg.setVisibility(0);
        if (this.Dh == null) {
          break;
        }
        this.Dh.setTranslationX(-i1);
        this.Dh.setVisibility(0);
        break;
        label975:
        i += 1;
        break label35;
        label982:
        j = 0;
        break label238;
        label987:
        View localView = this.mBaseView;
        break label298;
        label996:
        localObject3 = this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView;
        break label311;
        label1005:
        this.Dg.setImageResource(2130850732);
        break label360;
        label1018:
        this.mTipsTextView.setTextColor(-16777216);
        this.mTipsTextView.setBackgroundResource(2130850734);
        this.mTipsTextView.setPadding(n, k, n, k);
        break label561;
        localLayoutParams.setMargins(k, 0, i, 0);
      }
    }
    for (;;)
    {
      label1069:
      k = i2 - i - k;
      break;
      label1079:
      i = n;
    }
    label1085:
    if (m < 16) {}
    for (;;)
    {
      m = i2 - i - k;
      k = i;
      i = m;
      break;
      i = m;
    }
  }
  
  public String getTag()
  {
    return "PtvTemplateProviderView";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dxm = false;
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131561136, this, false);
    }
    addContentView(this.mContentView);
    this.b = ((QQViewPager)findViewById(2131381896));
    this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter = new QIMPtvTemplateViewPagerAdapter(this.mContext, this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a, this.eCJ);
    this.jdField_c_of_type_Ayzs = ((ayzs)axov.a(3));
    this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.lV(new ArrayList());
    this.b.setOnPageChangeListener(this);
    this.b.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.mApp.registObserver(this.jdField_a_of_type_Axrf);
    updateData();
  }
  
  public void onDestroy()
  {
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.adg(null);
    }
    if (this.jdField_c_of_type_Ayzs != null)
    {
      this.jdField_c_of_type_Ayzs.aq("0", 0, "");
      axpa.eGt = 0;
      this.jdField_c_of_type_Ayzs.b(null);
      this.jdField_c_of_type_Ayzs.adH(111);
      this.jdField_c_of_type_Ayzs.adH(113);
      this.jdField_c_of_type_Ayzs.adH(112);
    }
    if (this.mApp != null) {
      this.mApp.unRegistObserver(this.jdField_a_of_type_Axrf);
    }
    super.onDestroy();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(paramInt);
    dLw();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "random tab template onResume");
    }
    if ((axpa.eGs == 0) && (axpa.cVC.equals("0"))) {}
  }
  
  public void onScrollChanged()
  {
    int i = this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.getScrollX();
    if (this.mTipsTextView == null) {
      dLx();
    }
    while (i == 0) {
      return;
    }
    dLw();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_c_of_type_Ayzs != null) {
      this.jdField_c_of_type_Ayzs.eIJ();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    dLx();
  }
  
  public void setGIFMode(boolean paramBoolean)
  {
    this.dtb = paramBoolean;
  }
  
  public void updateData()
  {
    Xe(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMPtvTemplateProviderView
 * JD-Core Version:    0.7.0.1
 */