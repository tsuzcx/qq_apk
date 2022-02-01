package dov.com.qq.im.aeeditor.module.edit;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import aqgw;
import aqha;
import aqju;
import axis;
import axiy;
import axji;
import axkn;
import axkp;
import axks;
import axll;
import axlm;
import axln;
import axlo;
import axlp;
import axlq;
import axmr;
import axmw;
import axnw;
import axnw.a;
import axzu;
import axzv;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tavcut.TavCutVersion;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIVideoLoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorComicLoadingView;
import dov.com.qq.im.aeeditor.module.controlpanel.AEEditorControlPanelContainer;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.a;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar.a;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar.a;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public abstract class AEEditorCommonEditFragment
  extends AEEditorBaseFragment
  implements Handler.Callback, AEEditorTopBar.a
{
  private static final String TAG = AEEditorCommonEditFragment.class.getSimpleName();
  protected axll a;
  public axnw a;
  public AEEditorAILoadingView a;
  protected AEEditorControlPanelContainer a;
  public AEEditorFilterControlPanel a;
  public AEEditorToolBar a;
  public AEEditorTopBar a;
  protected TextView ahn;
  private axzv<List<AEEditorFilterBean>> b;
  protected FrameLayout cD;
  protected String cVo;
  public Context context;
  protected boolean dvj;
  public aqgw e;
  
  private void eMt()
  {
    if (AEEditorAILoadingView.aON()) {
      return;
    }
    ThreadManager.excute(new AEEditorCommonEditFragment.8(this), 128, null, true);
  }
  
  private void jq(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131380001));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(HV());
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(this);
  }
  
  private void jr(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar = ((AEEditorToolBar)paramView.findViewById(2131379990));
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.setToolBarListener(a());
  }
  
  private void js(View paramView)
  {
    this.cD = ((FrameLayout)paramView.findViewById(2131367155));
  }
  
  private void jt(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer = ((AEEditorControlPanelContainer)paramView.findViewById(2131365424));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer.a(a());
    boolean bool = aOU();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.tb(bool);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.Yz(aOT());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.select(Rd());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.Nq(0);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFilterControlListener(a());
    this.ahn = ((TextView)paramView.findViewById(2131367096));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.V(this.ahn);
    this.b = new axlo(this, bool);
    axmr.a().s().a(this.b);
  }
  
  private void ju(View paramView)
  {
    this.jdField_a_of_type_Axnw = new axnw();
    this.jdField_a_of_type_Axnw.a(a());
  }
  
  private void jv(View paramView)
  {
    jQ("TAVCut版本", TavCutVersion.getVersion());
  }
  
  protected abstract String HV();
  
  protected abstract int Rd();
  
  protected abstract axmw a();
  
  protected abstract axnw.a a();
  
  protected abstract AEEditorFilterControlPanel.a a();
  
  protected abstract AEEditorToolBar.a a();
  
  public ArrayList<String> a(axkn paramaxkn)
  {
    getResources().getString(2131719045);
    Object localObject = getResources().getString(2131719046);
    String str = getResources().getString(2131719046);
    if ((paramaxkn instanceof axkp))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689947), "", "");
      return null;
    }
    if (paramaxkn != null)
    {
      if (!TextUtils.isEmpty(paramaxkn.getSceneLabel())) {
        paramaxkn.getSceneLabel();
      }
      if ((paramaxkn instanceof axks))
      {
        List localList = ((axks)paramaxkn).MT;
        if (localList != null) {
          if ((localList.size() > 0) && (localList.get(0) != null))
          {
            paramaxkn = ((YoutuResultItem)localList.get(0)).Label;
            if ((localList.size() > 1) && (localList.get(1) != null)) {
              str = ((YoutuResultItem)localList.get(1)).Label;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramaxkn);
      ((ArrayList)localObject).add(str);
      return localObject;
      continue;
      paramaxkn = (axkn)localObject;
      break;
      paramaxkn = (axkn)localObject;
    }
  }
  
  protected void a(axkn paramaxkn)
  {
    String str1 = getResources().getString(2131719045);
    Object localObject1 = getResources().getString(2131719046);
    String str2 = getResources().getString(2131719046);
    if ((paramaxkn instanceof axkp)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689947), "", "");
    }
    label201:
    for (;;)
    {
      return;
      Object localObject2;
      if (paramaxkn != null) {
        if (!TextUtils.isEmpty(paramaxkn.getSceneLabel()))
        {
          str1 = paramaxkn.getSceneLabel();
          localObject2 = localObject1;
          if ((paramaxkn instanceof axks))
          {
            List localList = ((axks)paramaxkn).MT;
            localObject2 = localObject1;
            if (localList != null)
            {
              paramaxkn = (axkn)localObject1;
              if (localList.size() > 0) {
                paramaxkn = ((YoutuResultItem)localList.get(0)).Label;
              }
              localObject2 = paramaxkn;
              if (localList.size() > 1)
              {
                localObject2 = ((YoutuResultItem)localList.get(1)).Label;
                localObject1 = paramaxkn;
                paramaxkn = (axkn)localObject2;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView == null) {
          break label201;
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(str1, (String)localObject1, paramaxkn);
        return;
        paramaxkn = str2;
        localObject1 = localObject2;
        continue;
        break;
        paramaxkn = str2;
      }
    }
  }
  
  public void aO(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_Axll != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.5(this, paramVarArgs));
    }
  }
  
  public boolean aOM()
  {
    Object localObject = getActivity();
    localObject = aqha.a((Context)localObject, 230).setTitle(acfp.m(2131689965)).setMessage(((Context)localObject).getString(2131689966)).setPositiveButton(((Context)localObject).getString(2131689965), new axlq(this)).setNegativeButton(((Context)localObject).getString(2131689950), new axlp(this));
    if (localObject != null) {}
    try
    {
      if (!((aqju)localObject).isShowing()) {
        ((aqju)localObject).show();
      }
      label83:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label83;
    }
  }
  
  protected abstract boolean aOT();
  
  protected boolean aOU()
  {
    return false;
  }
  
  protected boolean aOu()
  {
    return axis.a().c("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", true, 0);
  }
  
  protected abstract void applyCurrentSticker();
  
  public void eMh()
  {
    a().m(getActivity(), true);
  }
  
  public void eMi()
  {
    eMs();
    eMo();
  }
  
  protected abstract void eMl();
  
  public abstract void eMm();
  
  public abstract void eMn();
  
  protected abstract void eMo();
  
  protected void eMp()
  {
    if (this.cD == null) {
      return;
    }
    this.cD.removeAllViews();
    if ((this instanceof AEEditorVideoEditFragment)) {}
    for (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAIVideoLoadingView(getActivity());; this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAILoadingView(getActivity()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new axlm(this));
      this.cD.addView(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView);
      return;
    }
  }
  
  protected void eMq()
  {
    if (this.cD == null) {
      return;
    }
    this.cD.removeAllViews();
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorComicLoadingView(getActivity());
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new axln(this));
    this.cD.addView(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView);
  }
  
  public abstract void eMr();
  
  protected void eMs()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.cancelLoading();
    }
    eMm();
  }
  
  protected void eMu()
  {
    axis.a().n("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", false, 0);
  }
  
  protected abstract int getLayoutResourceId();
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      axiy.d(TAG, "sendMessage");
      applyCurrentSticker();
    }
  }
  
  public void jQ(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Axll != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.4(this, paramString1, paramString2));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    axiy.i(TAG, "onCreate");
    super.onCreate(paramBundle);
    this.context = getActivity();
    eMt();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    axiy.i(TAG, "onCreateView");
    eMl();
    this.e = new aqgw(Looper.getMainLooper(), this);
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutResourceId(), paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    axiy.i(TAG, "onDestroyView");
    super.onDestroyView();
    axmr.a().s().b(this.b);
    this.e.removeMessages(0);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onPause()
  {
    axiy.i(TAG, "onPause");
    super.onPause();
    eMs();
    this.dvj = true;
  }
  
  public void onResume()
  {
    axiy.i(TAG, "onResume");
    super.onResume();
    this.dvj = false;
    if (this.jdField_a_of_type_Axnw != null) {
      this.jdField_a_of_type_Axnw.onResume();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    axiy.i(TAG, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    this.cVo = getArguments().getString("editor_filter_id");
    if (!TextUtils.isEmpty(this.cVo))
    {
      axiy.i(TAG, "jump from scheme, filterID=" + this.cVo);
      getArguments().putString("editor_filter_id", "");
    }
    jv(paramView);
    jq(paramView);
    jr(paramView);
    js(paramView);
    jt(paramView);
    ju(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment
 * JD-Core Version:    0.7.0.1
 */