import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.videostory.capture.AEBottomListPart.4;
import com.tencent.biz.videostory.capture.AEBottomListPart.6;
import com.tencent.biz.videostory.capture.AEBottomListPart.7;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class wqq
  extends wug
  implements awhd, wvs, wvt<wqp>, wvu<wqp>
{
  private int jdField_a_of_type_Int;
  private bgxh jdField_a_of_type_Bgxh;
  private bgxx jdField_a_of_type_Bgxx;
  private bhcw jdField_a_of_type_Bhcw;
  private AEBottomListScrollView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView;
  private wql jdField_a_of_type_Wql;
  private wsi jdField_a_of_type_Wsi;
  private wsz jdField_a_of_type_Wsz;
  private wvc jdField_a_of_type_Wvc;
  
  public wqq(Activity paramActivity, View paramView, wus paramwus)
  {
    super(paramActivity, paramView, paramwus);
    this.jdField_a_of_type_Bhcw = ((bhcw)paramwus.a(65537, new Object[0]));
    this.jdField_a_of_type_Bgxh = this.jdField_a_of_type_Bhcw.a();
  }
  
  private int a(String paramString)
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
      if (i >= this.jdField_a_of_type_Wql.getItemCount()) {
        break label57;
      }
      bgya localbgya = this.jdField_a_of_type_Wql.a(i);
      if (localbgya != null)
      {
        j = i;
        if (paramString.equals(localbgya.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  @NonNull
  private bgya a(int paramInt)
  {
    if (this.jdField_a_of_type_Wql != null) {
      return this.jdField_a_of_type_Wql.a(paramInt);
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_Wql.a(paramInt));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.invalidate();
  }
  
  private void a(bgya parambgya)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.getIntent() == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("qq_camera_top_title", parambgya.f);
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("qq_camera_scheme", parambgya.g);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && ((bjeg.k(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (bjeg.l(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (bjeg.m(this.jdField_a_of_type_AndroidAppActivity.getIntent())));
  }
  
  private boolean a(bgya parambgya)
  {
    if (parambgya != null) {
      return parambgya.a();
    }
    return false;
  }
  
  private void b(bgya parambgya)
  {
    if ((parambgya != null) && (!parambgya.equals(bgya.jdField_a_of_type_Bgya)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_Wql.getItemCount()) || (this.jdField_a_of_type_Wql.a(i) == null)) {
        break label103;
      }
      if (!parambgya.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Wql.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_Wql.a(i).a(parambgya);
      a(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Wql.a(parambgya);
        a(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Wql.a();
    bhcm.a().g();
    bhci.a().A();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Wsi = ((wsi)bhur.a(this.jdField_a_of_type_Bhcw).a(wsi.class));
    this.jdField_a_of_type_Wsi.a().a(this.jdField_a_of_type_Bhcw, new wqr(this));
    this.jdField_a_of_type_Wsz = ((wsz)bhur.a(this.jdField_a_of_type_Bhcw).a(wsz.class));
    this.jdField_a_of_type_Wsz.a().a(this.jdField_a_of_type_Bhcw, new wqx(this));
  }
  
  private void g()
  {
    if (a()) {
      return;
    }
    wqa.a(new View[] { this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new wqy(this)).b();
  }
  
  private void j()
  {
    QLog.d("AEWaterMarkListPart", 4, "getDateFromPtv: ");
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.4(this));
    avzk.b().a(this.jdField_a_of_type_Bhcw, new wqz(this));
  }
  
  private void k()
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
      this.jdField_a_of_type_Bgxx.d();
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
          Object localObject = this.jdField_a_of_type_Bgxx.b();
          if (QLog.isDevelopLevel())
          {
            l4 = System.currentTimeMillis();
            QLog.d("AEWaterMarkListPart", 4, "found hot category cost=" + (l4 - l2));
          }
          for (l2 = l4;; l2 = 0L)
          {
            if (((List)localObject).isEmpty())
            {
              ThreadManager.getUIHandler().post(new AEBottomListPart.6(this, l1));
              return;
            }
            ArrayList localArrayList = new ArrayList();
            localObject = ((List)localObject).iterator();
            int i = 0;
            while (((Iterator)localObject).hasNext())
            {
              bgya localbgya = (bgya)((Iterator)localObject).next();
              if (((!localbgya.jdField_a_of_type_JavaLangString.contains("_3DFaceFila")) || (FilamentInitializer.supportFilament())) && ((!localbgya.jdField_a_of_type_JavaLangString.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
              {
                if (i >= 10) {
                  break;
                }
                localArrayList.add(localbgya);
                i += 1;
              }
            }
            l1 = l3;
            if (QLog.isDevelopLevel())
            {
              l1 = System.currentTimeMillis();
              QLog.d("AEWaterMarkListPart", 4, "filterFilament cost=" + (l1 - l2));
            }
            ThreadManager.getUIHandler().post(new AEBottomListPart.7(this, localArrayList, l1));
            return;
          }
        }
        l2 = 0L;
      }
      l1 = 0L;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Wvc != null) {
      this.jdField_a_of_type_Wvc.b();
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Wvc == null)
    {
      this.jdField_a_of_type_Wvc = new wvc(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Wvc.a(new wra(this));
    }
    this.jdField_a_of_type_Wvc.a();
  }
  
  @TargetApi(12)
  private void n()
  {
    int i = vms.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.getHeight());
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    ((AnimatorSet)localObject).addListener(new wrb(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = bhog.a(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new wqs(this));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Wsi.a())
    {
      if (this.jdField_a_of_type_Wus != null)
      {
        this.jdField_a_of_type_Wus.a(327683, new Object[0]);
        this.jdField_a_of_type_Wus.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bhcw.a().a(true, 150);
      return;
    }
    int i = vms.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new wqt(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bhog.a(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new wqu(this));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Wsi.a())
    {
      if (this.jdField_a_of_type_Wus != null)
      {
        this.jdField_a_of_type_Wus.a(327684, new Object[0]);
        this.jdField_a_of_type_Wus.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_Bhcw.a().a(true, 150);
      return;
    }
    int i = vms.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.getHeight());
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new wqv(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bhog.a(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new wqw(this));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.startAnimation((Animation)localObject);
  }
  
  private void q()
  {
    int j = 0;
    bgya localbgya1 = bgxx.a();
    if (localbgya1 != null)
    {
      bgya localbgya2 = this.jdField_a_of_type_Wql.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localbgya2 != null)
      {
        i = j;
        if (localbgya1.jdField_a_of_type_JavaLangString.equals(localbgya2.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_Wql.getItemCount()) {
          break;
        }
        localbgya2 = this.jdField_a_of_type_Wql.a(i);
      } while ((localbgya2 == null) || (!localbgya1.jdField_a_of_type_JavaLangString.equals(localbgya2.jdField_a_of_type_JavaLangString)));
      a(i);
      return;
    }
    a(0);
    return;
    a(this.jdField_a_of_type_Int);
  }
  
  public bgxx a()
  {
    return this.jdField_a_of_type_Bgxx;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView = ((AEBottomListScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131307138));
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setItemTransformer(new wwp().a(0.88F).a());
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_Wql = new wql(this.jdField_a_of_type_Bhcw, this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView, this.jdField_a_of_type_Bgxh);
      this.jdField_a_of_type_Wql.a(this.jdField_a_of_type_Bhcw);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Wql);
      this.jdField_a_of_type_Bgxx = ((bgxx)bhfm.a().c(18));
      if (a()) {
        break label227;
      }
      this.jdField_a_of_type_Bgxx.a(this, 113);
      this.jdField_a_of_type_Bgxx.a(this, 114);
      this.jdField_a_of_type_Bgxx.a(this, 115);
      this.jdField_a_of_type_Bgxx.a(this, 112);
      e();
      j();
    }
    for (;;)
    {
      f();
      return;
      label227:
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setVisibility(8);
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable wqp paramwqp1, @Nullable wqp paramwqp2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Wsi.b()) && (!a())) {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.setVisibility(0);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      o();
      return;
      p();
      return;
      this.jdField_a_of_type_Wsz.b().a(Boolean.valueOf(false));
      this.jdField_a_of_type_Wsz.c().a(Boolean.valueOf(false));
    } while ((!this.jdField_a_of_type_Wsi.b()) || (a()));
    q();
    n();
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113)
    {
      paramObject = bgxx.a();
      if ((paramObject == null) || (paramObject.equals(bgya.jdField_a_of_type_Bgya)))
      {
        a(0);
        QLog.d("AEWaterMarkListPart", 4, "current pendant has change");
      }
    }
    for (;;)
    {
      return;
      b(paramObject);
      break;
      if (paramInt == 114)
      {
        paramObject = bgxx.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = true;
        }
        b(paramObject);
        return;
      }
      if (paramInt == 115)
      {
        paramObject = bgxx.a();
        if (paramObject != null) {
          paramObject.jdField_a_of_type_Boolean = false;
        }
        b(paramObject);
        return;
      }
      if ((paramInt == 112) && (paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof bgya)))
      {
        paramObject = (bgya)paramVarArgs[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_Wql.getItemCount())
        {
          paramVarArgs = this.jdField_a_of_type_Wql.a(paramInt);
          if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
          {
            paramVarArgs.d = true;
            paramVarArgs.e = false;
            this.jdField_a_of_type_Wql.notifyItemChanged(paramInt);
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(@NonNull wqp paramwqp, int paramInt)
  {
    paramwqp.a(4);
  }
  
  public void a(@NonNull wqp paramwqp, boolean paramBoolean)
  {
    if (paramwqp.jdField_a_of_type_Bgya.b) {
      paramwqp.jdField_a_of_type_Bgya.c = true;
    }
    for (;;)
    {
      if ((bgxx.a() != null) && (!bgxx.a().equals(paramwqp.jdField_a_of_type_Bgya)))
      {
        bgxx.a().b = false;
        bgxx.a().c = false;
      }
      return;
      paramwqp.jdField_a_of_type_Bgya.b = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  public void ad_()
  {
    if (wrn.a())
    {
      b(wrn.b);
      wrn.c();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wvc != null) {
      this.jdField_a_of_type_Wvc.c();
    }
    if ((bgxx.a() != null) && (!bgxx.a().c()) && (this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("widgetinfo", "camera^" + bgxx.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(@NonNull wqp paramwqp, int paramInt)
  {
    if (!"call_material_id".equals(paramwqp.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      paramwqp.jdField_a_of_type_Bgya.b = true;
      if ((bgxx.a() != null) && (!bgxx.a().equals(paramwqp.jdField_a_of_type_Bgya)))
      {
        bgxx.a().b = false;
        bgxx.a().c = false;
      }
    }
    QLog.d("AEWaterMarkListPart", 4, "prePosition:" + this.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bgxx.a(this);
    this.jdField_a_of_type_Bgxx.b(null, false);
    if (this.jdField_a_of_type_Wql != null) {
      this.jdField_a_of_type_Wql.b();
    }
  }
  
  public void c(@Nullable wqp paramwqp, int paramInt)
  {
    if (paramwqp != null)
    {
      paramwqp.a(3);
      wvh.a().a(paramwqp.jdField_a_of_type_Bgya);
      if (this.jdField_a_of_type_Wql != null)
      {
        if (!a(paramwqp.jdField_a_of_type_Bgya)) {
          break label50;
        }
        m();
      }
    }
    for (;;)
    {
      a(paramwqp.jdField_a_of_type_Bgya);
      return;
      label50:
      l();
      this.jdField_a_of_type_Wql.b(paramwqp.jdField_a_of_type_Bgya);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqq
 * JD-Core Version:    0.7.0.1
 */