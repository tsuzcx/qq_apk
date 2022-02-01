import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.5;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView.a;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView.b;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView.c;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class awxv
  extends axgh
  implements anho, AEBottomListScrollView.a, AEBottomListScrollView.b<awxq.b>, AEBottomListScrollView.c<awxq.b>
{
  private awxq jdField_a_of_type_Awxq;
  private axgg jdField_a_of_type_Axgg;
  private axbr jdField_b_of_type_Axbr;
  private axgf jdField_b_of_type_Axgf;
  private awtq jdField_c_of_type_Awtq;
  private awwk jdField_c_of_type_Awwk;
  private AEBottomListScrollView jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private AECaptureMode jdField_c_of_type_DovComQqImAeModeAECaptureMode;
  private int eDN;
  
  public awxv(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
    this.jdField_c_of_type_Awtq = ((awtq)paramaxgi.a(65537, new Object[0]));
    this.jdField_c_of_type_Awwk = this.jdField_c_of_type_Awtq.a();
  }
  
  private boolean a(axbu paramaxbu)
  {
    if (paramaxbu != null) {
      return paramaxbu.isWsBanner();
    }
    return false;
  }
  
  private boolean aOh()
  {
    Boolean localBoolean;
    if ((this.jdField_a_of_type_Axgg != null) && (this.jdField_a_of_type_Axgg.p() != null))
    {
      localBoolean = (Boolean)this.jdField_a_of_type_Axgg.p().getValue();
      if (localBoolean == null) {}
    }
    for (boolean bool = localBoolean.booleanValue();; bool = true) {
      return (!aOi()) && (this.jdField_b_of_type_Axgf.bz()) && (bool);
    }
  }
  
  private boolean aOi()
  {
    return ((this.mActivity != null) && ((axcg.av(this.mActivity.getIntent())) || (axcg.aw(this.mActivity.getIntent())) || (axcg.ax(this.mActivity.getIntent())))) || (axcg.ay(this.mActivity.getIntent()));
  }
  
  private void ady(int paramInt)
  {
    this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Awxq.a(paramInt));
    this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  private axbu b(int paramInt)
  {
    if (this.jdField_a_of_type_Awxq != null) {
      return this.jdField_a_of_type_Awxq.a(paramInt);
    }
    return null;
  }
  
  private void biN()
  {
    this.jdField_b_of_type_Axgf = ((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class));
    this.jdField_b_of_type_Axgf.t.a(this.jdField_c_of_type_Awtq, new awyc(this));
    this.jdField_a_of_type_Axgg = ((axgg)awuh.a(this.jdField_c_of_type_Awtq).b(axgg.class));
    this.jdField_a_of_type_Axgg.p().a(this.jdField_c_of_type_Awtq, new awyd(this));
  }
  
  private void eHA()
  {
    long l3 = 0L;
    long l1;
    if (QLog.isDevelopLevel())
    {
      l1 = System.currentTimeMillis();
      QLog.d("AEWaterMarkListPart", 4, "dataNotify begin");
    }
    for (;;)
    {
      this.jdField_b_of_type_Axbr.aGs();
      long l2;
      if (QLog.isDevelopLevel())
      {
        l2 = System.currentTimeMillis();
        QLog.d("AEWaterMarkListPart", 4, "dataNotify forceInit done cost=" + (l2 - l1));
      }
      for (;;)
      {
        long l4;
        if (QLog.isDevelopLevel())
        {
          l4 = System.currentTimeMillis();
          QLog.d("AEWaterMarkListPart", 4, "dataNotify getTemplateInfos done cost=" + (l4 - l2));
        }
        for (l2 = l4;; l2 = 0L)
        {
          Object localObject = this.jdField_b_of_type_Axbr.hL();
          if (QLog.isDevelopLevel())
          {
            l4 = System.currentTimeMillis();
            QLog.d("AEWaterMarkListPart", 4, "found hot category cost=" + (l4 - l2));
          }
          for (l2 = l4;; l2 = 0L)
          {
            if (((List)localObject).isEmpty())
            {
              ThreadManager.getUIHandler().post(new AEBottomListPart.7(this, l1));
              return;
            }
            ArrayList localArrayList = new ArrayList();
            localObject = ((List)localObject).iterator();
            int i = 0;
            while (((Iterator)localObject).hasNext())
            {
              axbu localaxbu = (axbu)((Iterator)localObject).next();
              if (((!localaxbu.id.contains("_3DFaceFila")) || (FilamentInitializer.supportFilament())) && ((!localaxbu.id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
              {
                if (i >= 10) {
                  break;
                }
                localArrayList.add(localaxbu);
                i += 1;
              }
            }
            l1 = l3;
            if (QLog.isDevelopLevel())
            {
              l1 = System.currentTimeMillis();
              QLog.d("AEWaterMarkListPart", 4, "filterFilament cost=" + (l1 - l2));
            }
            ThreadManager.getUIHandler().post(new AEBottomListPart.8(this, localArrayList, l1));
            return;
          }
        }
        l2 = 0L;
      }
      l1 = 0L;
    }
  }
  
  @TargetApi(12)
  private void eHB()
  {
    int i = rpq.dip2px(this.mActivity, this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    ((AnimatorSet)localObject).addListener(new awyg(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = axwc.a(this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new awxx(this));
    this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void eHC()
  {
    if (this.jdField_b_of_type_Axgf.aOx())
    {
      if (this.jdField_c_of_type_Axgi != null)
      {
        this.jdField_c_of_type_Axgi.p(327683, new Object[0]);
        this.jdField_c_of_type_Axgi.p(196612, new Object[0]);
      }
      this.jdField_c_of_type_Awtq.a().by(true, 150);
      return;
    }
    int i = rpq.dip2px(this.mActivity, this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new awxy(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = axwc.a(this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new awxz(this));
    this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void eHD()
  {
    if (this.jdField_b_of_type_Axgf.aOx())
    {
      if (this.jdField_c_of_type_Axgi != null)
      {
        this.jdField_c_of_type_Axgi.p(327684, new Object[0]);
        this.jdField_c_of_type_Axgi.p(196612, new Object[0]);
      }
      this.jdField_c_of_type_Awtq.a().by(true, 150);
      return;
    }
    int i = rpq.dip2px(this.mActivity, this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new awya(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = axwc.a(this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new awyb(this));
    this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void eHE()
  {
    int j = 0;
    axbu localaxbu1 = axbr.b();
    if (localaxbu1 != null)
    {
      axbu localaxbu2 = this.jdField_a_of_type_Awxq.a(this.eDN);
      int i = j;
      if (localaxbu2 != null)
      {
        i = j;
        if (localaxbu1.id.equals(localaxbu2.id))
        {
          ady(this.eDN);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Awxq.getItemCount()) {
          break;
        }
        localaxbu2 = this.jdField_a_of_type_Awxq.a(i);
      } while ((localaxbu2 == null) || (!localaxbu1.id.equals(localaxbu2.id)));
      ady(i);
      return;
    }
    ady(0);
    return;
    ady(this.eDN);
  }
  
  private void eHx()
  {
    this.jdField_a_of_type_Awxq.eHu();
    axip.a().eLx();
    axim.a().reportLaunch();
  }
  
  private void eHy()
  {
    if (!aOh()) {
      return;
    }
    spf.b(new View[] { this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new awye(this)).b();
  }
  
  private void eHz()
  {
    QLog.d("AEWaterMarkListPart", 4, "getDateFromPtv: ");
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.5(this));
    axbk.e().a(this.jdField_c_of_type_Awtq, new awyf(this));
  }
  
  private int gl(String paramString)
  {
    int j;
    if (paramString == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_Awxq.getItemCount()) {
        break label57;
      }
      axbu localaxbu = this.jdField_a_of_type_Awxq.a(i);
      if (localaxbu != null)
      {
        j = i;
        if (paramString.equals(localaxbu.id)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  private void h(axbu paramaxbu)
  {
    if ((paramaxbu != null) && (!paramaxbu.equals(axbu.i)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Awxq.getItemCount()) || (this.jdField_a_of_type_Awxq.a(i) == null)) {
        break label103;
      }
      if (!paramaxbu.id.equals(this.jdField_a_of_type_Awxq.a(i).id)) {
        break label96;
      }
      this.jdField_a_of_type_Awxq.a(i).x(paramaxbu);
      ady(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Awxq.c(paramaxbu);
        ady(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  public axbr a()
  {
    return this.jdField_b_of_type_Axbr;
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable awxq.b paramb1, @Nullable awxq.b paramb2) {}
  
  public void a(@NonNull awxq.b paramb, boolean paramBoolean)
  {
    if (paramb.c.dtW) {
      paramb.c.dtX = true;
    }
    for (;;)
    {
      if ((axbr.b() != null) && (!axbr.b().equals(paramb.c)))
      {
        axbr.b().dtW = false;
        axbr.b().dtX = false;
      }
      return;
      paramb.c.dtW = true;
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113)
    {
      paramObject = axbr.b();
      if ((paramObject == null) || (paramObject.equals(axbu.i)))
      {
        ady(0);
        QLog.d("AEWaterMarkListPart", 4, "current pendant has change");
      }
    }
    for (;;)
    {
      return;
      h(paramObject);
      break;
      if (paramInt == 114)
      {
        paramObject = axbr.b();
        if (paramObject != null) {
          paramObject.editablewatermark = true;
        }
        h(paramObject);
        return;
      }
      if (paramInt == 115)
      {
        paramObject = axbr.b();
        if (paramObject != null) {
          paramObject.editablewatermark = false;
        }
        h(paramObject);
        return;
      }
      if ((paramInt == 112) && (paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof axbu)))
      {
        paramObject = (axbu)paramVarArgs[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_Awxq.getItemCount())
        {
          paramVarArgs = this.jdField_a_of_type_Awxq.a(paramInt);
          if ((paramVarArgs != null) && (paramObject.id.equals(paramVarArgs.id)))
          {
            paramVarArgs.usable = true;
            paramVarArgs.downloading = false;
            this.jdField_a_of_type_Awxq.notifyItemChanged(paramInt);
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void b(@NonNull awxq.b paramb, int paramInt)
  {
    paramb.adx(4);
  }
  
  public void c(@NonNull awxq.b paramb, int paramInt)
  {
    if (!"call_material_id".equals(paramb.c.id))
    {
      this.eDN = paramInt;
      paramb.c.dtW = true;
      if ((axbr.b() != null) && (!axbr.b().equals(paramb.c)))
      {
        axbr.b().dtW = false;
        axbr.b().dtX = false;
      }
    }
    QLog.d("AEWaterMarkListPart", 4, "prePosition:" + this.eDN);
  }
  
  public void d(@Nullable awxq.b paramb, int paramInt)
  {
    if (paramb != null)
    {
      paramb.adx(3);
      paramb = paramb.c;
      axaq.a().t(paramb);
      if (this.jdField_a_of_type_Awxq != null)
      {
        if (!a(paramb)) {
          break label46;
        }
        rpw.a(this.mActivity, paramb);
      }
    }
    return;
    label46:
    this.jdField_a_of_type_Awxq.d(paramb);
  }
  
  public void eHF()
  {
    if (axgn.aOC())
    {
      h(axgn.k);
      axgn.eJz();
    }
  }
  
  public void initView()
  {
    if (this.mRootView != null)
    {
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.mRootView.findViewById(2131378861)).inflate().findViewById(2131374698));
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new spm.a().a(0.88F).a());
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Awxq = new awxq(this.jdField_c_of_type_Awtq, this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_c_of_type_Awwk);
      this.jdField_a_of_type_Awxq.a(new awxw(this));
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Awxq);
      this.jdField_b_of_type_Axbr = ((axbr)axov.a().c(18));
      if (aOi()) {
        break label243;
      }
      this.jdField_b_of_type_Axbr.a(this, 113);
      this.jdField_b_of_type_Axbr.a(this, 114);
      this.jdField_b_of_type_Axbr.a(this, 115);
      this.jdField_b_of_type_Axbr.a(this, 112);
      eHx();
      eHz();
    }
    for (;;)
    {
      biN();
      return;
      label243:
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
      this.jdField_a_of_type_Awxq.eHv();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (aOh()) {
      this.jdField_c_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(0);
    }
  }
  
  public void onActivityResume()
  {
    if ((axbr.b() != null) && (!axbr.b().aOq()) && (this.mActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.mActivity.getIntent().putExtra("widgetinfo", "camera^" + axbr.b().id);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_Axbr.d(this);
    this.jdField_b_of_type_Axbr.c(null, false);
    if (this.jdField_a_of_type_Awxq != null) {
      this.jdField_a_of_type_Awxq.onDestroy();
    }
  }
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      eHC();
      return;
      eHD();
      return;
      this.jdField_a_of_type_Axgg.q().postValue(Boolean.valueOf(false));
      this.jdField_a_of_type_Axgg.r().postValue(Boolean.valueOf(false));
    } while ((!this.jdField_b_of_type_Axgf.bz()) || (aOi()));
    eHE();
    eHB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxv
 * JD-Core Version:    0.7.0.1
 */