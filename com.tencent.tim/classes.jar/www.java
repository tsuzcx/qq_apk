import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class www
  implements View.OnClickListener, wvs
{
  AnimatorSet N;
  private PatchedButton a;
  protected ImageButton ak;
  private int bRT = -1;
  private int bRU = -1;
  private int bRV = -1;
  private int bRW = -1;
  private int bRX = -1;
  private int bRY = -1;
  private int bRZ = -1;
  private int bSa = -1;
  private int bSb = -1;
  private int bSc = -1;
  private int bSd = -1;
  private int bSe = -1;
  private int bSf = -1;
  private int bSg = -1;
  private int bSh = -1;
  private int bSi = -1;
  int bSj;
  private int bSk = -1;
  protected boolean bgj;
  private boolean bgk;
  private boolean bgl;
  private boolean bgm;
  private boolean bgn;
  PatchedButton d;
  PatchedButton e;
  protected BaseChatPie f;
  private LinearLayout hc;
  protected boolean isHideBottom;
  private LinearLayout j;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  protected ImageButton n;
  private int padding;
  
  public www(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie;
  }
  
  private boolean N(View paramView)
  {
    return ((paramView.getLayoutParams() instanceof FrameLayout.LayoutParams)) && (((View)paramView.getParent() instanceof RedTouch));
  }
  
  private void a(RedTouch paramRedTouch)
  {
    b(paramRedTouch, 10);
  }
  
  private void a(RedTouch paramRedTouch, int paramInt1, int paramInt2)
  {
    if (this.f.sessionInfo.cZ == 0)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)this.f.app.getManager(36)).a(paramInt1, String.valueOf(paramInt2));
      if (localAppInfo != null) {
        paramRedTouch.e(localAppInfo);
      }
    }
  }
  
  private void b(RedTouch paramRedTouch, int paramInt)
  {
    if (this.f.sessionInfo.cZ == 0)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((altq)this.f.app.getManager(36)).c(paramInt);
      if (localRedTypeInfo != null) {
        paramRedTouch.c(localRedTypeInfo);
      }
    }
  }
  
  private void ccC() {}
  
  private void ccK()
  {
    this.padding = wja.dp2px(4.0F, this.f.mActivity.getResources());
    ccs();
    this.bgk = false;
  }
  
  private void ccL()
  {
    if (this.f.sessionInfo.cZ == 0) {
      a(new RedTouch(this.f.mContext, this.e).a(8388661).a());
    }
  }
  
  private void ccN()
  {
    if (this.f.sessionInfo.cZ == 0) {
      a(new RedTouch(this.f.mContext, this.n).a(8388661).a(), 4, 130105);
    }
  }
  
  private void ccO()
  {
    if (this.f.sessionInfo.cZ == 0) {
      a(new RedTouch(this.f.mContext, this.ak).a(8388661).a(), 4, 130101);
    }
  }
  
  private void ccP()
  {
    boolean bool = jof.a().dd(this.f.sessionInfo.aTl);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "reAdjustAnonyStatusBar is called! isAnony = " + bool);
      }
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW())) {
        ImmersiveUtils.setStatusTextColor(false, this.f.a().getWindow());
      }
    }
  }
  
  private void fG(int paramInt1, int paramInt2)
  {
    if (this.a != null)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.a.setLayoutParams(localLayoutParams);
    }
  }
  
  private void onCreate()
  {
    this.e = ((PatchedButton)this.f.mAIORootView.findViewById(2131373428));
    this.d = ((PatchedButton)this.f.mAIORootView.findViewById(2131367817));
    this.e.setOnClickListener(this.f);
    this.d.setOnClickListener(this.f);
    this.d.setOnLongClickListener(new wwx(this));
    this.bSj = 1;
    this.f.jdField_b_of_type_ComTencentWidgetPatchedButton = this.d;
  }
  
  private void onDestroy() {}
  
  private void onPause() {}
  
  private void onShow() {}
  
  protected void Ad()
  {
    this.bgn = false;
    this.a = ((PatchedButton)this.f.mAIORootView.findViewById(2131367802));
    Object localObject1;
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject2;
    if ((this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.isHideBottom)) {
      if (this.ak != null)
      {
        this.ak.setVisibility(0);
        if (this.ak != null)
        {
          this.ak.setSelected(false);
          if (AppSetting.enableTalkBack) {
            this.ak.setContentDescription(acfp.m(2131714604));
          }
        }
        if (this.n == null) {
          break label768;
        }
        this.n.setVisibility(0);
        if (this.n != null)
        {
          this.n.setSelected(false);
          if (AppSetting.enableTalkBack) {
            this.n.setContentDescription(acfp.m(2131714601));
          }
        }
        this.hc = ((LinearLayout)this.f.mAIORootView.findViewById(2131367819));
        if (this.f.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          localObject1 = (FrameLayout.LayoutParams)this.f.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
          if (this.bRV == -1) {
            this.bRV = ((FrameLayout.LayoutParams)localObject1).leftMargin;
          }
          ((FrameLayout.LayoutParams)localObject1).leftMargin = wja.dp2px(8.0F, this.f.mActivity.getResources());
          this.f.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (this.f.mAIORootView != null)
        {
          this.j = ((LinearLayout)this.f.mAIORootView.findViewById(2131367818));
          localObject1 = (LinearLayout.LayoutParams)this.j.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).gravity = 80;
          if (this.bSg == -1) {
            this.bSg = ((LinearLayout.LayoutParams)localObject1).bottomMargin;
          }
          if ((this.ak != null) && (this.bSh == -1)) {
            this.bSh = ((LinearLayout.LayoutParams)this.ak.getLayoutParams()).bottomMargin;
          }
          if (this.bSh == -1) {
            break label821;
          }
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.bSh;
          if (QLog.isColorLevel()) {
            QLog.d("SimpleUIAIOHelper", 2, "initui() simple mode  bottomMargin 1 = " + ((LinearLayout.LayoutParams)localObject1).bottomMargin);
          }
          this.j.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (this.f.jdField_b_of_type_ComTencentWidgetPatchedButton != null)
        {
          localObject1 = this.e;
          localLayoutParams = ((View)localObject1).getLayoutParams();
          localObject2 = localLayoutParams;
          if ((localLayoutParams instanceof FrameLayout.LayoutParams))
          {
            localObject1 = (View)this.e.getParent();
            localObject2 = ((View)localObject1).getLayoutParams();
            if ((localObject1 instanceof RedTouch)) {
              a((RedTouch)localObject1);
            }
          }
          if ((localObject2 instanceof LinearLayout.LayoutParams))
          {
            localObject2 = (LinearLayout.LayoutParams)localObject2;
            if (this.bRW == -1) {
              this.bRW = ((LinearLayout.LayoutParams)localObject2).width;
            }
            if (this.bRX == -1) {
              this.bRX = ((LinearLayout.LayoutParams)localObject2).height;
            }
            ((LinearLayout.LayoutParams)localObject2).width = ((int)this.f.mActivity.getResources().getDimension(2131298558));
            ((LinearLayout.LayoutParams)localObject2).height = ((int)this.f.mActivity.getResources().getDimension(2131298558));
            ((LinearLayout.LayoutParams)localObject2).gravity = 8388629;
            this.e.setVisibility(0);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            fG(((LinearLayout.LayoutParams)localObject2).width, ((LinearLayout.LayoutParams)localObject2).height);
            this.e.setBackgroundResource(2130838286);
            this.e.setText("");
            if (AppSetting.enableTalkBack) {
              this.e.setContentDescription(acfp.m(2131714611));
            }
            this.e.setEnabled(true);
          }
          if (!(localObject1 instanceof RedTouch)) {
            ccL();
          }
        }
        if (this.ak != null)
        {
          if (!N(this.ak)) {
            break label845;
          }
          localObject1 = (View)this.ak.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 4, 130101);
        }
        if (this.n != null)
        {
          if (!N(this.n)) {
            break label852;
          }
          localObject1 = (View)this.n.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 4, 130105);
        }
      }
    }
    label768:
    label821:
    label845:
    label852:
    while ((this.f instanceof ydw))
    {
      for (;;)
      {
        return;
        localObject1 = (ViewStub)this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362510);
        if (localObject1 != null)
        {
          this.ak = ((ImageButton)((ViewStub)localObject1).inflate());
          this.ak.setBackgroundResource(2130838295);
          this.ak.setOnClickListener(this);
          continue;
          localObject1 = (ViewStub)this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362511);
          if (localObject1 != null)
          {
            this.n = ((ImageButton)((ViewStub)localObject1).inflate());
            this.n.setBackgroundResource(2130838215);
            this.n.setOnClickListener(this);
            continue;
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)this.f.mActivity.getResources().getDimension(2131298557));
            continue;
            ccO();
          }
        }
      }
      ccN();
      return;
    }
    if (this.ak != null)
    {
      if (N(this.ak)) {
        ((RedTouch)this.ak.getParent()).setVisibility(8);
      }
      this.ak.setVisibility(8);
    }
    if (this.n != null)
    {
      if (N(this.n)) {
        ((RedTouch)this.n.getParent()).setVisibility(8);
      }
      this.n.setVisibility(8);
    }
    if (this.f.jdField_b_of_type_ComTencentWidgetPatchedButton != null) {
      this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    }
    if ((this.f.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.bRV != -1))
    {
      localObject1 = (FrameLayout.LayoutParams)this.f.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).leftMargin = this.bRV;
      this.f.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.f.jdField_b_of_type_ComTencentWidgetPatchedButton != null)
    {
      localObject1 = this.f.jdField_b_of_type_ComTencentWidgetPatchedButton;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          ((RedTouch)localObject1).dGB();
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if ((this.bRW != -1) && (this.bRX != -1))
        {
          ((LinearLayout.LayoutParams)localObject2).width = this.bRW;
          ((LinearLayout.LayoutParams)localObject2).height = this.bRX;
          this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject2).gravity = 85;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          fG(((LinearLayout.LayoutParams)localObject2).width, ((LinearLayout.LayoutParams)localObject2).height);
          this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.setBackgroundResource(wi());
          this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131691441);
          if (AppSetting.enableTalkBack) {
            this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.setContentDescription(acfp.m(2131714614));
          }
          if (this.f.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
          {
            localObject1 = this.f.jdField_b_of_type_ComTencentWidgetPatchedButton;
            if (this.f.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
              break label1375;
            }
          }
        }
      }
    }
    label1375:
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject1).setEnabled(bool);
      if (this.f.mAIORootView == null) {
        break;
      }
      if (this.j == null) {
        this.j = ((LinearLayout)this.f.mAIORootView.findViewById(2131367818));
      }
      localObject1 = (LinearLayout.LayoutParams)this.j.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      if (this.bSg != -1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.bSg;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "initui() simple mode  bottomMargin  2 = " + ((LinearLayout.LayoutParams)localObject1).bottomMargin);
      }
      this.j.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return;
    }
  }
  
  public int[] C()
  {
    return new int[] { 0, 1, 2, 3, 5, 7, 8, 9, 13 };
  }
  
  public void CV(int paramInt)
  {
    if (this.isHideBottom) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
    } while (this.ak == null);
    this.ak.setSelected(false);
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.bSi = paramInt;
      return;
      onCreate();
      continue;
      ccK();
      continue;
      onInit();
      continue;
      onResume();
      ccC();
      continue;
      onShow();
      continue;
      onPause();
      continue;
      onDestroy();
    }
  }
  
  public boolean Se()
  {
    wxk localwxk = (wxk)this.f.a(23);
    return (localwxk != null) && ((localwxk.Ss()) || (this.bgn));
  }
  
  public void ccG()
  {
    if (this.j == null) {
      this.j = ((LinearLayout)this.f.mAIORootView.findViewById(2131367818));
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.j.getLayoutParams();
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout  bottomMargin  = " + localLayoutParams.bottomMargin);
    }
    if ((this.f.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.isHideBottom))
    {
      if (this.bSh != -1) {}
      for (localLayoutParams.bottomMargin = this.bSh;; localLayoutParams.bottomMargin = ((int)this.f.mActivity.getResources().getDimension(2131298557)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout() simple mode  bottomMargin 1 = " + localLayoutParams.bottomMargin);
        }
        this.j.setLayoutParams(localLayoutParams);
        return;
      }
    }
    localLayoutParams.gravity = 80;
    if (this.bSg != -1) {
      localLayoutParams.bottomMargin = this.bSg;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout() simple mode  bottomMargin 2 = " + localLayoutParams.bottomMargin);
    }
    this.j.setLayoutParams(localLayoutParams);
  }
  
  void ccM()
  {
    View localView = (View)this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.getParent();
    if (((localView instanceof RedTouch)) && (TextUtils.isEmpty(this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.getText())))
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((altq)this.f.app.getManager(36)).c(10);
      ((RedTouch)localView).c(localRedTypeInfo);
    }
  }
  
  protected void ccs()
  {
    if ((this.f.sessionInfo.cZ == 0) || (this.f.sessionInfo.cZ == 1) || (this.f.sessionInfo.cZ == 3000)) {
      this.isHideBottom = true;
    }
  }
  
  public void cct()
  {
    Object localObject = (wvd)this.f.a(24);
    if ((this.f.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.isHideBottom))
    {
      this.f.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      int i = wja.dp2px(10.0F, this.f.mActivity.getResources());
      if ((this.bRT == -1) || (this.bRU == -1))
      {
        this.bRT = this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop();
        this.bRU = this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom();
      }
      if (this.f.jdField_b_of_type_ComTencentWidgetPatchedButton != null) {
        this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      }
      if (!((wvd)localObject).isFullScreenMode()) {
        this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), i, this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), i);
      }
      if (this.f.mAIORootView != null)
      {
        if (this.j == null) {
          this.j = ((LinearLayout)this.f.mAIORootView.findViewById(2131367818));
        }
        localObject = (LinearLayout.LayoutParams)this.j.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).gravity = 80;
        if (this.bSg == -1) {
          this.bSg = ((LinearLayout.LayoutParams)localObject).bottomMargin;
        }
        if ((this.ak != null) && (this.bSh == -1)) {
          this.bSh = ((LinearLayout.LayoutParams)this.ak.getLayoutParams()).bottomMargin;
        }
        if (this.bSh == -1) {
          break label334;
        }
        ((LinearLayout.LayoutParams)localObject).bottomMargin = this.bSh;
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "setSimpleUIMode() simple mode  bottomMargin 1 = " + ((LinearLayout.LayoutParams)localObject).bottomMargin);
        }
        this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      return;
      label334:
      ((LinearLayout.LayoutParams)localObject).bottomMargin = ((int)this.f.mActivity.getResources().getDimension(2131298557));
      break;
      if ((this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.bRT != -1) && (this.bRU != -1))
      {
        if (!((wvd)localObject).isFullScreenMode()) {
          this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.bRT, this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), this.bRU);
        }
        if (!this.f.aey) {
          break label574;
        }
        this.f.zL(wja.dp2px(1.0F, this.f.mActivity.getResources()));
      }
      while (this.f.mAIORootView != null)
      {
        if (this.j == null) {
          this.j = ((LinearLayout)this.f.mAIORootView.findViewById(2131367818));
        }
        localObject = (LinearLayout.LayoutParams)this.j.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).gravity = 16;
        if (this.bSg != -1) {
          ((LinearLayout.LayoutParams)localObject).bottomMargin = this.bSg;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "setSimpleUIMode() simple mode  bottomMargin 2 = " + ((LinearLayout.LayoutParams)localObject).bottomMargin);
        }
        this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        label574:
        ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this.f), true);
      }
    }
  }
  
  public void l(Boolean paramBoolean)
  {
    Object localObject = this.f.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {}
    for (localObject = ((ChatFragment)localObject).b;; localObject = null)
    {
      anlm.a((SystemBarCompact)localObject, this.f.a().getWindow(), paramBoolean);
      ccP();
      return;
    }
  }
  
  public void o(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if (this.isHideBottom)
    {
      Object localObject = this.f.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramInt2 != 8) {
        break label106;
      }
      bool1 = true;
      ((PatchedButton)localObject).setSelected(bool1);
      if (this.n != null)
      {
        localObject = this.n;
        if (paramInt2 != 3) {
          break label111;
        }
        bool1 = true;
        label53:
        ((ImageButton)localObject).setSelected(bool1);
      }
      if (this.ak != null) {
        if (paramInt2 != 2) {
          break label116;
        }
      }
    }
    label106:
    label111:
    label116:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ak.setSelected(bool1);
      if (AppSetting.enableTalkBack)
      {
        if (!bool1) {
          break label121;
        }
        this.ak.setContentDescription(acfp.m(2131714609));
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label53;
    }
    label121:
    this.ak.setContentDescription(acfp.m(2131714616));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "onClick() simple_audio_btn");
      }
      this.f.k(Integer.valueOf(2));
      this.ak.setSelected(true);
      this.n.setSelected(false);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "onClick() simple_emo_btn");
      }
      this.f.k(Integer.valueOf(3));
      this.ak.setSelected(false);
      this.n.setSelected(true);
    }
  }
  
  public void onInit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onCreate() called");
    }
    Ad();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onResume() called");
    }
    cct();
  }
  
  public void v(TextView paramTextView)
  {
    if (paramTextView != null)
    {
      Object localObject = paramTextView.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (this.bSk == -1) {
          this.bSk = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = wja.dp2px(14.0F, this.f.mActivity.getResources());
        paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public int wi()
  {
    return 2130838363;
  }
  
  public void zf(boolean paramBoolean)
  {
    Object localObject = (wxk)this.f.a(23);
    boolean bool = paramBoolean;
    if (localObject != null) {
      if (!((wxk)localObject).Ss())
      {
        bool = paramBoolean;
        if (!this.bgn) {}
      }
      else
      {
        bool = paramBoolean;
        if ((this.f instanceof xwn)) {
          bool = true;
        }
      }
    }
    if (this.N != null) {
      this.N.end();
    }
    if (this.f.jdField_b_of_type_ComTencentWidgetPatchedButton != null)
    {
      if (!this.isHideBottom) {
        break label326;
      }
      if (!bool) {
        break label284;
      }
      if (this.bSj == 2) {
        if (this.bSi < 7) {
          break label366;
        }
      }
    }
    label284:
    label326:
    label366:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = ObjectAnimator.ofFloat(this.e, "translationX", new float[] { 0.0F, -50.0F });
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.e, "alpha", new float[] { 1.0F, 0.0F });
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.d, "alpha", new float[] { 0.0F, 1.0F });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2 });
        localAnimatorSet.setDuration(200L);
        localAnimatorSet.addListener(new wwy(this));
        localAnimatorSet.start();
        this.N = localAnimatorSet;
        this.d.setVisibility(0);
        this.f.jdField_b_of_type_ComTencentWidgetPatchedButton = this.d;
        this.bSj = 1;
      }
      do
      {
        return;
        this.e.setVisibility(8);
        break;
      } while (this.bSj != 1);
      this.e.setVisibility(0);
      this.d.setVisibility(8);
      this.f.jdField_b_of_type_ComTencentWidgetPatchedButton = this.e;
      this.bSj = 2;
      return;
      this.f.jdField_b_of_type_ComTencentWidgetPatchedButton = this.d;
      this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.setEnabled(bool);
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      return;
    }
  }
  
  public void zg(boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = (wxk)this.f.a(23);
    if ((localObject != null) && ((((wxk)localObject).Ss()) || (this.bgn))) {}
    for (int i = 1;; i = 0)
    {
      if (this.N != null) {
        this.N.end();
      }
      if (this.isHideBottom)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "onClickFunBtn() simple mode fun_btn isSend = " + paramBoolean);
        }
        if (this.bSj == 1)
        {
          this.e.setVisibility(0);
          this.d.setVisibility(8);
          this.f.jdField_b_of_type_ComTencentWidgetPatchedButton = this.e;
          localObject = this.f.jdField_b_of_type_ComTencentWidgetPatchedButton;
          if (!this.bgm) {
            break label209;
          }
        }
      }
      label209:
      for (int k = 2130838285;; k = 2130838286)
      {
        ((PatchedButton)localObject).setBackgroundResource(k);
        this.bSj = 2;
        if (!paramBoolean) {
          break;
        }
        if (i == 0)
        {
          if (this.ak != null) {
            this.ak.setSelected(false);
          }
          if (this.n != null) {
            this.n.setSelected(false);
          }
          this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        }
        return;
      }
      if (!this.bgl) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.bgl = paramBoolean;
        if (this.ak != null) {
          this.ak.setSelected(false);
        }
        if (this.n != null) {
          this.n.setSelected(false);
        }
        this.f.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(this.bgl);
        this.f.k(Integer.valueOf(8));
        return;
      }
    }
  }
  
  public void zh(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "switchAnonymousChat is called! isAnonymousChat = " + paramBoolean);
    }
    this.bgm = paramBoolean;
    Object localObject;
    if ((this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.isHideBottom))
    {
      if (this.ak != null)
      {
        localObject = this.ak;
        if (!paramBoolean) {
          break label136;
        }
        i = 2130838294;
        ((ImageButton)localObject).setBackgroundResource(i);
      }
      if (this.n != null)
      {
        localObject = this.n;
        if (!paramBoolean) {
          break label143;
        }
        i = 2130838213;
        label99:
        ((ImageButton)localObject).setBackgroundResource(i);
      }
      if (this.f.jdField_b_of_type_ComTencentWidgetPatchedButton != null)
      {
        localObject = this.f.jdField_b_of_type_ComTencentWidgetPatchedButton;
        if (!paramBoolean) {
          break label150;
        }
      }
    }
    label136:
    label143:
    label150:
    for (int i = 2130838285;; i = 2130838286)
    {
      ((PatchedButton)localObject).setBackgroundResource(i);
      return;
      i = 2130838295;
      break;
      i = 2130838215;
      break label99;
    }
  }
  
  public void zi(boolean paramBoolean)
  {
    this.bgn = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     www
 * JD-Core Version:    0.7.0.1
 */