package dov.com.qq.im.aeeditor;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RelativeLayout;
import awtj;
import axcg;
import axip;
import axiz;
import axjg;
import axji;
import axmr;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.tavcut.TAVCut;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class AEEditorActivity
  extends PeakFragmentActivity
{
  private static final String TAG = AEEditorActivity.class.getSimpleName();
  private List<a> MK = new ArrayList();
  private List<String> ML = new ArrayList();
  private List<String> MM = new ArrayList();
  private axji a;
  private boolean baw;
  
  private void cf(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.MK.add(new a(paramInt));
    }
  }
  
  private void eLF()
  {
    if (!awtj.init()) {
      this.MK.add(new a(-1));
    }
    for (;;)
    {
      TAVCut.initTAVCut(getApplicationContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new axjg(this));
      return;
      cf(FeatureManager.Features.YT_COMMON.init(), -2);
      cf(FeatureManager.Features.PTU_TOOLS.init(), -3);
      cf(FeatureManager.Features.PTU_ALGO.init(), -4);
      cf(AIManager.installDetector(PTFaceDetector.class), -2);
      cf(FeatureManager.Features.PAG.init(), -6);
      cf(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
  }
  
  private void eLG()
  {
    if (this.MK.size() > 0) {}
  }
  
  private void eLH()
  {
    Bundle localBundle = new Bundle();
    if (getIntent().getExtras() != null) {
      localBundle = getIntent().getExtras();
    }
    this.a = new axji(getSupportFragmentManager());
    this.a.cL(localBundle);
  }
  
  private void lW()
  {
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("editorType", -1);
    int j = localIntent.getIntExtra("editorFrom", -1);
    if ((j == axcg.x.getId()) || (j == axcg.z.getId())) {
      if (i == 0) {
        axip.a().a().aCe = axip.aq.longValue();
      }
    }
    for (;;)
    {
      axip.a().a().cUU = axip.a().HP();
      return;
      if (i == 1)
      {
        axip.a().a().aCe = axip.ar.longValue();
      }
      else
      {
        axip.a().a().aCe = axip.ap.longValue();
        continue;
        if ((j == axcg.y.getId()) || (j == axcg.A.getId()))
        {
          if (i == 0) {
            axip.a().a().aCe = axip.as.longValue();
          } else if (i == 1) {
            axip.a().a().aCe = axip.at.longValue();
          } else {
            axip.a().a().aCe = axip.ap.longValue();
          }
        }
        else {
          axip.a().a().aCe = axip.ap.longValue();
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.a != null) {
      this.a.m(this, true);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    axiz.eLD();
    this.baw = axiz.aOK();
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    setImmersiveStatus(getResources().getColor(2131165242));
    super.doOnCreate(paramBundle);
    setContentView(2131558601);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramBundle = (RelativeLayout)findViewById(2131377546);
      int i = getStatusBarHeight();
      paramBundle.setPadding(paramBundle.getPaddingLeft(), i + paramBundle.getPaddingTop(), paramBundle.getPaddingRight(), paramBundle.getPaddingBottom());
    }
    if (ImmersiveUtils.aJW()) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
    eLF();
    eLG();
    axmr.a().eMS();
    eLH();
    lW();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public class a
  {
    private int errorCode;
    
    public a(int paramInt)
    {
      this.errorCode = paramInt;
    }
    
    public String toString()
    {
      switch (this.errorCode)
      {
      default: 
        return "未知错误";
      case 0: 
        return "初始化成功";
      case -1: 
        return "初始化AEKit失败";
      case -2: 
        return "加载YTCommon失败";
      case -3: 
        return "加载PtuTools失败";
      case -4: 
        return "加载PtuAlgo失败";
      case -5: 
        return "加载人脸检测失败";
      case -6: 
        return "加载PAG失败";
      case -7: 
        return "加载ImageAlgo失败";
      }
      return "初始化TAVCut失败";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.AEEditorActivity
 * JD-Core Version:    0.7.0.1
 */