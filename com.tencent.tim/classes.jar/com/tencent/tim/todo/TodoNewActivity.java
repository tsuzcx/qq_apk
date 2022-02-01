package com.tencent.tim.todo;

import aalb;
import ahgq;
import anbk;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anpc;
import aqha;
import aqiw;
import aqju;
import aunu;
import auol;
import auom;
import auon;
import auoo;
import auop;
import auoq;
import auos;
import auot;
import auou;
import auow;
import auox;
import auoy;
import auoz;
import aupa;
import aupb;
import aupc;
import aupd;
import aupe;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.data.TodoInfo;
import com.tencent.tim.widget.IphonePickerView;
import com.tencent.tim.widget.IphonePickerView.d;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TodoNewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final String TAG = TodoNewActivity.class.getSimpleName();
  public static int erP = 600;
  private ImageView Hf;
  private aupd jdField_a_of_type_Aupd = new auos(this);
  private a jdField_a_of_type_ComTencentTimTodoTodoNewActivity$a;
  private IphonePickerView jdField_a_of_type_ComTencentTimWidgetIphonePickerView;
  private TextView afA;
  private TextView afB;
  private TextView afC;
  private TextView afx;
  private TextView afy;
  private TextView afz;
  boolean allowClick = true;
  private TodoInfo b;
  private long cC;
  private String cIJ = "";
  private boolean djl;
  private boolean djm;
  public boolean djn = true;
  private boolean djo;
  private boolean djp;
  private boolean djq;
  private boolean djr;
  private boolean djs;
  private RelativeLayout el;
  private int erQ = 0;
  private aqju mDialog;
  private EditText mEditText;
  private int mMode;
  private RelativeLayout mRootView;
  private RelativeLayout nD;
  private RelativeLayout nE;
  private TextView ut;
  
  private void VU(boolean paramBoolean)
  {
    if (this.djo) {
      return;
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.getVisibility() != 0)) {}
    for (TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.getMeasuredHeight(), 0.0F);; localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.getMeasuredHeight()))
    {
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localTranslateAnimation.setAnimationListener(new auom(this, paramBoolean));
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.startAnimation(localTranslateAnimation);
      return;
      if ((paramBoolean) || (this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.getVisibility() != 0)) {
        break;
      }
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setInterpolator(new DecelerateInterpolator(2.0F));
    localValueAnimator.addUpdateListener(new auon(this));
    if (paramAnimatorListener != null) {
      localValueAnimator.addListener(paramAnimatorListener);
    }
    localValueAnimator.setDuration(200L);
    localValueAnimator.start();
  }
  
  private boolean aJv()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.cIJ != null)
    {
      bool1 = bool2;
      if (this.b != null) {
        if (this.cIJ.equals(this.b.content))
        {
          bool1 = bool2;
          if (this.cC == this.b.remindTime) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean aJw()
  {
    if ((this.b == null) || (TextUtils.isEmpty(this.cIJ)))
    {
      showToast("待办修改失败，请稍后重试。");
      return false;
    }
    if ((this.mMode != 2) && (this.cC > 0L) && (this.cC <= NetConnInfoCenter.getServerTimeMillis()))
    {
      showToast("保存失败，提醒时间需晚于当前时间。");
      return false;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      showToast("当前网络不可用，请检查你的网络设置。");
      return false;
    }
    if (this.mMode != 2)
    {
      this.b.content = this.cIJ;
      this.b.remindTime = this.cC;
    }
    return true;
  }
  
  private void aaU(int paramInt)
  {
    this.mEditText = ((EditText)findViewById(2131379970));
    this.mEditText.setCursorVisible(false);
    this.mEditText.setOnFocusChangeListener(new auoy(this));
    this.mEditText.addTextChangedListener(new auoz(this, paramInt));
  }
  
  private void aaV(int paramInt)
  {
    if (aJw()) {
      ((aunu)this.app.getBusinessHandler(181)).a(paramInt, this.b);
    }
  }
  
  private void c(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    int j = 255;
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean) {
        break label98;
      }
    }
    for (;;)
    {
      int k = this.el.getMeasuredHeight();
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, j });
      localValueAnimator.addUpdateListener(new auow(this, paramBoolean, k));
      localValueAnimator.setInterpolator(new DecelerateInterpolator());
      if (paramAnimatorListener != null) {
        localValueAnimator.addListener(paramAnimatorListener);
      }
      localValueAnimator.setDuration(300L).start();
      return;
      i = 255;
      break;
      label98:
      j = 0;
    }
  }
  
  private void cFc()
  {
    this.nE = ((RelativeLayout)findViewById(2131380027));
    this.afz = ((TextView)findViewById(2131377644));
    this.afB = ((TextView)findViewById(2131364677));
    this.afB.setOnClickListener(this);
    evR();
    aaU((int)(180.0F * getResources().getDisplayMetrics().density));
    evW();
  }
  
  private void evQ()
  {
    this.mEditText.setClickable(false);
    this.mEditText.setFocusable(false);
    this.mEditText.setFocusableInTouchMode(false);
    this.afx.setClickable(false);
    this.afx.setTextColor(getResources().getColor(2131167614));
    this.afx.setCompoundDrawablesWithIntrinsicBounds(2130851656, 0, 0, 0);
    this.afz.setVisibility(8);
    this.afz.setClickable(false);
  }
  
  private void evR()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.afB.getLayoutParams();
    if ((this.mMode == 2) || (this.mMode == 3)) {
      localLayoutParams.addRule(11, 2131380027);
    }
    for (;;)
    {
      this.afB.setLayoutParams(localLayoutParams);
      this.nE.updateViewLayout(this.afB, localLayoutParams);
      return;
      localLayoutParams.addRule(9, 2131380027);
    }
  }
  
  private void evS()
  {
    this.afz.setVisibility(0);
    this.afz.setOnClickListener(this);
    evU();
  }
  
  private void evT()
  {
    this.mEditText.requestFocus();
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.mEditText, 2);
  }
  
  private void evU()
  {
    if ((TextUtils.isEmpty(this.cIJ)) || ((this.mMode == 1) && (!aJv())))
    {
      this.afz.setTextColor(getResources().getColor(2131167614));
      this.afz.setClickable(false);
      return;
    }
    this.afz.setTextColor(getResources().getColorStateList(2131167581));
    this.afz.setClickable(true);
  }
  
  private void evV()
  {
    if ((this.b != null) && ((this.b.fromUin != 0L) || (this.b.c2cTempUin != 0L)))
    {
      String str = aupe.a(this.b, this.app, this);
      if (!TextUtils.isEmpty(str))
      {
        str = String.format(getResources().getString(2131721210), new Object[] { str });
        this.afy = ((TextView)findViewById(2131367738));
        this.afy.setVisibility(0);
        this.afy.setText(str);
        this.afy.setOnClickListener(this);
      }
    }
  }
  
  private void evW()
  {
    this.afx = ((TextView)findViewById(2131377119));
    Button localButton;
    if ((this.b != null) && (this.b.remindTime != 0L))
    {
      this.afx.setCompoundDrawablesWithIntrinsicBounds(2130851748, 0, 0, 0);
      this.afx.setOnClickListener(new aupa(this));
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView = ((IphonePickerView)findViewById(2131379688));
      this.jdField_a_of_type_ComTencentTimTodoTodoNewActivity$a = new a();
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentTimTodoTodoNewActivity$a);
      this.jdField_a_of_type_ComTencentTimTodoTodoNewActivity$a.a(this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView);
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.setGravity(0, 5);
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.setMaxSkew(0, -0.3F);
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.setMaxSkew(1, 0.3F);
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.setMaxSkew(2, 0.3F);
      this.jdField_a_of_type_ComTencentTimTodoTodoNewActivity$a.nw(NetConnInfoCenter.getServerTimeMillis() + 1800000L);
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.setPickListener(new aupb(this));
      localButton = (Button)this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.findViewById(2131364221);
      if (this.cC == 0L) {
        break label272;
      }
    }
    label272:
    for (String str = "删除提醒";; str = "取消")
    {
      localButton.setText(str);
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.findViewById(2131379693).setOnClickListener(new aupc(this, localButton));
      localButton.setOnClickListener(new auol(this, localButton));
      this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.setBackgroundColor(-1);
      return;
      this.afx.setCompoundDrawablesWithIntrinsicBounds(2130851727, 0, 0, 0);
      break;
    }
  }
  
  private void evX()
  {
    this.nD = ((RelativeLayout)findViewById(2131372708));
    this.nD.setVisibility(0);
    this.afA = ((TextView)findViewById(2131365706));
    this.ut = ((TextView)findViewById(2131379967));
    this.Hf = ((ImageView)findViewById(2131379968));
    this.ut.setOnClickListener(this);
    this.Hf.setOnClickListener(this);
  }
  
  private void evY()
  {
    if ((this.erQ == 1) || (this.erQ == 3)) {}
    do
    {
      return;
      if (this.erQ == 0)
      {
        a(0.0F, 1.0F, new auop(this));
        aupe.L(this.app, "0X80091CE", 1);
        return;
      }
    } while (this.erQ != 2);
    AnimationSet localAnimationSet = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, this.nD.getLeft() + this.nD.getWidth() / 2, this.nD.getTop() + this.nD.getHeight() / 2);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setDuration(200L);
    localAnimationSet.setInterpolator(new AccelerateInterpolator());
    localAnimationSet.setAnimationListener(new auoq(this));
    this.el.startAnimation(localAnimationSet);
    ewa();
    aupe.L(this.app, "0X800923A", 1);
  }
  
  private void evZ()
  {
    if (aJw()) {
      ((aunu)this.app.getBusinessHandler(181)).b(this.b.todoId, 1, this.b.content, this.b.remindTime);
    }
  }
  
  private void ewa()
  {
    if ((this.b == null) || (TextUtils.isEmpty(this.b.todoId)))
    {
      showToast("删除失败，请稍后重试。");
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      showToast("当前网络不可用，请检查你的网络设置");
      return;
    }
    anpc.report("tim_mine_tab_remain_click_delete_remain_click");
    ((aunu)this.app.getBusinessHandler(181)).gR(this.b.todoId, this.b.status);
  }
  
  private void ewb()
  {
    if (this.mDialog == null) {
      this.mDialog = aqha.a(this, 230).setTitle("是否放弃对待办的修改?").setPositiveButton(getString(2131694830), new auou(this)).setNegativeButton(getString(2131694891), new auot(this));
    }
    this.mDialog.show();
  }
  
  private void ie()
  {
    if ((this.b != null) && (this.b.content != null))
    {
      this.mEditText.setText(this.b.content);
      if ((this.mMode == 4) && (this.mEditText != null) && (this.mEditText.getText() != null)) {
        this.mEditText.setSelection(this.mEditText.getText().toString().length());
      }
      if (this.b.remindTime == 0L) {
        break label156;
      }
      if ((this.mMode == 1) || (this.mMode == 2) || (this.mMode == 3))
      {
        this.afx.setText(aupe.cm(this.b.remindTime));
        this.jdField_a_of_type_ComTencentTimTodoTodoNewActivity$a.nw(this.b.remindTime);
      }
    }
    label156:
    while ((this.mMode != 2) && (this.mMode != 3))
    {
      return;
      this.mEditText.setText("");
      break;
    }
    this.afx.setText(getResources().getString(2131721216));
  }
  
  private void parseIntent()
  {
    this.mMode = getIntent().getIntExtra("param_mode", 0);
    this.b = ((TodoInfo)getIntent().getParcelableExtra("todoinfo"));
    this.djl = getIntent().getBooleanExtra("is_from_self", false);
    this.djm = getIntent().getBooleanExtra("has_added_todo", false);
    if (this.b == null) {
      this.b = new TodoInfo();
    }
    this.cC = this.b.remindTime;
  }
  
  private void showToast(String paramString)
  {
    QQToast.a(this, paramString, 0).show((int)getResources().getDimension(2131299627));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject;
    float f1;
    float f2;
    if ((paramMotionEvent.getAction() == 0) || (1 == paramMotionEvent.getAction()))
    {
      localObject = getWindow().getCurrentFocus();
      if ((localObject != null) && (this.mEditText != null) && (localObject == this.mEditText))
      {
        int[] arrayOfInt = new int[2];
        this.mEditText.getLocationOnScreen(arrayOfInt);
        f1 = paramMotionEvent.getRawX() - (arrayOfInt[0] - this.mEditText.getLeft());
        f2 = paramMotionEvent.getRawY() - (arrayOfInt[1] - this.mEditText.getTop());
        if ((f1 <= this.mEditText.getLeft()) || (f1 >= this.mEditText.getRight()) || (f2 <= this.mEditText.getTop()) || (f2 >= this.mEditText.getBottom())) {
          break label516;
        }
      }
    }
    label308:
    label477:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (paramMotionEvent.getAction() == 0) {
          this.djp = true;
        }
      }
      else if ((this.erQ == 2) && (this.ut != null))
      {
        localObject = new int[2];
        this.ut.getLocationOnScreen((int[])localObject);
        f1 = paramMotionEvent.getRawX() - (localObject[0] - this.ut.getLeft());
        f2 = paramMotionEvent.getRawY() - (localObject[1] - this.ut.getTop());
        if ((f1 <= this.ut.getLeft()) || (f1 >= this.ut.getRight()) || (f2 <= this.ut.getTop()) || (f2 >= this.ut.getBottom())) {
          break label510;
        }
      }
      label354:
      label492:
      label510:
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          if (paramMotionEvent.getAction() == 0) {
            this.djq = true;
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView != null)
          {
            localObject = new int[2];
            this.jdField_a_of_type_ComTencentTimWidgetIphonePickerView.getLocationOnScreen((int[])localObject);
            if (paramMotionEvent.getRawY() < localObject[1])
            {
              if (paramMotionEvent.getAction() != 0) {
                break label477;
              }
              this.djr = true;
            }
          }
          if (paramMotionEvent.getY() < this.el.getTop())
          {
            if (paramMotionEvent.getAction() != 0) {
              break label492;
            }
            this.djs = true;
          }
        }
        for (;;)
        {
          if (1 == paramMotionEvent.getAction())
          {
            this.djp = false;
            this.djq = false;
            this.djr = false;
            this.djs = false;
          }
          return super.dispatchTouchEvent(paramMotionEvent);
          if (!this.djp) {
            break;
          }
          this.mEditText.clearFocus();
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(((View)localObject).getWindowToken(), 0);
          break;
          if (!this.djq) {
            break label308;
          }
          a(1.0F, 0.0F, new auoo(this));
          break label308;
          if (!this.djr) {
            break label354;
          }
          VU(false);
          break label354;
          if (this.djs) {
            this.afB.performClick();
          }
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[doOnActivityResult], requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
    }
    if ((paramInt2 == -1) && (paramIntent != null)) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
      paramIntent = paramIntent.getExtras();
    } while ((paramIntent == null) || (paramIntent.getInt("BUSI_TYPE") != 1043));
    aupe.a(paramIntent, this.app, this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.a(getWindow(), true);
    }
    overridePendingTransition(0, 0);
    this.mRootView = new RelativeLayout(this);
    this.mRootView.setFocusable(true);
    this.mRootView.setFocusableInTouchMode(true);
    this.mRootView.setBackgroundColor(1677721600);
    paramBundle = this.mRootView;
    int j = (int)(getResources().getDisplayMetrics().density * 120.0F);
    int i;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      i = ImmersiveUtils.getStatusBarHeight(this);
      paramBundle.setPadding(0, i + j, 0, 0);
      this.el = ((RelativeLayout)LayoutInflater.from(this).inflate(2131563223, this.mRootView, false));
      this.mRootView.addView(this.el);
      super.setContentView(this.mRootView);
      parseIntent();
      cFc();
      if (this.mMode != 1) {
        break label233;
      }
      evX();
      evV();
      evS();
    }
    label343:
    for (;;)
    {
      this.mEditText.post(new TodoNewActivity.1(this));
      this.mRootView.post(new TodoNewActivity.2(this));
      this.app.addObserver(this.jdField_a_of_type_Aupd);
      return true;
      i = 0;
      break;
      label233:
      if ((this.mMode == 0) || (this.mMode == 4))
      {
        evS();
      }
      else
      {
        if (this.mMode == 2)
        {
          Resources localResources;
          if (!this.djl)
          {
            this.afC = ((TextView)findViewById(2131377630));
            this.afC.setVisibility(0);
            this.afC.setOnClickListener(this);
            paramBundle = this.afC;
            localResources = getResources();
            if (!this.djm) {
              break label343;
            }
          }
          for (i = 2131721794;; i = 2131721207)
          {
            paramBundle.setText(localResources.getString(i));
            evQ();
            evR();
            break;
          }
        }
        if (this.mMode == 3)
        {
          evQ();
          evX();
          evV();
          evR();
          this.mEditText.setTextColor(getResources().getColor(2131167614));
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Aupd);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.mRootView.getWindowToken(), 0);
  }
  
  public void finish()
  {
    c(false, new auox(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.allowClick)
      {
        this.allowClick = false;
        paramView.postDelayed(new TodoNewActivity.14(this), 1200L);
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131364677: 
          if ((!TextUtils.isEmpty(this.cIJ)) && (this.mMode != 2) && (aJv()))
          {
            ewb();
          }
          else
          {
            if (this.mMode == 4) {
              aupe.L(this.app, "0X80091B5", 1);
            }
            for (;;)
            {
              finish();
              break;
              if (this.mMode == 0) {
                aupe.L(this.app, "0X80091BC", 1);
              }
            }
          }
          break;
        case 2131379967: 
          evY();
          break;
        case 2131379968: 
          localObject2 = String.format(getResources().getString(2131721208), new Object[] { this.b.content });
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString(aupe.cIK, this.b.todoId);
          ((Bundle)localObject1).putInt("BUSI_TYPE", 1043);
          ((Bundle)localObject1).putInt("forward_type", -1);
          ((Bundle)localObject1).putString("forward_text", (String)localObject2);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("k_dataline", false);
          ((Intent)localObject2).putExtra("k_favorites", false);
          ((Intent)localObject2).setClass(this, ForwardRecentActivity.class);
          ((Intent)localObject2).putExtras((Bundle)localObject1);
          ahgq.f(this, (Intent)localObject2, 21);
          aupe.L(this.app, "0X80091CD", 1);
          anpc.report("tim_mine_tab_remain_click_share_remain_click");
        }
      }
    }
    int i;
    if (this.b.fromUinType == 1) {
      i = 1;
    }
    for (;;)
    {
      label364:
      if ((i == -1) || (this.b == null) || (this.b.fromUin == 0L) || (this.app == null))
      {
        QQToast.a(this, "无法定位到对应聊天窗口", 0).show();
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("uintype = ").append(i).append(", ");
        if (this.b == null) {}
        for (localObject1 = "mTodoInfo is null";; localObject1 = "mTodoInfo.fromUin = " + this.b.fromUin)
        {
          QLog.d((String)localObject2, 2, (String)localObject1);
          break;
          if (this.b.fromUinType == 2)
          {
            i = 3000;
            break label364;
          }
          if (this.b.fromUinType == 3)
          {
            i = 0;
            break label364;
          }
          if (this.b.fromUinType != 4) {
            break label1175;
          }
          if (this.b.c2cTempUinType == 1)
          {
            i = 1000;
            break label364;
          }
          if (this.b.c2cTempUinType == 2)
          {
            i = 1004;
            break label364;
          }
          if (this.b.c2cTempUinType != 3) {
            break label1175;
          }
          i = 1006;
          break label364;
        }
      }
      localObject2 = aupe.a(this.b, this.app, this);
      long l = anbk.I(this.b.msgRandom);
      if (this.b.c2cTempUinType == 3) {}
      for (localObject1 = this.b.numStr;; localObject1 = String.valueOf(this.b.fromUin))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "enterChatFromTodo before search: fromText = " + (String)localObject2 + ", friendUin = " + (String)localObject1 + ", uintype = " + i + ", msgUid = " + l + ", msgSeq = " + this.b.msgSeq + ", random = " + this.b.msgRandom);
        }
        localObject1 = this.app.b().c((String)localObject1, i, this.b.msgSeq, l);
        if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
          break label831;
        }
        QQToast.a(this, "无法定位到对应聊天窗口", 0).show();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(TAG, 2, "queryMsgList == null or queryMsgList.size() == 0");
        break;
      }
      label831:
      localObject1 = (MessageRecord)((List)localObject1).get(0);
      if (((localObject1 instanceof MessageForUniteGrayTip)) || (((MessageRecord)localObject1).msgtype == -2006))
      {
        QQToast.a(this, "无法定位到对应聊天窗口", 0).show();
        break;
      }
      aalb.bwg = true;
      if ((i == 1) || (i == 3000)) {}
      for (aalb.LY = this.b.msgSeq;; aalb.LY = this.b.msgTime)
      {
        aalb.a(this, this.app, String.valueOf(this.b.fromUin), i, (String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "enterChatFromTodo after search: msgSeq = " + this.b.msgSeq + ", msgTime = " + this.b.msgTime + ", msgRandom = " + this.b.msgRandom + ", msgUid = " + l);
        }
        aupe.L(this.app, "0X80091CC", 1);
        break;
      }
      if (this.mMode == 1)
      {
        evZ();
        break;
      }
      if (this.mMode == 0)
      {
        aaV(0);
        break;
      }
      if (this.mMode != 4) {
        break;
      }
      aaV(2);
      break;
      if (this.djm) {
        if ((this.b != null) && (!TextUtils.isEmpty(this.b.todoId)))
        {
          localObject1 = new Intent(this, TodoListActivity.class);
          ((Intent)localObject1).putExtra("highlight_todo_id", this.b.todoId);
          startActivity((Intent)localObject1);
        }
      }
      for (;;)
      {
        aupe.L(this.app, "0X80091D1", 1);
        break;
        showToast("该待办不存在");
        continue;
        aaV(1);
      }
      label1175:
      i = -1;
    }
  }
  
  public class a
    implements IphonePickerView.d
  {
    private IphonePickerView b;
    private int interval = 5;
    
    protected a() {}
    
    private int ap()
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      int i = localCalendar.get(1);
      localCalendar.set(6, 1);
      localCalendar.roll(6, -1);
      int j = localCalendar.get(6);
      localCalendar.roll(6, 1);
      localCalendar.set(1, i + 1);
      localCalendar.set(6, 1);
      localCalendar.roll(6, -1);
      return localCalendar.get(6) + j;
    }
    
    public void a(IphonePickerView paramIphonePickerView)
    {
      this.b = paramIphonePickerView;
    }
    
    public String d(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return "";
      case 0: 
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        ((Calendar)localObject2).set(6, paramInt2 + 1);
        if (((Calendar)localObject1).get(1) == ((Calendar)localObject2).get(1)) {
          if (((Calendar)localObject1).get(6) == ((Calendar)localObject2).get(6)) {
            return "今天";
          }
        }
        for (localObject1 = new SimpleDateFormat("M月d日 E");; localObject1 = new SimpleDateFormat("yyyy年M月d日 E")) {
          return ((SimpleDateFormat)localObject1).format(((Calendar)localObject2).getTime());
        }
      case 1: 
        localObject2 = new StringBuilder();
        if (paramInt2 < 10) {}
        for (localObject1 = "0";; localObject1 = "") {
          return (String)localObject1 + paramInt2;
        }
      }
      Object localObject2 = new StringBuilder();
      if (this.interval * paramInt2 < 10) {}
      for (Object localObject1 = "0";; localObject1 = "") {
        return (String)localObject1 + this.interval * paramInt2;
      }
    }
    
    public int getColumnCount()
    {
      return 3;
    }
    
    public void nw(long paramLong)
    {
      int i = 0;
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(paramLong);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      int j = localCalendar.get(1);
      localCalendar.set(6, 1);
      localCalendar.roll(6, -1);
      int k = localCalendar.get(6);
      int m = ((Calendar)localObject).get(1);
      this.b.setSelection(0, k * (m - j) + (((Calendar)localObject).get(6) - 1));
      this.b.setSelection(1, ((Calendar)localObject).get(11));
      j = ((Calendar)localObject).get(12);
      localObject = this.b;
      if (j != 0) {
        i = j / this.interval;
      }
      ((IphonePickerView)localObject).setSelection(2, i);
    }
    
    public int t(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        return ap();
      case 1: 
        return 24;
      }
      return 60 / this.interval;
    }
    
    public long w()
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      int i = localCalendar.get(1);
      localCalendar.setTimeInMillis(0L);
      localCalendar.set(1, i);
      localCalendar.set(6, this.b.ha(0) + 1);
      localCalendar.set(11, this.b.ha(1));
      localCalendar.set(12, this.b.ha(2) * this.interval);
      localCalendar.set(13, 0);
      return localCalendar.getTimeInMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.todo.TodoNewActivity
 * JD-Core Version:    0.7.0.1
 */