package com.tencent.mobileqq.apollo.process.ui.framework;

import ablp;
import ablw;
import abmt;
import abos;
import abqh;
import abqi;
import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import auru;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class QzoneGameFloatView
  extends FrameworkView
  implements View.OnClickListener
{
  public View AM;
  public View AN;
  public View AO;
  public View AP;
  public View AQ;
  public View AR;
  public View AS;
  public Hole a;
  private boolean bEH;
  private boolean bEI;
  private boolean bEJ = true;
  public View lY;
  public int mScreenHeight;
  public int mScreenWidth;
  public View mask;
  
  public QzoneGameFloatView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext, paramStartCheckParam);
    paramContext = LayoutInflater.from(paramContext);
    if (paramStartCheckParam.mGameType == 5) {}
    for (int i = 2131560159;; i = 2131560160)
    {
      paramContext = (FrameLayout)paramContext.inflate(i, null);
      this.mask = bO();
      if (paramStartCheckParam.mGameType == 5)
      {
        this.bEH = true;
        this.bEI = true;
        setFrameViewStyle(paramStartCheckParam);
      }
      a(paramContext, this);
      RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)this.mActivityRef.get()).findViewById(2131377555);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      addView(paramContext, localLayoutParams);
      if (paramStartCheckParam.mGameType == 5)
      {
        ma();
        if ((this.AR != null) && (this.AR.getVisibility() == 0)) {
          this.AR.setVisibility(8);
        }
      }
      setBackgroundColor(0);
      localRelativeLayout.addView(this.mask);
      localRelativeLayout.addView(this, localLayoutParams);
      return;
    }
  }
  
  private View bO()
  {
    View localView = new View((Context)this.mActivityRef.get());
    localView.setId(2131371159);
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localView.setBackgroundColor(1996488704);
    localView.setVisibility(8);
    return localView;
  }
  
  private void ma()
  {
    if ((this.lY != null) && ((this.lY instanceof TextView)) && (this.bEJ))
    {
      ((TextView)this.lY).setCompoundDrawablesWithIntrinsicBounds(0, 2130843475, 0, 0);
      ((TextView)this.lY).setTextColor(getResources().getColor(2131167488));
    }
    if ((this.AR != null) && ((this.AR instanceof TextView)))
    {
      ((TextView)this.AR).setCompoundDrawablesWithIntrinsicBounds(0, 2130843472, 0, 0);
      ((TextView)this.AR).setTextColor(getResources().getColor(2131167488));
    }
    if ((this.AQ != null) && ((this.AQ instanceof TextView)))
    {
      ((TextView)this.AQ).setCompoundDrawablesWithIntrinsicBounds(0, 2130843466, 0, 0);
      ((TextView)this.AQ).setTextColor(getResources().getColor(2131167488));
    }
    if ((this.AP != null) && ((this.AP instanceof TextView)))
    {
      ((TextView)this.AP).setCompoundDrawablesWithIntrinsicBounds(0, 2130843463, 0, 0);
      ((TextView)this.AP).setTextColor(getResources().getColor(2131167488));
    }
    if ((this.AM != null) && ((this.AM instanceof Button))) {
      this.AM.setBackgroundResource(2130843468);
    }
  }
  
  @TargetApi(16)
  public void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    int i;
    if (this.b.viewMode > 0) {
      if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels)
      {
        i = localDisplayMetrics.heightPixels;
        this.mScreenWidth = i;
        if (localDisplayMetrics.heightPixels <= localDisplayMetrics.widthPixels) {
          break label375;
        }
        i = localDisplayMetrics.widthPixels;
        label64:
        this.mScreenHeight = i;
        this.AM = paramView.findViewById(2131367230);
        this.AO = paramView.findViewById(2131379710);
        this.AN = paramView.findViewById(2131363712);
        this.AP = paramView.findViewById(2131366571);
        this.lY = paramView.findViewById(2131378168);
        this.AR = paramView.findViewById(2131378017);
        this.AS = paramView.findViewById(2131371927);
        this.AQ = paramView.findViewById(2131367362);
        this.jdField_a_of_type_ComTencentBizWebviewpluginHole = ((Hole)paramView.findViewById(2131368554));
        cEj();
        this.AR.setVisibility(0);
        this.AQ.setVisibility(0);
        if (!this.bEJ) {
          break label453;
        }
        this.lY.setVisibility(0);
        label197:
        this.AP.setVisibility(0);
        this.AM.setVisibility(0);
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("secondHandSharePre", 0);
        if ((!localSharedPreferences.getBoolean("first_float_tip", true)) || (this.bEI)) {
          break label465;
        }
        this.AO.setVisibility(0);
        localSharedPreferences.edit().putBoolean("first_float_tip", false).apply();
        paramView.getViewTreeObserver().addOnGlobalLayoutListener(new abqh(this, paramView, localDisplayMetrics));
      }
    }
    for (;;)
    {
      paramView = new abqi(this, localDisplayMetrics);
      this.AP.setOnClickListener(paramOnClickListener);
      this.lY.setOnClickListener(paramOnClickListener);
      this.AS.setOnClickListener(paramOnClickListener);
      this.AR.setOnClickListener(paramOnClickListener);
      this.AQ.setOnClickListener(paramOnClickListener);
      this.AM.setOnTouchListener(paramView);
      this.AO.setOnTouchListener(paramView);
      this.mask.setOnTouchListener(paramView);
      return;
      i = localDisplayMetrics.widthPixels;
      break;
      label375:
      i = localDisplayMetrics.heightPixels;
      break label64;
      if (localDisplayMetrics.heightPixels < localDisplayMetrics.widthPixels)
      {
        i = localDisplayMetrics.heightPixels;
        label403:
        this.mScreenWidth = i;
        if (localDisplayMetrics.heightPixels >= localDisplayMetrics.widthPixels) {
          break label444;
        }
      }
      label444:
      for (i = localDisplayMetrics.widthPixels;; i = localDisplayMetrics.heightPixels)
      {
        this.mScreenHeight = i;
        break;
        i = localDisplayMetrics.widthPixels;
        break label403;
      }
      label453:
      this.lY.setVisibility(8);
      break label197;
      label465:
      this.AO.setVisibility(8);
    }
  }
  
  public void cEh()
  {
    this.AM.setEnabled(false);
  }
  
  public void cEj()
  {
    cEk();
  }
  
  public void cEk()
  {
    int i = this.mScreenHeight;
    int j = this.mScreenWidth;
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.AM.getLayoutParams();
    localLayoutParams.leftMargin = ((int)(j - localDisplayMetrics.density * 70.0F));
    localLayoutParams.topMargin = (i / 2 - this.AM.getWidth() / 2);
    this.AM.setLayoutParams(localLayoutParams);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.AP) {
      if ((this.jdField_a_of_type_Abos == null) || (!this.jdField_a_of_type_Abos.YM()))
      {
        QLog.d("cmframe_QzoneGameFloatView", 1, "game not running, finish");
        ((Activity)this.mActivityRef.get()).finish();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("cmframe_QzoneGameFloatView", 1, "notify game");
      if (!YW())
      {
        if (this.jdField_a_of_type_Ablw != null) {
          this.jdField_a_of_type_Ablw.cCT();
        }
        this.jdField_a_of_type_Abos.cDH();
        if ((this.b == null) || ((this.b.commFlag & 0x1) == 0)) {
          this.e.sendEmptyMessageDelayed(102, 1000L);
        }
      }
      for (;;)
      {
        if (this.b == null) {
          break label204;
        }
        abmt.b(abmt.getAppInterface(), ablp.a(0, 0, 3, 901003004, this.b.gameId, this.b.src));
        break;
        this.e.sendEmptyMessageDelayed(102, 5000L);
        QLog.i("cmframe_QzoneGameFloatView", 1, "comm flag bit0 is 1.");
        continue;
        this.e.sendEmptyMessage(111);
      }
      label204:
      continue;
      if (paramView == this.lY)
      {
        if ((this.bEI) && (!this.bEJ)) {
          QQToast.a(getContext(), 0, acfp.m(2131713114), 0).show();
        } else if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.YO())) {
          QLog.e("cmframe_QzoneGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
        } else if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.YM()) && (this.b != null)) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("gameId", this.b.gameId);
            localJSONObject.put("isSelectFriend", 1);
            localJSONObject.put("gameMode", this.b.gameMode);
            localJSONObject.put("roomId", this.b.roomId);
            this.jdField_a_of_type_Abos.Cz(localJSONObject.toString());
            if (this.jdField_a_of_type_Ablw != null) {
              this.jdField_a_of_type_Ablw.cCU();
            }
            if (this.b == null) {
              continue;
            }
            abmt.b(abmt.getAppInterface(), ablp.a(0, 0, 3, 901003002, this.b.gameId, this.b.src));
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("cmframe_QzoneGameFloatView", 1, "share game error, e=", localException);
            }
          }
        }
      }
      else if (paramView == this.AQ)
      {
        if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.YO()))
        {
          QLog.e("cmframe_QzoneGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
        }
        else
        {
          if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.YM()))
          {
            caS();
            QLog.d("cmframe_QzoneGameFloatView", 1, "pack up game");
            if (this.jdField_a_of_type_Ablw != null) {
              this.jdField_a_of_type_Ablw.cCV();
            }
            if (this.b != null) {
              abmt.b(abmt.getAppInterface(), ablp.a(0, 0, 3, 901003003, this.b.gameId, this.b.src));
            }
          }
          for (;;)
          {
            if ((this.b == null) || (this.b.enter == 0) || (this.b.enter == 1) || (this.b.enter != 7)) {
              break label625;
            }
            break;
            ((Activity)this.mActivityRef.get()).finish();
          }
        }
      }
      else {
        label625:
        if ((paramView == this.AR) && (this.b != null)) {
          if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.YO())) {
            QLog.e("cmframe_QzoneGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
          } else {
            ApolloGameUtil.bW(this.b.gameId, null);
          }
        }
      }
    }
  }
  
  public void resetView()
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    this.mScreenWidth = localDisplayMetrics.widthPixels;
    this.mScreenHeight = localDisplayMetrics.heightPixels;
    cEk();
  }
  
  public void setFloatBtnBackground(View paramView, boolean paramBoolean)
  {
    if (!this.bEH) {
      paramView.setBackgroundResource(2130843470);
    }
  }
  
  public void setFloatingShareVisible(boolean paramBoolean)
  {
    View localView;
    if (this.lY != null)
    {
      localView = this.lY;
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      if ((!paramBoolean) && (this.AM != null) && ((this.AM.getVisibility() == 8) || (this.AM.getVisibility() == 4))) {
        this.AM.setVisibility(0);
      }
      return;
    }
  }
  
  public void setFrameViewStyle(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam != null) {}
    try
    {
      String str = paramStartCheckParam.extInfoFromSvr;
      if (str != null)
      {
        int i = new JSONObject(str).optInt("needShowShare", 1);
        ThreadManagerV2.getUIHandlerV2().post(new QzoneGameFloatView.1(this, i, paramStartCheckParam));
      }
      return;
    }
    catch (Throwable paramStartCheckParam)
    {
      QLog.e("cmframe_QzoneGameFloatView", 1, paramStartCheckParam, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView
 * JD-Core Version:    0.7.0.1
 */