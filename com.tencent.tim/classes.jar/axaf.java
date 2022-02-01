import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.a;
import dov.com.qq.im.ae.view.AECompoundButton;

public class axaf
  extends axgh
  implements View.OnClickListener
{
  private View Mr;
  private axgg jdField_a_of_type_Axgg;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private axgf b;
  private awtq c;
  private boolean dtS;
  private AECompoundButton e;
  private int eEr = 3;
  private AECompoundButton f;
  private AECompoundButton g;
  private AECompoundButton h;
  private AECompoundButton i;
  private AECompoundButton j;
  private AECompoundButton k;
  private AECompoundButton l;
  private LinearLayout mr;
  
  public axaf(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
    this.jdField_c_of_type_Awtq = ((awtq)paramaxgi.a(65537, new Object[0]));
  }
  
  private void XX(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.b.aOx())
      {
        this.k.setVisibility(0);
        this.j.setVisibility(0);
        this.g.setVisibility(8);
        this.l.setVisibility(8);
      }
      for (;;)
      {
        this.h.setVisibility(0);
        return;
        this.g.setVisibility(0);
        if (axcg.ay(this.mActivity.getIntent())) {
          this.l.setVisibility(0);
        }
      }
    }
    if (this.b.aOx())
    {
      this.k.setVisibility(8);
      this.j.setVisibility(8);
    }
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  private void a(@NonNull axjd paramaxjd)
  {
    if (!axcg.ay(this.mActivity.getIntent())) {}
    do
    {
      return;
      if (this.i != null) {
        this.i.setForegroundAndBackgroundResource(paramaxjd.eFv, paramaxjd.eFu);
      }
      if (this.f != null) {
        this.f.setForegroundAndBackgroundResource(paramaxjd.eFw, paramaxjd.eFu);
      }
      if (this.l != null) {
        this.l.setForegroundAndBackgroundResource(paramaxjd.eFx, paramaxjd.eFu);
      }
      if (this.g != null) {
        this.g.setForegroundAndBackgroundResource(paramaxjd.eFy, paramaxjd.eFu);
      }
      if (this.h != null) {
        this.h.setForegroundAndBackgroundResource(paramaxjd.eFz, paramaxjd.eFu);
      }
    } while (this.e == null);
    this.e.setForegroundAndBackgroundResource(paramaxjd.eFA, paramaxjd.eFu);
  }
  
  private boolean aOo()
  {
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.c() == null)) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.c().getValue();
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  private void biN()
  {
    this.b = ((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class));
    this.b.t.a(this.jdField_c_of_type_Awtq, new axah(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)awuh.a(this.jdField_c_of_type_Awtq).b(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().a(this.jdField_c_of_type_Awtq, new axai(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.c().a(this.jdField_c_of_type_Awtq, new axaj(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.d.a(this.jdField_c_of_type_Awtq, new axak(this));
    this.jdField_a_of_type_Axgg = ((axgg)awuh.a(this.jdField_c_of_type_Awtq).b(axgg.class));
    this.jdField_a_of_type_Axgg.p().a(this.jdField_c_of_type_Awtq, new axal(this));
    this.jdField_a_of_type_Axgg.q().a(this.jdField_c_of_type_Awtq, new axam(this));
    this.jdField_a_of_type_Axgg.r().a(this.jdField_c_of_type_Awtq, new axan(this));
  }
  
  private void eIr()
  {
    if (!"VIVO;V1836T".equalsIgnoreCase(Build.MANUFACTURER + ";" + Build.MODEL)) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = this.Mr.getLayoutParams();
    } while (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
    localMarginLayoutParams.topMargin += riw.dip2px(this.mActivity, 20.0F);
    this.Mr.setLayoutParams(localLayoutParams);
  }
  
  protected void initView()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378877);
    if (localViewStub != null) {
      this.Mr = localViewStub.inflate();
    }
    ViewCompat.setOnApplyWindowInsetsListener(this.Mr, new axag(this));
    ViewCompat.requestApplyInsets(this.Mr);
    this.mr = ((LinearLayout)this.mRootView.findViewById(2131364137));
    this.i = ((AECompoundButton)this.Mr.findViewById(2131364226));
    this.i.setOnClickListener(this);
    this.e = ((AECompoundButton)this.Mr.findViewById(2131364422));
    this.f = ((AECompoundButton)this.Mr.findViewById(2131365586));
    this.h = ((AECompoundButton)this.Mr.findViewById(2131363357));
    this.h.setOnClickListener(this);
    this.g = ((AECompoundButton)this.Mr.findViewById(2131367213));
    this.j = ((AECompoundButton)this.Mr.findViewById(2131365470));
    this.j.setOnClickListener(this);
    this.k = ((AECompoundButton)this.Mr.findViewById(2131379062));
    this.k.setOnClickListener(this);
    this.k.setSelected(false);
    this.g.setOnClickListener(this);
    this.g.setSelected(this.dtS);
    this.l = ((AECompoundButton)this.Mr.findViewById(2131379056));
    this.l.setOnClickListener(this);
    biN();
    eIr();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (aOo()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.c().postValue(Boolean.valueOf(true));
    }
    if (this.g != null) {
      this.g.setSelected(this.dtS);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = true;
    switch (paramView.getId())
    {
    }
    label410:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b.aOx()) {}
      for (;;)
      {
        axxe.a(this.h.H(), 200L, null);
        sqn.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
        if (this.jdField_c_of_type_Axgi == null) {
          break;
        }
        if (!this.jdField_a_of_type_Axgg.aOA()) {
          break label162;
        }
        this.jdField_c_of_type_Axgi.p(327686, new Object[0]);
        break;
        axim.a().eKV();
      }
      label162:
      if (!this.jdField_a_of_type_Axgg.aOB())
      {
        Object localObject;
        if (axcg.ay(this.jdField_c_of_type_Awtq.getActivity().getIntent()))
        {
          if (!axiw.Y(paramView))
          {
            localObject = new Intent();
            ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
            ((Intent)localObject).putExtra("is_show", false);
            this.jdField_c_of_type_Awtq.getActivity().sendBroadcast((Intent)localObject);
          }
        }
        else
        {
          this.jdField_c_of_type_Axgi.p(131077, new Object[0]);
          continue;
          axxe.a(this.j.H(), 200L, null);
          localObject = (AEVideoStoryTopBarViewModel.a)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().getValue();
          int m;
          if ((localObject != null) && (((AEVideoStoryTopBarViewModel.a)localObject).getEnable()))
          {
            m = 1;
            label296:
            localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b();
            if (m != 0) {
              break label364;
            }
            bool1 = true;
            label311:
            ((axzu)localObject).postValue(new AEVideoStoryTopBarViewModel.a(bool1, this.eEr));
            if (!this.b.aOx()) {
              continue;
            }
            localObject = axip.a();
            if (m != 0) {
              break label369;
            }
          }
          label364:
          label369:
          for (bool1 = bool3;; bool1 = false)
          {
            ((axip)localObject).Yo(bool1);
            break;
            m = 0;
            break label296;
            bool1 = false;
            break label311;
          }
          axxe.a(this.k.H(), 200L, null);
          bool3 = aOo();
          localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.c();
          if (!bool3)
          {
            bool1 = true;
            ((axzu)localObject).postValue(Boolean.valueOf(bool1));
            if (!this.b.aOx()) {
              continue;
            }
            localObject = axip.a();
            if (bool3) {
              break label456;
            }
          }
          label456:
          for (bool1 = bool2;; bool1 = false)
          {
            ((axip)localObject).Yn(bool1);
            break;
            bool1 = false;
            break label410;
          }
          axxe.a(paramView, 200L, null);
          this.jdField_c_of_type_Awtq.auC();
          continue;
          axxe.a(this.g.H(), 200L, null);
          if (!this.g.isSelected()) {}
          for (;;)
          {
            if (this.jdField_c_of_type_Awtq.bj(bool1))
            {
              this.dtS = bool1;
              this.g.setSelected(bool1);
              if (QLog.isDevelopLevel()) {
                axiy.d("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
              }
            }
            axim.a().eKQ();
            break;
            bool1 = false;
          }
          axxe.a(this.l.H(), 200L, null);
          localObject = (AEVideoStoryTopBarViewModel.Ratio)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.d.getValue();
          if (localObject != null) {
            this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.d.postValue(((AEVideoStoryTopBarViewModel.Ratio)localObject).next());
          }
        }
      }
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
    } while ((!aOo()) || (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.c() == null));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.c().postValue(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axaf
 * JD-Core Version:    0.7.0.1
 */