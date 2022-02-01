package com.tencent.mobileqq.activity.aio.audiopanel;

import abin;
import acfp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import aqiw;
import aqmr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.SmallPttPlayView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import ujt;
import ujt.d;
import wqc;
import wqd;
import wqe;
import wqf;
import wqg;
import wqh;
import wqi;
import wqj;
import wqk;
import wqn;
import wqp;
import wqr;
import wqs;
import wqs.a;
import wsr;

public class VoiceTextEditPanel
  extends RelativeLayout
  implements wqc, wqr, wqs.a
{
  private TextView Iu;
  private final String TAG = "VoiceTextEditPanel";
  private VoiceTextEditScrollerView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView;
  private SmallPttPlayView jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new wqk(this);
  private wqn jdField_a_of_type_Wqn = new wqn();
  private wqp jdField_a_of_type_Wqp = new wqp();
  private wqs jdField_a_of_type_Wqs = new wqs();
  private AtomicInteger aB = new AtomicInteger(0);
  public String aLy;
  private EditText aM;
  private QQAppInterface app;
  private int bQE;
  private FrameLayout bb;
  private boolean bfn;
  public boolean bfo = true;
  private boolean bfp;
  private Button cancel;
  private Button dP;
  private BaseChatPie jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QQRecorder.RecorderParam jdField_e_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private boolean fk;
  private LinearLayout gY;
  private LinearLayout gZ;
  private View gk;
  private ImageView gl;
  private RelativeLayout hu;
  private boolean isDrag;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private String path;
  private SharedPreferences pref;
  private SessionInfo sessionInfo;
  private String text;
  private CheckBox z;
  
  public VoiceTextEditPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public VoiceTextEditPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VoiceTextEditPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void caJ()
  {
    if ((this.aB.get() == 1) || (this.aB.get() == 3))
    {
      QQToast.a(getContext(), acfp.m(2131716874), 0).show(getContext().getResources().getDimensionPixelSize(2131299627));
      setEditSendAndeCheckEnable();
      this.jdField_a_of_type_Wqs.stop();
      this.jdField_a_of_type_Wqp.caZ();
      this.aM.setText(this.text);
      this.aB.set(5);
    }
  }
  
  private void caK()
  {
    if (this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wsr != null) {
      this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wsr.setEnable(false);
    }
    if (this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Abin != null) {
      this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Abin.DF(false);
    }
    this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.bIf();
  }
  
  private void caL()
  {
    if (this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wsr != null) {
      this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wsr.setEnable(true);
    }
    if (this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Abin != null) {
      this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Abin.DF(true);
    }
    this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.bIe();
  }
  
  private void caP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "hideBottom");
    }
    this.gY.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.gk.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.gk.setLayoutParams(localLayoutParams);
  }
  
  private void caQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "showBottom");
    }
    this.gY.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.gk.getLayoutParams();
    localLayoutParams.bottomMargin = ankt.dip2px(75.0F);
    this.gk.setLayoutParams(localLayoutParams);
  }
  
  private void caR()
  {
    this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
    if ((this.z.isChecked()) && (this.z.isEnabled()))
    {
      int i = 1;
      if (this.bfn)
      {
        int j = 2;
        this.jdField_e_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.cuc = this.text;
        i = j;
        if (this.jdField_e_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.cuc != null)
        {
          i = j;
          if (this.jdField_e_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.cuc.length() > 150)
          {
            this.jdField_e_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.cuc = this.jdField_e_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.cuc.substring(0, 149);
            i = j;
          }
        }
      }
      this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.path, 5, this.bQE, this.jdField_e_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, false, i);
      anot.a(null, "dc00898", "", "", "0X800A1DA", "0X800A1DA", 1, 0, "", "", "", "");
      if (RH()) {
        break label366;
      }
      this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.wa(false);
      this.jdField_a_of_type_Wqn.caz();
      clearText();
    }
    for (;;)
    {
      onExit();
      return;
      ujt.d locald = new ujt.d();
      ArrayList localArrayList = new ArrayList();
      if (this.aB.get() < 5) {
        ujt.a(this.app, getContext(), this.sessionInfo, this.text, localArrayList, locald);
      }
      for (;;)
      {
        if (!this.fk) {
          break label330;
        }
        anot.a(null, "dc00898", "", "", "0X800A1DA", "0X800A1DA", 3, 0, "", "", "", "");
        break;
        if (this.aB.get() == 5) {
          ujt.a(this.app, getContext(), this.sessionInfo, this.aM.getText().toString(), localArrayList, locald);
        }
      }
      label330:
      anot.a(null, "dc00898", "", "", "0X800A1DA", "0X800A1DA", 2, 0, "", "", "", "");
      break;
      label366:
      this.jdField_a_of_type_Wqn.CA(1);
      this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.hideAllPanels();
    }
  }
  
  private void clearText()
  {
    this.text = "";
    this.aM.setText(this.text);
    this.jdField_a_of_type_Wqp.clear();
  }
  
  private void initView()
  {
    this.hu = ((RelativeLayout)findViewById(2131368427));
    this.bb = ((FrameLayout)findViewById(2131371159));
    this.bb.setOnTouchListener(new wqd(this));
    this.gY = ((LinearLayout)findViewById(2131363682));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView = ((VoiceTextEditScrollerView)findViewById(2131365360));
    this.cancel = ((Button)findViewById(2131364221));
    this.dP = ((Button)findViewById(2131377979));
    this.Iu = ((TextView)findViewById(2131377994));
    this.gZ = ((LinearLayout)findViewById(2131382133));
    this.gl = ((ImageView)findViewById(2131368465));
    this.z = ((CheckBox)findViewById(2131364587));
    this.z.setOnCheckedChangeListener(new wqe(this));
    View localView = (View)this.z.getParent();
    localView.post(new VoiceTextEditPanel.3(this, ankt.dip2px(8.0F), localView));
    this.aM = ((EditText)findViewById(2131366187));
    this.aM.setHorizontallyScrolling(false);
    this.aM.setLines(100);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView = ((SmallPttPlayView)findViewById(2131378514));
    this.gk = findViewById(2131370458);
    this.aM.setOnClickListener(new wqf(this));
    this.aM.setOnEditorActionListener(new wqg(this));
    this.aM.addTextChangedListener(new wqh(this));
    this.cancel.setOnClickListener(new wqi(this));
    this.dP.setOnClickListener(new wqj(this));
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      this.cancel.setTextColor(getContext().getResources().getColor(2131167335));
    }
  }
  
  private void onExit()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    this.jdField_a_of_type_Wqn.caz();
    clearText();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView.onDestroy();
    }
    this.jdField_a_of_type_Wqs.stop();
    caL();
    xla.bhx = false;
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setListener(null);
    this.isDrag = false;
    this.bfo = true;
  }
  
  private void reset()
  {
    this.aB.set(0);
    clearText();
    this.fk = false;
    this.bfo = false;
    this.gZ.setVisibility(0);
    this.Iu.setVisibility(8);
    this.z.setEnabled(true);
    this.aM.setEnabled(true);
    this.aM.setFocusableInTouchMode(false);
    this.jdField_a_of_type_Wqn.reset();
    this.bfn = false;
    this.hu.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setBackgroundDrawable(getContext().getResources().getDrawable(2130851023));
    caQ();
    this.pref = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    if (this.pref.getBoolean("businessinfo_ptt_vt_send_type_" + this.app.getCurrentAccountUin(), true))
    {
      this.z.setChecked(true);
      this.dP.setText(2131719514);
      setSendEnable(true);
      return;
    }
    this.z.setChecked(false);
    this.dP.setText(2131719512);
    setSendEnable(false);
  }
  
  public void Cx(int paramInt)
  {
    QQToast.a(getContext(), acfp.m(2131716872), 0).show(getContext().getResources().getDimensionPixelSize(2131299627));
    setEditSendAndeCheckEnable();
    this.jdField_a_of_type_Wqs.stop();
    this.jdField_a_of_type_Wqp.caZ();
    this.aM.setText(this.text);
    this.aB.set(5);
  }
  
  public void Cy(int paramInt)
  {
    if (this.hu.getVisibility() != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEditPanel", 2, "onActionDown but mHeader cannot see");
      }
    }
    do
    {
      return;
      this.isDrag = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setPanelActionDownPos(getTop(), getBottom());
      measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt - getTop(), 1073741824));
      layout(getLeft(), getTop(), getRight(), paramInt);
      this.bb.setVisibility(0);
      this.bb.measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824));
      this.bb.layout(getLeft(), 0, getRight(), paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("VoiceTextEditPanel", 2, "ACTION_DOWN mSlideLayout.getTop()=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() + " gettop=" + getTop() + " mSlideLayout.getBottom()" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getBottom() + " getbottom=" + getBottom() + " y=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getY());
  }
  
  public boolean RH()
  {
    return this.bfp;
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    initView();
    this.jdField_a_of_type_Wqn.a(paramViewGroup2, this, paramViewGroup1, this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  public void at(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "enterNormalState normalStateBottom=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() + " top=" + paramInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop(), paramInt1, paramInt2, paramInt3, 0, 200, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView);
    this.hu.setVisibility(8);
    caQ();
  }
  
  public void caF()
  {
    if ((!this.dP.isEnabled()) && (!aqmr.isEmpty(this.text))) {
      setSendEnable(true);
    }
  }
  
  public void caG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "vadFinishWithNoSeg state= " + this.aB.get());
    }
    this.aB.set(2);
    this.jdField_a_of_type_Wqs.stop();
    this.mHandler.post(new VoiceTextEditPanel.10(this));
  }
  
  public void caH()
  {
    this.z.setEnabled(false);
    this.dP.setText(2131719512);
    this.gZ.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "forbitSendAudio");
    }
    this.Iu.setVisibility(0);
    this.fk = true;
    updateUI();
  }
  
  public void caI()
  {
    this.jdField_a_of_type_Wqn.caW();
    if (this.jdField_a_of_type_Wqn.vT() != 0) {
      clearText();
    }
  }
  
  public void caM()
  {
    this.mHandler.post(new VoiceTextEditPanel.11(this));
  }
  
  public void caN()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(false);
    this.isDrag = false;
  }
  
  public void caO()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(true);
    this.isDrag = false;
    this.aM.setFocusable(true);
    this.aM.setFocusableInTouchMode(true);
    this.aM.requestFocus();
  }
  
  public void caS()
  {
    if (RH())
    {
      this.jdField_a_of_type_Wqn.fr(getRight() - getLeft(), this.jdField_a_of_type_Wqn.getDefaultHeight());
      return;
    }
    onExit();
  }
  
  public void caT()
  {
    this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.hideSoftInput();
  }
  
  public void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, new Object[] { "onXContainerLayout  start left=", Integer.valueOf(paramInt1), " top=", Integer.valueOf(paramInt2), " right=", Integer.valueOf(paramInt3), " bottom=", Integer.valueOf(paramInt4), " isDrag=", this.isDrag + " isShowEidt= " + paramBoolean + " mSlideLayout.top=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() + " mSlideLayout.bottom=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getBottom() + " this.top=" + getTop() + " this.bottom=" + getBottom() + "y=" + getY() });
    }
    int i;
    if (!this.isDrag)
    {
      if (paramInt2 != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setMaxHeight(paramInt4);
      }
      int j = this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getBottom();
      i = paramInt2;
      if (paramInt2 == 0) {
        i = paramInt2 + j;
      }
      if ((i > j) && (getTop() == j)) {
        this.jdField_a_of_type_Wqn.fr(getRight() - getLeft(), this.jdField_a_of_type_Wqn.getDefaultHeight());
      }
      if ((getTop() != i) || (paramInt4 != getBottom()) || (!paramBoolean)) {
        break label305;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEditPanel", 2, "onXContainerLayout edit state need no layout");
      }
    }
    label305:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() + getTop() - i >= ankt.dip2px(2.0F))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceTextEditPanel", 2, "onXContainerLayout normal state need no layout");
    return;
    measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - i, 1073741824));
    layout(paramInt1, i, paramInt3, paramInt4);
  }
  
  public void fq(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "enterEditState");
    }
    caP();
    int i = getHeight();
    int j = getHeight();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.a(getTop(), paramInt2, i - paramInt1, j, 1, 100, this);
    this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.aey();
  }
  
  public void hideSoftInput()
  {
    caT();
  }
  
  public void onDestroy()
  {
    onExit();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView.onPause();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.bottomMargin = paramInt2;
    setLayoutParams(localLayoutParams);
  }
  
  public void onTouch(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) || (!RH())) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.onTouchEvent(paramMotionEvent);
    } while (paramMotionEvent.getAction() != 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setMaskClick(true);
  }
  
  public void sendRequest()
  {
    anot.a(null, "dc00898", "", "", "0X800A1D7", "0X800A1D7", 0, 0, "", "", "", "");
    caK();
    AppNetConnInfo.registerConnectionChangeReceiver(getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    reset();
    xla.bhx = true;
    if (!aqiw.isNetworkAvailable(getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEditPanel", 2, "sendRequest  net unAvailable");
      }
      QQToast.a(getContext(), acfp.m(2131716873), 0).show(getContext().getResources().getDimensionPixelSize(2131299627));
      setEditSendAndeCheckEnable();
      this.aB.set(5);
    }
    while (this.aLy == null) {
      return;
    }
    this.aB.set(1);
    this.jdField_a_of_type_Wqp.xD(this.path);
    this.jdField_a_of_type_Wqs.cba();
  }
  
  public void setEditSendAndeCheckEnable()
  {
    setSendEnable(true);
    this.aM.setFocusableInTouchMode(true);
    this.z.setEnabled(true);
  }
  
  public void setParam(String paramString1, QQRecorder.RecorderParam paramRecorderParam, int paramInt, String paramString2)
  {
    this.path = paramString1;
    this.jdField_e_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.bQE = paramInt;
    this.aLy = paramString2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView.setDuration(this.bQE, paramString1, paramRecorderParam);
    }
    this.jdField_a_of_type_Wqp.a(paramString2, this.app, this, this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.getCurType(), this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.oL());
    this.jdField_a_of_type_Wqs.a(this.app, getResources().getColorStateList(2131167383), this);
  }
  
  public void setSendEnable(boolean paramBoolean)
  {
    this.dP.setEnabled(paramBoolean);
  }
  
  public void setSttNetFinish()
  {
    this.aB.set(4);
    this.bfn = true;
  }
  
  public void updateUI()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void xC(String paramString)
  {
    this.text = paramString;
    if (aqmr.isEmpty(paramString)) {}
    do
    {
      return;
      if ((this.aB.get() != 4) && (this.aB.get() != 5)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceTextEditPanel", 2, "updateText has finish");
    return;
    this.aB.set(3);
  }
  
  public void yO(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, " onSoftInputShowing  isShow=" + paramBoolean + " isDrag=" + this.isDrag);
    }
    this.bfp = paramBoolean;
    if (paramBoolean)
    {
      anot.a(null, "dc00898", "", "", "0X800A1DC", "0X800A1DC", 0, 0, "", "", "", "");
      this.hu.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setListener(this);
      caP();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setBackgroundDrawable(getContext().getResources().getDrawable(2130839727));
    }
    for (;;)
    {
      if (!this.isDrag) {
        this.jdField_a_of_type_Wqn.yP(paramBoolean);
      }
      return;
      if (!this.isDrag) {
        caQ();
      }
      this.hu.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setBackgroundDrawable(getContext().getResources().getDrawable(2130851023));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel
 * JD-Core Version:    0.7.0.1
 */