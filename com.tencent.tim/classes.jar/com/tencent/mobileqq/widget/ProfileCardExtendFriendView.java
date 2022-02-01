package com.tencent.mobileqq.widget;

import acff;
import afsg;
import afsi;
import afxm;
import afxw;
import afyi;
import alcs;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import anot;
import aqep;
import aqqs;
import aqrn;
import aqry;
import aqsa;
import argz;
import arha;
import arhb;
import arhc;
import ausj;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendGradientFootView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendGradientTextView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;
import wja;

public class ProfileCardExtendFriendView
  extends LinearLayout
  implements View.OnClickListener, View.OnTouchListener
{
  private static boolean caP;
  protected ImageView FH;
  protected ImageView FI;
  private Paint Q;
  private ExtendFriendGradientFootView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView;
  protected ExtendFriendGradientTextView a;
  private ProfileCardFavorShowView jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView;
  protected TextView ace;
  private String ace;
  protected TextView acf;
  protected TextView acg;
  protected TextView ach;
  protected TextView aci;
  protected TextView acj;
  private ausj ae;
  private QQAppInterface app;
  int backgroundColor = -1;
  protected ExtendFriendVoiceView c;
  int cUn = -16777216;
  private boolean caI;
  private boolean caJ;
  private FrameLayout cl;
  int clothesId;
  private View contentView;
  private alcs jdField_d_of_type_Alcs;
  private Card jdField_d_of_type_ComTencentMobileqqDataCard;
  private boolean daB;
  private boolean daC;
  private boolean daD;
  private boolean daE = true;
  private boolean daF;
  private boolean daG;
  private int duration;
  private Bitmap dw;
  private int ehr;
  private int ehs;
  int fontId;
  int fontType;
  private GradientDrawable g;
  private boolean isOwner;
  private boolean isTheme;
  public TextView jS;
  protected LinearLayout lp;
  protected LinearLayout lq;
  public LinearLayout lr;
  private LinearLayout ls;
  private LinearLayout lt;
  private RectF mBgRect;
  private Context mContext;
  private LayoutInflater mInflater;
  private int mLayoutHeight;
  private int mLayoutWidth;
  private aqrn mVasRes;
  private ImageView tR;
  private float wm;
  
  public ProfileCardExtendFriendView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initUI();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, alcs paramalcs, boolean paramBoolean)
  {
    super(paramContext);
    this.mContext = paramContext;
    if (paramalcs != null) {}
    for (;;)
    {
      this.isTheme = bool;
      this.daC = paramBoolean;
      this.jdField_d_of_type_Alcs = paramalcs;
      initUI();
      return;
      bool = false;
    }
  }
  
  public ProfileCardExtendFriendView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    initUI();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initUI();
  }
  
  private void YB(int paramInt)
  {
    this.g = afyi.a(paramInt, this.wm, this.wm, this.wm, this.wm);
  }
  
  private void a(View paramView, alcs paramalcs, boolean paramBoolean)
  {
    if (paramalcs != null)
    {
      alcs.a(this.ach, "color", paramalcs, "commonItemContentColor");
      alcs.a(this.acj, "color", paramalcs, "commonItemContentColor");
      alcs.a(this.aci, "color", paramalcs, "commonItemContentColor");
      alcs.a(this.jdField_ace_of_type_AndroidWidgetTextView, "color", paramalcs, "commonItemContentColor");
      alcs.a(this.acf, "color", paramalcs, "commonItemContentColor");
      alcs.a(this.acg, "color", paramalcs, "commonItemContentColor");
      paramView = paramalcs.gB.get("commonItemContentColor");
      if (paramView != null)
      {
        if (!(paramView instanceof ColorStateList)) {
          break label112;
        }
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(((ColorStateList)paramView).getDefaultColor());
      }
    }
    label112:
    while (!paramBoolean)
    {
      do
      {
        do
        {
          return;
        } while (!(paramView instanceof String));
        paramView = (String)paramView;
      } while (!paramView.startsWith("#"));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(Color.parseColor(paramView));
      return;
    }
    this.ach.setTextColor(getResources().getColor(2131167304));
    this.acj.setTextColor(getResources().getColor(2131167304));
    this.aci.setTextColor(getResources().getColor(2131167304));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(getResources().getColor(2131167304));
    this.jdField_ace_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167304));
    this.acf.setTextColor(getResources().getColor(2131167304));
    this.acg.setTextColor(getResources().getColor(2131167304));
  }
  
  private void d(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mLayoutHeight <= 0) || (this.mLayoutWidth <= 0)) {
      return;
    }
    if (this.mBgRect == null) {
      this.mBgRect = new RectF();
    }
    float f;
    int i;
    if (this.isOwner)
    {
      f = 10.0F;
      i = wja.dp2px(f, getResources());
      this.mBgRect.set(0, 0.0F, this.mLayoutWidth - 0, this.mLayoutHeight - i);
      if (!paramBoolean1) {
        break label211;
      }
      if (!paramBoolean2) {
        break label201;
      }
      YB(872415231);
      this.FI.setImageResource(2130846058);
      this.ach.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130846065), null);
    }
    for (;;)
    {
      if (this.g != null) {
        this.g.setBounds(0, 0, this.mLayoutWidth - 0, this.mLayoutHeight - i);
      }
      paramView = (FrameLayout.LayoutParams)this.tR.getLayoutParams();
      paramView.width = (this.mLayoutWidth + 0);
      paramView.height = (this.mLayoutHeight - i);
      this.tR.setLayoutParams(paramView);
      return;
      f = 44.0F;
      break;
      label201:
      YB(-1711276033);
      continue;
      label211:
      if (paramBoolean2)
      {
        this.FI.setImageResource(2130846060);
        this.ach.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130846067), null);
        YB(184549375);
      }
      else
      {
        if (this.Q == null)
        {
          this.Q = new Paint(1);
          this.Q.setStyle(Paint.Style.FILL);
          this.Q.setAntiAlias(true);
        }
        eip();
        if (this.dw == null) {
          YB(869849304);
        }
        f = this.mLayoutWidth / this.dw.getWidth();
        paramView = new Matrix();
        paramView.setScale(f, f);
        BitmapShader localBitmapShader = new BitmapShader(this.dw, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        localBitmapShader.setLocalMatrix(paramView);
        this.Q.setShader(localBitmapShader);
      }
    }
  }
  
  private void eip()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inSampleSize = 2;
    int i;
    int j;
    if ((!TextUtils.isEmpty(this.jdField_ace_of_type_JavaLangString)) && (this.jdField_ace_of_type_JavaLangString.contains("=")) && (afxw.fc != null) && (afxw.fc.length > 0) && (afxw.fe != null) && (afxw.fe.length > 0))
    {
      i = this.jdField_ace_of_type_JavaLangString.indexOf('=');
      i = this.jdField_ace_of_type_JavaLangString.substring(i + 1).toUpperCase().charAt(0);
      j = afxw.fe.length;
    }
    for (Object localObject = afxw.fc[(i % j)];; localObject = "expand_summary_bg.png")
    {
      localObject = afxw.decodeFile(afxw.kL((String)localObject), localOptions);
      if (localObject == null) {
        break;
      }
      this.dw = afxm.a(getResources(), (Bitmap)localObject, -2565928, 0.2F, false);
      return;
    }
    this.dw = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
    new Canvas(this.dw).drawColor(-1);
  }
  
  private void eiq()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView != null)
    {
      this.daD = false;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFold(false);
      if ((this.daF) && (this.ehr != 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView.YC(this.ehs);
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setVisibility(8);
      this.FI.setRotation(180.0F);
      this.FI.setPadding(this.FI.getPaddingLeft(), wja.dp2px(16.0F, getResources()), this.FI.getPaddingRight(), wja.dp2px(6.0F, getResources()));
    }
  }
  
  private void eir()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView != null)
    {
      this.daD = true;
      if ((!this.daF) || (this.ehr == 0) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView == null)) {
        break label126;
      }
      ExtendFriendGradientTextView localExtendFriendGradientTextView = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView;
      if (this.daD) {
        break label121;
      }
      localExtendFriendGradientTextView.setFold(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView.YC(this.ehr);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setVisibility(0);
      this.FI.setRotation(0.0F);
      this.FI.setPadding(this.FI.getPaddingLeft(), wja.dp2px(6.0F, getResources()), this.FI.getPaddingRight(), wja.dp2px(16.0F, getResources()));
      return;
      label121:
      bool = false;
      break;
      label126:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFold(this.daD);
      this.daG = true;
    }
  }
  
  private void eit()
  {
    if ((this.mContext instanceof FriendProfileCardActivity))
    {
      if ((((ProfileActivity.AllInOne)((FriendProfileCardActivity)this.mContext).getIntent().getParcelableExtra("AllInOne")).pa == 96) && (((FriendProfileCardActivity)this.mContext).aWx))
      {
        this.mContext.sendBroadcast(new Intent("com.tencent.mobileqq.search.finish"));
        ((FriendProfileCardActivity)this.mContext).finish();
      }
    }
    else {
      return;
    }
    ExtendFriendPublicFragmentActivity.ek(this.mContext);
  }
  
  private void initUI()
  {
    this.mInflater = LayoutInflater.from(getContext());
    this.contentView = this.mInflater.inflate(2131561576, this, true);
    this.jdField_ace_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131380848));
    this.acf = ((TextView)this.contentView.findViewById(2131380982));
    this.acg = ((TextView)this.contentView.findViewById(2131380909));
    this.FH = ((ImageView)this.contentView.findViewById(2131369664));
    this.lp = ((LinearLayout)this.contentView.findViewById(2131370727));
    this.lq = ((LinearLayout)this.contentView.findViewById(2131370728));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView = ((ExtendFriendGradientTextView)this.contentView.findViewById(2131380762));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setCardView(this);
    this.FI = ((ImageView)this.contentView.findViewById(2131369721));
    this.FI.setOnClickListener(this);
    this.lr = ((LinearLayout)this.contentView.findViewById(2131366599));
    this.jS = ((TextView)this.lr.findViewById(2131366600));
    this.jS.setOnClickListener(this);
    this.c = ((ExtendFriendVoiceView)this.contentView.findViewById(2131369082));
    this.c.cbQ = true;
    this.c.setMode(2);
    this.c.setOnClickListener(this);
    this.c.setActivity((FriendProfileCardActivity)this.mContext);
    this.ach = ((TextView)this.contentView.findViewById(2131380980));
    this.ach.setOnClickListener(this);
    this.aci = ((TextView)this.contentView.findViewById(2131380983));
    this.acj = ((TextView)this.contentView.findViewById(2131380977));
    this.lt = ((LinearLayout)this.contentView.findViewById(2131366292));
    this.cl = ((FrameLayout)this.contentView.findViewById(2131367187));
    this.tR = ((ImageView)this.contentView.findViewById(2131371159));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView = ((ExtendFriendGradientFootView)this.contentView.findViewById(2131367459));
    View localView = this.contentView.findViewById(2131382055);
    int i = getResources().getDisplayMetrics().widthPixels / 2;
    int j = wja.dp2px(38.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = (i - j);
    localLayoutParams.leftMargin = wja.dp2px(10.0F, getResources());
    localView.setLayoutParams(localLayoutParams);
    this.ls = ((LinearLayout)this.contentView.findViewById(2131382055));
    this.wm = wja.dp2px(3.0F, getResources());
    a(this.contentView, this.jdField_d_of_type_Alcs, this.daC);
    addOnLayoutChangeListener(new argz(this));
  }
  
  public void TJ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.FI.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setVisibility(0);
      this.lt.setPadding(this.lt.getPaddingLeft(), this.lt.getPaddingTop(), this.lt.getPaddingRight(), 0);
      if (this.daE) {
        eir();
      }
    }
    while ((paramBoolean) || (this.FI.getVisibility() == 0))
    {
      return;
      eiq();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.bFY = null;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.cbM = false;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setMaxLines(50);
    this.FI.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setVisibility(8);
    this.lt.setPadding(this.lt.getPaddingLeft(), this.lt.getPaddingTop(), this.lt.getPaddingRight(), wja.dp2px(16.0F, getResources()));
  }
  
  public ETTextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView;
  }
  
  public void b(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_ComTencentMobileqqDataCard = paramCard;
    this.jdField_ace_of_type_AndroidWidgetTextView.setText(String.format("%d", new Object[] { Integer.valueOf(paramCard.popularity) }));
    this.app = paramQQAppInterface;
    QLog.d("BusinessCard_CardHandler", 1, "handleGetSummaryCard--vExtendCard 111 popularity=" + this.jdField_ace_of_type_AndroidWidgetTextView + " declaration=" + paramCard.declaration + " voiceUrl=" + paramCard.voiceUrl + " updateTime=" + paramCard.updateTime + " duration=" + this.duration + "fontId = " + paramCard.fontId + "fontType = " + paramCard.fontType + "clothesId= " + paramCard.clothesId);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.content == null)
    {
      localObject = "";
      if ((paramCard.declaration != null) && (!((String)localObject).equals(paramCard.declaration)))
      {
        TJ(false);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setContent(paramCard.declaration);
      }
      this.jdField_ace_of_type_JavaLangString = paramCard.voiceUrl;
      this.isOwner = paramCard.uin.equals(paramQQAppInterface.getCurrentAccountUin());
      if (!this.isOwner) {
        break label442;
      }
      localObject = getContext().getString(2131701179);
      this.cl.setOnClickListener(this);
      this.cl.setOnTouchListener(this);
      label263:
      if (TextUtils.isEmpty(this.jdField_ace_of_type_JavaLangString)) {
        break label489;
      }
      this.ls.setVisibility(0);
      this.c.setVoiceDuration(paramCard.extendFriendVoiceDuration);
      this.duration = paramCard.extendFriendVoiceDuration;
      this.c.setVoiceUrl(this.jdField_ace_of_type_JavaLangString);
      label312:
      d(this.contentView, this.isTheme, this.daC);
      this.jS.setText((CharSequence)localObject);
      if (!this.isOwner) {
        break label501;
      }
      this.lr.setVisibility(8);
      label352:
      c(paramCard, paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setColor(this.backgroundColor);
      if (!anlm.ayn())
      {
        setClothes(paramCard.clothesId);
        setFont(paramCard.fontId, paramCard.fontType);
      }
      if ((!this.caJ) && (!this.caI)) {
        break label531;
      }
    }
    label531:
    for (paramCard = "2";; paramCard = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_show", "", 0, "", paramCard);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.content;
      break;
      label442:
      localObject = (afsi)paramQQAppInterface.getManager(264);
      localObject = String.format(getContext().getString(2131701178), new Object[] { ((afsi)localObject).uB() });
      this.cl.setOnClickListener(this);
      break label263;
      label489:
      this.ls.setVisibility(8);
      break label312;
      label501:
      if (this.daB)
      {
        this.lr.setVisibility(8);
        break label352;
      }
      this.lr.setVisibility(0);
      break label352;
    }
  }
  
  public void c(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramCard.schoolName)) || (TextUtils.isEmpty(paramCard.schoolId)))
    {
      this.lp.setVisibility(8);
      return;
    }
    this.lp.setVisibility(0);
    TextView localTextView = this.acg;
    String str = paramCard.schoolName;
    int i;
    Context localContext;
    if (paramCard.authState == 2L)
    {
      i = 2130846054;
      localContext = getContext();
      if (!this.isOwner) {
        break label147;
      }
    }
    label147:
    for (arhc localarhc = new arhc(this, paramCard);; localarhc = null)
    {
      localTextView.setText(aqep.a(str, false, i, 2131298794, 2131298793, localContext, paramQQAppInterface, localarhc));
      this.acg.setMovementMethod(LinkMovementMethod.getInstance());
      this.lq.post(new ProfileCardExtendFriendView.5(this, paramCard));
      return;
      i = 2130846055;
      break;
    }
  }
  
  public void cC(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = ((acff)this.app.getManager(51)).c(this.app.getCurrentAccountUin());
    Intent localIntent = new Intent();
    localObject = new ExtendFriendProfileEditFragment.ExtendFriendInfo((Card)localObject);
    if (paramBoolean1)
    {
      ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).cUM = this.fontId;
      ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).cbi = true;
    }
    if (paramBoolean2)
    {
      ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).cUN = this.clothesId;
      ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).cbj = true;
    }
    localIntent.putExtra("key_extend_friend_info", (Parcelable)localObject);
    PublicFragmentActivity.startForResult((Activity)this.mContext, localIntent, ExtendFriendEditFragment.class, 4097);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.mBgRect != null) && (this.Q != null) && (!this.daF)) {
      paramCanvas.drawRoundRect(this.mBgRect, this.wm, this.wm, this.Q);
    }
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      return;
      if (this.g != null) {
        this.g.draw(paramCanvas);
      }
    }
  }
  
  public void eis()
  {
    if (anlm.ayn()) {}
    do
    {
      return;
      if (!caP)
      {
        if (((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin()).declaration == null) {
          ((afsg)this.app.getBusinessHandler(127)).k(this.app.getCurrentAccountUin(), false);
        }
        caP = false;
      }
    } while ((((this.mContext instanceof BaseActivity)) && (this.mContext == null)) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView == null));
    if (this.ae == null)
    {
      this.ae = ausj.b(this.mContext);
      this.ae.addCancelButton(2131721058);
      if (this.caJ) {
        this.ae.addButton(2131719584);
      }
      if (this.caI) {
        this.ae.addButton(2131719585);
      }
      if ((!this.caI) && (!this.caJ)) {
        this.ae.addButton(2131719586);
      }
      this.ae.a(new arhb(this));
    }
    if (!((BaseActivity)this.mContext).isFinishing()) {
      this.ae.show();
    }
    VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_click", "", 0, "", "");
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    ExtendFriendProfileEditFragment.ExtendFriendInfo localExtendFriendInfo;
    if (paramView.getId() == 2131366600) {
      if (this.isOwner)
      {
        localObject = new Intent();
        if (this.jdField_d_of_type_ComTencentMobileqqDataCard != null)
        {
          localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_d_of_type_ComTencentMobileqqDataCard);
          localExtendFriendInfo.fontId = this.fontId;
          localExtendFriendInfo.clothesId = this.clothesId;
          ((Intent)localObject).putExtra("key_extend_friend_info", localExtendFriendInfo);
        }
        if ((this.mContext instanceof Activity))
        {
          anot.a(this.app, "dc00898", "", "", "0X80092DE", "0X80092DE", 1, 0, "", "", "", "");
          PublicFragmentActivity.startForResult((Activity)this.mContext, (Intent)localObject, ExtendFriendEditFragment.class, 4097);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.app;
      if (((FriendProfileCardActivity)this.mContext).aWx) {}
      for (int i = 1;; i = 2)
      {
        anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X80092E5", "0X80092E5", i, 0, "", "", "", "");
        eit();
        break;
      }
      if (paramView.getId() == 2131369082)
      {
        if (this.c.isPlaying())
        {
          this.c.aRx();
        }
        else
        {
          if (this.isOwner) {
            anot.a(this.app, "dc00898", "", "", "0X80092DD", "0X80092DD", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            this.c.ddV();
            break;
            i = (this.duration - 1) / 10;
            anot.a(this.app, "dc00898", "", "", "0X80092E4", "0X80092E4", i + 1, 0, "", "", "", "");
          }
        }
      }
      else if (paramView.getId() == 2131369721)
      {
        if (this.daD) {
          eiq();
        } else {
          eir();
        }
      }
      else
      {
        if (paramView.getId() == 2131380980)
        {
          if (this.isOwner) {
            anot.a(this.app, "dc00898", "", "", "0X80092DC", "0X80092DC", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            localObject = new Intent(getContext(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", "https://sqimg.qq.com/qq_product_operations/popularRule/popularRules.html");
            getContext().startActivity((Intent)localObject);
            break;
            anot.a(this.app, "dc00898", "", "", "0X80092E6", "0X80092E6", 0, 0, "", "", "", "");
          }
        }
        if (paramView.getId() == 2131367187) {
          if (this.isOwner)
          {
            localObject = new Intent();
            if (this.jdField_d_of_type_ComTencentMobileqqDataCard != null)
            {
              localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_d_of_type_ComTencentMobileqqDataCard);
              localExtendFriendInfo.fontId = this.fontId;
              localExtendFriendInfo.clothesId = this.clothesId;
              ((Intent)localObject).putExtra("key_extend_friend_info", localExtendFriendInfo);
            }
            if ((this.mContext instanceof Activity))
            {
              anot.a(this.app, "dc00898", "", "", "0X80092DE", "0X80092DE", 2, 0, "", "", "", "");
              PublicFragmentActivity.startForResult((Activity)this.mContext, (Intent)localObject, ExtendFriendEditFragment.class, 4097);
            }
          }
          else
          {
            eis();
          }
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mVasRes != null) {
      this.mVasRes.recycle();
    }
    this.mVasRes = null;
  }
  
  public void onPause()
  {
    if (this.c != null) {
      this.c.aRx();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mLayoutWidth = paramInt1;
    this.mLayoutHeight = paramInt2;
    if (this.contentView != null) {
      d(this.contentView, this.isTheme, this.daC);
    }
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.tR.setVisibility(0);
      return false;
    }
    this.tR.setVisibility(8);
    return false;
  }
  
  public void setClothes(int paramInt)
  {
    if (this.clothesId == paramInt) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        this.caJ = false;
        this.clothesId = paramInt;
        this.cl.setBackground(null);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(-16777216);
        this.jdField_ace_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.ach.setTextColor(-16777216);
        this.aci.setTextColor(-16777216);
        this.acj.setTextColor(-16777216);
        return;
      }
    } while (paramInt <= 10000);
    this.clothesId = paramInt;
    this.caJ = true;
    if ((this.cl.getBackground() instanceof VasResDrawable))
    {
      ((VasResDrawable)this.cl.getBackground()).update(paramInt);
      return;
    }
    VasResDrawable localVasResDrawable = new VasResDrawable(this.app, paramInt);
    aqry localaqry = new aqry(localVasResDrawable, this.app, 2130847025);
    localaqry.SR(true);
    localaqry.a(new arha(this));
    localVasResDrawable.a(localaqry);
    this.cl.setBackgroundDrawable(localVasResDrawable);
  }
  
  public void setDiyCard(boolean paramBoolean)
  {
    this.daF = paramBoolean;
  }
  
  public void setETTextColorFromClothes(aqqs paramaqqs)
  {
    if ((paramaqqs.fontColor != null) && (!TextUtils.isEmpty(paramaqqs.fontColor)))
    {
      this.cUn = Color.parseColor(paramaqqs.fontColor);
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView != null) && (this.cUn != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(this.cUn);
      }
    }
    if ((paramaqqs != null) && (paramaqqs.backgroundColor != null) && (!TextUtils.isEmpty(paramaqqs.backgroundColor)))
    {
      this.backgroundColor = Color.parseColor(paramaqqs.backgroundColor);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setColor(this.backgroundColor);
      if (SignTextEditFragment.isColorDark(this.backgroundColor))
      {
        this.jdField_ace_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.ach.setTextColor(-1);
        this.aci.setTextColor(-1);
        this.acj.setTextColor(-1);
        this.acf.setTextColor(-1);
        this.acg.setTextColor(-1);
      }
    }
    else
    {
      return;
    }
    this.jdField_ace_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.ach.setTextColor(-16777216);
    this.aci.setTextColor(-16777216);
    this.acj.setTextColor(-16777216);
    this.acf.setTextColor(-16777216);
    this.acg.setTextColor(-16777216);
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.daE = paramBoolean;
  }
  
  public void setFont(int paramInt1, int paramInt2)
  {
    if (this.fontId == paramInt1) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.caI = false;
      this.fontId = paramInt1;
      this.fontType = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    this.fontId = paramInt1;
    this.fontType = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFont(0, System.currentTimeMillis());
    this.caI = true;
    if (this.mVasRes == null)
    {
      this.mVasRes = new aqrn(this.app, paramInt1);
      aqsa localaqsa = new aqsa(this.mVasRes, this.app, paramInt2);
      localaqsa.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.getTextSize(), true);
      this.mVasRes.a(localaqsa);
      localaqsa.XS(-1);
      return;
    }
    ((aqsa)this.mVasRes.a()).a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.getTextSize(), true);
    ((aqsa)this.mVasRes.a()).update(paramInt1, paramInt2);
  }
  
  public void setIsFromLimitChat(boolean paramBoolean)
  {
    this.daB = paramBoolean;
    if (this.isOwner)
    {
      this.lr.setVisibility(8);
      return;
    }
    if (this.daB)
    {
      this.lr.setVisibility(8);
      return;
    }
    this.lr.setVisibility(0);
  }
  
  public void setProfileCardFavorShowView(ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView = paramProfileCardFavorShowView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView
 * JD-Core Version:    0.7.0.1
 */