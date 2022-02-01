package com.tencent.mobileqq.receipt;

import acfp;
import achq;
import acle;
import acrb;
import adxp;
import adyd;
import ajlc;
import aklr;
import akxb;
import akxb.a;
import alip;
import alsr;
import alss;
import alst;
import alsu;
import alsv;
import alte;
import altf;
import alyv;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.text.ClipboardManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import ansy;
import anvq;
import aofk;
import aofk.a;
import aofy;
import aomq;
import aoop;
import aptw;
import argt;
import ausj;
import avfp;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.a;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.b;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.a;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToast.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import jnm;
import ku;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x984.oidb_0x984.ReadReportReq;
import tencent.im.oidb.cmd0x984.oidb_0x984.ReqBody;
import tencent.im.oidb.cmd0x984.oidb_0x984.RspBody;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListReq;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListRsp;
import tencent.im.oidb.cmd0x985.oidb_0x985.ReqBody;
import tencent.im.oidb.cmd0x985.oidb_0x985.RspBody;
import tencent.im.oidb.cmd0x986.oidb_0x986.ReqBody;
import tencent.im.oidb.cmd0x986.oidb_0x986.RspBody;
import ujt;
import wja;
import xkx;
import xkx.a;
import xtm;

public class ReceiptMessageDetailFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, MediaPlayerManager.a, MediaPlayerManager.b, PttAudioWaveView.a, QQToast.a
{
  private long Bz;
  private ImageView Da;
  private View Gl;
  private long IT;
  private TextView Jo;
  private boolean Sf;
  private TextView XV;
  private argt jdField_a_of_type_Argt;
  private f jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment$f;
  private long ahG;
  private URLImageView av;
  private ETTextView jdField_b_of_type_ComEtrumpMixlayoutETTextView;
  private MediaPlayerManager jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private xkx.a jdField_b_of_type_Xkx$a;
  private boolean cze;
  private int dwS;
  private int dwT = -1;
  private int dwU = -1;
  private int dwV;
  private MessageForPtt e;
  private Button ha;
  private Runnable hq = new ReceiptMessageDetailFragment.4(this);
  private Runnable hr = new ReceiptMessageDetailFragment.5(this);
  private achq k;
  private achq l;
  private RelativeLayout lI;
  private QQAppInterface mApp;
  private ViewGroup mContainer;
  private boolean mIsRead;
  private View mLoadingView;
  private long mMsgTime;
  private int mMsgType;
  private String mResId;
  private SessionInfo mSessionInfo;
  private Handler mUiHandler = new a(this);
  private long oh;
  float yS = 0.0F;
  
  private void F(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "markMessageRealRead, readCount: " + paramInt1 + " totalCount: " + paramInt2 + " fromFetchReadStatus:" + paramBoolean);
    }
    if ((!this.Sf) && (paramBoolean)) {
      return;
    }
    MessageRecord localMessageRecord = this.mApp.b().b(this.mSessionInfo.aTl, this.dwS, this.IT);
    if (localMessageRecord == null)
    {
      QLog.d("ReceiptMessageDetailFragment", 1, "get message fail from mark message read");
      return;
    }
    if ((paramInt1 == 0) && (this.Sf))
    {
      QLog.d("ReceiptMessageDetailFragment", 2, "read count is 0 when mark message read");
      return;
    }
    if (!this.Sf)
    {
      alte.d(this.mApp, localMessageRecord, "1");
      return;
    }
    if (this.dwS == 0)
    {
      alte.d(this.mApp, localMessageRecord, "2");
      return;
    }
    if (paramInt1 >= paramInt2)
    {
      alte.d(this.mApp, localMessageRecord, "3");
      return;
    }
    alte.d(this.mApp, localMessageRecord, "4");
  }
  
  private int Ic()
  {
    return 0xFFFF & (int)this.ahG;
  }
  
  private Rect a(ImageView paramImageView)
  {
    Rect localRect = new Rect();
    if ((paramImageView == null) || (paramImageView.getDrawable() == null)) {
      return localRect;
    }
    Object localObject = new float[9];
    paramImageView.getImageMatrix().getValues((float[])localObject);
    float f1 = localObject[0];
    float f2 = localObject[4];
    localObject = paramImageView.getDrawable();
    int i = ((Drawable)localObject).getIntrinsicWidth();
    int j = ((Drawable)localObject).getIntrinsicHeight();
    i = Math.round(f1 * i);
    int m = Math.round(f2 * j);
    localRect.right = i;
    localRect.bottom = m;
    j = paramImageView.getWidth();
    m = (paramImageView.getHeight() - m) / 2;
    localRect.left = ((j - i) / 2);
    localRect.top = m;
    return localRect;
  }
  
  private xkx.a a(MessageForPtt paramMessageForPtt)
  {
    xkx.a locala = new xkx.a();
    locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = new BaseChatItemLayout(BaseApplicationImpl.getContext());
    BreathAnimationLayout localBreathAnimationLayout = new BreathAnimationLayout(BaseApplicationImpl.getContext());
    Object localObject1 = new PttAudioPlayView(getActivity(), 12);
    ((PttAudioPlayView)localObject1).setThemeColor(getActivity().getResources().getColorStateList(2131167322).getDefaultColor());
    ((PttAudioPlayView)localObject1).setId(2131374800);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).width = wja.dp2px(34.0F, getActivity().getResources());
    ((RelativeLayout.LayoutParams)localObject2).height = wja.dp2px(34.0F, getActivity().getResources());
    ((PttAudioPlayView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new PttAudioWaveView(getActivity());
    ((PttAudioWaveView)localObject2).setShouldDisallowInterceptTouch(true);
    ((PttAudioWaveView)localObject2).setProgressColor(getActivity().getResources().getColorStateList(2131167322).getDefaultColor());
    ((PttAudioWaveView)localObject2).setId(2131374801);
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).width = wja.dp2px(10.0F, getActivity().getResources());
    ((RelativeLayout.LayoutParams)localObject3).height = wja.dp2px(41.0F, getActivity().getResources());
    ((PttAudioWaveView)localObject2).setShouldDisallowInterceptTouch(true);
    ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((PttAudioWaveView)localObject2).setOnClickListener(this);
    localObject3 = new TextView(getActivity());
    ((TextView)localObject3).setId(2131374802);
    ((TextView)localObject3).setTextColor(getActivity().getResources().getColorStateList(2131167322));
    VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(getActivity());
    localVoicePrintView.setId(2131374803);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject4 = new SyncParentPressedRelativeLayout(BaseApplicationImpl.getContext());
    ((RelativeLayout)localObject4).setId(2131374798);
    ((RelativeLayout)localObject4).addView((View)localObject2);
    ((RelativeLayout)localObject4).addView((View)localObject1);
    ((RelativeLayout)localObject4).addView((View)localObject3);
    ((RelativeLayout)localObject4).addView(localVoicePrintView);
    localBreathAnimationLayout.addView((View)localObject4);
    locala.c = localBreathAnimationLayout;
    locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = ((PttAudioPlayView)localObject1);
    locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
    locala.ET = ((TextView)localObject3);
    locala.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
    locala.hG = ((RelativeLayout)localObject4);
    locala.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
    boolean bool;
    label611:
    int i;
    if (paramMessageForPtt.isSend())
    {
      ((RelativeLayout.LayoutParams)locala.ET.getLayoutParams()).addRule(1, 2131374801);
      ((RelativeLayout.LayoutParams)locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374800);
      ((RelativeLayout.LayoutParams)locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      if ((!paramMessageForPtt.isSendFromLocal()) || (paramMessageForPtt.fileSize != -2L)) {
        break label860;
      }
      if (!QLog.isColorLevel()) {
        break label872;
      }
      localObject1 = QQRecorder.Cf();
      if ((paramMessageForPtt.fileSize != -2L) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(paramMessageForPtt.getLocalFilePath()))) {
        break label854;
      }
      bool = true;
      QLog.d("ReceiptMessageDetailFragment", 2, "isRecording: " + bool);
      i = 999;
    }
    for (;;)
    {
      int j = i;
      if (i == -1)
      {
        a(locala, paramMessageForPtt, false, true);
        j = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "fileStatus = " + j + " url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
      }
      a(locala, paramMessageForPtt, j, d(paramMessageForPtt));
      alip.a(this.mApp).f(paramMessageForPtt);
      aomq.a(this.mApp, j, paramMessageForPtt);
      if (AppSetting.enableTalkBack)
      {
        paramMessageForPtt = String.format(acfp.m(2131713651), new Object[] { paramMessageForPtt.timeStr });
        localBreathAnimationLayout.setContentDescription(paramMessageForPtt);
        locala.hG.setContentDescription(paramMessageForPtt);
      }
      return locala;
      ((RelativeLayout.LayoutParams)locala.ET.getLayoutParams()).addRule(1, 2131374801);
      ((RelativeLayout.LayoutParams)locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374800);
      ((RelativeLayout.LayoutParams)locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      break;
      label854:
      bool = false;
      break label611;
      label860:
      i = xkx.a(this.mApp, paramMessageForPtt);
      continue;
      label872:
      i = 999;
    }
  }
  
  private void a(xkx.a parama)
  {
    parama.ET.setCompoundDrawablePadding(0);
    parama.ET.setCompoundDrawables(null, null, null, null);
  }
  
  private boolean a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    boolean bool = alyv.isLongPhoto((int)paramDouble1, (int)paramDouble2);
    int i = aoop.AIO_IMAGE_MAX_SIZE;
    return ((bool) && (paramDouble1 <= paramInt1) && (paramDouble2 <= paramInt2)) || ((paramDouble1 < i) && (paramDouble2 < i));
  }
  
  private void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!isAdded()) {}
    do
    {
      return;
      if ((paramBoolean1) && (!wja.Rc()))
      {
        if (this.Gl == null)
        {
          LayoutInflater.from(this.mApp.getApp()).inflate(2131558689, (ViewGroup)this.mContentView);
          this.Gl = this.mContentView.findViewById(2131362513);
          this.XV = ((TextView)this.mContentView.findViewById(2131362514));
          this.Gl.setOnClickListener(this);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Gl.getLayoutParams();
          localLayoutParams.addRule(11);
          localLayoutParams.addRule(12);
          if (this.mSessionInfo.cZ != 0) {
            localLayoutParams.bottomMargin += wja.dp2px(45.0F, getResources());
          }
        }
        this.Gl.setVisibility(0);
        if (paramBoolean2) {
          this.XV.setText(2131690245);
        }
        for (;;)
        {
          this.Gl.setSelected(paramBoolean2);
          return;
          this.XV.setText(2131690244);
        }
      }
    } while (this.Gl == null);
    this.Gl.setVisibility(8);
  }
  
  private achq b()
  {
    if (this.k == null) {
      this.k = new alst(this);
    }
    return this.k;
  }
  
  private void b(MessageForPtt paramMessageForPtt)
  {
    if (!isAdded()) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.mApp.getManager(24));
    this.e = paramMessageForPtt;
    this.jdField_b_of_type_Xkx$a = a(paramMessageForPtt);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.weight = 0.0F;
    localLayoutParams1.gravity = 16;
    this.jdField_b_of_type_Xkx$a.E = this.jdField_b_of_type_Xkx$a.c;
    a(paramMessageForPtt, this.mApp.getApp(), this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_b_of_type_Xkx$a);
    dJq();
    this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setPadding(0, 0, 0, wja.dp2px(7.0F, this.mApp.getApp().getResources()));
    this.jdField_b_of_type_Xkx$a.c.setFocusable(false);
    if (AppSetting.enableTalkBack) {
      ViewCompat.setImportantForAccessibility(this.jdField_b_of_type_Xkx$a.c, 2);
    }
    this.mContainer.setBackgroundResource(2130838345);
    paramMessageForPtt = new View(BaseApplicationImpl.getContext());
    View localView = new View(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(0, 0);
    localLayoutParams2.weight = 1.0F;
    this.mContainer.addView(paramMessageForPtt, localLayoutParams2);
    this.mContainer.addView(this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localLayoutParams1);
    this.mContainer.addView(localView, localLayoutParams2);
  }
  
  private void bM(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "setReadMemberCount, count: " + paramInt + " isSucc: " + paramBoolean);
    }
    if (!isAdded()) {
      return;
    }
    if (paramBoolean) {
      this.mLoadingView.setVisibility(4);
    }
    if (this.mSessionInfo.cZ == 0)
    {
      if (paramInt > 0)
      {
        localButton = this.ha;
        if (this.Sf) {}
        for (paramInt = 2131700672;; paramInt = 2131700674)
        {
          localButton.setText(paramInt);
          return;
        }
      }
      Button localButton = this.ha;
      if (this.Sf) {}
      for (paramInt = 2131700673;; paramInt = 2131700675)
      {
        localButton.setText(paramInt);
        return;
      }
    }
    this.ha.setText(String.format(getString(2131700676), new Object[] { Integer.toString(paramInt) }));
    this.ha.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130838344), null);
    this.ha.setCompoundDrawablePadding(wja.dp2px(5.0F, getResources()));
  }
  
  private achq c()
  {
    if (this.l == null) {
      this.l = new alsu(this);
    }
    return this.l;
  }
  
  private void c(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.mApp.a().a(paramMessageForPtt, null);
    dJk();
  }
  
  private void c(MessageForText paramMessageForText)
  {
    dJc();
    if (!TextUtils.isEmpty(paramMessageForText.sb)) {
      if (!TextUtils.isEmpty(paramMessageForText.sb2))
      {
        q(paramMessageForText.sb2);
        if (AppSetting.enableTalkBack)
        {
          paramMessageForText = aofy.og(paramMessageForText.msg);
          this.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setContentDescription(paramMessageForText);
        }
      }
    }
    for (;;)
    {
      dJk();
      return;
      q(paramMessageForText.sb);
      break;
      this.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setText("");
    }
  }
  
  private void copyText()
  {
    try
    {
      ((ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard")).setText(this.jdField_b_of_type_ComEtrumpMixlayoutETTextView.getText());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReceiptMessageDetailFragment", 2, localException.toString());
    }
  }
  
  private void dJc()
  {
    this.jdField_b_of_type_ComEtrumpMixlayoutETTextView = new ETTextView(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    Resources localResources = getResources();
    int i = localResources.getDimensionPixelSize(2131298568);
    this.mContainer.setPadding(i, i, i, 0);
    this.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, localResources.getDimensionPixelSize(2131298571));
    this.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(localResources.getColor(2131167427));
    i = wja.dp2px(11.0F, localResources);
    this.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLineSpacing(i, 1.0F);
    this.mContainer.setBackgroundResource(2130838346);
    ((FrameLayout.LayoutParams)this.mContainer.getLayoutParams()).gravity = 0;
    this.mContainer.setOnLongClickListener(new d(this, null));
    this.mContainer.addView(this.jdField_b_of_type_ComEtrumpMixlayoutETTextView, localLayoutParams);
  }
  
  private void dJd()
  {
    QQToast.a(this.mApp.getApp(), 1, 2131700668, 0).a(this);
  }
  
  private void dJe()
  {
    this.av = new URLImageView(BaseApplicationImpl.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.av.setAdjustViewBounds(true);
    if (AppSetting.enableTalkBack) {
      this.av.setContentDescription(acfp.m(2131713654));
    }
    this.mContainer.setBackgroundColor(Color.parseColor("#f7f7f9"));
    this.lI = new RelativeLayout(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    this.lI.addView(this.av, localLayoutParams);
    this.mContainer.setBackgroundResource(2130838345);
    this.mContainer.addView(this.lI, localLayoutParams1);
  }
  
  private void dJf()
  {
    Object localObject = ajlc.a().a(this.mApp, this.IT);
    Message localMessage = this.mUiHandler.obtainMessage(0);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (ChatMessage)((List)localObject).get(((List)localObject).size() - 1);
      ((ChatMessage)localObject).parse();
      localMessage.obj = localObject;
      if (!(localObject instanceof MessageForText)) {
        break label133;
      }
      localMessage.what = 1;
    }
    for (;;)
    {
      if ((localObject instanceof MessageForPtt)) {
        localMessage.what = 3;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "queryLocalMessages, message is " + ((ChatMessage)localObject).toString());
      }
      this.mUiHandler.sendMessage(localMessage);
      return;
      label133:
      if ((localObject instanceof MessageForPic)) {
        localMessage.what = 2;
      }
    }
  }
  
  private void dJg()
  {
    if (!isAdded()) {
      return;
    }
    this.ha = ((Button)this.mContentView.findViewById(2131376665));
    View localView = this.mContentView.findViewById(2131363629);
    this.mLoadingView = this.mContentView.findViewById(2131370804);
    this.ha.setOnClickListener(this);
    localView.setTouchDelegate(new TouchDelegate(new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, wja.dp2px(45.0F, getResources())), this.ha));
    bM(0, false);
    if (this.mSessionInfo.cZ == 0) {
      this.ha.setClickable(false);
    }
    localView.setVisibility(0);
  }
  
  private void dJh()
  {
    this.cze = true;
    if (this.mSessionInfo.cZ == 0)
    {
      QQToast.a(this.mApp.getApp(), 1, 2131700657, 0).a(this);
      return;
    }
    QQToast.a(this.mApp.getApp(), 1, 2131700658, 0).a(this);
  }
  
  private void dJi()
  {
    this.mContentView.findViewById(2131366516).setVisibility(0);
    stopTitleProgress();
  }
  
  private void dJj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment$f == null) {
      this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment$f = new f(this);
    }
    alte.a().a(this.mApp, this.mResId, this.mApp.getCurrentAccountUin(), this.mSessionInfo.aTl, this.mSessionInfo.aTl, this.mSessionInfo.cZ, this.IT, 1035, this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment$f);
  }
  
  private void dJk()
  {
    if (this.Sf) {
      return;
    }
    if (this.mIsRead)
    {
      this.mUiHandler.sendEmptyMessage(4);
      return;
    }
    ThreadManager.post(this.hq, 8, null, false);
  }
  
  private void dJl()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.mMsgTime);
    localReqBody.uint64_group_code.set(parseLong(this.mSessionInfo.aTl));
    localReqBody.uint32_msg_seq.set((int)this.ahG);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.Bz);
    jnm.a(this.mApp, new h(this), localReqBody.toByteArray(), "OidbSvc.0x986_0", 2438, 0);
  }
  
  private void dJm()
  {
    oidb_0x984.ReqBody localReqBody = new oidb_0x984.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x984.ReadReportReq localReadReportReq = new oidb_0x984.ReadReportReq();
    localReadReportReq.uint32_msg_seq.set((int)this.ahG);
    localReadReportReq.uint64_conf_uin.set(parseLong(this.mSessionInfo.aTl));
    localReadReportReq.uint64_from_uin.set(this.Bz);
    localReqBody.msg_read_report_req.set(localReadReportReq);
    jnm.a(this.mApp, new c(this), localReqBody.toByteArray(), "OidbSvc.0x984_0", 2436, 0);
  }
  
  private void dJn()
  {
    if ((this.mSessionInfo.cZ == 0) && (!this.Sf)) {
      return;
    }
    ThreadManager.post(this.hr, 8, null, false);
  }
  
  private void dJo()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.mMsgTime);
    localReqBody.uint64_group_code.set(parseLong(this.mSessionInfo.aTl));
    localReqBody.uint32_msg_seq.set((int)this.ahG);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.Bz);
    jnm.a(this.mApp, new g(this), localReqBody.toByteArray(), "OidbSvc.0x986_2", 2438, 2);
  }
  
  private void dJp()
  {
    oidb_0x985.ReqBody localReqBody = new oidb_0x985.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x985.GetReadListReq localGetReadListReq = new oidb_0x985.GetReadListReq();
    localGetReadListReq.uint32_msg_seq.set((int)this.ahG);
    localGetReadListReq.uint64_conf_uin.set(parseLong(this.mSessionInfo.aTl));
    localGetReadListReq.uint64_from_uin.set(this.Bz);
    localReqBody.msg_get_read_list_req.set(localGetReadListReq);
    jnm.a(this.mApp, new b(this), localReqBody.toByteArray(), "OidbSvc.0x985", 2437, 0);
  }
  
  private void dJq()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_Xkx$a.E.getLayoutParams();
    localLayoutParams.addRule(0, 0);
    localLayoutParams.addRule(1, 0);
    localLayoutParams.addRule(13);
  }
  
  private void dJr()
  {
    int i = this.dwV + 1;
    this.dwV = i;
    if (i < 3)
    {
      dJk();
      if (QLog.isDebugVersion()) {
        QLog.d("ReceiptMessageDetailFragment", 4, "resend read report, retry count: " + this.dwV);
      }
      return;
    }
    this.mUiHandler.sendEmptyMessage(5);
  }
  
  private void dJs()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SESSION_INFO", this.mSessionInfo);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SENDER_UIN", this.Bz);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.extra_shmsgseq", this.ahG);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_IS_SENDER", this.Sf);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_UNISEQ", this.IT);
    if (this.mSessionInfo.cZ == 1)
    {
      localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_TROOP_CODE", parseLong(this.mSessionInfo.aTl));
      localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_TIME", this.mMsgTime);
    }
    if (getActivity() == null) {
      return;
    }
    PublicFragmentActivity.startForResult(getActivity(), localIntent, ReceiptMessageReadMemberListContainerFragment.class, 100);
  }
  
  private void initData()
  {
    Bundle localBundle = getArguments();
    this.IT = localBundle.getLong("ReceiptMessageDetailFragment.extra_msg_uni_seq", -1L);
    this.mSessionInfo = ((SessionInfo)localBundle.getParcelable("ReceiptMessageDetailFragment.extra_msg_session_info"));
    this.mResId = localBundle.getString("ReceiptMessageDetailFragment.extra_res_id");
    this.ahG = localBundle.getLong("ReceiptMessageDetailFragment.extra_shmsgseq", -1L);
    this.Bz = parseLong(localBundle.getString("ReceiptMessageDetailFragment.extra_sender_uin"));
    this.oh = localBundle.getLong("ReceiptMessageDetailFragment.extra_msg_uid", -1L);
    this.mMsgTime = localBundle.getLong("ReceiptMessageDetailFragment.extra_msg_time", -1L);
    this.dwS = localBundle.getInt("ReceiptMessageDetailFragment.EXTRA_SESSION_TYPE_FROM_MESSAGE", -1);
    this.mIsRead = localBundle.getBoolean("ReceiptMessageDetailFragment.EXTRA_IS_READ", false);
    if (parseLong(this.mApp.getCurrentAccountUin()) == this.Bz) {}
    for (boolean bool = true;; bool = false)
    {
      this.Sf = bool;
      if ((this.IT < 0L) || (this.mSessionInfo == null) || (this.Bz < 0L) || (this.oh < 0L)) {
        QLog.d("ReceiptMessageDetailFragment", 1, "invalid msg seq or null session info");
      }
      ThreadManager.post(new ReceiptMessageDetailFragment.1(this), 8, null, false);
      return;
    }
  }
  
  private long parseLong(String paramString)
  {
    try
    {
      long l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, QLog.getStackTraceString(paramString));
      }
    }
    return -1L;
  }
  
  private void q(CharSequence paramCharSequence)
  {
    int i = 0;
    if ((paramCharSequence instanceof aofk))
    {
      aofk.a[] arrayOfa = (aofk.a[])((aofk)paramCharSequence).getSpans(0, paramCharSequence.length(), aofk.a.class);
      if (arrayOfa.length > 0)
      {
        int j = arrayOfa.length;
        while (i < j)
        {
          arrayOfa[i].setSize((int)(this.jdField_b_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + 0.5F) + wja.dp2px(2.0F, this.mApp.getApp().getResources()));
          i += 1;
        }
      }
    }
    this.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setText(paramCharSequence);
  }
  
  private void s(URLDrawable paramURLDrawable)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    int m = localDisplayMetrics.heightPixels;
    double d2 = paramURLDrawable.getIntrinsicWidth();
    double d1 = paramURLDrawable.getIntrinsicHeight();
    float f = localDisplayMetrics.density;
    double d4 = d2 * f;
    double d5 = d1 * f;
    boolean bool = a(d4, d5, i, m);
    this.lI.getLayoutParams().height = -1;
    this.lI.getLayoutParams().width = -1;
    int j = 0;
    double d3;
    if (!bool)
    {
      m = m - ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getContext()) - getResources().getDimensionPixelSize(2131299627) - wja.dp2px(45.0F, getResources()) + 1;
      d2 = 2.0D * d4;
      d1 = d2;
      if (d2 > i) {
        d1 = i;
      }
      double d6 = d1 * d5 / d4;
      if (d5 >= 3.0D * d4)
      {
        i = 1;
        j = m;
        d2 = d6;
        d3 = d1;
        if (i == 0)
        {
          j = m;
          d2 = d6;
          d3 = d1;
          if (d6 > m)
          {
            d2 = m;
            d3 = d1 * d2 / m;
            j = m;
          }
        }
      }
    }
    for (;;)
    {
      this.av.getLayoutParams().height = ((int)(0.5D + d2));
      this.av.getLayoutParams().width = ((int)(0.5D + d3));
      this.av.setScaleType(ImageView.ScaleType.FIT_CENTER);
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "setImageViewSize, isSmall: " + bool + " size: " + d4 + " / " + d5 + " sizeToSet: " + d3 + " / " + d2 + " containerHeight: " + j);
      }
      return;
      i = 0;
      break;
      d2 = d5;
      d3 = d4;
    }
  }
  
  private void w(MessageForPic paramMessageForPic)
  {
    dJe();
    ajlc.a().setSessionInfo(this.mSessionInfo);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = "ReceiptMessageDetailFragment.isReceipt";
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mApp.getApp().getResources().getDrawable(2130838350);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mApp.getApp().getResources().getDrawable(2130838333);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    if ((paramMessageForPic.width > i) || (paramMessageForPic.height > j))
    {
      long l2 = paramMessageForPic.height;
      for (long l1 = paramMessageForPic.width; l2 * l1 > 10000000L; l1 /= 2L) {
        l2 /= 2L;
      }
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)l2);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)l1);
    }
    localObject = aoop.a(paramMessageForPic, 1, null, (URLDrawable.URLDrawableOptions)localObject);
    this.av.setImageDrawable((Drawable)localObject);
    this.av.setOnClickListener(new alsr(this, paramMessageForPic));
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "showPicMessage when drawable's status is succeeded");
      }
      s((URLDrawable)localObject);
      dJk();
    }
    for (;;)
    {
      this.av.setURLDrawableDownListener(new alss(this));
      ((URLDrawable)localObject).setAutoDownload(true);
      return;
      try
      {
        paramMessageForPic = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130849452);
        this.jdField_a_of_type_Argt = new argt(paramMessageForPic, (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 12.0F));
        this.jdField_a_of_type_Argt.setLevel(0);
        this.Da = new ImageView(BaseApplicationImpl.getContext());
        paramMessageForPic = new RelativeLayout.LayoutParams(-2, -2);
        i = wja.dp2px(40.0F, BaseApplicationImpl.getContext().getResources());
        paramMessageForPic.width = i;
        paramMessageForPic.height = i;
        Rect localRect = new Rect(0, 0, i, i);
        this.jdField_a_of_type_Argt.setBounds(localRect);
        paramMessageForPic.addRule(13);
        this.Da.setImageDrawable(this.jdField_a_of_type_Argt);
        this.lI.addView(this.Da, paramMessageForPic);
      }
      catch (OutOfMemoryError paramMessageForPic)
      {
        for (;;)
        {
          paramMessageForPic = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
        }
      }
    }
  }
  
  public void a(Context paramContext, ImageView paramImageView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo)
  {
    localObject = new int[2];
    paramImageView.getLocationOnScreen((int[])localObject);
    paramImageView = a(paramImageView);
    paramImageView.offset(localObject[0], localObject[1]);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramImageView);
    localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", 0);
    if (paramSessionInfo.cZ == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.aTl);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.troopUin);
    }
    if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    for (;;)
    {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", true);
      localBundle.putBoolean("extra.IS_RECEIPT_MSG", true);
      localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      localObject = paramChatMessage.selfuin;
      paramImageView = (ImageView)localObject;
      if (paramChatMessage.isMultiMsg) {}
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramImageView = (ImageView)localObject;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramImageView = localAppRuntime.getAccount();
        }
      }
      catch (Exception paramImageView)
      {
        for (;;)
        {
          boolean bool;
          paramImageView = (ImageView)localObject;
        }
      }
      bool = aklr.ae(getActivity().app.getCurrentAccountUin(), 1);
      localBundle.putBoolean("extra.OCR", bool);
      if (bool)
      {
        localObject = aklr.mw(getActivity().app.getCurrentAccountUin());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localBundle.putString("extra.OCR_TEXT", (String)localObject);
        }
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.cZ);
      localBundle.putString("uin", paramChatMessage.frienduin);
      localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      avfp.a(paramContext, localBundle, new AIOImageProviderService(paramImageView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), xtm.a((MessageForPic)paramChatMessage), -1, -1);
      if (QLog.isColorLevel()) {
        QLog.i("ReceiptMessageDetailFragment", 2, "ReceiptMessageDetailFragment.enterImagePreview()");
      }
      return;
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.bNV;
    int i = j;
    if (ansy.U(paramChatMessage)) {
      i = j - wja.dp2px(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.bNY, i, BaseChatItemLayout.bNX, BaseChatItemLayout.bNW);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.bNX, i, BaseChatItemLayout.bNY, BaseChatItemLayout.bNW);
  }
  
  protected void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    xkx.a locala = (xkx.a)parame;
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()))
    {
      parame = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        parame = parame.getColorStateList(2131167326);
        if ((locala.ET != null) && (parame != null)) {
          locala.ET.setTextColor(parame);
        }
        if ((locala.Jp != null) && (parame != null)) {
          locala.Jp.setTextColor(parame);
        }
      }
    }
    for (;;)
    {
      return;
      parame = parame.getColorStateList(2131167322);
      break;
      if (paramadxp.mTextColor == 0)
      {
        locala.ET.setTextColor(-16777216);
        if (locala.Jp != null) {
          locala.Jp.setTextColor(-16777216);
        }
      }
      while ((paramadxp.bRF) && (((ChatBackgroundManager)this.mApp.getManager(63)).a(BaseApplicationImpl.getContext(), this.mSessionInfo, locala.ET.getCurrentTextColor(), 10000.0D * locala.jdField_b_of_type_Adxp.cs) == 1))
      {
        float f2 = locala.ET.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        locala.ET.setTextColor(-1);
        locala.ET.setShadowLayer(f1, 0.0F, 0.0F, paramadxp.mStrokeColor);
        return;
        locala.ET.setTextColor(paramadxp.mTextColor);
        if (locala.Jp != null) {
          locala.Jp.setTextColor(paramadxp.mTextColor);
        }
      }
    }
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onStartSeek ");
    }
    MediaPlayerManager.a(this.mApp).stop(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onSeekProgressUpdate, progress = " + paramFloat);
    }
    this.yS = paramFloat;
    if (this.e != null)
    {
      this.e.playProgress = paramFloat;
      if ((this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView == null) || (this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getPlayState())) {}
    }
    else
    {
      return;
    }
    int i = (int)(this.e.voiceLength * 1000.0F * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onSeekProgressUpdate, offset = " + i);
    }
    MediaPlayerManager.a(this.mApp).b(this.e, i);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame)
  {
    parame.bvc = 1;
    parame.jdField_b_of_type_Adxp = adyd.a(0, this.mApp, paramContext.getResources(), null, false);
    if (parame.jdField_b_of_type_Adxp != null) {
      parame.jdField_b_of_type_Adxp.m(parame.E, null);
    }
    if (parame.E != null)
    {
      parame.E.setMinimumWidth(wja.dp2px(65.0F, this.mApp.getApp().getResources()));
      parame.E.setMinimumHeight(wja.dp2px(57.0F, this.mApp.getApp().getResources()));
    }
    if (parame.jdField_b_of_type_Adxp != null)
    {
      int j = paramChatMessage.vipBubbleDiyTextId;
      int i = j;
      if (j <= 0) {
        i = acle.R(paramChatMessage.vipBubbleID);
      }
      parame.jdField_b_of_type_Adxp.a(this.mApp, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), false, parame.E, ku.a(paramChatMessage), i);
    }
    if (parame.E != null)
    {
      paramContext = parame.E.getBackground();
      if (paramContext != null) {
        paramContext.setAlpha(255);
      }
    }
    if (parame.jdField_b_of_type_Adxp != null) {
      a(parame, paramBaseChatItemLayout, paramChatMessage, parame.jdField_b_of_type_Adxp);
    }
    paramChatMessage.mAnimFlag = false;
    if (parame.E != null)
    {
      paramBaseChatItemLayout.setBubbleView(parame.E);
      a(parame.E, paramChatMessage);
      parame.E.setTag(2131364051, parame.jdField_b_of_type_Adxp);
      parame.E.setTag(2131364546, paramChatMessage);
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onPlayProgress , progress_time = " + paramLong + " , progress_ratio = " + paramFloat);
    }
    if ((this.jdField_b_of_type_Xkx$a != null) && (paramFloat > 0.0F))
    {
      this.yS = paramFloat;
      if (this.jdField_b_of_type_Xkx$a.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
      {
        this.jdField_b_of_type_Xkx$a.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
        if ((paramChatMessage instanceof MessageForPtt)) {
          ((MessageForPtt)paramChatMessage).playProgress = paramFloat;
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if ((paramView != null) && (this.jdField_b_of_type_Xkx$a != null) && (this.e != null) && (this.jdField_b_of_type_Xkx$a.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null))
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_Xkx$a.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
        this.e.playProgress = 0.0F;
        this.jdField_b_of_type_Xkx$a.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
        this.jdField_b_of_type_Xkx$a.zu(false);
      }
      if (this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
  }
  
  protected void a(xkx.a parama, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)parama.hG.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    int i = 0;
    if (parama.tj != null)
    {
      parama.tj.setVisibility(8);
      parama.tj.setOnClickListener(null);
      parama.tk.setVisibility(8);
    }
    if (parama.Jp != null)
    {
      parama.Jp.setVisibility(8);
      parama.Jp.setOnClickListener(null);
      parama.tl.setVisibility(8);
      parama.tm.setVisibility(8);
    }
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    parama.hG.setOnTouchListener(parama.jdField_a_of_type_Wlz);
    parama.hG.setOnLongClickListener(parama.jdField_a_of_type_Wlz);
    Object localObject2 = BaseApplicationImpl.getContext().getResources();
    int j = wja.dp2px(15.0F, (Resources)localObject2);
    switch (paramInt)
    {
    default: 
      paramInt = i;
      localObject1 = (anvq)this.mApp.getManager(17);
      i = paramInt;
      if (paramMessageForPtt.sttAbility == 1)
      {
        i = paramInt;
        if (((anvq)localObject1).l(paramMessageForPtt)) {
          i = 4;
        }
      }
      switch (i)
      {
      case 2: 
      case 3: 
      default: 
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc != null) {
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
        }
        break;
      }
      break;
    }
    do
    {
      return;
      parama.ET.setText("");
      parama.ET.setPadding(wja.dp2px(10.0F, (Resources)localObject2), BaseChatItemLayout.bOa, wja.dp2px(10.0F, (Resources)localObject2), BaseChatItemLayout.bOb);
      if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(parama);
      paramInt = 1;
      parama.c.setAnimating(false);
      ((RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = j;
      parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      break;
      ((RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = j;
      parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      parama.ET.setText("");
      parama.ET.setPadding(wja.dp2px(40.0F, (Resources)localObject2), BaseChatItemLayout.bOa, wja.dp2px(40.0F, (Resources)localObject2), BaseChatItemLayout.bOb);
      if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      parama.c.setAnimating(true);
      paramInt = i;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.n(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength > 0) {
        break label796;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "get a amr file length = 0 return now");
      }
      parama.ET.setText("");
      parama.ET.setPadding(wja.dp2px(10.0F, (Resources)localObject2), BaseChatItemLayout.bOa, wja.dp2px(10.0F, (Resources)localObject2), BaseChatItemLayout.bOb);
    } while (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label796:
    if (paramMessageForPtt.voiceLength > xkx.f(this.mApp, "ConvertText_MaxPtt")) {
      paramMessageForPtt.sttAbility = 0;
    }
    if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
      paramMessageForPtt.timeStr = xkx.az(paramMessageForPtt.voiceLength);
    }
    Object localObject3 = paramMessageForPtt.timeStr;
    parama.ET.setText((CharSequence)localObject3);
    a(parama);
    parama.c.setAnimating(false);
    parama.hG.setOnClickListener(this);
    if (paramMessageForPtt.isSend()) {
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        localObject1 = ((aptw)this.mApp.getManager(203)).a(this.mApp, paramMessageForPtt);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
        }
      }
      else
      {
        label944:
        if ((paramInt != 2003) && (paramInt != 1003)) {
          break label2060;
        }
        if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
        if ((paramMessageForPtt.sttAbility != 2) || (paramMessageForPtt.voiceChangeFlag == 1) || (!paramMessageForPtt.expandStt)) {
          break label2231;
        }
        paramInt = 0;
        i = 2;
      }
    }
    for (;;)
    {
      label1010:
      int m = wja.dp2px(9.0F, (Resources)localObject2);
      int n = wja.dp2px(12.0F, (Resources)localObject2);
      int i1 = ((Resources)localObject2).getDrawable(2130845739).getIntrinsicHeight();
      int i2 = wja.dp2px(1.0F, (Resources)localObject2);
      j = wja.dp2px(3.0F, (Resources)localObject2);
      parama.ET.setPadding(0, BaseChatItemLayout.bOa, m, BaseChatItemLayout.bOb);
      parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, j, 0);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(m, 0, m, 0);
      if (i == 2)
      {
        if (parama.Jp != null) {
          break label2103;
        }
        ImageView localImageView1 = new ImageView(BaseApplicationImpl.getContext());
        localImageView1.setImageDrawable(new ColorDrawable(838860800));
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i2);
        localImageView1.setLayoutParams(localLayoutParams1);
        localImageView1.setId(2131374818);
        TextView localTextView = new TextView(BaseApplicationImpl.getContext());
        if (!paramMessageForPtt.isSend()) {
          break label2090;
        }
        localObject1 = ((Resources)localObject2).getColorStateList(2131167326);
        label1198:
        if (localObject1 != null) {
          localTextView.setTextColor((ColorStateList)localObject1);
        }
        localTextView.setId(2131374817);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ImageView localImageView2 = new ImageView(BaseApplicationImpl.getContext());
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        localImageView2.setLayoutParams(localLayoutParams2);
        localImageView2.setImageResource(2130845739);
        localImageView2.setScaleType(ImageView.ScaleType.FIT_END);
        localLayoutParams1.addRule(3, 2131374798);
        localLayoutParams1.addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131374818);
        localLayoutParams2.addRule(3, 2131374818);
        localLayoutParams2.addRule(14);
        localLayoutParams2.addRule(6, 2131374817);
        localLayoutParams2.addRule(8, 2131374817);
        parama.c.addView(localImageView1);
        parama.c.addView(localTextView);
        parama.c.addView(localImageView2);
        parama.tl = localImageView1;
        parama.Jp = localTextView;
        parama.tm = localImageView2;
      }
      for (;;)
      {
        parama.Jp.setOnClickListener(this);
        parama.Jp.setOnTouchListener(parama.jdField_a_of_type_Wlz);
        parama.Jp.setOnLongClickListener(parama.jdField_a_of_type_Wlz);
        parama.Jp.setTextSize(0, this.mSessionInfo.cN);
        localObject1 = (RelativeLayout.LayoutParams)parama.tl.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374798);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374798);
        localObject1 = (RelativeLayout.LayoutParams)parama.Jp.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374798);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374798);
        i2 = wja.dp2px(22.0F, (Resources)localObject2);
        parama.tl.setPadding(m, 0, m, 0);
        parama.Jp.setPadding(m, BaseChatItemLayout.bOa, m, i2 + i1);
        parama.tm.setPadding(0, 0, 0, n);
        localObject2 = paramMessageForPtt.sttText;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = getActivity().getString(2131720496);
        }
        parama.Jp.setText((CharSequence)localObject1);
        float f = 0.0F;
        if (i == 2)
        {
          localObject2 = paramMessageForPtt.sttText;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getActivity().getString(2131720496);
          }
          if (this.Jo == null) {
            this.Jo = new TextView(getActivity());
          }
          this.Jo.setTextSize(0, this.mSessionInfo.cN);
          f = this.Jo.getPaint().measureText((String)localObject1);
        }
        i = (int)wja.a((int)parama.ET.getPaint().measureText((String)localObject3), getActivity().getResources());
        i = xkx.a(getActivity(), paramMessageForPtt.voiceLength, f, m + i, j, false, false);
        localObject1 = (RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = i;
        localObject2 = VoicePrintUtils.a(this.mApp, false, false, i + m, parama);
        localObject3 = (RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).width = (localObject2[0] + localObject2[1] + localObject2[2]);
        ((RelativeLayout.LayoutParams)localObject3).height = VoicePrintUtils.a(this.mApp, false, parama);
        if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null)
        {
          i = localObject2[0];
          m = localObject2[1];
          ((RelativeLayout.LayoutParams)localObject3).width = (localObject2[2] + (i + m));
          ((RelativeLayout.LayoutParams)localObject3).height = VoicePrintUtils.a(this.mApp, false, parama);
          if (QLog.isColorLevel()) {
            QLog.d("ReceiptMessageDetailFragment", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject3).width + ", flagTimeContainer.getLeft()=" + parama.hG.getLeft());
          }
          parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
        }
        if (paramMessageForPtt.voiceLength > 0) {
          parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject1).width - j, paramMessageForPtt.voiceLength);
        }
        parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
        parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
        if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
          parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
        }
        break;
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject1, null);
        break label944;
        localObject1 = ((aptw)this.mApp.getManager(203)).a(this.mApp, paramMessageForPtt);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label944;
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject1, null);
        break label944;
        label2060:
        if ((paramInt == 1005) || (paramInt == 1004))
        {
          paramInt = 1;
          i = 1;
          break label1010;
        }
        paramInt = 4;
        i = 1;
        break label1010;
        label2090:
        localObject1 = ((Resources)localObject2).getColorStateList(2131167322);
        break label1198;
        label2103:
        parama.tl.setVisibility(0);
        parama.Jp.setVisibility(0);
        parama.tm.setVisibility(0);
      }
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
      localObject1 = parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (parama = acfp.m(2131713653);; parama = acfp.m(2131713652))
      {
        ((ImageView)localObject1).setContentDescription(parama);
        return;
      }
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839657, null);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
      ((Animatable)parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getDrawable()).start();
      return;
      label2231:
      paramInt = 0;
      i = 1;
    }
  }
  
  protected void a(xkx.a parama, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ujt.a(this.mApp, this.mSessionInfo.aTl, paramMessageForPtt, false, 5, 0, paramBoolean2, new e(this));
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    alip.a(this.mApp).g(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = this.jdField_b_of_type_Xkx$a;
      if (paramAudioPlayerBase.seekPlay(paramXListView.getLocalFilePath(), paramInt2))
      {
        c(paramXListView);
        if (paramView != null)
        {
          a(paramView, paramXListView, xkx.a(this.mApp, paramXListView), true);
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
          if (paramView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
            paramView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          }
          paramView.zu(true);
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "play failed player return false " + paramXListView.getLocalFilePath());
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "play failed not ready " + paramXListView.getLocalFilePath());
      }
    }
  }
  
  public boolean auu()
  {
    return isVisible();
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, String.format("onHeadsetChanged, wiredHeadsetConnect: %b, btHeadsetConnect : %b, speakerPhoneOn : %b, callFromBoradcast : %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }));
    }
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.bM(this.mApp.getApp());
      }
    }
    BaseChatPie.b(this.mApp.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.isPlaying()) {
      if ((paramBoolean1) || (paramBoolean4)) {
        break label123;
      }
    }
    label123:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      aF(paramBoolean1, paramBoolean3);
      return;
    }
  }
  
  protected boolean d(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a();
    return (this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.isPlaying()) && ((localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq)));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131700680));
    startTitleProgress();
    setLeftViewName(2131700664);
    this.mContainer = ((ViewGroup)this.mContentView.findViewById(2131371311));
    initData();
  }
  
  public boolean e(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onNearToEar, nearEear: " + paramBoolean1 + " / speakerPhoneOn:" + paramBoolean2);
    }
    if (isResumed())
    {
      BaseChatPie.b(this.mApp.getApp(), paramBoolean2, false, false);
      aF(true, paramBoolean2);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558708;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramInt1 = paramIntent.getIntExtra("ReceiptMessageReadMemberListContainerFragment.RESULT_KEY_READ_NUMBER", 0);
    } while (paramInt1 <= 0);
    bM(paramInt1, true);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)getActivity().getAppInterface());
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onClick(View paramView)
  {
    if (!isAdded()) {}
    boolean bool;
    label82:
    int i;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131362513: 
        localObject = this.mApp;
        if (this.mApp.getLoudSpeakerState()) {
          break label713;
        }
        bool = true;
        ((QQAppInterface)localObject).setLoudSpeakerState(bool);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.gC();
        aF(true, this.mApp.getLoudSpeakerState());
        if (isResumed()) {
          BaseChatPie.b(this.mApp.getApp(), this.mApp.getLoudSpeakerState(), false, false);
        }
        break;
      case 2131376665: 
        if (this.cze)
        {
          dJh();
        }
        else if (this.mLoadingView.getVisibility() != 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReceiptMessageDetailFragment", 2, "user click bottom bar before fetched read count");
          }
        }
        else
        {
          dJs();
          if (this.mSessionInfo.cZ == 3000)
          {
            i = 1;
            localObject = "";
            switch (this.mMsgType)
            {
            default: 
              if (!this.Sf) {
                break;
              }
            }
          }
          for (String str = "0x80083EA";; str = "0x80083EB")
          {
            anot.a(this.mApp, "CliOper", "", "", str, str, i, 0, "", "", (String)localObject, "");
            break;
            i = 2;
            break label199;
            localObject = "pic";
            break label236;
            localObject = "msg";
            break label236;
            localObject = "ptt";
            break label236;
          }
        }
        break;
      case 2131374798: 
      case 2131374801: 
        label199:
        label236:
        this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this, this);
        if (this.e != null) {
          if (d(this.e))
          {
            this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.stop(true);
            this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
            anot.a(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
          }
          else if ((this.e != this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a()) && (this.e.isReady()))
          {
            this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
            this.jdField_b_of_type_Xkx$a.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
            if (!this.mApp.bF()) {
              break label493;
            }
            QQToast.a(this.mApp.getApp(), 1, 2131697385, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
          }
        }
        break;
      }
    }
    label493:
    Object localObject = (PttAudioWaveView)paramView.findViewById(2131374801);
    float f;
    if ((localObject != null) && (this.e != null))
    {
      f = this.e.playProgress;
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "onClick, progress = " + f);
      }
      if (f == 1.0F)
      {
        ((PttAudioWaveView)localObject).setProgress(0.0F);
        this.e.playProgress = 0.0F;
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "onClick, offset = " + i);
      }
      anot.a(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.mApp).b(this.e, i)) {
        break;
      }
      QQToast.a(getActivity(), 1, 2131697384, 0).show(getActivity().getResources().getDimensionPixelSize(2131299627));
      break;
      i = (int)(this.e.voiceLength * 1000.0F * f);
      continue;
      label713:
      bool = false;
      break label82;
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.l != null) {
      this.mApp.removeObserver(this.l);
    }
    if (this.k != null) {
      this.mApp.removeObserver(this.k);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.bZy();
      onPlayStop();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.stop(true);
    }
  }
  
  public void onPlayStart()
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().getWindow().addFlags(128);
    aF(true, this.mApp.getLoudSpeakerState());
  }
  
  public void onPlayStop()
  {
    if (getActivity() == null) {
      return;
    }
    if ((this.jdField_b_of_type_Xkx$a != null) && (this.jdField_b_of_type_Xkx$a.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) && (this.yS > 0.95D))
    {
      this.jdField_b_of_type_Xkx$a.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      this.e.playProgress = 0.0F;
      this.jdField_b_of_type_Xkx$a.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
      if (this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        this.jdField_b_of_type_Xkx$a.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
      this.yS = 0.0F;
    }
    a(this.jdField_b_of_type_Xkx$a, this.e, xkx.a(this.mApp, this.e), false);
    getActivity().setVolumeControlStream(3);
    getActivity().getWindow().clearFlags(128);
    aF(false, false);
  }
  
  public void onStop()
  {
    if ((this.e != null) && (d(this.e))) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.stop(true);
    }
    super.onStop();
  }
  
  public void zR(int paramInt)
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().setVolumeControlStream(3);
    aF(false, false);
  }
  
  public void zS(int paramInt)
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().setVolumeControlStream(paramInt);
  }
  
  public void zT(int paramInt) {}
  
  static class a
    extends Handler
  {
    private WeakReference<ReceiptMessageDetailFragment> hF;
    
    a(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
    {
      this.hF = new WeakReference(paramReceiptMessageDetailFragment);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.hF.get();
      if ((localReceiptMessageDetailFragment == null) || (!localReceiptMessageDetailFragment.isAdded())) {}
      label124:
      int i;
      label126:
      do
      {
        return;
        switch (paramMessage.what)
        {
        case 8: 
        case 9: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        default: 
          i = 0;
        }
      } while (i == 0);
      localReceiptMessageDetailFragment.stopTitleProgress();
      ReceiptMessageDetailFragment.m(localReceiptMessageDetailFragment);
      if ((ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).cZ == 0) && (!ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment)))
      {
        if (!ReceiptMessageDetailFragment.b(localReceiptMessageDetailFragment)) {
          break label399;
        }
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, 1, true);
      }
      while (ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment))
      {
        ReceiptMessageDetailFragment.h(localReceiptMessageDetailFragment);
        return;
        if (!(paramMessage.obj instanceof MessageForText)) {
          break;
        }
        ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 1);
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForText)paramMessage.obj);
        i = 1;
        break label126;
        if (!(paramMessage.obj instanceof MessageForPic)) {
          break;
        }
        ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 2);
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForPic)paramMessage.obj);
        i = 1;
        break label126;
        if (!(paramMessage.obj instanceof MessageForPtt)) {
          break;
        }
        ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 3);
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForPtt)paramMessage.obj);
        ReceiptMessageDetailFragment.h(localReceiptMessageDetailFragment);
        i = 1;
        break label126;
        ReceiptMessageDetailFragment.i(localReceiptMessageDetailFragment);
        i = 0;
        break label126;
        ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment);
        i = 0;
        break label126;
        ReceiptMessageDetailFragment.h(localReceiptMessageDetailFragment);
        i = 0;
        break label126;
        QQToast.a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).getApp(), 1, 2131700669, 0).a(localReceiptMessageDetailFragment);
        i = 0;
        break label126;
        i = xkx.a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment));
        localReceiptMessageDetailFragment.a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), i, false);
        i = 0;
        break label126;
        ReceiptMessageDetailFragment.k(localReceiptMessageDetailFragment);
        i = 0;
        break label126;
        ThreadManager.post(new ReceiptMessageDetailFragment.DetailHandler.1(this, localReceiptMessageDetailFragment), 8, null, false);
        i = 0;
        break label126;
        ReceiptMessageDetailFragment.l(localReceiptMessageDetailFragment);
        break label124;
        label399:
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, 0, true);
      }
    }
  }
  
  static class b
    extends altf<ReceiptMessageDetailFragment>
  {
    b(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
    {
      super();
    }
    
    public void c(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if ((paramInt != 0) || (paramArrayOfByte == null))
      {
        QLog.d("ReceiptMessageDetailFragment", 1, "mDiscussionFetchReadStatusCallback request error on code: " + paramInt);
        return;
      }
      try
      {
        paramBundle = new oidb_0x985.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.uint32_code.get();
        if (paramInt == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReceiptMessageDetailFragment", 2, "mDiscussionFetchReadStatusCallback succ");
          }
          paramBundle = (oidb_0x985.GetReadListRsp)paramBundle.msg_get_read_list_rsp.get();
          paramArrayOfByte = paramBundle.rpt_msg_read_list.get();
          paramBundle = paramBundle.rpt_msg_unread_list.get();
          ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.ex;
          paramInt = paramArrayOfByte.size();
          int i = paramArrayOfByte.size();
          ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, paramInt, paramBundle.size() + i, true);
          paramInt = paramArrayOfByte.size();
          ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex, paramInt, true);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.d("ReceiptMessageDetailFragment", 2, "fetch read member fail on invalid data");
        return;
      }
      QLog.d("ReceiptMessageDetailFragment", 1, "mDiscussionFetchReadStatusCallback fail on code: " + paramInt);
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex).sendEmptyMessage(20);
    }
  }
  
  static class c
    extends altf<ReceiptMessageDetailFragment>
  {
    c(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
    {
      super();
    }
    
    public void c(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if ((paramInt != 0) || (paramArrayOfByte == null))
      {
        QLog.d("ReceiptMessageDetailFragment", 1, "getDiscussionSendReadReportCallback error on code: " + paramInt);
        return;
      }
      try
      {
        paramBundle = new oidb_0x984.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.uint32_code.get() == 0) {
          break label148;
        }
        QLog.d("ReceiptMessageDetailFragment", 1, "getDiscussionSendReadReportCallback fail on code: " + paramBundle.uint32_code.get());
        if (paramBundle.uint32_code.get() == 20)
        {
          ReceiptMessageDetailFragment.n((ReceiptMessageDetailFragment)this.ex);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.d("ReceiptMessageDetailFragment", 1, "Report read status fail on invalid data");
        ReceiptMessageDetailFragment.n((ReceiptMessageDetailFragment)this.ex);
        return;
      }
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex).sendEmptyMessage(5);
      return;
      label148:
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "getDiscussionSendReadReportCallback succ");
      }
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex, 0, 0, false);
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex).sendEmptyMessage(4);
    }
  }
  
  public static class d
    implements View.OnLongClickListener
  {
    private WeakReference<ReceiptMessageDetailFragment> mOut;
    
    private d(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
    {
      this.mOut = new WeakReference(paramReceiptMessageDetailFragment);
    }
    
    public boolean onLongClick(View paramView)
    {
      paramView = (ReceiptMessageDetailFragment)this.mOut.get();
      if ((paramView == null) || (!paramView.isAdded())) {
        return false;
      }
      ausj localausj = ausj.b(paramView.getActivity());
      localausj.addButton(2131721060);
      localausj.addCancelButton(2131721058);
      localausj.a(new alsv(this, paramView, localausj));
      localausj.show();
      return true;
    }
  }
  
  static class e
    implements akxb
  {
    private WeakReference<ReceiptMessageDetailFragment> mContextRef;
    
    e(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
    {
      this.mContextRef = new WeakReference(paramReceiptMessageDetailFragment);
    }
    
    public void a(akxb.a parama)
    {
      ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.mContextRef.get();
      if (localReceiptMessageDetailFragment == null) {
        return;
      }
      switch (parama.result)
      {
      default: 
        return;
      case -1: 
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), null);
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(7);
        return;
      }
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), null);
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(6);
    }
    
    public void aS(int paramInt, boolean paramBoolean) {}
  }
  
  static class f
    implements akxb
  {
    private int dwV;
    private WeakReference<ReceiptMessageDetailFragment> mContextRef;
    
    f(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
    {
      this.mContextRef = new WeakReference(paramReceiptMessageDetailFragment);
    }
    
    public void a(akxb.a parama)
    {
      ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.mContextRef.get();
      if (localReceiptMessageDetailFragment == null) {
        return;
      }
      if ((parama.errCode == 0) && (parama.data != null))
      {
        MessageRecord localMessageRecord = ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).b().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).aTl, ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).cZ, ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment));
        Object localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = new MessageForStructing();
          ((MessageRecord)localObject).senderuin = "0";
          ((MessageRecord)localObject).uniseq = ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment);
        }
        parama = ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a().b().a(parama.data, null, (MessageRecord)localObject, null);
        if ((parama != null) && (!parama.isEmpty()))
        {
          ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(10);
          return;
        }
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(11);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "ReceiptMessageDownloadCallBack onDownload, download msg fail with code: " + parama.errCode);
      }
      int i = this.dwV + 1;
      this.dwV = i;
      if (i <= 3)
      {
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(0);
        return;
      }
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(11);
    }
    
    public void aS(int paramInt, boolean paramBoolean) {}
  }
  
  static class g
    extends altf<ReceiptMessageDetailFragment>
  {
    g(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
    {
      super();
    }
    
    public void c(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "mTroopFetchReadStatusCallback onRes: " + paramInt);
      }
      if ((paramInt == 0) && (paramArrayOfByte != null)) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReceiptMessageDetailFragment", 2, "mTroopFetchReadStatusCallback succ");
        }
        paramBundle = new oidb_0x986.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.uint32_read_uin_num.get();
        ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex, paramInt, true);
        ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex, paramInt, 2147483647, true);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.d("ReceiptMessageDetailFragment", 1, "fetch read member fail on invalid data");
        ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex).sendEmptyMessage(20);
      }
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex).sendEmptyMessage(20);
      return;
    }
  }
  
  static class h
    extends altf<ReceiptMessageDetailFragment>
  {
    h(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
    {
      super();
    }
    
    public void c(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (QLog.isDebugVersion()) {
        QLog.d("ReceiptMessageDetailFragment", 4, "mTroopSendReadReportCallback onRes: " + paramInt);
      }
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReceiptMessageDetailFragment", 2, "mTroopSendReadReportCallback succ");
        }
        ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex, 0, 0, false);
        ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex).sendEmptyMessage(4);
        return;
      }
      if (paramInt != 1281)
      {
        QLog.d("ReceiptMessageDetailFragment", 1, "mTroopSendReadReportCallback fatal error: " + paramInt);
        ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.ex).sendEmptyMessage(5);
        return;
      }
      ReceiptMessageDetailFragment.n((ReceiptMessageDetailFragment)this.ex);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment
 * JD-Core Version:    0.7.0.1
 */