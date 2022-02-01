import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.ConfessProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class xxt
  extends BaseChatPie
  implements Handler.Callback
{
  protected achq a;
  aegq jdField_a_of_type_Aegq;
  aegv jdField_a_of_type_Aegv = new xxu(this);
  protected ConfessInfo a;
  private ConfessProgressView jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView;
  arib b;
  private int bXR = -1;
  protected boolean bkA;
  private String confessorNick;
  private LottieDrawable f;
  PopupWindow g;
  MqqHandler s = new aurf(ThreadManager.getSubThreadLooper(), this);
  private ImageView tY;
  private View xj;
  private View xk;
  
  public xxt(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Achq = new xxy(this);
  }
  
  @NonNull
  private List<ChatMessage> aH(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((ChatMessage)paramList.get(i)).getConfessTopicId() == this.sessionInfo.topicId)
      {
        localArrayList.add(paramList.get(i));
        if ((((ChatMessage)paramList.get(i)).msgtype == 1032) && (QLog.isColorLevel())) {
          QLog.i(this.TAG, 2, "ConfessChatPie has illegal msgType!");
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void cfP()
  {
    long l1;
    if (aegp.i(this.app))
    {
      zK(false);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.sessionInfo.aTl);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    if (this.sessionInfo.cZ == 1033)
    {
      this.jdField_a_of_type_Aegq.b(this.app.getLongAccountUin(), l1, this.sessionInfo.topicId, this.sessionInfo.cZ, true);
      return;
    }
    this.jdField_a_of_type_Aegq.b(l1, this.app.getLongAccountUin(), this.sessionInfo.topicId, this.sessionInfo.cZ, false);
  }
  
  private void cfQ()
  {
    if ((this.xj != null) && (this.sessionInfo.cZ == 1034))
    {
      String str = aegu.g(this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.topicId);
      if (aegp.D(this.app, str)) {
        this.xj.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.xj.setVisibility(8);
  }
  
  private void cfR()
  {
    if (this.sessionInfo.cZ == 1033)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130844446);
      this.cL.setBackgroundResource(2130844446);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378466).setVisibility(8);
    }
    for (;;)
    {
      try
      {
        wja.S(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130844452);
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          wja.S(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130844465);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
        }
        this.mTitleText.setTextColor(jof.aCs);
        this.Ct.setTextColor(this.mActivity.getResources().getColor(2131167301));
        if (this.Cr.getVisibility() == 0)
        {
          this.Cr.setBackgroundResource(2130844472);
          this.Cr.setTextColor(jof.aCs);
          this.cJ.setOnClickListener(null);
          this.cK.setOnClickListener(null);
          wja.a(this.pp, null);
          if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
          {
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundColor(-16777216);
            if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 8) {
              this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
            }
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.aX(this.app);
          }
          if (this.c != null) {
            this.c.HW(true);
          }
          this.pp.setVisibility(4);
          this.aSc = false;
          vU(true);
          this.Cu.setText(acfp.m(2131704286) + this.confessorNick);
          this.Cu.setTextColor(-855638017);
          this.mTitleText.setTextColor(-855638017);
          Object localObject1 = new View(this.mActivity);
          ((View)localObject1).setBackgroundColor(-2013265920);
          Object localObject2 = new RelativeLayout.LayoutParams(-1, 2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          localObject1 = acfp.m(2131704287);
          if (this.bkA) {
            localObject1 = acfp.m(2131704288);
          }
          this.Cr.setText((CharSequence)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131370393).setVisibility(8);
          this.Cr.setTextSize(16.0F);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription((String)localObject1);
          localObject1 = new ConfessNewsBgView(this.mContext);
          ((ConfessNewsBgView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          this.fs.addView((View)localObject1, 0);
          if (this.sessionInfo.cZ != 1033) {
            break label926;
          }
          i = 858006566;
          ((ConfessNewsBgView)localObject1).setBgColor(i);
          ((ConfessNewsBgView)localObject1).setSize(2);
          if (aegp.i(this.app))
          {
            localObject1 = View.inflate(this.mContext, 2131561271, null);
            this.cL.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
            localObject2 = ((View)localObject1).findViewById(2131382125);
            this.tY = ((ImageView)((View)localObject1).findViewById(2131368566));
            this.tY.setOnClickListener(this);
            this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView = ((ConfessProgressView)((View)localObject1).findViewById(2131365206));
            float f1 = this.mContext.getResources().getDisplayMetrics().density;
            this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.setSize(24.0F * f1, 27.0F * f1, -0.15F * f1, -0.5F * f1);
            this.xj = ((View)localObject1).findViewById(2131368558);
            this.xj.setVisibility(8);
            this.xk = ((View)localObject1).findViewById(2131368556);
            if (this.sessionInfo.cZ == 1033)
            {
              localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
              ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = ((int)(9.0F * f1));
              ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            this.xk.setVisibility(4);
            cfS();
            if (!aegp.C(this.app, "holmes_guide"))
            {
              aegp.a(this.app, "holmes_guide", true);
              if (this.sessionInfo.cZ != 1033) {
                break label933;
              }
              localObject1 = View.inflate(this.mContext, 2131561270, null);
              ((View)localObject1).findViewById(2131368561).setOnClickListener(this);
              ((View)localObject1).setOnClickListener(this);
              this.cL.getViewTreeObserver().addOnGlobalLayoutListener(new xxv(this, (View)localObject1, (View)localObject2));
            }
            if ((this.aSN) && (this.tY != null)) {
              this.tY.setVisibility(4);
            }
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.TAG, 1, "handleConfessUI error: " + localThrowable.getMessage());
        continue;
        if (this.pq.getVisibility() != 0) {
          continue;
        }
        this.pq.setBackgroundResource(2130851759);
        this.pq.setPadding(0, 0, 0, 0);
        this.Cs.setTextColor(jof.aCs);
        this.Cs.setBackgroundResource(2130838072);
        continue;
      }
      this.mTitleText.setText(this.confessorNick);
      this.ps.setVisibility(4);
      this.pp.setImageResource(2130846502);
      this.pp.setBackgroundColor(0);
      continue;
      label926:
      int i = 268234225;
      continue;
      label933:
      View localView = View.inflate(this.mContext, 2131561269, null);
    }
  }
  
  private void cfS()
  {
    ThreadManager.excute(new ConfessChatPie.3(this), 16, null, true);
  }
  
  private void cfT()
  {
    Object localObject = a();
    if ((localObject == null) || (this.app == null)) {
      return;
    }
    localObject = (ausj)auss.a((Context)localObject, null);
    ((ausj)localObject).addButton(2131690243, 5);
    ((ausj)localObject).addButton(2131691293, 5);
    ((ausj)localObject).addCancelButton(2131721058);
    ((ausj)localObject).a(new xxz(this, (ausj)localObject));
    ((ausj)localObject).show();
  }
  
  private int getResId(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return 2130845883;
    case 0: 
      return 2130845877;
    case 1: 
      return 2130845878;
    case 2: 
      return 2130845880;
    case 3: 
      return 2130845881;
    case 4: 
      return 2130845882;
    case 6: 
      return 2130845884;
    case 7: 
      return 2130845885;
    case 8: 
      return 2130845886;
    case 9: 
      return 2130845887;
    }
    return 2130845879;
  }
  
  private void zK(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView == null) || (this.tY == null)) {
      return;
    }
    ConfessConvInfo localConfessConvInfo = this.app.a().a().a(this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.topicId);
    if (localConfessConvInfo != null)
    {
      if ((localConfessConvInfo.holmesTolCount == 0) || (localConfessConvInfo.holmesCurCount != localConfessConvInfo.holmesTolCount)) {
        break label215;
      }
      this.tY.setImageResource(2130845891);
    }
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.Q(localConfessConvInfo.holmesCurCount, localConfessConvInfo.holmesTolCount);
      this.tY.setContentDescription(String.format(acfp.m(2131704296), new Object[] { Integer.valueOf(localConfessConvInfo.holmesTolCount), Integer.valueOf(localConfessConvInfo.holmesCurCount) }));
      if ((paramBoolean) && (localConfessConvInfo.holmesCurCount > this.bXR) && (this.f != null))
      {
        if ((i != 0) && (this.tY != null)) {
          this.tY.setVisibility(4);
        }
        if (this.xk != null) {
          this.xk.setVisibility(0);
        }
        this.f.playAnimation();
      }
      this.bXR = localConfessConvInfo.holmesCurCount;
      cfQ();
      return;
      label215:
      this.tY.setImageResource(2130845890);
    }
  }
  
  public void Ib()
  {
    this.TAG = "ConfessChatPie";
  }
  
  public boolean OL()
  {
    return false;
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return aH(paramQQAppInterface.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, -1L, this.sessionInfo.topicId, paramBoolean));
  }
  
  public void a(QQMessageFacade.Message paramMessage) {}
  
  public void a(DraftTextInfo paramDraftTextInfo) {}
  
  public void aH(QQAppInterface paramQQAppInterface)
  {
    aegu.a(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.topicId, true, true);
  }
  
  public void aIH()
  {
    aH(this.app);
  }
  
  public boolean af(boolean paramBoolean)
  {
    paramBoolean = super.af(paramBoolean);
    cfR();
    this.app.addObserver(this.jdField_a_of_type_Aegv);
    this.jdField_a_of_type_Aegq = ((aegq)this.app.getBusinessHandler(125));
    cfP();
    return paramBoolean;
  }
  
  public void bGK() {}
  
  public void bGY() {}
  
  public void bHD()
  {
    ThreadManager.post(new ConfessChatPie.4(this), 8, null, true);
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addObserver(this.jdField_a_of_type_Achq);
  }
  
  public void bHt()
  {
    super.bHt();
    if (this.sessionInfo.cZ == 1033) {
      ay(-16777216, false);
    }
  }
  
  public void bIL() {}
  
  public void bIM()
  {
    if ((this.sessionInfo == null) || (this.mContext == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null)) {}
    while (ThemeUtil.isDefaultOrDIYTheme(false)) {
      return;
    }
    if (this.sessionInfo.cZ != 1033)
    {
      Object localObject = ((FragmentActivity)a()).getSupportFragmentManager();
      ((FragmentManager)localObject).beginTransaction();
      localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = (ChatFragment)localObject;
        if (((ChatFragment)localObject).b != null) {
          ((ChatFragment)localObject).b.setStatusBarDrawable(a().getResources().getDrawable(2130847060));
        }
      }
      this.Ct.setTextColor(-1);
      this.mTitleText.setTextColor(-1);
      this.Cu.setTextColor(-1);
      this.Cr.setTextColor(-1);
      this.Cr.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851119));
      this.mAIORootView.findViewById(2131370393).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setIsDefaultTheme(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851105));
      this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
      wja.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, SkinEngine.getInstances().getDefaultThemeDrawable(2130850842));
      wja.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, SkinEngine.getInstances().getDefaultThemeDrawable(2130850843));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
      localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130850991);
      Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850988);
      Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850992);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { -16842910 }, localDrawable1);
      localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
      localStateListDrawable.addState(new int[0], (Drawable)localObject);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable(localStateListDrawable);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setTextColor(-1);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850892));
      return;
    }
    wja.S(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130844465);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
  }
  
  public void bIb()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > bEE))
    {
      ChatActivityUtils.h(this.mContext, 2131719509, 1);
      return;
    }
    ujt.d locald = new ujt.d();
    a(locald);
    locald.aSL = this.aSL;
    this.aSL = false;
    ujt.a(this.app, this.mContext, this.sessionInfo, str, null, locald);
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
    }
    bIN();
    this.jdField_a_of_type_Yjh.h(1002, new Object[] { str });
  }
  
  public void br(Intent paramIntent)
  {
    super.br(paramIntent);
    String str1 = paramIntent.getStringExtra("key_confessor_nick");
    int i = paramIntent.getIntExtra("key_confessor_sex", 0);
    String str2 = paramIntent.getStringExtra("key_confess_desc");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    this.bkA = paramIntent.getBooleanExtra("open_chat_from_rec_confess", false);
    this.confessorNick = str1;
    paramIntent = (aegs)this.app.getManager(269);
    if (((this.mActivity instanceof ChatActivity)) && (TextUtils.isEmpty(this.sessionInfo.aTl)))
    {
      QLog.d("ConfessChatPie", 1, "friend uin is null ,uintype = " + this.sessionInfo.cZ);
      this.mActivity.finish();
    }
    label345:
    for (;;)
    {
      return;
      this.sessionInfo.Vx = this.confessorNick;
      if (!this.aSN)
      {
        aego localaego = paramIntent.a();
        String str3 = this.sessionInfo.aTl;
        int j = this.sessionInfo.cZ;
        int k = this.sessionInfo.topicId;
        if (this.sessionInfo.cZ == 1033)
        {
          paramIntent = this.app.getCurrentAccountUin();
          this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo = localaego.a(str3, j, k, paramIntent, str1, i, str2, l);
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label345;
        }
        QLog.i(this.TAG, 2, String.format("updateSession saveConfessItem frdUin:%s type:%s topicId:%d confessorNick:%s confessorSex:%d", new Object[] { this.sessionInfo.aTl, Integer.valueOf(this.sessionInfo.cZ), Integer.valueOf(this.sessionInfo.topicId), str1, Integer.valueOf(i) }));
        return;
        paramIntent = this.sessionInfo.aTl;
        break;
        paramIntent = new ConfessInfo();
        paramIntent.reset();
        paramIntent.topicId = this.sessionInfo.topicId;
        paramIntent.confessorNick = str1;
      }
    }
  }
  
  public List<ChatMessage> cF()
  {
    return aH(a(this.app, false));
  }
  
  protected void cfO()
  {
    if (this.jdField_b_of_type_Arib != null)
    {
      this.jdField_b_of_type_Arib.dismiss();
      this.jdField_b_of_type_Arib = null;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Aegv);
    this.s.removeCallbacksAndMessages(null);
    cfO();
    if (this.g != null) {
      this.g.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 60) && (this.sessionInfo.cZ == 1033))
    {
      this.cL.setBackgroundResource(2130844446);
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public List<ChatMessage> n(boolean paramBoolean)
  {
    return aH(a(this.app, paramBoolean));
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i = paramView.getId();
    if ((i == 2131369594) && (this.sessionInfo != null) && (this.sessionInfo.cZ == 1034)) {
      cfT();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131368561)
      {
        if (this.g != null)
        {
          this.g.dismiss();
          this.g = null;
        }
      }
      else if (i != 2131368563)
      {
        if (i == 2131368566)
        {
          int j = 2;
          i = j;
          String str1;
          if (this.xj != null)
          {
            i = j;
            if (this.xj.getVisibility() == 0)
            {
              this.xj.setVisibility(8);
              str1 = aegu.g(this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.topicId);
              aegp.b(this.app, str1, false);
              i = 1;
            }
          }
          String str2;
          label192:
          QQAppInterface localQQAppInterface;
          Context localContext;
          if (this.sessionInfo.cZ == 1033)
          {
            str1 = this.app.getAccount();
            str2 = this.sessionInfo.aTl;
            localQQAppInterface = this.app;
            localContext = this.mContext;
            j = this.sessionInfo.topicId;
            if (this.sessionInfo.cZ != 1033) {
              break label358;
            }
          }
          for (;;)
          {
            aegp.a(localQQAppInterface, localContext, str1, str2, j, bool);
            anot.a(this.app, "dc00898", "", "", "0X8009573", "0X8009573", i, 0, this.sessionInfo.topicId + "", "", str1 + "", str2 + "");
            break;
            str1 = this.sessionInfo.aTl;
            str2 = this.app.getAccount();
            break label192;
            label358:
            bool = false;
          }
        }
        super.onClick(paramView);
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    Object localObject = ((FragmentActivity)a()).getSupportFragmentManager();
    ((FragmentManager)localObject).beginTransaction();
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = (ChatFragment)localObject;
      if (((ChatFragment)localObject).b != null) {
        ((ChatFragment)localObject).b.setStatusBarColor(1226741);
      }
    }
  }
  
  public void q(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_b_of_type_Arib == null) {
      this.jdField_b_of_type_Arib = new arib(this.mActivity);
    }
    this.jdField_b_of_type_Arib.aa(paramInt1, paramString, paramInt2);
  }
  
  public int vk()
  {
    int i = this.app.a().e(this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.topicId);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "initHaveUnRead count " + i);
    }
    return i;
  }
  
  public int vl()
  {
    int i = xkx.f(this.app, "Normal_MaxPtt") * 1000 - 200;
    this.uiHandler.sendEmptyMessageDelayed(16711687, i);
    return i + 200;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxt
 * JD-Core Version:    0.7.0.1
 */