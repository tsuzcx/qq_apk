package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import axol;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.b;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import rpq;

public abstract class ProviderView
  extends FrameLayout
{
  private QIMSlidingTabView a;
  protected DoodleLayout.b a;
  private QIMSlidingTabView b;
  public int busType = 2;
  public a c;
  protected QIMSlidingTabView c;
  protected boolean cBk = true;
  protected int dzM;
  public int eCJ = 0;
  protected AppInterface mApp;
  protected View mBaseView;
  protected int mContentHeight = 206;
  protected ViewGroup mContentLayout;
  protected View mContentView;
  public Context mContext;
  public boolean mInited;
  protected Handler mThreadHandler;
  protected RelativeLayout oa;
  private RelativeLayout ob;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mThreadHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  protected Bundle D()
  {
    return null;
  }
  
  protected abstract int QW();
  
  public void TZ(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public QIMSlidingTabView a()
  {
    return this.b;
  }
  
  public boolean aOc()
  {
    return false;
  }
  
  public void addContentView(View paramView)
  {
    if (this.mContentLayout == null) {
      throw new IllegalStateException("no content layout");
    }
    this.mContentLayout.addView(paramView);
  }
  
  public void apk() {}
  
  public void aq(int paramInt, String paramString1, String paramString2) {}
  
  public boolean au(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean ava()
  {
    return this.cBk;
  }
  
  public void dKI()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "[cc]onProviderShow " + getClass().getSimpleName());
    }
    if ((this.oa != null) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView == this.b) && (this.b.getVisibility() != 0)) {
      this.b.setVisibility(0);
    }
  }
  
  public void dLs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "[cc]onProviderDismiss " + getClass().getSimpleName());
    }
    if ((this.oa != null) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView == this.b) && (this.b.getVisibility() == 0)) {
      this.b.setVisibility(8);
    }
  }
  
  protected void ePc()
  {
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.eNr();
    }
  }
  
  public void ePd()
  {
    this.ob = this.oa;
    this.oa = null;
    if ((this.ob != null) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView == this.b) && (this.b.getVisibility() == 0)) {
      this.b.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "[cc]dismissBottomTab " + getClass().getSimpleName());
    }
  }
  
  public void ePe()
  {
    if ((this.ob != null) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView == this.b) && (this.b.getVisibility() != 0)) {
      this.b.setVisibility(0);
    }
    this.oa = this.ob;
    this.ob = null;
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "[cc]showBottomTab " + getClass().getSimpleName());
    }
  }
  
  public void ex(Bundle paramBundle)
  {
    if (this.mContentView == null) {
      try
      {
        paramBundle = LayoutInflater.from(getContext()).inflate(2131561096, this, false);
        addView(paramBundle);
        if (this.mBaseView == null)
        {
          this.mBaseView = paramBundle;
          this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)this.mBaseView.findViewById(2131373722));
          if (this.oa == null) {
            break label143;
          }
          this.b = ((QIMSlidingTabView)LayoutInflater.from(getContext()).inflate(2131561097, this.oa, false));
          this.oa.addView(this.b);
        }
        for (;;)
        {
          this.mContentLayout = ((ViewGroup)this.mBaseView.findViewById(2131373719));
          paramBundle = LayoutInflater.from(getContext()).inflate(QW(), this, false);
          if (this.mContentView != null) {
            break;
          }
          this.mContentView = paramBundle;
          return;
          label143:
          this.b = ((QIMSlidingTabView)this.mBaseView.findViewById(2131373717));
        }
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ProviderView", 2, "preInflate failed " + paramBundle.toString());
        }
      }
    }
  }
  
  public int getContentHeight()
  {
    return this.mContentHeight;
  }
  
  public boolean isInit()
  {
    return this.mInited;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle)
  {
    this.mApp = axol.getAppInterface();
    if (this.mBaseView == null)
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2131561096, this, false);
      addView(paramBundle);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)paramBundle.findViewById(2131373722));
      if (this.oa != null)
      {
        this.b = ((QIMSlidingTabView)LayoutInflater.from(getContext()).inflate(2131561097, this.oa, false));
        this.oa.addView(this.b);
        this.mContentLayout = ((ViewGroup)paramBundle.findViewById(2131373719));
      }
    }
    else
    {
      paramBundle = this.mContentLayout.getLayoutParams();
      paramBundle.height = rpq.dip2px(getContext(), this.mContentHeight);
      this.mContentLayout.setLayoutParams(paramBundle);
      if (this.dzM != 1) {
        break label221;
      }
      paramBundle = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
      label147:
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView = paramBundle;
      if (this.cBk)
      {
        this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setVisibility(0);
        if (this.dzM != 1) {
          break label229;
        }
        findViewById(2131373723).setVisibility(0);
      }
    }
    for (;;)
    {
      this.mInited = true;
      if (QLog.isColorLevel()) {
        QLog.i("ProviderView", 2, "oncreate");
      }
      return;
      this.b = ((QIMSlidingTabView)paramBundle.findViewById(2131373717));
      break;
      label221:
      paramBundle = this.b;
      break label147;
      label229:
      if (this.dzM != 2) {}
    }
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
  
  public void onResume() {}
  
  public void onStop() {}
  
  public void setCaptureScene(int paramInt)
  {
    this.eCJ = paramInt;
  }
  
  public void setDoodleEventListener(DoodleLayout.b paramb)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b = paramb;
  }
  
  public void setLiuHaiParentView(RelativeLayout paramRelativeLayout)
  {
    this.oa = paramRelativeLayout;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.cBk = paramBoolean;
  }
  
  public void setProviderViewListener(a parama)
  {
    this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a = parama;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.dzM = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void O(int paramInt, Object paramObject);
    
    public abstract void YI(boolean paramBoolean);
    
    public abstract void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString);
    
    public abstract void adg(String paramString);
    
    public abstract void aev(int paramInt);
    
    public abstract void aew(int paramInt);
    
    public abstract void aex(int paramInt);
    
    public abstract void aey(int paramInt);
    
    public abstract void b(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem);
    
    public abstract void eNr();
    
    public abstract void eNs();
    
    public abstract void eNu();
    
    public abstract int getVideoDuration();
    
    public abstract void onMusicOriginalChange(boolean paramBoolean);
    
    public abstract void r(int paramInt, Object... paramVarArgs);
    
    public abstract void uZ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */