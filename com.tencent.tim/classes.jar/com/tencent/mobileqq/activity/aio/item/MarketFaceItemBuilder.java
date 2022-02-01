package com.tencent.mobileqq.activity.aio.item;

import acdz;
import acfp;
import afhf;
import afhs;
import afhu;
import afhv;
import afkd;
import afke;
import afkn;
import afko;
import afnu;
import afpu;
import ahgq;
import aixi;
import aixo;
import aiyr;
import ajdg;
import ajpd;
import anaz;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArraySet;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import anpc;
import anqz;
import apsw;
import apsw.e;
import aqha;
import aqhq;
import aqiu;
import aqiw;
import aqju;
import aqnm;
import aqoa;
import aqob;
import arhz;
import augo;
import ausj;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import sxx;
import ujt;
import wja;
import wlz;
import xjm;
import xjn;
import xjo;
import xjp;
import xjq;
import xjr;
import xjs;
import xju;
import xjv;
import xjw;

public class MarketFaceItemBuilder
  extends BaseBubbleBuilder
  implements MediaPlayerManager.a
{
  static long IV;
  public static afpu b;
  public static int bTw = 1;
  public static ChatMessage o;
  private long IW;
  public a a = new a();
  public afke b;
  afkn b;
  public int bTx = 320;
  public int bTy = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
  public boolean bgY = false;
  Set<Long> bo = new HashSet();
  Set<b> bp = new HashSet();
  Set<Long> bq = new ArraySet();
  public Context mContext;
  public List<b> se;
  
  public MarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Afkn = new xju(this);
    this.mContext = paramContext;
    this.se = new ArrayList();
    this.jdField_b_of_type_Afke = ((afke)paramQQAppInterface.getManager(43));
    if ((this.mContext instanceof SplashActivity)) {
      this.bgY = true;
    }
  }
  
  private void De(int paramInt)
  {
    this.a.a(paramInt, this.app, this.mContext, jdField_b_of_type_Afpu, this.sessionInfo, c());
    afkd.a().a(this.a);
    this.jdField_b_of_type_Afke.ex(jdField_b_of_type_Afpu.e.epId, afke.cRu);
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    afhu localafhu = (afhu)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localafhu.ez();
    int j;
    int i;
    if (localList != null)
    {
      j = 0;
      int m = 0;
      int n;
      for (i = 1; j < localList.size(); i = n)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        int k;
        if (!TextUtils.isEmpty(localCustomEmotionData.RomaingType))
        {
          k = m;
          if ("needDel".equals(localCustomEmotionData.RomaingType)) {}
        }
        else
        {
          k = m + 1;
        }
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId)))
        {
          if (localafhu.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.14(paramContext));
            }
            ajdg.ew("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.15(paramContext));
          }
          ajdg.ew("2003", 1);
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= afhs.cQV) {
        j = -2;
      }
    }
    for (;;)
    {
      paramHandler = new CustomEmotionData();
      paramHandler.uin = paramQQAppInterface.getCurrentAccountUin();
      paramHandler.emoId = (i + 1);
      paramHandler.isMarkFace = true;
      paramHandler.emoPath = paramEmoticon.epId;
      paramHandler.eId = paramEmoticon.eId;
      paramHandler.checkMarketFace("addEmotionToFavorite");
      paramEmoticon = ((ajdg)paramQQAppInterface.getManager(14)).b(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label427;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (afhv)paramQQAppInterface.getManager(103);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new afhf(paramQQAppInterface, paramContext, paramHandler, null, 0));
        }
        if (o != null) {
          a(paramQQAppInterface, o.frienduin, "ep_mall", "Clk_collect_suc", 0);
        }
        return j;
        label427:
        bool = false;
      }
      j = 0;
      continue;
      i = 1;
      j = 0;
    }
  }
  
  private SpannableString a(int paramInt, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = paramString2;
    int i;
    if (TextUtils.isEmpty(paramString2))
    {
      i = 2131691861;
      switch (paramInt)
      {
      default: 
        paramString2 = str;
        paramInt = i;
      }
    }
    for (;;)
    {
      localObject = this.mContext.getString(paramInt, new Object[] { paramString2 });
      paramString2 = (String)localObject + paramString1;
      localObject = new SpannableString(paramString2);
      paramInt = paramString2.indexOf(paramString1);
      i = paramString1.length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-31676), paramInt, i + paramInt, 33);
      return localObject;
      paramInt = 2131691862;
      paramString2 = acfp.m(2131708048);
      continue;
      paramString2 = acfp.m(2131708043);
      paramInt = i;
      continue;
      paramString2 = acfp.m(2131708040);
      paramInt = i;
      continue;
      paramString2 = acfp.m(2131708050);
      paramInt = i;
    }
  }
  
  public static void a(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt2, String paramString, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramEmoticon == null) {
      QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
    }
    label223:
    do
    {
      Handler localHandler;
      do
      {
        do
        {
          do
          {
            return;
            if (aM(paramContext)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("MarketFaceItemBuilder", 2, "context is not in the top");
          return;
          localHandler = new Handler(Looper.getMainLooper());
          if (paramInt2 != 0) {
            break label223;
          }
          if (7 != paramInt1 % 1000) {
            break;
          }
          try
          {
            paramQQAppInterface = new Bundle();
            paramQQAppInterface.putInt("forward_type", 9);
            paramQQAppInterface.putBoolean("forward_emotion_from_preview", paramBoolean);
            paramEmoticon = new Intent();
            paramEmoticon.putExtras(paramQQAppInterface);
            ahgq.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
            return;
          }
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
        return;
        if (6 == paramInt1 % 1000)
        {
          ThreadManager.post(new MarketFaceItemBuilder.11(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
          return;
        }
      } while (107 != paramInt1 % 1000);
      anot.a(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      afpu.b(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.12(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          ajdg.ew("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.13(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    ajdg.ew("2002", 1);
  }
  
  private static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      aqha.a(paramContext, 230, paramString1, paramString2, 2131721058, 2131692649, new xjo(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new xjp()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, afpu paramafpu, SessionInfo paramSessionInfo, arhz paramarhz)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramafpu, paramSessionInfo, paramarhz, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, afpu paramafpu, SessionInfo paramSessionInfo, arhz paramarhz, boolean paramBoolean)
  {
    if (paramafpu == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((paramarhz != null) && (paramarhz.isShowing())) {
        paramarhz.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramafpu.e, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!aqiw.isNetworkAvailable(paramContext)) || (paramInt > 1000))
    {
      if ((paramarhz != null) && (paramarhz.isShowing())) {
        paramarhz.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramafpu.e, -404, acfp.m(2131708047), paramSessionInfo, paramBoolean);
      return;
    }
    ((acdz)paramQQAppInterface.getBusinessHandler(12)).E(paramInt, Integer.valueOf(paramafpu.e.epId).intValue(), paramafpu.e.eId);
  }
  
  private void a(afpu paramafpu, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.app.getCurrentUin();
      str2 = ps();
      if (paramafpu == null) {}
      for (paramafpu = "";; paramafpu = paramafpu.e.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramafpu, paramString);
        return;
      }
    case 3: 
      paramString = this.app;
      if (paramafpu == null) {}
      for (paramafpu = "";; paramafpu = paramafpu.e.epId)
      {
        anot.a(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramafpu, "", "", "");
        return;
      }
    }
    String str1 = this.app.getCurrentUin();
    String str2 = ps();
    if (paramafpu == null) {}
    for (paramafpu = "";; paramafpu = paramafpu.e.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramafpu, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  private void a(b paramb)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_b_of_type_Afke.a(paramb.c.e.epId, Boolean.valueOf(false)))
    {
      afkd.a().a(this.jdField_b_of_type_Afkn);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramb.c.e.name;
      localEmoticonPackage.epId = paramb.c.e.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramb.rscType != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = aixo.dr(paramb.c.e.magicValue);; localEmoticonPackage.rscType = paramb.rscType)
    {
      ((ajdg)this.app.getManager(14)).e(paramb.c.e);
      paramb.bgZ = false;
      ((MessageForMarketFace)paramb.mMessage).needToPlay = true;
      this.se.add(paramb);
      paramb.tf.setVisibility(8);
      paramb.progressBar.setVisibility(0);
      this.jdField_b_of_type_Afke.a(localEmoticonPackage, false);
      anot.a(this.app, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(b paramb, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramb.tg.getDrawable();
    if (this.bo.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramb.tg.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramb.tg.setVisibility(4);
  }
  
  private void a(b paramb, Rect paramRect)
  {
    AIOEmotionFragment.a(this.mContext, paramb.mMessage, this.sessionInfo, paramRect);
  }
  
  private void a(b paramb, URLDrawable paramURLDrawable)
  {
    int m = 200;
    int j;
    label50:
    int k;
    int n;
    Object localObject;
    if ((paramURLDrawable != null) && (paramb.c.e != null)) {
      if (paramb.c.e.width == 0)
      {
        j = 200;
        if (paramb.c.e.height != 0) {
          break label429;
        }
        k = j;
        i = m;
        if (paramb.c.e.extensionWidth != 0)
        {
          k = j;
          i = m;
          if (paramb.c.e.extensionHeight != 0)
          {
            k = paramb.c.e.extensionWidth;
            i = paramb.c.e.extensionHeight;
          }
        }
        j = k;
        if (k != i) {
          j = i;
        }
        n = (j * this.bTy + (this.bTx >> 1)) / this.bTx;
        i = (this.bTy * i + (this.bTx >> 1)) / this.bTx;
        paramb.image.setLayoutParams(new FrameLayout.LayoutParams(n, i));
        localObject = paramb.Jn.getTag();
        if (!(localObject instanceof Integer)) {
          break label530;
        }
      }
    }
    label530:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if ((paramb.Jn.getVisibility() == 0) && (i != -1))
      {
        String str1 = (String)paramb.Jn.getTag(2131364079);
        String str2 = (String)paramb.Jn.getTag(2131364078);
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(wja.dp2px(12.0F, this.mContext.getResources()));
        localPaint.setTextAlign(Paint.Align.LEFT);
        int i1 = (int)localPaint.measureText("...");
        if (!TextUtils.isEmpty(str1)) {}
        for (j = (int)localPaint.measureText(acfp.m(2131708045) + str1);; j = (int)localPaint.measureText(acfp.m(2131708041)))
        {
          m = str2.length();
          k = (int)localPaint.measureText(str2) + j;
          localObject = "";
          while ((k > n) && (m > 0))
          {
            m -= 1;
            localObject = str2.substring(0, m);
            k = (int)localPaint.measureText((String)localObject) + i1 + j;
          }
          j = paramb.c.e.width;
          break;
          label429:
          m = paramb.c.e.height;
          break label50;
        }
        if (!((String)localObject).equals(""))
        {
          localObject = a(i, (String)localObject + "...", str1);
          paramb.Jn.setText((CharSequence)localObject);
        }
      }
      paramb.image.setImageDrawable(paramURLDrawable);
      a(paramb, paramURLDrawable, paramb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
      return;
    }
  }
  
  private void a(b paramb, URLDrawable paramURLDrawable, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramURLDrawable != null) {
      switch (paramURLDrawable.getStatus())
      {
      default: 
        paramb.progressBar.setVisibility(0);
        paramBaseChatItemLayout.setProgressVisable(true);
      }
    }
    do
    {
      float f;
      do
      {
        do
        {
          return;
          if (!aiyr.apU()) {
            paramb.progressBar.setVisibility(8);
          }
        } while ((afnu.isWifiOrG3OrG4()) && (2 == paramb.c.e.jobType) && (!this.jdField_b_of_type_Afke.ma(paramb.c.e.epId)) && (!afnu.ajD()));
        f = this.jdField_b_of_type_Afke.e(paramb.c.e.epId);
      } while ((f >= 0.0F) && (1.0F != f));
      paramb.progressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
      paramb.progressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
    } while (!AppSetting.enableTalkBack);
    paramb.bc.setContentDescription(acfp.m(2131708044));
  }
  
  private void a(b paramb, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.5(this, paramString, paramb), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    anot.a(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, b paramb)
  {
    a(paramChatMessage, paramb, "");
  }
  
  private void a(ChatMessage paramChatMessage, b paramb, String paramString)
  {
    int i = 0;
    if ((paramb.c.ajH()) && (!d(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      URLDrawable localURLDrawable = paramb.c.a("fromAIO", bool);
      Object localObject1 = "";
      Object localObject2 = localObject1;
      if (localURLDrawable != null)
      {
        localObject2 = localObject1;
        if (localURLDrawable.getStatus() == 1)
        {
          if ((localURLDrawable.getStateTag() instanceof Bundle)) {
            localObject1 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
          }
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).equals("aio_preview"))
            {
              localObject2 = paramb.jdField_b_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
                paramString = paramb.c.a("fromAIO", bool);
              }
            }
          }
        }
      }
      for (;;)
      {
        a(paramb, paramString);
        paramb.sM.setVisibility(8);
        paramb.sL.setVisibility(8);
        paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        c(paramChatMessage, paramb);
        b(paramChatMessage, paramb);
        if (paramString != null) {
          a(paramb, paramString, (String)localObject1);
        }
        c(paramb);
        return;
        if (!paramString.equals("")) {
          i = 1;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
          paramString = paramb.c.a("fromAIO", bool, true, paramb);
        }
        else
        {
          paramString = localURLDrawable;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static boolean aM(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        return paramContext.getClass().getName().equals(localObject);
      }
    }
    return true;
  }
  
  private void b(b paramb)
  {
    if ((4 != paramb.c.e.jobType) || (((MessageForMarketFace)paramb.mMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_b_of_type_Afke.c(paramb.c.e.epId, true, true)) {
        break;
      }
      if (!afnu.isWifiOrG3OrG4())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramb.c.e.epId);
        }
        paramb.tf.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_b_of_type_Afke.e(paramb.c.e.epId));
    afkd.a().a(this.jdField_b_of_type_Afkn);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramb.c.e.name;
    localEmoticonPackage.epId = paramb.c.e.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((ajdg)this.app.getManager(14)).e(paramb.c.e);
    this.se.add(paramb);
    paramb.bgZ = ((MessageForMarketFace)paramb.mMessage).needToPlay;
    paramb.tf.setVisibility(8);
    paramb.progressBar.setVisibility(0);
    ((MessageForMarketFace)paramb.mMessage).needToPlay = false;
    this.jdField_b_of_type_Afke.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramb.c.e.epId);
    }
    anot.a(this.app, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.bgY) && (this.jdField_b_of_type_Afke.ajs()))
    {
      if (!this.bdn) {
        paramb.tf.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramb.c.e.epId);
      }
    }
    for (;;)
    {
      paramb.tf.setImageResource(2130838101);
      if ((((MessageForMarketFace)paramb.mMessage).isSend()) || (!((MessageForMarketFace)paramb.mMessage).needToPlay) || (!this.jdField_b_of_type_Afke.ajr()) || (System.currentTimeMillis() - this.IW <= 3000L) || (((FragmentActivity)this.mContext).getChatFragment() == null) || (((FragmentActivity)this.mContext).getChatFragment().a() == null) || (((FragmentActivity)this.mContext).getChatFragment().a().OT())) {
        break;
      }
      this.IW = System.currentTimeMillis();
      ((MessageForMarketFace)paramb.mMessage).needToPlay = false;
      a(paramb, "1");
      anot.a(this.app, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramb.c.e.epId, "", "", "");
      return;
      paramb.tf.setVisibility(8);
    }
  }
  
  private void b(ChatMessage paramChatMessage, b paramb)
  {
    if ((paramb.c.ajH()) && (paramb.c.isNewSoundType()) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (paramb.c.P() != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        paramChatMessage.width = wja.dp2px(39.0F, this.mContext.getResources());
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramb.c.P(), paramChatMessage.width, paramb.c.Ds());
        if (Build.VERSION.SDK_INT < 19)
        {
          paramChatMessage = (RelativeLayout.LayoutParams)paramb.hE.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramb.jdField_b_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
          paramChatMessage.width = wja.dp2px(92.0F, this.mContext.getResources());
          localLayoutParams.width = wja.dp2px(92.0F, this.mContext.getResources());
        }
      }
      int i = paramb.c.Dt();
      int j = paramb.c.Du();
      paramChatMessage = new anqz(i, 1, 1, wja.dp2px(22.0F, this.mContext.getResources()));
      paramb.hE.setBackgroundDrawable(paramChatMessage);
      paramb.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      paramb.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.postInvalidate();
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
      paramb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
    }
  }
  
  private arhz c()
  {
    if (((FragmentActivity)this.mContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.mContext).getChatFragment().a().x == null) {
        ((FragmentActivity)this.mContext).getChatFragment().a().x = new arhz(this.mContext);
      }
      return ((FragmentActivity)this.mContext).getChatFragment().a().x;
    }
    return null;
  }
  
  private void c(b paramb)
  {
    paramb.bgZ = false;
    if ((2 != paramb.c.e.jobType) || (((MessageForMarketFace)paramb.mMessage).mMarkFaceMessage == null) || (!aiyr.apU())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_b_of_type_Afke.ma(paramb.c.e.epId))
      {
        if (!afnu.isWifiOrG3OrG4())
        {
          paramb.tf.setVisibility(8);
          return;
        }
        if ((!afnu.ajD()) && (!this.jdField_b_of_type_Afke.a(paramb.c.e.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_b_of_type_Afke.e(paramb.c.e.epId)))
        {
          afkd.a().a(this.jdField_b_of_type_Afkn);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramb.c.e.name;
          ((EmoticonPackage)localObject).epId = paramb.c.e.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = aixo.dr(paramb.c.e.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((ajdg)this.app.getManager(14)).e(paramb.c.e);
          this.se.add(paramb);
          paramb.bgZ = ((MessageForMarketFace)paramb.mMessage).needToPlay;
          paramb.tf.setVisibility(8);
          paramb.progressBar.setVisibility(0);
          ((MessageForMarketFace)paramb.mMessage).needToPlay = false;
          this.jdField_b_of_type_Afke.a((EmoticonPackage)localObject, false);
          anot.a(this.app, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramb.c.e.epId, "", "", "");
        }
      }
      else
      {
        if (aixo.dr(paramb.c.e.magicValue) == 1) {
          paramb.tf.setVisibility(8);
        }
        while (((MessageForMarketFace)paramb.mMessage).needToPlay)
        {
          ((MessageForMarketFace)paramb.mMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramb.c.e.eId;
          ((Emoticon)localObject).epId = paramb.c.e.epId;
          ((Emoticon)localObject).magicValue = paramb.c.e.magicValue;
          ((Emoticon)localObject).jobType = paramb.c.e.jobType;
          if ((((FragmentActivity)this.mContext).getChatFragment() != null) && (((FragmentActivity)this.mContext).getChatFragment().a() != null) && (aiyr.apU())) {
            ((FragmentActivity)this.mContext).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramb.mMessage).senderuin, false);
          }
          anot.a(this.app, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramb.c.e.epId, "", "", "");
          return;
          if (!this.bdn)
          {
            paramb.tf.setImageResource(2130838101);
            paramb.tf.setVisibility(0);
          }
        }
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, b paramb)
  {
    if ((paramChatMessage.isFlowMessage) && (paramb.c.e.jobType == 0)) {
      if (!(this.mContext instanceof MultiForwardActivity))
      {
        if (!paramChatMessage.isSend()) {
          break label56;
        }
        paramb.sL.setImageResource(2130847981);
        paramb.sL.setVisibility(0);
      }
    }
    label56:
    while ((!paramChatMessage.isDui) || (!DuiButtonImageView.bXG) || (ajpd.aK(paramChatMessage)))
    {
      return;
      paramb.sM.setImageResource(2130847981);
      paramb.sM.setVisibility(0);
      return;
    }
    paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.q = paramChatMessage;
    if ((paramChatMessage.isSend()) || (paramb.c.ajH()))
    {
      paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.stopAnim();
      return;
    }
    if ((paramb.c != null) && (paramb.c.e != null) && ((2 == paramb.c.e.jobType) || (4 == paramb.c.e.jobType)))
    {
      paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.stopAnim();
      return;
    }
    if (!paramChatMessage.hasPlayedDui) {
      paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
    }
    while (DuiButtonImageView.bXG)
    {
      paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
      paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
      return;
      paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.ms();
    }
    paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
    paramb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
  }
  
  private void d(b paramb)
  {
    if ((paramb != null) && (paramb.c != null) && (paramb.c.isNewSoundType()) && (paramb.mMessage != null) && (!this.bq.contains(Long.valueOf(paramb.mMessage.uniseq))))
    {
      ajdg.e(this.app, "0X800AB51", this.sessionInfo.cZ, paramb.c.e.epId);
      this.bq.add(Long.valueOf(paramb.mMessage.uniseq));
    }
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = MediaPlayerManager.a(this.app).a();
    } while ((localChatMessage != paramChatMessage) && ((!(localChatMessage instanceof MessageForMarketFace)) || (localChatMessage.frienduin == null) || (!localChatMessage.frienduin.equals(paramChatMessage.frienduin)) || (localChatMessage.uniseq != paramChatMessage.uniseq)));
    return true;
  }
  
  private void fo(View paramView)
  {
    paramView = (b)wja.a(paramView);
    EmoticonPackage localEmoticonPackage;
    if ((paramView.c != null) && (paramView.c.e != null) && (2 == paramView.c.e.jobType))
    {
      if (!this.jdField_b_of_type_Afke.a(paramView.c.e.epId, Boolean.valueOf(false)))
      {
        afkd.a().a(this.jdField_b_of_type_Afkn);
        localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.name = paramView.c.e.name;
        localEmoticonPackage.epId = paramView.c.e.epId;
        localEmoticonPackage.jobType = 3;
        localEmoticonPackage.type = 1;
        localEmoticonPackage.isMagicFaceDownloading = true;
        paramView.bgZ = false;
        ((MessageForMarketFace)paramView.mMessage).needToPlay = false;
        ((ajdg)this.app.getManager(14)).e(paramView.c.e);
        this.se.add(paramView);
        paramView.tf.setVisibility(8);
        paramView.progressBar.setVisibility(0);
        this.jdField_b_of_type_Afke.a(localEmoticonPackage, false);
        anot.a(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, paramView.c.e.epId, "", "", "");
      }
    }
    else if ((paramView.c != null) && (paramView.c.e != null) && (4 == paramView.c.e.jobType) && (System.currentTimeMillis() - this.IW > 3000L) && (this.jdField_b_of_type_Afke.ajr()))
    {
      this.IW = System.currentTimeMillis();
      if (!this.jdField_b_of_type_Afke.c(paramView.c.e.epId, true, true)) {
        break label474;
      }
      a(paramView, "0");
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, paramView.c.e.epId, "", "", "");
      return;
      if ((((FragmentActivity)this.mContext).getChatFragment() == null) || (((FragmentActivity)this.mContext).getChatFragment().a() == null) || (!aiyr.apU()) || (((FragmentActivity)this.mContext).getChatFragment() == null) || (((FragmentActivity)this.mContext).getChatFragment().a() == null)) {
        break;
      }
      ((FragmentActivity)this.mContext).getChatFragment().a().a(paramView.c.e, 1, paramView.mMessage.senderuin, true);
      break;
      label474:
      afkd.a().a(this.jdField_b_of_type_Afkn);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramView.c.e.name;
      localEmoticonPackage.epId = paramView.c.e.epId;
      localEmoticonPackage.jobType = 5;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      paramView.bgZ = false;
      ((MessageForMarketFace)paramView.mMessage).needToPlay = false;
      ((ajdg)this.app.getManager(14)).e(paramView.c.e);
      this.se.add(paramView);
      paramView.tf.setVisibility(8);
      paramView.progressBar.setVisibility(0);
      this.jdField_b_of_type_Afke.a(localEmoticonPackage, false);
    }
  }
  
  private void fp(View paramView)
  {
    boolean bool = true;
    Object localObject = (b)wja.a(paramView);
    QQAppInterface localQQAppInterface;
    int i;
    if ((((b)localObject).c != null) && (((b)localObject).c.ajH()) && (((b)localObject).c.isNewSoundType()))
    {
      if (!d(((b)localObject).mMessage)) {
        break label119;
      }
      MediaPlayerManager.a(this.app).stop(false);
      localQQAppInterface = this.app;
      i = this.sessionInfo.cZ;
      if (((b)localObject).c.e == null) {
        break label112;
      }
    }
    label112:
    for (paramView = ((b)localObject).c.e.epId;; paramView = "")
    {
      ajdg.e(localQQAppInterface, "0X800A934", i, paramView);
      return;
    }
    label119:
    if (this.app.bF())
    {
      QQToast.a(this.app.getApp(), 2131697385, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if ((((b)localObject).mMessage instanceof MessageForMarketFace)) {
      ((MessageForMarketFace)((b)localObject).mMessage).playProgress = 0.0F;
    }
    ((b)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    if (MediaPlayerManager.a(this.app).k(((b)localObject).mMessage))
    {
      ((b)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
      localQQAppInterface = this.app;
      i = this.sessionInfo.cZ;
      if (((b)localObject).c.e != null)
      {
        paramView = ((b)localObject).c.e.epId;
        ajdg.e(localQQAppInterface, "0X800A933", i, paramView);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        localQQAppInterface = this.app;
        if (((b)localObject).c.e != null)
        {
          paramView = ((b)localObject).c.e.epId;
          label300:
          ajdg.e(localQQAppInterface, "0X800A935", -1, paramView);
        }
      }
      else
      {
        localObject = new HashMap();
        if (!bool) {
          break label390;
        }
      }
      label390:
      for (paramView = "0";; paramView = "1")
      {
        ((HashMap)localObject).put("playResult", paramView);
        ((HashMap)localObject).put("playType", "1");
        anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject, null);
        return;
        paramView = "";
        break;
        paramView = "";
        break label300;
      }
      bool = false;
    }
  }
  
  private void fq(View paramView)
  {
    b localb = (b)wja.a(paramView);
    Drawable localDrawable = localb.image.getDrawable();
    URLDrawable localURLDrawable;
    Object localObject;
    if ((localDrawable instanceof URLDrawable))
    {
      localURLDrawable = (URLDrawable)localDrawable;
      localObject = localURLDrawable.getURL().getHost();
      if (!(localURLDrawable.getTag() instanceof Bundle)) {
        break label654;
      }
      localObject = ((Bundle)localURLDrawable.getTag()).getString("display_type");
    }
    label654:
    for (;;)
    {
      switch (((URLDrawable)localDrawable).getStatus())
      {
      default: 
        if ((localb.c != null) && (localb.c.e != null) && (localb.c.e.jobType == 2) && (aiyr.apU())) {
          a(localb);
        }
        if ((((URLDrawable)localDrawable).getStatus() == 1) || ((localb.c != null) && (localb.c.e != null) && (localb.c.ajJ()))) {
          a(localb, sxx.getViewRect(paramView));
        }
        break;
      }
      do
      {
        return;
        String str = "";
        if ((localURLDrawable.getStateTag() instanceof Bundle)) {
          str = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
        }
        localURLDrawable.restartDownload();
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + localURLDrawable.getStatus());
        }
        a(localb, localURLDrawable, str);
        localb.progressBar.setVisibility(0);
        if ((localb.c == null) || (!localb.c.ajH()) || (!"big_sound".equals(localObject))) {
          break;
        }
        IV = localb.mMessage.uniseq;
        break;
        if ((localb.c == null) || (localb.c.e == null) || (localb.c.e.jobType == 0) || (localb.c.e.jobType == 2) || (localb.c.e.jobType == 4)) {
          break;
        }
        localb.progressBar.setVisibility(8);
        if ("big_sound".equals(localObject))
        {
          if ((localb.c.e == null) || (!localb.c.e.isSound)) {
            break;
          }
          if (d(localb.mMessage))
          {
            MediaPlayerManager.a(this.app).stop(false);
            break;
          }
          if (this.app.bF())
          {
            QQToast.a(this.app.getApp(), 2131697385, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
            break;
          }
          MediaPlayerManager.a(this.app).k(localb.mMessage);
          break;
        }
        if (!"aio_preview".equals(localObject)) {
          break;
        }
        localObject = localb.c.a("fromAIO", true);
        if (localObject == null) {
          break;
        }
        localb.image.setImageDrawable((Drawable)localObject);
        localb.progressBar.setVisibility(0);
        b(localb, (URLDrawable)localObject);
        if (!localb.c.ajH()) {
          break;
        }
        IV = localb.mMessage.uniseq;
        break;
      } while ((!(localDrawable instanceof aixi)) || (localb.c == null) || (localb.c.e == null) || (!localb.c.ajJ()));
      a(localb, sxx.getViewRect(paramView));
      return;
    }
  }
  
  private String ps()
  {
    try
    {
      i = aqiw.getSystemNetwork(this.mContext);
      switch (i)
      {
      default: 
        return "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
      return "2G";
    }
    return "3G";
    return "4G";
    return "wifi";
  }
  
  protected void B(ChatMessage paramChatMessage)
  {
    ((augo)this.app.getManager(374)).B(paramChatMessage);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    b localb = (b)parame;
    this.bp.add(localb);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    PttAudioPlayView localPttAudioPlayView;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    RelativeLayout localRelativeLayout;
    TriangleView localTriangleView;
    Object localObject10;
    Object localObject11;
    Object localObject12;
    Object localObject13;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      parame = new RelativeLayout(this.mContext);
      localObject2 = new RelativeLayout(this.mContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131371151);
      paramView = new ImageView(this.mContext);
      paramView.setId(2131367330);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364503);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364503);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.mContext);
      ((FrameLayout)localObject1).setId(2131363426);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131367330);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramwlz);
      ((FrameLayout)localObject1).setOnLongClickListener(paramwlz);
      paramwlz = new MarketFaceView(this.mContext);
      ((FrameLayout)localObject1).addView(paramwlz, -2, -2);
      localObject4 = new ImageView(this.mContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.mContext);
      ((ImageView)localObject5).setId(2131382066);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363426);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363426);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.mContext);
      ((BreathAnimationLayout)localObject6).setId(2131372325);
      localPttAudioPlayView = new PttAudioPlayView(this.mContext, 10);
      localPttAudioPlayView.setThemeColor(this.mContext.getResources().getColorStateList(2131167322).getDefaultColor());
      localPttAudioPlayView.setId(2131372327);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838309);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = wja.dp2px(5.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = wja.dp2px(25.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = wja.dp2px(25.0F, this.mContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.mContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = wja.dp2px(5.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = wja.dp2px(20.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = wja.dp2px(20.0F, this.mContext.getResources());
      ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((ImageView)localObject7).setImageDrawable((Drawable)this.mContext.getResources().getDrawable(2130839649));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.mContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.mContext.getResources().getColorStateList(2131167322).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131372328);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131372327);
      ((RelativeLayout.LayoutParams)localObject9).width = wja.dp2px(39.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = wja.dp2px(45.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = aqnm.dip2px(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = aqnm.dip2px(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.mContext);
      ((RelativeLayout)localObject9).setId(2131372326);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.mContext);
      localTriangleView = new TriangleView(this.mContext);
      localObject10 = new RelativeLayout.LayoutParams(aqnm.dip2px(9.0F), aqnm.dip2px(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = aqnm.dip2px(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131373411);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(aqnm.dip2px(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, aqnm.dip2px(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131373411);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363426);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363426);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = aqnm.dip2px(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.mContext);
      ((ImageView)localObject10).setId(2131367331);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363426);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363426);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.mContext, this.app, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131366152);
      localObject12 = new RelativeLayout.LayoutParams(wja.dp2px(50.0F, this.mContext.getResources()), wja.dp2px(50.0F, this.mContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363426);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363426);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -wja.dp2px(6.5F, this.mContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.mContext);
      ((ImageView)localObject12).setId(2131371046);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363426);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363426);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = wja.dp2px(10.0F, this.mContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.mContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = wja.dp2px(8.0F, this.mContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131371151);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130845675));
        ((TextView)localObject13).setPadding(wja.dp2px(9.0F, this.mContext.getResources()), wja.dp2px(4.0F, this.mContext.getResources()), wja.dp2px(9.0F, this.mContext.getResources()), wja.dp2px(4.0F, this.mContext.getResources()));
        parame.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        parame.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.mContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364530);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.mContext.getResources().getDrawable(2130839651));
          int i = wja.dp2px(16.0F, this.mContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localb.image = paramwlz;
          localb.sS = ((ImageView)localObject4);
          localb.te = ((ImageView)localObject5);
          localb.sL = paramView;
          localb.sM = ((ImageView)localObject10);
          localb.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localb.tf = ((ImageView)localObject12);
          localb.bc = ((FrameLayout)localObject1);
          localb.progressBar = ((ProgressBar)localObject2);
          localb.Jn = ((TextView)localObject13);
          localb.jdField_b_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localb.hE = ((RelativeLayout)localObject9);
          localb.hF = localRelativeLayout;
          localb.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = localTriangleView;
          localb.tg = ((ImageView)localObject7);
          if (!d(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localb, paramChatMessage.uniseq);
          localb.Jn.setVisibility(8);
          localb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.enableTalkBack) && (a(paramChatMessage, localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc != null)) {
            localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setContentDescription(acfp.m(2131708046));
          }
          new QueryTask(new xjr(this, localb), new xjs(this, localb, paramBaseChatItemLayout, paramChatMessage, l)).bq(paramBaseChatItemLayout.mMarkFaceMessage);
          return parame;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localb.c != null) && (localb.c.ajH()) && (localb.te != null) && ((localb.te.getDrawable() instanceof AnimationDrawable))) {
        localb.te.setImageResource(2130848001);
      }
      parame = paramView;
      if (AppSetting.enableTalkBack)
      {
        localb.bc.setContentDescription("");
        parame = paramView;
      }
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new b();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_b_of_type_Afpu == null) || (jdField_b_of_type_Afpu.e == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131365686) || (paramInt == 2131362240) || (paramInt == 2131367539) || (paramInt == 2131367229))
    {
      a(paramInt, paramChatMessage);
      return;
    }
    if (paramInt == 2131372073)
    {
      super.m(paramChatMessage);
      return;
    }
    if (paramInt == 2131372030)
    {
      super.j(paramChatMessage);
      return;
    }
    if (paramInt == 2131377998)
    {
      B(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    ((ajdg)this.app.getManager(14)).a(jdField_b_of_type_Afpu.e.epId, new xjq(this, paramInt, paramChatMessage));
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, ankt.dip2px(10.0F), 0);
  }
  
  void a(b paramb, URLDrawable paramURLDrawable, String paramString)
  {
    paramb.te.setVisibility(8);
    paramb.jdField_b_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramb.sS.setVisibility(8);
    paramb.tf.setVisibility(8);
    paramb.bha = false;
    int i = paramURLDrawable.getStatus();
    if (paramURLDrawable.getHeader("2g_use_gif") != null) {
      i = 1;
    }
    for (;;)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
          str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
        }
      }
      if ("aio_preview".equals(str)) {
        if (paramb.c.ajH()) {
          if (paramb.c.isNewSoundType()) {
            paramb.jdField_b_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramb.te.setImageResource(2130848001);
          paramb.te.setVisibility(0);
          return;
        } while ((i != 1) || (paramb.c.imageType != 3));
        paramb.sS.setImageResource(2130838098);
        paramb.sS.setVisibility(0);
        paramb.bha = true;
        return;
      }
      if (d(paramb.mMessage))
      {
        if (paramb.c.isNewSoundType())
        {
          paramb.jdField_b_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramb.te.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.mContext.getResources().getDrawable(2130772334);
        paramb.te.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramb.c.isNewSoundType())
      {
        paramb.jdField_b_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramb.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramb.te.setImageResource(2130848001);
      paramb.te.setVisibility(0);
      return;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt)
  {
    arhz localarhz = c();
    if (localarhz != null)
    {
      localarhz.setMessage(this.mContext.getString(2131693099));
      localarhz.show();
    }
    a(this.app, o.frienduin, "ep_mall", "Clk_collect", 0);
    if ((jdField_b_of_type_Afpu != null) && (jdField_b_of_type_Afpu.e != null)) {
      afnu.c(this.app, 1, null, jdField_b_of_type_Afpu.e.eId);
    }
    anot.a(this.app, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", paramString, paramInt + "", "");
    QQAppInterface localQQAppInterface;
    if ((jdField_b_of_type_Afpu != null) && (jdField_b_of_type_Afpu.isNewSoundType()))
    {
      localQQAppInterface = this.app;
      paramInt = this.sessionInfo.cZ;
      if (jdField_b_of_type_Afpu.e == null) {
        break label268;
      }
    }
    label268:
    for (paramString = jdField_b_of_type_Afpu.e.epId;; paramString = "")
    {
      ajdg.e(localQQAppInterface, "0X800A939", paramInt, paramString);
      if ((paramEmoticonPackage == null) || (paramEmoticonPackage.name == null) || ((paramEmoticonPackage.mobileFeetype == 0) && (paramEmoticonPackage.downloadCount == 0))) {
        break label299;
      }
      paramInt = this.app.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((i - paramInt <= 86400) && (i >= paramInt)) {
        break;
      }
      De(6);
      return;
    }
    a(6, this.mContext, this.app, paramEmoticonPackage, jdField_b_of_type_Afpu, this.sessionInfo, localarhz);
    return;
    label299:
    De(6);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt1, int paramInt2)
  {
    arhz localarhz = c();
    if (paramInt2 == 2131367539)
    {
      anot.a(this.app, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", paramString, paramInt1 + "", "");
      if ((2 == jdField_b_of_type_Afpu.e.jobType) && (!this.jdField_b_of_type_Afke.ajt()))
      {
        ChatActivityUtils.h(this.mContext, 2131690227, 0);
        return;
      }
      bTw = 1;
      a(this.app, o.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      paramString = this.mContext.getString(2131693102);
    }
    for (paramInt1 = 7;; paramInt1 = 107)
    {
      if (localarhz != null)
      {
        localarhz.setMessage(paramString);
        localarhz.show();
      }
      if (paramEmoticonPackage != null) {
        break;
      }
      De(paramInt1);
      return;
      anot.a(this.app, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
      if ((this.sessionInfo.cZ == 1) && (((apsw)this.app.getManager(48)).a(this.sessionInfo.aTl, true).cSk))
      {
        ChatActivityUtils.h(this.mContext, 2131699615, 0);
        return;
      }
      paramString = this.mContext.getString(2131693101);
      anot.a(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_b_of_type_Afpu.e.epId, "", "");
    }
    a(paramInt1, this.mContext, this.app, paramEmoticonPackage, jdField_b_of_type_Afpu, this.sessionInfo, localarhz);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, afpu paramafpu)
  {
    if ((paramMessageForMarketFace == null) || (paramafpu == null) || (paramafpu.e == null) || (paramafpu.e.epId == null)) {
      return;
    }
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.setMainTitle(this.mContext.getString(2131693097));
    localausj.addButton(this.mContext.getResources().getString(2131693096), 1);
    localausj.addButton(this.mContext.getResources().getString(2131693098), 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new xjn(this, paramafpu, localausj, paramMessageForMarketFace));
    localausj.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (b)wja.a(paramView);
      if ((paramXListView != null) && (paramXListView.c != null) && (paramXListView.c.ajH()) && (paramXListView.c.isNewSoundType()) && (d(paramChatMessage)))
      {
        QLog.i("MarketFaceItemBuilder", 2, "AudioPlayer onPlayProgress progress_ratio = " + paramFloat);
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
        if ((paramChatMessage instanceof MessageForMarketFace)) {
          ((MessageForMarketFace)paramChatMessage).playProgress = paramFloat;
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = (b)wja.a(paramView);
      if (!paramXListView.c.isNewSoundType()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.c.a("fromAIO", false);
      paramXListView.image.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.te.setImageResource(2130848001);
    }
  }
  
  public boolean a(BaseBubbleBuilder.e parame)
  {
    return parame instanceof b;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (b)wja.a(paramView);
    if ((paramXListView == null) || (paramXListView.c == null) || (paramXListView.c.e == null)) {
      return false;
    }
    if (paramXListView.c.ajH())
    {
      paramView = afnu.bEr.replace("[epId]", paramXListView.c.e.epId).replace("[eId]", paramXListView.c.e.eId);
      if (!aqhq.fileExistsAndNotEmpty(paramView))
      {
        if (this.bo.contains(Long.valueOf(paramChatMessage.uniseq))) {
          return false;
        }
        this.bo.add(Long.valueOf(paramChatMessage.uniseq));
        a(paramXListView, paramChatMessage.uniseq);
        ThreadManager.getFileThreadHandler().post(new MarketFaceItemBuilder.7(this, paramXListView, paramChatMessage));
        return false;
      }
      if (paramAudioPlayerBase.play(paramView))
      {
        paramView = paramXListView.c.a("fromAIO", true);
        paramXListView.image.setImageDrawable(paramView);
        afpu.o(paramView);
        if (paramXListView.c.isNewSoundType()) {
          if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
        }
        for (;;)
        {
          return true;
          paramView = (AnimationDrawable)this.mContext.getResources().getDrawable(2130772334);
          paramXListView.te.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
    return false;
  }
  
  public aqob[] a(View paramView)
  {
    paramView = (b)wja.a(paramView);
    aqoa localaqoa = new aqoa();
    o = paramView.mMessage;
    if (ApolloUtil.V(o)) {
      return localaqoa.a();
    }
    if ((o instanceof MessageForMarketFace))
    {
      MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)o;
      if ((localMessageForMarketFace.mMarkFaceMessage == null) || (localMessageForMarketFace.mMarkFaceMessage.stickerInfo == null)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (paramView.c.e.jobType != 1)
        {
          jdField_b_of_type_Afpu = paramView.c;
          if (wja.eU(1) == 1) {
            localaqoa.Z(2131362240, this.mContext.getString(2131694742), 2130839084);
          }
          localaqoa.Z(2131367539, this.mContext.getString(2131721067), 2130839086);
          localaqoa.Z(2131377998, this.mContext.getString(2131719492), 2130840517);
          a(o, localaqoa);
          if ((paramView.c.e.jobType != 2) && (paramView.c.e.jobType != 4)) {
            localaqoa.Z(2131367229, this.mContext.getString(2131694751), 2130839065);
          }
          a(this.app, o.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.mMessage.extraflag != 32768) && (!this.app.a().aR(paramView.mMessage))) {
          a(localaqoa, this.sessionInfo.cZ, paramView.mMessage);
        }
        a(localaqoa, paramView.mMessage);
        super.a(localaqoa, this.mContext, o);
        if (paramView.c.e.jobType != 1) {
          b(o, localaqoa);
        }
        super.c(localaqoa, this.mContext);
        super.e(localaqoa, this.mContext);
      }
      for (;;)
      {
        return localaqoa.a();
        jdField_b_of_type_Afpu = paramView.c;
        ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
      }
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!aqiu.ms(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((ajdg)this.app.getManager(14)).a(paramChatMessage.mMarkFaceMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = paramChatMessage.e;
          if ((paramChatMessage != null) && (paramChatMessage.name != null)) {
            localStringBuilder.append(paramChatMessage.name);
          }
        }
      }
      return localStringBuilder.toString();
      label103:
      localStringBuilder.append("发来表情");
    }
  }
  
  void b(b paramb, URLDrawable paramURLDrawable)
  {
    a(paramb, paramURLDrawable, "");
  }
  
  protected void cdO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    Object localObject = ((FragmentActivity)this.mContext).getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).a();
      if (localObject != null) {
        ((BaseChatPie)localObject).getUIHandler().obtainMessage(79, null).sendToTarget();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] curPie is null.");
      return;
    }
    QLog.d("MarketFaceItemBuilder", 2, "[Doutu] chatFragment is null.");
  }
  
  public void destroy()
  {
    afkd.a().b(this.jdField_b_of_type_Afkn);
    afkd.a().b(this.a);
    Iterator localIterator = this.bp.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).destory();
    }
    this.bp.clear();
    this.bo.clear();
    this.bp = null;
  }
  
  public boolean e(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void ei(View paramView)
  {
    paramView = (b)wja.a(paramView);
    String str1;
    String str2;
    if (paramView.mMessage.isSendFromLocal())
    {
      str1 = this.mContext.getString(2131690230);
      str2 = this.mContext.getString(2131690231);
      if ((paramView.mMessage.sendFailCode == 41) && (paramView.c != null) && (paramView.c.e != null)) {
        a((MessageForMarketFace)paramView.mMessage, paramView.c);
      }
    }
    do
    {
      return;
      aqha.a(this.mContext, 230, str1, str2, new xjv(this, paramView), new xjw(this)).show();
      return;
      paramView = paramView.image.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void fl(View paramView)
  {
    wja.bcO = true;
    if (super.Rk()) {
      return;
    }
    if (paramView.getId() == 2131363426)
    {
      fq(paramView);
      return;
    }
    if (paramView.getId() == 2131382066) {
      fn(paramView);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if ((paramView.getId() == 2131372327) || (paramView.getId() == 2131372328)) {
        fp(paramView);
      } else if ((paramView.getId() == 2131367331) || (paramView.getId() == 2131367330)) {
        fm(paramView);
      } else if (paramView.getId() == 2131366152) {
        cdO();
      } else if (paramView.getId() == 2131371046) {
        fo(paramView);
      }
    }
  }
  
  protected void fm(View paramView)
  {
    paramView = (b)wja.a(paramView);
    arhz localarhz = c();
    if (localarhz != null)
    {
      localarhz.setMessage(this.mContext.getString(2131693101));
      localarhz.show();
    }
    ((ajdg)this.app.getManager(14)).a(paramView.c.e.epId, new xjm(this, paramView, localarhz));
  }
  
  protected void fn(View paramView)
  {
    paramView = (b)wja.a(paramView);
    if ((paramView.c != null) && (paramView.c.ajH()))
    {
      if (d(paramView.mMessage)) {
        MediaPlayerManager.a(this.app).stop(false);
      }
    }
    else {
      return;
    }
    if (this.app.bF())
    {
      QQToast.a(this.app.getApp(), 2131697385, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    MediaPlayerManager.a(this.app).k(paramView.mMessage);
  }
  
  public void onClick(View paramView)
  {
    fl(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  class MarketFaceView
    extends URLImageView
  {
    public MarketFaceView(Context paramContext)
    {
      super();
    }
    
    private void f(MarketFaceItemBuilder.b paramb)
    {
      if ((!afnu.isWifiOrG3OrG4()) || (2 != paramb.c.e.jobType) || (MarketFaceItemBuilder.this.b.ma(paramb.c.e.epId)) || (!aiyr.apU()) || (afnu.ajD()))
      {
        float f = MarketFaceItemBuilder.this.b.e(paramb.c.e.epId);
        if ((f < 0.0F) || (1.0F == f))
        {
          paramb.progressBar.setVisibility(8);
          paramb.a.setProgressVisable(false);
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
          }
        }
      }
    }
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      super.onLoadFialed(paramURLDrawable, paramThrowable);
      paramThrowable = (MarketFaceItemBuilder.b)wja.a(this);
      paramThrowable.progressBar.setVisibility(8);
      MarketFaceItemBuilder.this.b(paramThrowable, paramURLDrawable);
      if (AppSetting.enableTalkBack) {
        paramThrowable.bc.setContentDescription(acfp.m(2131708039));
      }
    }
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      MarketFaceItemBuilder.b localb = (MarketFaceItemBuilder.b)wja.a(this);
      super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      super.setImageDrawable(paramURLDrawable);
      if (localb == null)
      {
        QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
        return;
      }
      if (localb.c == null)
      {
        paramURLDrawable = localb.mMessage;
        if (!(paramURLDrawable instanceof MessageForMarketFace)) {
          break label434;
        }
        paramURLDrawable = ((MessageForMarketFace)paramURLDrawable).mMarkFaceMessage;
        if (paramURLDrawable == null) {
          break label434;
        }
      }
      label413:
      label432:
      label434:
      for (int i = paramURLDrawable.dwTabID;; i = -1)
      {
        QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  emoticonInfo == null epId = " + i);
        return;
        f(localb);
        MarketFaceItemBuilder.this.b(localb, paramURLDrawable);
        if ((2 == localb.c.e.jobType) && (aiyr.apU()) && (MarketFaceItemBuilder.this.b.ma(localb.c.e.epId)))
        {
          if (aixo.dr(localb.c.e.magicValue) == 1) {
            localb.tf.setVisibility(8);
          }
        }
        else
        {
          if ((4 == localb.c.e.jobType) && (MarketFaceItemBuilder.this.b.ajs()) && (MarketFaceItemBuilder.this.b.c(localb.c.e.epId, true, true)) && (!MarketFaceItemBuilder.this.bdn))
          {
            localb.tf.setImageResource(2130838101);
            localb.tf.setVisibility(0);
          }
          if ((MarketFaceItemBuilder.IV != 0L) && (MarketFaceItemBuilder.IV == localb.mMessage.uniseq) && (localb.c.ajH()))
          {
            if (!MarketFaceItemBuilder.this.app.bF()) {
              break label413;
            }
            QQToast.a(MarketFaceItemBuilder.this.app.getApp(), 2131697385, 0).show(MarketFaceItemBuilder.this.mContext.getResources().getDimensionPixelSize(2131299627));
          }
        }
        for (;;)
        {
          if (!AppSetting.enableTalkBack) {
            break label432;
          }
          localb.bc.setContentDescription("");
          return;
          if (MarketFaceItemBuilder.this.bdn) {
            break;
          }
          localb.tf.setImageResource(2130838101);
          localb.tf.setVisibility(0);
          break;
          MediaPlayerManager.a(MarketFaceItemBuilder.this.app).k(localb.mMessage);
        }
        break;
      }
    }
  }
  
  public static class a
    extends afko
  {
    private QQAppInterface app;
    private afpu c;
    private Context context;
    private int opType;
    private arhz progressDialog;
    private SessionInfo sessionInfo;
    
    public void a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, afpu paramafpu, SessionInfo paramSessionInfo, arhz paramarhz)
    {
      this.opType = paramInt;
      this.app = paramQQAppInterface;
      this.context = paramContext;
      this.c = paramafpu;
      this.sessionInfo = paramSessionInfo;
      this.progressDialog = paramarhz;
    }
    
    public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "onJsonComplete:" + paramEmoticonPackage.epId);
      }
      if (paramInt == 0)
      {
        if (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.c.e.epId)) {
          return;
        }
        this.app.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
        MarketFaceItemBuilder.a(this.opType, this.context, this.app, paramEmoticonPackage, this.c, this.sessionInfo, this.progressDialog);
        return;
      }
      MarketFaceItemBuilder.a(this.opType + 1000, this.context, this.app, paramEmoticonPackage, this.c, this.sessionInfo, this.progressDialog);
    }
  }
  
  public static class b
    extends BaseBubbleBuilder.e
  {
    public TextView Jn;
    public PttAudioPlayView a;
    public PttAudioWaveView a;
    public TriangleView a;
    public DuiButtonImageView a;
    public BreathAnimationLayout b;
    public EmoticonPackage b;
    public FrameLayout bc;
    public boolean bgZ;
    public boolean bha;
    public afpu c;
    public RelativeLayout hE;
    public RelativeLayout hF;
    public ImageView image;
    public ProgressBar progressBar;
    public int rscType = -1;
    public ImageView sL;
    public ImageView sM;
    public ImageView sS;
    public long tag;
    public ImageView te;
    public ImageView tf;
    ImageView tg;
    
    public void destory()
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.destory();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.destory();
      }
      if ((this.tg != null) && ((this.tg.getDrawable() instanceof Animatable))) {
        ((Animatable)this.tg.getDrawable()).stop();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder
 * JD-Core Version:    0.7.0.1
 */