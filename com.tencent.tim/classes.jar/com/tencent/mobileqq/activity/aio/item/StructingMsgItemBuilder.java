package com.tencent.mobileqq.activity.aio.item;

import acbn;
import acfp;
import acne;
import afdv;
import ahbj;
import ahgq;
import ahtr;
import ajlc;
import ajlg;
import akyj;
import anaz;
import anbk;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import annt;
import anot;
import anqu;
import anra;
import anre;
import ansh;
import ansu;
import answ.a;
import antc;
import antz;
import anun.a;
import anvf;
import aobw;
import aoiz;
import aojn;
import aoko;
import aooi;
import aoop;
import apsa;
import aqfr;
import aqgv;
import aqha;
import aqhq;
import aqiu;
import aqju;
import aqoa;
import aqob;
import aqoi;
import aqxg;
import aqxh;
import augo;
import ausj;
import auss;
import auuw;
import auuw.a;
import avdb;
import aviz;
import avja;
import avjg;
import avjj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.a;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XListView;
import cooperation.comic.VipComicJumpActivity;
import java.io.File;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jqc;
import kct;
import kds;
import mqq.os.MqqHandler;
import obl.a;
import obo;
import ocp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rar;
import rpq;
import ujt;
import wja;
import wko.a;
import wla.a;
import wlz;
import wvy;
import wyf;
import xoc;
import xoh;
import xoi;
import xoj;
import xok;
import xol;
import xon;
import xoo;
import xop;
import xoq;
import xor;
import xos;
import xot;
import xtj;
import xtm;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.a, MediaPlayerManager.a, wla.a
{
  static int bVM;
  public static final int[] hw = { 83, 98, 108, 114, 116, 151, 156 };
  private ansh a;
  auuw b;
  private volatile boolean bhX;
  private volatile boolean bhY;
  private volatile boolean bhZ;
  private final float mDensity;
  private List<StructMsgForImageShare> rZ = new ArrayList();
  private List<AbsShareMsg> sf = new ArrayList();
  
  public StructingMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.a = new ansh();
  }
  
  private StructMsgForGeneralShare a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {
      paramChatMessage = null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare;
    do
    {
      return paramChatMessage;
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) {
        break;
      }
      localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
      paramChatMessage = localStructMsgForGeneralShare;
    } while (localStructMsgForGeneralShare.getProgress() >= 0);
    return null;
  }
  
  private void a(Activity paramActivity, View paramView, ChatMessage paramChatMessage)
  {
    String str = paramChatMessage.frienduin;
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = localAbsStructMsg.adverKey;
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      i = 0;
      if (i < ((JSONArray)localObject1).length())
      {
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject1).get(i);
        Object localObject2 = new auuw.a();
        ((auuw.a)localObject2).id = i;
        ((auuw.a)localObject2).iconId = 0;
        if (localJSONObject.has("show_name")) {}
        for (((auuw.a)localObject2).title = localJSONObject.getString("show_name");; ((auuw.a)localObject2).title = "")
        {
          localArrayList1.add(localObject2);
          localObject2 = new obl.a();
          ((obl.a)localObject2).puin = str;
          ((obl.a)localObject2).index = localJSONObject.optString("index");
          ((obl.a)localObject2).name = localJSONObject.optString("index_name");
          ((obl.a)localObject2).type = localJSONObject.optString("index_type");
          ((obl.a)localObject2).aoY = String.valueOf(jqc.getNetWorkType());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      this.b = auuw.a(paramActivity, localArrayList1, new xoh(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new xoi(this), wja.dp2px(100.0F, paramActivity.getResources()));
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    int i = paramView.getWidth() * 7 / 2;
    this.b.showAsDropDown(paramView, 0 - i, 0);
    this.b.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.b.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.b.setOnDismissListener(new xoj(this));
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new anra(this.app, paramView).i(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(aqoi paramaqoi, a parama)
  {
    if (parama.hL == null) {
      return;
    }
    Object localObject;
    int i;
    if ((paramaqoi instanceof aojn))
    {
      localObject = (aojn)paramaqoi;
      i = (int)((aojn)localObject).hh();
      if ((i != 1004) || (!((aojn)localObject).azP()) || (!((aojn)localObject).isPause())) {
        break label420;
      }
      i = 1006;
    }
    label420:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131378856);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131378856);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131378856);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131378856);
      if ((parama.hL != null) && (parama.hL.findViewById(2131378843) == null) && (parama.b != null)) {
        parama.hL.addView(parama.b, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (parama.b == null) {
          break;
        }
        parama.b.setProcessor(null);
        parama.b.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (parama.b == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.mContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131378843);
          localMessageProgressTextView.setBackgroundDrawable(new wyf(2130706432, this.mDensity * 12.0F));
          if (parama.hL != null) {
            parama.hL.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          parama.b = localMessageProgressTextView;
        }
        parama.b.setProcessor((aojn)paramaqoi);
        parama.b.setVisibility(0);
        switch (i)
        {
        }
        for (;;)
        {
          parama.b.adc();
          return;
          parama.b.setProgress(0);
          return;
          parama.b.setProgress(0);
        }
        if (parama.b == null) {
          break;
        }
        parama.b.setProcessor(null);
        parama.b.setVisibility(4);
        return;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      acne localacne = (acne)this.app.getBusinessHandler(28);
      localacne.f(anbk.ab(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new xop(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131380283, paramMessageForStructing);
      localacne.a(paramBaseChatItemLayout, paramMessageForStructing);
    }
  }
  
  private void a(a parama, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      parama.E.setBackgroundResource(2130851770);
      int i = parama.hL.getPaddingLeft();
      int j = parama.hL.getPaddingLeft();
      parama.hL.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(a parama, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    Object localObject2 = parama.hM;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new RelativeLayout(this.mContext);
      parama.hM = ((RelativeLayout)localObject1);
      ((RelativeLayout)localObject1).setId(2131378837);
      paramBaseChatItemLayout.addView((View)localObject1);
    }
    Object localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    }
    ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(-2.0F, paramResources);
    if (paramBoolean2)
    {
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(0.0F, paramResources);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364503);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364503);
      if (!paramBoolean1) {
        break label535;
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131364512);
      label148:
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject3 = ((RelativeLayout)localObject1).getChildAt(0);
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (parama.hL != null)
        {
          Object localObject4 = parama.hL.getChildAt(0);
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject4 = ((View)localObject4).getTag(2131378856);
            if (QLog.isColorLevel()) {
              QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject4);
            }
            if (localObject4 != null)
            {
              localObject2 = localObject3;
              if (localObject4.getClass() == paramAbsStructMsg.getClass()) {}
            }
            else
            {
              localObject2 = null;
            }
          }
        }
      }
      ((RelativeLayout)localObject1).removeAllViews();
      ((RelativeLayout)localObject1).setBackgroundDrawable(null);
      localObject2 = paramAbsStructMsg.getSourceView(this.mContext, (View)localObject2);
      if (localObject2 == null) {
        break label557;
      }
      ((View)localObject2).setId(2131378838);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      if (ThemeUtil.isInNightMode(this.app))
      {
        parama = new View(this.mContext);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
        paramBaseChatItemLayout.addRule(6, 2131378838);
        paramBaseChatItemLayout.addRule(5, 2131378838);
        paramBaseChatItemLayout.addRule(7, 2131378838);
        paramBaseChatItemLayout.addRule(8, 2131378838);
        parama.setBackgroundResource(2130838067);
        ((RelativeLayout)localObject1).addView(parama, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      a(paramAbsStructMsg, (RelativeLayout)localObject1);
      ahtr.a((View)localObject2, (RelativeLayout)localObject1, paramBoolean1, paramResources, this.mContext, paramAbsStructMsg);
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(10.0F, paramResources);
      if ((!paramBoolean1) || ((paramAbsStructMsg.mMsgServiceID != 83) && (paramAbsStructMsg.mMsgServiceID != 108) && (paramAbsStructMsg.mMsgServiceID != 114) && (paramAbsStructMsg.mMsgServiceID != 116) && (paramAbsStructMsg.mMsgServiceID != 151) && (paramAbsStructMsg.mMsgServiceID != 156)) || (TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData))) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin += wja.dp2px(18.0F, paramResources);
      break;
      label535:
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131364512);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131364503);
      break label148;
      label557:
      paramBaseChatItemLayout.removeView((View)localObject1);
      parama.hM = null;
    }
  }
  
  private void a(a parama, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = parama.hN;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.mContext);
      parama.hM = localRelativeLayout;
      localRelativeLayout.setId(2131378836);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - wja.dp2px(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364503);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364503);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.mContext, paramResources);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      parama = (RelativeLayout.LayoutParams)paramStructMsgForGeneralShare.getLayoutParams();
      parama.topMargin = rpq.dip2px(this.mContext, 10.0F);
      parama.height = -2;
      parama.width = -2;
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    parama.hM = null;
  }
  
  private void a(AbsShareMsg paramAbsShareMsg)
  {
    if (!this.sf.contains(paramAbsShareMsg))
    {
      paramAbsShareMsg.report(Integer.valueOf(0));
      this.sf.add(paramAbsShareMsg);
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setVisibility(0);
    if ((paramAbsStructMsg.mMsgUrl != null) && ((paramAbsStructMsg.mMsgUrl.startsWith("https://3gimg.qq.com/wap30/infoopstatic")) || (paramAbsStructMsg.mMsgUrl.startsWith("https://viola.qq.com/js/redpackIndex.js"))) && ("1".equals(Uri.parse(paramAbsStructMsg.mMsgUrl).getQueryParameter("hidesource")))) {
      paramRelativeLayout.setVisibility(8);
    }
  }
  
  private void a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (!this.rZ.contains(paramStructMsgForImageShare))
    {
      paramStructMsgForImageShare.report(Long.valueOf(((Activity)this.mContext).getIntent().getLongExtra("req_share_id", 0L)));
      this.rZ.add(paramStructMsgForImageShare);
    }
  }
  
  private static void a(String paramString, URL paramURL, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.cuR = true;
    paramString = aoiz.getFilePath(paramURL.toString());
    QLog.d("StructingMsgItemBuilder", 1, new Object[] { "generateHdPic hdThumbFilePath=", paramString });
    if (!paramString.endsWith("_hd"))
    {
      if (!paramString.endsWith("_big400")) {
        break label136;
      }
      paramString.replace("_big400", "_hd");
    }
    while (new File(paramString).exists())
    {
      QLog.d("StructingMsgItemBuilder", 1, "hd image exists, no need compress");
      paramString = URLDrawable.getDrawable(paramURL);
      if (paramString != null)
      {
        QLog.d("StructingMsgItemBuilder", 1, "hd image invalidateSelf");
        ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.15(paramString));
      }
      return;
      label136:
      paramString = paramString + "_hd";
    }
    localCompressInfo.destPath = paramString;
    for (;;)
    {
      try
      {
        new File(paramString).getParentFile().mkdirs();
        localCompressInfo.a = paramThumbWidthHeightDP;
        if (akyj.c(localCompressInfo))
        {
          paramThumbWidthHeightDP = "hd image compress success";
          QLog.d("StructingMsgItemBuilder", 1, paramThumbWidthHeightDP);
          if (localCompressInfo.destPath == null) {
            break;
          }
          paramString = new File(paramString);
          if (!localCompressInfo.destPath.equals(localCompressInfo.srcPath)) {
            break label392;
          }
          bool = ahbj.copyFile(new File(localCompressInfo.srcPath), paramString);
          QLog.d("StructingMsgItemBuilder", 1, new Object[] { "ret=", Boolean.valueOf(bool), ", thumbCI.destPath=", localCompressInfo.destPath, ", thumbCI.srcPath=", localCompressInfo.srcPath });
          if ((!bool) || (BaseApplicationImpl.sImageCache.get(paramURL.toString()) == null)) {
            break;
          }
          BaseApplicationImpl.sImageCache.remove(paramURL.toString());
          paramString = URLDrawable.getDrawable(paramURL);
          if (paramString == null) {
            break;
          }
          QLog.d("StructingMsgItemBuilder", 1, "hd image invalidateSelf");
          ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.16(paramString));
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("StructingMsgItemBuilder", 1, "hd image file parent create fail");
        return;
      }
      paramThumbWidthHeightDP = "hd image compress fail";
      continue;
      label392:
      boolean bool = true;
    }
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg, aqoa paramaqoa)
  {
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if ((paramAbsStructMsg == null) || (paramaqoa == null) || (this.mContext == null)) {
      bool1 = false;
    }
    int j;
    do
    {
      return bool1;
      this.mContext.getResources();
      if (paramAbsStructMsg.mMsgServiceID != 35) {
        break;
      }
      j = paramaqoa.size();
      bool1 = bool2;
    } while (j <= 0);
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      paramAbsStructMsg = paramaqoa.a(i);
      if (paramAbsStructMsg != null)
      {
        bool1 = bool2;
        if (paramAbsStructMsg.getItemId() == 2131366733) {
          break;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b(Activity paramActivity, View paramView, ChatMessage paramChatMessage)
  {
    ArrayList localArrayList = new ArrayList();
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    Object localObject = localAbsStructMsg.adverKey;
    for (;;)
    {
      try
      {
        localObject = new JSONArray((String)localObject);
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break;
        }
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
        auuw.a locala = new auuw.a();
        if (localJSONObject.has("index"))
        {
          locala.id = localJSONObject.getInt("index");
          locala.iconId = 0;
          if (localJSONObject.has("show_name"))
          {
            locala.title = localJSONObject.getString("show_name");
            localArrayList.add(locala);
            i += 1;
          }
        }
        else
        {
          locala.id = i;
          continue;
        }
        locala.title = "";
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    this.b = auuw.a(paramActivity, localArrayList, new xol(this, paramChatMessage, paramActivity, localAbsStructMsg), new xon(this), wja.dp2px(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.b.showAsDropDown(paramView, i, 0);
    this.b.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.b.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.b.setOnDismissListener(new xoo(this));
  }
  
  private void bA(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559846, null);
    ((ImageView)localView.findViewById(2131368846)).setImageResource(2130840113);
    ((TextView)localView.findViewById(2131379419)).setText(acfp.m(2131715004));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.23(this, localReportDialog), 1500L);
    this.bhY = false;
  }
  
  private void bB(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559846, null);
    ((ImageView)localView.findViewById(2131368846)).setImageResource(2130840095);
    ((TextView)localView.findViewById(2131379419)).setText(acfp.m(2131715003));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.24(this, localReportDialog), 1500L);
    this.bhY = false;
  }
  
  private boolean c(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = paramMessageForStructing.structingMsg;
    boolean bool = paramMessageForStructing.hasFlag(4);
    if (((paramMessageForStructing instanceof AbsShareMsg)) && (((AbsShareMsg)paramMessageForStructing).mMsgException)) {
      bool = true;
    }
    for (;;)
    {
      if ((paramMessageForStructing.mMsgServiceID == 76) || (paramMessageForStructing.mMsgServiceID == 91)) {
        bool = true;
      }
      return bool;
    }
  }
  
  private boolean d(MessageForStructing paramMessageForStructing)
  {
    return (paramMessageForStructing.isSendFromLocal()) && (paramMessageForStructing.extraflag == 32772) && (paramMessageForStructing.structingMsg != null) && ((paramMessageForStructing.structingMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramMessageForStructing.structingMsg).isSdkShareMsg()) && (!((AbsShareMsg)paramMessageForStructing.structingMsg).shareData.isFinish());
  }
  
  private boolean g(AbsStructMsg paramAbsStructMsg)
  {
    return 19 == paramAbsStructMsg.mMsgServiceID;
  }
  
  private void gb(long paramLong)
  {
    if (((this.mContext instanceof ChatActivity)) || ((this.mContext instanceof SplashActivity)))
    {
      aqxh localaqxh = (aqxh)this.app.getManager(76);
      aqxg localaqxg = localaqxh.a();
      BaseActivity localBaseActivity = (BaseActivity)this.mContext;
      if ((localaqxg != null) && (localBaseActivity.isResume()) && (localaqxg.senderuin.equalsIgnoreCase(this.sessionInfo.aTl)) && (localaqxg.status == 2L) && (paramLong == localaqxg.uniseq)) {
        localaqxh.a(localaqxg, localBaseActivity);
      }
    }
  }
  
  public static String pv()
  {
    return String.valueOf(bVM);
  }
  
  private boolean s(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {}
    do
    {
      return false;
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
    } while (!(paramChatMessage instanceof StructMsgForImageShare));
    paramChatMessage = ((StructMsgForImageShare)paramChatMessage).getFirstImageElement();
    if ((paramChatMessage != null) && (paramChatMessage.useCustomSize())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean t(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return false;
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg instanceof StructMsgForGeneralShare))
      {
        paramChatMessage = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
        int i = 0;
        while (i < paramChatMessage.getItemCount())
        {
          if ((paramChatMessage.getItemByIndex(i) instanceof antc)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    this.a.reportStart();
    if (paramView == null) {}
    MessageForStructing localMessageForStructing;
    AbsStructMsg localAbsStructMsg;
    for (int i = 1;; i = 2)
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      localAbsStructMsg = null;
      if (localMessageForStructing != null) {
        localAbsStructMsg = localMessageForStructing.structingMsg;
      }
      if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
        rar.a(this.app, this.mContext, localMessageForStructing, "exp");
      }
      if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (!((StructMsgForGeneralShare)localAbsStructMsg).havaPayInfoInit))
      {
        localObject = paramChatMessage.getExtInfoFromExtStr("pa_pay_message");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("1"))) {
          ((StructMsgForGeneralShare)localAbsStructMsg).initPay(this.mContext, paramChatMessage);
        }
      }
      if (localAbsStructMsg != null) {
        break;
      }
      return paramView;
    }
    int k = -1;
    int j = k;
    if (paramView != null)
    {
      j = k;
      if ((paramView.getTag() instanceof BaseBubbleBuilder.e))
      {
        localObject = (BaseBubbleBuilder.e)paramView.getTag();
        j = k;
        if (localObject != null) {
          j = ((BaseBubbleBuilder.e)localObject).pos;
        }
      }
    }
    localAbsStructMsg.message = localMessageForStructing;
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    if (localAbsStructMsg.mMsgServiceID == 76)
    {
      paramInt2 = wja.dp2px(11.0F, this.mContext.getResources());
      k = wja.dp2px(7.5F, this.mContext.getResources());
      paramView.setPadding(0, 0, 0, 0);
      paramViewGroup = (BaseBubbleBuilder.e)paramView.getTag();
      paramViewGroup.E.setPadding(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramViewGroup.E.getLayoutParams()).setMargins(paramInt2, k, paramInt2, k);
    }
    if (localAbsStructMsg.mMsgServiceID == 35)
    {
      paramViewGroup = (BaseBubbleBuilder.e)paramView.getTag();
      paramViewGroup.E.setPadding(paramViewGroup.E.getPaddingLeft(), 0, paramViewGroup.E.getPaddingRight(), 0);
    }
    paramViewGroup = (a)paramView.getTag();
    Object localObject = paramViewGroup.a;
    if (((i == 1) || (j != paramViewGroup.pos)) && (localAbsStructMsg.mMsgServiceID == 128)) {
      aqfr.b("Grp_AIO", "invite", "send_exp", 0, 0, new String[] { String.valueOf(localAbsStructMsg.uniseq) });
    }
    int m;
    if ((localAbsStructMsg instanceof AbsShareMsg))
    {
      paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;
      if ((this.sessionInfo.cZ != 1008) && (localAbsStructMsg.hasFlag(4))) {
        localAbsStructMsg.addFlag(1);
      }
      paramwlz = this.mContext.getResources();
      boolean bool = c(localMessageForStructing);
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
      }
      a(paramViewGroup, (BaseChatItemLayout)localObject, bool);
      a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), localAbsStructMsg, paramwlz, bool);
      if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsStructMsg).mHasAdSource)) {
        a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localAbsStructMsg, paramwlz, bool);
      }
      if ((this.sessionInfo.cZ == 1008) || (localMessageForStructing.structingMsg.mMsgServiceID == 76) || (localMessageForStructing.structingMsg.mMsgServiceID == 21))
      {
        k = paramwlz.getDimensionPixelSize(2131299515);
        m = paramwlz.getDimensionPixelSize(2131299515);
        if ((!BaseChatItemLayout.bdx) || (!bool)) {
          break label1008;
        }
        paramInt1 = 1;
        label678:
        AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
        j = paramInt1;
        if (localAIOLongShotHelper != null)
        {
          j = paramInt1;
          if (localAIOLongShotHelper.RS()) {
            j = 0;
          }
        }
        paramInt1 = k;
        if (j != 0)
        {
          j = wja.dp2px(30.0F, paramwlz);
          paramInt1 = j;
          if (((BaseChatItemLayout)localObject).mCheckBox != null)
          {
            localObject = (RelativeLayout.LayoutParams)((BaseChatItemLayout)localObject).mCheckBox.getLayoutParams();
            paramInt1 = j;
            if (localObject != null)
            {
              ((RelativeLayout.LayoutParams)localObject).leftMargin = wja.dp2px(5.0F, paramwlz);
              paramInt1 = j;
            }
          }
        }
        paramwlz = (RelativeLayout.LayoutParams)((RelativeLayout)((BaseChatItemLayout)paramView).aP()).getLayoutParams();
        if (paramwlz != null)
        {
          if (localMessageForStructing.structingMsg.mMsgServiceID == 21) {
            break label1013;
          }
          paramwlz.setMargins(paramInt1, 0, m, 0);
        }
      }
    }
    for (;;)
    {
      paramView.requestLayout();
      if ((paramViewGroup != null) && (paramViewGroup.mMessage == paramChatMessage) && (localAbsStructMsg.hasFlag(16))) {
        ThreadManager.post(new StructingMsgItemBuilder.5(this, paramViewGroup), 2, null, false);
      }
      paramwlz = (apsa)this.app.getManager(132);
      if (paramwlz.be(paramChatMessage))
      {
        paramwlz.lR(paramChatMessage.uniseq);
        paramViewGroup.E.setVisibility(8);
        paramwlz = AnimationUtils.loadAnimation(this.mContext, 2130772280);
        paramwlz.setAnimationListener(new xot(this, paramViewGroup));
        paramViewGroup.E.postDelayed(new StructingMsgItemBuilder.7(this, paramViewGroup, paramwlz), 300L);
      }
      this.a.jG(paramInt2, i);
      if ((this.sessionInfo != null) && ("3046055438".equals(this.sessionInfo.aTl))) {
        kds.a(this.app, paramChatMessage, paramView);
      }
      return paramView;
      paramInt2 = -1;
      break;
      label1008:
      paramInt1 = 0;
      break label678;
      label1013:
      paramwlz.setMargins(paramInt1, paramwlz.topMargin, m, paramwlz.bottomMargin);
    }
  }
  
  /* Error */
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    // Byte code:
    //   0: new 1183	android/os/Bundle
    //   3: dup
    //   4: invokespecial 1184	android/os/Bundle:<init>	()V
    //   7: astore 15
    //   9: aload_0
    //   10: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   13: instanceof 914
    //   16: ifne +13 -> 29
    //   19: aload_0
    //   20: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   23: instanceof 916
    //   26: ifeq +2857 -> 2883
    //   29: aload_0
    //   30: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   33: checkcast 1186	android/support/v4/app/FragmentActivity
    //   36: invokevirtual 1190	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   39: invokevirtual 1195	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   42: invokevirtual 1200	com/tencent/mobileqq/activity/BaseChatPie:a	()Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$b;
    //   45: astore 10
    //   47: aload_3
    //   48: ifnonnull +131 -> 179
    //   51: aload_0
    //   52: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   55: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   58: astore 9
    //   60: new 305	android/widget/RelativeLayout
    //   63: dup
    //   64: aload_0
    //   65: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   68: invokespecial 434	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   71: astore_3
    //   72: aload_3
    //   73: ldc_w 451
    //   76: invokevirtual 436	android/widget/RelativeLayout:setId	(I)V
    //   79: aload_3
    //   80: ldc_w 1201
    //   83: aload 9
    //   85: invokestatic 212	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   88: invokevirtual 1204	android/widget/RelativeLayout:setMinimumHeight	(I)V
    //   91: aload_3
    //   92: iconst_1
    //   93: invokevirtual 1207	android/widget/RelativeLayout:setClickable	(Z)V
    //   96: aload_3
    //   97: getstatic 1210	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:bNX	I
    //   100: getstatic 1213	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:bNV	I
    //   103: getstatic 1216	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:bNY	I
    //   106: getstatic 1219	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:bNW	I
    //   109: invokevirtual 429	android/widget/RelativeLayout:setPadding	(IIII)V
    //   112: aload_3
    //   113: ldc_w 1220
    //   116: invokevirtual 1221	android/widget/RelativeLayout:setBackgroundResource	(I)V
    //   119: new 295	android/widget/RelativeLayout$LayoutParams
    //   122: dup
    //   123: bipush 254
    //   125: bipush 254
    //   127: invokespecial 298	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   130: astore 11
    //   132: aload 9
    //   134: ldc_w 1085
    //   137: invokevirtual 1089	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   140: istore 6
    //   142: aload 11
    //   144: iload 6
    //   146: iconst_0
    //   147: iload 6
    //   149: iconst_0
    //   150: invokevirtual 1025	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   153: aload 11
    //   155: iconst_1
    //   156: ldc_w 1222
    //   159: invokevirtual 302	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   162: aload_3
    //   163: aload 11
    //   165: invokevirtual 456	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   168: ldc 83
    //   170: aload_1
    //   171: invokevirtual 1227	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   174: ifne +30 -> 204
    //   177: aload_3
    //   178: areturn
    //   179: aload_3
    //   180: instanceof 1229
    //   183: ifeq +18 -> 201
    //   186: aload_0
    //   187: aload_1
    //   188: invokespecial 1231	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:s	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   191: ifne +10 -> 201
    //   194: aload_3
    //   195: checkcast 1229	android/view/ViewGroup
    //   198: invokevirtual 1232	android/view/ViewGroup:removeAllViews	()V
    //   201: goto -33 -> 168
    //   204: aload_2
    //   205: getfield 1233	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder$e:a	Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout;
    //   208: aload_0
    //   209: invokevirtual 1237	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setMiniAioShieldItemTouchListener	(Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout$a;)V
    //   212: aload_1
    //   213: checkcast 83	com/tencent/mobileqq/data/MessageForStructing
    //   216: astore 13
    //   218: aload 13
    //   220: getfield 87	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   223: astore 14
    //   225: aload 14
    //   227: ifnonnull +77 -> 304
    //   230: invokestatic 467	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -56 -> 177
    //   236: new 471	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 472	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1239
    //   246: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: astore_2
    //   250: aload 13
    //   252: ifnonnull +24 -> 276
    //   255: ldc_w 1241
    //   258: astore_1
    //   259: ldc_w 469
    //   262: iconst_2
    //   263: aload_2
    //   264: aload_1
    //   265: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 485	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 489	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_3
    //   275: areturn
    //   276: aload 13
    //   278: getfield 1245	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   281: ifnonnull +10 -> 291
    //   284: ldc_w 1241
    //   287: astore_1
    //   288: goto -29 -> 259
    //   291: aload 13
    //   293: getfield 1245	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   296: arraylength
    //   297: invokestatic 575	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: astore_1
    //   301: goto -42 -> 259
    //   304: aload 14
    //   306: aload 13
    //   308: putfield 1016	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   311: aload_0
    //   312: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   315: ifnull +241 -> 556
    //   318: aload_0
    //   319: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   322: getfield 1054	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   325: sipush 1008
    //   328: if_icmpne +228 -> 556
    //   331: aload 14
    //   333: instanceof 89
    //   336: ifeq +39 -> 375
    //   339: aload 14
    //   341: checkcast 89	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   344: astore_2
    //   345: aload 15
    //   347: ldc_w 1247
    //   350: aload_0
    //   351: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   354: getfield 944	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   357: invokevirtual 1251	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload 15
    //   362: ldc_w 1253
    //   365: aload_0
    //   366: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   369: getfield 1256	com/tencent/mobileqq/activity/aio/SessionInfo:aTn	Ljava/lang/String;
    //   372: invokevirtual 1251	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload 15
    //   377: ldc_w 1258
    //   380: iconst_1
    //   381: invokevirtual 1262	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   384: aload_1
    //   385: ldc_w 1264
    //   388: invokevirtual 1000	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   391: astore_2
    //   392: aload_2
    //   393: ifnull +163 -> 556
    //   396: aload_2
    //   397: ldc 189
    //   399: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   402: ifne +154 -> 556
    //   405: aload_2
    //   406: invokestatic 533	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   409: ifne +9 -> 418
    //   412: aload 14
    //   414: aload_2
    //   415: putfield 1267	com/tencent/mobileqq/structmsg/AbsStructMsg:templateIDForPortal	Ljava/lang/String;
    //   418: aload 14
    //   420: instanceof 577
    //   423: ifeq +133 -> 556
    //   426: aload 14
    //   428: checkcast 577	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   431: invokevirtual 1271	com/tencent/mobileqq/structmsg/AbsShareMsg:getStructMsgItemLists	()Ljava/util/List;
    //   434: astore 9
    //   436: aload 9
    //   438: ifnull +118 -> 556
    //   441: aload 9
    //   443: invokeinterface 1275 1 0
    //   448: astore 9
    //   450: aload 9
    //   452: invokeinterface 1280 1 0
    //   457: ifeq +99 -> 556
    //   460: aload 9
    //   462: invokeinterface 1283 1 0
    //   467: checkcast 1285	anqu
    //   470: astore 11
    //   472: aload_2
    //   473: invokestatic 533	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   476: ifne +9 -> 485
    //   479: aload 11
    //   481: aload_2
    //   482: putfield 1286	anqu:templateIDForPortal	Ljava/lang/String;
    //   485: aload 11
    //   487: instanceof 1288
    //   490: ifeq -40 -> 450
    //   493: aload 11
    //   495: checkcast 1288	anqv
    //   498: astore 11
    //   500: aload 11
    //   502: getfield 1292	anqv:rz	Ljava/util/ArrayList;
    //   505: ifnull -55 -> 450
    //   508: aload 11
    //   510: getfield 1292	anqv:rz	Ljava/util/ArrayList;
    //   513: invokevirtual 1293	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   516: astore 11
    //   518: aload 11
    //   520: invokeinterface 1280 1 0
    //   525: ifeq -75 -> 450
    //   528: aload 11
    //   530: invokeinterface 1283 1 0
    //   535: checkcast 1285	anqu
    //   538: astore 12
    //   540: aload_2
    //   541: invokestatic 533	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   544: ifne -26 -> 518
    //   547: aload 12
    //   549: aload_2
    //   550: putfield 1286	anqu:templateIDForPortal	Ljava/lang/String;
    //   553: goto -35 -> 518
    //   556: aload 14
    //   558: aload 13
    //   560: getfield 390	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   563: putfield 1040	com/tencent/mobileqq/structmsg/AbsStructMsg:uniseq	J
    //   566: aload 14
    //   568: aload 13
    //   570: getfield 387	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   573: putfield 1296	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   576: aload 14
    //   578: aload 13
    //   580: getfield 1299	com/tencent/mobileqq/data/MessageForStructing:istroop	I
    //   583: putfield 1302	com/tencent/mobileqq/structmsg/AbsStructMsg:uinType	I
    //   586: aload 14
    //   588: aload 13
    //   590: getfield 1305	com/tencent/mobileqq/data/MessageForStructing:selfuin	Ljava/lang/String;
    //   593: putfield 1308	com/tencent/mobileqq/structmsg/AbsStructMsg:currentAccountUin	Ljava/lang/String;
    //   596: aload 14
    //   598: aload 13
    //   600: getfield 1311	com/tencent/mobileqq/data/MessageForStructing:versionCode	I
    //   603: putfield 1314	com/tencent/mobileqq/structmsg/AbsStructMsg:messageVersion	I
    //   606: aload 15
    //   608: ldc_w 1315
    //   611: aload 13
    //   613: invokevirtual 1077	com/tencent/mobileqq/data/MessageForStructing:isSend	()Z
    //   616: invokevirtual 1262	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   619: aload 14
    //   621: getfield 1302	com/tencent/mobileqq/structmsg/AbsStructMsg:uinType	I
    //   624: sipush 1008
    //   627: if_icmpne +1392 -> 2019
    //   630: aload 14
    //   632: getstatic 1318	com/tencent/mobileqq/structmsg/AbsStructMsg:SOURCE_ACCOUNT_TYPE_PA	I
    //   635: putfield 1321	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   638: aload 15
    //   640: ldc_w 1323
    //   643: aload 14
    //   645: getfield 1321	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   648: invokevirtual 1326	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   651: aload 14
    //   653: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   656: bipush 21
    //   658: if_icmpne +16 -> 674
    //   661: aload 15
    //   663: ldc_w 1328
    //   666: aload 14
    //   668: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   671: invokevirtual 1326	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   674: ldc_w 626
    //   677: aload 14
    //   679: invokevirtual 1227	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   682: ifeq +36 -> 718
    //   685: aload 14
    //   687: checkcast 626	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   690: astore_2
    //   691: aload_2
    //   692: aload 13
    //   694: getfield 1331	com/tencent/mobileqq/data/MessageForStructing:issend	I
    //   697: putfield 1334	com/tencent/mobileqq/structmsg/StructMsgForImageShare:mIsSend	I
    //   700: aload_2
    //   701: aload 13
    //   703: getfield 390	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   706: putfield 1337	com/tencent/mobileqq/structmsg/StructMsgForImageShare:mUniseq	J
    //   709: aload_2
    //   710: aload 13
    //   712: getfield 1340	com/tencent/mobileqq/data/MessageForStructing:msgtype	I
    //   715: putfield 1343	com/tencent/mobileqq/structmsg/StructMsgForImageShare:mMsgType	I
    //   718: aload 4
    //   720: iconst_0
    //   721: invokevirtual 1346	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setAddStatesFromChildren	(Z)V
    //   724: aload 4
    //   726: invokevirtual 1347	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:getTag	()Ljava/lang/Object;
    //   729: astore_2
    //   730: aload_2
    //   731: ifnull +2147 -> 2878
    //   734: aload_2
    //   735: instanceof 15
    //   738: ifeq +2140 -> 2878
    //   741: aload_2
    //   742: checkcast 15	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a
    //   745: astore_2
    //   746: aload_2
    //   747: ifnonnull +2125 -> 2872
    //   750: aload_0
    //   751: invokevirtual 1350	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	()Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a;
    //   754: astore 9
    //   756: aload 9
    //   758: aload_0
    //   759: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   762: putfield 1351	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   765: aload 9
    //   767: getfield 280	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a:hL	Landroid/widget/RelativeLayout;
    //   770: astore_2
    //   771: aload_2
    //   772: astore 11
    //   774: aload_2
    //   775: ifnonnull +16 -> 791
    //   778: aload_3
    //   779: checkcast 305	android/widget/RelativeLayout
    //   782: astore 11
    //   784: aload 9
    //   786: aload 11
    //   788: putfield 280	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a:hL	Landroid/widget/RelativeLayout;
    //   791: aconst_null
    //   792: astore_2
    //   793: aload_3
    //   794: aload 9
    //   796: invokevirtual 1353	android/view/View:setTag	(Ljava/lang/Object;)V
    //   799: aload_1
    //   800: invokestatic 1355	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:t	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   803: ifeq +1254 -> 2057
    //   806: aload 9
    //   808: iconst_1
    //   809: putfield 1358	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a:bib	Z
    //   812: aload 14
    //   814: instanceof 89
    //   817: ifeq +1355 -> 2172
    //   820: aload 14
    //   822: getfield 1361	com/tencent/mobileqq/structmsg/AbsStructMsg:mSType	Ljava/lang/String;
    //   825: ifnull +16 -> 841
    //   828: aload 15
    //   830: ldc_w 1363
    //   833: aload 14
    //   835: getfield 1361	com/tencent/mobileqq/structmsg/AbsStructMsg:mSType	Ljava/lang/String;
    //   838: invokevirtual 1251	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   841: aload_1
    //   842: invokestatic 1368	com/tencent/mobileqq/transfile/StructLongMessageDownloadProcessor:aZ	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   845: ifne +10 -> 855
    //   848: aload_1
    //   849: invokestatic 1371	com/tencent/mobileqq/transfile/StructLongMessageDownloadProcessor:bb	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   852: ifeq +22 -> 874
    //   855: aload 15
    //   857: ldc_w 1373
    //   860: aload 13
    //   862: ldc_w 1375
    //   865: invokevirtual 1376	com/tencent/mobileqq/data/MessageForStructing:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   868: invokestatic 1379	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   871: invokevirtual 1326	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   874: aload 14
    //   876: checkcast 89	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   879: invokevirtual 1382	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getLayoutStr	()Ljava/lang/String;
    //   882: astore 12
    //   884: aload 12
    //   886: astore_2
    //   887: aload_0
    //   888: aload 14
    //   890: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   893: invokevirtual 1385	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:gz	(I)Z
    //   896: ifeq +27 -> 923
    //   899: new 471	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 472	java/lang/StringBuilder:<init>	()V
    //   906: aload 12
    //   908: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload 13
    //   913: getfield 1331	com/tencent/mobileqq/data/MessageForStructing:issend	I
    //   916: invokevirtual 1067	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   919: invokevirtual 485	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: astore_2
    //   923: aload_0
    //   924: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   927: ifnull +1942 -> 2869
    //   930: aload_0
    //   931: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   934: getfield 1054	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   937: sipush 1008
    //   940: if_icmpne +1929 -> 2869
    //   943: ldc_w 1387
    //   946: aload_0
    //   947: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   950: getfield 944	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   953: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   956: ifeq +1913 -> 2869
    //   959: aload_0
    //   960: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   963: checkcast 927	com/tencent/mobileqq/app/BaseActivity
    //   966: getfield 1388	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   969: sipush 341
    //   972: invokevirtual 920	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   975: checkcast 1390	zyd
    //   978: invokevirtual 1393	zyd:VX	()Z
    //   981: ifne +1888 -> 2869
    //   984: aload 15
    //   986: ldc_w 1395
    //   989: aload_1
    //   990: getfield 1397	com/tencent/mobileqq/data/ChatMessage:isShowQWalletPubAd	Z
    //   993: invokevirtual 1262	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   996: new 471	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 472	java/lang/StringBuilder:<init>	()V
    //   1003: aload_2
    //   1004: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: aload_1
    //   1008: getfield 1397	com/tencent/mobileqq/data/ChatMessage:isShowQWalletPubAd	Z
    //   1011: invokevirtual 1072	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1014: invokevirtual 485	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: astore 12
    //   1019: aload 12
    //   1021: astore_2
    //   1022: aload_2
    //   1023: astore 12
    //   1025: aconst_null
    //   1026: astore_2
    //   1027: aload 10
    //   1029: ifnull +15 -> 1044
    //   1032: aload 10
    //   1034: aload 12
    //   1036: aload_3
    //   1037: checkcast 1229	android/view/ViewGroup
    //   1040: invokevirtual 1400	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$b:a	(Ljava/lang/String;Landroid/view/ViewGroup;)Landroid/view/View;
    //   1043: astore_2
    //   1044: aload_2
    //   1045: ifnull +1060 -> 2105
    //   1048: aload 14
    //   1050: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1053: bipush 61
    //   1055: if_icmpne +1032 -> 2087
    //   1058: aload_0
    //   1059: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1062: aload_2
    //   1063: aload_3
    //   1064: invokevirtual 1401	android/view/View:getResources	()Landroid/content/res/Resources;
    //   1067: ldc_w 1402
    //   1070: invokevirtual 1404	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1073: invokestatic 1408	com/tencent/mobileqq/structmsg/AbsStructMsg:getInCompatibleView	(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)Landroid/view/View;
    //   1076: astore_2
    //   1077: aload_3
    //   1078: aload 5
    //   1080: invokevirtual 1412	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1083: aload_3
    //   1084: aload 5
    //   1086: invokevirtual 1416	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1089: aload 14
    //   1091: instanceof 577
    //   1094: ifeq +1294 -> 2388
    //   1097: aload 14
    //   1099: checkcast 577	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   1102: astore 5
    //   1104: aload 5
    //   1106: invokevirtual 1420	com/tencent/mobileqq/structmsg/AbsShareMsg:getOnClickListener	()Landroid/view/View$OnClickListener;
    //   1109: astore 10
    //   1111: aload_3
    //   1112: new 1422	xou
    //   1115: dup
    //   1116: aload_0
    //   1117: aload 5
    //   1119: aload 13
    //   1121: aload_1
    //   1122: aload_1
    //   1123: getfield 1425	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1126: aload 10
    //   1128: invokespecial 1428	xou:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lcom/tencent/mobileqq/structmsg/AbsShareMsg;Lcom/tencent/mobileqq/data/MessageForStructing;Lcom/tencent/mobileqq/data/ChatMessage;JLandroid/view/View$OnClickListener;)V
    //   1131: invokevirtual 1432	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1134: ldc_w 626
    //   1137: aload 14
    //   1139: invokevirtual 1227	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   1142: ifeq +1157 -> 2299
    //   1145: aload_0
    //   1146: getfield 256	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1149: invokestatic 1437	wla:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lwla;
    //   1152: aload 4
    //   1154: aload_0
    //   1155: invokevirtual 1440	wla:a	(Landroid/view/View;Lwla$a;)V
    //   1158: aload_0
    //   1159: aload 13
    //   1161: invokespecial 1442	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:d	(Lcom/tencent/mobileqq/data/MessageForStructing;)Z
    //   1164: ifeq +16 -> 1180
    //   1167: aload_0
    //   1168: getfield 256	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1171: invokestatic 1437	wla:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lwla;
    //   1174: aload 4
    //   1176: aload_0
    //   1177: invokevirtual 1440	wla:a	(Landroid/view/View;Lwla$a;)V
    //   1180: aload 14
    //   1182: invokestatic 1446	obo:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Z
    //   1185: ifeq +1144 -> 2329
    //   1188: aload_3
    //   1189: aconst_null
    //   1190: invokevirtual 1432	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1193: aload 14
    //   1195: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1198: bipush 76
    //   1200: if_icmpeq +13 -> 1213
    //   1203: aload 14
    //   1205: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1208: bipush 106
    //   1210: if_icmpne +28 -> 1238
    //   1213: aload_3
    //   1214: aconst_null
    //   1215: invokevirtual 1432	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1218: aload 14
    //   1220: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1223: bipush 106
    //   1225: if_icmpeq +13 -> 1238
    //   1228: aload_3
    //   1229: aconst_null
    //   1230: invokevirtual 1416	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1233: aload_3
    //   1234: aconst_null
    //   1235: invokevirtual 1412	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1238: aload 14
    //   1240: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1243: bipush 79
    //   1245: if_icmpne +22 -> 1267
    //   1248: aload_3
    //   1249: aconst_null
    //   1250: invokevirtual 1432	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1253: aload_3
    //   1254: new 1448	xoe
    //   1257: dup
    //   1258: aload_0
    //   1259: aload 5
    //   1261: invokespecial 1451	xoe:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)V
    //   1264: invokevirtual 1432	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1267: aload 14
    //   1269: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1272: bipush 81
    //   1274: if_icmpne +3 -> 1277
    //   1277: aload 11
    //   1279: aload_2
    //   1280: invokevirtual 506	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1283: aload 14
    //   1285: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1288: bipush 38
    //   1290: if_icmpne +129 -> 1419
    //   1293: aload_0
    //   1294: getfield 256	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1297: bipush 76
    //   1299: invokevirtual 920	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1302: checkcast 922	aqxh
    //   1305: astore_2
    //   1306: aload_2
    //   1307: ifnull +112 -> 1419
    //   1310: aload_2
    //   1311: aload_1
    //   1312: getfield 1425	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1315: invokevirtual 1454	aqxh:cZ	(J)Z
    //   1318: ifeq +1150 -> 2468
    //   1321: new 1456	android/widget/ProgressBar
    //   1324: dup
    //   1325: aload_0
    //   1326: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1329: invokespecial 1457	android/widget/ProgressBar:<init>	(Landroid/content/Context;)V
    //   1332: astore_2
    //   1333: aload_2
    //   1334: ldc_w 1458
    //   1337: invokevirtual 1459	android/widget/ProgressBar:setId	(I)V
    //   1340: aload_2
    //   1341: aload_0
    //   1342: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1345: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1348: ldc_w 1460
    //   1351: invokevirtual 1463	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1354: invokevirtual 1466	android/widget/ProgressBar:setIndeterminateDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1357: ldc_w 1467
    //   1360: aload_0
    //   1361: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1364: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1367: invokestatic 212	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1370: istore 6
    //   1372: new 295	android/widget/RelativeLayout$LayoutParams
    //   1375: dup
    //   1376: bipush 254
    //   1378: bipush 254
    //   1380: invokespecial 298	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1383: pop
    //   1384: new 295	android/widget/RelativeLayout$LayoutParams
    //   1387: dup
    //   1388: iload 6
    //   1390: iload 6
    //   1392: invokespecial 298	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1395: astore 5
    //   1397: aload 5
    //   1399: bipush 13
    //   1401: ldc_w 451
    //   1404: invokevirtual 302	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1407: aload 11
    //   1409: aload_2
    //   1410: aload 5
    //   1412: invokevirtual 316	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1415: aload_0
    //   1416: invokevirtual 1470	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:ceh	()V
    //   1419: aload 14
    //   1421: instanceof 626
    //   1424: ifeq +1074 -> 2498
    //   1427: aload 13
    //   1429: invokevirtual 896	com/tencent/mobileqq/data/MessageForStructing:isSendFromLocal	()Z
    //   1432: ifeq +38 -> 1470
    //   1435: aload_0
    //   1436: getfield 256	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1439: invokevirtual 1473	com/tencent/mobileqq/app/QQAppInterface:a	()Laooi;
    //   1442: aload 13
    //   1444: getfield 387	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   1447: aload 13
    //   1449: getfield 390	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   1452: invokevirtual 1478	aooi:a	(Ljava/lang/String;J)Laqoi;
    //   1455: astore_2
    //   1456: aload 9
    //   1458: aload 11
    //   1460: putfield 280	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a:hL	Landroid/widget/RelativeLayout;
    //   1463: aload_0
    //   1464: aload_2
    //   1465: aload 9
    //   1467: invokespecial 1480	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Laqoi;Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a;)V
    //   1470: aload 14
    //   1472: checkcast 626	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   1475: invokevirtual 965	com/tencent/mobileqq/structmsg/StructMsgForImageShare:getFirstImageElement	()Lansu;
    //   1478: astore_2
    //   1479: aload_2
    //   1480: ifnull +41 -> 1521
    //   1483: aload_2
    //   1484: getfield 1484	ansu:j	Lcom/tencent/mobileqq/data/MessageForPic;
    //   1487: ifnull +34 -> 1521
    //   1490: aload_0
    //   1491: getfield 256	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1494: invokevirtual 1487	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/pic/PicPreDownloader;
    //   1497: aload_2
    //   1498: getfield 1484	ansu:j	Lcom/tencent/mobileqq/data/MessageForPic;
    //   1501: iconst_2
    //   1502: invokevirtual 1492	com/tencent/mobileqq/pic/PicPreDownloader:a	(Lcom/tencent/mobileqq/data/MessageForPic;I)V
    //   1505: invokestatic 1495	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   1508: new 1497	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$12
    //   1511: dup
    //   1512: aload_0
    //   1513: aload_2
    //   1514: invokespecial 1500	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$12:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lansu;)V
    //   1517: invokevirtual 697	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1520: pop
    //   1521: aload_0
    //   1522: aload 14
    //   1524: checkcast 626	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   1527: invokespecial 1502	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/structmsg/StructMsgForImageShare;)V
    //   1530: aload 14
    //   1532: getfield 1505	com/tencent/mobileqq/structmsg/AbsStructMsg:adverSign	I
    //   1535: iconst_1
    //   1536: if_icmpne +990 -> 2526
    //   1539: new 305	android/widget/RelativeLayout
    //   1542: dup
    //   1543: aload_0
    //   1544: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1547: invokespecial 434	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   1550: astore_2
    //   1551: new 836	android/widget/ImageView
    //   1554: dup
    //   1555: aload_0
    //   1556: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1559: invokespecial 1506	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   1562: astore 5
    //   1564: aload 5
    //   1566: ldc_w 1507
    //   1569: invokevirtual 840	android/widget/ImageView:setImageResource	(I)V
    //   1572: aload_2
    //   1573: iconst_0
    //   1574: invokevirtual 1510	android/widget/RelativeLayout:setBackgroundColor	(I)V
    //   1577: new 295	android/widget/RelativeLayout$LayoutParams
    //   1580: dup
    //   1581: ldc_w 1511
    //   1584: aload_0
    //   1585: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1588: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1591: invokestatic 212	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1594: ldc_w 1201
    //   1597: aload_0
    //   1598: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1601: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1604: invokestatic 212	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1607: invokespecial 298	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1610: astore 10
    //   1612: aload 10
    //   1614: bipush 11
    //   1616: invokevirtual 1513	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1619: aload 10
    //   1621: bipush 10
    //   1623: invokevirtual 1513	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1626: aload_2
    //   1627: aload 10
    //   1629: invokevirtual 456	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1632: new 295	android/widget/RelativeLayout$LayoutParams
    //   1635: dup
    //   1636: bipush 254
    //   1638: bipush 254
    //   1640: invokespecial 298	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1643: astore 10
    //   1645: aload 10
    //   1647: bipush 11
    //   1649: invokevirtual 1513	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1652: aload 10
    //   1654: bipush 10
    //   1656: invokevirtual 1513	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1659: aload 10
    //   1661: iconst_0
    //   1662: bipush 12
    //   1664: bipush 12
    //   1666: iconst_0
    //   1667: invokevirtual 1025	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   1670: aload 5
    //   1672: aload 10
    //   1674: invokevirtual 1514	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1677: aload_2
    //   1678: aload 5
    //   1680: invokevirtual 506	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1683: aload_3
    //   1684: instanceof 305
    //   1687: ifeq +11 -> 1698
    //   1690: aload_3
    //   1691: checkcast 305	android/widget/RelativeLayout
    //   1694: aload_2
    //   1695: invokevirtual 506	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1698: aload 13
    //   1700: getfield 387	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   1703: astore 10
    //   1705: aload 14
    //   1707: getfield 1517	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   1710: lstore 7
    //   1712: aload_0
    //   1713: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1716: instanceof 205
    //   1719: ifeq +22 -> 1741
    //   1722: aload_2
    //   1723: new 1519	xof
    //   1726: dup
    //   1727: aload_0
    //   1728: aload 5
    //   1730: aload_1
    //   1731: aload 10
    //   1733: lload 7
    //   1735: invokespecial 1522	xof:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Landroid/widget/ImageView;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;J)V
    //   1738: invokevirtual 1523	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1741: aload_0
    //   1742: getfield 219	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:b	Lauuw;
    //   1745: ifnull +20 -> 1765
    //   1748: aload_0
    //   1749: getfield 219	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:b	Lauuw;
    //   1752: invokevirtual 1526	auuw:isShowing	()Z
    //   1755: ifeq +10 -> 1765
    //   1758: aload_0
    //   1759: getfield 219	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:b	Lauuw;
    //   1762: invokevirtual 231	auuw:dismiss	()V
    //   1765: aload 4
    //   1767: ifnull +194 -> 1961
    //   1770: aload 13
    //   1772: invokestatic 1531	ajpd:aK	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1775: ifne +186 -> 1961
    //   1778: aload 4
    //   1780: ldc_w 1532
    //   1783: invokevirtual 1533	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:findViewById	(I)Landroid/view/View;
    //   1786: checkcast 1535	com/tencent/mobileqq/doutu/DuiButtonImageView
    //   1789: astore_2
    //   1790: aload_2
    //   1791: ifnonnull +992 -> 2783
    //   1794: new 1535	com/tencent/mobileqq/doutu/DuiButtonImageView
    //   1797: dup
    //   1798: aload_0
    //   1799: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1802: aload_0
    //   1803: getfield 256	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1806: aload_1
    //   1807: invokespecial 1538	com/tencent/mobileqq/doutu/DuiButtonImageView:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1810: astore_2
    //   1811: new 295	android/widget/RelativeLayout$LayoutParams
    //   1814: dup
    //   1815: ldc_w 1539
    //   1818: aload_0
    //   1819: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1822: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1825: invokestatic 212	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1828: ldc_w 1539
    //   1831: aload_0
    //   1832: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1835: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1838: invokestatic 212	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1841: invokespecial 298	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1844: astore 5
    //   1846: aload 5
    //   1848: bipush 8
    //   1850: ldc_w 451
    //   1853: invokevirtual 302	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1856: aload 5
    //   1858: iconst_1
    //   1859: ldc_w 451
    //   1862: invokevirtual 302	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1865: aload 5
    //   1867: getstatic 1219	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:bNW	I
    //   1870: ldc_w 1540
    //   1873: aload_0
    //   1874: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   1877: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1880: invokestatic 212	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1883: isub
    //   1884: putfield 1176	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   1887: aload_2
    //   1888: ldc_w 1532
    //   1891: invokevirtual 1541	com/tencent/mobileqq/doutu/DuiButtonImageView:setId	(I)V
    //   1894: aload 4
    //   1896: aload_2
    //   1897: aload 5
    //   1899: invokevirtual 1542	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1902: aload_1
    //   1903: getfield 1543	com/tencent/mobileqq/data/ChatMessage:extraflag	I
    //   1906: ldc_w 1544
    //   1909: if_icmpne +10 -> 1919
    //   1912: aload_1
    //   1913: invokevirtual 1545	com/tencent/mobileqq/data/ChatMessage:isSendFromLocal	()Z
    //   1916: ifne +17 -> 1933
    //   1919: aload_0
    //   1920: getfield 256	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1923: invokevirtual 1548	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   1926: aload_1
    //   1927: invokevirtual 1553	anaz:aS	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1930: ifeq +861 -> 2791
    //   1933: iconst_1
    //   1934: istore 6
    //   1936: aload_1
    //   1937: getfield 1556	com/tencent/mobileqq/data/ChatMessage:isDui	Z
    //   1940: ifeq +912 -> 2852
    //   1943: iload 6
    //   1945: ifne +907 -> 2852
    //   1948: aload_1
    //   1949: invokevirtual 1557	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   1952: ifeq +845 -> 2797
    //   1955: aload_2
    //   1956: bipush 8
    //   1958: invokevirtual 1558	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   1961: aload_0
    //   1962: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1965: getfield 1054	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   1968: sipush 1008
    //   1971: if_icmpne -1794 -> 177
    //   1974: aload_0
    //   1975: getfield 1562	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:aA	Ljava/util/HashSet;
    //   1978: aload_1
    //   1979: getfield 1135	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   1982: invokestatic 624	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1985: invokevirtual 1565	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1988: ifne -1811 -> 177
    //   1991: aload_0
    //   1992: getfield 1562	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:aA	Ljava/util/HashSet;
    //   1995: aload_1
    //   1996: getfield 1135	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   1999: invokestatic 624	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2002: invokevirtual 1566	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   2005: pop
    //   2006: bipush 117
    //   2008: aload_1
    //   2009: aload 9
    //   2011: getfield 1033	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a:pos	I
    //   2014: invokestatic 1571	adak:a	(ILcom/tencent/mobileqq/data/ChatMessage;I)V
    //   2017: aload_3
    //   2018: areturn
    //   2019: aload 13
    //   2021: ldc_w 1323
    //   2024: invokevirtual 1376	com/tencent/mobileqq/data/MessageForStructing:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   2027: astore_2
    //   2028: aload_2
    //   2029: ifnull -1391 -> 638
    //   2032: aload_2
    //   2033: ldc 189
    //   2035: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2038: ifne -1400 -> 638
    //   2041: aload 14
    //   2043: aload_2
    //   2044: invokestatic 1379	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2047: putfield 1321	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   2050: goto -1412 -> 638
    //   2053: astore_2
    //   2054: goto -1416 -> 638
    //   2057: aload 9
    //   2059: iconst_0
    //   2060: putfield 1358	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$a:bib	Z
    //   2063: goto -1251 -> 812
    //   2066: astore 12
    //   2068: ldc_w 648
    //   2071: iconst_1
    //   2072: aload 12
    //   2074: iconst_0
    //   2075: anewarray 491	java/lang/Object
    //   2078: invokestatic 1575	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2081: aload_2
    //   2082: astore 12
    //   2084: goto -1059 -> 1025
    //   2087: aload 14
    //   2089: aload_0
    //   2090: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2093: aload_2
    //   2094: aload 5
    //   2096: aload 15
    //   2098: invokevirtual 1579	com/tencent/mobileqq/structmsg/AbsStructMsg:getView	(Landroid/content/Context;Landroid/view/View;Lwlz;Landroid/os/Bundle;)Landroid/view/View;
    //   2101: astore_2
    //   2102: goto -1025 -> 1077
    //   2105: aload 14
    //   2107: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2110: bipush 61
    //   2112: if_icmpne +42 -> 2154
    //   2115: aload_0
    //   2116: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2119: aconst_null
    //   2120: aload_3
    //   2121: invokevirtual 1401	android/view/View:getResources	()Landroid/content/res/Resources;
    //   2124: ldc_w 1402
    //   2127: invokevirtual 1404	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2130: invokestatic 1408	com/tencent/mobileqq/structmsg/AbsStructMsg:getInCompatibleView	(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)Landroid/view/View;
    //   2133: astore_2
    //   2134: aload 10
    //   2136: ifnull +15 -> 2151
    //   2139: aload 10
    //   2141: aload 12
    //   2143: aload_2
    //   2144: aload_3
    //   2145: checkcast 1229	android/view/ViewGroup
    //   2148: invokevirtual 1582	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$b:a	(Ljava/lang/String;Landroid/view/View;Landroid/view/ViewGroup;)V
    //   2151: goto -1074 -> 1077
    //   2154: aload 14
    //   2156: aload_0
    //   2157: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2160: aconst_null
    //   2161: aload 5
    //   2163: aload 15
    //   2165: invokevirtual 1579	com/tencent/mobileqq/structmsg/AbsStructMsg:getView	(Landroid/content/Context;Landroid/view/View;Lwlz;Landroid/os/Bundle;)Landroid/view/View;
    //   2168: astore_2
    //   2169: goto -35 -> 2134
    //   2172: aload 11
    //   2174: invokevirtual 1585	android/widget/RelativeLayout:getChildCount	()I
    //   2177: ifle +86 -> 2263
    //   2180: aload 11
    //   2182: iconst_0
    //   2183: invokevirtual 459	android/widget/RelativeLayout:getChildAt	(I)Landroid/view/View;
    //   2186: astore 10
    //   2188: aload 10
    //   2190: astore_2
    //   2191: aload 10
    //   2193: ifnull +70 -> 2263
    //   2196: aload 10
    //   2198: ldc_w 299
    //   2201: invokevirtual 462	android/view/View:getTag	(I)Ljava/lang/Object;
    //   2204: astore 12
    //   2206: invokestatic 467	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2209: ifeq +31 -> 2240
    //   2212: ldc_w 469
    //   2215: iconst_2
    //   2216: new 471	java/lang/StringBuilder
    //   2219: dup
    //   2220: invokespecial 472	java/lang/StringBuilder:<init>	()V
    //   2223: ldc_w 474
    //   2226: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: aload 12
    //   2231: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2234: invokevirtual 485	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2237: invokestatic 489	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2240: aload 12
    //   2242: ifnull +19 -> 2261
    //   2245: aload 10
    //   2247: astore_2
    //   2248: aload 12
    //   2250: invokevirtual 495	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2253: aload 14
    //   2255: invokevirtual 495	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2258: if_acmpeq +5 -> 2263
    //   2261: aconst_null
    //   2262: astore_2
    //   2263: aload 11
    //   2265: invokevirtual 498	android/widget/RelativeLayout:removeAllViews	()V
    //   2268: aload_0
    //   2269: aload_1
    //   2270: invokespecial 1231	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:s	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   2273: ifeq +21 -> 2294
    //   2276: aload 14
    //   2278: aload_0
    //   2279: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2282: aload_2
    //   2283: aload 5
    //   2285: aload 15
    //   2287: invokevirtual 1579	com/tencent/mobileqq/structmsg/AbsStructMsg:getView	(Landroid/content/Context;Landroid/view/View;Lwlz;Landroid/os/Bundle;)Landroid/view/View;
    //   2290: astore_2
    //   2291: goto -1214 -> 1077
    //   2294: aconst_null
    //   2295: astore_2
    //   2296: goto -20 -> 2276
    //   2299: ldc 89
    //   2301: aload 14
    //   2303: invokevirtual 1227	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   2306: ifeq -1148 -> 1158
    //   2309: aload_0
    //   2310: aload 14
    //   2312: invokespecial 1587	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:g	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Z
    //   2315: ifeq -1157 -> 1158
    //   2318: aload_0
    //   2319: aload 4
    //   2321: aload 13
    //   2323: invokespecial 1589	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout;Lcom/tencent/mobileqq/data/MessageForStructing;)V
    //   2326: goto -1168 -> 1158
    //   2329: aload 14
    //   2331: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2334: bipush 78
    //   2336: if_icmpne -1143 -> 1193
    //   2339: aload_0
    //   2340: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2343: checkcast 1186	android/support/v4/app/FragmentActivity
    //   2346: invokevirtual 1190	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   2349: invokevirtual 1195	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   2352: astore 10
    //   2354: aload 14
    //   2356: checkcast 577	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   2359: astore 12
    //   2361: aload 10
    //   2363: instanceof 1591
    //   2366: ifeq -1173 -> 1193
    //   2369: aload_3
    //   2370: new 1593	xod
    //   2373: dup
    //   2374: aload_0
    //   2375: aload 10
    //   2377: aload 12
    //   2379: invokespecial 1596	xod:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lcom/tencent/mobileqq/activity/BaseChatPie;Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)V
    //   2382: invokevirtual 1432	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2385: goto -1192 -> 1193
    //   2388: aload 14
    //   2390: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2393: iconst_3
    //   2394: if_icmpeq +13 -> 2407
    //   2397: aload 14
    //   2399: getfield 526	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2402: bipush 120
    //   2404: if_icmpne -1127 -> 1277
    //   2407: aload_0
    //   2408: invokevirtual 1599	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:Rk	()Z
    //   2411: ifeq +11 -> 2422
    //   2414: aload_3
    //   2415: iconst_0
    //   2416: invokevirtual 1600	android/view/View:setClickable	(Z)V
    //   2419: goto -1142 -> 1277
    //   2422: aload_3
    //   2423: iconst_1
    //   2424: invokevirtual 1600	android/view/View:setClickable	(Z)V
    //   2427: goto -1150 -> 1277
    //   2430: astore 5
    //   2432: aload_2
    //   2433: invokevirtual 1604	android/view/View:getParent	()Landroid/view/ViewParent;
    //   2436: astore 5
    //   2438: aload 5
    //   2440: ifnull +19 -> 2459
    //   2443: aload 5
    //   2445: instanceof 1229
    //   2448: ifeq +11 -> 2459
    //   2451: aload 5
    //   2453: checkcast 1229	android/view/ViewGroup
    //   2456: invokevirtual 1232	android/view/ViewGroup:removeAllViews	()V
    //   2459: aload 11
    //   2461: aload_2
    //   2462: invokevirtual 506	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   2465: goto -1182 -> 1283
    //   2468: aload_0
    //   2469: getfield 939	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   2472: getfield 1054	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   2475: ifne -1056 -> 1419
    //   2478: aload_2
    //   2479: invokevirtual 925	aqxh:a	()Laqxg;
    //   2482: astore_2
    //   2483: aload_2
    //   2484: ifnull -1065 -> 1419
    //   2487: aload_0
    //   2488: aload_2
    //   2489: getfield 953	aqxg:uniseq	J
    //   2492: invokespecial 1606	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:gb	(J)V
    //   2495: goto -1076 -> 1419
    //   2498: aload 14
    //   2500: instanceof 89
    //   2503: ifne +11 -> 2514
    //   2506: aload 14
    //   2508: instanceof 1608
    //   2511: ifeq -981 -> 1530
    //   2514: aload_0
    //   2515: aload 14
    //   2517: checkcast 577	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   2520: invokespecial 1610	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)V
    //   2523: goto -993 -> 1530
    //   2526: aload 14
    //   2528: getfield 1505	com/tencent/mobileqq/structmsg/AbsStructMsg:adverSign	I
    //   2531: iconst_2
    //   2532: if_icmpne -791 -> 1741
    //   2535: new 305	android/widget/RelativeLayout
    //   2538: dup
    //   2539: aload_0
    //   2540: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2543: invokespecial 434	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   2546: astore_2
    //   2547: new 843	android/widget/TextView
    //   2550: dup
    //   2551: aload_0
    //   2552: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2555: invokespecial 1611	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2558: astore 5
    //   2560: aload 5
    //   2562: ldc_w 1612
    //   2565: invokevirtual 1613	android/widget/TextView:setBackgroundResource	(I)V
    //   2568: aload 5
    //   2570: bipush 17
    //   2572: invokevirtual 1614	android/widget/TextView:setGravity	(I)V
    //   2575: aload 14
    //   2577: getfield 1505	com/tencent/mobileqq/structmsg/AbsStructMsg:adverSign	I
    //   2580: istore 6
    //   2582: aload 5
    //   2584: ldc_w 1615
    //   2587: invokestatic 849	acfp:m	(I)Ljava/lang/String;
    //   2590: invokevirtual 853	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2593: aload 5
    //   2595: iconst_m1
    //   2596: invokevirtual 1616	android/widget/TextView:setTextColor	(I)V
    //   2599: aload 5
    //   2601: ldc_w 1617
    //   2604: invokevirtual 1620	android/widget/TextView:setTextSize	(F)V
    //   2607: aload_2
    //   2608: iconst_0
    //   2609: invokevirtual 1510	android/widget/RelativeLayout:setBackgroundColor	(I)V
    //   2612: new 295	android/widget/RelativeLayout$LayoutParams
    //   2615: dup
    //   2616: ldc_w 1511
    //   2619: aload_0
    //   2620: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2623: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2626: invokestatic 212	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   2629: ldc_w 1201
    //   2632: aload_0
    //   2633: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2636: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2639: invokestatic 212	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   2642: invokespecial 298	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2645: astore 10
    //   2647: aload 10
    //   2649: bipush 11
    //   2651: invokevirtual 1513	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2654: aload 10
    //   2656: bipush 10
    //   2658: invokevirtual 1513	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2661: aload_2
    //   2662: aload 10
    //   2664: invokevirtual 456	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2667: new 295	android/widget/RelativeLayout$LayoutParams
    //   2670: dup
    //   2671: bipush 254
    //   2673: bipush 254
    //   2675: invokespecial 298	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2678: astore 10
    //   2680: aload 10
    //   2682: bipush 11
    //   2684: invokevirtual 1513	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2687: aload 10
    //   2689: bipush 10
    //   2691: invokevirtual 1513	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2694: aload 5
    //   2696: aload 10
    //   2698: invokevirtual 1621	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2701: aload_2
    //   2702: aload 5
    //   2704: invokevirtual 506	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   2707: aload_3
    //   2708: instanceof 305
    //   2711: ifeq +11 -> 2722
    //   2714: aload_3
    //   2715: checkcast 305	android/widget/RelativeLayout
    //   2718: aload_2
    //   2719: invokevirtual 506	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   2722: aload 13
    //   2724: getfield 387	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   2727: astore 10
    //   2729: aload 14
    //   2731: getfield 1517	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   2734: lstore 7
    //   2736: aload 13
    //   2738: ldc_w 1264
    //   2741: invokevirtual 1376	com/tencent/mobileqq/data/MessageForStructing:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   2744: astore 10
    //   2746: aload 13
    //   2748: getfield 1299	com/tencent/mobileqq/data/MessageForStructing:istroop	I
    //   2751: istore 6
    //   2753: aload_0
    //   2754: getfield 330	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:mContext	Landroid/content/Context;
    //   2757: instanceof 205
    //   2760: ifeq -1019 -> 1741
    //   2763: aload_2
    //   2764: new 1623	xog
    //   2767: dup
    //   2768: aload_0
    //   2769: aload 5
    //   2771: aload_1
    //   2772: aload 10
    //   2774: invokespecial 1626	xog:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Landroid/widget/TextView;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;)V
    //   2777: invokevirtual 1523	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2780: goto -1039 -> 1741
    //   2783: aload_2
    //   2784: aload_1
    //   2785: putfield 1629	com/tencent/mobileqq/doutu/DuiButtonImageView:q	Lcom/tencent/mobileqq/data/ChatMessage;
    //   2788: goto -886 -> 1902
    //   2791: iconst_0
    //   2792: istore 6
    //   2794: goto -858 -> 1936
    //   2797: aload_1
    //   2798: getfield 1632	com/tencent/mobileqq/data/ChatMessage:hasPlayedDui	Z
    //   2801: ifne +30 -> 2831
    //   2804: aload_1
    //   2805: aload_2
    //   2806: invokestatic 1635	com/tencent/mobileqq/doutu/DuiButtonImageView:a	(Lcom/tencent/mobileqq/doutu/DuiButtonImageView;)Z
    //   2809: putfield 1632	com/tencent/mobileqq/data/ChatMessage:hasPlayedDui	Z
    //   2812: getstatic 1638	com/tencent/mobileqq/doutu/DuiButtonImageView:bXG	Z
    //   2815: ifeq +23 -> 2838
    //   2818: aload_2
    //   2819: aload_0
    //   2820: invokevirtual 1639	com/tencent/mobileqq/doutu/DuiButtonImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2823: aload_2
    //   2824: iconst_0
    //   2825: invokevirtual 1558	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   2828: goto -867 -> 1961
    //   2831: aload_2
    //   2832: invokevirtual 1642	com/tencent/mobileqq/doutu/DuiButtonImageView:ms	()V
    //   2835: goto -23 -> 2812
    //   2838: aload_2
    //   2839: aconst_null
    //   2840: invokevirtual 1639	com/tencent/mobileqq/doutu/DuiButtonImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2843: aload_2
    //   2844: bipush 8
    //   2846: invokevirtual 1558	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   2849: goto -888 -> 1961
    //   2852: aload_2
    //   2853: bipush 8
    //   2855: invokevirtual 1558	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   2858: aload_2
    //   2859: invokevirtual 1645	com/tencent/mobileqq/doutu/DuiButtonImageView:stopAnim	()V
    //   2862: goto -901 -> 1961
    //   2865: astore_2
    //   2866: goto -1992 -> 874
    //   2869: goto -1847 -> 1022
    //   2872: aload_2
    //   2873: astore 9
    //   2875: goto -2119 -> 756
    //   2878: aconst_null
    //   2879: astore_2
    //   2880: goto -2134 -> 746
    //   2883: aconst_null
    //   2884: astore 10
    //   2886: goto -2839 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2889	0	this	StructingMsgItemBuilder
    //   0	2889	1	paramChatMessage	ChatMessage
    //   0	2889	2	parame	BaseBubbleBuilder.e
    //   0	2889	3	paramView	View
    //   0	2889	4	paramBaseChatItemLayout	BaseChatItemLayout
    //   0	2889	5	paramwlz	wlz
    //   140	2653	6	i	int
    //   1710	1025	7	l	long
    //   58	2816	9	localObject1	Object
    //   45	2840	10	localObject2	Object
    //   130	2330	11	localObject3	Object
    //   538	497	12	localObject4	Object
    //   2066	7	12	localThrowable	java.lang.Throwable
    //   2082	296	12	localObject5	Object
    //   216	2531	13	localMessageForStructing	MessageForStructing
    //   223	2507	14	localAbsStructMsg	AbsStructMsg
    //   7	2279	15	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   2041	2050	2053	java/lang/Exception
    //   923	1019	2066	java/lang/Throwable
    //   1277	1283	2430	java/lang/IllegalStateException
    //   855	874	2865	java/lang/Exception
  }
  
  public aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    parama = (MessageForStructing)paramChatMessage;
    paramChatMessage = parama.structingMsg;
    if (paramChatMessage != null) {
      if ((!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).mMsgException)) {}
    }
    label369:
    label375:
    label379:
    for (;;)
    {
      return paramaqoa;
      if ((paramChatMessage.mMsgServiceID != 86) && (paramChatMessage.mMsgServiceID != 61) && (paramChatMessage.mMsgServiceID != 91) && (paramChatMessage.mMsgServiceID != 97) && (paramChatMessage.mMsgServiceID != 98) && (!(paramChatMessage instanceof StructMsgForHypertext)) && ((!parama.isSendFromLocal()) || (!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).isSdkShareMsg()) || ((parama.extraflag != 32772) && (parama.extraflag != 32768))))
      {
        parama = this.mContext.getResources();
        int i;
        if (paramChatMessage.fwFlag != 1) {
          if (this.sessionInfo.cZ == 1008) {
            if (!paramChatMessage.hasFlag(32))
            {
              paramaqoa.Z(2131367544, parama.getString(2131721067), 2130839086);
              if ((paramChatMessage.hasFlag(2)) || ((this.sessionInfo.cZ == 1008) && (TextUtils.isEmpty(paramChatMessage.mMsgUrl))) || (paramChatMessage.mMsgServiceID == 81)) {
                break label375;
              }
              if (paramChatMessage.mMsgServiceID != 14) {
                break label369;
              }
              i = 0;
            }
          }
        }
        for (;;)
        {
          if ((i == 0) && (!a(paramChatMessage, paramaqoa))) {
            break label379;
          }
          paramaqoa.Z(2131366733, this.mContext.getResources().getString(2131693407), 2130839085);
          return paramaqoa;
          if (paramChatMessage.hasFlag(1)) {
            break;
          }
          paramaqoa.Z(2131367523, parama.getString(2131721067), 2130839086);
          break;
          if (paramChatMessage.mMsgServiceID == 14) {
            break;
          }
          if (!paramChatMessage.hasFlag(1))
          {
            paramaqoa.Z(2131367523, parama.getString(2131721067), 2130839086);
            break;
          }
          if (paramChatMessage.mMsgServiceID != 35) {
            break;
          }
          paramaqoa.Z(2131367523, parama.getString(2131721067), 2130839086);
          break;
          i = 1;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    try
    {
      ChatMessage localChatMessage = wja.a(paramView);
      if (!(localChatMessage instanceof MessageForStructing)) {
        return null;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("StructingMsgItemBuilder", 1, paramView.getClass().getName(), localException);
          localObject = null;
        }
        localObject = (MessageForStructing)localObject;
        if ((((MessageForStructing)localObject).structingMsg != null) && ((((MessageForStructing)localObject).structingMsg.mMsgServiceID == 5) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 137))) {
          return (BaseBubbleBuilder.d)paramView.findViewById(2131369034);
        }
      } while ((((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 107));
      Object localObject = paramView.findViewById(2131376827);
      if (localObject != null) {
        return (BaseBubbleBuilder.d)((View)localObject).getTag(-1);
      }
      paramView = "getTouchDelegate when receipt message but the root view is null \r\n" + paramView;
      annt.e(new IllegalStateException(paramView), "StructingMsgItemBuilderCatchedException" + paramView);
    }
    return null;
  }
  
  protected a a()
  {
    return new a();
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject6 = xtj.f(paramChatMessage);
    Object localObject1;
    if (paramInt == 2131362240) {
      if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
      {
        paramContext = (MessageForStructing)paramChatMessage;
        if ((paramContext.structingMsg == null) || (!(paramContext.structingMsg instanceof StructMsgForImageShare))) {
          break label131;
        }
        paramContext = (StructMsgForImageShare)paramContext.structingMsg;
        paramChatMessage = paramContext.getFirstImageElement();
        if (paramChatMessage == null) {
          break label131;
        }
        paramChatMessage = paramChatMessage.j;
        localObject1 = aoop.a(paramChatMessage, 1);
        if (localObject1 != null) {
          break label81;
        }
      }
    }
    label81:
    Object localObject2;
    label131:
    label488:
    int i;
    label980:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localObject1 = URLDrawable.getDrawable((URL)localObject1, -1, -1, null, null, false);
                  ((URLDrawable)localObject1).setTag(paramChatMessage);
                  xtm.a(this.mContext, this.app, (URLDrawable)localObject1, paramChatMessage.frienduin, this.mContext.getResources().getDimensionPixelSize(2131299627), paramContext, null);
                } while (!xtj.hQ((String)localObject6));
                avdb.a(this.app, "3009", "2", "40053", xtj.hB((String)localObject6), new String[] { "1", "", xtj.hA((String)localObject6) });
                return;
                if (paramInt != 2131367523) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("forward", 2, "structingMsgItem forward");
                }
              } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
              paramChatMessage = (MessageForStructing)paramChatMessage;
            } while (paramChatMessage.structingMsg == null);
            if (!(paramChatMessage.structingMsg instanceof StructMsgForImageShare)) {
              break;
            }
          } while (!((StructMsgForImageShare)paramChatMessage.structingMsg).checkImageSharePic(this.app.getApp()));
          localObject1 = new Bundle();
          if ((paramChatMessage.structingMsg.source_puin != null) && (!"".equals(paramChatMessage.structingMsg.source_puin))) {
            ((Bundle)localObject1).putString("source_puin", paramChatMessage.structingMsg.source_puin);
          }
          ((Bundle)localObject1).putInt("forward_type", -3);
          paramChatMessage.structingMsg.mCommentText = null;
          ((Bundle)localObject1).putInt("structmsg_service_id", paramChatMessage.structingMsg.mMsgServiceID);
          ((Bundle)localObject1).putByteArray("stuctmsg_bytes", paramChatMessage.structingMsg.getBytes());
          ((Bundle)localObject1).putLong("structmsg_uniseq", paramChatMessage.uniseq);
          ((Bundle)localObject1).putInt("accostType", paramChatMessage.structingMsg.sourceAccoutType);
          ((Bundle)localObject1).putInt("selection_mode", this.bOY);
          paramContext = new Intent();
          paramContext.putExtras((Bundle)localObject1);
          if (!(paramChatMessage.structingMsg instanceof StructMsgForImageShare)) {
            break label980;
          }
          localObject1 = (StructMsgForImageShare)paramChatMessage.structingMsg;
          localObject2 = ((StructMsgForImageShare)localObject1).getFirstImageElement();
          if ((localObject2 != null) && (((ansu)localObject2).useCustomSize()))
          {
            paramContext.putExtra("key_forward_image_share", true);
            paramContext.putExtra("key_forward_image_share_appid", Long.toString(((StructMsgForImageShare)localObject1).mSourceAppid));
            paramContext.putExtra("key_forward_image_share_uin_type", ((StructMsgForImageShare)localObject1).uinType);
          }
          ahgq.f((Activity)this.mContext, paramContext, 21);
          paramContext = paramChatMessage.structingMsg.mMsgUrl;
          localObject1 = paramChatMessage.senderuin;
          localObject2 = Long.toString(paramChatMessage.structingMsg.msgId);
          anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject1, paramContext, (String)localObject2, "");
          anot.a(this.app, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramChatMessage.structingMsg.mMsgServiceID == 84) {
            anot.a(this.app, "CliOper", "", "", "0X8007166", "0X8007166", 0, 0, "", "", "", "");
          }
          if (xtj.hQ((String)localObject6)) {
            avdb.a(this.app, "3009", "2", "40053", xtj.hB((String)localObject6), new String[] { "2", "", xtj.hA((String)localObject6) });
          }
        } while (!paramChatMessage.isMultiMsg);
        i = 10;
        paramContext = paramChatMessage.structingMsg;
        paramInt = i;
        if (paramContext != null) {
          switch (paramContext.mMsgServiceID)
          {
          default: 
            paramInt = i;
          }
        }
        for (;;)
        {
          anot.a(this.app, "dc00898", "", "", "0X8009D66", "0X8009D66", paramInt, 0, "" + paramInt, "", "", "");
          return;
          if ((paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 35))
          {
            anot.b(this.app, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
            if (!ajlc.a().g(this.app, paramChatMessage.uniseq))
            {
              paramInt = paramContext.getResources().getDimensionPixelSize(2131299627);
              QQToast.a(paramContext, acfp.m(2131715005), 0).show(paramInt);
              return;
            }
            if (!ajlc.a().h(this.app, paramChatMessage.uniseq)) {
              break;
            }
            aqha.a(paramContext, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", acfp.m(2131714997), acfp.m(2131715007), new xoc(this, paramChatMessage), new xok(this)).show();
            return;
          }
          if ((paramChatMessage.structingMsg == null) || (paramChatMessage.structingMsg.mMsgServiceID != 81)) {
            break;
          }
          rar.a(this.app, this.mContext, paramChatMessage, "forward");
          break;
          if ((!(paramChatMessage.structingMsg instanceof StructMsgForAudioShare)) && (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare))) {
            break label488;
          }
          paramContext.putExtra("key_forward_share", true);
          paramContext.putExtra("key_forward_share_title", ((AbsShareMsg)paramChatMessage.structingMsg).mContentTitle);
          paramContext.putExtra("key_forward_image_share_uin_type", paramChatMessage.structingMsg.uinType);
          break label488;
          paramInt = 2;
          continue;
          paramInt = 7;
        }
        if (paramInt != 2131365686) {
          break;
        }
        ujt.b(this.mContext, this.app, paramChatMessage);
        if (xtj.hQ((String)localObject6)) {
          avdb.a(this.app, "3009", "2", "40053", xtj.hB((String)localObject6), new String[] { "5", "", xtj.hA((String)localObject6) });
        }
      } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
      paramContext = (MessageForStructing)paramChatMessage;
    } while ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81));
    rar.a(this.app, this.mContext, paramContext, "delete");
    return;
    long l2;
    long l1;
    if (paramInt == 2131372073)
    {
      super.m(paramChatMessage);
      if (xtj.hQ((String)localObject6)) {
        avdb.a(this.app, "3009", "2", "40053", xtj.hB((String)localObject6), new String[] { "6", "", xtj.hA((String)localObject6) });
      }
      if (this.sessionInfo.cZ == 1008)
      {
        paramContext = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        l2 = 0L;
        l1 = l2;
        if (paramChatMessage == null) {
          break label4337;
        }
        l1 = l2;
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break label4337;
        }
        localObject1 = (MessageForStructing)paramChatMessage;
        l1 = l2;
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label4337;
        }
        l1 = l2;
        if (!(((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)) {
          break label4337;
        }
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        l2 = ((AbsShareMsg)localObject1).msgId;
        l1 = l2;
        if (!(localObject1 instanceof StructMsgForGeneralShare)) {
          break label4337;
        }
        localObject1 = (StructMsgForGeneralShare)localObject1;
        paramInt = StructMsgForGeneralShare.clickedItemIndex;
      }
    }
    for (;;)
    {
      anot.a(this.app, "dc00899", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X80064F7", "0X80064F7", 0, 0, paramContext, String.valueOf(l2), String.valueOf(paramInt), "");
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
        break;
      }
      paramContext = (MessageForStructing)paramChatMessage;
      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
        break;
      }
      rar.a(this.app, this.mContext, paramContext, "more");
      return;
      MessageForStructing localMessageForStructing;
      AbsShareMsg localAbsShareMsg;
      if (paramInt == 2131366733)
      {
        if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
          break;
        }
        localMessageForStructing = (MessageForStructing)paramChatMessage;
        if (localMessageForStructing.structingMsg == null) {
          break;
        }
        localAbsShareMsg = (AbsShareMsg)localMessageForStructing.structingMsg;
        if ((localAbsShareMsg instanceof StructMsgForImageShare))
        {
          i = 0;
          if (xtj.hQ((String)localObject6))
          {
            localObject1 = localAbsShareMsg.mMsgActionData.substring(localAbsShareMsg.mMsgActionData.indexOf("|") + 1).split("\\|");
            paramInt = i;
            if (localObject1.length < 8) {
              break label4332;
            }
            if (!localObject1[7].equals("link"))
            {
              paramInt = i;
              if (!localObject1[7].equals("scrawl_link")) {
                break label4332;
              }
            }
            i = 1;
            paramInt = i;
            if (!localObject1[7].equals("scrawl_link")) {
              break label4332;
            }
            paramInt = i;
            if (localObject1.length <= 8) {
              break label4332;
            }
            paramContext = localObject1[8];
            paramInt = 1;
          }
        }
      }
      for (;;)
      {
        if ((paramInt == 0) && (!TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData)))
        {
          localObject1 = localAbsShareMsg.mMsg_A_ActionData.split("\\|");
          if ((localObject1.length >= 8) && (localObject1[7].equals("link"))) {
            paramInt = 1;
          }
        }
        label1684:
        label2359:
        label4301:
        label4307:
        label4315:
        for (;;)
        {
          Object localObject5;
          Object localObject4;
          if (paramInt != 0)
          {
            localObject2 = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
            if (localObject2 == null) {
              break label4323;
            }
            if (((ansu)localObject2).d == null) {
              ((ansu)localObject2).d = ((StructMsgForImageShare)localAbsShareMsg);
            }
            localObject5 = xtm.a(((ansu)localObject2).a());
            localObject4 = ((AIOImageData)localObject5).c(4);
            localObject2 = localObject4;
            if (localObject4 == null) {
              localObject2 = ((AIOImageData)localObject5).c(2);
            }
            if (localObject2 == null) {
              break label4323;
            }
          }
          label2169:
          Object localObject3;
          label3938:
          label4323:
          for (localObject2 = ((File)localObject2).getAbsolutePath();; localObject3 = null)
          {
            Object localObject7 = localObject1[3] + acfp.m(2131714996) + localObject1[5] + acfp.m(2131715002);
            localObject5 = "ADTAG=comic.plugin.read&id=" + localObject1[0] + "&name=" + URLEncoder.encode(localObject1[1]) + "&sectionID=" + localObject1[2] + "&sectionName=" + URLEncoder.encode(localObject1[3]) + "&pageID=" + localObject1[4] + "&page=" + localObject1[5] + "&type=" + localObject1[6];
            localObject4 = localObject5;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject4 = (String)localObject5 + "&scrawl_link=" + URLEncoder.encode(paramContext);
            }
            paramContext = VipComicJumpActivity.c("comicReadShare", "5123", null, null, "354", null, (String)localObject4);
            new aviz(6).a("nLinkType", 0).b("sTitle", localObject1[1]).b("sUrl", paramContext).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localAbsShareMsg.mSourceName).b("sBrief", (String)localObject7).b("sPath", (String)localObject2).b("sResUrl", localAbsShareMsg.mSourceUrl).a("lCategory", 1L).b((Activity)this.mContext, this.app.getAccount());
            avjg.a(this.app, 6, 2);
            avjg.a(this.app, 8, 0, localAbsShareMsg.uinType);
            avdb.a(this.app, "3009", "2", "40053", xtj.hB((String)localObject6), new String[] { "3", "", xtj.hA((String)localObject6) });
            int j = 0;
            i = paramInt;
            paramInt = j;
            for (;;)
            {
              if ((i == 0) && (paramInt == 0))
              {
                i = 0;
                paramInt = i;
                if ((localAbsShareMsg instanceof StructMsgForImageShare))
                {
                  paramInt = i;
                  if (!localMessageForStructing.isSendFromLocal())
                  {
                    paramContext = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
                    paramInt = localAbsShareMsg.uinType;
                    if ((paramContext != null) && (paramContext.j != null))
                    {
                      this.app.a().a(paramContext.j, 2);
                      ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilder.3(this, paramContext, paramInt, paramChatMessage));
                    }
                    paramInt = 1;
                  }
                }
                if (paramInt == 0)
                {
                  paramContext = avjj.a((StructMsgForImageShare)localAbsShareMsg);
                  if (paramContext != null)
                  {
                    aviz.a(paramContext.mMd5, localAbsShareMsg.uinType, paramContext.mUuid, paramContext.anV, paramContext.cij, paramContext.filesize).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
                    avjg.a(this.app, 2, 0, localAbsShareMsg.uinType);
                    avjg.a(this.app, 6, 3);
                  }
                }
              }
              while (localMessageForStructing.isMultiMsg)
              {
                i = 10;
                paramContext = localMessageForStructing.structingMsg;
                paramInt = i;
                if (paramContext != null) {}
                switch (paramContext.mMsgServiceID)
                {
                default: 
                  paramInt = i;
                  label2419:
                  anot.a(this.app, "dc00898", "", "", "0X8009D67", "0X8009D67", paramInt, 0, "" + paramInt, "", "", "");
                  return;
                  paramInt = 0;
                  break label1684;
                  if (!xtj.hR((String)localObject6)) {
                    break label4315;
                  }
                  paramContext = xtj.j((String)localObject6);
                  if ((paramContext == null) || (paramContext.length <= 2)) {
                    break label4315;
                  }
                  localObject2 = paramContext[1];
                  paramContext = paramContext[2];
                  paramContext = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
                  if (paramContext != null)
                  {
                    if (paramContext.d == null) {
                      paramContext.d = ((StructMsgForImageShare)localAbsShareMsg);
                    }
                    localObject4 = xtm.a(paramContext.a());
                    localObject1 = ((AIOImageData)localObject4).c(4);
                    paramContext = (Context)localObject1;
                    if (localObject1 == null) {
                      paramContext = ((AIOImageData)localObject4).c(2);
                    }
                    if (paramContext != null) {
                      paramContext.getAbsolutePath();
                    }
                  }
                  paramContext = this.app.getAccount();
                  aviz.a((String)localObject2).c(paramContext).b((Activity)this.mContext, paramContext);
                  avjg.a(this.app, 7, 0, localAbsShareMsg.uinType);
                  avjg.a(this.app, 6, 2);
                  paramInt = 1;
                  i = 0;
                  break label2169;
                  if ((!(localAbsShareMsg instanceof StructMsgForGeneralShare)) || (localAbsShareMsg.mMsgServiceID != 35)) {
                    break label2696;
                  }
                  paramContext = ((FragmentActivity)this.mContext).getChatFragment();
                  if (paramContext != null)
                  {
                    paramContext = paramContext.a();
                    ((wvy)paramContext.a(11)).a(paramContext, null, (MessageForStructing)paramChatMessage);
                  }
                  break;
                }
              }
              if (!TextUtils.isEmpty(localAbsShareMsg.mMsgActionData))
              {
                String[] arrayOfString1 = localAbsShareMsg.mMsgActionData.split("&");
                i = arrayOfString1.length;
                localObject4 = null;
                localObject2 = null;
                localObject1 = null;
                paramContext = null;
                paramInt = 0;
                if (paramInt < i)
                {
                  String[] arrayOfString2 = arrayOfString1[paramInt].split("=");
                  localObject5 = localObject4;
                  localObject6 = localObject2;
                  localObject7 = localObject1;
                  Object localObject8 = paramContext;
                  if (arrayOfString2.length > 1)
                  {
                    if (!arrayOfString2[0].trim().equals("lat")) {
                      break label2834;
                    }
                    localObject8 = arrayOfString2[1];
                    localObject7 = localObject1;
                    localObject6 = localObject2;
                    localObject5 = localObject4;
                  }
                  for (;;)
                  {
                    paramInt += 1;
                    localObject4 = localObject5;
                    localObject2 = localObject6;
                    localObject1 = localObject7;
                    paramContext = (Context)localObject8;
                    break;
                    if (arrayOfString2[0].trim().equals("lon"))
                    {
                      localObject7 = arrayOfString2[1];
                      localObject5 = localObject4;
                      localObject6 = localObject2;
                      localObject8 = paramContext;
                    }
                    else if (arrayOfString2[0].trim().equals("loc"))
                    {
                      localObject6 = arrayOfString2[1];
                      localObject5 = localObject4;
                      localObject7 = localObject1;
                      localObject8 = paramContext;
                    }
                    else
                    {
                      localObject5 = localObject4;
                      localObject6 = localObject2;
                      localObject7 = localObject1;
                      localObject8 = paramContext;
                      if (arrayOfString2[0].trim().equals("title"))
                      {
                        localObject5 = arrayOfString2[1];
                        localObject6 = localObject2;
                        localObject7 = localObject1;
                        localObject8 = paramContext;
                      }
                    }
                  }
                }
                if ((localAbsShareMsg.mMsgServiceID == 32) && (!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
                {
                  aviz.a(Float.valueOf(paramContext).floatValue(), Float.valueOf((String)localObject1).floatValue(), (String)localObject4, (String)localObject2, null).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
                  avjg.a(this.app, 11, 0, localAbsShareMsg.uinType);
                  avjg.a(this.app, 6, 7);
                  return;
                }
              }
              localObject4 = avjj.P(localAbsShareMsg.getXmlBytes());
              paramContext = localAbsShareMsg.mContentCover;
              if ((localAbsShareMsg instanceof StructMsgForAudioShare))
              {
                paramInt = 2;
                i = 10;
              }
              for (;;)
              {
                if ((localAbsShareMsg.mMsgServiceID == 14) || (localAbsShareMsg.mMsgServiceID == 84))
                {
                  paramContext = new ArrayList();
                  localObject1 = new JSONObject();
                }
                for (;;)
                {
                  try
                  {
                    ((JSONObject)localObject1).put("bFriendCard", true);
                    ((JSONObject)localObject1).put("jumpUrl", localAbsShareMsg.mContentCover);
                    localObject1 = ((JSONObject)localObject1).toString().getBytes();
                    if (localObject1 != null) {
                      paramContext.add(localObject1);
                    }
                    paramContext.add(localAbsShareMsg.getXml().getBytes());
                    aviz.a(null, false, localAbsShareMsg.mContentTitle, localAbsShareMsg.mContentSummary, false, 0L, "").b("sBizDataList", paramContext).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
                    avjg.a(this.app, 10, 0, localAbsShareMsg.uinType);
                    avjg.a(this.app, 6, i);
                    break label2359;
                    if ((!(localAbsShareMsg instanceof StructMsgForGeneralShare)) || (!((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg)) {
                      break label4307;
                    }
                    localObject2 = (StructMsgForGeneralShare)localAbsShareMsg;
                    paramInt = 0;
                    if (paramInt >= ((StructMsgForGeneralShare)localObject2).getItemCount()) {
                      break label4307;
                    }
                    localObject1 = ((StructMsgForGeneralShare)localObject2).getItemByIndex(paramInt);
                    if ((localObject1 instanceof antz))
                    {
                      localObject5 = ((antz)localObject1).rz.iterator();
                      localObject1 = paramContext;
                      if (!((Iterator)localObject5).hasNext()) {
                        break label4301;
                      }
                      localObject1 = (anqu)((Iterator)localObject5).next();
                      if (!(localObject1 instanceof anvf)) {
                        continue;
                      }
                      localObject5 = (anvf)localObject1;
                      paramContext = ((anvf)localObject5).imgUrl;
                      localObject1 = paramContext;
                      if (!((anvf)localObject5).aza()) {
                        break label4301;
                      }
                      kct.b("0X8006601", ((StructMsgForGeneralShare)localAbsShareMsg).uinType, kct.l(((anvf)localObject5).type, ((StructMsgForGeneralShare)localObject2).mSourceName), ((anvf)localObject5).ciu, "");
                      i = 2;
                      paramInt = 0;
                      break label3096;
                    }
                    paramInt += 1;
                    continue;
                  }
                  catch (JSONException localJSONException)
                  {
                    localJSONException.printStackTrace();
                    continue;
                  }
                  if (localAbsShareMsg.uinType == 1008)
                  {
                    localObject3 = aqgv.b(this.app, this.app.getAccount(), true);
                    localObject1 = localObject3;
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      localObject1 = localAbsShareMsg.mContentSrc;
                    }
                    aviz.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, paramContext, (String)localObject1, (byte[])localObject4, false, 0L).b(this.app, paramChatMessage).a("lCategory", 10L).b("sUin", localAbsShareMsg.mSourceName).b((Activity)this.mContext, this.app.getAccount());
                    avjg.a(this.app, 8, 0, localAbsShareMsg.uinType);
                  }
                  else
                  {
                    localObject6 = new ArrayList();
                    localObject5 = localAbsShareMsg.mContentSummary;
                    if (a(localAbsShareMsg))
                    {
                      ((ArrayList)localObject6).add(avja.b(true));
                      j = paramInt;
                      localObject1 = localObject5;
                      localObject3 = localObject4;
                      if (!TextUtils.isEmpty(localAbsShareMsg.mMsgUrl))
                      {
                        j = paramInt;
                        localObject1 = localObject5;
                        localObject3 = localObject4;
                        if (localAbsShareMsg.mMsgUrl.indexOf("action=accountCard") > -1)
                        {
                          ((ArrayList)localObject6).add(localAbsShareMsg.getXml().getBytes());
                          j = 7;
                          localObject3 = localObject4;
                          localObject1 = localObject5;
                        }
                      }
                      label3706:
                      if ((j != 6) && (j != 7)) {
                        break label3938;
                      }
                      avjg.a(this.app, 10, 0, localAbsShareMsg.uinType);
                    }
                    for (;;)
                    {
                      aviz.a(j, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, (String)localObject1, paramContext, localAbsShareMsg.mContentSrc, (byte[])localObject3, false, 0L).b("sBizDataList", (ArrayList)localObject6).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
                      break;
                      j = paramInt;
                      localObject1 = localObject5;
                      localObject3 = localObject4;
                      if (TextUtils.isEmpty(localAbsShareMsg.mMsgUrl)) {
                        break label3706;
                      }
                      j = paramInt;
                      localObject1 = localObject5;
                      localObject3 = localObject4;
                      if (localAbsShareMsg.mMsgUrl.indexOf("jq.qq.com") <= -1) {
                        break label3706;
                      }
                      ((ArrayList)localObject6).add(localAbsShareMsg.getXml().getBytes());
                      paramInt = 6;
                      localObject7 = hz(localAbsShareMsg.mContentCover);
                      j = paramInt;
                      localObject1 = localObject5;
                      localObject3 = localObject4;
                      if (TextUtils.isEmpty((CharSequence)localObject7)) {
                        break label3706;
                      }
                      localObject1 = this.mContext.getString(2131700244) + (String)localObject7;
                      localObject3 = null;
                      j = paramInt;
                      break label3706;
                      if (aobw.pN(localAbsShareMsg.mMsgUrl)) {
                        avjg.a(this.app, 12, 0, localAbsShareMsg.uinType);
                      } else {
                        avjg.a(this.app, 8, 0, localAbsShareMsg.uinType);
                      }
                    }
                    paramInt = 2;
                    break label2419;
                    paramInt = 7;
                    break label2419;
                    if (paramInt == 2131365509)
                    {
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
                        break;
                      }
                      ((ClipboardManager)this.mContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
                      return;
                    }
                    if (paramInt == 2131372062)
                    {
                      m(paramChatMessage);
                      return;
                    }
                    if (paramInt == 2131367544)
                    {
                      ThreadManager.post(new StructingMsgItemBuilder.4(this, paramChatMessage, paramContext), 8, null, false);
                      return;
                    }
                    if (paramInt == 2131372030)
                    {
                      super.j(paramChatMessage);
                      if (xtj.hQ((String)localObject6)) {
                        avdb.a(this.app, "3009", "2", "40053", xtj.hB((String)localObject6), new String[] { "4", "", xtj.hA((String)localObject6) });
                      }
                      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
                        break;
                      }
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
                        break;
                      }
                      rar.a(this.app, this.mContext, paramContext, "withdraw");
                      return;
                    }
                    if (paramInt == 2131364237)
                    {
                      paramContext = this.app.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
                      if ((paramContext == null) || (!(paramContext instanceof aojn))) {
                        break;
                      }
                      ((aojn)paramContext).cancel();
                      return;
                    }
                    if (paramInt == 2131377998)
                    {
                      ((augo)this.app.getManager(374)).B(paramChatMessage);
                      return;
                    }
                    super.a(paramInt, paramContext, paramChatMessage);
                    return;
                    paramContext = (Context)localObject1;
                  }
                }
                i = 2;
                paramInt = 0;
              }
              paramInt = 0;
              i = 0;
            }
          }
        }
        label2696:
        label2834:
        label3096:
        label4332:
        paramContext = null;
      }
      label4337:
      paramInt = 0;
      l2 = l1;
    }
  }
  
  public void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    Object localObject = AIOLongShotHelper.a();
    if ((localObject != null) && (((AIOLongShotHelper)localObject).RS())) {
      super.a(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
    }
    do
    {
      do
      {
        return;
        if ((!BaseChatItemLayout.bdx) || (!(paramChatMessage instanceof MessageForStructing))) {
          break label160;
        }
        localObject = ((MessageForStructing)paramChatMessage).structingMsg;
        if ((!paramChatMessage.isSendFromLocal()) || (!(localObject instanceof AbsShareMsg)) || (!((AbsShareMsg)localObject).isSdkShareMsg()) || ((paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768))) {
          break;
        }
      } while ((paramBaseChatItemLayout.mCheckBox == null) || (paramBaseChatItemLayout.mCheckBox.getVisibility() != 0));
      paramBaseChatItemLayout.mCheckBox.setVisibility(8);
      return;
      if (((AbsStructMsg)localObject).mMsgServiceID != 14) {
        break;
      }
    } while ((paramBaseChatItemLayout.mCheckBox == null) || (paramBaseChatItemLayout.mCheckBox.getVisibility() != 0));
    paramBaseChatItemLayout.mCheckBox.setVisibility(8);
    return;
    label160:
    super.a(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    do
    {
      return;
      if ((paramaoko.fileType == 1) || (paramaoko.fileType == 131075))
      {
        b(paramView, paramaoko, paramInt1, paramInt2);
        return;
      }
    } while (paramaoko.fileType != 52);
    c(paramView, paramaoko, paramInt1, paramInt2);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    MessageForStructing localMessageForStructing;
    int i;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      boolean bool = obo.a(localMessageForStructing.structingMsg);
      if (((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) || (localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 151) || (localMessageForStructing.structingMsg.mMsgServiceID == 156))
      {
        if ((!bool) || (localMessageForStructing.structingMsg.hasFlag(4))) {
          break label201;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131296407);
        if (!paramChatMessage.isSend()) {
          break label261;
        }
        paramView.setPadding(BaseChatItemLayout.bNY, BaseChatItemLayout.bNV, i, BaseChatItemLayout.bNW);
      }
    }
    for (;;)
    {
      if (localMessageForStructing.structingMsg.mMsgServiceID == 107)
      {
        paramChatMessage = this.mContext.getResources();
        paramView.setPadding(wja.dp2px(1.5F, paramChatMessage), wja.dp2px(2.0F, paramChatMessage), wja.dp2px(1.5F, paramChatMessage), paramView.getPaddingBottom());
      }
      return;
      label201:
      if ((localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116))
      {
        i = this.mContext.getResources().getDimensionPixelSize(2131296408);
        break;
      }
      i = this.mContext.getResources().getDimensionPixelSize(2131296412);
      break;
      label261:
      paramView.setPadding(i, BaseChatItemLayout.bNV, BaseChatItemLayout.bNY, BaseChatItemLayout.bNW);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructingMsgItemBuilder", 2, "updateView type=" + paramInt + ",message=" + paramChatMessage);
    }
    if (paramInt == 891)
    {
      Object localObject = paramView.getTag();
      if (((localObject instanceof a)) && ((paramChatMessage instanceof MessageForStructing)))
      {
        localObject = (a)localObject;
        BaseChatItemLayout localBaseChatItemLayout = ((a)localObject).a;
        paramChatMessage = (MessageForStructing)paramChatMessage;
        AbsStructMsg localAbsStructMsg = paramChatMessage.structingMsg;
        if (localAbsStructMsg != null) {
          localAbsStructMsg.message = paramChatMessage;
        }
        a((a)localObject, localBaseChatItemLayout, paramChatMessage.isSend(), localAbsStructMsg, paramView.getResources(), c(paramChatMessage));
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    if ((!(paramChatMessage instanceof MessageForStructing)) || (((MessageForStructing)paramChatMessage).structingMsg == null)) {}
    do
    {
      return;
      paramBaseChatItemLayout = (MessageForStructing)paramChatMessage;
      paramInt1 = paramBaseChatItemLayout.structingMsg.mMsgServiceID;
    } while ((c(paramBaseChatItemLayout)) || (paramInt1 == 83) || (paramInt1 == 151) || (paramInt1 == 156) || (paramInt1 == 108) || (paramInt1 == 114) || (paramInt1 == 98) || (paramInt1 == 97) || (paramInt1 == 5) || (paramInt1 == 137) || (paramInt1 == 106) || (paramInt1 == 107) || (paramInt1 == 122) || (paramInt1 == 116));
    paramInt2 = parame.E.getPaddingLeft();
    int i = parame.E.getPaddingRight();
    int m = parame.E.getPaddingTop();
    int n = parame.E.getPaddingBottom();
    int j = wja.dp2px(2.0F, this.mContext.getResources());
    boolean bool = ThemeUtil.isInNightMode(this.app);
    int k;
    if (paramChatMessage.isSend())
    {
      paramInt1 = paramInt2;
      if (paramInt2 > j) {
        paramInt1 = paramInt2 - j;
      }
      parame.E.setBackgroundResource(2130851006);
      j = paramInt1;
      k = i;
      if (bool)
      {
        j = paramInt1;
        k = i;
        if (parame.E.getParent() != null)
        {
          j = paramInt1;
          k = i;
          if ((parame.E.getParent() instanceof RelativeLayout))
          {
            paramBaseChatItemLayout = (RelativeLayout)parame.E.getParent();
            paramContext = new View(paramContext);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(6, 2131364503);
            localLayoutParams.addRule(5, 2131364503);
            localLayoutParams.addRule(7, 2131364503);
            localLayoutParams.addRule(8, 2131364503);
            if (parame.mask != null) {
              paramBaseChatItemLayout.removeView(parame.mask);
            }
            if (!ajlg.P(paramChatMessage)) {
              break label444;
            }
            paramContext.setBackgroundResource(2130851003);
            parame.mask = paramContext;
            paramBaseChatItemLayout.addView(parame.mask, localLayoutParams);
            k = i;
            j = paramInt1;
          }
        }
      }
    }
    label444:
    do
    {
      do
      {
        do
        {
          parame.E.setPadding(j, m, k, n);
          return;
          paramContext.setBackgroundResource(2130851002);
          break;
          paramInt1 = i;
          if (i > j) {
            paramInt1 = i - j;
          }
          parame.E.setBackgroundResource(2130850829);
          j = paramInt2;
          k = paramInt1;
        } while (!bool);
        j = paramInt2;
        k = paramInt1;
      } while (parame.E.getParent() == null);
      j = paramInt2;
      k = paramInt1;
    } while (!(parame.E.getParent() instanceof RelativeLayout));
    paramBaseChatItemLayout = (RelativeLayout)parame.E.getParent();
    paramContext = new View(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(6, 2131364503);
    localLayoutParams.addRule(5, 2131364503);
    localLayoutParams.addRule(7, 2131364503);
    localLayoutParams.addRule(8, 2131364503);
    if (parame.mask != null) {
      paramBaseChatItemLayout.removeView(parame.mask);
    }
    if (ajlg.P(paramChatMessage)) {
      paramContext.setBackgroundResource(2130850826);
    }
    for (;;)
    {
      parame.mask = paramContext;
      paramBaseChatItemLayout.addView(parame.mask, localLayoutParams);
      j = paramInt2;
      k = paramInt1;
      break;
      paramContext.setBackgroundResource(2130850825);
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramXListView = wja.a(paramView);
    if ((paramXListView instanceof a)) {}
    for (paramXListView = (a)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.hL.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof answ.a))
          {
            paramView = (answ.a)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.Ht.getTag() instanceof anun.a))
            {
              paramView = (ImageView)((anun.a)paramView.Ht.getTag()).Hy;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130842633);
            }
          }
          paramInt += 1;
        }
      }
      return;
    }
  }
  
  boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, long paramLong, String paramString13)
  {
    String str1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
    String str2 = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramString1 + "&version=1";
    paramString1 = new Intent();
    paramString1.setClass(paramContext, ForwardRecentActivity.class);
    paramString1.putExtra("key_flag_from_plugin", true);
    paramString1.putExtra("strurt_msgid", String.valueOf(paramLong));
    paramString1.putExtra("struct_uin", paramString13);
    paramString1.putExtra("forward_type", 1001);
    paramString1.putExtra("image_url_remote", paramString4);
    paramString1.putExtra("title", paramString2);
    paramString1.putExtra("desc", paramString3);
    paramString1.putExtra("pluginName", "public_account");
    paramString1.putExtra("detail_url", paramString6);
    paramString1.putExtra("app_name", paramString5);
    if (("replyMsg".equals(paramString8)) || ("replyCmd".equals(paramString8))) {}
    for (;;)
    {
      paramString1.putExtra("req_type", 1);
      paramString1.putExtra("req_share_id", -1);
      paramString1.putExtra("brief_key", paramString12);
      paramString1.putExtra("struct_share_key_source_icon", paramString7);
      paramString1.putExtra("struct_share_key_source_action", "plugin");
      paramString1.putExtra("struct_share_key_source_action_data", str1);
      paramString1.putExtra("struct_share_key_source_a_action_data", str1);
      paramString1.putExtra("struct_share_key_source_i_action_data", str2);
      paramString1.putExtra("forward _key_nojump", true);
      paramString2 = anre.a(paramString1.getExtras());
      if (paramString2 == null) {
        break;
      }
      paramString1.putExtra("stuctmsg_bytes", paramString2.getBytes());
      paramString1.putExtra("k_struct_forward", true);
      paramContext.startActivity(paramString1);
      return true;
      paramString1.putExtra("struct_share_key_content_action", paramString8);
      paramString1.putExtra("struct_share_key_content_action_DATA", paramString9);
      paramString1.putExtra("struct_share_key_content_a_action_DATA", paramString10);
      paramString1.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    }
    return false;
  }
  
  public boolean a(BaseBubbleBuilder.e parame)
  {
    return parame instanceof a;
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    Object localObject;
    do
    {
      return false;
      localObject = (MessageForStructing)paramChatMessage;
      if ((((MessageForStructing)localObject).structingMsg != null) && (StructMsgForImageShare.class.isInstance(((MessageForStructing)localObject).structingMsg)) && (paramChatMessage.isSendFromLocal()))
      {
        localObject = this.app.b().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
        if (!(localObject instanceof MessageForStructing)) {
          break;
        }
        localObject = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
        if (localObject == null) {
          break;
        }
        localObject = ((StructMsgForImageShare)localObject).getFirstImageElement();
        if ((localObject == null) || (((ansu)localObject).filesize > 0L)) {
          break;
        }
        paramChatMessage = this.app.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof aojn))
        {
          if (((aojn)paramChatMessage).hh() == 1005L) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
        return true;
      }
      if (d((MessageForStructing)localObject))
      {
        if (this.app.a().a(((MessageForStructing)localObject).frienduin, ((MessageForStructing)localObject).uniseq) != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("StructingMsgItemBuilder", 2, "isFailed| Sdk share msg, processor not exist.");
        }
        return true;
      }
    } while ((((MessageForStructing)localObject).structingMsg != null) && ((((MessageForStructing)localObject).structingMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg).mMsgServiceID == 95) && (this.app.a().aS(paramChatMessage)));
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public boolean a(AbsShareMsg paramAbsShareMsg)
  {
    if (paramAbsShareMsg == null) {}
    do
    {
      return false;
      if (ocp.ey(paramAbsShareMsg.mMsgUrl)) {
        return true;
      }
    } while (((TextUtils.isEmpty(paramAbsShareMsg.mSource_A_ActionData)) || (!paramAbsShareMsg.mSource_A_ActionData.contains("pubaccount"))) && ((TextUtils.isEmpty(paramAbsShareMsg.mSource_I_ActionData)) || (!paramAbsShareMsg.mSource_I_ActionData.contains("public_account"))));
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = wja.a(paramView);
    if ((paramXListView instanceof a)) {}
    for (paramXListView = (a)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.hL.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof answ.a))
          {
            paramView = (answ.a)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.Ht.getTag() instanceof anun.a)) {
              return aqhq.fileExistsAndNotEmpty(((anun.a)paramView.Ht.getTag()).localPath);
            }
          }
          paramInt += 1;
        }
      }
      return false;
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    Object localObject = wja.a(paramView);
    if ((localObject instanceof a)) {}
    for (localObject = (a)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (ViewGroup)((a)localObject).hL.getChildAt(0);
        int i = ((ViewGroup)localObject).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          if (((((ViewGroup)localObject).getChildAt(paramInt2).getTag() instanceof answ.a)) && (a(paramXListView, paramInt1, paramView, paramChatMessage)))
          {
            answ.a locala = (answ.a)((ViewGroup)localObject).getChildAt(paramInt2).getTag();
            if ((locala.Ht.getTag() instanceof anun.a)) {
              paramAudioPlayerBase.play(((anun.a)locala.Ht.getTag()).localPath);
            }
          }
          paramInt2 += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public aqob[] a(View paramView)
  {
    paramView = (MessageForStructing)wja.a(paramView);
    aqoa localaqoa = new aqoa();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label40;
      }
      a(localaqoa, paramView, null);
    }
    for (;;)
    {
      return localaqoa.a();
      label40:
      b(localaqoa, paramView, null);
    }
  }
  
  public aqoa b(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    parama = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = parama.structingMsg;
    if (localAbsStructMsg != null)
    {
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).mMsgException))
      {
        ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        if (this.sessionInfo.cZ == 1008) {
          super.c(paramaqoa, this.mContext);
        }
        super.e(paramaqoa, this.mContext);
        return paramaqoa;
      }
      if (localAbsStructMsg.mMsgServiceID == 86)
      {
        ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        super.e(paramaqoa, this.mContext);
        return paramaqoa;
      }
      if (localAbsStructMsg.mMsgServiceID == 61)
      {
        ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        super.e(paramaqoa, this.mContext);
        return paramaqoa;
      }
      if (localAbsStructMsg.mMsgServiceID == 91)
      {
        ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        super.e(paramaqoa, this.mContext);
        return paramaqoa;
      }
      if (localAbsStructMsg.mMsgServiceID == 97)
      {
        ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        super.e(paramaqoa, this.mContext);
        return paramaqoa;
      }
      if (localAbsStructMsg.mMsgServiceID == 98)
      {
        ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        super.e(paramaqoa, this.mContext);
        return paramaqoa;
      }
      if (localAbsStructMsg.mMsgServiceID == 128)
      {
        a(parama, paramaqoa);
        ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        b(parama, paramaqoa);
        aqfr.b("Grp_AIO", "invite", "send_in", 0, 0, new String[0]);
        return paramaqoa;
      }
      if ((localAbsStructMsg instanceof StructMsgForHypertext))
      {
        ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        super.c(paramaqoa, this.mContext);
        super.e(paramaqoa, this.mContext);
        return paramaqoa;
      }
      if ((parama.isSendFromLocal()) && ((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).isSdkShareMsg()) && ((parama.extraflag == 32772) || (parama.extraflag == 32768)))
      {
        if (this.app.a().a(parama.frienduin, parama.uniseq) != null) {
          paramaqoa.Z(2131364237, this.mContext.getString(2131691403), 2130839075);
        }
        for (;;)
        {
          super.e(paramaqoa, this.mContext);
          return paramaqoa;
          ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        }
      }
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        ansu localansu = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
        if (localansu == null) {
          break label1569;
        }
        paramChatMessage = localansu.j;
        if (paramChatMessage != null) {
          break label1566;
        }
        if (localansu.d == null)
        {
          localansu.d = ((StructMsgForImageShare)localAbsStructMsg);
          localansu.d.message = parama;
        }
        localansu.a(this.mContext, null, null);
        paramChatMessage = localansu.j;
      }
    }
    for (;;)
    {
      int i;
      if ((paramChatMessage != null) && (aoop.a(this.mContext, paramChatMessage, 65537)))
      {
        i = 1;
        if ((paramChatMessage == null) || (paramChatMessage.imageType != 2000)) {
          break label623;
        }
      }
      label623:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          break label629;
        }
        super.e(paramaqoa, this.mContext);
        return paramaqoa;
        i = 0;
        break;
      }
      label629:
      paramaqoa.Z(2131362240, this.mContext.getString(2131694742), 2130839084);
      paramChatMessage = this.mContext.getResources();
      if (localAbsStructMsg.fwFlag != 1)
      {
        if (localAbsStructMsg.hasFlag(8)) {
          paramaqoa.Z(2131365509, paramChatMessage.getString(2131692329), 2130839078);
        }
        if (this.sessionInfo.cZ == 1008) {
          if (!localAbsStructMsg.hasFlag(32))
          {
            paramaqoa.Z(2131367544, paramChatMessage.getString(2131721067), 2130839086);
            label733:
            a(parama, paramaqoa);
            if (localAbsStructMsg.hasFlag(2)) {
              break label1554;
            }
            if (((this.sessionInfo.cZ == 1008) && (TextUtils.isEmpty(localAbsStructMsg.mMsgUrl))) || (localAbsStructMsg.mMsgServiceID == 81)) {
              break label1560;
            }
            if (localAbsStructMsg.mMsgServiceID != 14) {
              break label1542;
            }
            j = 0;
          }
        }
      }
      for (;;)
      {
        label795:
        i = j;
        if (localAbsStructMsg.mMsgServiceID == 21)
        {
          i = j;
          if (localAbsStructMsg.mMsgActionData != null)
          {
            i = j;
            if (!localAbsStructMsg.mMsgActionData.startsWith("mqqwpa://im/chat")) {}
          }
        }
        label1542:
        label1554:
        for (i = 0;; i = 0)
        {
          if ((parama.extraflag != 32768) && (!this.app.a().aR(parama)))
          {
            int k = 1;
            j = k;
            if (parama.istroop == 1)
            {
              j = k;
              if (localAbsStructMsg != null)
              {
                if ((localAbsStructMsg.mMsgServiceID != 23) && (localAbsStructMsg.mMsgServiceID != 19) && (localAbsStructMsg.mMsgServiceID != 60) && (!acfp.m(2131715006).equals(localAbsStructMsg.getSourceName())))
                {
                  j = k;
                  if (localAbsStructMsg.mMsgUrl == null) {
                    break label984;
                  }
                  if (!localAbsStructMsg.mMsgUrl.startsWith("http://qqweb.qq.com/m/qunactivity"))
                  {
                    j = k;
                    if (!localAbsStructMsg.mMsgUrl.startsWith("https://qqweb.qq.com/m/qunactivity")) {
                      break label984;
                    }
                  }
                }
                j = 0;
              }
            }
            label984:
            if (((1008 != parama.istroop) || (!acbn.bkr.equals(parama.frienduin))) && ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgUrl == null) || (!localAbsStructMsg.mMsgUrl.startsWith("https://ti.qq.com/remind/view.html"))))
            {
              k = j;
              if (localAbsStructMsg != null)
              {
                k = j;
                if (localAbsStructMsg.mMsgUrl != null)
                {
                  k = j;
                  if (!localAbsStructMsg.mMsgUrl.startsWith("https://mqq.tenpay.com")) {}
                }
              }
            }
            else
            {
              k = 0;
            }
            j = k;
            if (localAbsStructMsg != null)
            {
              j = k;
              if (localAbsStructMsg.mMsgServiceID == 49) {
                j = 0;
              }
            }
            if (j != 0) {
              a(paramaqoa, this.sessionInfo.cZ, parama);
            }
          }
          if ((this.sessionInfo.cZ != 1008) || (paramaqoa.size() == 0)) {
            a(paramaqoa, parama);
          }
          j = i;
          if (localAbsStructMsg != null) {
            if (localAbsStructMsg.mMsgServiceID != 14)
            {
              j = i;
              if (localAbsStructMsg.mMsgServiceID != 84) {}
            }
            else
            {
              j = 1;
            }
          }
          if ((j != 0) || (a(localAbsStructMsg, paramaqoa))) {
            paramaqoa.Z(2131366733, this.mContext.getResources().getString(2131693407), 2130839085);
          }
          super.a(paramaqoa, this.mContext, parama);
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID != 49) && (localAbsStructMsg.mMsgServiceID != 106) && (localAbsStructMsg.mMsgServiceID != 14)) {
            super.c(paramaqoa, this.mContext);
          }
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
            rar.a(this.app, this.mContext, parama, "press");
          }
          super.e(paramaqoa, this.mContext);
          b(parama, paramaqoa);
          if (((!augo.g(this.app, parama)) || (localAbsStructMsg == null) || (localAbsStructMsg.mMsgServiceID != 95)) && ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgServiceID != 33) || (!aobw.pN(localAbsStructMsg.mMsgUrl)))) {
            break;
          }
          paramaqoa.Z(2131377998, this.mContext.getString(2131719492), 2130840517);
          return paramaqoa;
          if (localAbsStructMsg.hasFlag(1)) {
            break label733;
          }
          paramaqoa.Z(2131367523, paramChatMessage.getString(2131721067), 2130839086);
          break label733;
          if (localAbsStructMsg.mMsgServiceID == 14)
          {
            paramaqoa.Z(2131367523, paramChatMessage.getString(2131721067), 2130839086);
            break label733;
          }
          if (!localAbsStructMsg.hasFlag(1))
          {
            paramaqoa.Z(2131367523, paramChatMessage.getString(2131721067), 2130839086);
            break label733;
          }
          if (localAbsStructMsg.mMsgServiceID != 35) {
            break label733;
          }
          paramaqoa.Z(2131367523, paramChatMessage.getString(2131721067), 2130839086);
          anot.b(this.app, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
          break label733;
          j = 1;
          break label795;
          a(parama, paramaqoa);
        }
        label1560:
        j = 0;
      }
      label1566:
      continue;
      label1569:
      paramChatMessage = null;
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (aqiu.ms(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    AbsShareMsg localAbsShareMsg;
    for (;;)
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof AbsShareMsg))) {
        break label210;
      }
      localAbsShareMsg = (AbsShareMsg)paramChatMessage;
      if (localAbsShareMsg.mMsgServiceID != 35) {
        break;
      }
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append(paramChatMessage.mMsgBrief);
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      localStringBuilder.append("按钮");
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
    if (localAbsShareMsg.mMsgServiceID == 107)
    {
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      return localStringBuilder.toString();
    }
    if (TextUtils.isEmpty(localAbsShareMsg.getTalkBackStr()))
    {
      if ((localAbsShareMsg.mContentTitle != null) && (localAbsShareMsg.mContentTitle.trim().length() > 0)) {
        localStringBuilder.append(localAbsShareMsg.mContentTitle);
      }
      if ((localAbsShareMsg.mContentSummary != null) && (localAbsShareMsg.mContentSummary.trim().length() > 0)) {
        localStringBuilder.append(localAbsShareMsg.mContentSummary);
      }
      localStringBuilder.append("按钮");
    }
    for (;;)
    {
      label210:
      return localStringBuilder.toString();
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      localStringBuilder.append("按钮");
    }
  }
  
  protected void b(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    paramView = wja.a(paramView);
    if (!a.class.isInstance(paramView)) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
        paramView = (a)paramView;
      } while ((!a.class.isInstance(paramView)) || (paramView.hL == null) || (!MessageForStructing.class.isInstance(paramView.mMessage)));
      localChatMessage = paramView.mMessage;
      if ((localChatMessage.uniseq == paramaoko.uniseq) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + paramaoko.uniseq);
        }
        a(this.app.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          notifyDataSetChanged();
        }
      }
    } while ((localChatMessage.uniseq != paramaoko.uniseq) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.hL.removeAllViews();
    paramaoko = new Bundle();
    paramView.hL.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.mContext, null, null, paramaoko));
  }
  
  protected void c(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    paramView = wja.a(paramView);
    if (!a.class.isInstance(paramView)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramView = (a)paramView;
        } while ((!a.class.isInstance(paramView)) || (paramView.hL == null) || (!MessageForStructing.class.isInstance(paramView.mMessage)));
        paramView = paramView.mMessage;
      } while ((paramView.uniseq != paramaoko.uniseq) || (!paramView.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + paramView.uniseq + ", file.uniseq = " + paramaoko.uniseq);
      }
    } while ((paramInt1 != 1005) && (paramInt1 != 1001) && (paramInt1 != 1003) && (paramInt1 != 1004) && (paramInt1 != 1002));
    notifyDataSetChanged();
  }
  
  public void c(MessageForStructing paramMessageForStructing) {}
  
  protected void ceh()
  {
    long l1 = 1L;
    aqxh localaqxh = (aqxh)this.app.getManager(76);
    aqxg localaqxg = localaqxh.a();
    if ((localaqxg != null) && (localaqxg.status == 0L) && (localaqxg.uniseq != 0L)) {
      localaqxh.me(localaqxg.uniseq);
    }
    long l2;
    if ((localaqxg != null) && (localaqxg.status == 1L))
    {
      l2 = localaqxh.timeout - (NetConnInfoCenter.getServerTimeMillis() - localaqxg.Cr);
      if (l2 > 0L) {
        break label127;
      }
    }
    for (;;)
    {
      new Handler(this.mContext.getMainLooper()).postDelayed(new StructingMsgItemBuilder.8(this, localaqxg, localaqxh), l1);
      return;
      label127:
      l1 = l2;
    }
  }
  
  public void destroy()
  {
    super.destroy();
    this.rZ.clear();
    this.sf.clear();
    StructMsgForGeneralShare.unRegisterQIPC();
  }
  
  public boolean e(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    if (wja.a(paramView).isMultiMsg) {}
    Object localObject2;
    ChatMessage localChatMessage;
    String str1;
    do
    {
      do
      {
        return;
        localObject1 = wja.a(paramView);
      } while (!a.class.isInstance(localObject1));
      localObject2 = this.mContext;
      localChatMessage = ((a)localObject1).mMessage;
      localObject1 = a(localChatMessage);
      if (localObject1 != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject1);
        return;
      }
      paramView = ((Context)localObject2).getString(2131690230);
      str1 = ((Context)localObject2).getString(2131690231);
    } while (!localChatMessage.isSendFromLocal());
    Object localObject1 = localChatMessage.getExtInfoFromExtStr("errorString");
    String str2 = localChatMessage.getExtInfoFromExtStr("retCode");
    String str3 = localChatMessage.getExtInfoFromExtStr("import_file_message_flag");
    boolean bool;
    if ((str3 != null) && ("import_file_message_flag_value".equals(str3)))
    {
      bool = String.valueOf(-1000).equals(str2);
      if (bool)
      {
        paramView = acfp.m(2131714999);
        localObject2 = acfp.m(2131715000);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label282;
        }
      }
    }
    for (;;)
    {
      localObject2 = (ausj)auss.a(this.mContext, null);
      ((ausj)localObject2).addButton(paramView);
      ((ausj)localObject2).addCancelButton(this.mContext.getString(2131721058));
      ((ausj)localObject2).setMainTitle((CharSequence)localObject1);
      ((ausj)localObject2).a(new xoq(this, bool, localChatMessage, (ausj)localObject2));
      ((ausj)localObject2).show();
      return;
      paramView = acfp.m(2131715001);
      break;
      aqha.a((Context)localObject2, 230, paramView, str1, new xor(this, localChatMessage, (Context)localObject2), new xos(this)).show();
      return;
      label282:
      localObject1 = localObject2;
    }
  }
  
  public void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((localAbsStructMsg != null) && (StructMsgForImageShare.class.isInstance(localAbsStructMsg)))
    {
      paramChatMessage = this.app.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage != null) && (aojn.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((aojn)paramChatMessage).b(), 0, 0);
        return;
      }
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    super.f(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public boolean gz(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = hw;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String hz(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      str1 = str2;
      if (paramString.length > 6) {
        str1 = paramString[5];
      }
    }
    return str1;
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    StructMsgForImageShare localStructMsgForImageShare;
    ansu localansu;
    if (paramView.getId() == 2131366152)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      localObject = ((FragmentActivity)this.mContext).getChatFragment();
      if (localObject == null) {
        break label199;
      }
      localBaseChatPie = ((ChatFragment)localObject).a();
      if (localBaseChatPie == null) {
        break label180;
      }
      localObject = (MessageForStructing)((a)wja.a(paramView)).mMessage;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break label218;
      }
      localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      localansu = localStructMsgForImageShare.getFirstImageElement();
      if (localansu == null) {
        break label218;
      }
    }
    label180:
    label199:
    label218:
    for (Object localObject = new afdv(localansu.mUuid, localansu.mMd5, localansu.anV, localStructMsgForImageShare.rawUrl, ((MessageForStructing)localObject).senderuin);; localObject = null)
    {
      localBaseChatPie.getUIHandler().obtainMessage(79, localObject).sendToTarget();
      for (;;)
      {
        super.onClick(paramView);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("StructingMsgItemBuilder", 2, "[Doutu] curPie is null.");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("StructingMsgItemBuilder", 2, "[Doutu] chatFragment is null.");
          }
        }
      }
    }
  }
  
  public void p(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg == null) || (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) || (((StructMsgForGeneralShare)paramChatMessage.structingMsg).mMsgServiceID != 95)) {
        break label99;
      }
    }
    label99:
    for (int i = 7;; i = 5)
    {
      anot.a(this.app, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  static class CacheMap
    extends HashMap<String, ArrayList<StructingMsgItemBuilder.c>>
  {
    private static final long serialVersionUID = -7873031099646660622L;
    
    public void add(StructingMsgItemBuilder.c paramc)
    {
      if (paramc == null) {
        return;
      }
      get(paramc.mKey).add(paramc);
    }
    
    public ArrayList<StructingMsgItemBuilder.c> get(String paramString)
    {
      ArrayList localArrayList2 = (ArrayList)super.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        put(paramString, localArrayList1);
      }
      return localArrayList1;
    }
    
    public void remove(StructingMsgItemBuilder.c paramc)
    {
      if ((paramc == null) || (paramc.mKey == null)) {}
      ArrayList localArrayList;
      do
      {
        return;
        localArrayList = get(paramc.mKey);
        localArrayList.remove(paramc);
      } while (!localArrayList.isEmpty());
      remove(paramc.mKey);
    }
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    public MessageProgressTextView b;
    public boolean bib;
    public RelativeLayout hL;
    public RelativeLayout hM;
    public RelativeLayout hN;
    public SessionInfo sessionInfo;
  }
  
  public static class b
  {
    private static final String TAG = b.class.getSimpleName();
    private StructingMsgItemBuilder.CacheMap a = new StructingMsgItemBuilder.CacheMap(null);
    private StructingMsgItemBuilder.CacheMap b = new StructingMsgItemBuilder.CacheMap(null);
    
    private StructingMsgItemBuilder.c a(String paramString, ViewGroup paramViewGroup)
    {
      Iterator localIterator = this.b.get(paramString).iterator();
      while (localIterator.hasNext())
      {
        paramString = (StructingMsgItemBuilder.c)localIterator.next();
        if (paramString != null) {
          paramString.I(paramViewGroup);
        }
      }
      for (;;)
      {
        this.b.remove(paramString);
        this.a.add(paramString);
        return paramString;
        paramString = null;
      }
    }
    
    public View a(String paramString, ViewGroup paramViewGroup)
    {
      b(paramString, paramViewGroup);
      paramString = a(paramString, paramViewGroup);
      if (paramString != null) {
        return paramString.getContentView();
      }
      return null;
    }
    
    public void a(String paramString, View paramView, ViewGroup paramViewGroup)
    {
      this.a.add(new StructingMsgItemBuilder.c(paramString, paramView, paramViewGroup));
    }
    
    public void b(String paramString, ViewGroup paramViewGroup)
    {
      if (paramViewGroup == null) {}
      StructingMsgItemBuilder.c localc;
      do
      {
        return;
        while (!paramString.hasNext()) {
          paramString = this.a.get(paramString).iterator();
        }
        localc = (StructingMsgItemBuilder.c)paramString.next();
      } while ((localc == null) || (localc.t() == null) || (localc.t() != paramViewGroup));
      localc.t().removeAllViews();
      this.a.remove(localc);
      this.b.add(localc);
    }
    
    public void clear()
    {
      this.a.clear();
      this.b.clear();
    }
  }
  
  static class c
  {
    SoftReference<View> k;
    SoftReference<ViewGroup> l;
    String mKey;
    
    public c(String paramString, View paramView, ViewGroup paramViewGroup)
    {
      this.mKey = paramString;
      this.k = new SoftReference(paramView);
      this.l = new SoftReference(paramViewGroup);
    }
    
    public void I(ViewGroup paramViewGroup)
    {
      this.l = new SoftReference(paramViewGroup);
    }
    
    public View getContentView()
    {
      return (View)this.k.get();
    }
    
    public ViewGroup t()
    {
      return (ViewGroup)this.l.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */