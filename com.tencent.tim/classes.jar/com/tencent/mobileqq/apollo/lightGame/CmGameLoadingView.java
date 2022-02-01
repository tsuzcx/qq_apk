package com.tencent.mobileqq.apollo.lightGame;

import abmt;
import abxi;
import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anpc;
import aqcx;
import auru;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.b;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import mqq.os.MqqHandler;

public class CmGameLoadingView
  extends RelativeLayout
  implements Handler.Callback
{
  private View AJ;
  private TextView PK;
  public TextView PL;
  public TextView PM;
  private ProgressBar X;
  private ProgressTimerTask jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private URLImageView aG;
  private CmGameStartChecker.StartCheckParam jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private ApolloLottieAnim jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private boolean bDV;
  private boolean bDW;
  private final byte[] cL = new byte[0];
  private auru e = new auru(Looper.getMainLooper(), this);
  private float ex;
  public Button fB;
  private volatile boolean isDestroy;
  public DiniFlyAnimationView k;
  public DiniFlyAnimationView l;
  private TextView mGameNameView;
  private volatile float mProgress;
  private int mScreenWidth;
  private float sv;
  private Timer t;
  
  public CmGameLoadingView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CmGameLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CmGameLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static CmGameLoadingView a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return null;
    }
    if (paramBoolean) {}
    for (int i = 2131559011;; i = 2131559012)
    {
      paramContext = (CmGameLoadingView)View.inflate(paramContext, i, null);
      paramContext.initView();
      return paramContext;
    }
  }
  
  private void b(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    Object localObject = "";
    Bundle localBundle = new Bundle();
    if (paramStartCheckParam != null) {
      localObject = paramStartCheckParam.wordingV2;
    }
    if (paramLong == -10L) {
      paramStartCheckParam = acfp.m(2131704115);
    }
    for (;;)
    {
      localBundle.putString("failWording", paramStartCheckParam);
      localBundle.putLong("resultCode", paramLong);
      localObject = this.e.obtainMessage(3);
      ((Message)localObject).obj = localBundle;
      this.e.sendMessage((Message)localObject);
      QLog.e("CmGameLoadingView", 1, new Object[] { "sendGameFailed failed resultCode:", Long.valueOf(paramLong), ",failWording:", paramStartCheckParam });
      return;
      if (paramLong == -12L)
      {
        paramStartCheckParam = acfp.m(2131704114);
      }
      else if (paramLong == -13L)
      {
        paramStartCheckParam = acfp.m(2131704098);
      }
      else if ((paramLong == -15L) || (paramLong == -17L))
      {
        paramStartCheckParam = acfp.m(2131704095);
      }
      else
      {
        paramStartCheckParam = (CmGameStartChecker.StartCheckParam)localObject;
        if (paramLong == -16L) {
          paramStartCheckParam = acfp.m(2131704113);
        }
      }
    }
  }
  
  private void initView()
  {
    QLog.d("CmGameLoadingView", 1, "[initView]");
    this.aG = ((URLImageView)super.findViewById(2131367866));
    this.mGameNameView = ((TextView)super.findViewById(2131367867));
    this.PK = ((TextView)super.findViewById(2131367868));
    this.PK.setVisibility(4);
    this.AJ = super.findViewById(2131368717);
    this.AJ.setVisibility(4);
    this.PL = ((TextView)super.findViewById(2131381118));
    this.PL.setVisibility(4);
    this.fB = ((Button)super.findViewById(2131363845));
    this.fB.setVisibility(4);
    this.X = ((ProgressBar)super.findViewById(2131370132));
    this.PM = ((TextView)super.findViewById(2131381076));
    this.k = ((DiniFlyAnimationView)super.findViewById(2131366093));
    this.l = ((DiniFlyAnimationView)super.findViewById(2131366092));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, super.getContext());
    this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, super.getContext());
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.jP(abxi.bix + "cmgame_loading_progress_lottie/"))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(super.getContext(), this.k, abxi.bix + "cmgame_loading_progress_lottie/", false);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(super.getContext(), this.l, abxi.bix + "cmgame_loading_progress_lottie/bubble/", true);
      this.l.loop(true);
    }
    for (this.bDV = false;; this.bDV = true)
    {
      setProgressViewVisibility(true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(this.k, "https://cmshow.gtimg.cn/client/zip/cmgame_loading_progress_lottie.zip", abxi.bix + "cmgame_loading_progress_lottie.zip", false);
    }
  }
  
  public void C(boolean paramBoolean, long paramLong)
  {
    Message localMessage = this.e.obtainMessage(1);
    if (paramBoolean) {}
    for (;;)
    {
      localMessage.obj = Long.valueOf(paramLong);
      this.e.sendMessage(localMessage);
      return;
      paramLong = -1L;
    }
  }
  
  public void DP(boolean paramBoolean)
  {
    if (paramBoolean) {
      setPeriodAnimationEnd(0.85F);
    }
    for (;;)
    {
      q(50, 1.0F);
      return;
      setPeriodAnimationEnd(0.95F);
    }
  }
  
  public void a(int paramInt, CmGameStartChecker paramCmGameStartChecker)
  {
    ThreadManager.getUIHandler().post(new CmGameLoadingView.1(this, paramInt, paramCmGameStartChecker));
  }
  
  public void a(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    setPeriodAnimationEnd(0.15F);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess))
    {
      q(4000, 0.85F);
      return;
    }
    q(1500, 0.85F);
  }
  
  public void aB(float paramFloat)
  {
    if ((this.bDV) || (this.bDW)) {}
    do
    {
      return;
      if (this.k.getVisibility() != 0)
      {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
      }
    } while (paramFloat <= this.ex);
    setProgressBubbleParams(paramFloat);
    this.k.setProgress(paramFloat);
    this.PM.setText(String.format("%d%%", new Object[] { Integer.valueOf((int)Math.ceil(100.0F * paramFloat)) }));
    if (this.PM.getVisibility() != 0) {
      this.PM.setVisibility(0);
    }
    this.ex = paramFloat;
  }
  
  public void aFu()
  {
    synchronized (this.cL)
    {
      if (this.t != null)
      {
        this.t.cancel();
        this.t = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask.cancel();
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask = null;
      }
      return;
    }
  }
  
  public void cDf()
  {
    setPeriodAnimationEnd(0.85F);
    q(150, 0.95F);
  }
  
  public void cDg()
  {
    setPeriodAnimationEnd(0.95F);
    q(60, 1.0F);
  }
  
  public void e(float paramFloat, int paramInt)
  {
    if ((this.t == null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask == null)) {
      synchronized (this.cL)
      {
        this.t = new Timer();
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask = new ProgressTimerTask(paramFloat);
        this.t.schedule(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask, 0L, paramInt);
        return;
      }
    }
    aFu();
    QLog.e("CmGameLoadingView", 1, "timer is not end");
  }
  
  public void f(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    Object localObject3 = null;
    QLog.d("CmGameLoadingView", 1, "[updateGameInfo]");
    if (paramStartCheckParam == null)
    {
      QLog.e("CmGameLoadingView", 1, "[initView] startCheckParam null");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    Object localObject1 = super.getResources().getDisplayMetrics();
    int i;
    Resources localResources;
    if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode > 0) {
      if (((DisplayMetrics)localObject1).heightPixels > ((DisplayMetrics)localObject1).widthPixels)
      {
        i = ((DisplayMetrics)localObject1).heightPixels;
        this.mScreenWidth = i;
        setProgressBubbleParams(0.0F);
        localResources = super.getResources();
        if (paramStartCheckParam.game == null) {
          break label359;
        }
      }
    }
    label180:
    label208:
    label347:
    label359:
    for (localObject1 = paramStartCheckParam.game.logoUrl;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = String.format(Locale.getDefault(), "https://i.hudongcdn.com/%1$d/sp_main_1_1.png", new Object[] { Integer.valueOf(paramStartCheckParam.gameId) });
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localResources.getDrawable(2130838600);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localResources.getDrawable(2130838600);
        this.aG.setImageDrawable(URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1));
        if ((paramStartCheckParam.game == null) || (TextUtils.isEmpty(paramStartCheckParam.game.name))) {
          break label326;
        }
        localObject1 = paramStartCheckParam.game.name;
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = localResources.getString(2131690694);
        }
        this.mGameNameView.setText((CharSequence)localObject2);
        if ((paramStartCheckParam.game == null) || (!paramStartCheckParam.game.isFeatured)) {
          break label347;
        }
        this.AJ.setVisibility(0);
      }
      for (;;)
      {
        q(700, 0.15F);
        return;
        i = ((DisplayMetrics)localObject1).widthPixels;
        break;
        if (((DisplayMetrics)localObject1).heightPixels < ((DisplayMetrics)localObject1).widthPixels) {}
        for (i = ((DisplayMetrics)localObject1).heightPixels;; i = ((DisplayMetrics)localObject1).widthPixels)
        {
          this.mScreenWidth = i;
          break;
        }
        this.aG.setImageResource(2130838600);
        break label180;
        localObject1 = localObject3;
        if (TextUtils.isEmpty(paramStartCheckParam.gameName)) {
          break label208;
        }
        localObject1 = paramStartCheckParam.gameName;
        break label208;
        this.AJ.setVisibility(8);
      }
    }
  }
  
  public void g(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    Message localMessage = this.e.obtainMessage(2);
    localMessage.obj = paramStartCheckParam;
    this.e.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        return false;
        l1 = ((Long)paramMessage.obj).longValue();
        if (l1 > 0L)
        {
          if (this.PK != null)
          {
            paramMessage = String.valueOf(l1) + acfp.m(2131704099);
            if (l1 > 9999L) {
              paramMessage = String.valueOf(l1 / 10000L) + acfp.m(2131704105);
            }
            this.PK.setVisibility(0);
            this.PK.setText(paramMessage);
          }
        }
        else if (this.PK != null)
        {
          this.PK.setVisibility(4);
          continue;
          if (paramMessage.obj != null) {
            f((CmGameStartChecker.StartCheckParam)paramMessage.obj);
          }
        }
      }
    case 3: 
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null)
      {
        localObject = paramMessage.getString("failWording");
        l1 = paramMessage.getLong("resultCode");
      }
      break;
    }
    for (;;)
    {
      paramMessage = (Message)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramMessage = acfp.m(2131704092);
      }
      localObject = paramMessage;
      if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
        if (this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr) {
          break label481;
        }
      }
      label481:
      for (localObject = paramMessage;; localObject = paramMessage + acfp.m(2131704108) + l1)
      {
        abmt.x(new Object[] { "[game failed] ", localObject });
        setProgressViewVisibility(false);
        this.fB.setVisibility(8);
        if (this.PL != null)
        {
          this.PL.setText((CharSequence)localObject);
          this.PL.setVisibility(0);
        }
        paramMessage = abmt.getAppInterface();
        if ((this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (paramMessage == null)) {
          break;
        }
        localObject = new HashMap();
        ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
        ((HashMap)localObject).put("param_Result", "0");
        ((HashMap)localObject).put("param_FailCode", String.valueOf(l1));
        anpc.a(paramMessage.getApp()).collectPerformance(paramMessage.getCurrentAccountUin(), "cmgame_launch_result", false, 0L, 0L, (HashMap)localObject, "", false);
        QLog.d("CmGameStat", 1, new Object[] { "cmgame_launch_result, failed", " [gameId=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), ", failCode=", Long.valueOf(l1), "]" });
        abmt.a(paramMessage, 1, 1, this.jdField_b_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, l1, null);
        break;
      }
      int i = ((Integer)paramMessage.obj).intValue();
      if (i >= 99)
      {
        setPeriodAnimationEnd(0.65F);
        break;
      }
      this.mProgress = (i / 200.0F + this.sv);
      aB(this.mProgress);
      break;
      aB(((Float)paramMessage.obj).floatValue());
      break;
      l1 = 0L;
      localObject = null;
    }
  }
  
  public void onDestroy()
  {
    aFu();
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.destroy();
    this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.destroy();
    this.mProgress = 0.0F;
    this.isDestroy = true;
  }
  
  public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.b paramb, long paramLong)
  {
    this.e.post(new CmGameLoadingView.2(this, paramStartCheckParam, paramLong, paramb));
  }
  
  public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt >= 100) {
        i = 99;
      }
      paramStartCheckParam = this.e.obtainMessage(4);
      paramStartCheckParam.obj = Integer.valueOf(i);
      this.e.removeMessages(4);
      this.e.sendMessage(paramStartCheckParam);
      return;
    }
  }
  
  public void onGameFailed(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    b(paramStartCheckParam, paramLong);
  }
  
  public void q(int paramInt, float paramFloat)
  {
    if ((paramFloat > this.sv) && (paramFloat > this.mProgress))
    {
      paramInt = (int)(paramInt / ((paramFloat - this.sv) / 0.01F));
      if (paramInt > 0)
      {
        e(paramFloat, paramInt);
        this.sv = paramFloat;
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      QLog.e("CmGameLoadingView", 1, "IllegalArgumentException Non-positive period.");
      return;
    }
    QLog.d("CmGameLoadingView", 2, new Object[] { "autoPlayPeriodAnimation endProgress:", Float.valueOf(paramFloat), ", mLastPeriodEndProgress:", Float.valueOf(this.sv), ", mProgress:", Float.valueOf(this.mProgress) });
  }
  
  public void setPeriodAnimationEnd(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameLoadingView", 2, new Object[] { "setPeriodAnimationEnd endProgress:", Float.valueOf(paramFloat), ", cur progress:", Float.valueOf(this.mProgress) });
    }
    if (paramFloat > this.mProgress)
    {
      aFu();
      Message localMessage = this.e.obtainMessage(5);
      localMessage.obj = Float.valueOf(paramFloat);
      this.e.removeMessages(5);
      this.e.sendMessage(localMessage);
      this.sv = paramFloat;
    }
  }
  
  public void setProgressBubbleParams(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
    localLayoutParams.leftMargin = (this.mScreenWidth / 2 - aqcx.dip2px(super.getContext(), 62.0F) + (int)(aqcx.dip2px(super.getContext(), 110.0F) * paramFloat));
    this.l.setLayoutParams(localLayoutParams);
  }
  
  public void setProgressViewVisibility(boolean paramBoolean)
  {
    int i = 0;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      this.bDW = bool;
      if (!paramBoolean) {
        break label65;
      }
    }
    for (;;)
    {
      if (!this.bDV) {
        break label71;
      }
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      this.PM.setVisibility(8);
      this.X.setVisibility(i);
      return;
      bool = false;
      break;
      label65:
      i = 8;
    }
    label71:
    this.X.setVisibility(8);
    this.k.setVisibility(i);
    this.l.setVisibility(i);
    this.PM.setVisibility(i);
  }
  
  public class ProgressTimerTask
    extends TimerTask
  {
    private float sw;
    
    public ProgressTimerTask(float paramFloat)
    {
      this.sw = paramFloat;
    }
    
    public void run()
    {
      CmGameLoadingView.a(CmGameLoadingView.this, CmGameLoadingView.a(CmGameLoadingView.this) + 0.01F);
      if ((CmGameLoadingView.a(CmGameLoadingView.this) > this.sw) || (CmGameLoadingView.a(CmGameLoadingView.this)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameLoadingView", 2, new Object[] { "ProgressTimerTask progress has arrival end:", Float.valueOf(this.sw) });
        }
        CmGameLoadingView.this.aFu();
        return;
      }
      Message localMessage = CmGameLoadingView.a(CmGameLoadingView.this).obtainMessage(5);
      localMessage.obj = Float.valueOf(CmGameLoadingView.a(CmGameLoadingView.this));
      CmGameLoadingView.a(CmGameLoadingView.this).removeMessages(5);
      CmGameLoadingView.a(CmGameLoadingView.this).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView
 * JD-Core Version:    0.7.0.1
 */