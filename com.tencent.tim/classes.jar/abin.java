import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.2;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.3;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.4;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.5;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.6;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class abin
{
  private static boolean bDg = true;
  public abyv.a a;
  public BarrageView a;
  private ApolloTextureView b;
  public boolean bDf;
  public ApolloRender c;
  private ApolloSurfaceView c;
  public ApolloTextureView c;
  private int cpd;
  private volatile boolean mDestroyed;
  
  public abin()
  {
    this.jdField_a_of_type_Abyv$a = new abio(this);
  }
  
  private void cCf()
  {
    ApolloRender localApolloRender = this.jdField_c_of_type_ComTencentMobileqqApolloApolloRender;
    if (localApolloRender != null)
    {
      String str = abuj.m(new File(abxi.bjI + "cm3d.js"));
      if (!TextUtils.isEmpty(str)) {
        localApolloRender.queueRenderTask(new ChatPieApolloViewController.3(this, localApolloRender, str));
      }
      if (!TextUtils.isEmpty(abhh.bfU)) {
        localApolloRender.queueRenderTask(new ChatPieApolloViewController.4(this, localApolloRender));
      }
    }
  }
  
  public void DF(boolean paramBoolean) {}
  
  public void Hk(int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getBottom() - this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getTop() >= paramInt) {
        break label69;
      }
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(4);
    }
    label69:
    do
    {
      for (;;)
      {
        if (this.b != null)
        {
          if (this.b.getBottom() - this.b.getTop() >= paramInt) {
            break;
          }
          this.b.setVisibility(4);
        }
        return;
        if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getVisibility() == 4) {
          this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(0);
        }
      }
    } while (this.b.getVisibility() != 4);
    this.b.setVisibility(0);
  }
  
  public void Hl(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.addRule(2, paramInt);
        this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.requestLayout();
      }
    }
    if (this.b != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.addRule(2, paramInt);
        this.b.requestLayout();
      }
    }
  }
  
  public boolean Yo()
  {
    return (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.b != null);
  }
  
  public ApolloTextureView a()
  {
    return this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView;
  }
  
  public boolean c(BaseChatPie paramBaseChatPie)
  {
    QLog.d("sava_ChatPieApolloViewController", 1, new Object[] { "ifApolloFunAvailThenInit, mApolloSurfaceView:", this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView, ",mApolloTextureView:", this.b });
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramBaseChatPie.sessionInfo == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "chatPie is null");
      return false;
    }
    if ((this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.b != null))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "surfaceview is already inited, return.");
      return false;
    }
    if (!abrj.e(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.cZ, paramBaseChatPie.sessionInfo.aTl)) {
      return false;
    }
    if (!abhh.aV(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Not in white list.");
      }
      return false;
    }
    Object localObject = ((apsw)paramBaseChatPie.app.getManager(48)).a(paramBaseChatPie.sessionInfo.aTl, true);
    if ((localObject != null) && (((apsw.e)localObject).cSk)) {
      return false;
    }
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start TraceReport_total");
    if (QLog.isColorLevel())
    {
      abyy.Df("exeBase");
      abyy.Df("exeCmshow0");
      abyy.Df("exeCommon");
    }
    abyy.Dg("aio_pre");
    int i = abrj.gf(0);
    abwh.bU(i, paramBaseChatPie.sessionInfo.aTl);
    abwh.gN(i, 1);
    abwh.gN(i, 10);
    abwh.b(i, null, new int[] { abwg.a(i, false, 0, paramBaseChatPie.sessionInfo.cZ, false) });
    localObject = (abrg)paramBaseChatPie.app.getManager(249);
    ((abrg)localObject).q(paramBaseChatPie);
    if (abrj.S(paramBaseChatPie.app))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Apollo func is double-hidden.");
      }
      abwh.a(i, 10, 103, new Object[] { "double hidden" });
      return false;
    }
    if (!abrj.f(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.cZ, paramBaseChatPie.sessionInfo.aTl)) {
      return false;
    }
    localObject = ((abrg)localObject).a();
    if (localObject != null) {
      ((SpriteUIHandler)localObject).b(paramBaseChatPie.b, paramBaseChatPie.jdField_a_of_type_Wki);
    }
    if (abvg.c(paramBaseChatPie.app.getCurrentAccountUin(), paramBaseChatPie.app) != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Apollo switch NOT open.");
      }
      paramBaseChatPie.getUIHandler().obtainMessage(62).sendToTarget();
    }
    for (;;)
    {
      return true;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        paramBaseChatPie.bGG();
      } else {
        paramBaseChatPie.getUIHandler().obtainMessage(65).sendToTarget();
      }
    }
  }
  
  public void cCg()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(this.cpd);
    }
    if (this.b != null) {
      this.b.setVisibility(this.cpd);
    }
  }
  
  public void k(BaseChatPie paramBaseChatPie)
  {
    long l = System.currentTimeMillis();
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramBaseChatPie.sessionInfo == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine chatPie is null");
      return;
    }
    if ((this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.b != null))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine surfaceview is already inited, return.");
      return;
    }
    if (paramBaseChatPie.vn() >= 7)
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine aio is finished, not init apollo.");
      return;
    }
    if ((TextUtils.isEmpty(abhh.bfT)) || (TextUtils.isEmpty(abhh.bfU)))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine script empty");
      return;
    }
    if (!abxh.bGf) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil cm3dPreLoad:" + bool);
      if (!bool) {
        break;
      }
      if (abrj.e(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.cZ, paramBaseChatPie.sessionInfo.aTl)) {
        break label184;
      }
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !SpriteUtil.isProperAIO");
      return;
    }
    label184:
    if (!abhh.aV(BaseApplicationImpl.getContext()))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Not in white list.");
      return;
    }
    apsw.e locale = ((apsw)paramBaseChatPie.app.getManager(48)).a(paramBaseChatPie.sessionInfo.aTl, true);
    if ((locale != null) && (locale.cSk))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine isGag");
      return;
    }
    if (abrj.S(paramBaseChatPie.app))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Apollo func is double-hidden.");
      return;
    }
    if (!abrj.f(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.cZ, paramBaseChatPie.sessionInfo.aTl))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !canUseCmShow");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine use:" + (System.currentTimeMillis() - l));
    }
    this.mDestroyed = false;
    ThreadManager.postImmediately(new ChatPieApolloViewController.2(this, paramBaseChatPie), null, false);
  }
  
  @TargetApi(14)
  public void l(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "initApolloSurfaceView");
    }
    if (paramBaseChatPie == null) {}
    int i;
    do
    {
      return;
      i = abrj.gf(0);
      if (paramBaseChatPie.vn() < 7) {
        break;
      }
      abwh.a(i, 10, 106, new Object[] { "aio is finished" });
    } while (!QLog.isColorLevel());
    QLog.d("sava_ChatPieApolloViewController", 2, "aio is finished, not init apollo.");
    return;
    Object localObject = (abht)paramBaseChatPie.app.getManager(227);
    ((abht)localObject).setSessionInfo(paramBaseChatPie.sessionInfo);
    ((abht)localObject).a(((abht)localObject).a);
    if ((this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.b != null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "mApolloSurfaceView is already created");
      return;
    }
    boolean bool1;
    if ((Build.VERSION.SDK_INT >= 26) || (abhh.bCQ))
    {
      bool1 = true;
      label142:
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "initTextureViewConfig initApolloSurfaceView:" + bool1);
      }
      localObject = (abrg)paramBaseChatPie.app.getManager(249);
      abwh.a(i, 10, 0, new Object[] { "cmshow switch done" });
      abwh.gN(i, 100);
      abwh.gN(i, 101);
      abyy.Df("onSurfaceCreated");
      if (!bool1) {
        break label743;
      }
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      try
      {
        this.b = new ApolloTextureView(paramBaseChatPie.mContext, null);
        this.b.setDestroyOnAsync(true);
        this.b.init(paramBaseChatPie.jdField_a_of_type_Acbh, 0, this.jdField_c_of_type_ComTencentMobileqqApolloApolloRender);
        this.b.setDispatchEvent2Native(true);
        this.b.setDumplicateCreateRenderThread(abhh.bCR);
        this.b.getRender().setUseGlobalTimer(true);
        if (paramBaseChatPie.app != null) {
          ((abrg)localObject).b(this.b);
        }
        this.jdField_c_of_type_ComTencentMobileqqApolloApolloRender = null;
        if (abxh.bGd) {
          break label837;
        }
        bool2 = true;
        this.bDf = bool2;
        QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil mPreloadEngine:" + this.bDf);
        if (!this.bDf) {
          break label843;
        }
        abyy.Df("preLoadEngine");
        if ((this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender() != null)) {
          this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().preLoadDirector();
        }
        if ((this.b != null) && (this.b.getRender() != null)) {
          this.b.getRender().preLoadDirector();
        }
        ThreadManager.postImmediately(new ChatPieApolloViewController.5(this, i, paramBaseChatPie, (abrg)localObject), null, false);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        if (!paramBaseChatPie.mActivity.isInMultiWindow()) {
          break label864;
        }
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          if (Build.VERSION.SDK_INT < 11) {
            break label879;
          }
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
            paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
          }
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.aVD = 0;
          if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
          }
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131370537);
        wur localwur = (wur)paramBaseChatPie.a(52);
        if ((localwur == null) || (!localwur.bgd)) {
          break label901;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131377764);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(paramBaseChatPie.mContext);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)((float)aqgz.hL() * 0.171F));
        if ((localwur == null) || (!localwur.bgd)) {
          break label913;
        }
        localLayoutParams.addRule(2, 2131377764);
        paramBaseChatPie.i().addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, localLayoutParams);
        i = abrj.zN();
        if (!bool1) {
          break label925;
        }
        this.b.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        this.b.setInitHeight(i);
        paramBaseChatPie.i().addView(this.b, (ViewGroup.LayoutParams)localObject);
        if (paramBaseChatPie.app == null) {
          break;
        }
        localObject = (abhh)paramBaseChatPie.app.getManager(153);
        if (localObject == null) {
          break;
        }
        ((abhh)localObject).a(paramBaseChatPie.sessionInfo, paramBaseChatPie.mContext);
        return;
      }
      catch (OutOfMemoryError paramBaseChatPie)
      {
        this.b = null;
        this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
        QLog.e("sava_ChatPieApolloViewController", 1, paramBaseChatPie, new Object[0]);
        return;
      }
      bool1 = false;
      break label142;
      label743:
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(paramBaseChatPie.mContext, null, true);
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.mRenderMode = 0;
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(paramBaseChatPie.jdField_a_of_type_Acbh, 0, this.jdField_c_of_type_ComTencentMobileqqApolloApolloRender);
      if (paramBaseChatPie.app != null) {
        ((abrg)localObject).b(this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      }
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().setUseGlobalTimer(true);
      continue;
      label837:
      boolean bool2 = false;
      continue;
      label843:
      ThreadManager.excute(new ChatPieApolloViewController.6(this, paramBaseChatPie, (abrg)localObject), 16, null, false);
      continue;
      label864:
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
      continue;
      label879:
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-wja.dp2px(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
      continue;
      label901:
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369277);
      continue;
      label913:
      localLayoutParams.addRule(2, 2131369277);
      continue;
      label925:
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.setInitHeight(i);
      paramBaseChatPie.i().addView(this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void m(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "addApolloBackView");
    }
    if (paramBaseChatPie == null) {}
    while ((!abhh.Ye()) || (this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView != null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
    if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label274;
      }
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
        paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
      }
      paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.aVD = 0;
      if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
        ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
      }
    }
    localLayoutParams.addRule(6, 2131370537);
    Object localObject1 = (wur)paramBaseChatPie.a(52);
    if ((localObject1 != null) && (((wur)localObject1).bgd)) {
      localLayoutParams.addRule(2, 2131377764);
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.mContext, null);
      localObject1 = new abze(paramBaseChatPie);
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView.init((abja)localObject1);
      if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null) {
        this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback((abiy)localObject1);
      }
      Object localObject2 = (abrg)paramBaseChatPie.app.getManager(249);
      ((abrg)localObject2).a(this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView);
      localObject2 = ((abrg)localObject2).a();
      if (localObject2 != null) {
        ((abze)localObject1).setRenderCallback((abiy)localObject2);
      }
      paramBaseChatPie.i().addView(this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView, 0, localLayoutParams);
      return;
      label274:
      localLayoutParams.bottomMargin = (-wja.dp2px(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
      break;
      localLayoutParams.addRule(2, 2131369277);
    }
  }
  
  public void n(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onResume");
    }
    if (paramBaseChatPie == null) {}
    do
    {
      do
      {
        return;
      } while (paramBaseChatPie.app == null);
      ((abhh)paramBaseChatPie.app.getManager(153)).n(new WeakReference(paramBaseChatPie));
    } while (!Yo());
    ((abrg)paramBaseChatPie.app.getManager(249)).bS(paramBaseChatPie.sessionInfo.cZ, paramBaseChatPie.sessionInfo.aTl);
  }
  
  public void o(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onPause");
    }
    if (paramBaseChatPie == null) {}
    while ((paramBaseChatPie.app == null) || (!Yo())) {
      return;
    }
    ((abrg)paramBaseChatPie.app.getManager(249)).bR(paramBaseChatPie.sessionInfo.cZ, paramBaseChatPie.sessionInfo.aTl);
  }
  
  public void p(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onDestroy ");
    }
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] chatPie:", paramBaseChatPie });
      return;
    }
    abyv.b(this.jdField_a_of_type_Abyv$a);
    this.mDestroyed = true;
    Object localObject = new StringBuilder().append("onDestroy preLoad mApolloRender:");
    boolean bool;
    if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloRender != null)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" mApolloSurfaceView:");
      if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {
        break label212;
      }
      bool = true;
      label103:
      localObject = ((StringBuilder)localObject).append(bool).append(" mApolloTextureView:");
      if (this.b == null) {
        break label217;
      }
      bool = true;
      label124:
      QLog.i("sava_ChatPieApolloViewController", 1, bool);
      if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloRender == null) {
        break label222;
      }
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloRender.queueDestroy();
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloRender = null;
    }
    for (;;)
    {
      ((abrg)paramBaseChatPie.app.getManager(249)).onDestroy();
      if (Yo()) {
        break label271;
      }
      QLog.e("sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(Yo()) });
      return;
      bool = false;
      break;
      label212:
      bool = false;
      break label103;
      label217:
      bool = false;
      break label124;
      label222:
      if (this.b != null)
      {
        localObject = this.b.getRender();
        if (localObject != null) {
          ((ApolloRender)localObject).queueDestroy();
        }
      }
      if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        localObject = this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender();
        if (localObject != null) {
          ((ApolloRender)localObject).queueDestroy();
        }
      }
    }
    label271:
    localObject = (abht)paramBaseChatPie.app.getManager(227);
    ((abht)localObject).setSessionInfo(null);
    ((abht)localObject).a(null);
    localObject = (abhe)paramBaseChatPie.app.getManager(211);
    if (localObject != null) {
      ((abhe)localObject).cBA();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      paramBaseChatPie.i().removeView(this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
    }
    if (this.b != null)
    {
      this.b.setVisibility(8);
      paramBaseChatPie.i().removeView(this.b);
      this.b = null;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      paramBaseChatPie.i().removeView(this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView);
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloTextureView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.destroy();
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      paramBaseChatPie.i().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = null;
    }
    this.cpd = 0;
    abvh.a().onDestroy();
  }
  
  public void resumeRender()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null) && (this.cpd == 0)) {
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().run();
    }
    if ((this.b != null) && (this.b.getRenderImpl() != null) && (this.cpd == 0)) {
      this.b.getRenderImpl().run();
    }
  }
  
  public void setBottomMargin(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = (-paramInt);
        this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.requestLayout();
      }
    }
    if (this.b != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = (-paramInt);
        this.b.requestLayout();
      }
    }
  }
  
  public void stopRender()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null)) {
      this.jdField_c_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().stopLoopDelayed(0L);
    }
    if ((this.b != null) && (this.b.getRenderImpl() != null)) {
      this.b.getRenderImpl().stopLoopDelayed(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abin
 * JD-Core Version:    0.7.0.1
 */