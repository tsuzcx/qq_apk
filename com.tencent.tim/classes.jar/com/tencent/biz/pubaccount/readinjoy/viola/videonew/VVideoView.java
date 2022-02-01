package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;
import java.util.Map;
import kbp;
import nwn;
import nwp;
import nws;
import nxa;
import org.json.JSONObject;

public class VVideoView
  extends FrameLayout
  implements IVView<VVideo>
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$b;
  private VVideo b;
  private int bcM;
  private ViewGroup.LayoutParams g;
  public int mComponentType = 1;
  private int mOrientation = 1;
  private WeakReference<VVideo> mWeakReference;
  
  public VVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VVideoView(@NonNull Context paramContext, VVideo paramVVideo)
  {
    super(paramContext);
    this.b = paramVVideo;
    setTag("VVideoView");
  }
  
  public VVideo a()
  {
    if (this.mWeakReference != null) {
      return (VVideo)this.mWeakReference.get();
    }
    return null;
  }
  
  public b a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$b;
  }
  
  public void a(VVideo paramVVideo)
  {
    this.mWeakReference = new WeakReference(paramVVideo);
  }
  
  public void aTP()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$a.f(this);
    }
  }
  
  public void aTQ()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$a.g(this);
    }
  }
  
  public void bbI()
  {
    if ((this.b != null) && (this.b.getInstance() != null) && (!TextUtils.isEmpty(this.b.getInstance().getUrl())) && (this.b.getInstance().getUrl().contains("VideoFeeds.js")) && (TextUtils.isEmpty(this.b.getInstance().getMasterVideoRef())))
    {
      kbp.a(null, null, "0X800AF0F", "0X800AF0F", 0, 0, null, null, null, "" + System.currentTimeMillis(), false);
      this.b.getInstance().setMasterVideoRef(this.b.getRef());
    }
  }
  
  public void dt(int paramInt1, int paramInt2)
  {
    if (a().getInstance().getActivity() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VVideoView", 2, "initView: playerType=" + paramInt1 + ", sceneType=" + paramInt2);
      }
      if (paramInt1 != 1) {
        break label154;
      }
      localObject1 = new nwp(a().getInstance().getActivity(), this, paramInt2, a().getInstance());
      setVideoViewControlListener((a)localObject1);
      localObject2 = (BaseModule)ViolaModuleManager.findModuleMapById(a().getInstance().getInstanceId()).get(BridgeModule.MODULE_NAME);
      if ((localObject2 instanceof BridgeModule))
      {
        localObject2 = ((BridgeModule)localObject2).getField("predownload");
        if ((localObject2 instanceof VideoPreDownloadMgr)) {
          ((nwp)localObject1).d((VideoPreDownloadMgr)localObject2);
        }
      }
    }
    return;
    label154:
    if (this.mComponentType == 1)
    {
      localObject1 = new ViolaVideoView(a().getInstance().getActivity());
      setVideoViewControlListener(new nws(a().getInstance().getActivity(), (nwn)localObject1, this, a().getInstance()));
      addView((View)localObject1, -1, -1);
      return;
    }
    Object localObject1 = new ViolaVideoView(a().getInstance().getActivity());
    Object localObject2 = new nxa(a().getInstance().getActivity(), (nwn)localObject1, this, a().getInstance());
    setVideoViewControlListener((a)localObject2);
    setVideoViewLifeCycleChangeListener((b)localObject2);
    addView((View)localObject1, -1, -1);
  }
  
  public a getVideoViewControlListener()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$a;
  }
  
  public void k(String paramString, Object paramObject)
  {
    this.b.videoFireEvent(paramString, paramObject);
  }
  
  public int qZ()
  {
    return this.mOrientation;
  }
  
  public void sP(int paramInt)
  {
    this.mOrientation = paramInt;
    this.g = getLayoutParams();
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if ((a() != null) && (a().getInstance() != null) && (a().getInstance().getActivity() != null))
    {
      localObject = a().getInstance().getActivity();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getWindow();
        if ((getParent() instanceof ViewGroup))
        {
          this.bcM = ((ViewGroup)getParent()).indexOfChild(this);
          aTP();
          ((ViewGroup)getParent()).removeView(this);
          aTQ();
        }
        localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        if ((a() == null) || (a().getInstance() == null) || (a().getInstance().getFragment() == null) || (!((ViolaFragment)a().getInstance().getFragment()).Gh())) {
          break label188;
        }
        ((ViolaFragment)a().getInstance().getFragment()).a().addView(this, localLayoutParams);
      }
    }
    return;
    label188:
    ((Window)localObject).addContentView(this, localLayoutParams);
  }
  
  public void setVideoViewControlListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$a = parama;
  }
  
  public void setVideoViewLifeCycleChangeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$b = paramb;
  }
  
  public void un(int paramInt)
  {
    this.mOrientation = paramInt;
    if ((a() != null) && (a().getParent() != null) && (a().getParent().getHostView() != null))
    {
      if ((getParent() != null) && ((getParent() instanceof ViewGroup)))
      {
        aTP();
        ((ViewGroup)getParent()).removeView(this);
        aTQ();
      }
      ((ViewGroup)a().getParent().getHostView()).addView(this, this.bcM, this.g);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener);
    
    public abstract void a(VVideoView paramVVideoView);
    
    public abstract void a(VVideoView paramVVideoView, int paramInt);
    
    public abstract void a(VVideoView paramVVideoView, String paramString);
    
    public abstract void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener);
    
    public abstract void a(VVideoView paramVVideoView, JSONObject paramJSONObject);
    
    public abstract void a(VVideoView paramVVideoView, boolean paramBoolean);
    
    public abstract void b(VVideoView paramVVideoView);
    
    public abstract void b(VVideoView paramVVideoView, int paramInt);
    
    public abstract void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener);
    
    public abstract void b(VVideoView paramVVideoView, JSONObject paramJSONObject);
    
    public abstract void b(VVideoView paramVVideoView, boolean paramBoolean);
    
    public abstract void c(VVideoView paramVVideoView);
    
    public abstract void c(VVideoView paramVVideoView, int paramInt);
    
    public abstract void c(VVideoView paramVVideoView, boolean paramBoolean);
    
    public abstract void d(VVideoView paramVVideoView);
    
    public abstract void e(VVideoView paramVVideoView);
    
    public abstract void f(VVideoView paramVVideoView);
    
    public abstract void g(VVideoView paramVVideoView);
    
    public abstract boolean isFullScreen();
    
    public abstract void onActivityCreate();
    
    public abstract void onActivityDestroy();
    
    public abstract void onActivityPause();
    
    public abstract void onActivityResume();
    
    public abstract void onActivityStart();
    
    public abstract void onActivityStop();
    
    public abstract void setAccurate(boolean paramBoolean);
    
    public abstract void setEndWithLastFrame(boolean paramBoolean);
    
    public abstract void setLoopBack(boolean paramBoolean);
    
    public abstract void setRate(float paramFloat);
    
    public abstract void setStartPosition(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void bbJ();
    
    public abstract void bbK();
    
    public abstract void bbL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView
 * JD-Core Version:    0.7.0.1
 */