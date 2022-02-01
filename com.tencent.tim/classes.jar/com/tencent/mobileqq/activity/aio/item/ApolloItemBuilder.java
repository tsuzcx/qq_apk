package com.tencent.mobileqq.activity.aio.item;

import abhh;
import abhh.e;
import abqz;
import abrg;
import abrh;
import abxi;
import abxk;
import acfp;
import aczo;
import adxp;
import ahwa;
import ahwb;
import anaz;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoiz;
import aqgz;
import aqiw;
import aqoa;
import aqob;
import aqrb;
import aquz;
import aqva;
import arhz;
import ausj;
import auss;
import avfp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jof;
import sxx;
import ujt;
import wja;
import wlz;
import wyn;
import wyo;
import wyp;
import wyq;
import wyr;
import wys;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float qf = 6.0F * (aqgz.getDispalyDpi() / 160) / 2.0F;
  private long IK;
  private long IL;
  private abhh.e jdField_a_of_type_Abhh$e;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqDataMessageForApollo;
  private boolean bgu;
  private boolean bgv;
  private boolean bgw = true;
  private View.OnClickListener dK = new wyo(this);
  private View.OnClickListener dL = new wyp(this);
  private View.OnClickListener dM = new wyr(this);
  private View.OnClickListener dN = new wys(this);
  private int mApolloStatus = 0;
  public boolean mClickable = true;
  protected View.OnClickListener onClickListener = new wyq(this);
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    paramQQAppInterface = (abhh)paramQQAppInterface.getManager(153);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Abhh$e = paramQQAppInterface.a();
    }
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838506), 200);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838507), 100);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838508), 200);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838507), 100);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838506), 300);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838509), 100);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838510), 200);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838509), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838490), 200);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838491), 100);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838492), 200);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838491), 100);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838490), 300);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838493), 100);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838494), 200);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838493), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, b paramb, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    boolean bool2 = false;
    if ((paramb == null) || (this.app == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    label630:
    do
    {
      do
      {
        return paramView;
      } while (!(paramb instanceof b));
      if ((paramMessageForApollo != null) && (this.bgu))
      {
        a(paramb, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null)
        {
          paramwlz = ApolloUtil.c(this.app, paramMessageForApollo);
          if (!TextUtils.isEmpty(paramwlz)) {
            paramb.e.append(paramwlz);
          }
          if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
          {
            paramb.e.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
            if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
              paramb.e.append(" ").append(paramMessageForApollo.inputText);
            }
            paramb.mActionId = paramMessageForApollo.mApolloMessage.id;
          }
        }
        else
        {
          paramView.setContentDescription(acfp.m(2131702545) + paramb.e.toString());
          paramb.e.insert(0, "[a]");
          paramb.e.setSpan(paramb.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
          paramb.IJ.setText(paramb.e);
          paramb.o.setOnClickListener(this.onClickListener);
          if (paramb.ar != null) {
            paramb.ar.setVisibility(8);
          }
          if (paramb.IL != null) {
            paramb.IL.setVisibility(8);
          }
          paramb.IJ.setVisibility(0);
          paramb.iconView.setVisibility(0);
          RelativeLayout.LayoutParams localLayoutParams;
          if (paramb.sM == null)
          {
            paramwlz = new ImageView(this.mContext);
            paramwlz.setId(2131367331);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(1, 2131364503);
            localLayoutParams.addRule(15, 2131363321);
            localLayoutParams.leftMargin = 10;
            paramwlz.setContentDescription(acfp.m(2131702547));
            paramBaseChatItemLayout.addView(paramwlz, localLayoutParams);
            paramwlz.setImageResource(2130847981);
            paramb.sM = paramwlz;
            paramb.sM.setOnClickListener(this.dM);
          }
          if (paramb.sL == null)
          {
            paramwlz = new ImageView(this.mContext);
            paramwlz.setId(2131367330);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(0, 2131364503);
            localLayoutParams.addRule(15, 2131363321);
            paramwlz.setContentDescription(acfp.m(2131702551));
            paramBaseChatItemLayout.addView(paramwlz, localLayoutParams);
            paramwlz.setImageResource(2130847981);
            paramb.sL = paramwlz;
            paramb.sL.setOnClickListener(this.dM);
          }
          paramwlz = (TextView)paramBaseChatItemLayout.findViewById(2131364534);
          if ((!paramMessageForApollo.mNeedTimeStamp) || (paramMessageForApollo.time <= 0L) || (paramwlz == null) || (paramMessageForApollo.time == ((Long)paramwlz.getTag()).longValue())) {
            break label875;
          }
          paramb.sL.setPadding(0, wja.dp2px(70.0F, this.mContext.getResources()), 0, 0);
          paramb.sM.setPadding(0, wja.dp2px(80.0F, this.mContext.getResources()), 0, 0);
          paramb.sM.setVisibility(8);
          paramb.sL.setVisibility(8);
          paramwlz = ((abxk)this.app.getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
          a(paramMessageForApollo, paramBaseChatItemLayout, paramb, paramwlz);
          if (((paramb.pos == paramb.count - 1) && (paramwlz != null) && (paramwlz.actionType != 5) && (!paramMessageForApollo.hasPlayed) && (this.jdField_a_of_type_Abhh$e != null) && (this.jdField_a_of_type_Abhh$e.c(paramMessageForApollo))) && ((paramMessageForApollo.isSend()) || (!abhh.sI.contains(Long.valueOf(paramMessageForApollo.uniseq))))) {
            break label924;
          }
          abhh.sI.remove(Long.valueOf(paramMessageForApollo.uniseq));
          a(paramb, 1);
        }
        while (paramb.pos != paramb.count - 1)
        {
          boolean bool1 = bool2;
          if (this.app != null)
          {
            paramBaseChatItemLayout = (abrg)this.app.getManager(249);
            bool1 = bool2;
            if (paramBaseChatItemLayout.a() != null) {
              bool1 = paramBaseChatItemLayout.a().bD(paramMessageForApollo.uniseq);
            }
          }
          a(paramMessageForApollo, paramb, bool1);
          c(paramMessageForApollo);
          return paramView;
          if (TextUtils.isEmpty(paramMessageForApollo.inputText)) {
            break;
          }
          paramb.e.append("：").append(paramMessageForApollo.inputText);
          break;
          paramb.sL.setPadding(0, wja.dp2px(30.0F, this.mContext.getResources()), 0, 0);
          paramb.sM.setPadding(0, wja.dp2px(30.0F, this.mContext.getResources()), 0, 0);
          break label630;
        }
        if (this.bgw) {
          cdt();
        }
        if (paramMessageForApollo.isSend()) {}
        for (int i = 0;; i = 1)
        {
          a(paramb, i);
          break;
        }
      }
      if (paramMessageForApollo != null)
      {
        a(paramb, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null) {
          paramb.mActionId = paramMessageForApollo.mApolloMessage.id;
        }
        paramb.o.setTag(Integer.valueOf(paramb.mActionId));
      }
      paramb.ar.setVisibility(0);
      paramb.ar.setOnTouchListener(paramwlz);
      paramb.ar.setOnClickListener(this.dK);
      paramb.ar.setOnLongClickListener(paramwlz);
      a(paramb, paramView.getResources(), false);
      if (paramb.IJ != null) {
        paramb.IJ.setVisibility(8);
      }
      if (paramb.IK != null) {
        paramb.IK.setVisibility(8);
      }
    } while (paramb.iconView == null);
    label875:
    paramb.iconView.setVisibility(8);
    label924:
    return paramView;
  }
  
  public static void a(Context paramContext, View paramView, MessageForApollo paramMessageForApollo, SessionInfo paramSessionInfo)
  {
    if (paramMessageForApollo.mApolloMessage == null) {
      return;
    }
    Object localObject = sxx.getViewRect(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.beB))
    {
      int i = ((FragmentActivity)paramContext).getChatFragment().a().vm();
      paramView.putInt("extra.AIO_CURRENT_PANEL_STATE", i);
      if (i == 1)
      {
        localObject = (InputMethodManager)paramContext.getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).toggleSoftInput(1, 0);
        }
      }
    }
    paramView.putBoolean("IS_APP_SHARE_PIC", true);
    paramView.putBoolean("extra.IS_FROM_MULTI_MSG", true);
    paramView.putBoolean("extra.IS_APOLLO", true);
    if (paramSessionInfo != null)
    {
      paramView.putString("extra.GROUP_UIN", paramSessionInfo.aTl);
      paramView.putString("uin", paramSessionInfo.aTl);
      paramView.putInt("forward_source_uin_type", paramSessionInfo.cZ);
    }
    localObject = new ApolloActionData();
    ((ApolloActionData)localObject).actionId = paramMessageForApollo.mApolloMessage.id;
    paramSessionInfo = new AIOImageData();
    paramSessionInfo.id = paramMessageForApollo.uniseq;
    paramSessionInfo.aVW = ApolloUtil.a((ApolloActionData)localObject, 0);
    localObject = a.cD(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.aVY = ((String)localObject);
    paramSessionInfo.aVX = ((String)localObject);
    avfp.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  private void a(b paramb)
  {
    aqrb localaqrb = (aqrb)this.app.getBusinessHandler(71);
    if (paramb.mMessage.sendFailCode == abxi.ctu) {
      localaqrb.ag(this.app.getCurrentUin(), 1, "userClick");
    }
    do
    {
      return;
      if (paramb.mMessage.sendFailCode == abxi.ctx)
      {
        localaqrb.ag(this.app.getCurrentUin(), 128, "userClick");
        return;
      }
      if (paramb.mMessage.sendFailCode == abxi.ctv)
      {
        localaqrb.ag(this.app.getCurrentUin(), 2, "userClick");
        return;
      }
    } while (paramb.mMessage.sendFailCode != abxi.ctw);
    aczo.r(this.app, 1);
  }
  
  private void a(b paramb, ausj paramausj, ApolloActionData paramApolloActionData)
  {
    paramausj.addCancelButton(2131721058);
    paramausj.a(new wyn(this, paramb, paramApolloActionData, paramausj));
    paramausj.show();
  }
  
  private void a(b paramb, boolean paramBoolean)
  {
    if (!(paramb instanceof b)) {}
    do
    {
      do
      {
        return;
        b(paramb, false);
        if (!this.bgu) {
          break;
        }
        if (paramb.iconView == null)
        {
          localObject = new ImageView(this.mContext);
          ((ImageView)localObject).setId(2131374742);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131374743);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramb.o.addView((View)localObject);
          paramb.iconView = ((ImageView)localObject);
        }
        if (paramb.IJ == null)
        {
          localObject = new AnimationTextView(this.mContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.bNT);
          ((AnimationTextView)localObject).setMinWidth(wja.dp2px(73.0F, this.mContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramb.o.addView((View)localObject);
          paramb.IJ = ((TextView)localObject);
        }
        paramb.IJ.setClickable(false);
        paramb.iconView.setClickable(false);
        paramb.tag = 0;
        if (paramb.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, wja.dp2px(31.0F, this.mContext.getResources()), wja.dp2px(23.0F, this.mContext.getResources()));
          paramb.jdField_a_of_type_AndroidTextStyleImageSpan = new c((Drawable)localObject);
        }
        if (paramb.e == null) {
          paramb.e = new SpannableStringBuilder();
        }
        paramb.IJ.setTextSize(0, this.sessionInfo.cN);
        int k = BaseChatItemLayout.bOc;
        int j = BaseChatItemLayout.bOd;
        int i = BaseChatItemLayout.bOc;
        if (paramBoolean)
        {
          k = BaseChatItemLayout.bOd;
          j = BaseChatItemLayout.bOc;
          i = BaseChatItemLayout.bOd;
        }
        paramb.IJ.setPadding(i, BaseChatItemLayout.bOa, j, BaseChatItemLayout.bOb);
        localObject = (ViewGroup.MarginLayoutParams)paramb.iconView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(k, BaseChatItemLayout.bOa, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = wja.dp2px(32.0F, this.mContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = wja.dp2px(24.0F, this.mContext.getResources());
        paramb.e.clear();
      } while (paramb.mLoadingView == null);
      paramb.mLoadingView.setVisibility(8);
      return;
      paramb.o.setOnClickListener(this.dL);
      if (paramb.ar == null)
      {
        localObject = new URLImageView(this.mContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(104.0F, this.mContext.getResources()), wja.dp2px(104.0F, this.mContext.getResources()));
        localLayoutParams.addRule(13);
        paramb.o.addView((View)localObject, localLayoutParams);
        paramb.ar = ((URLImageView)localObject);
      }
    } while (paramb.mLoadingView != null);
    Object localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setImageResource(2130839651);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramb.o.addView((View)localObject, localLayoutParams);
    paramb.mLoadingView = ((ImageView)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.2(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, b paramb)
  {
    ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramb), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, b paramb, ApolloActionData paramApolloActionData)
  {
    int i;
    if ((paramb.pos == paramb.count - 1) && (paramApolloActionData != null) && (paramApolloActionData.actionType != 5) && (b(paramMessageForApollo)))
    {
      if (((paramMessageForApollo.extraflag != 32768) || (!paramMessageForApollo.isSendFromLocal())) && (!this.app.a().aS(paramMessageForApollo))) {
        break label138;
      }
      i = 1;
      if (i == 0)
      {
        if ((!this.bgv) || (this.IL != paramMessageForApollo.uniseq)) {
          break label162;
        }
        if ((!this.sessionInfo.beB) && (!(this.mContext instanceof MultiForwardActivity)))
        {
          if (!paramMessageForApollo.isSend()) {
            break label144;
          }
          paramb.sL.setVisibility(0);
          paramb.sM.setVisibility(8);
        }
      }
    }
    label138:
    label144:
    label162:
    while ((this.bgv) && (this.IL == paramMessageForApollo.uniseq))
    {
      return;
      i = 0;
      break;
      paramb.sL.setVisibility(8);
      paramb.sM.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
    a(paramMessageForApollo, paramBaseChatItemLayout, paramb);
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new ApolloItemBuilder.3(paramContext, paramInt, paramString));
  }
  
  private boolean a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.istroop != 0) && (paramMessageForApollo.istroop != 1) && (paramMessageForApollo.istroop != 3000)) {
      return false;
    }
    if (!abhh.aV(this.mContext)) {
      return false;
    }
    if ((this.sessionInfo != null) && (this.sessionInfo.cZ == 3000) && (abhh.ce("discuss") == 0)) {
      return false;
    }
    paramMessageForApollo = ((abhh)this.app.getManager(153)).a(this.app.getCurrentUin());
    if (paramMessageForApollo != null)
    {
      this.mApolloStatus = paramMessageForApollo.apolloStatus;
      return abhh.a(paramMessageForApollo);
    }
    return false;
  }
  
  private AnimationDrawable b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838500), 700);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838504), 200);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838501), 200);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838502), 200);
      localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838503), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838495), 700);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838499), 200);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838496), 200);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838497), 200);
    localAnimationDrawable.addFrame(this.mContext.getResources().getDrawable(2130838498), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  static void b(b paramb, boolean paramBoolean)
  {
    int j = 0;
    if ((paramb.IM != null) && (!paramBoolean)) {
      paramb.IM.setVisibility(8);
    }
    Object localObject;
    if (paramb.iconView != null)
    {
      localObject = paramb.iconView;
      if (paramBoolean)
      {
        i = 8;
        ((ImageView)localObject).setVisibility(i);
      }
    }
    else
    {
      if (paramb.IJ != null)
      {
        localObject = paramb.IJ;
        if (!paramBoolean) {
          break label150;
        }
        i = 8;
        label68:
        ((TextView)localObject).setVisibility(i);
      }
      if (paramb.ar != null)
      {
        localObject = paramb.ar;
        if (!paramBoolean) {
          break label155;
        }
      }
    }
    label150:
    label155:
    for (int i = 8;; i = 0)
    {
      ((URLImageView)localObject).setVisibility(i);
      if (paramb.mLoadingView != null)
      {
        localObject = paramb.mLoadingView;
        i = j;
        if (paramBoolean) {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
      }
      if (paramb.IL != null) {
        paramb.IL.setVisibility(8);
      }
      return;
      i = 0;
      break;
      i = 0;
      break label68;
    }
  }
  
  private arhz c()
  {
    if (((FragmentActivity)this.mContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.mContext).getChatFragment().a().y == null) {
        ((FragmentActivity)this.mContext).getChatFragment().a().y = new arhz(this.mContext);
      }
      return ((FragmentActivity)this.mContext).getChatFragment().a().y;
    }
    return null;
  }
  
  private void c(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    abhh localabhh = (abhh)this.app.getManager(153);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localabhh.a(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localabhh.da(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.app.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localabhh.a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label267;
        }
        localabhh.da(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
      }
    }
    label227:
    while ((localApolloBaseInfo == null) || (!localApolloBaseInfo.isApolloStatusOpen()) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS))
    {
      return;
      l1 = 0L;
      break;
      if ((localApolloBaseInfo == null) || (!localApolloBaseInfo.isApolloStatusOpen()) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS)) {
        break label73;
      }
      localabhh.da(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label267:
    localabhh.da(localApolloBaseInfo.uin, 1);
  }
  
  private void d(MessageForApollo paramMessageForApollo)
  {
    Object localObject = (abhh)this.app.getManager(153);
    aqrb localaqrb = (aqrb)this.app.getBusinessHandler(71);
    if (localaqrb != null)
    {
      ArrayList localArrayList = new ArrayList(2);
      int i;
      if (!paramMessageForApollo.isSend())
      {
        ApolloBaseInfo localApolloBaseInfo = ((abhh)localObject).a(paramMessageForApollo.senderuin);
        if ((localApolloBaseInfo == null) || (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime > 300L)) {
          localArrayList.add(paramMessageForApollo.senderuin);
        }
        if ((QLog.isColorLevel()) && (localApolloBaseInfo != null) && (!localApolloBaseInfo.isApolloStatusOpen()))
        {
          i = localApolloBaseInfo.apolloStatus;
          QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + paramMessageForApollo.senderuin + ", status: " + i);
        }
      }
      if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.peer_uin > 0L) && (paramMessageForApollo.mApolloMessage.peer_uin != this.app.getLongAccountUin()))
      {
        localObject = ((abhh)localObject).a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        if ((localObject == null) || (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject).apolloUpdateTime > 300L)) {
          localArrayList.add(paramMessageForApollo.mApolloMessage.peer_uin + "");
        }
        if ((QLog.isColorLevel()) && (localObject != null) && (!((ApolloBaseInfo)localObject).isApolloStatusOpen()))
        {
          i = ((ApolloBaseInfo)localObject).apolloStatus;
          QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + paramMessageForApollo.mApolloMessage.peer_uin + ", status: " + i);
        }
      }
      if (!localArrayList.isEmpty()) {
        localaqrb.Z((String[])localArrayList.toArray(new String[0]));
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if (this.bgu) {
      return 1;
    }
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramwlz = (b)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.bgu)
    {
      if (paramwlz.IL != null) {
        paramwlz.IL.setVisibility(8);
      }
      localObject2 = ((abxk)this.app.getManager(155)).b(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.mContext.getResources();
        if (paramwlz.IK == null)
        {
          paramChatMessage = new TextView(this.mContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.bNT);
          paramChatMessage.setMinWidth(wja.dp2px(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(wja.dp2px(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130843454);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(wja.dp2px(6.0F, (Resources)localObject1), 0, wja.dp2px(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131364503);
          paramView.addRule(3, 2131364503);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = wja.dp2px(-3.0F, (Resources)localObject1);
          paramView.leftMargin = wja.dp2px(12.0F, (Resources)localObject1);
          paramwlz.IK = paramChatMessage;
          paramwlz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramwlz.IK.setOnClickListener(this.dN);
        }
        paramwlz.IK.setVisibility(0);
        paramView = acfp.m(2131702549);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramwlz.IK.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838626);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramwlz.IK.setCompoundDrawables(paramChatMessage, null, null, null);
        paramwlz.IK.setCompoundDrawablePadding(wja.dp2px(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramwlz.IK != null) {
          paramwlz.IK.setVisibility(8);
        }
      }
    }
    if (paramwlz.IK != null) {
      paramwlz.IK.setVisibility(8);
    }
    paramChatMessage = this.mContext.getResources();
    if (paramwlz.IL == null)
    {
      paramView = paramwlz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.mContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(wja.dp2px(5.0F, paramChatMessage), 0, wja.dp2px(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130843454);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364503);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364503);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(12.0F, paramChatMessage);
      paramwlz.IL = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramwlz.IL.setOnClickListener(this.dL);
    }
    paramwlz.IL.setVisibility(8);
    paramwlz.IL.setText(acfp.m(2131702552));
    paramView = paramChatMessage.getDrawable(2130838624);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramwlz.IL.setCompoundDrawables(paramView, null, null, null);
    paramwlz.IL.setPadding(wja.dp2px(5.0F, paramChatMessage), 0, wja.dp2px(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(parame instanceof b)) {
      return paramView;
    }
    parame = (b)parame;
    if ((paramView == null) || ((parame != null) && (parame.o == null)))
    {
      paramChatMessage = new RelativeLayout(this.mContext);
      paramChatMessage.setId(2131374743);
      parame.o = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramwlz);
      paramChatMessage.setOnLongClickListener(paramwlz);
      this.bgu = a(localMessageForApollo);
      return a(localMessageForApollo, parame, paramChatMessage, paramBaseChatItemLayout, paramwlz);
      paramChatMessage = paramView;
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new b();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForApollo))) {}
    MessageForApollo localMessageForApollo;
    do
    {
      do
      {
        do
        {
          return;
          localMessageForApollo = (MessageForApollo)paramChatMessage;
          switch (paramInt)
          {
          default: 
            super.a(paramInt, paramContext, paramChatMessage);
            return;
          case 2131365686: 
            ujt.b(this.mContext, this.app, paramChatMessage);
          }
        } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
        VipUtils.a(this.app, "cmshow", "Apollo", "long_press_del", ApolloUtil.gi(this.sessionInfo.cZ), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
        return;
      } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
      a(localMessageForApollo.mApolloMessage.id, localMessageForApollo);
      return;
      super.j(paramChatMessage);
    } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
    VipUtils.a(this.app, "cmshow", "Apollo", "long_press_withdraw", ApolloUtil.gi(this.sessionInfo.cZ), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = ((abxk)this.app.getManager(155)).a(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / aqgz.density);
      localObject1 = ApolloUtil.a(((TextView)localObject1).getPaint(), 208.0F, (String)localObject2, 3);
      localObject1 = Pattern.compile("\n").matcher((CharSequence)localObject1).replaceAll("");
    }
    if ((localObject3 != null) && (((ApolloActionData)localObject3).feeType == 1))
    {
      localObject2 = new ApolloFavActionData();
      if (paramMessageForApollo.isBarrageMode()) {}
      for (paramInt = 1;; paramInt = 0)
      {
        ((ApolloFavActionData)localObject2).textType = paramInt;
        ((ApolloFavActionData)localObject2).text = ((String)localObject1);
        ((ApolloFavActionData)localObject2).acitonId = paramMessageForApollo.mApolloMessage.id;
        ((ApolloFavActionData)localObject2).audioId = paramMessageForApollo.audioId;
        ((ApolloFavActionData)localObject2).audioStartTime = paramMessageForApollo.audioStartTime;
        ((ApolloFavActionData)localObject2).playOriginalAudio = paramMessageForApollo.isPlayDefaultAudio;
        a(this.app, this.mContext, (ApolloFavActionData)localObject2, this.sessionInfo);
        return;
      }
    }
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      a(this.mContext.getString(2131690322), 1, this.mContext);
      return;
    }
    localObject3 = (aqrb)this.app.getBusinessHandler(71);
    if (paramMessageForApollo.isBarrageMode()) {}
    for (localObject2 = "1";; localObject2 = "0")
    {
      ((aqrb)localObject3).a(paramInt, (String)localObject1, (String)localObject2, paramMessageForApollo.audioId, paramMessageForApollo.audioStartTime, paramMessageForApollo.isPlayDefaultAudio, "actionAdd");
      paramMessageForApollo = c();
      if (paramMessageForApollo == null) {
        break;
      }
      paramMessageForApollo.setMessage(2131690391);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.app, this.sessionInfo.aTl, this.sessionInfo.cZ);
    }
    b localb;
    if ((paramView != null) && ((wja.a(paramView) instanceof b)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        abhh.aM.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localb = (b)wja.a(paramView);
      if (!super.a(paramMessageForApollo, localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      if ((paramView instanceof BaseChatItemLayout)) {
        if (paramMessageForApollo.actionType != 5) {
          break label152;
        }
      }
    }
    label152:
    for (paramView = b(paramMessageForApollo.isSend());; paramView = a(paramMessageForApollo.isSend()))
    {
      if ((paramView != null) && (localb.iconView != null))
      {
        localb.iconView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    if (!(parame instanceof b)) {}
    b localb;
    do
    {
      return;
      localb = (b)parame;
    } while ((paramadxp == null) || (localb.IJ == null));
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        parame = paramView.getColorStateList(2131167326);
        if (parame != null) {
          localb.IJ.setTextColor(parame);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (parame = paramView.getColorStateList(2131167325);; parame = paramView.getColorStateList(2131167324))
      {
        localb.IJ.setLinkTextColor(parame);
        return;
        parame = paramView.getColorStateList(2131167322);
        break;
      }
    }
    if (paramadxp.mTextColor == 0) {
      localb.IJ.setTextColor(-16777216);
    }
    while (paramadxp.mLinkColor == 0)
    {
      localb.IJ.setLinkTextColor(paramView.getResources().getColorStateList(2131167324));
      return;
      localb.IJ.setTextColor(paramadxp.mTextColor);
    }
    localb.IJ.setLinkTextColor(paramadxp.mLinkColor);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = wja.a(paramBaseChatItemLayout2);
    if (!(localObject instanceof b)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = wja.a(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof b));
      localObject = (b)localObject;
      paramBaseChatItemLayout2 = (b)paramBaseChatItemLayout2;
    } while (((b)localObject).mActionId != paramBaseChatItemLayout2.mActionId);
    q(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  public void a(b paramb, int paramInt)
  {
    paramb = (MessageForApollo)paramb.mMessage;
    if (((!paramb.hasPlayed) || (paramInt == 2)) && (this.app != null))
    {
      abqz localabqz = ((abrg)this.app.getManager(249)).a();
      if (localabqz != null) {
        localabqz.b(paramInt, paramb);
      }
    }
  }
  
  public void a(b paramb, Resources paramResources, boolean paramBoolean)
  {
    if ((paramb == null) || (paramResources == null)) {
      return;
    }
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      try
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mGifRoundCorner = qf;
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838625);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838627);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramb.mActionId));
        File localFile = new File(a.cD(paramb.mActionId));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramb.ar.setImageDrawable(paramResources);
        paramb.mLoadingView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramb.mActionId + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramb) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramb.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramb.mActionId));
      paramb.ar.setImageDrawable(paramResources);
      paramb.ar.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramb.mLoadingView.setVisibility(0);
      } else {
        paramb.mLoadingView.setVisibility(8);
      }
    }
  }
  
  protected void a(MessageForApollo paramMessageForApollo, b paramb, boolean paramBoolean)
  {
    paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (abhh.aM.contains(Integer.valueOf(paramb.mActionId)))
    {
      localObject = (abhh)this.app.getManager(153);
      if ((localObject != null) && (((abhh)localObject).cd(this.app.getCurrentUin()) != 2)) {
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramb.iconView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        abhh.aM.remove(Integer.valueOf(paramb.mActionId));
        if (!paramMessageForApollo.hasPlayed) {
          ApolloUtil.a(paramMessageForApollo, this.app, this.sessionInfo.aTl, this.sessionInfo.cZ);
        }
        return;
      }
    }
    int i;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        i = 2130838500;
      }
    }
    for (;;)
    {
      paramb.iconView.setImageResource(i);
      return;
      i = 2130838495;
      continue;
      if (paramMessageForApollo.isSend()) {
        i = 2130838506;
      } else {
        i = 2130838490;
      }
    }
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    if (ApolloUtil.V(paramView))
    {
      super.e(localaqoa, this.mContext);
      return localaqoa.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((this.bgu) && (!ApolloGameUtil.ib(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction())) {
        localaqoa.Z(2131366733, this.mContext.getString(2131690318), 2130838567);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.app.a().aR(paramView))) {
        a(localaqoa, this.sessionInfo.cZ, paramView);
      }
      a(localaqoa, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.app, "cmshow", "Apollo", "long_press_msg", ApolloUtil.gi(this.sessionInfo.cZ), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131702548) + paramChatMessage.msg;
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int i;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131374742);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        i = 2130838500;
      }
    }
    for (;;)
    {
      paramView.setImageResource(i);
      return;
      label51:
      i = 2130838495;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        i = 2130838506;
      } else {
        i = 2130838490;
      }
    }
  }
  
  public boolean b(MessageForApollo paramMessageForApollo)
  {
    if (jof.a().dd(paramMessageForApollo.frienduin)) {}
    int i;
    do
    {
      return false;
      i = abhh.h(this.app, this.app.getCurrentUin());
    } while (((paramMessageForApollo.is3dAction()) && (i != 2)) || ((!paramMessageForApollo.is3dAction()) && (i != 1)));
    return true;
  }
  
  public void cdt()
  {
    if ((this.app == null) || (this.mContext == null)) {}
    label14:
    String str1;
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        do
        {
          break label14;
          do
          {
            return;
          } while ((this.sessionInfo == null) || (this.sessionInfo.cZ != 0));
          this.bgw = false;
          localObject1 = this.sessionInfo.aTl;
          localObject2 = this.app.getCurrentUin();
          str1 = "apollo_invite_gray_tip" + (String)localObject2 + "_" + (String)localObject1;
          localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        } while (!localSharedPreferences.getBoolean(str1, true));
        localObject3 = (abhh)this.app.getManager(153);
      } while (localObject3 == null);
      localObject3 = ((abhh)localObject3).a(this.sessionInfo.aTl);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = anaz.gQ();
    String str2 = acfp.m(2131702546);
    int i = str2.indexOf(acfp.m(2131702544));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#1e6fff");
    ((Bundle)localObject3).putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new ahwa((String)localObject1, (String)localObject2, str2, this.sessionInfo.cZ, -5040, 2359297, l);
    ((ahwa)localObject1).addHightlightItem(i, i + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.app, (ahwa)localObject1);
    ahwb.a(this.app, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(this.app, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
  }
  
  public void destroy()
  {
    super.destroy();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "this:" + this + ", destroy(),apollo check game dialog dismiss");
    }
  }
  
  public void ei(View paramView)
  {
    paramView = (b)wja.a(paramView);
    if (paramView.mMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.mMessage.sendFailCode + ", extraflag: " + paramView.mMessage.extraflag);
      }
      a(paramView);
      ApolloBaseInfo localApolloBaseInfo = ((abhh)this.app.getManager(153)).a(this.app.getCurrentAccountUin());
      ausj localausj = (ausj)auss.a(this.mContext, null);
      abxk localabxk = (abxk)this.app.getManager(155);
      ApolloActionData localApolloActionData = localabxk.a(paramView.mActionId);
      if ((paramView.mMessage.sendFailCode == abxi.ctu) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloVipFlag != 1))
      {
        localausj.setMainTitle(this.mContext.getResources().getString(2131690337));
        localausj.addButton(this.mContext.getResources().getString(2131690336), 1);
        paramView.tag = 1;
        ApolloUtil.d((Activity)this.mContext, this.app.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.mMessage.sendFailCode == abxi.ctv) && (localApolloActionData != null) && (localApolloBaseInfo != null) && (localApolloActionData.vipLevel < localApolloBaseInfo.apolloVipLevel))
      {
        localausj.setMainTitle(this.mContext.getResources().getString(2131690337));
        localausj.addButton(this.mContext.getResources().getString(2131690336), 1);
        paramView.tag = 2;
        ApolloUtil.d((Activity)this.mContext, this.app.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.mMessage.sendFailCode == abxi.ctx) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localabxk.hY(localApolloActionData.actionId))))
      {
        localausj.setMainTitle(this.mContext.getResources().getString(2131690334));
        localausj.addButton(this.mContext.getResources().getString(2131690333), 1);
        paramView.tag = 3;
      }
      for (;;)
      {
        a(paramView, localausj, localApolloActionData);
        return;
        if (paramView.mMessage.sendFailCode == abxi.ctw)
        {
          localausj.setMainTitle(this.mContext.getResources().getString(2131690335));
          paramView.tag = 4;
        }
        else
        {
          if ((paramView.mMessage.sendFailCode == 0) && (!super.a(paramView.mMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
            break;
          }
          localausj.addButton(this.mContext.getResources().getString(2131690343), 1);
        }
      }
    }
    a(paramView, 2);
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (b)wja.a(paramView);
    if (paramView.mLoadingView != null) {
      paramView.mLoadingView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (b)wja.a(paramView);
    if (paramView.mLoadingView != null) {
      paramView.mLoadingView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (b)wja.a(paramView);
    if (paramView.mLoadingView != null) {
      paramView.mLoadingView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = wja.a(paramView);
    if (!(paramView instanceof b)) {}
    do
    {
      return;
      paramView = (b)paramView;
      if (paramView.mLoadingView != null) {
        paramView.mLoadingView.setVisibility(8);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloItemBuilder", 2, "onLoadSuccessed");
  }
  
  public void q(View paramView, int paramInt1, int paramInt2)
  {
    paramView = wja.a(paramView);
    if (!(paramView instanceof b)) {}
    abhh localabhh;
    do
    {
      do
      {
        return;
        paramView = (b)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.mMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        abhh.aM.remove(Integer.valueOf(paramView.mActionId));
        return;
      }
      if (!abhh.aM.contains(Integer.valueOf(paramView.mActionId))) {
        abhh.aM.add(Integer.valueOf(paramView.mActionId));
      }
      localabhh = (abhh)this.app.getManager(153);
    } while ((localabhh != null) && (localabhh.cd(this.app.getCurrentUin()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  static class AvatarImageView
    extends View
  {
    private float aU;
    private float hG;
    private Bitmap[] mBitmaps;
    private Paint mPaint;
    private float qg;
    
    public AvatarImageView(Context paramContext)
    {
      super();
      this.qg = wja.dp2px(6.5F, paramContext.getResources());
      this.aU = wja.dp2px(3.0F, paramContext.getResources());
      this.hG = wja.dp2px(15.0F, paramContext.getResources());
      this.mPaint = new Paint(1);
      this.mPaint.setColor(-6620);
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      int i = getWidth();
      int j = getHeight();
      if ((i == 0) || (j == 0) || (this.mBitmaps == null) || (this.mBitmaps.length <= 0)) {}
      for (;;)
      {
        return;
        i = 0;
        while (i < this.mBitmaps.length)
        {
          if ((this.mBitmaps[i] != null) && (!this.mBitmaps[i].isRecycled()))
          {
            paramCanvas.save();
            paramCanvas.translate(this.qg, 0.0F);
            paramCanvas.translate((this.qg + this.qg + this.hG + this.hG) * i, 0.0F);
            paramCanvas.drawCircle(this.hG, this.hG, this.hG, this.mPaint);
            paramCanvas.translate(this.aU, this.aU);
            paramCanvas.drawBitmap(this.mBitmaps[i], new Rect(0, 0, this.mBitmaps[i].getWidth(), this.mBitmaps[i].getHeight()), new RectF(0.0F, 0.0F, (this.hG - this.aU) * 2.0F, (this.hG - this.aU) * 2.0F), null);
            paramCanvas.restore();
          }
          i += 1;
        }
      }
    }
  }
  
  static class PlusOneManagerTask
    implements Runnable
  {
    int actionType;
    boolean bgx;
    WeakReference<ApolloItemBuilder> dV;
    WeakReference<MessageForApollo> dW;
    WeakReference<ApolloItemBuilder.b> holderRef;
    
    public PlusOneManagerTask(ApolloItemBuilder paramApolloItemBuilder, ApolloItemBuilder.b paramb, MessageForApollo paramMessageForApollo, int paramInt)
    {
      this.dV = new WeakReference(paramApolloItemBuilder);
      this.holderRef = new WeakReference(paramb);
      this.dW = new WeakReference(paramMessageForApollo);
      this.actionType = paramInt;
    }
    
    public void run()
    {
      ApolloItemBuilder localApolloItemBuilder = (ApolloItemBuilder)this.dV.get();
      ApolloItemBuilder.b localb = (ApolloItemBuilder.b)this.holderRef.get();
      MessageForApollo localMessageForApollo = (MessageForApollo)this.dW.get();
      if ((localApolloItemBuilder == null) || (localb == null) || (localMessageForApollo == null)) {
        break label45;
      }
      label45:
      while (!(localb instanceof ApolloItemBuilder.b)) {
        return;
      }
      if (this.actionType == 0) {
        if ((!(localb.sL.getContext() instanceof MultiForwardActivity)) && (!this.bgx) && (!localApolloItemBuilder.sessionInfo.beB))
        {
          if (!localMessageForApollo.isSend()) {
            break label165;
          }
          localb.sL.setVisibility(0);
          localb.sM.setVisibility(8);
        }
      }
      for (;;)
      {
        ApolloItemBuilder.a(localApolloItemBuilder, true);
        if ((this.actionType != 1) || (ApolloItemBuilder.a(localApolloItemBuilder) != localMessageForApollo.uniseq)) {
          break;
        }
        localb.sL.setVisibility(8);
        localb.sM.setVisibility(8);
        ApolloItemBuilder.a(localApolloItemBuilder, 0L);
        return;
        label165:
        localb.sL.setVisibility(8);
        localb.sM.setVisibility(0);
      }
    }
  }
  
  public static class a
    extends aoiz
  {
    public static final String cD(int paramInt)
    {
      return abxi.bip + paramInt + "/panelGif.gif";
    }
    
    public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
      throws Exception
    {
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadStarted();
      }
      if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof Integer)))
      {
        paramDownloadParams = (Integer)paramDownloadParams.tag;
        paramOutputStream = new File(cD(paramDownloadParams.intValue()));
        if (paramOutputStream.exists())
        {
          if (paramURLDrawableHandler != null) {
            paramURLDrawableHandler.onFileDownloadSucceed(paramOutputStream.length());
          }
          return paramOutputStream;
        }
        paramOutputStream.getParentFile().mkdirs();
        if ((BaseApplicationImpl.sApplication != null) && (!aqiw.isNetworkAvailable(BaseApplicationImpl.sApplication)) && (paramURLDrawableHandler != null)) {
          paramURLDrawableHandler.onFileDownloadFailed(0);
        }
        paramDownloadParams = new aquz("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramDownloadParams + "/preview.gif", paramOutputStream);
        paramDownloadParams.retryCount = 1;
        paramDownloadParams.cWy = false;
        if (aqva.a(paramDownloadParams, null) == 0)
        {
          if (paramURLDrawableHandler != null) {
            paramURLDrawableHandler.onFileDownloadSucceed(paramOutputStream.length());
          }
          return paramOutputStream;
        }
      }
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadFailed(0);
      }
      return null;
    }
  }
  
  public static class b
    extends BaseBubbleBuilder.e
    implements URLDrawable.URLDrawableListener
  {
    public TextView IJ;
    public TextView IK;
    public TextView IL;
    public TextView IM;
    public ImageSpan a;
    public URLImageView ar;
    public SpannableStringBuilder e;
    public ImageView iconView;
    public int mActionId;
    public ImageView mLoadingView;
    public RelativeLayout o;
    public ImageView sL;
    public ImageView sM;
    public int tag;
    
    public void onLoadCanceled(URLDrawable paramURLDrawable) {}
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      if (this.IM != null) {
        this.IM.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onLoadSuccessed,mDrawableCacheKey:" + paramURLDrawable);
      }
    }
  }
  
  public static class c
    extends ImageSpan
  {
    public c(Drawable paramDrawable)
    {
      super();
    }
    
    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramCharSequence = getDrawable();
      paramCanvas.save();
      paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      paramCharSequence = getDrawable().getBounds();
      if (paramFontMetricsInt != null)
      {
        paramPaint = paramPaint.getFontMetricsInt();
        paramInt2 = paramPaint.bottom - paramPaint.top;
        int i = paramCharSequence.bottom - paramCharSequence.top;
        paramInt1 = i / 2 - paramInt2 / 4;
        i /= 2;
        paramInt2 = paramInt2 / 4 + i;
        paramFontMetricsInt.ascent = (-paramInt2);
        paramFontMetricsInt.top = (-paramInt2);
        paramFontMetricsInt.bottom = paramInt1;
        paramFontMetricsInt.descent = paramInt1;
      }
      return paramCharSequence.right;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder
 * JD-Core Version:    0.7.0.1
 */