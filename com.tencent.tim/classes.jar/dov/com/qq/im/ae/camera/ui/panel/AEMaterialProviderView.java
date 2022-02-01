package dov.com.qq.im.ae.camera.ui.panel;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import anho;
import awzq;
import axbq;
import axbr;
import axbu;
import axcg;
import axiy;
import axol;
import axov;
import axrf;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.capture.view.QIMSlidingTabView;
import dov.com.qq.im.capture.view.QIMSlidingTabView.a;
import dov.com.qq.im.capture.view.QIMSlidingTabView.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import rpw;

public class AEMaterialProviderView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, anho, QIMSlidingTabView.a
{
  private List<axbq> Ft = new CopyOnWriteArrayList();
  private axbr jdField_a_of_type_Axbr;
  public axrf a;
  private AEMaterialTabAdapter jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter;
  private QIMSlidingTabView jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
  private QQViewPager b;
  private AEMaterialPanel.a c;
  private boolean dtJ = true;
  private boolean dtK;
  private int dzN = 1;
  private AppInterface mApp = axol.getAppInterface();
  
  public AEMaterialProviderView(Context paramContext, AEMaterialPanel.a parama)
  {
    super(paramContext);
    this.jdField_a_of_type_Axrf = new awzq(this);
    this.c = parama;
    initView();
  }
  
  private boolean apb()
  {
    if ((getContext() instanceof QIMCameraCaptureActivity))
    {
      QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)getContext();
      return (localQIMCameraCaptureActivity != null) && (axcg.ay(localQIMCameraCaptureActivity.getIntent()));
    }
    return false;
  }
  
  private ArrayList<QIMSlidingTabView.b> eH()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.Ft.size())
    {
      axbq localaxbq = (axbq)this.Ft.get(i);
      if (localaxbq == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (-1 == localaxbq.categoryId) {
          this.dzN = i;
        }
        QIMSlidingTabView.b localb = new QIMSlidingTabView.b();
        localb.tabName = localaxbq.categoryName;
        localArrayList.add(localb);
      }
    }
    return localArrayList;
  }
  
  private void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131558567, this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)findViewById(2131380036));
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.b = ((QQViewPager)findViewById(2131381896));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter = new AEMaterialTabAdapter(getContext(), this.c);
    this.jdField_a_of_type_Axbr = ((axbr)axov.a(18));
    this.jdField_a_of_type_Axbr.refresh();
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.lV(new ArrayList());
    this.b.setOnPageChangeListener(this);
    this.b.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter);
    this.mApp.registObserver(this.jdField_a_of_type_Axrf);
    Xe(true);
  }
  
  @TargetApi(9)
  public void TX(int paramInt)
  {
    this.b.setCurrentItem(paramInt);
  }
  
  public void Xe(boolean paramBoolean)
  {
    Object localObject;
    int j;
    int i;
    if (apb())
    {
      localObject = this.jdField_a_of_type_Axbr.hJ();
      this.Ft = new ArrayList((Collection)localObject);
      j = this.dzN;
      i = j;
      if (!paramBoolean)
      {
        i = j;
        if (this.b != null)
        {
          i = j;
          if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter != null)
          {
            if (this.dtJ) {
              break label353;
            }
            i = this.b.getCurrentItem();
            localObject = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.a(i);
            if (localObject == null) {
              break label353;
            }
            i = 0;
            label90:
            if (i >= this.Ft.size()) {
              break label353;
            }
            axbq localaxbq = (axbq)this.Ft.get(i);
            if ((localaxbq == null) || (TextUtils.isEmpty(localaxbq.categoryName)) || (!localaxbq.categoryName.equals(((axbq)localObject).categoryName))) {
              break label346;
            }
          }
        }
      }
    }
    for (;;)
    {
      this.dtJ = false;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter != null)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.lV(this.Ft);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.notifyDataSetChanged();
      }
      if (this.b != null) {
        this.b.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.eL(eH());
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
      }
      j = i;
      if (i >= this.Ft.size())
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("AEMaterialProviderView", 2, "resetPos " + i + " not exist, mTabList size = " + this.Ft.size());
          j = 0;
        }
      }
      if ((!this.dtK) && (this.Ft.size() > 0) && (this.b != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)) {
        adG(j);
      }
      return;
      localObject = this.jdField_a_of_type_Axbr.x(paramBoolean);
      break;
      label346:
      i += 1;
      break label90;
      label353:
      i = j;
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 114) && (paramVarArgs != null) && (paramVarArgs.length != 1)) {}
  }
  
  public void adG(int paramInt)
  {
    if ((this.b != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null))
    {
      axiy.i("AEMaterialProviderView", "locatePage: " + paramInt);
      this.b.setCurrentItem(paramInt);
    }
  }
  
  public void ae(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("selectCategoryAndItem");
      ((StringBuilder)localObject).append(", categoryName=").append(paramString1);
      ((StringBuilder)localObject).append(", itemId=").append(paramString2);
      ((StringBuilder)localObject).append(", mTabListSize=").append(this.Ft.size());
      QLog.d("AEMaterialProviderView", 2, ((StringBuilder)localObject).toString());
    }
    if (this.Ft.isEmpty()) {
      Xe(true);
    }
    int i = 0;
    int j;
    if (i < this.Ft.size()) {
      if ((paramString1 != null) && (paramString1.equals(((axbq)this.Ft.get(i)).categoryName)))
      {
        paramString1 = (axbq)this.Ft.get(i);
        j = i;
      }
    }
    for (;;)
    {
      if (paramString1 == null)
      {
        return;
        i += 1;
        break;
      }
      i = 0;
      label175:
      if (i < paramString1.Mm.size())
      {
        localObject = (axbu)paramString1.Mm.get(i);
        if (!((axbu)localObject).id.equals(paramString2)) {}
      }
      for (paramString1 = (String)localObject;; paramString1 = null)
      {
        ThreadManager.getUIHandler().post(new AEMaterialProviderView.2(this, j));
        if (QLog.isColorLevel()) {
          QLog.d("AEMaterialProviderView", 2, "itemInfo= " + paramString1 + ",index=" + j + ",pos=" + i);
        }
        if (paramString1 == null) {
          break;
        }
        this.dtK = true;
        if (paramString1.isWsBanner())
        {
          rpw.a(getContext(), paramString1);
          return;
          i += 1;
          break label175;
        }
        postDelayed(new AEMaterialProviderView.3(this, j, paramString1), 200L);
        return;
        i = 0;
      }
      j = 0;
      paramString1 = null;
    }
  }
  
  public String getTag()
  {
    return "AEMaterialProviderView";
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Axbr != null)
    {
      this.jdField_a_of_type_Axbr.c(null, false);
      this.jdField_a_of_type_Axbr.adH(111);
      this.jdField_a_of_type_Axbr.adH(113);
      this.jdField_a_of_type_Axbr.adH(112);
    }
    if (this.mApp != null) {
      this.mApp.unRegistObserver(this.jdField_a_of_type_Axrf);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(paramInt);
  }
  
  public void onScrollChanged() {}
  
  public void onStop()
  {
    if (this.jdField_a_of_type_Axbr != null)
    {
      if (((getContext() instanceof Activity)) && (axcg.ay(((Activity)getContext()).getIntent()))) {
        this.jdField_a_of_type_Axbr.eIK();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Axbr.eIJ();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView
 * JD-Core Version:    0.7.0.1
 */